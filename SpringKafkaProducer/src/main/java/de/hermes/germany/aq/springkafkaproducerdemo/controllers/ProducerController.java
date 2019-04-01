package de.hermes.germany.aq.springkafkaproducerdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {

    @Value("${spring.kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @CrossOrigin
    @PostMapping(value = "/produce")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.kafkaTemplate.send(topic, message);
    }
}