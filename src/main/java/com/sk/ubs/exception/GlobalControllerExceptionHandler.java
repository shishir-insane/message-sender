/**
 *
 * GlobalControllerExceptionHandler.java
 * com.sk.ubs.exception
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    /**
     * No handler found exception.
     *
     * @param e
     *            the e
     * @return the api error response
     */
    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse noHandlerFoundException(final Exception e) {
        return new ApiErrorResponse(404, 4001, e.getMessage());
    }

    /**
     * Service exception.
     *
     * @param e
     *            the e
     * @return the api error response
     */
    @ExceptionHandler(value = { ServiceException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse serviceException(final ServiceException e) {
        return new ApiErrorResponse(500, e.getErrorCode(), e.getMessage());
    }

    /**
     * Unknown exception.
     *
     * @param e
     *            the e
     * @param request
     *            the request
     * @return the api error response
     */
    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse unknownException(final Exception e, final WebRequest request) {
        return new ApiErrorResponse(500, 5001, e.getMessage());
    }
}
