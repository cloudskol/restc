package com.cloudskol.restc.core;

/**
 * @author tham
 */

public class ApiRequest {
    private String path;
    private ApiMethod method;

    ApiRequest(String path) {
        this(path, ApiMethod.GET);
    }

    public ApiRequest(String path, ApiMethod method) {
        this.path = path;
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public ApiMethod getMethod() {
        return method;
    }
}
