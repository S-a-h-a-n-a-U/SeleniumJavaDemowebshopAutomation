package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By genderMale = By.id("gender-male");
    private final By firstName = By.id("FirstName");
    private final By lastName = By.id("LastName");
    private final By email = By.id("Email");
    private final By password = By.id("Password");
    private final By confirmPassword = By.id("ConfirmPassword");
    private final By registerButton = By.id("register-button");
    private final By successMessage = By.className("result");

    // Actions
    public void selectMaleGender() {
        click(genderMale);
    }

    public void enterFirstName(String fName) {
        type(firstName, fName);
    }

    public void enterLastName(String lName) {
        type(lastName, lName);
    }

    public void enterEmail(String mail) {
        type(email, mail);
    }

    public void enterPassword(String pwd) {
        type(password, pwd);
    }

    public void enterConfirmPassword(String pwd) {
        type(confirmPassword, pwd);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }

}