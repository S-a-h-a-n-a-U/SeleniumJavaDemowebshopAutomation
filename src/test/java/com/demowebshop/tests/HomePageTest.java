package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyRegisterNavigation() {

        HomePage homePage = new HomePage(driver);

        homePage.clickRegister();

        String expectedTitle = "Demo Web Shop. Register";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle,
                "Register page is not displayed.");

        System.out.println("Register page opened successfully.");
    }
}