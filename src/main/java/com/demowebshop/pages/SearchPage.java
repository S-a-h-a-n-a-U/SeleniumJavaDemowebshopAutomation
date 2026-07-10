package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By searchBox = By.id("small-searchterms");
    private final By searchButton = By.cssSelector("input.search-box-button");
    private final By searchResult = By.className("product-title");
    private final By searchedProduct = By.className("product-title");

    // Actions
    public void enterSearchText(String product) {
        type(searchBox, product);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    // Business Method
    public void searchProduct(String product) {
        enterSearchText(product);
        clickSearchButton();
    }

    // Validation
    public boolean isProductDisplayed() {
        return isDisplayed(searchResult);

    }
    public String getProductName() {
        return getText(searchedProduct);
    }
}