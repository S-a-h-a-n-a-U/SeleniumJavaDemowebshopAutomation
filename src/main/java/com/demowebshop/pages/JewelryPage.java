package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JewelryPage extends BasePage {

    public JewelryPage(WebDriver driver) {
        super(driver);
    }

    private final By productLinks =
            By.cssSelector(".product-title a");

    private final By compareButton =
            By.cssSelector("input[value='Add to compare list']");

    public String addProductToCompare(int index) {

        List<WebElement> products = driver.findElements(productLinks);

        String productName = products.get(index).getText();

        products.get(index).click();

        WebElement compare =
                driver.findElement(compareButton);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", compare);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().back();

        return productName;
    }
}