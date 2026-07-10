package com.demowebshop.pages;

import com.demowebshop.utilities.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtility waitUtility;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitUtility = new WaitUtility(driver);
    }

    public void click(By locator) {
        waitUtility.waitForElementClickable(locator).click();
    }

    protected void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public String getText(By locator) {
        return waitUtility.waitForElementVisible(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        return waitUtility.waitForElementVisible(locator).isDisplayed();
    }
}
