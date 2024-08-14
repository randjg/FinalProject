package API.pages;

import API.helper.Endpoint;
import API.helper.Models.User;
import io.restassured.response.Response;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class ApiPage {

    private Response response;

    public Response isAPIAvailable(){
        response = Endpoint.setupRequest().get("/users");
        assertEquals(200, response.getStatusCode());
        return response;
    }

    public Response createUser(User user){
        return Endpoint.setupRequest()
                .body(user)
                .post("/users");
    }

    public User createValidUser(){
        return new User(
                "Randy J",
                generateUniqueEmail(),
                "male",
                "active"
        );
    }

    public User createInvalidUser(){
        return new User(
                "",
                generateUniqueEmail(),
                "",
                ""
        );
    }

    public void validateUserCreation(User expectedUser, Response response){
        assertEquals("Name should match", expectedUser.getName(), response.jsonPath().getString("name"));
        assertEquals("Email should match", expectedUser.getEmail(), response.jsonPath().getString("email"));
        assertEquals("Gender should match", expectedUser.getGender(), response.jsonPath().getString("gender"));
        assertEquals("Status should match", expectedUser.getStatus(), response.jsonPath().getString("status"));
    }

    public void validateErrorMessage(Response response){
        String errorMessage = response.jsonPath().getString("message");
    }

    public String generateUniqueEmail(){
        return "rjg." + generateUniqueNumber() + "@example.com";
    }

    //to generate random number for unique email
    private String generateUniqueNumber(){
        Random random = new Random();

        return String.format("%04d",
                random.nextInt(10000)
        );
    }

    public Response getUserById(int userID){
        return Endpoint.setupRequest()
                .get("/users/" + userID);
    }

    public void validateUserDetails(Response response, int expectedUserID, String expectedName, String expectedEmail, String expectedGender, String expectedStatus){
        assertEquals("User ID should match", expectedUserID, response.jsonPath().getInt("id"));
        assertEquals("Name should match", expectedName, response.jsonPath().getString("name"));
        assertEquals("Email should match", expectedEmail, response.jsonPath().getString("email"));
        assertEquals("Gender should match", expectedGender, response.jsonPath().getString("gender"));
        assertEquals("Status should match", expectedStatus, response.jsonPath().getString("status"));
    }

    public Response getAllUsers(){
        return Endpoint.setupRequest().get("/users");
    }

    public Response filterUserByStatus(String status){
        return Endpoint.setupRequest().queryParam("status", status).get("/users");
    }

    public void validateUserListIsNotEmpty(Response response){
        assertFalse("User list should not be empty", response.jsonPath().getList("").isEmpty());
    }

    public void validateUsersHaveStatus(Response response, String expectedStatus){
        List<String> statuses = response.jsonPath().getList("status");
        assertTrue("All users should have status: " + expectedStatus, statuses.stream().allMatch(status -> status.equals(expectedStatus)));
    }

    public void validateStatusCode(Response response, int expectedStatusCode){
        assertEquals(expectedStatusCode, response.statusCode());
    }
}
