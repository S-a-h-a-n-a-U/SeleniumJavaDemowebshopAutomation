package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.ComparePage;
import com.demowebshop.pages.HeaderPage;
import com.demowebshop.pages.JewelryPage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareTest extends BaseTest {

    @Test
    public void verifyCompareProducts() throws InterruptedException {

        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        JewelryPage jewelryPage = new JewelryPage(driver);
        ComparePage comparePage = new ComparePage(driver);

        System.out.println("========== COMPARE PRODUCTS TEST ==========");

        // Login
        headerPage.clickLogin();
        loginPage.login(TestData.email, TestData.password);

        System.out.println("User Logged In Successfully");

        // Open Jewelry
        headerPage.clickJewelry();

        System.out.println("Jewelry Category Opened");

        // Product 1
        String product1 = "Diamond Tennis Bracelet";

        jewelryPage.openDiamondBracelet();
        jewelryPage.addCurrentProductToCompare();

        System.out.println("Added Product : " + product1);

        Thread.sleep(1500);

        jewelryPage.goBack();

        // Product 2
        String product2 = "Vintage Style Ring";

        jewelryPage.openVintageRing();
        jewelryPage.addCurrentProductToCompare();

        System.out.println("Added Product : " + product2);

        Thread.sleep(1500);

        // Open Compare Products
        comparePage.openComparePage();

        System.out.println("\n========== COMPARE VERIFICATION ==========");

        Assert.assertTrue(
                comparePage.isDiamondBraceletDisplayed(),
                "Diamond Tennis Bracelet not found."
        );

        System.out.println(product1 + " : PASSED");

        Assert.assertTrue(
                comparePage.isVintageRingDisplayed(),
                "Vintage Style Ring not found."
        );

        System.out.println(product2 + " : PASSED");

        System.out.println("\nCompared Products:");
        System.out.println("1. " + product1);
        System.out.println("2. " + product2);

        System.out.println("Compare Products Verified Successfully");

    }
}