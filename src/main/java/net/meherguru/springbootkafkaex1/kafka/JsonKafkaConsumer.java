package net.meherguru.springbootkafkaex1.kafka;

import net.meherguru.springbootkafkaex1.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static  final  Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(User user){

        LOGGER.info(String.format("Json message recieved -> %s ", user.toString()));

    }
}
