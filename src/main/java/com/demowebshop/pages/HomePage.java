package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By registerLink = By.className("ico-register");
    private final By loginLink = By.className("ico-login");
    private final By wishlistLink = By.className("ico-wishlist");
    private final By cartLink = By.className("ico-cart");

    // Actions
    public void clickRegister() {
        click(registerLink);
    }

    public void clickLogin() {
        click(loginLink);
    }

    public void clickWishlist() {
        click(wishlistLink);
    }

    public void clickShoppingCart() {
        click(cartLink);
    }
}
