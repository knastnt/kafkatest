package ru.knastnt.kafkatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;


@SpringBootApplication
public class KafkatestApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkatestApplication.class, args);
    }

    @Component
    public static class Runner implements CommandLineRunner{
        @Autowired
        //it's ok. https://stackoverflow.com/questions/55280173/the-correct-way-for-creation-of-kafkatemplate-in-spring-boot
        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        private KafkaTemplate<String, String> kafkaTemplate;

        @Override
        public void run(String... args) throws Exception {
            Thread thread = new Thread(() -> {
                try {
                    while (true) {
                        sleep(3000);
                        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("msg", "currentTime", "сообщение: " + (new SimpleDateFormat("dd MM yyyy HH-mm-ss")).format(new Date()));
                        future.addCallback(System.out::println, System.err::println);
                    }
                }catch (InterruptedException e){
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            });
            thread.setDaemon(true);
            thread.start();
        }
    }
}
