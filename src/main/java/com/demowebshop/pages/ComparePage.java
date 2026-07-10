package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparePage extends BasePage {

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    private final By diamondBracelet =
            By.linkText("Diamond Tennis Bracelet");

    private final By vintageRing =
            By.linkText("Vintage Style Three Stone Diamond Engagement Ring");

    public void openComparePage() {
        driver.get("https://demowebshop.tricentis.com/compareproducts");
    }

    public boolean isDiamondBraceletDisplayed() {
        return isDisplayed(diamondBracelet);
    }

    public boolean isVintageRingDisplayed() {
        return isDisplayed(vintageRing);
    }
}