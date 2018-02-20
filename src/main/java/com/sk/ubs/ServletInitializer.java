/**
 *
 * ServletInitializer.java
 * com.sk.ubs
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.boot.web.support.SpringBootServletInitializer#
     * configure(org.springframework.boot.builder.SpringApplicationBuilder)
     */
    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(MessageSenderApplication.class);
    }

}
