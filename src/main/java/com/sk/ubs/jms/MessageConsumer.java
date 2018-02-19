package com.sk.ubs.jms;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk.ubs.model.Message;
import com.sk.ubs.repository.MessageRepository;
import com.sk.ubs.sender.MessageSender;
import com.sk.ubs.util.AppUtils;

@Component
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageSender smsMessageSender;

    @Autowired
    private MessageSender emailMessageSender;

    @Autowired
    private ObjectMapper mapper;

    @JmsListener(destination = AppUtils.QUEUE_NAME)
    public void receiveQueue(final String messageString) {
        try {
            final Message message = mapper.readValue(messageString, Message.class);
            sendMessage(message);
            messageRepository.save(message);
        } catch (final IOException e) {
            LOGGER.error("Error occured while reading message from queue. {}", e);
        }
    }

    private void sendMessage(final Message message) {
        switch (message.getType()) {
        case SMS:
            smsMessageSender.transmitMessage(message);
            break;
        case EMAIL:
            emailMessageSender.transmitMessage(message);
            break;
        }
    }

}
