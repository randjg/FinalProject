package WEB.stepDef;

import WEB.pages.CartPage;
import WEB.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.security.SecureRandom;

public class MessageStepDef extends BaseTest{

    protected HomePage homePage;
    protected CartPage cartPage;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private String randomMessage;

    @When("user click contact button")
    public void userClickContactButton() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        homePage.clickContactButton();
    }

    @Then("user input contact email with {string}")
    public void userInputContactEmail(String email) {
        homePage.inputEmail(email);
    }

    @Then("user input contact name with {string}")
    public void userInputContactNameWith(String name) {
        homePage.inputName(name);
    }

    @Then("user input message")
    public void userInputMessage() {
        randomMessage = generateRandomMessage(100);
        homePage.messageInput(randomMessage);
        System.out.printf(randomMessage);
    }

    @When("user click send message button")
    public void userClickSendMessageButton() {
        homePage.clickSendMessageButton();
    }

    public static String generateRandomMessage(int len){
        SecureRandom random = new SecureRandom();
        StringBuilder build = new StringBuilder(len);

        for (int i = 0 ; i < len ; i++){
            int idx = random.nextInt(CHARACTERS.length());
            build.append(CHARACTERS.charAt(idx));

            if ((i + 1) % 10 == 0 && i != len - 1) {
                build.append(' ');
            }
        }

        return build.toString();
    }
}
