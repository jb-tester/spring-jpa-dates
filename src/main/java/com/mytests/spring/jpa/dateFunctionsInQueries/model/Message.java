package com.mytests.spring.jpa.dateFunctionsInQueries.model;

/**
 * *
 * <p>Created by irina on 28.05.2022.</p>
 * <p>Project: spring-jpa-dates</p>
 * *
 */

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    private Long id;
    
    private java.time.OffsetDateTime sent;
    private Instant delivered;
    @Column(name = "message")
    private String text;
    @Column(name = "author")
    private String from;
    private String recipient;
    @Column(name = "ok")
    private boolean status;

    @Transient
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Message(Long id, java.time.OffsetDateTime sent, Instant delivered, String text, String from, String recipient, boolean status) {
        this.id = id;
        this.sent = sent;
        this.delivered = delivered;
        this.text = text;
        this.from = from;
        this.recipient = recipient;
        this.status = status;
    }

    public Message() {

    }

    public java.time.OffsetDateTime getSent() {
        return sent;
    }

    public void setSent(java.time.OffsetDateTime sent) {
        this.sent = sent;
    }

    public Instant getDelivered() {
        return delivered;
    }

    public void setDelivered(Instant delivered) {
        this.delivered = delivered;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean ok) {
        this.status = ok;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Message: " +
                "id=" + id +
                ", sent=" + sent +
                ", delivered=" + delivered +
                ", text='" + text + '\'' +
                ", from='" + from + '\'' +
                ", recipient='" + recipient + '\'' +
                ", ok=" + status +
                ' ';
    }
}
