package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Waitings.waitForPresenceElementByLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResultsPage extends GoogleCloudParentPage {

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorFormPage openPricingCalculator(String searchKey){
        LOGGER.info("Looking for " + searchKey + "in search result.");
        waitForPresenceElementByLinkText(searchKey, driver);
        driver.findElement(By.linkText(searchKey)).click();
        LOGGER.info(searchKey + " found and opened");
        return new PricingCalculatorFormPage(driver);
    }
}
