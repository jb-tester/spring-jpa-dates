package com.mytests.spring.jpa.dateFunctionsInQueries;

import com.mytests.spring.jpa.dateFunctionsInQueries.services.DatesAndNumbersDisplayService;
import com.mytests.spring.jpa.dateFunctionsInQueries.services.FooBarService;
import com.mytests.spring.jpa.dateFunctionsInQueries.services.MessageService;
import com.mytests.spring.jpa.dateFunctionsInQueries.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaDatesApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private FooBarService fooBarService;
    @Autowired
    private DatesAndNumbersDisplayService datesAndNumbers;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaDatesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // orderService.init();
        //orderService.displayResults();
        // messageService.init();
        //messageService.displayResults();

        //fooBarService.displayResults();

        datesAndNumbers.displayQueriesUsage();
    }
}
