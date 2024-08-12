package WEB.stepDef;

import WEB.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class SignUpStepDef extends BaseTest{

    protected HomePage homePage;
    private String dynamicUsername;

    @Given("user is on start page")
    public void userIsOnStartPage() {
        homePage = new HomePage(driver);
        homePage.goToHomePage();
    }

    @When("user click signup button")
    public void userClickSignupButton() {
        homePage.clickSignUpButton();
    }

    @Then("user input username with {string}")
    public void userInputUsernameWith(String username) {
        homePage.inputUsernameSignUp(username);
    }

    @Then("user input password with {string}")
    public void userInputPasswordWith(String password) {
        homePage.inputPasswordSignUp(password);
    }

    @When("user click register button")
    public void userClickRegisterButton() {
        homePage.clickRegisterButton();
    }

    @Then("user should see pop-up message {string}")
    public void userShouldSeePopUpMessage(String message) {
        homePage.validateMessage(message);
    }

    @Then("user input username with a dynamic value")
    public void userInputUsernameWithADynamicValue() {
        dynamicUsername = generateDynamicUsername();
        homePage.inputUsernameSignUp(dynamicUsername);
        System.out.printf(dynamicUsername);
    }

    //To create dynamic username to avoid username already exist
    private String generateDynamicUsername(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String timestamp = LocalDateTime.now().format(formatter);

        Random random = new Random();
        int randomNum = random.nextInt(1000);

        return "rjg" + timestamp + randomNum;
    }
}
