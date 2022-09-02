package net.meherguru.springbootkafkaex1.kafka;

import net.meherguru.springbootkafkaex1.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {


    private final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info(String.format("the message is %s", message));

        log.info("Message sent -> {} ", message);
        kafkaTemplate.send("firstguru", message);
    }

    public void sentJsonMessage(User user){
        kafkaTemplate.send("User sent", user);
    }

}
