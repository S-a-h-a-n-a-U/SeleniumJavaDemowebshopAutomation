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

        System.out.println("Login Email    : " + TestData.email);
        System.out.println("Login Password : " + TestData.password);

        headerPage.clickLogin();

        loginPage.login(TestData.email, TestData.password);

        Assert.assertTrue(headerPage.isLogoutDisplayed());

        System.out.println("Login Successful");
    }
}