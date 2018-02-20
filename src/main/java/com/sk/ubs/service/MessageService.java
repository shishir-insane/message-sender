/**
 *
 * MessageService.java
 * com.sk.ubs.service
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.service;

import java.util.List;

import com.sk.ubs.exception.ServiceException;
import com.sk.ubs.model.Message;

public interface MessageService {

    /**
     * Send email.
     *
     * @param message
     *            the message
     * @throws ServiceException
     *             the service exception
     */
    void sendEmail(Message message) throws ServiceException;

    /**
     * Send sms.
     *
     * @param message
     *            the message
     * @throws ServiceException
     *             the service exception
     */
    void sendSms(Message message) throws ServiceException;

    /**
     * Gets the all messages.
     *
     * @return the all messages
     */
    List<Message> getAllMessages();

}
