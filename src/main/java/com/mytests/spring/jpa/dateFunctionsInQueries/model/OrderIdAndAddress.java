package com.mytests.spring.jpa.dateFunctionsInQueries.model;

/**
 * *
 * <p>Created by irina on 4/14/2022.</p>
 * <p>Project: spring-jpa-dates</p>
 * *
 */
public class OrderIdAndAddress {

    String address;
    int id;

    public OrderIdAndAddress(int id, String address) {
        this.address = address;
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "OrderIdAndAddress{" +
                "address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
