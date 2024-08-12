package WEB.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePage{

    WebDriver driver;
    public WebDriverWait wait;

    By signUpButton = By.xpath("//*[@id=\"signin2\"]");
    By userNameSignUpInput = By.xpath("//*[@id=\"sign-username\"]");
    By passwordSignUpInput = By.xpath("//*[@id=\"sign-password\"]");
    By registerButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    By loginButton = By.xpath("//*[@id=\"login2\"]");
    By userNameLoginInput = By.xpath("//*[@id=\"loginusername\"]");
    By passwordLoginInput = By.xpath("//*[@id=\"loginpassword\"]");
    By loginButtonModal = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    By logoutButton = By.xpath("//*[@id=\"logout2\"]");
    By productTitle = By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a");
    By addToCartButton = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    By cartButton = By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a");
    By aboutUsButton = By.xpath("//*[@id=\"navbarExample\"]/ul/li[3]/a");
    By playButton = By.xpath("//*[@id=\"example-video\"]/div[1]");
    By contactButton = By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a");
    By emailInput = By.xpath("//*[@id=\"recipient-email\"]");
    By nameInput = By.xpath("//*[@id=\"recipient-name\"]");
    By messageInput = By.xpath("//*[@id=\"message-text\"]");
    By sendMessageButton = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]");

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToHomePage(){
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void clickSignUpButton(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        element.click();
    }

    public void inputUsernameSignUp(String username){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(userNameSignUpInput));
        element.click();
        element.sendKeys(username);
    }

    public void inputPasswordSignUp(String password){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(passwordSignUpInput));
        element.click();
        element.sendKeys(password);
    }

    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    public void validateMessage(String expectedMessage){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = alert.getText();
        assertEquals("The pop-up message is incorrect!", expectedMessage, actualMessage);
        alert.accept();
    }

    public void clickLoginButton(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        element.click();
    }

    public void inputUsernameLogin(String username){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(userNameLoginInput));
        element.click();
        element.sendKeys(username);
    }

    public void inputPasswordLogin(String password){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(passwordLoginInput));
        element.click();
        element.sendKeys(password);
    }

    public void clickLoginButtonModal(){
        driver.findElement(loginButtonModal).click();
    }

    public void validateLogin(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        assertTrue(true);
    }

    public void clickProduct(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(productTitle));
        assertTrue(element.isDisplayed());
        assertEquals("Samsung galaxy s6", element.getText());
        element.click();
    }

    public void clickAddToCartButton(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        element.click();
    }

    public void dismissAlert(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public void clickCartButton(){
        driver.findElement(cartButton).click();
    }

    public void clickAboutUsButton(){
        driver.findElement(aboutUsButton).click();
    }

    public void clickPlayVideo(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(playButton));
        element.click();
    }

    public void clickContactButton(){
        driver.findElement(contactButton).click();
    }

    public void inputEmail(String email){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        element.click();
        element.sendKeys(email);
    }

    public void inputName(String name){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        element.click();
        element.sendKeys(name);
    }

    public void messageInput(String message){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(messageInput));
        element.click();
        element.sendKeys(message);
    }

    public void clickSendMessageButton(){
        driver.findElement(sendMessageButton).click();
    }

}
