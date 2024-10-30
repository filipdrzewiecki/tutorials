package com.drzewiecki.jms.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;


@Slf4j
@Profile("kafka")
@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic1() {
        log.info("creating new topic=topic1");
        return TopicBuilder.name("topic1").build();
    }

    @Bean
    public NewTopic topic2() {
        log.info("creating new topic=topic2");
        return TopicBuilder.name("topic2").build();
    }

    @Bean
    public NewTopic topic3() {
        log.info("creating new topic=topic3");
        return TopicBuilder.name("topic3").build();
    }
}
