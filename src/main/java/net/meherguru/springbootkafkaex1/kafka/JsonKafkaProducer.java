package net.meherguru.springbootkafkaex1.kafka;

import net.meherguru.springbootkafkaex1.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    private  KafkaTemplate<String, User> userKafkaTemplate;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    public JsonKafkaProducer(KafkaTemplate<String, User> jsonKafkaTemplate) {
        this.userKafkaTemplate = jsonKafkaTemplate;
    }

    public void sentJsonMessage(User data) {

        log.info(String.format("Meessage object sent %s", data.toString()));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();
        userKafkaTemplate.send(message);
    }
}
