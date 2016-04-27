package com.cloudskol.restc.core;

/**
 * @author tham
 */

public class ApiResponse<T> {
    private int code;
    private T response;

    public ApiResponse(int code, T response) {
        this.code = code;
        this.response = response;
    }

    public int getCode() {
        return code;
    }

    public T getResponse() {
        return response;
    }
}
