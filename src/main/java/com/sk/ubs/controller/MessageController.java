/**
 *
 * MessageController.java
 * com.sk.ubs.controller
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jcabi.aspects.Loggable;
import com.sk.ubs.exception.ServiceException;
import com.sk.ubs.model.Message;
import com.sk.ubs.service.MessageService;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * Send sms.
     *
     * @param message
     *            the message
     * @throws ServiceException
     *             the service exception
     */
    @RequestMapping(value = "/sms", method = RequestMethod.POST)
    @Loggable
    public void sendSms(@RequestBody final Message message) throws ServiceException {
        messageService.sendSms(message);
    }

    /**
     * Send email.
     *
     * @param message
     *            the message
     * @throws ServiceException
     *             the service exception
     */
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    @Loggable
    public void sendEmail(@RequestBody final Message message) throws ServiceException {
        messageService.sendEmail(message);
    }

    /**
     * Gets the message list.
     *
     * @return the message list
     */
    @RequestMapping("/messages")
    @Loggable
    public List<Message> getMessageList() {
        return messageService.getAllMessages();
    }

}
