package com.drzewiecki.jms.component;

import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @JmsListener(destination = "@{queues.incoming.topic1}", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(Message message) {
        try {
            log.info("Received Message");
            //do additional processing
            log.info("Received Message: " + message);
        } catch (Exception e) {
            log.error("Received Exception : " + e);
        }
    }
}




