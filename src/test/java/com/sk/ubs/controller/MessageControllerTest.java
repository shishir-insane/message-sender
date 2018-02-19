package com.sk.ubs.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk.ubs.model.Message;

@RunWith(SpringRunner.class)
@WebMvcTest(MessageController.class)
public class MessageControllerTest {

    private Message message;
    private JacksonTester<Message> jsonTester;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void init() {
        JacksonTester.initFields(this, objectMapper);
        message = new Message();
        message.setId(1l);
        message.setSentTo("code.star@zoho.eu");
        message.setSentFrom("code.star@zoho.eu");
        message.setBody("Hello Shishir");
    }

    @Test
    public void testSendMessage() throws Exception {
        final String jsonContent = jsonTester.write(message).getJson();

        mvc.perform(post("/message").content(jsonContent).contentType(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isOk());
    }

}
