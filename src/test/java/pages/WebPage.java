package pages;

import org.openqa.selenium.By;

import java.util.Objects;

import static helper.Utility.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class WebPage {

    By input_username = By.id("user-name");
    By input_pwd = By.id("password");
    By btn_login = By.id("login-button");
    By icon_cart = By.xpath("//*[@class=\"shopping_cart_link\"]");
    By icon_cart_item = By.xpath("//span[@class=\"shopping_cart_badge\"]");
    By addItem = By.xpath("(//*[text () = 'Add to cart'])[1]");
    By removeItem = By.xpath("(//*[text () = 'Remove'])[1]");
    By sortItem = By.xpath("//select");
    By sortItemHilo = By.xpath("//option[@value=\"hilo\"]");
    By sortItemZtoA = By.xpath("//option[@value=\"za\"]");
    By firstItem = By.xpath("(//*[@class=\"inventory_item_name \"])[1]");

    By err_msg(String errmsg) {
        return By.xpath("//*[contains(text(),' " + errmsg + "')]");
    }

    public void goToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username) {
        driver.findElement(input_username).sendKeys(username);
    }

    public void inputPassword(String pwd) {
        driver.findElement(input_pwd).sendKeys(pwd);
    }

    public void clickBtnLogin() {
        driver.findElement(btn_login).click();
        ;
    }

    public void verifyIconCart() {
        driver.findElement(icon_cart).isDisplayed();
    }

    public void verifyErrMsg(String errMsg) {
        driver.findElement(err_msg(errMsg)).isDisplayed();
    }

    public void itemAddToCart() {
        driver.findElement(addItem).click();
    }

    public void itemRemoveToCart() {
        driver.findElement(removeItem).click();
    }

    public void verifyItemCart(String itemExpected) {
        String itemActual = driver.findElement(icon_cart_item).getText();
        assertThat(itemActual).isEqualTo(itemExpected);
    }

    public void clickSortItemHighToLow() {
        String itemBefore, itemAfter;

        itemBefore = driver.findElement(firstItem).getText();
        driver.findElement(sortItem).click();
        driver.findElement(sortItemHilo).click();
        itemAfter = driver.findElement(firstItem).getText();

        assertThat(itemBefore).isNotEqualTo(itemAfter);
    }

    public void clickSortItemZtoA() {
        String itemBefore, itemAfter;

        itemBefore = driver.findElement(firstItem).getText();
        driver.findElement(sortItem).click();
        driver.findElement(sortItemZtoA).click();
        itemAfter = driver.findElement(firstItem).getText();

        assertThat(itemBefore).isNotEqualTo(itemAfter);
    }
}
