package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {

    ApiPage apiPage;

    public ApiStep() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.setupURL(url);
    }

    @And("hit api get list users")
    public void hitApi() {
        apiPage.hitGetListUser();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
        apiPage.validationStatusCode(status_code);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationJSONSChema(filename);
    }

    @And("hit api post create new users")
    public void hitApiPostCreateNewUsers() {
        apiPage.hitPostCreateUser();
    }

    @And("hit api get list users not found {string}")
    public void hitApiPostCreateNewUsers(String id) {
        apiPage.hitGetUserNotFound(id);
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() {
        apiPage.validationBodyPostCreateNewUsers();
    }

    @And("hit api delete new")
    public void hitApiDeleteNew() {
        apiPage.hitDeleteUsers();
    }
    @And("hit api update data")
    public void hitApiUpdateData() {
        apiPage.hitUpdateUser();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationBodyUpdateUsers();
    }

    @Then("validation response body get users not found")
    public void validationResponseBodyUserNotFound() {
        apiPage.validationBodyGetUsersNotFound();
    }
}
