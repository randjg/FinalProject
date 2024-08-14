package API.stepDef;

import API.pages.ApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;

import static org.junit.Assert.*;

public class ListAllUsersStepDef {

    private ApiPage apiPage = new ApiPage();
    private Response response;
    private String status;

    @When("user send a GET request to list all users")
    public void userSendAGETRequestToListAllUsers() {
        response = apiPage.getAllUsers();
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @And("the response should contain a list of users")
    public void theResponseShouldContainAListOfUsers() {
        apiPage.validateUserListIsNotEmpty(response);
    }

    @And("user have query parameter to filter data by status {string}")
    public void userHaveQueryParameterToFilterDataByStatus(String status) {
        this.status = status;
    }

    @When("user send a GET request to filter users")
    public void userSendAGETRequestToFilterUsers() {
        response = apiPage.filterUserByStatus(status);
    }

    @And("the response should only contain users with status {string}")
    public void theResponseShouldOnlyContainUsersWithStatus(String expectedStatus) {
        apiPage.validateUsersHaveStatus(response, expectedStatus);
    }


}
