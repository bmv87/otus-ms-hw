package ru.otus.java.pro.mt.core.transfers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationResultDto {
    private boolean valid;
}
