package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchApplicationTest extends BaseTest {

    @Test
    public void verifyHomePageTitle() {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Demo Web Shop";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Page Title Verified Successfully.");
    }
}