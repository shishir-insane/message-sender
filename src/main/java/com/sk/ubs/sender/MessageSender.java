/**
 *
 * MessageSender.java
 * com.sk.ubs.sender
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.sender;

import com.sk.ubs.model.Message;

public interface MessageSender {

    /**
     * Transmit message.
     *
     * @param message
     *            the message
     */
    void transmitMessage(Message message);

}
