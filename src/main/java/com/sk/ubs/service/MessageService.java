package com.sk.ubs.service;

import com.sk.ubs.model.Message;

public interface MessageService {

    void sendEmail(Message message);

    void sendSms(Message message);

}
