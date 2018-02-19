package com.sk.ubs.exception;

import lombok.Data;

@Data
public class ApiErrorResponse {
    private final int status;
    private final int code;
    private final String message;
}
