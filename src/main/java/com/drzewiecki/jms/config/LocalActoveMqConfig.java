package com.drzewiecki.jms.config;

import jakarta.jms.Destination;
import jakarta.jms.Queue;
import lombok.Getter;
import lombok.Setter;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Setter
@Getter
@Import(ActiveMQAutoConfiguration.class)
public class LocalActoveMqConfig {

    @Bean
    public Destination queue(@Value("${queues.incoming.topic1") String queue) {
        return new ActiveMQQueue(queue);
    }

}
