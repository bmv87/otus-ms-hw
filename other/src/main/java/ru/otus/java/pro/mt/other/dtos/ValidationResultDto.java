package ru.otus.java.pro.mt.other.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Schema(description = "Результат проверки по другим параметрам")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationResultDto {
    @Schema(
            description = "Проверка пройдена",
            example = "true",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private boolean valid;
}
