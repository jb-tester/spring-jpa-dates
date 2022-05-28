package com.mytests.spring.jpa.dateFunctionsInQueries.services;

import com.mytests.spring.jpa.dateFunctionsInQueries.model.Message;
import com.mytests.spring.jpa.dateFunctionsInQueries.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * *
 * <p>Created by irina on 28.05.2022.</p>
 * <p>Project: spring-jpa-dates</p>
 * *
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void init(){
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(0L, Instant.now(), Instant.now(Clock.systemUTC()), "message1", "vasya","masha", true));
        messages.add(new Message(1L, Instant.now(), Instant.now(Clock.systemUTC()), "message1", "masha","vasya", true));
        messages.add(new Message(2L, Instant.now(), null, "message1", "vasya","masha", false));
      messageRepository.saveAll(messages);  
    }

    public void displayResults() {
        System.out.println("--- comparing timestamp to instant-type field: --- ");
        for (Message message : messageRepository.query1()) {
            System.out.println(message);
        }
        System.out.println("--- cast test: --- ");
        for (Message message : messageRepository.query2()) {
            System.out.println(message);
        }
    }
}
