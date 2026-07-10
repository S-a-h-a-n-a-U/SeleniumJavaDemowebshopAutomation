package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DigitalDownloadsPage extends BasePage {

    public DigitalDownloadsPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By digitalDownloadsMenu = By.linkText("Digital downloads");

    // 3rd Album
    private final By thirdAlbum = By.linkText("3rd Album");

    // Actions
    public void openDigitalDownloads() {
        click(digitalDownloadsMenu);
    }

    public void openThirdAlbum() {
        click(thirdAlbum);
    }
}