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
    public void verifyCompareProducts() {

        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        JewelryPage jewelryPage = new JewelryPage(driver);
        ComparePage comparePage = new ComparePage(driver);

        System.out.println("========== COMPARE PRODUCTS TEST ==========");

        headerPage.clickLogin();
        loginPage.login(TestData.email, TestData.password);

        System.out.println("Login Successful");

        headerPage.clickJewelry();

        System.out.println("Jewelry Page Opened");

        String product1 = jewelryPage.addProductToCompare(0);
        System.out.println(product1 + " added");

        String product2 = jewelryPage.addProductToCompare(1);
        System.out.println(product2 + " added");

        comparePage.openComparePage();

        Assert.assertTrue(comparePage.isProductDisplayed(product1),
                product1 + " not found.");

        Assert.assertTrue(comparePage.isProductDisplayed(product2),
                product2 + " not found.");

        System.out.println("Compare Test Passed");
    }
}