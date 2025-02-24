package ru.otus.java.pro.mt.limits.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Schema(description = "Оставшийся лимит")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemainingLimitDto {
    @Schema(
            description = "Сумма",
            example = "100.00",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private BigDecimal remainingLimit;
}
