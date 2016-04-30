package com.cloudskol.restc.core;

/**
 * @author tham
 *
 * Simple key-value pair
 * This is used in many different forms like header, path, query parameters
 */

public class Tuple {
    private String key;
    private String value;

    public Tuple(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
