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

        System.out.println("========== EDIT WISHLIST TEST ==========");

        // Login
        headerPage.clickLogin();
        loginPage.login(TestData.email, TestData.password);

        System.out.println("User Logged In Successfully");

        // Open Wishlist
        wishlistPage.openWishlist();

        System.out.println("Wishlist Opened");

        // Update Quantity
        String expectedQuantity = "5";

        wishlistPage.updateThirdAlbumQuantity(expectedQuantity);
        wishlistPage.clickUpdateWishlist();

        String actualQuantity = wishlistPage.getThirdAlbumQuantity();

        System.out.println("\n========== WISHLIST VERIFICATION ==========");
        System.out.println("Expected Quantity : " + expectedQuantity);
        System.out.println("Actual Quantity   : " + actualQuantity);

        Assert.assertEquals(
                actualQuantity,
                expectedQuantity,
                "Wishlist quantity was not updated."
        );

        System.out.println("Quantity Verification : PASSED");

        // Refresh page to verify persistence
        driver.navigate().refresh();

        wishlistPage.openWishlist();

        String quantityAfterRefresh = wishlistPage.getThirdAlbumQuantity();

        System.out.println("\nQuantity After Refresh : " + quantityAfterRefresh);

        Assert.assertEquals(
                quantityAfterRefresh,
                expectedQuantity,
                "Wishlist quantity did not persist after refresh."
        );

        System.out.println("Persistence Verification : PASSED");
        System.out.println("Wishlist Updated Successfully");

    }
}
