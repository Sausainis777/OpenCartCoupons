package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckDiscount {
    WebDriver driver;
    By subTotal = By.cssSelector("tfoot#checkout-total > tr:nth-of-type(1) > td:nth-of-type(2)");
    By coupon = By.cssSelector("#checkout-total tr:nth-of-type(2) .text-end:nth-of-type(2)");
    By ecoTax = By.cssSelector("tfoot#checkout-total > tr:nth-of-type(3) > td:nth-of-type(2)");
    By vat = By.cssSelector("tfoot#checkout-total > tr:nth-of-type(4) > td:nth-of-type(2)");

    By total = By.xpath("//tfoot[@id='checkout-total']/tr[5]/td[2]");

    public CheckDiscount(WebDriver driver) {
        this.driver = driver;
    }

    public String subTotal() {
        return driver.findElement(subTotal).getText();
    }

    public String coupon() {
        return driver.findElement(coupon).getText();
    }

    public String ecoTax() {
        return driver.findElement(ecoTax).getText();
    }

    public String vat() {
        return driver.findElement(vat).getText();
    }
public String total(){
        return driver.findElement(total).getText();
}

}

