/**
 *
 * MessageConsumer.java
 * com.sk.ubs.jms
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.jms;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcabi.aspects.Loggable;
import com.sk.ubs.model.Message;
import com.sk.ubs.repository.MessageRepository;
import com.sk.ubs.sender.MessageSender;
import com.sk.ubs.util.AppUtils;

@Component
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    private final MessageRepository messageRepository;

    @Autowired
    private MessageSender smsMessageSender;

    @Autowired
    private MessageSender emailMessageSender;

    @Autowired
    private ObjectMapper mapper;

    public MessageConsumer(final MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * Receive queue.
     *
     * @param messageString
     *            the message string
     */
    @JmsListener(destination = AppUtils.QUEUE_NAME)
    @Loggable
    public void receiveQueue(final String messageString) {
        if (StringUtils.isEmpty(messageString)) {
            return;
        }
        try {
            final Message message = mapper.readValue(messageString, Message.class);
            if (AppUtils.validateMessage(message)) {
                sendMessage(message);
                messageRepository.save(message);
            } else {
                LOGGER.error("Error occured while parsing message from queue.");
            }
        } catch (final IOException e) {
            LOGGER.error("Error occured while reading message from queue. {}", e);
        }
    }

    /**
     * Send message.
     *
     * @param message
     *            the message
     */
    private void sendMessage(final Message message) {
        switch (message.getType()) {
        case SMS:
            smsMessageSender.transmitMessage(message);
            break;
        case EMAIL:
            emailMessageSender.transmitMessage(message);
            break;
        default:
            LOGGER.error("Unsupported method type {}", message.getType().name());
            break;
        }
    }
}
