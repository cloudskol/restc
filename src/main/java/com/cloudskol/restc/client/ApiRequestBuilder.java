package com.cloudskol.restc.client;

import com.cloudskol.restc.core.ApiRequest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * @author tham
 */

public class ApiRequestBuilder {
    private final Client client;

    public ApiRequestBuilder(Client client) {
        this.client = client;
    }

    public WebTarget build(ApiRequest request) {
        final WebTarget target = client.target(request.getPath());

        return target;
    }
}
