package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.HeaderPage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.WishlistPage;
import com.demowebshop.utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditWishlistTest extends BaseTest {

    @Test
    public void verifyWishlistEdit() {

        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);

        // Login
        headerPage.clickLogin();
        loginPage.login(TestData.email, TestData.password);

        // Open Wishlist
        wishlistPage.openWishlist();

        // Update Quantity
        wishlistPage.updateThirdAlbumQuantity("5");

        // Click Update Wishlist
        wishlistPage.clickUpdateWishlist();

        // Validate Quantity
        Assert.assertEquals(
                wishlistPage.getThirdAlbumQuantity(),
                "5",
                "Wishlist quantity was not updated."
        );

        System.out.println("Wishlist Updated Successfully");
    }
}
