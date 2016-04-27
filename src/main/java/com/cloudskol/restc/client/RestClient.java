package com.cloudskol.restc.client;

import com.cloudskol.restc.core.ApiResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * @author tham
 */

public class RestClient {
    private static RestClient instance;
    private static Client client;

    private RestClient() {}

    public static final synchronized RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();

            if (client == null) {
                client = ClientBuilder.newClient();
            }
        }

        return instance;
    }

    public ApiResponse get() {
        return null;
    }
}
