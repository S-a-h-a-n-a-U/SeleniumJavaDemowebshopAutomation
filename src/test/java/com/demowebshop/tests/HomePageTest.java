
package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyRegisterNavigation() {

        HomePage homePage = new HomePage(driver);

        homePage.clickRegister();

        System.out.println("Register link clicked successfully.");
    }
}