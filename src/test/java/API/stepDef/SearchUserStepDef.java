package API.stepDef;

import API.pages.ApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SearchUserStepDef {

    private ApiPage apiPage = new ApiPage();
    private Response response;
    private int userID;
    private String userName;

    @And("the searched ID is {int}")
    public void theSearchedIDIs(int userID) {
        this.userID = userID;
    }

    @When("user send a GET request to the endpoint with the user data")
    public void userSendAGETRequestToTheEndpointWithTheUserData() {
        response = apiPage.getUserById(userID);
    }

    @Then("the GET response status code should be {int}")
    public void theGetResponseStatusCodeShouldBe(int expectedStatusCode) {
        apiPage.validateStatusCode(response, expectedStatusCode);
    }

    @And("the response should contain the correct user details")
    public void theResponseShouldContainTheCorrectUserDetails() {
        apiPage.validateUserDetails(response, userID, "Randy J", "rjg.5532@example.com", "male", "active");
    }

}
