package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // ===========================
    // Shipping
    // ===========================

    private final By shippingAddressContinue =
            By.xpath("//input[@onclick='Shipping.save()']");

    private final By shippingMethodContinue =
            By.xpath("//input[@onclick='ShippingMethod.save()']");

    // ===========================
    // Billing Address
    // ===========================

    private final By billingAddressDropdown =
            By.id("billing-address-select");

    private final By country =
            By.id("BillingNewAddress_CountryId");

    private final By city =
            By.id("BillingNewAddress_City");

    private final By address1 =
            By.id("BillingNewAddress_Address1");

    private final By zip =
            By.id("BillingNewAddress_ZipPostalCode");

    private final By phone =
            By.id("BillingNewAddress_PhoneNumber");

    // ===========================
    // Continue Buttons
    // ===========================

    private final By billingContinue =
            By.xpath("//input[@onclick='Billing.save()']");

    private final By paymentMethodContinue =
            By.xpath("//input[@onclick='PaymentMethod.save()']");

    private final By paymentInfoContinue =
            By.xpath("//input[@onclick='PaymentInfo.save()']");

    private final By confirmOrder =
            By.xpath("//input[@onclick='ConfirmOrder.save()']");

    // ===========================
    // Actions
    // ===========================

    public void enterBillingAddress() throws InterruptedException {

        Select addressSelect = new Select(driver.findElement(billingAddressDropdown));

        // Multiple address scenario
        if (addressSelect.getOptions().size() > 2) {
            addressSelect.selectByIndex(2);   // Select second saved address
            return;
        }

        String selectedAddress =
                addressSelect.getFirstSelectedOption().getText();

        // Existing address already selected
        if (!selectedAddress.equalsIgnoreCase("New Address")) {
            return;
        }

        // First checkout - Fill New Address

        new Select(driver.findElement(country))
                .selectByVisibleText("India");

        Thread.sleep(1500);

        type(city, "Bangalore");
        type(address1, "MG Road");
        type(zip, "560001");
        type(phone, "9876543210");
    }

    public void continueBilling() {
        click(billingContinue);
    }

    public void continueShippingAddress() {
        click(shippingAddressContinue);
    }

    public void continueShippingMethod() {
        click(shippingMethodContinue);
    }

    public void continuePaymentMethod() {
        click(paymentMethodContinue);
    }

    public void continuePaymentInfo() {
        click(paymentInfoContinue);
    }

    public void confirmOrder() {
        click(confirmOrder);
    }
}