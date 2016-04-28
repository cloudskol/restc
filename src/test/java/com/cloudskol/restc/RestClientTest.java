package com.cloudskol.restc;

import com.cloudskol.restc.client.RestClient;
import com.cloudskol.restc.core.ApiResponse;
import com.cloudskol.restc.core.Tuple;
import com.cloudskol.restc.get.GetApiRequest;
import org.junit.Test;

/**
 * @author tham
 */

public class RestClientTest {
    private static final String GET_PATH = "http://localhost:8080/restskol/api/books";

    @Test
    public void testGet() {
        final GetApiRequest apiRequest = new GetApiRequest(GET_PATH);
        apiRequest.addQueryParam(new Tuple("author", "Tham"));
        final ApiResponse apiResponse = RestClient.getInstance().get(apiRequest);
        System.out.println("Status: " + apiResponse.getCode());

        System.out.println("Data: " + apiResponse.getData());
    }
}
