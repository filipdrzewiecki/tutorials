package com.drzewiecki.kafka.service;

import com.drzewiecki.kafka.controller.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publish(Message message) {
        kafkaTemplate.send("topic1", message.data());
    }
}