package com.cloudskol.restc.core;

import javax.ws.rs.core.Response;

/**
 * @author tham
 */

public class ApiResponse<T> {
    private int code;
    private T data;

    private Response response;

    public ApiResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
