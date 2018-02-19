package com.sk.ubs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sk.ubs.exception.ServiceException;
import com.sk.ubs.model.Message;
import com.sk.ubs.service.MessageService;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/sms", method = RequestMethod.POST)
    public void sendSms(@RequestBody final Message message) throws ServiceException {
        messageService.sendSms(message);
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public void sendEmail(@RequestBody final Message message) throws ServiceException {
        messageService.sendSms(message);
    }

    @RequestMapping("/messages")
    public List<Message> getMessageList() {
        return messageService.getAllMessages();
    }

}
