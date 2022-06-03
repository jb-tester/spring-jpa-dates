package com.mytests.spring.jpa.dateFunctionsInQueries.services;

import com.mytests.spring.jpa.dateFunctionsInQueries.model.FooBar;
import com.mytests.spring.jpa.dateFunctionsInQueries.repos.FooBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * *
 * <p>Created by irina on 6/3/2022.</p>
 * <p>Project: spring-jpa-dates</p>
 * *
 */
@Service
public class FooBarService {


    @Autowired
    private FooBarRepository fooBarRepository;

    public void displayResults() {
        System.out.println("--- using '.' in entity name: --- ");
        for (FooBar foo : fooBarRepository.query("maria")) {
            System.out.println(foo);
        }}
}
