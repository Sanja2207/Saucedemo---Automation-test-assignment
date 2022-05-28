package Test;

import Base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogIn extends BasePage {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }

    /**
     * • Test Case Standard User
     * This test case verifies login functionality by entering registered username and password.
     * 1. Go to www.saucedemo.com
     * 2. Enter registered username
     * 3. Enter registered password
     * 4. Click on Login button
     * 5. Assert that the login was successful
     * <p>
     * Test parameters:
     * username : "standard_username"
     * password : "secret_sauce"
     **/

    @Test
    public void testStandardUser() {

        login.Login("standard_user", "secret_sauce");

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        login.clickOnBurgerMenuButton();

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(login.getLogout().isDisplayed());
    }
}
