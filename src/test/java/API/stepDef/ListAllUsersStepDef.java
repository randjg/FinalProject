package API.stepDef;

import API.pages.ApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListAllUsersStepDef {

    private ApiPage apiPage = new ApiPage();
    private Response response;
    private String status;

    @When("user send a GET request to list all users")
    public void userSendAGETRequestToListAllUsers() {
        response = apiPage.getAllUsers();
    }

    @And("the response should contain a list of users")
    public void theResponseShouldContainAListOfUsers() {
        assertFalse("User list should not be empty", response.jsonPath().getList("").isEmpty());
    }

    @And("user have query parameter to filter data by status {string}")
    public void userHaveQueryParameterToFilterDataByStatus(String status) {
        this.status = status;
    }

    @When("user send a GET request to filter users")
    public void userSendAGETRequestToFilterUsers() {
        response = apiPage.filterUserByStatus(status);
        System.out.println(response.getBody().asString());
    }

    @And("the response should only contain users with status {string}")
    public void theResponseShouldOnlyContainUsersWithStatus(String expectedStatus) {
        List<String> statuses = response.jsonPath().getList("status");
        assertTrue("All users should have status: " + expectedStatus, statuses.stream().allMatch(status -> status.equals(expectedStatus)));
    }
}
