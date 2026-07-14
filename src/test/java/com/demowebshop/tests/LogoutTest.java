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

        System.out.println("========== LOGOUT TEST ==========");
        System.out.println("Login Email    : " + TestData.email);
        System.out.println("Login Password : " + TestData.password);

        // Open Login Page
        headerPage.clickLogin();

        // Login
        loginPage.login(TestData.email, TestData.password);

        // Verify Login
        String expectedEmail = TestData.email;
        String actualEmail = headerPage.getLoggedInUserEmail();

        System.out.println("\n========== LOGIN VERIFICATION ==========");
        System.out.println("Expected Email : " + expectedEmail);
        System.out.println("Actual Email   : " + actualEmail);

        Assert.assertTrue(
                headerPage.isLogoutDisplayed(),
                "Logout link is not displayed."
        );

        Assert.assertEquals(
                actualEmail,
                expectedEmail,
                "Logged-in email does not match."
        );

        System.out.println("Logout Link Verification : PASSED");
        System.out.println("Email Verification       : PASSED");
        System.out.println("Login Successful");

        // Logout
        headerPage.clickLogout();

        // Verify Logout
        System.out.println("\n========== LOGOUT VERIFICATION ==========");

        String expectedLoginLink = "Displayed";
        String actualLoginLink = headerPage.isLoginDisplayed() ? "Displayed" : "Not Displayed";

        System.out.println("Expected Login Link : " + expectedLoginLink);
        System.out.println("Actual Login Link   : " + actualLoginLink);

        Assert.assertTrue(
                headerPage.isLoginDisplayed(),
                "Login link is not displayed after logout."
        );

        System.out.println("Login Link Verification : PASSED");
        System.out.println("Logout Successful");

    }
}