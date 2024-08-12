package WEB.stepDef;

import WEB.pages.CartPage;
import WEB.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

public class CheckoutStepDef extends BaseTest{

    protected HomePage homePage;
    protected CartPage cartPage;
    private String dynamicCCNumber;

    @When("user click a product")
    public void userClickAProduct() {
        homePage = new HomePage(driver);
        homePage.clickProduct();
    }

    @When("user click add to cart button")
    public void userClickAddToCartButton() {
        homePage.clickAddToCartButton();
    }

    @Then("user should dismiss the alert")
    public void userDismissTheAlert() {
        homePage.dismissAlert();
    }

    @When("user click cart button")
    public void userClickCartButton() {
        homePage.clickCartButton();
    }

    @Then("user should see page title {string}")
    public void userShouldSeePageTitle(String pageTitle) {
        cartPage = new CartPage(driver);
        cartPage.validatePage(pageTitle);
    }

    @When("user click place to order button")
    public void userClickPlaceToOrderButton() {
        cartPage.clickPlaceToOrderButton();
    }

    @Then("user should see modal with title {string}")
    public void userShouldSeeModalWithTitle(String modalLabel) {
        cartPage.validateModality(modalLabel);
    }

    @Then("user input name field with {string}")
    public void userInputNameFieldWith(String name) {
        cartPage.inputName(name);
    }

    @Then("user input country field with {string}")
    public void userInputCountryFieldWith(String country) {
        cartPage.inputCountry(country);
    }

    @Then("user input city field with {string}")
    public void userInputCityFieldWith(String city) {
        cartPage.inputCity(city);
    }

    @Then("user input credit card number with a dynamic value")
    public void userInputCreditCardNumberWithADynamicValue() {
        dynamicCCNumber = generateDynamicCCNumber();
        cartPage.inputCreditCard(dynamicCCNumber);
        System.out.printf(dynamicCCNumber);
    }

    @Then("user input month with {string}")
    public void userInputMonthWith(String month) {
        cartPage.inputMonth(month);
    }

    @Then("user input year with {string}")
    public void userInputYearWith(String year) {
        cartPage.inputYear(year);
    }

    @When("user click purchase button")
    public void userClickPurchaseButton() {
        cartPage.clickPurchaseButton();
    }

    //To create dynamic cc number
    private String generateDynamicCCNumber(){
        Random random = new Random();

        return String.format("%04d-%04d-%04d-%04d",
                random.nextInt(10000),
                random.nextInt(10000),
                random.nextInt(10000),
                random.nextInt(10000)
        );
    }
}
