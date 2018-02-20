/**
 *
 * MessageRepository.java
 * com.sk.ubs.repository
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.ubs.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
