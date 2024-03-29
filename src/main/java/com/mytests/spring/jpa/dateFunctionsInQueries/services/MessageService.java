package com.mytests.spring.jpa.dateFunctionsInQueries.services;

import com.mytests.spring.jpa.dateFunctionsInQueries.model.Message;
import com.mytests.spring.jpa.dateFunctionsInQueries.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
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
        messages.add(new Message(0L, OffsetDateTime.now(), Instant.now(Clock.systemUTC()), "message1", "vasya","masha", true));
        messages.add(new Message(1L, OffsetDateTime.now(), Instant.now(Clock.systemUTC()), "message1", "masha","vasya", true));
        messages.add(new Message(2L, OffsetDateTime.now(), null, "message1", "vasya","masha", false));
      messageRepository.saveAll(messages);  
    }

    public void displayResults() {
        System.out.println("--- comparing timestamp to instant-type field: --- ");
        for (Message message : messageRepository.query1()) {
            System.out.println(message);
        }
        System.out.println("--- comparing timestamp to offsetDataType-type field: --- ");
        for (Message message : messageRepository.query11()) {
            System.out.println(message);
        }
        System.out.println("--- cast test: --- ");
        for (Message message : messageRepository.query2()) {
            System.out.println(message);
        }
        System.out.println("--- cast test2: --- ");
        for (Message message : messageRepository.query3(false)) {
            System.out.println(message);
        }
        System.out.println("--- cast test3: ---");
        for (Date rez : messageRepository.query4("vasya")) {
            System.out.println(rez);
        }
    }
}
