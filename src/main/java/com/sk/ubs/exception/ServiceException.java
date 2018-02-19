package com.sk.ubs.exception;

public class ServiceException extends Exception {

    private static final long serialVersionUID = -2448274330640558042L;

    private final int errorCode;

    public ServiceException(final int errorCode, final String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(final int errorCode, final Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ServiceException(final int errorCode, final String message, final Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ServiceException(final int errorCode, final String message, final Throwable cause,
            final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
