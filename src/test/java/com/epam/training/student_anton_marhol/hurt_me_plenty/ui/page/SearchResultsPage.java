package com.epam.training.student_anton_marhol.hurt_me_plenty.ui.page;

import static com.epam.training.student_anton_marhol.hurt_me_plenty.ui.util.Waitings.waitForPresenceElementByLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends ParentPage{

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorFormPage lookingForPricingCalculatorInSearchResult (){
        waitForPresenceElementByLinkText(SEARCH_TEXT, driver);
        driver.findElement(By.linkText(SEARCH_TEXT)).click();
        return new PricingCalculatorFormPage(driver);
    }
}
