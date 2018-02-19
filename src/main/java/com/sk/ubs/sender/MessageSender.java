package com.sk.ubs.sender;

import com.sk.ubs.model.Message;

public interface MessageSender {

    void transmitMessage(Message message);

}
