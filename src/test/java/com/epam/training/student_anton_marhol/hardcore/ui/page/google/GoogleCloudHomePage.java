package com.epam.training.student_anton_marhol.hardcore.ui.page.google;

import static com.epam.training.student_anton_marhol.hardcore.ui.util.Waitings.waitForPresenceElementByXpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends GoogleCloudParentPage {

    private static final String SEARCH_FIELD = "//input[@name='q']";

    @FindBy (xpath = SEARCH_FIELD)
    private WebElement searchField;

    public GoogleCloudHomePage(WebDriver driver){
        super(driver);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(GOOGLE_CLOUD_URL);
        return this;
    }

    public GoogleSearchResultsPage searchOnHomePage() {
        waitForPresenceElementByXpath(SEARCH_FIELD, driver);
        searchField.sendKeys(CLOUD_PRICING_CALCULATOR_SEARCH_TEXT);
        searchField.submit();
        return new GoogleSearchResultsPage(driver);
    }
}
