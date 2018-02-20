/**
 *
 * ServiceException.java
 * com.sk.ubs.exception
 * message-sender
 *
 * Copyright 2018 - Shishir Kumar
 */
package com.sk.ubs.exception;

public class ServiceException extends Exception {

    private static final long serialVersionUID = -2448274330640558042L;

    private final int errorCode;

    /**
     * Instantiates a new service exception.
     *
     * @param errorCode
     *            the error code
     * @param message
     *            the message
     */
    public ServiceException(final int errorCode, final String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * Instantiates a new service exception.
     *
     * @param errorCode
     *            the error code
     * @param cause
     *            the cause
     */
    public ServiceException(final int errorCode, final Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    /**
     * Instantiates a new service exception.
     *
     * @param errorCode
     *            the error code
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public ServiceException(final int errorCode, final String message, final Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * Instantiates a new service exception.
     *
     * @param errorCode
     *            the error code
     * @param message
     *            the message
     * @param cause
     *            the cause
     * @param enableSuppression
     *            the enable suppression
     * @param writableStackTrace
     *            the writable stack trace
     */
    public ServiceException(final int errorCode, final String message, final Throwable cause,
            final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    /**
     * Gets the error code.
     *
     * @return the error code
     */
    public int getErrorCode() {
        return errorCode;
    }

}
