package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.*;
import com.demowebshop.utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyOrderCreation() throws InterruptedException {

        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        BooksPage booksPage = new BooksPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        // Login
        headerPage.clickLogin();
        loginPage.login(TestData.email, TestData.password);

        // Open Books
        booksPage.openBooks();
        booksPage.openComputingBook();

        // Add Book to Cart
        productPage.clickAddToCart();
        productPage.waitForNotificationToDisappear();

        // Open Shopping Cart
        headerPage.clickShoppingCart();

        // Accept Terms & Checkout
        cartPage.acceptTerms();
        cartPage.clickCheckout();

        // Billing Address
        checkoutPage.enterBillingAddress();
        checkoutPage.continueBilling();

        Thread.sleep(2000);

// Shipping Address
        checkoutPage.continueShippingAddress();

        Thread.sleep(2000);

// Shipping Method
        checkoutPage.continueShippingMethod();

        Thread.sleep(2000);

// Payment Method
        checkoutPage.continuePaymentMethod();

        Thread.sleep(2000);

// Payment Information
        checkoutPage.continuePaymentInfo();

        Thread.sleep(2000);

        Thread.sleep(2000);

        // Confirm Order
        checkoutPage.confirmOrder();

        Thread.sleep(3000);

        // Validation
        Assert.assertTrue(
                orderConfirmationPage.getSuccessMessage()
                        .contains("successfully processed"),
                "Order creation failed.");

        System.out.println("==================================");
        System.out.println(orderConfirmationPage.getSuccessMessage());
        System.out.println(orderConfirmationPage.getOrderNumber());
        System.out.println("==================================");
    }
}