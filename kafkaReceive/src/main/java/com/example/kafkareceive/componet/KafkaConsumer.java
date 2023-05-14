package com.example.kafkareceive.componet;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {


    @KafkaListener(id = "default", topics = "default")
    public void messageListener(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        log.info("kafka message:{}", record.value());
        ack.acknowledge();
    }

    @KafkaListener(id = "default1", topics = "default1")
    public void messageListener1(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        String s = record.value().toString();
        log.info("kafka message:{}", s);
        if (s.contains("123")) {
            throw new RuntimeException();
        } else {
            ack.acknowledge();
        }
    }

}
