package com.cloudskol.restc.core;

import javax.ws.rs.core.Response;

/**
 * @author tham
 */

public class ApiResponseBuilder {
    private Response response;

    public ApiResponseBuilder(Response response) {
        this.response = response;
    }

    public ApiResponse build() {
        final ApiResponse apiResponse = new ApiResponse(response.getStatus(),
                response.readEntity(String.class));
        apiResponse.setResponse(response);

        return apiResponse;
    }
}
