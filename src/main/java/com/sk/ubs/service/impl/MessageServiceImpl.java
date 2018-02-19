package com.sk.ubs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sk.ubs.exception.ServiceException;
import com.sk.ubs.jms.MessageProducer;
import com.sk.ubs.model.Message;
import com.sk.ubs.repository.MessageRepository;
import com.sk.ubs.service.MessageService;
import com.sk.ubs.util.AppUtils;
import com.sk.ubs.util.MessageType;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageProducer messageProducer;

    private final MessageRepository messageRepository;

    public MessageServiceImpl(final MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void sendSms(final Message message) throws ServiceException {
        try {
            if (AppUtils.validateMessage(message)) {
                message.setType(MessageType.SMS);
                messageProducer.sendMessage(message);
            }
        } catch (MessagingException | JsonProcessingException e) {
            throw new ServiceException(AppUtils.SMS_NOT_SENT_ERROR, e.getMessage());
        }

    }

    @Override
    public void sendEmail(final Message message) throws ServiceException {
        try {
            if (AppUtils.validateMessage(message)) {
                message.setType(MessageType.EMAIL);
                messageProducer.sendMessage(message);
            }
        } catch (MessagingException | JsonProcessingException e) {
            throw new ServiceException(AppUtils.EMAIL_NOT_SENT_ERROR, e.getMessage());
        }
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

}
