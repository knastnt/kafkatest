package ru.knastnt.kafkatest;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
public class Listener {

    @KafkaListener(topics = "msg2")
    public void messageListener(@Payload UserDTO userDTO, @Headers MessageHeaders headers) {
        System.out.println(headers);
        System.out.println(userDTO);
    }

    @KafkaListener(topics = "msg3")
    public void messageListener(@Payload UserDTO.Address s, @Headers MessageHeaders headers) {
        System.out.println(headers);
        System.out.println(s);
    }
}
