package com.cloudskol.restc.post;

import com.cloudskol.restc.core.ApiMethod;
import com.cloudskol.restc.core.ApiRequest;

/**
 * @author tham
 *
 * Model object which will be used for POST request
 */

public class PostApiRequest extends ApiRequest {
    private FormParameter formParam;

    public PostApiRequest(String path) {
        super(path, ApiMethod.POST);
    }

    public FormParameter getFormParam() {
        return formParam;
    }
}
