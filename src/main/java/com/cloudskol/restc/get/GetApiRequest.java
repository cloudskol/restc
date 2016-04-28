package com.cloudskol.restc.get;

import com.cloudskol.restc.core.ApiMethod;
import com.cloudskol.restc.core.ApiRequest;
import com.cloudskol.restc.core.Tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tham
 */

public class GetApiRequest extends ApiRequest {
    private List<Tuple> queryParams = new ArrayList<Tuple>(2);

    public GetApiRequest(String path) {
        super(path, ApiMethod.GET);
    }

    public boolean addQueryParam(Tuple tuple) {
        return queryParams.add(tuple);
    }

    public List<Tuple> getQueryParams() {
        return queryParams;
    }
}
