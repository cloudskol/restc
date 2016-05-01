package com.cloudskol.restc.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tham
 */

public class QueryParameter {
    private List<Tuple> parameters = new ArrayList<Tuple>(2);

    public  boolean addParameter(Tuple tuple) {
        return parameters.add(tuple);
    }

    public List<Tuple> getParameters() {
        return parameters;
    }
}
