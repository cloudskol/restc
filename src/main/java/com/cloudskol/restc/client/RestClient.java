/*
 * Copyright 2016 restc (http://cloudskol.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloudskol.restc.client;

import com.cloudskol.restc.core.*;
import com.cloudskol.restc.get.GetApiRequestBuilder;
import com.cloudskol.restc.post.PostApiRequestBuilder;

import javax.ws.rs.client.*;
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

    /**
     * Base method to call the REST API
     *
     * @param request
     * @param method
     * @return response constrcuted with {@link ApiResponse}
     */
    public ApiResponse request(ApiRequest request, ApiMethod method) {
        ApiResponse response = null;
        switch (method) {
            case GET:
                response = get(request);
                break;

            case POST:
                response = post(request);
                break;
        }

        return response;
    }

    /**
     * Implementation for GET method
     *
     * @param request
     * @return instance of {@link ApiResponse} with status code and response payload
     */
    public ApiResponse get(ApiRequest request) {
        final GetApiRequestBuilder requestBuilder = new GetApiRequestBuilder(client);
        final WebTarget target = requestBuilder.build(request);

        Invocation.Builder invocationBuilder = addHeaderParams(target.request(), request);
        return new ApiResponseBuilder(invocationBuilder.get()).build();
    }

    /**
     * Method for calling POST API
     *
     * @param request
     * @return instance of {@link ApiResponse} with status code and response payload
     */
    public ApiResponse post(ApiRequest request) {
        final PostApiRequestBuilder requestBuilder = new PostApiRequestBuilder(client);
        final WebTarget target = requestBuilder.build(request);

        Invocation.Builder invocationBuilder = addHeaderParams(target.request(), request);
        final Invocation invocation = requestBuilder.getInvocationwithForm(invocationBuilder, request);

        return new ApiResponseBuilder(invocation.invoke()).build();
    }

    private Invocation.Builder addHeaderParams(Invocation.Builder invocationBuilder, ApiRequest request) {
        final HeaderParameter headerParam = request.getHeaderParam();
        if (headerParam == null) {
            return null;
        }

        final List<Tuple> parameters = headerParam.getParameters();
        if (parameters == null || parameters.isEmpty()) {
            return null;
        }


        //Updated invocation builder should be returned back
        for (Tuple header : parameters) {
            invocationBuilder = invocationBuilder.header(header.getKey(), header.getValue());
        }

        return invocationBuilder;
    }
}
