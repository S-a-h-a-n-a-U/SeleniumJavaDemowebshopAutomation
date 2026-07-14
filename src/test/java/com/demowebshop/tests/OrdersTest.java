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

        System.out.println("========== ORDERS TEST ==========");

        // Login
        headerPage.clickLogin();
        loginPage.login(TestData.email, TestData.password);

        System.out.println("User Logged In Successfully");

        // Open My Account
        myAccountPage.openMyAccount();

        System.out.println("My Account Opened");

        // Open Orders
        myAccountPage.openOrders();

        System.out.println("Orders Page Opened");

        System.out.println("\n========== ORDER VERIFICATION ==========");

        Assert.assertTrue(
                ordersPage.isOrderDisplayed(),
                "No orders found."
        );

        System.out.println("Orders Available : PASSED");

        ordersPage.openLatestOrder();

        System.out.println("Latest Order Opened Successfully");

        System.out.println("Order History Verification : PASSED");
    }
}