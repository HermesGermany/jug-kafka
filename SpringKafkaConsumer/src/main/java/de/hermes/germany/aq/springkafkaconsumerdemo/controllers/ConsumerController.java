package de.hermes.germany.aq.springkafkaconsumerdemo.controllers;

import de.hermes.germany.aq.springkafkaconsumerdemo.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @Value("${spring.kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @CrossOrigin
    @RequestMapping(value = "/messages", produces={ "application/json"})
    public List<Map<String, String>> getKafkaTopicMessages(){
        return consumerService.getAllMessages();
    }
}