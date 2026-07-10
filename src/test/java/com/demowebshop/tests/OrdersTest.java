package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.HeaderPage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.MyAccountPage;
import com.demowebshop.pages.OrdersPage;
import com.demowebshop.utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrdersTest extends BaseTest {

    @Test
    public void verifyOrdersInMyAccount() {

        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        OrdersPage ordersPage = new OrdersPage(driver);

        // Login
        headerPage.clickLogin();
        loginPage.login(TestData.email, TestData.password);

        // Open My Account
        myAccountPage.openMyAccount();

        // Open Orders
        myAccountPage.openOrders();

        // Validation
        Assert.assertTrue(
                ordersPage.isOrderDisplayed(),
                "No orders found.");

        System.out.println("Orders are displayed successfully.");

    }
}