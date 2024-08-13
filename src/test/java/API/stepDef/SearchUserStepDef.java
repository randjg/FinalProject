package API.stepDef;

import API.pages.ApiPage;
import io.cucumber.java.en.And;
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
        System.out.println(response.getBody().asString());
//        response = apiPage.getUserByName(userName);
    }

    @And("the response should contain the correct user details")
    public void theResponseShouldContainTheCorrectUserDetails() {
        response.jsonPath().getInt("id");
        assertEquals("Randy J", response.jsonPath().getString("name"));
        assertEquals("rjg.5532@example.com", response.jsonPath().getString("email"));
        assertEquals("male", response.jsonPath().getString("gender"));
        assertEquals("active", response.jsonPath().getString("status"));
    }

//    @And("the searched name is {string}")
//    public void theSearchedNameIs(String userName) {
//        this.userName = userName;
//    }
}
