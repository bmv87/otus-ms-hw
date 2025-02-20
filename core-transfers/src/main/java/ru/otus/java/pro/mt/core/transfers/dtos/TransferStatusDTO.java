package ru.otus.java.pro.mt.core.transfers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class TransferStatusDTO {

    private String transferId;
    private String status;
}
