package com.mytests.spring.jpa.dateFunctionsInQueries.services;

import com.mytests.spring.jpa.dateFunctionsInQueries.model.DatesAndNumbers;
import com.mytests.spring.jpa.dateFunctionsInQueries.repos.UsingEntityManager;
import org.springframework.stereotype.Service;


/**
 * *
 * <p>Created by irina on 12/13/2022.</p>
 * <p>Project: spring-jpa-dates</p>
 * *
 */
@Service
public class DatesAndNumbersDisplayService {

    private final DatesAndNumbersService service;
    private final UsingEntityManager usingEntityManager;

    public DatesAndNumbersDisplayService(DatesAndNumbersService service, UsingEntityManager usingEntityManager) {
        this.service = service;
        this.usingEntityManager = usingEntityManager;
    }

    public void displayQueriesUsage() {
        System.out.println("=======Using @Query() annotation:====");
        System.out.println("====== findAll()");
        for (DatesAndNumbers datesAndNumbers : service.listAll()) {
            System.out.println(datesAndNumbers);
        }

        System.out.println("====== firstDate = local date");
        for (DatesAndNumbers datesAndNumbers : service.qwe1()) {
            System.out.println(datesAndNumbers);
        }

        System.out.println("====== local datetime and local time");
        for (DatesAndNumbers datesAndNumbers : service.qwe2()) {
            System.out.println(datesAndNumbers);
        }

        System.out.println("====== extract");
        for (DatesAndNumbers datesAndNumbers : service.qwe3()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("====== ceiling()");
        for (DatesAndNumbers datesAndNumbers : service.qwe4()) {
            System.out.println(datesAndNumbers);
        }

        System.out.println("====== exp()");
        for (DatesAndNumbers datesAndNumbers : service.qwe5()) {
            System.out.println(datesAndNumbers);
        }


        System.out.println("====== floor()");
        for (DatesAndNumbers datesAndNumbers : service.qwe6()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("====== ln()");
        for (DatesAndNumbers datesAndNumbers : service.qwe7()) {
            System.out.println(datesAndNumbers);
        }


        System.out.println("====== power()");
        for (DatesAndNumbers datesAndNumbers : service.qwe8()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("====== round()");
        for (DatesAndNumbers datesAndNumbers : service.qwe9()) {
            System.out.println(datesAndNumbers);
        }

        System.out.println("====== sign()");
        for (DatesAndNumbers datesAndNumbers : service.qwe10()) {
            System.out.println(datesAndNumbers);
        }


        System.out.println("====== coalesce()");
        System.out.println(service.qwe11());

        System.out.println("====== numbered param test:");
        for (DatesAndNumbers datesAndNumbers : service.qwe12()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("====== current_timestamp() test:");
        for (DatesAndNumbers datesAndNumbers : service.qwe13()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("====== local_date() test:");
        for (DatesAndNumbers datesAndNumbers : service.qwe14()) {
            System.out.println(datesAndNumbers);
        }

        System.out.println("====== cast test:");
        System.out.println("=======");
        for (DatesAndNumbers datesAndNumbers : service.qwe15()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("=======");
        for (DatesAndNumbers datesAndNumbers : service.qwe16()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("=======");
        for (DatesAndNumbers datesAndNumbers : service.qwe17()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("=======");
        for (DatesAndNumbers datesAndNumbers : service.qwe18()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("======= logical expression test:");
        for (DatesAndNumbers datesAndNumbers : service.qwe19()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("======= SpEL expression test1:");
        for (DatesAndNumbers datesAndNumbers : service.qwe20()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("======= SpEL expression test2:");
        for (DatesAndNumbers datesAndNumbers : service.qwe21()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("======= entity FQN in query:");
        for (DatesAndNumbers datesAndNumbers : service.qwe22()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("======= date and time arithmetics test1:");
        for (DatesAndNumbers datesAndNumbers : service.qwe23()) {
            System.out.println(datesAndNumbers);
        }
        System.out.println("======= date and time arithmetics test2:");
        for (DatesAndNumbers datesAndNumbers : service.qwe24()) {
            System.out.println(datesAndNumbers);
        }

        System.out.println("======= date and time arithmetics test3:");
        for (DatesAndNumbers datesAndNumbers : service.qwe25()) {
            System.out.println(datesAndNumbers);
        }

       /* System.out.println("======= filter test:");
        //System.out.println(service.qwe22());
        System.out.println("=======Using EntityManager.createQuery():====");
        usingEntityManager.displayResults();*/
    }
}
