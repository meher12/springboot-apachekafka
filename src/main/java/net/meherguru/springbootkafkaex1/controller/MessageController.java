package net.meherguru.springbootkafkaex1.controller;

import net.meherguru.springbootkafkaex1.dto.User;
import net.meherguru.springbootkafkaex1.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class MessageController {

    @Autowired
    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        this.kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

    @GetMapping("/jsonpublish")
    public ResponseEntity<String> jsonpublish(@RequestBody User user) {
        this.kafkaProducer.sendM(user);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
