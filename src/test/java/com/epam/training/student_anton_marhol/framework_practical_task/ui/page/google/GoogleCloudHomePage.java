package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Waitings.waitForPresenceElementByXpath;

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
        LOGGER.info(GOOGLE_CLOUD_URL + " opened");
        return this;
    }

    public GoogleSearchResultsPage search(String searchKey) {
        waitForPresenceElementByXpath(SEARCH_FIELD, driver);
        searchField.sendKeys(searchKey);
        searchField.submit();
        LOGGER.info(searchKey + "is looking for");
        return new GoogleSearchResultsPage(driver);
    }
}
