package Test;

import Base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCart extends BasePage {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com");
        login.Login("standard_user", "secret_sauce");
    }

    /**
     * Precondition: User is successfully logged in.
     * <p>
     * 1. Open the https://www.saucedemo.com/inventory.html page
     * 2. Navigate to the first item 'Sauce Labs Backpack' and click on 'ADD TO CART' button in its description box
     * 3. Verify that the cart badge is updated correctly
     * 4. Open 'Sauce Labs Bike Light' details page
     * 5. Add the item to the cart by clicking on the 'ADD TO CART' button
     * 6. Open the cart by clicking on the cart-icon in the top right corner
     * 7. Verify that the correct items are present (2 different items)
     * 8. Remove the first item from the cart by clicking on the 'Remove' button
     * 9. Verify that the correct item is present (1 item)
     */

    @Test
    public void cartTest() {

        waiterURL("https://www.saucedemo.com/inventory.html");

        cart.addFirstItemToTheCart();

        String cartBadgeIsUpdatedCorrectly = cart.getCartBadge().getText();
        Assert.assertEquals(cartBadgeIsUpdatedCorrectly, "1");

        cart.addSecondItemToTheCart();

        cart.openTheCart();

        Assert.assertTrue(cart.getTitleOfFirstItem().isDisplayed());
        Assert.assertTrue(cart.getTitleOfSecondItem().isDisplayed());

        cart.removeTheFirstItemFromTheCart();

        String correctCartValue = cart.getCartContainer().getText();
        Assert.assertEquals(correctCartValue, "1");
        Assert.assertTrue(cart.getTitleOfSecondItem().isDisplayed());


    }
}
