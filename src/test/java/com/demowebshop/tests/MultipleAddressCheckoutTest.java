package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.*;
import com.demowebshop.utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleAddressCheckoutTest extends BaseTest {

    @Test
    public void verifyCheckoutWithMultipleAddress() throws InterruptedException {

        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        AddressPage addressPage = new AddressPage(driver);
        BooksPage booksPage = new BooksPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        // Login
        headerPage.clickLogin();
        loginPage.login(TestData.email, TestData.password);

        // Open Addresses
        myAccountPage.openMyAccount();
        addressPage.openAddresses();

        // Add Second Address
        addressPage.clickAddNew();
        addressPage.addSecondAddress();
        addressPage.saveAddress();

        Thread.sleep(2000);

        // Open Books
        driver.get("https://demowebshop.tricentis.com/books");
        Thread.sleep(2000);
        booksPage.openComputingBook();

        // Add Product
        productPage.clickAddToCart();
        productPage.waitForNotificationToDisappear();

        // Shopping Cart
        headerPage.clickShoppingCart();

        cartPage.acceptTerms();
        cartPage.clickCheckout();

        // Checkout
        checkoutPage.enterBillingAddress();
        checkoutPage.continueBilling();

        Thread.sleep(2000);

        checkoutPage.continueShippingAddress();

        Thread.sleep(2000);

        checkoutPage.continueShippingMethod();

        Thread.sleep(2000);

        checkoutPage.continuePaymentMethod();

        Thread.sleep(2000);

        checkoutPage.continuePaymentInfo();

        Thread.sleep(2000);

        checkoutPage.confirmOrder();

        Thread.sleep(3000);

        Assert.assertTrue(
                orderConfirmationPage.getSuccessMessage()
                        .contains("successfully processed"));

        System.out.println("======================================");
        System.out.println("Checkout with Multiple Address Passed");
        System.out.println(orderConfirmationPage.getOrderNumber());
        System.out.println("======================================");
    }
}