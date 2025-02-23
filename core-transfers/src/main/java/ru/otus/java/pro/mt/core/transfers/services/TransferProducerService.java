package ru.otus.java.pro.mt.core.transfers.services;

import ru.otus.java.pro.mt.core.transfers.dtos.TransferStatusDTO;
import ru.otus.java.pro.mt.core.transfers.entities.Transfer;

public interface TransferProducerService {
    boolean notify(TransferStatusDTO transfer);
}
