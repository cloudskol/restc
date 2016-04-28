package com.cloudskol.restc.get;

import com.cloudskol.restc.core.ApiRequest;
import com.cloudskol.restc.core.ApiRequestBuilder;
import com.cloudskol.restc.core.Tuple;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * @author tham
 */

public class GetApiRequestBuilder {
    private ApiRequestBuilder requestBuilder;

    public GetApiRequestBuilder(Client client) {
        requestBuilder = new ApiRequestBuilder(client);
    }

    public WebTarget build(ApiRequest request) {
        WebTarget webTarget = requestBuilder.build(request);

        //Add query parameter
        webTarget = addQueryParams(webTarget, request);

        System.out.println("Request: " + webTarget.getUri().toString());
        return webTarget;
    }

    private WebTarget addQueryParams(WebTarget webTarget, ApiRequest request) {
        if (!(request instanceof GetApiRequest)) {
            return webTarget;
        }

        GetApiRequest getApiRequest = (GetApiRequest)request;
        if (getApiRequest.getQueryParams() == null || getApiRequest.getQueryParams().isEmpty()) {
            return webTarget;
        }

        for (Tuple tuple : getApiRequest.getQueryParams()) {
            webTarget = webTarget.queryParam(tuple.getKey(), tuple.getValue());
        }

        return webTarget;
    }
}
