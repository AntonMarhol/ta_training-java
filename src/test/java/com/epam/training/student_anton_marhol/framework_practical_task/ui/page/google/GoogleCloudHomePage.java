package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Waits.waitForPresenceElementByXpath;

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
        LOGGER.info("Looking for " + GOOGLE_CLOUD_URL);
        driver.get(GOOGLE_CLOUD_URL);
        LOGGER.info(GOOGLE_CLOUD_URL + " opened");
        return this;
    }

    public GoogleSearchResultsPage search(String searchKey) {
        LOGGER.info("Waiting for search field.");
        waitForPresenceElementByXpath(SEARCH_FIELD, driver);
        searchField.sendKeys(searchKey);
        searchField.submit();
        LOGGER.info(searchKey + " search started");
        return new GoogleSearchResultsPage(driver);
    }
}
