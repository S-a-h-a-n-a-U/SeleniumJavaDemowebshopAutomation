package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void verifyProductSearch() {

        SearchPage searchPage = new SearchPage(driver);

        String searchKeyword = "Laptop";

        System.out.println("========== PRODUCT SEARCH TEST ==========");
        System.out.println("Search Keyword : " + searchKeyword);

        searchPage.searchProduct(searchKeyword);

        Assert.assertTrue(
                searchPage.isProductDisplayed(),
                "No product is displayed."
        );

        String productName = searchPage.getProductName();

        System.out.println("\n========== SEARCH VERIFICATION ==========");
        System.out.println("Expected Keyword : " + searchKeyword);
        System.out.println("Actual Product   : " + productName);

        Assert.assertTrue(
                productName.toLowerCase().contains(searchKeyword.toLowerCase()),
                "Displayed product does not match the searched keyword."
        );

        System.out.println("Product Verification : PASSED");
        System.out.println("Search Successful");
        System.out.println("=========================================");
    }
}