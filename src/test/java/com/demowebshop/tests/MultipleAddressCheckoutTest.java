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

        System.out.println("========== MULTIPLE ADDRESS CHECKOUT TEST ==========");

        // Login
        headerPage.clickLogin();
        loginPage.login(TestData.email, TestData.password);

        System.out.println("User Logged In Successfully");

        // Open Addresses
        myAccountPage.openMyAccount();
        addressPage.openAddresses();

        System.out.println("Address Page Opened");

        // Add Second Address
        addressPage.clickAddNew();
        addressPage.addSecondAddress();
        addressPage.saveAddress();

        System.out.println("Second Address Added Successfully");

        Thread.sleep(2000);

        // Open Books
        driver.get("https://demowebshop.tricentis.com/books");
        Thread.sleep(2000);

        booksPage.openComputingBook();

        // Add Product
        productPage.clickAddToCart();
        productPage.waitForNotificationToDisappear();

        System.out.println("Book Added To Cart");

        // Shopping Cart
        headerPage.clickShoppingCart();

        cartPage.acceptTerms();
        cartPage.clickCheckout();

        // Checkout
        checkoutPage.enterBillingAddress();

        System.out.println("Billing Address Selected Successfully");

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

        String successMessage = orderConfirmationPage.getSuccessMessage();
        String orderNumber = orderConfirmationPage.getOrderNumber();

        System.out.println("\n========== ORDER VERIFICATION ==========");

        System.out.println("Expected Message : Your order has been successfully processed!");
        System.out.println("Actual Message   : " + successMessage);

        Assert.assertTrue(
                successMessage.contains("successfully processed"),
                "Checkout failed."
        );

        System.out.println("Checkout Verification : PASSED");

        System.out.println("\nExpected : Order Number should be generated");
        System.out.println("Actual   : " + orderNumber);

        Assert.assertFalse(
                orderNumber.isEmpty(),
                "Order number was not generated."
        );

        System.out.println("Order Number Verification : PASSED");
        System.out.println("Checkout with Multiple Address Passed");

    }
}