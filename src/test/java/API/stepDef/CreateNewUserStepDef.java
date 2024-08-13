package API.stepDef;

import API.helper.Endpoint;
import API.helper.Models.User;
import API.pages.ApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class CreateNewUserStepDef {

    private final ApiPage apiPage = new ApiPage();
    private Response response;
    private User user;

    @Given("the GoREST API is available")
    public void theGoRESTAPIIsAvailable() {
        response = Endpoint.setupRequest()
                .get("/users");
        assertEquals(200, response.getStatusCode());
    }

    @And("the user data is valid")
    public void theUserDataIsValid() {
        user = new User(
                "Randy J",
                "rjg." + generateUniqueNumber() + "@example.com",
                "male",
                "active"
        );
    }

    @When("user send a POST request to the endpoint with the user data")
    public void userSendAPostRequestToTheEndpointWithTheUserData() {
        response = apiPage.createUser(user);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @And("the user should be created successfully")
    public void theUserShouldBeCreatedSuccessfully() {
        response.jsonPath().getInt("id");

        assertEquals("Name should match", user.getName(), response.jsonPath().getString("name"));
        assertEquals("Email should match", user.getEmail(), response.jsonPath().getString("email"));
        assertEquals("Gender should match", user.getGender(), response.jsonPath().getString("gender"));
        assertEquals("Status should match", user.getStatus(), response.jsonPath().getString("status"));
    }

    //to generate random number for unique email
    private String generateUniqueNumber(){
        Random random = new Random();

        return String.format("%04d",
                random.nextInt(10000)
        );
    }

    @And("the user data is invalid")
    public void theUserDataIsInvalid() {
        user = new User(
                "",
                "" + generateUniqueNumber() + "@example.com",
                "",
                ""
        );
    }

    @And("the response should contain an error message")
    public void theResponseShouldContainAnErrorMessage() {
        response.jsonPath().getString("message");
        System.out.println(response.getStatusCode());
    }
}
