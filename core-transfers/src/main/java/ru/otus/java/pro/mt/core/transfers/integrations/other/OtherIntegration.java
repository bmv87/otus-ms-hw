package ru.otus.java.pro.mt.core.transfers.integrations.other;

import ru.otus.java.pro.mt.core.transfers.dtos.ValidationResultDto;

public interface OtherIntegration {

    ValidationResultDto checkOtherParams(String clientId);
}
