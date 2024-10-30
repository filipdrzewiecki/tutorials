package com.drzewiecki.jms.kafka.service;

import com.drzewiecki.jms.kafka.controller.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Profile("kafka")
@RequiredArgsConstructor
public class MessageService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publish(Message message) {
        kafkaTemplate.send("topic1", message.data());
    }
}
