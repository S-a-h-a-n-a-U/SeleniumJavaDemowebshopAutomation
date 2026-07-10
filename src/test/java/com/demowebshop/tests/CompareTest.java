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

        // Login
        headerPage.clickLogin();
        loginPage.login(TestData.email, TestData.password);

        // Open Jewelry
        headerPage.clickJewelry();

        // Product 1
        jewelryPage.openDiamondBracelet();
        jewelryPage.addCurrentProductToCompare();

        Thread.sleep(1500);

        jewelryPage.goBack();

        // Product 2
        jewelryPage.openVintageRing();
        jewelryPage.addCurrentProductToCompare();

        Thread.sleep(1500);

        // Open Compare Products
        comparePage.openComparePage();

        // Validation
        Assert.assertTrue(comparePage.isDiamondBraceletDisplayed(),
                "Diamond Tennis Bracelet not found.");

        Assert.assertTrue(comparePage.isVintageRingDisplayed(),
                "Vintage Style Ring not found.");

        System.out.println("Compare Products Verified Successfully");
    }
}