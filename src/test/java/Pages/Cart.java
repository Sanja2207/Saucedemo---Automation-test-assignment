package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement addToCartFirstItem;
    WebElement cartBadge;
    WebElement itemsDetailsPage;
    WebElement addToCartSecondItem;
    WebElement shoppingCart;
    WebElement titleOfFirstItem;
    WebElement titleOfSecondItem;
    WebElement removeButton;
    WebElement cartContainer;

    public Cart(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getAddToCartFirstItem() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public WebElement getCartBadge() {
        return driver.findElement(By.className("shopping_cart_badge"));
    }

    public WebElement getItemsDetailsPage() {
        return driver.findElement(By.id("item_0_title_link"));
    }

    public WebElement getAddToCartSecondItem() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
    }

    public WebElement getShoppingCart() {
        return driver.findElement(By.className("shopping_cart_link"));

    }

    public WebElement getTitleOfFirstItem() {
        return driver.findElement(By.linkText("Sauce Labs Backpack"));
    }

    public WebElement getTitleOfSecondItem() {
        return driver.findElement(By.linkText("Sauce Labs Bike Light"));
    }

    public WebElement getRemoveButton() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }

    public WebElement getCartContainer() {
        return driver.findElement(By.className("shopping_cart_container"));
    }

    //--------------------------------------------------------

    public void addFirstItemToTheCart() {
        this.getAddToCartFirstItem().click();
    }

    public void addSecondItemToTheCart() {

        this.getItemsDetailsPage().click();
        this.getAddToCartSecondItem().click();
    }

    public void openTheCart() {
        this.getShoppingCart().click();
    }

    public void removeTheFirstItemFromTheCart() {
        this.getRemoveButton().click();
    }

}
