package com.cloudskol.restc.core;

/**
 * @author tham
 */

public class ApiRequest {
    private String path;

    public ApiRequest(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
