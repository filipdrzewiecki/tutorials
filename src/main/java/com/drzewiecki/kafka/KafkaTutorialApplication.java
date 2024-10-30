package com.drzewiecki.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@SpringBootApplication
public class KafkaTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaTutorialApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> template) {
        return args -> {
            log.info("sending new message");
            template.send("fifi", "hi fifi fifi2");
        };
    }

}
