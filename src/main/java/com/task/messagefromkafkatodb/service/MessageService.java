package com.task.messagefromkafkatodb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.task.messagefromkafkatodb.model.Message;
import com.task.messagefromkafkatodb.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void addMessage(JsonNode jsonNode) {
        try {
            Message message = JsonMapper.fromJson(jsonNode);
            messageRepository.save(message);
        } catch (JsonProcessingException e) {
            Logger.getAnonymousLogger().severe("Error while parsing json to message.");
        }
    }
}
