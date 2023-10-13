package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    By useCoupon = By.cssSelector("#accordion .accordion-item:nth-of-type(2) [data-bs-toggle]");

    By inputCoupons = By.cssSelector("#input-coupon");

    By clickToUseCoupon = By.cssSelector("form#form-coupon  .btn.btn-primary");

    By clearCart = By.cssSelector(".table-responsive .fa-circle-xmark");


    public CartPage(WebDriver driver) {
        this.driver = driver;


    }
    public void useCoupon(){

        var element = driver.findElement(useCoupon);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void inputMyCoupons(String name){
        driver.findElement(inputCoupons).sendKeys(name);

    }
    public void clickToUseCoupon(){
        var element = driver.findElement(clickToUseCoupon);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void clearCart(){
        driver.findElement(clearCart).click();
    }
}