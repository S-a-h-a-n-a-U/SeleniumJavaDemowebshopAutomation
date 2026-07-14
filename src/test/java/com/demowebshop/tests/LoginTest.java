package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.HeaderPage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin() {

        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        System.out.println("========== LOGIN TEST ==========");
        System.out.println("Login Email    : " + TestData.email);
        System.out.println("Login Password : " + TestData.password);

        // Open Login Page
        headerPage.clickLogin();

        // Login
        loginPage.login(TestData.email, TestData.password);

        // Verification
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

    }
}