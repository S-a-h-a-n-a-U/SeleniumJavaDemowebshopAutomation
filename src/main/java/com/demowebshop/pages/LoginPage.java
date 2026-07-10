package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By email = By.id("Email");
    private final By password = By.id("Password");
    private final By loginButton = By.cssSelector("input.login-button");
    private final By logoutLink = By.className("ico-logout");

    // Actions
    public void enterEmail(String userEmail) {
        type(email, userEmail);
    }

    public void enterPassword(String userPassword) {
        type(password, userPassword);
    }

    public void clickLogin() {
        click(loginButton);
    }

    // Business Method
    public void login(String userEmail, String userPassword) {
        enterEmail(userEmail);
        enterPassword(userPassword);
        clickLogin();
    }

    // Validation
    public boolean isLogoutDisplayed() {
        return isDisplayed(logoutLink);
    }
}