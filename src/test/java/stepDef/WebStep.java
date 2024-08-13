package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.WebPage;

public class WebStep {
    WebPage webPage;

    public WebStep() {
        this.webPage = new WebPage();
    }

    @Given("user go to login page")
    public void userGoToLoginPage() {
        webPage.goToLoginPage();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        webPage.inputUsername(username);
    }

    @And("user input pwd {string}")
    public void userInputPwd(String pwd) {
        webPage.inputPassword(pwd);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        webPage.clickBtnLogin();
    }

    @Then("user verify see cart icon")
    public void userVerifySeeCartIcon() {
        webPage.verifyIconCart();
    }

    @Then("user verify see errmsg {string}")
    public void userVerifySeeErrmsg(String errMsg) {
        webPage.verifyErrMsg(errMsg);
    }

    @And("user click add to cart")
    public void userClickAddToCart() {
        webPage.itemAddToCart();
    }

    @Then("verify cart item has {string}")
    public void verifyCartItemHas(String itemExpected) {
        webPage.verifyItemCart(itemExpected);
    }

    @And("user click remove item chart")
    public void userClickRemoveItemChart() {
        webPage.itemRemoveToCart();
    }

    @And("user click sort item high to low")
    public void userClickSortItemHighToLow() {
        webPage.clickSortItemHighToLow();
        
    }

    @And("user click sort item Z to A")
    public void userClickSortItemZToA() {
        webPage.clickSortItemZtoA();
    }
}
