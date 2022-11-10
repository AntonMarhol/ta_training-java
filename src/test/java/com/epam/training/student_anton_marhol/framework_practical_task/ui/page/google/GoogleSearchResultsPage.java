package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Waits.waitForPresenceElementByLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResultsPage extends GoogleCloudParentPage {

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorFormPage open(String searchKey){
        LOGGER.info("Looking for " + searchKey + "in search result.");
        waitForPresenceElementByLinkText(searchKey, driver).click();
//        driver.findElement(By.linkText(searchKey)).click();
        LOGGER.info(searchKey + " found and opened");
        return new PricingCalculatorFormPage(driver);
    }
}
