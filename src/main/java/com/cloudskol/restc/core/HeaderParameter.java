package com.cloudskol.restc.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tham
 */

public class HeaderParameter {
    private List<Tuple> headerParams = new ArrayList<Tuple>(2);

    public boolean addHeaderParam(Tuple headerParam) {
        return headerParams.add(headerParam);
    }

    public List<Tuple> getParameters() {
        return headerParams;
    }
}
