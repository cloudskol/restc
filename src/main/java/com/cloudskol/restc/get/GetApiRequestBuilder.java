package com.cloudskol.restc.get;

import com.cloudskol.restc.core.ApiRequest;
import com.cloudskol.restc.core.ApiRequestBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * @author tham
 *
 * Builder to handle the GET method call
 */

public class GetApiRequestBuilder {
    private ApiRequestBuilder requestBuilder;

    public GetApiRequestBuilder(Client client) {
        requestBuilder = new ApiRequestBuilder(client);
    }

    public WebTarget build(ApiRequest request) {
        WebTarget webTarget = requestBuilder.build(request);
        System.out.println("Request: " + webTarget.getUri().toString());
        return webTarget;
    }
}
