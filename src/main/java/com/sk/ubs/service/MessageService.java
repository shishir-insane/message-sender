package com.sk.ubs.service;

import java.util.List;

import com.sk.ubs.exception.ServiceException;
import com.sk.ubs.model.Message;

public interface MessageService {

    void sendEmail(Message message) throws ServiceException;

    void sendSms(Message message) throws ServiceException;

    List<Message> getAllMessages();

}
