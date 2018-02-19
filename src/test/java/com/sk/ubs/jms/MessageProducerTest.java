package com.sk.ubs.jms;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.messaging.MessagingException;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sk.ubs.jms.MessageProducer;
import com.sk.ubs.model.Message;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageProducerTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    private MessageProducer producer;

    private Message message;

    @Before
    public void init() {
        message = new Message();
        message.setId(1l);
        message.setSentTo("code.star@zoho.eu");
        message.setSentFrom("code.star@zoho.eu");
        message.setBody("Hello Shishir");
    }

    @Test
    public void testSendMessage() throws InterruptedException, MessagingException, JsonProcessingException {
        producer.sendMessage(message);
        Thread.sleep(1000L);
        throw new MessagingException("");
    }
}
