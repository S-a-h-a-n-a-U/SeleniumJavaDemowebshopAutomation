package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By termsCheckbox =
            By.id("termsofservice");

    private final By checkoutButton =
            By.id("checkout");

    public void acceptTerms() {
        click(termsCheckbox);
    }

    public void clickCheckout() {
        click(checkoutButton);
    }

}