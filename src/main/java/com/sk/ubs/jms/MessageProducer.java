/**
 *
 * MessageProducer.java
 * com.sk.ubs.jms
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.jms;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcabi.aspects.Loggable;
import com.sk.ubs.model.Message;

@Component
public class MessageProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private ObjectMapper mapper;

    /**
     * Send message.
     *
     * @param message
     *            the message
     * @throws MessagingException
     *             the messaging exception
     * @throws JsonProcessingException
     *             the json processing exception
     */
    @Loggable
    public void sendMessage(final Message message) throws MessagingException, JsonProcessingException {
        jmsMessagingTemplate.convertAndSend(queue, mapper.writeValueAsString(message));
    }

}
