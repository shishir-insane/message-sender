/**
 *
 * Message.java
 * com.sk.ubs.model
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sk.ubs.util.MessageType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String sentTo;
    private String sentFrom;
    private String body;
    private Date sentAt;
    private MessageType type;

    /**
     * Instantiates a new message.
     */
    public Message() {
        sentAt = new Date();
        type = MessageType.EMAIL;
    }
}
