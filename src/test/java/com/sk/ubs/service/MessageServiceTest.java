/**
 *
 * MessageServiceTest.java
 * com.sk.ubs.service
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.MessagingException;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sk.ubs.exception.ServiceException;
import com.sk.ubs.jms.MessageProducer;
import com.sk.ubs.model.Message;
import com.sk.ubs.repository.MessageRepository;
import com.sk.ubs.service.impl.MessageServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

    @MockBean
    private MessageProducer messageProducer;

    @MockBean
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageServiceImpl messageService;

    private Message message;

    @Before
    public void init() {
        messageService = new MessageServiceImpl(messageRepository);
        MockitoAnnotations.initMocks(this);
        message = new Message();
        message.setId(1l);
        message.setSentTo("code.star@zoho.eu");
        message.setSentFrom("code.star@zoho.eu");
        message.setBody("Hello Shishir");
    }

    @Test
    public void testSendSms() throws MessagingException, JsonProcessingException, ServiceException {
        doNothing().when(messageProducer).sendMessage(any(Message.class));
        messageService.sendSms(message);
    }

    @Test(expected = ServiceException.class)
    public void testSendSms_InvalidMessage() throws MessagingException, JsonProcessingException, ServiceException {
        doNothing().when(messageProducer).sendMessage(any(Message.class));
        final Message messageInvalid = new Message();
        messageInvalid.setId(1l);
        messageInvalid.setSentTo(null);
        messageInvalid.setSentFrom("code.star@zoho.eu");
        messageInvalid.setBody("Hello Shishir");
        messageService.sendSms(messageInvalid);
    }

    @Test
    public void testSendEmail() throws MessagingException, JsonProcessingException, ServiceException {
        doNothing().when(messageProducer).sendMessage(any(Message.class));
        messageService.sendEmail(message);
    }

    @Test(expected = ServiceException.class)
    public void testSendEmail_InvalidMessage() throws MessagingException, JsonProcessingException, ServiceException {
        doNothing().when(messageProducer).sendMessage(any(Message.class));
        final Message messageInvalid = new Message();
        messageInvalid.setId(1l);
        messageInvalid.setSentTo(null);
        messageInvalid.setSentFrom("code.star@zoho.eu");
        messageInvalid.setBody("Hello Shishir");
        messageService.sendEmail(messageInvalid);
    }

    @Test
    public void testGetAllMessages() {
        when(messageRepository.findAll()).thenReturn(Lists.newArrayList(message));
        final List<Message> messages = messageService.getAllMessages();
        assertEquals(messages.size(), 1);
    }

}
