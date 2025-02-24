package ru.otus.java.pro.mt.other.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.java.pro.mt.other.dtos.ValidationResultDto;

@RestController
@RequestMapping("/api/v1/other")
@Tag(name = "Другие параметры клиента", description = "Методы проверки клиента")
public class OtherController {

    @Operation(summary = "Проверка на другие параметры клиента")
    @GetMapping("/check")
    public ValidationResultDto checkOther(
            @Parameter(description = "Идентификатор клиента", required = true, schema = @Schema(type = "string", maxLength = 10, example = "1234567890"))
            @RequestHeader(name = "client-id") String clientId
    ) {
        return new ValidationResultDto(true);
    }
}
