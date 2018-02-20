/**
 *
 * ApiErrorResponse.java
 * com.sk.ubs.exception
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.exception;

import lombok.Data;

/**
 * Instantiates a new api error response.
 *
 * @param status
 *            the status
 * @param code
 *            the code
 * @param message
 *            the message
 */
@Data
public class ApiErrorResponse {
    private final int status;
    private final int code;
    private final String message;
}
