package com.suvam.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic" , groupId = "my-new-group")
    public void listen1(String message){
        System.out.println("Received Message in 1st consumer: "+ message);
    }

    @KafkaListener(topics = "my-topic" , groupId = "my-new-group-1")
    public void listen2(String message){
        System.out.println("Received Message in 2nd consumer: "+ message);
    }

    @KafkaListener(topics = "my-topic-rider" , groupId = "my-new-group-rider")
    public void listenRiderLocation(RiderLocation location){
        System.out.println("Received location: "+ location.getRiderId()
        +" : "+ location.getLatitude()
        +" : "+location.getLongitude());
    }
}
