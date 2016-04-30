package com.cloudskol.restc.client;

import com.cloudskol.restc.core.*;
import com.cloudskol.restc.get.GetApiRequestBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

/**
 * @author tham
 *
 * Main entry point for Rest client
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

    public ApiResponse request(ApiRequest request, ApiMethod method) {
        ApiResponse response = null;
        switch (method) {
            case GET:
                response = get(request);
                break;
        }

        return response;
    }

    public ApiResponse get(ApiRequest request) {
        final GetApiRequestBuilder requestBuilder = new GetApiRequestBuilder(client);
        final WebTarget target = requestBuilder.build(request);

        final Invocation.Builder invocationBuilder = target.request();
        final MultivaluedMap<String, Object> headerParams = convertHeaderParams(request);
        if (headerParams != null && headerParams.size() > 0) {
            invocationBuilder.headers(headerParams);
        }


        return new ApiResponseBuilder(invocationBuilder.get()).build();
    }

    private MultivaluedMap<String, Object> convertHeaderParams(ApiRequest request) {
        final HeaderParameter headerParam = request.getHeaderParam();
        if (headerParam == null) {
            return null;
        }

        final List<Tuple> parameters = headerParam.getParameters();
        if (parameters == null || parameters.isEmpty()) {
            return null;
        }


        final Form form = new Form();
        for (Tuple header : parameters) {
            form.param(header.getKey(), header.getValue());
        }

        return form.asMap();
    }
}
