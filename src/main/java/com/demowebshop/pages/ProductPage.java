package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Generic Buttons
    private final By addToWishlistButton =
            By.cssSelector("input[value='Add to wishlist']");

    private final By addToCompareButton =
            By.cssSelector("input[value='Add to compare list']");

    private final By addToCartButton =
            By.cssSelector("input[value='Add to cart']");

    // Notification
    private final By successMessage =
            By.cssSelector("p.content");

    private final By successBar =
            By.id("bar-notification");

    // ==========================
    // Actions
    // ==========================

    public void clickAddToWishlist() {
        click(addToWishlistButton);
    }

    public void clickAddToCompare() {
        click(addToCompareButton);
    }

    public void clickAddToCart() {
        click(addToCartButton);
    }

    // ==========================
    // Validations
    // ==========================

    public String getSuccessMessage() {
        return getText(successMessage);
    }

    public String getWishlistSuccessMessage() {
        return getText(successMessage);
    }

    // ==========================
    // Wait
    // ==========================

    public void waitForNotificationToDisappear() {
        try {
            waitUtility.waitForElementInvisible(successBar);
        } catch (Exception e) {
            // Ignore if notification disappears automatically
        }
    }
}