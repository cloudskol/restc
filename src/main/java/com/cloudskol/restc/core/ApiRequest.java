package com.cloudskol.restc.core;

/**
 * @author tham
 */

public class ApiRequest {
    private String path;
    private ApiMethod method;

    private PathParameter pathParam;

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

    public PathParameter getPathParam() {
        return pathParam;
    }

    public void setPathParam(PathParameter pathParam) {
        this.pathParam = pathParam;
    }
}
