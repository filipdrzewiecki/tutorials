package com.drzewiecki.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaListeners {

    @KafkaListener(
            topics= {"topic1", "topic2"}
    )
    void basicListener(String data) {
        log.info("data received={}", data);

    }
}
