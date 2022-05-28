package com.mytests.spring.jpa.dateFunctionsInQueries.model;

/**
 * *
 * <p>Created by irina on 28.05.2022.</p>
 * <p>Project: spring-jpa-dates</p>
 * *
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.time.Instant;

@Entity 
public class Message {
    @Id
    private Long id;
    
    private Instant sent;
    private Instant delivered;
    private String text;
    private String from;
    private String recipient;
    private boolean ok;

    public Message(Long id, Instant sent, Instant delivered, String text, String from, String recipient, boolean ok) {
        this.id = id;
        this.sent = sent;
        this.delivered = delivered;
        this.text = text;
        this.from = from;
        this.recipient = recipient;
        this.ok = ok;
    }

    public Instant getSent() {
        return sent;
    }

    public void setSent(Instant sent) {
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

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
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
                ", ok=" + ok +
                ' ';
    }
}
