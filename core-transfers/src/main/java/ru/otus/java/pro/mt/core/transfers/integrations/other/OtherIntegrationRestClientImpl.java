package ru.otus.java.pro.mt.core.transfers.integrations.other;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.otus.java.pro.mt.core.transfers.dtos.ValidationResultDto;
import ru.otus.java.pro.mt.core.transfers.exceptions_handling.BusinessLogicException;

@Component
@RequiredArgsConstructor
public class OtherIntegrationRestClientImpl implements OtherIntegration {
    private final RestClient otherClient;

    @Override
    public ValidationResultDto checkOtherParams(String clientId) {
        return otherClient
                .get()
                .uri("/check")
                .header("client-id", clientId)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.value() == HttpStatus.NOT_FOUND.value(), (request, response) -> {
                    throw new BusinessLogicException("CLIENT_NOT_EXIST", "Клиент не найден");
                })
                .body(ValidationResultDto.class);
    }
}
