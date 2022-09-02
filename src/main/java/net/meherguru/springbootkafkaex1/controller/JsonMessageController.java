package net.meherguru.springbootkafkaex1.controller;

import net.meherguru.springbootkafkaex1.kafka.JsonKafkaProducer;
import net.meherguru.springbootkafkaex1.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/jsonpublish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.sentJsonMessage(user);
        return ResponseEntity.ok("Json message  sent to the topic");
    }
}
