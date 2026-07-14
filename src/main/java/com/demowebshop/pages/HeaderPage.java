package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    // Header
    private final By registerLink = By.className("ico-register");
    private final By loginLink = By.className("ico-login");
    private final By logoutLink = By.className("ico-logout");
    private final By loggedInUserEmail = By.className("account");
    private final By wishlistLink = By.className("ico-wishlist");
    private final By shoppingCartLink = By.className("ico-cart");

    // Top Menu
    private final By jewelryMenu = By.linkText("Jewelry");

    // Footer
    private final By compareProductsLink = By.linkText("Compare products");

    public void clickRegister() {
        click(registerLink);
    }

    public void clickLogin() {
        click(loginLink);
    }

    public void clickLogout() {
        click(logoutLink);
    }

    public void clickWishlist() {
        click(wishlistLink);
    }

    public void clickShoppingCart() {
        click(shoppingCartLink);
    }

    public void clickJewelry() {
        click(jewelryMenu);
    }

    public void clickCompareProducts() {
        click(compareProductsLink);
    }

    public boolean isLogoutDisplayed() {
        return isDisplayed(logoutLink);
    }

    public boolean isLoginDisplayed() {
        return isDisplayed(loginLink);
    }

    public String getLoggedInUserEmail() {
        return getText(loggedInUserEmail);
    }
}