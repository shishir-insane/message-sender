package com.sk.ubs.util;

import org.springframework.util.StringUtils;

import com.sk.ubs.model.Message;

public final class AppUtils {

    public static final String QUEUE_NAME = "message.queue";
    public static final int SMS_NOT_SENT_ERROR = 4001;
    public static final int EMAIL_NOT_SENT_ERROR = 4002;

    private AppUtils() {
        // Hidden constructor
    }

    public static final boolean validateMessage(final Message message) {
        if (null == message || StringUtils.isEmpty(message.getSentTo())) {
            return false;
        } else {
            return true;
        }
    }

}
