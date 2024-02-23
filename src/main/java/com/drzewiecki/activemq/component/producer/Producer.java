package com.drzewiecki.activemq.component.producer;

import com.drzewiecki.activemq.component.Order;
import jakarta.jms.Destination;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {

    private final JmsTemplate jmsTemplate;
    private final Destination orderQueue;
    private final Destination everythingQueue;

    public void sendMessage(Object message) {
        log.info("Attempting Send message={}", message);
        jmsTemplate.convertAndSend(everythingQueue, message);
    }

    public void sendOrderMessage(Order message) {
        log.info("Attempting Send message={}", message);
        jmsTemplate.convertAndSend(orderQueue, message);
    }
}
