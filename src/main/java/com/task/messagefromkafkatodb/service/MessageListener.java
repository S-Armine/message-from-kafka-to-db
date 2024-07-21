package com.task.messagefromkafkatodb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MessageListener {

    @Autowired
    private MessageService messageService;

    @KafkaListener(topics = "messageTopic", groupId = "groupId")
    public void consume(String message) {
        try {
            JsonNode node = JsonMapper.parse(message);
            System.out.println("MESSAGE RECEIVED: " + message);
            messageService.addMessage(node);
        } catch (JsonProcessingException e) {
            Logger.getAnonymousLogger().severe("Error while parsing string to json.");;
        }
    }
}
