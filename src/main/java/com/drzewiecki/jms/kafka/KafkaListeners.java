package com.drzewiecki.jms.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Profile("kafka")
@Component
public class KafkaListeners {

    @KafkaListener(
            topics= {"topic1", "topic2"}
    )
    void basicListener(String data) {
        log.info("data received={}", data);

    }
}
