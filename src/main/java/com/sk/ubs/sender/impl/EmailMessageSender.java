/**
 *
 * EmailMessageSender.java
 * com.sk.ubs.sender.impl
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.sender.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sk.ubs.model.Message;
import com.sk.ubs.sender.MessageSender;

@Component
public class EmailMessageSender implements MessageSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailMessageSender.class);

    /*
     * (non-Javadoc)
     *
     * @see
     * com.sk.ubs.sender.MessageSender#transmitMessage(com.sk.ubs.model.Message)
     */
    @Override
    public void transmitMessage(final Message message) {
        LOGGER.info("{} recieved at {}", message.getType().name(), message.getSentAt());
        LOGGER.info("Message Details: {}", message.toString());
    }
}
