package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement username;
    WebElement password;
    WebElement loginButton;
    WebElement logout;
    WebElement burgerMenuButton;

    public Login(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public WebElement getLogout() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public WebElement getBurgerMenuButton() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    //--------------------------------------------------------

    public void Login(String username, String password) {
        getUsername().clear();
        getUsername().sendKeys(username);
        getPassword().clear();
        getPassword().sendKeys(password);
        getLoginButton().click();
    }

    public void clickOnBurgerMenuButton(){
        this.getBurgerMenuButton().click();
    }

}
