package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.HeaderPage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void verifySuccessfulLogout() {

        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Click Login
        headerPage.clickLogin();

        // Login with valid credentials
        loginPage.login(TestData.email, TestData.password);

        // Verify Logout link is displayed
        Assert.assertTrue(headerPage.isLogoutDisplayed(),
                "Login failed. Logout link is not displayed.");

        // Logout
        headerPage.clickLogout();

        // Verify Login link is displayed again
        Assert.assertTrue(headerPage.isLoginDisplayed(),
                "Logout failed. Login link is not displayed.");

        System.out.println("Logout Successful");
    }
}