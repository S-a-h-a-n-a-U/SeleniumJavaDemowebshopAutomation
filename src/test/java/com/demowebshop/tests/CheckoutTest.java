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

        System.out.println("========== CHECKOUT TEST ==========");

        // Login
        headerPage.clickLogin();
        loginPage.login(TestData.email, TestData.password);

        System.out.println("User Logged In Successfully");

        // Open Books
        booksPage.openBooks();
        booksPage.openComputingBook();

        System.out.println("Book Selected Successfully");

        // Add Book to Cart
        productPage.clickAddToCart();
        productPage.waitForNotificationToDisappear();

        System.out.println("Book Added To Cart");

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

        // Confirm Order
        checkoutPage.confirmOrder();

        Thread.sleep(3000);

        String successMessage = orderConfirmationPage.getSuccessMessage();
        String orderNumber = orderConfirmationPage.getOrderNumber();

        System.out.println("\n========== ORDER VERIFICATION ==========");
        System.out.println("Expected Message : Your order has been successfully processed!");
        System.out.println("Actual Message   : " + successMessage);

        Assert.assertTrue(
                successMessage.contains("successfully processed"),
                "Order creation failed."
        );

        System.out.println("Order Success Message : PASSED");

        System.out.println("\nExpected : Order Number should be generated");
        System.out.println("Actual   : " + orderNumber);

        Assert.assertFalse(
                orderNumber.isEmpty(),
                "Order number was not generated."
        );

        System.out.println("Order Number Verification : PASSED");

        System.out.println("\nCheckout Successful");

    }
}