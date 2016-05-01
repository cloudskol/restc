package com.cloudskol.restc.core;

/**
 * @author tham
 */

public class ApiRequest {
    private String path;
    private ApiMethod method;

    private QueryParameter queryParam;
    private PathParameter pathParam;
    private HeaderParameter headerParam;

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

    public QueryParameter getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(QueryParameter queryParam) {
        this.queryParam = queryParam;
    }

    public PathParameter getPathParam() {
        return pathParam;
    }

    public void setPathParam(PathParameter pathParam) {
        this.pathParam = pathParam;
    }

    public HeaderParameter getHeaderParam() {
        return headerParam;
    }

    public void setHeaderParam(HeaderParameter headerParam) {
        this.headerParam = headerParam;
    }
}
