package com.drzewiecki.jms.activemq.component.consumer;

import com.drzewiecki.jms.activemq.component.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageConsumer {

    private final ObjectMapper objectMapper;

    public MessageConsumer() {
        this.objectMapper = new ObjectMapper();
    }

    @SneakyThrows
    @JmsListener(destination = "${queues.incoming.everything}", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(@Payload String message) {
        Order order = objectMapper.readValue(message, Order.class);
        log.info("Received Message: " + order);
    }
}
