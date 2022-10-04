package com.epam.training.student_anton_marhol.framework_practical_task.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends ParentPage {

    protected static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/";

    private static final String SEARCH_FIELD_XPATH = "//input[@class='devsite-search-field devsite-search-query']";

    @FindBy (xpath = SEARCH_FIELD_XPATH)
    private WebElement searchField;

    public GoogleCloudHomePage(WebDriver driver){
        super(driver);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(GOOGLE_CLOUD_URL);
        logger.info(GOOGLE_CLOUD_URL + " opened");
        return this;
    }

    public GoogleSearchResultsPage searchOnHomePage() {
        waitForPresenceElementByXpath(SEARCH_FIELD_XPATH);

        searchField.sendKeys(LOCATOR_FOR_CLOUD_PRICING_CALCULATOR);
        searchField.submit();

        return new GoogleSearchResultsPage(driver);
    }
}
