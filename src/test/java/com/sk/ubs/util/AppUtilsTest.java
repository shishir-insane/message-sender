/**
 *
 * AppUtilsTest.java
 * com.sk.ubs.util
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sk.ubs.model.Message;

public class AppUtilsTest {

    @Test
    public void testValidateMessage_Valid() {
        final Message message = new Message();
        message.setId(1l);
        message.setSentTo("code.star@zoho.eu");
        message.setSentFrom("code.star@zoho.eu");
        message.setBody("Hello Shishir");

        assertTrue(AppUtils.validateMessage(message));
    }

    @Test
    public void testValidateMessage_InValidNullTo() {
        final Message message = new Message();
        message.setId(1l);
        message.setSentTo(null);
        message.setSentFrom("code.star@zoho.eu");
        message.setBody("Hello Shishir");

        assertFalse(AppUtils.validateMessage(message));
    }

    @Test
    public void testValidateMessage_InValidEmptyTo() {
        final Message message = new Message();
        message.setId(1l);
        message.setSentTo("");
        message.setSentFrom("code.star@zoho.eu");
        message.setBody("Hello Shishir");

        assertFalse(AppUtils.validateMessage(message));
    }

    @Test
    public void testValidateMessage_InValidNullMessage() {
        assertFalse(AppUtils.validateMessage(null));
    }

}
