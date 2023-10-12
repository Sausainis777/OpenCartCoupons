package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {
    WebDriver driver;
    By clickMyAccount = By.cssSelector(".list-inline-item:nth-of-type(2) .d-md-inline");
    By clickRegister = By.linkText("Register");
    By searchField = By.cssSelector(".form-control-lg");
    By clickSearchButton = By.cssSelector(".btn-light");
    By cartButton = By.cssSelector(".btn-inverse");
    By viewCart = By.cssSelector("p > a:nth-of-type(1) > strong");
    By useCoupon = By.cssSelector("#accordion .accordion-item:nth-of-type(2) [data-bs-toggle]");

    By inputCoupons = By.cssSelector("#input-coupon");

    public MainPage(WebDriver driver) {
        this.driver = driver;

    }

    public void clickMyAccount(){
        driver.findElement(clickMyAccount).click();
    }
    public void clickRegister(){
        driver.findElement(clickRegister).click();
    }
    public void inputSearchField(String search){
        driver.findElement(searchField).sendKeys(search);
    }
    public void clickCartButton(){
        WebElement element = driver.findElement(cartButton);
                Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();


    }
    public void viewCart(){
        driver.findElement(viewCart).click();
    }
    public void useCoupon(){
        driver.findElement(useCoupon).click();
    }
    public void inputMyCoupons(String name, String discount, String kind){
        driver.findElement(inputCoupons).sendKeys(name, discount, kind);

    }
    public void clickSearchButton(){
        driver.findElement(clickSearchButton).click();
    }


    }


