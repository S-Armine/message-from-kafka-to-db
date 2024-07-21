package com.task.messagefromkafkatodb.repository;

import com.task.messagefromkafkatodb.model.Message;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MessageRepository extends MongoRepository<Message, ObjectId> {

}
