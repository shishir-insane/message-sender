/**
 *
 * AppUtils.java
 * com.sk.ubs.util
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.util;

import org.springframework.util.StringUtils;

import com.sk.ubs.model.Message;

public final class AppUtils {

    public static final String QUEUE_NAME = "message.queue";
    public static final int SMS_NOT_SENT_ERROR = 4001;
    public static final int INVALID_INPUT_MESSAGE_CODE = 4003;
    public static final int EMAIL_NOT_SENT_ERROR = 4002;

    public static final String INVALID_INPUT_MESSAGE = "Message posted in invalid";

    /**
     * Instantiates a new app utils.
     */
    private AppUtils() {
        // Hidden constructor
    }

    /**
     * Validate message.
     *
     * @param message
     *            the message
     * @return true, if successful
     */
    public static final boolean validateMessage(final Message message) {
        if (null == message || StringUtils.isEmpty(message.getSentTo())) {
            return false;
        } else {
            return true;
        }
    }

}
