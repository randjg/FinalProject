package WEB.stepDef;

import WEB.pages.CartPage;
import WEB.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MediaPlayerStepDef extends BaseTest{

    protected HomePage homePage;
    protected CartPage cartPage;

    @When("user click about us button")
    public void userClickAboutUsButton() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        homePage.clickAboutUsButton();
    }

    @And("user click play button")
    public void userClickPlayButton() {
        homePage.clickPlayVideo();
    }
}
