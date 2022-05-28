package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout extends BasePage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement firstName;
    WebElement lastName;
    WebElement zipCode;
    WebElement checkoutButton;
    WebElement continueButton;
    WebElement finishButton;
    WebElement displayedMessage;


    public Checkout(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getFirstName() {
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getZipCode() {
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(By.id("checkout"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.id("continue"));
    }

    public WebElement getFinishButton() {
        return driver.findElement(By.id("finish"));
    }

    public WebElement getDisplayedMessage() {
        return driver.findElement(By.className("complete-header"));
    }

//--------------------------------------------------------


    public void completeTheCheckoutForm(String firstName, String lastName, String zipCode) {

        this.getFirstName().clear();
        this.getFirstName().sendKeys(firstName);
        this.getLastName().clear();
        this.getLastName().sendKeys(lastName);
        this.getZipCode().clear();
        this.getZipCode().sendKeys(zipCode);
    }

    public void continueToTheCheckoutPage() {
        this.getCheckoutButton().click();
    }

    public void completeTheOrder() {

        this.getContinueButton().click();
        this.getFinishButton().click();

    }
}

