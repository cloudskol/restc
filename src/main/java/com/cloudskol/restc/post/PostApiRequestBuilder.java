package com.cloudskol.restc.post;

import com.cloudskol.restc.core.ApiRequest;
import com.cloudskol.restc.core.ApiRequestBuilder;
import com.cloudskol.restc.core.Tuple;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import java.util.List;

/**
 * @author tham
 */

public class PostApiRequestBuilder {
    private ApiRequestBuilder requestBuilder;

    public PostApiRequestBuilder(Client client) {
        requestBuilder = new ApiRequestBuilder(client);
    }

    public WebTarget build(ApiRequest request) {
        WebTarget webTarget = requestBuilder.build(request);
        System.out.println("Request: " + webTarget.getUri().toString());
        return webTarget;
    }

    public Invocation getInvocationwithForm(Invocation.Builder invokeBuilder, ApiRequest request) {
        if (!(request instanceof PostApiRequest)) {
            return null;
        }

        PostApiRequest postRequest = (PostApiRequest)request;
        final FormParameter formParam = postRequest.getFormParam();
        if (formParam == null) {
            return null;
        }

        final List<Tuple> formParameters = formParam.getParameters();
        if (formParameters == null || formParameters.isEmpty()) {
            return null;
        }

        final Form form = new Form();
        for (Tuple formParameter : formParameters) {
            form.param(formParameter.getKey(), formParameter.getValue());
        }

        return invokeBuilder.buildPost(Entity.entity(form, formParam.getType()));
    }
}
