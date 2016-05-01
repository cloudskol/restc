package com.cloudskol.restc.core;

import com.cloudskol.restc.get.GetApiRequest;

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

        //Add query parameter
        target = addQueryParameter(target, request);

        //Add path parameter
        target = addPathParameter(target, request);

        return target;
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

    private WebTarget addQueryParameter(WebTarget target, ApiRequest request) {
        final QueryParameter queryParam = request.getQueryParam();
        if (queryParam == null) {
            return target;
        }

        final List<Tuple> queryParameters = queryParam.getParameters();
        if (queryParameters == null || queryParameters.isEmpty()) {
            return target;
        }

        for (Tuple queryParameter : queryParameters) {
            target = target.queryParam(queryParameter.getKey(), queryParameter.getValue());
        }

        return target;
    }
}
