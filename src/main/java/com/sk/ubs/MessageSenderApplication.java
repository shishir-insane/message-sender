package com.sk.ubs;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import com.sk.ubs.util.AppUtils;

@SpringBootApplication
@EnableJms
public class MessageSenderApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MessageSenderApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(AppUtils.QUEUE_NAME);
    }
}
