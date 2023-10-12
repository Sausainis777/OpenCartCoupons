import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.LoginPage;
import org.example.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CouponsTest {
    WebDriver driver;

    @BeforeAll
    static void driverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void driver() {

        driver = new ChromeDriver();
        driver.get("http://192.168.8.129/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/Cupons.csv")
    void coupons(String number, String discount, String kind) throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginpage = new LoginPage(driver);


        loginpage.clickMyAccount();
        loginpage.clickLogin();

        loginpage.setLoginEmail("tomas3@gmail.com");
        loginpage.setLoginPassWord("Tomas");
        loginpage.clickToLogin();
        Thread.sleep(2000);





        mainPage.inputSearchField("Palm Treo Pro");
        mainPage.clickSearchButton();
        Thread.sleep(3000);



        driver.findElement(By.cssSelector("#product-list [class='col mb-3']:nth-of-type(2) .button-group [type='submit']:nth-of-type(1)")).click();
        Thread.sleep(2000);
        mainPage.clickCartButton();
        mainPage.viewCart();
        mainPage.useCoupon();
        mainPage.inputMyCoupons(number, discount, kind);


    }
}