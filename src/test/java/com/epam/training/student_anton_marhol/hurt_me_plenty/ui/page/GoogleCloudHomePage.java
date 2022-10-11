package com.epam.training.student_anton_marhol.hurt_me_plenty.ui.page;

import static com.epam.training.student_anton_marhol.hardcore.ui.util.Waitings.waitForPresenceElementByXpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends ParentPage{

    private static final String SEARCH_FIELD = "//input[@name='q']";

    @FindBy (xpath = SEARCH_FIELD)
    private WebElement searchField;

    public GoogleCloudHomePage (WebDriver driver){
        super(driver);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultsPage performSearch() {
        waitForPresenceElementByXpath(SEARCH_FIELD, driver);
        searchField.sendKeys(SEARCH_TEXT);
        searchField.submit();
        return new SearchResultsPage(driver);
    }
}
