package com.cloudskol.restc.post;

import com.cloudskol.restc.core.Tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tham
 */

public class FormParameter {
    private List<Tuple> parameters = new ArrayList<Tuple>(2);

    public  boolean addParameter(Tuple tuple) {
        return parameters.add(tuple);
    }

    public List<Tuple> getParameters() {
        return parameters;
    }
}
