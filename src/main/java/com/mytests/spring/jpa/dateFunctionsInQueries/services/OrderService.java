package com.mytests.spring.jpa.dateFunctionsInQueries.services;

import com.mytests.spring.jpa.dateFunctionsInQueries.model.Order;
import com.mytests.spring.jpa.dateFunctionsInQueries.model.OrderIdAndAddress;
import com.mytests.spring.jpa.dateFunctionsInQueries.model.State;
import com.mytests.spring.jpa.dateFunctionsInQueries.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * *
 * <p>Created by irina on 4/14/2022.</p>
 * <p>Project: spring-jpa-dates</p>
 * *
 */
@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;

    public void init(){

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(new Date(2022-1900,4,2),false,3000,"U Zatisi 1", new Time(11,11,11), State.delivered));
        orders.add(new Order(new Date(2022-1900,4,5),false,1000,"U Zatisi 1", new Time(17,17,17), State.delivered));
        orders.add(new Order(new Date(2022-1900,4,10),false,1500,"U Zatisi 1", new Time(17,17,17), State.delivered));
        orders.add(new Order(new Date(2022-1900,4,12),true,500,"U Zatisi 1", new Time(17,17,17), State.ready));
        orders.add(new Order(new Date(2022-1900,4,13),false,2500,"U Zatisi 1", new Time(17,17,17), State.accepted));
        orders.add(new Order(new Date(2022-1900,4,14),true,4500,"U Zatisi 1", new Time(17,17,17), State.delivered));
        orders.add(new Order(new Date(2022-1900,4,14),true,4500,"U Zatisi 1", new Time(20,17,17), State.placed));
        orderRepository.saveAll(orders);
    }

    public OrderIdAndAddress getOrderIdAndAddress(){
        return orderRepository.getOrdersByDate(new Date(2022-1900,4,14)).get(0);
    }

    public List<Order> checkNotProcessed(){
        return orderRepository.processUrgently(new Double(1000000000));
    }

    public List<Order> checkLastYearOrders(){
        return orderRepository.lastYearOrders(new java.util.Date());
    }
    public void displayResults(){
        System.out.println("--- year(...) and month(...) test ---");
        System.out.println(getOrderIdAndAddress());
        System.out.println("--- current_timestamp() test --");
        for (Order order : checkNotProcessed()) {
            System.out.println(order);
        }
        System.out.println("--- expression with year(...) test ---");
        for (Order order : checkLastYearOrders()) {
            System.out.println(order);
        }
    }
}
