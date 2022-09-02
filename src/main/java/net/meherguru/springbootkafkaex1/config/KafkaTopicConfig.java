package net.meherguru.springbootkafkaex1.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic firstguruTopic(){
        return TopicBuilder.name("firstguru")
                .build();
    }

    @Bean
    public NewTopic jsonfirstguruTopic(){
        return TopicBuilder.name("firstguru_json")
                .build();
    }
}
