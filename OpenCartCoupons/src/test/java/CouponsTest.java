import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.CartPage;
import org.example.CheckDiscount;
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
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CouponsTest {
    WebDriver driver;

    @BeforeAll
    static void driverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void driver() {

        driver = new ChromeDriver();
        driver.get("http://192.168.8.132/en-gb?route=common/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterEach
    void teardown() {
//        driver.quit();
    }

    public int getNumber(String text) {
        
        return Integer.parseInt(text);

    }


    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/Cupons.csv")
    void coupons(String number, int value, String type) throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginpage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckDiscount checkPrice = new CheckDiscount(driver);


        loginpage.clickMyAccount();
        loginpage.clickLogin();

        loginpage.setLoginEmail("tomas3@gmail.com");
        loginpage.setLoginPassWord("Tomas");
        loginpage.clickToLogin();
        Thread.sleep(2000);

        mainPage.inputSearchField("Palm Treo Pro");
        mainPage.clickSearchButton();


        mainPage.addToCartButton();
        Thread.sleep(2000);

        mainPage.clickCartButton();
        mainPage.viewCart();

        cartPage.useCoupon();


        cartPage.inputMyCoupons(number);
        Thread.sleep(2000);

        cartPage.clickToUseCoupon();


        Thread.sleep(3000);

        int subTotal = getNumber(checkPrice.subTotal().replace("$", "").replace(".", "").replace(",", ""));

        String formattedValue = "";
        String formattedPercentage = "";


        if (type.equalsIgnoreCase("FLAT")) {
            formattedValue = String.format(Locale.US, "$%.2f", -value * 1.0);
            assertEquals(formattedValue, driver.findElement(By.xpath("//tfoot[@id='checkout-total']/tr[2]/td[2]")).getText());

        } else if (type.equalsIgnoreCase("PERCENTAGE")) {
            formattedPercentage = String.format(Locale.US, "$%.2f", -subTotal * 10 / 10000.0);
            assertEquals(formattedPercentage, driver.findElement(By.xpath("//tfoot[@id='checkout-total']/tr[2]/td[2]")).getText());
        }

        int coupon = getNumber(checkPrice.coupon().replace("$", "").replace(".", ""));
        int ecoTax = getNumber(checkPrice.ecoTax().replace("$", "").replace(".", ""));
        int vat = getNumber(checkPrice.vat().replace("$", "").replace(".", ""));
        int total = getNumber(checkPrice.total().replace("$", "").replace(".", ""));
        int totalSum = subTotal + coupon + ecoTax + vat;
        assertEquals(total, totalSum);


        cartPage.clearCart();
        driver.quit();
    }


}