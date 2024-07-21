package com.task.messagefromkafkatodb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.messagefromkafkatodb.model.Message;

public class JsonMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode parse(String json) throws JsonProcessingException {
        return mapper.readTree(json);
    }

    public static Message fromJson(JsonNode node) throws JsonProcessingException {
        return mapper.treeToValue(node, Message.class);
    }
}
