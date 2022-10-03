package com.epam.training.student_anton_marhol.framework_practical_task.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchResultsPage extends ParentPage {

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorTheFirstPage lookingForPricingCalculatorInSearchResult (){
        new WebDriverWait(driver, LONG_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText(LOCATOR_FOR_CLOUD_PRICING_CALCULATOR)));
        driver.findElement(By.linkText(LOCATOR_FOR_CLOUD_PRICING_CALCULATOR)).click();

        return new PricingCalculatorTheFirstPage(driver);
    }
}
