package com.epam.training.student_anton_marhol.hardcore.ui.page.google;

import static com.epam.training.student_anton_marhol.hardcore.ui.util.Waitings.waitForPresenceElementByLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResultsPage extends GoogleCloudParentPage {

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorFormPage lookingForPricingCalculatorInSearchResult (){
        waitForPresenceElementByLinkText(CLOUD_PRICING_CALCULATOR_SEARCH_TEXT, driver);
        driver.findElement(By.linkText(CLOUD_PRICING_CALCULATOR_SEARCH_TEXT)).click();
        return new PricingCalculatorFormPage(driver);
    }
}
