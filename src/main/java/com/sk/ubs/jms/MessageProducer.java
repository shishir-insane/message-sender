package com.sk.ubs.jms;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk.ubs.model.Message;

@Component
public class MessageProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private ObjectMapper mapper;

    public void sendMessage(final Message message) throws MessagingException, JsonProcessingException {
        jmsMessagingTemplate.convertAndSend(queue, mapper.writeValueAsString(message));
    }

}
