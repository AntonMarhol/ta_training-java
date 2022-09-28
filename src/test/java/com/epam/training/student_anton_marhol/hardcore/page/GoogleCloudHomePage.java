package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends ParentPage {

    private static final String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";
    private static final String SEARCH_FIELD_XPATH = "//input[@class='devsite-search-field devsite-search-query']";

    @FindBy (xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchField;

    public GoogleCloudHomePage(WebDriver driver){
        super(driver);
    }

    public GoogleCloudHomePage openPage() {

        driver.get(GOOGLE_CLOUD_URL);

        return this;
    }

    public GoogleSearchResultsPage searchOnHomePage() {

        waitForPresenceElementByXpath(SEARCH_FIELD_XPATH);

        searchField.sendKeys(SEARCH_TEXT);
        searchField.submit();

        return new GoogleSearchResultsPage(driver);
    }
}
