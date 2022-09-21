package com.epam.training.student_anton_marhol.hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class GoogleCloudHomePage {

    private static final String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private final WebDriver driver;

    @FindBy (xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchField;

    public GoogleCloudHomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public GoogleCloudHomePage openPage() {

        driver.get(HOMEPAGE_URL);
        CustomConditions.jQueryAJAXsCompleted();

        return this;
    }

    public SearchResultsPage searchOnHomePage() throws InterruptedException{

        searchField.sendKeys(SEARCH_TEXT);
        searchField.submit();

        return new SearchResultsPage(driver);
    }
}
