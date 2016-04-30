package com.cloudskol.restc.core;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import java.util.List;

/**
 * @author tham
 */

public class ApiRequestBuilder {
    private final Client client;

    public ApiRequestBuilder(Client client) {
        this.client = client;
    }

    public WebTarget build(ApiRequest request) {
        WebTarget target = client.target(request.getPath());

        //Add path parameter
        target = addPathParameter(target, request);

        //Add header parameter
        addHeaderParameter(target, request);

        return target;
    }

    private void addHeaderParameter(WebTarget target, ApiRequest request) {
        final HeaderParameter headerParam = request.getHeaderParam();
        if (headerParam == null) {
            return;
        }

        final List<Tuple> parameters = headerParam.getParameters();
        if (parameters == null || parameters.isEmpty()) {
            return;
        }

        for (Tuple parameter : parameters) {
        }
    }

    /**
     * Resolves the path parameter available in the request object
     *
     * @param target
     * @param request
     * @return instance of @WebTarget after resolved the path parameters
     */
    private WebTarget addPathParameter(WebTarget target, ApiRequest request) {
        final PathParameter pathParam = request.getPathParam();
        if (pathParam == null) {
            return target;
        }

        final List<Tuple> parameters = pathParam.getParameters();
        if (parameters == null || parameters.isEmpty()) {
            return target;
        }

        for (Tuple parameter : parameters) {
            target = target.resolveTemplate(parameter.getKey(), parameter.getValue());
        }

        return target;
    }
}
