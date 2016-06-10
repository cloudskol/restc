package com.cloudskol.restc.get;

import com.cloudskol.restc.core.ApiMethod;
import com.cloudskol.restc.core.ApiRequest;
import com.cloudskol.restc.core.Tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tham
 *
 * Bean object for holding GET api related information
 */

public class GetApiRequest extends ApiRequest {
    public GetApiRequest(String path) {
        super(path, ApiMethod.GET);
    }
}
