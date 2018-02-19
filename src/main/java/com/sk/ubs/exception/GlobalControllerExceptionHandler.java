package com.sk.ubs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse noHandlerFoundException(final Exception e) {
        return new ApiErrorResponse(404, 4001, e.getMessage());
    }

    @ExceptionHandler(value = { ServiceException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse serviceException(final ServiceException e) {
        return new ApiErrorResponse(500, e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse unknownException(final Exception e, final WebRequest request) {
        return new ApiErrorResponse(500, 5001, e.getMessage());
    }
}
