package com.cloudskol.restc.post;

import com.cloudskol.restc.core.Tuple;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tham
 *
 * Wrapper to handle the form parameters in the request
 */

public class FormParameter {
    private MediaType type;
    private List<Tuple> parameters = new ArrayList<Tuple>(2);

    public FormParameter() {
        this(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
    }

    public FormParameter(MediaType type) {
        this.type = type;
    }

    public  boolean addParameter(Tuple tuple) {
        return parameters.add(tuple);
    }

    public MediaType getType() {
        return type;
    }

    public List<Tuple> getParameters() {
        return parameters;
    }
}
