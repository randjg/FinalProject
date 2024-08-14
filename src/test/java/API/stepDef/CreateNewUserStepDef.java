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
        response = apiPage.isAPIAvailable();
    }

    @And("the user data is valid")
    public void theUserDataIsValid() {
        user = apiPage.createValidUser();
    }

    @When("user send a POST request to the endpoint with the user data")
    public void userSendAPostRequestToTheEndpointWithTheUserData() {
        response = apiPage.createUser(user);
        System.out.println(response.getBody().asString());
    }

    @Then("the POST response status code should be {int}")
    public void thePostResponseStatusCodeShouldBe(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @And("the user should be created successfully")
    public void theUserShouldBeCreatedSuccessfully() {
        apiPage.validateUserCreation(user, response);
    }

    @And("the user data is invalid")
    public void theUserDataIsInvalid() {
        user = apiPage.createInvalidUser();
    }

    @And("the response should contain an error message")
    public void theResponseShouldContainAnErrorMessage() {
        apiPage.validateErrorMessage(response);
    }
}
