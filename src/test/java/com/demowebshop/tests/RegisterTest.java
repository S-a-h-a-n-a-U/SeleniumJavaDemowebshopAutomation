package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.HeaderPage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void verifyUserRegistration() {

        HeaderPage headerPage = new HeaderPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        String email = TestData.getRandomEmail();

        headerPage.clickRegister();

        registerPage.selectMaleGender();
        registerPage.enterFirstName("John");
        registerPage.enterLastName("Smith");
        registerPage.enterEmail(email);
        registerPage.enterPassword(TestData.password);
        registerPage.enterConfirmPassword(TestData.password);

        registerPage.clickRegisterButton();

        Assert.assertEquals(registerPage.getSuccessMessage(),
                "Your registration completed");

        System.out.println("Registered Email : " + email);
        System.out.println("Password         : " + TestData.password);
    }
}