package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ApiTest {

    @org.junit.Test
    @Test
    public void testGetRequest() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

        // Overenie status kódu
        assertEquals(200, response.getStatusCode());

        // Overenie obsahu odpovede
        assertNotNull(response.getBody().asString());

        // Vypísanie odpovede do konzoly
        System.out.println("Response: " + response.getBody().asString());
    }

     @Test
    public void testPostRequest() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", "foo");
        requestBody.put("body", "bar");
        requestBody.put("userId", 1);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("http://localhost:3000/posts");

        assertEquals(201, response.getStatusCode());
        assertNotNull(response.getBody().asString());
        System.out.println("POST Response: " + response.getBody().asString());
    }
}
