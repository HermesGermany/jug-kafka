package de.hermes.germany.aq.springkafkaconsumerdemo.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsumerService {

    private final List<Map<String, String>> messages = new ArrayList<>();

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.group-id}")
    public void consume(String message){
        this.addMessage(message);
    }

    public List<Map<String, String>> getAllMessages() {
        return this.messages;
    }

    private void addMessage(String message) {
        String loweredMessages = message.toLowerCase();
        boolean exists = false;
        for (Map<String, String> entry : this.messages) {
            if(entry.containsValue(loweredMessages)) {
                exists = true;
                Integer oldValue = Integer.parseInt(entry.get("size"));
                Integer newValue = oldValue + 1;
                entry.put("size", newValue.toString());
            }
        }

        if(!exists) {
            Map<String, String> newEntry = new HashMap<>();
            newEntry.put("text", loweredMessages);
            newEntry.put("size", "2");
            this.messages.add(newEntry);
        }
    }
}
