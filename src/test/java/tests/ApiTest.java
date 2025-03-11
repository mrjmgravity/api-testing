package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
