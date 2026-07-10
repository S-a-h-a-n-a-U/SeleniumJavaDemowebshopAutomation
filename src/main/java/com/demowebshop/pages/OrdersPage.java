package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrdersPage extends BasePage {

    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    // Latest Order
    private final By orderTable =
            By.cssSelector(".order-list");

    private final By detailsButton =
            By.cssSelector("input[value='Details']");

    // Validations
    public boolean isOrderDisplayed() {
        return isDisplayed(orderTable);
    }

    public void openLatestOrder() {
        click(detailsButton);
    }
}