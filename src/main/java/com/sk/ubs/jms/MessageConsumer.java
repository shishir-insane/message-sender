package com.sk.ubs.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sk.ubs.model.Message;
import com.sk.ubs.repository.MessageRepository;
import com.sk.ubs.util.AppUtils;

@Component
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    private MessageRepository messageRepository;

    @JmsListener(destination = AppUtils.QUEUE_NAME)
    public void receiveQueue(final Message message) {
        LOGGER.info("{} recieved at {}", message.getType().name(), message.getSentAt());
        LOGGER.info("Message Details: {}", message.toString());
        messageRepository.save(message);
    }

}
