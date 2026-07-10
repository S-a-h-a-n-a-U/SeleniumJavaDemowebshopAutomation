package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksPage extends BasePage {

    public BooksPage(WebDriver driver) {
        super(driver);
    }

    private final By booksMenu =
            By.linkText("Books");

    private final By computingBook =
            By.linkText("Computing and Internet");

    public void openBooks() {
        click(booksMenu);
    }

    public void openComputingBook() {
        click(computingBook);
    }

}