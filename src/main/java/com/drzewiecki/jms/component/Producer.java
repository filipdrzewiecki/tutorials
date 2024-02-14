package com.drzewiecki.jms.component;

import jakarta.jms.Destination;
import jakarta.jms.Queue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {

    private final JmsTemplate jmsTemplate;
    private final Destination incomingMessageQueue;

    public void sendMessage(String message){
            log.info("Attempting Send message to Topic: ");
            jmsTemplate.convertAndSend(incomingMessageQueue, message);
    }
}
