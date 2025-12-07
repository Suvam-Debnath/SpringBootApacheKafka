package com.suvam.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaProducer {

    private final KafkaTemplate<String, RiderLocation> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // sending string message
//    @PostMapping("/send")
//    public String sendMessage(@RequestParam String message){
//        kafkaTemplate.send("my-topic",message);
//        return "Message sent: "+message;
//    }

    // sending Objects messages by Serializing and Deserializing
    @PostMapping("/send")
    public String sendMessage(@RequestParam String message){
        RiderLocation location = new RiderLocation("rider123",36.21,77.12);
        kafkaTemplate.send("my-topic-rider", location);
        return "Message sent: "+ location.getRiderId();
    }
}
