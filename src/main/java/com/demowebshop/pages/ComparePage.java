package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;

public class ComparePage extends BasePage {

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    public void openComparePage() {

        driver.get("https://demowebshop.tricentis.com/compareproducts");
    }

    public boolean isProductDisplayed(String productName) {

        return driver.getPageSource().contains(productName);
    }
}