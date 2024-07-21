package com.task.messagefromkafkatodb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
public class Message {

    @Id
    private ObjectId id;
    private String message;

    public Message() {
    }

    public Message(ObjectId id, String message) {
        this.id = id;
        this.message = message;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ObjectId getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
