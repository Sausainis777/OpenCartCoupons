package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    By addToCartButton = By.cssSelector("#product-list [class='col mb-3']:nth-of-type(2) .button-group [type='submit']:nth-of-type(1)");


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

        var element = driver.findElement(cartButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);


    }
    public void viewCart(){
        driver.findElement(viewCart).click();
    }

    public void clickSearchButton(){
        driver.findElement(clickSearchButton).click();
    }
    public void addToCartButton(){
        var element = driver.findElement(addToCartButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

    }


    }


