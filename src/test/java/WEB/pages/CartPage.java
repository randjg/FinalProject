package WEB.pages;

import WEB.stepDef.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class CartPage extends BaseTest {

    WebDriver driver;
    public WebDriverWait wait;

    By placeOrderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    By nameInput = By.xpath("//*[@id=\"name\"]");
    By countryInput = By.xpath("//*[@id=\"country\"]");
    By cityInput = By.xpath("//*[@id=\"city\"]");
    By creditCardInput = By.xpath("//*[@id=\"card\"]");
    By monthInput = By.xpath("//*[@id=\"month\"]");
    By yearInput = By.xpath("//*[@id=\"year\"]");
    By purchaseButton = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");

    public CartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void validatePage(String pageTitle){
        assertTrue(driver.getPageSource().contains(pageTitle));
    }

    public void clickPlaceToOrderButton(){
        driver.findElement(placeOrderButton).click();
    }

    public void validateModality(String modalLabel){
        assertTrue(driver.getPageSource().contains(modalLabel));
    }

    public void inputName(String name){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        element.click();
        element.sendKeys(name);
    }

    public void inputCountry(String country){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(countryInput));
        element.click();
        element.sendKeys(country);
    }

    public void inputCity(String city){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(cityInput));
        element.click();
        element.sendKeys(city);
    }

    public void inputCreditCard(String creditCard){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(creditCardInput));
        element.click();
        element.sendKeys(creditCard);
    }

    public void inputMonth(String month){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(monthInput));
        element.click();
        element.sendKeys(month);
    }

    public void inputYear(String year){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(yearInput));
        element.click();
        element.sendKeys(year);
    }

    public void clickPurchaseButton(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(purchaseButton));
        element.click();
    }

}
