package Base;

import Pages.Cart;
import Pages.Checkout;
import Pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public Login login;
    public Cart cart;
    public Checkout checkout;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        login = new Login(driver, wdwait);
        cart = new Cart(driver, wdwait);
        checkout = new Checkout(driver, wdwait);

    }

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @AfterClass
    public void tearDown() throws IOException {

        driver.manage().deleteAllCookies();
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        driver.close();
        driver.quit();
    }

    //--------------------------------------------------------

    public void waiterElement(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waiterURL(String URL) {
        wdwait.until(ExpectedConditions.urlToBe(URL));
    }


}
