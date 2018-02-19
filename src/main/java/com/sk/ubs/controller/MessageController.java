package com.sk.ubs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sk.ubs.model.Message;

@RestController
public class MessageController {

    @RequestMapping(value = "/sms", method = RequestMethod.POST)
    public void sendSms(@RequestBody final Message message) {

    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public void sendEmail(@RequestBody final Message message) {

    }

    @RequestMapping("/messages")
    public List<Message> getMessageList() {
        return null;
    }

}
