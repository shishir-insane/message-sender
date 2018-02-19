package com.sk.ubs.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk.ubs.model.Message;
import com.sk.ubs.service.MessageService;

@RunWith(SpringRunner.class)
@WebMvcTest(MessageController.class)
public class MessageControllerTest {

    private Message message;
    private JacksonTester<Message> jsonTester;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

    @Before
    public void init() {
        JacksonTester.initFields(this, objectMapper);
        message = new Message();
        message.setId(1l);
        message.setSentTo("code.star@zoho.eu");
        message.setSentFrom("code.star@zoho.eu");
        message.setBody("Hello Shishir");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendSms() throws Exception {
        doNothing().when(messageService).sendSms(any(Message.class));
        final String jsonContent = jsonTester.write(message).getJson();
        mvc.perform(post("/sms").content(jsonContent).contentType(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isOk());
    }

    @Test
    public void testSendEmail() throws Exception {
        doNothing().when(messageService).sendEmail(any(Message.class));
        final String jsonContent = jsonTester.write(message).getJson();
        mvc.perform(post("/email").content(jsonContent).contentType(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isOk());
    }

    @Test
    public void testGetMessageList() throws Exception {
        when(messageService.getAllMessages()).thenReturn(Lists.newArrayList(message));
        mvc.perform(get("/messages").contentType(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isOk());
    }

}
