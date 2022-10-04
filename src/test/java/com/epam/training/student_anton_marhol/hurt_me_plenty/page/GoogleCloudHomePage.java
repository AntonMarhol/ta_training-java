package com.epam.training.student_anton_marhol.hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage extends ParentPage{

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";
    private static final String SEARCH_FIELD_XPATH = "//input[@class='devsite-search-field devsite-search-query']";

    @FindBy (xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchField;

    public GoogleCloudHomePage (WebDriver driver){
        super(driver);
    }

    public GoogleCloudHomePage openPage() {

        driver.get(HOMEPAGE_URL);

        return this;
    }

    public SearchResultsPage searchOnHomePage() {

        new WebDriverWait(driver, LONG_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_FIELD_XPATH)));
        searchField.sendKeys(SEARCH_TEXT);
        searchField.submit();

        return new SearchResultsPage(driver);
    }
}
