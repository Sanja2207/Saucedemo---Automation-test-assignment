package Test;

import Base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCheckout extends BasePage {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com");
        login.Login("standard_user", "secret_sauce");
        cart.addFirstItemToTheCart();
        cart.openTheCart();
    }

    /**
     * Preconditions: user is successfully logged in and at least one item is added to the cart.
     * <p>
     * 1. Continue to the Checkout page by clicking on the 'CHECKOUT' button
     * 2. Fill in the form by entering a first name, last name and postal code in the provided textboxes
     * 3. Click on button 'CONTINUE' in the bottom right corner
     * 4. Click on button 'FINISH' in the bottom right corner
     * 5. Assert that the order is completed successfully with the displayed message "Thank you for your order"
     * <p>
     * Test parameters:
     * firstName : "Myname"
     * lastName : "Mylastname"
     * postal code : "21000"
     **/

    @Test
    public void checkoutTest() {
        checkout.continueToTheCheckoutPage();

        checkout.completeTheCheckoutForm("Myname", "Mylastname", "21000");

        checkout.completeTheOrder();

        String successfulPurchaseMSG = checkout.getDisplayedMessage().getText();
        Assert.assertEquals(successfulPurchaseMSG, "THANK YOU FOR YOUR ORDER");


    }
}
