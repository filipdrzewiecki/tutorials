package com.drzewiecki.activemq.component.consumer;

import com.drzewiecki.activemq.component.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderConsumer {

    @JmsListener(destination = "${queues.incoming.orders}", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(@Payload Order order) {
            log.info("Received Order Message: " + order);
    }
}




