package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage {

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private final By successMessage =
            By.cssSelector(".section.order-completed .title");

    private final By orderNumber =
            By.xpath("//li[contains(text(),'Order number')]");

    public String getSuccessMessage() {
        return getText(successMessage);
    }

    public String getOrderNumber() {
        return getText(orderNumber);
    }
}