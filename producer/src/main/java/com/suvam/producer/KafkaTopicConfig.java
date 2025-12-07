package com.suvam.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// creating topic programmatically
@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic createMyTopic(){
        return new NewTopic("my-new-topic2",3,(short)1);
    }
}
