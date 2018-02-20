/**
 *
 * MessageConsumerTest.java
 * com.sk.ubs.jms
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.jms;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk.ubs.model.Message;
import com.sk.ubs.repository.MessageRepository;
import com.sk.ubs.sender.MessageSender;
import com.sk.ubs.util.MessageType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageConsumerTest {

    @Mock
    private MessageRepository messageRepository;

    @Mock
    private MessageSender smsMessageSender;

    @Mock
    private MessageSender emailMessageSender;

    @Mock
    private ObjectMapper mapper;

    @InjectMocks
    private MessageConsumer messageConsumer;

    private String messageString;
    private Message message;

    @Before
    public void init() throws JsonParseException, JsonMappingException, IOException {
        messageConsumer = new MessageConsumer(messageRepository);
        MockitoAnnotations.initMocks(this);
        message = new Message();
        message.setId(1l);
        message.setSentTo("code.star@zoho.eu");
        message.setSentFrom("code.star@zoho.eu");
        message.setBody("Hello Shishir");
        messageString = "{\"sentTo\":\"code.star@zoho.eu\",\"sentFrom\":\"code.star@zoho.eu\",\"body\":\"Hello Shishir\"}";
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testReceiveQueue() throws JsonParseException, JsonMappingException, IOException {
        when(messageRepository.save(any(Message.class))).thenReturn(message);
        when(mapper.readValue(anyString(), any(Class.class))).thenReturn(message);
        doNothing().when(smsMessageSender).transmitMessage(any(Message.class));
        doNothing().when(emailMessageSender).transmitMessage(any(Message.class));
        messageConsumer.receiveQueue(messageString);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testReceiveQueue_EmptyStr() throws JsonParseException, JsonMappingException, IOException {
        when(messageRepository.save(any(Message.class))).thenReturn(message);
        when(mapper.readValue(anyString(), any(Class.class))).thenReturn(message);
        doNothing().when(smsMessageSender).transmitMessage(any(Message.class));
        doNothing().when(emailMessageSender).transmitMessage(any(Message.class));
        messageConsumer.receiveQueue("");
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testReceiveQueue_InvalidMessage() throws JsonParseException, JsonMappingException, IOException {
        final Message invalidMessage = new Message();
        invalidMessage.setId(1l);
        invalidMessage.setSentTo(null);
        invalidMessage.setSentFrom("code.star@zoho.eu");
        invalidMessage.setBody("Hello Shishir");
        when(messageRepository.save(any(Message.class))).thenReturn(invalidMessage);
        when(mapper.readValue(anyString(), any(Class.class))).thenReturn(invalidMessage);
        doNothing().when(smsMessageSender).transmitMessage(any(Message.class));
        doNothing().when(emailMessageSender).transmitMessage(any(Message.class));
        messageConsumer.receiveQueue(messageString);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testReceiveQueue_SmsMessage() throws JsonParseException, JsonMappingException, IOException {
        final String smsMessageString = "{\"type\":\"SMS\",\"sentTo\":\"code.star@zoho.eu\",\"sentFrom\":\"code.star@zoho.eu\",\"body\":\"Hello Shishir\"}";
        final Message smsMessage = new Message();
        smsMessage.setId(1l);
        smsMessage.setSentTo(null);
        smsMessage.setSentFrom("code.star@zoho.eu");
        smsMessage.setBody("Hello Shishir");
        smsMessage.setType(MessageType.SMS);
        when(messageRepository.save(any(Message.class))).thenReturn(message);
        when(mapper.readValue(anyString(), any(Class.class))).thenReturn(message);
        doNothing().when(smsMessageSender).transmitMessage(any(Message.class));
        doNothing().when(emailMessageSender).transmitMessage(any(Message.class));
        messageConsumer.receiveQueue(smsMessageString);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testReceiveQueue_UnsupportedMessage() throws JsonParseException, JsonMappingException, IOException {
        final String faxMessageString = "{\"type\":\"FAX\",\"sentTo\":\"code.star@zoho.eu\",\"sentFrom\":\"code.star@zoho.eu\",\"body\":\"Hello Shishir\"}";
        final Message invalidMessage = new Message();
        invalidMessage.setId(1l);
        invalidMessage.setSentTo(null);
        invalidMessage.setSentFrom("code.star@zoho.eu");
        invalidMessage.setBody("Hello Shishir");
        invalidMessage.setType(MessageType.FAX);
        when(messageRepository.save(any(Message.class))).thenReturn(invalidMessage);
        when(mapper.readValue(anyString(), any(Class.class))).thenReturn(invalidMessage);
        doNothing().when(smsMessageSender).transmitMessage(any(Message.class));
        doNothing().when(emailMessageSender).transmitMessage(any(Message.class));
        messageConsumer.receiveQueue(faxMessageString);
    }
}
