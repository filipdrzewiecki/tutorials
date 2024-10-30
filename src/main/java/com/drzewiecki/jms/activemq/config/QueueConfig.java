package com.drzewiecki.jms.activemq.config;

import jakarta.jms.Destination;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public Destination orderQueue(@Value("${queues.incoming.orders}") String queue) {
        return new ActiveMQQueue(queue);
    }

    @Bean
    public Destination everythingQueue(@Value("${queues.incoming.everything}") String queue) {
        return new ActiveMQQueue(queue);
    }
}
