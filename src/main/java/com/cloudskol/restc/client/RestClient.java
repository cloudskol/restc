package com.cloudskol.restc.client;

import com.cloudskol.restc.core.ApiRequest;
import com.cloudskol.restc.core.ApiRequestBuilder;
import com.cloudskol.restc.core.ApiResponse;
import com.cloudskol.restc.core.ApiResponseBuilder;
import com.cloudskol.restc.get.GetApiRequestBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author tham
 */

public class RestClient {
    private static RestClient instance;
    private static Client client;

    private RestClient() {}

    public static final synchronized RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();

            if (client == null) {
                client = ClientBuilder.newClient();
            }
        }

        return instance;
    }

    public ApiResponse get(ApiRequest request) {
        final GetApiRequestBuilder requestBuilder = new GetApiRequestBuilder(client);
        final WebTarget target = requestBuilder.build(request);

        return new ApiResponseBuilder(target.request().get()).build();
    }
}
