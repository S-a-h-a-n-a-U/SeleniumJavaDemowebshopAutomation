package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.DigitalDownloadsPage;
import com.demowebshop.pages.HeaderPage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.ProductPage;
import com.demowebshop.pages.WishlistPage;
import com.demowebshop.utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {

    @Test
    public void verifyWishlistCreation() {

        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        DigitalDownloadsPage digitalDownloadsPage = new DigitalDownloadsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);

        // Login
        headerPage.clickLogin();
        loginPage.login(TestData.email, TestData.password);

        // Open Digital Downloads
        digitalDownloadsPage.openDigitalDownloads();

        // Open Product
        digitalDownloadsPage.openThirdAlbum();

        // Add to Wishlist
        // Add to Wishlist
        productPage.clickAddToWishlist();

// Verify success message
        Assert.assertTrue(
                productPage.getWishlistSuccessMessage().contains("The product has been added"),
                "Wishlist success message not displayed."
        );

// Open Wishlist
        wishlistPage.openWishlist();

        // Validate Product
        Assert.assertTrue(
                wishlistPage.isThirdAlbumDisplayed(),
                "3rd Album is not present in Wishlist."
        );

        System.out.println("Wishlist Created Successfully");
    }
}