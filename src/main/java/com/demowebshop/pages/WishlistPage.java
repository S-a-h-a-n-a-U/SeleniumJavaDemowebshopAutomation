package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage {

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By wishlistLink = By.className("ico-wishlist");
    private final By thirdAlbum =
            By.xpath("//td[@class='product']//a[text()='3rd Album']");
    // Quantity textbox for 3rd Album
    private final By thirdAlbumQty = By.xpath("//a[text()='3rd Album']/../../td[@class='qty nobr']/input");

    // Update Wishlist button
    private final By updateWishlistButton = By.name("updatecart");

    // Actions
    public void openWishlist() {
        click(wishlistLink);
    }

    // Validation
    public boolean isThirdAlbumDisplayed() {
        return isDisplayed(thirdAlbum);
    }
    public void updateThirdAlbumQuantity(String qty) {
        type(thirdAlbumQty, qty);
    }

    public void clickUpdateWishlist() {
        click(updateWishlistButton);
    }

    public String getThirdAlbumQuantity() {
        return driver.findElement(thirdAlbumQty).getAttribute("value");
    }
}