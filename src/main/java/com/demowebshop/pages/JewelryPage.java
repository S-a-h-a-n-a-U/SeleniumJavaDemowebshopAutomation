package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JewelryPage extends BasePage {

    public JewelryPage(WebDriver driver) {
        super(driver);
    }

    private final By diamondBracelet =
            By.linkText("Diamond Tennis Bracelet");

    private final By vintageRing =
            By.linkText("Vintage Style Three Stone Diamond Engagement Ring");

    private final By addToCompareButton =
            By.cssSelector("input.button-2.add-to-compare-list-button");

    public void openDiamondBracelet() {
        click(diamondBracelet);
    }

    public void openVintageRing() {
        click(vintageRing);
    }

    public void addCurrentProductToCompare() {
        click(addToCompareButton);
    }

    public void goBack() {
        driver.navigate().back();
    }
}