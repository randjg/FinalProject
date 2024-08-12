package WEB.stepDef;

import WEB.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef extends BaseTest{

    protected HomePage homePage;

    public LoginStepDef(){
        homePage = new HomePage(driver);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        homePage.clickLoginButton();
    }

    @Then("user input login username with {string}")
    public void userInputLoginUsernameWith(String username) {
        homePage.inputUsernameLogin(username);
    }

    @Then("user input login password with {string}")
    public void userInputLoginPasswordWith(String password) {
        homePage.inputPasswordLogin(password);
    }

    @When("user click log in button")
    public void userClickLogInButton() {
        homePage.clickLoginButtonModal();
    }

    @Then("user should see logout button")
    public void userShouldSeeLogoutButton() {
        homePage.validateLogin();
    }

}
