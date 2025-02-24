package ru.otus.java.pro.mt.limits.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.java.pro.mt.limits.dtos.RemainingLimitDto;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/limits")
@Tag(name = "Лимиты", description = "Методы работы с лимитами")
public class LimitsController {

    @Operation(summary = "Получение оставшегося лимита")
    @GetMapping("/check")
    public RemainingLimitDto checkLimit(
            @Parameter(description = "Идентификатор клиента", required = true, schema = @Schema(type = "string", maxLength = 10, example = "1234567890"))
            @RequestHeader(name = "client-id") String clientId
    ) {
        return new RemainingLimitDto(BigDecimal.valueOf(1000));
    }
}