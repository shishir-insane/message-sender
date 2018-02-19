package com.sk.ubs.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sk.ubs.model.Message;

@RestController
public class MessageController {

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public void RequestBody(@RequestBody final Message message) {

    }

}
