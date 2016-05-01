package com.cloudskol.restc.post;

import com.cloudskol.restc.core.ApiMethod;
import com.cloudskol.restc.core.ApiRequest;

/**
 * @author tham
 */

public class PostApiRequest extends ApiRequest {
    public PostApiRequest(String path) {
        super(path, ApiMethod.POST);
    }
}
