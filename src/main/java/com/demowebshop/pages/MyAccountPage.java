package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    // My Account Link
    private final By myAccountLink =
            By.className("account");

    // Orders Link
    private final By ordersLink =
            By.linkText("Orders");

    public void openMyAccount() {
        click(myAccountLink);
    }

    public void openOrders() {
        click(ordersLink);
    }
}