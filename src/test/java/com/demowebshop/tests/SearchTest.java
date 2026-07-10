package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void verifyProductSearch() {

        SearchPage searchPage = new SearchPage(driver);

        searchPage.searchProduct("Laptop");

        Assert.assertTrue(searchPage.isProductDisplayed());

        String productName = searchPage.getProductName();

        System.out.println("Product Found : " + productName);

        System.out.println("Search Successful");
    }
}