package ru.otus.java.pro.mt.core.transfers.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.otus.java.pro.mt.core.transfers.configs.properties.TransfersProperties;
import ru.otus.java.pro.mt.core.transfers.dtos.TransferStatusDTO;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferProducerServiceImpl implements TransferProducerService {
    private final KafkaTemplate<String, TransferStatusDTO> kafkaTemplate;
    private final TransfersProperties configProperties;

    @Override
    public boolean notify(TransferStatusDTO transfer) {
        try {
            var result = kafkaTemplate.send(configProperties.getTopic(), transfer.getTransferId(), transfer).get();
            log.info("Sent message=[{}] with offset=[{}]", transfer.toString(), result.getRecordMetadata().offset());
        } catch (Exception ex) {
            log.error("Transfer notification error", ex);
            return false;
        }

        return true;
    }
}
