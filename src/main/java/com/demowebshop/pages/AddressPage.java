package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.demowebshop.utilities.TestData;

public class AddressPage extends BasePage {

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By addressesLink = By.linkText("Addresses");
    private final By addNewButton = By.cssSelector("input[value='Add new']");

    private final By country = By.id("Address_CountryId");
    private final By city = By.id("Address_City");
    private final By address1 = By.id("Address_Address1");
    private final By zip = By.id("Address_ZipPostalCode");
    private final By phone = By.id("Address_PhoneNumber");

    private final By saveButton =
            By.cssSelector("input[value='Save']");
    private final By firstName = By.id("Address_FirstName");
    private final By lastName = By.id("Address_LastName");
    private final By email = By.id("Address_Email");

    // Actions

    public void openAddresses() {
        click(addressesLink);
    }

    public void clickAddNew() {
        click(addNewButton);
    }

    public void addSecondAddress() {

        type(firstName, "John");
        type(lastName, "Smith");
        type(email, TestData.email);

        new Select(driver.findElement(country))
                .selectByVisibleText("India");

        type(city, "Mysore");
        type(address1, "Vijayanagar");
        type(zip, "570001");
        type(phone, "9999999999");
    }
    public void saveAddress() {
        click(saveButton);
    }
}