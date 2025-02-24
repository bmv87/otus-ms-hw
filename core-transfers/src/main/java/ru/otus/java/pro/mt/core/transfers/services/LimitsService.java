package ru.otus.java.pro.mt.core.transfers.services;

import java.math.BigDecimal;

public interface LimitsService {
    boolean isLimitEnough(String clientId, BigDecimal amount);
}
