package ru.otus.java.pro.mt.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.retrytopic.SameIntervalTopicReuseStrategy;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
@Slf4j
public class TransferConsumerServiceImpl {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @RetryableTopic(
            backoff = @Backoff(value = 6000),
            attempts = "4",
            autoCreateTopics = "true",
            retryTopicSuffix = "-retry",
            dltTopicSuffix = "-dlt",
            sameIntervalTopicReuseStrategy = SameIntervalTopicReuseStrategy.SINGLE_TOPIC,
            exclude = {NullPointerException.class}
    )
    @KafkaListener(topics = "${transfers.topic}")
    public void consume(ConsumerRecord<String, String> studentRecord, MessageHeaders headers) {
        log.info("### -> Header is acquired: {}", headers);
        Acknowledgment ack = headers.get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        log.info("#### -> Key: {}", studentRecord.key());
        log.info(String.format("#### -> Consumed a message -> %s", studentRecord.value()));
        System.out.println("==================================================");
        System.out.printf("По переводу %s клиенту отправлена нотификация -> %s \n", studentRecord.key(), studentRecord.value());
        System.out.println("==================================================");
        if (Objects.nonNull(ack)) ack.acknowledge();
    }

    @DltHandler
    public void dlt(Objects data, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.error("Event from topic {}  is dead lettered - event:{}", topic, data);
    }
}
