package com.mytests.spring.jpa.dateFunctionsInQueries.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * *
 * <p>Created by irina on 4/14/2022.</p>
 * <p>Project: spring-jpa-dates</p>
 * *
 */
@Entity
@Table(name = "orders")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "urgent")
    private boolean urgent;
    @Basic
    @Column(name = "sum")
    private Integer sum;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "created")
    private Time created;
    @Basic
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private State status;

    public Order(Date date, boolean urgent, Integer sum, String address, Time created, State status) {
        this.date = date;
        this.urgent = urgent;
        this.sum = sum;
        this.address = address;
        this.created = created;
        this.status = status;
    }

    public Order() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Time getCreated() {
        return created;
    }

    public void setCreated(Time created) {
        this.created = created;
    }

    public State getStatus() {
        return status;
    }

    public void setStatus(State status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", urgent=" + urgent +
                ", sum=" + sum +
                ", address='" + address + '\'' +
                ", created=" + created +
                ", status=" + status +
                '}';
    }
}
