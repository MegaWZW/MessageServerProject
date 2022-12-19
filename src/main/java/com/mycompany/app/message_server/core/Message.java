package com.mycompany.app.message_server.core;

import java.util.Date;

public class Message {
    private Date dateAndTime;
    private String  sender;
    private String recipient;
    private String text;

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message(Date dateAndTime, String sender, String recipient, String text) {
        this.dateAndTime = dateAndTime;
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
    }
}
