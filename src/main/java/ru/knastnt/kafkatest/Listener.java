package ru.knastnt.kafkatest;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
public class Listener {
    @KafkaListener(topics = "msg")
    public void messageListener(String msg) {
        System.out.println(msg);
    }
}
