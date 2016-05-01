package com.cloudskol.restc;

import com.cloudskol.restc.client.RestClient;
import com.cloudskol.restc.core.*;
import com.cloudskol.restc.get.GetApiRequest;
import org.junit.Test;

/**
 * @author tham
 */

public class RestClientTest {
    private static final String BOOKS = "http://localhost:8080/restskol/api/books";
    private static final String BOOK_WITH_ID = "http://localhost:8080/restskol/api/books/{id}";

    @Test
    public void testGet() {
        final GetApiRequest apiRequest = new GetApiRequest(BOOKS);

        final QueryParameter queryParameter = new QueryParameter();
        queryParameter.addParameter(new Tuple("author", "Tham"));
        apiRequest.setQueryParam(queryParameter);

        final ApiResponse apiResponse = RestClient.getInstance().get(apiRequest);
        displayResponse(apiResponse);
    }

    @Test
    public void testPathParameter() {
        final GetApiRequest apiRequest = new GetApiRequest(BOOK_WITH_ID);

        final PathParameter pathParameter = new PathParameter();
        pathParameter.addParameter(new Tuple("id", "3"));
        apiRequest.setPathParam(pathParameter);

        final ApiResponse apiResponse = RestClient.getInstance().get(apiRequest);
        displayResponse(apiResponse);
    }

    private void displayResponse(ApiResponse response) {
        System.out.println("Status: " + response.getCode());
        System.out.println("Data: " + response.getData());
    }
}
