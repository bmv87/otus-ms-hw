package ru.otus.java.pro.mt.core.transfers.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.java.pro.mt.core.transfers.integrations.other.OtherIntegration;

@Service
@RequiredArgsConstructor
public class OtherServiceImpl implements OtherService {
    private final OtherIntegration otherIntegration;

    public boolean isValid(String clientId) {
        return otherIntegration.checkOtherParams(clientId).isValid();
    }
}
