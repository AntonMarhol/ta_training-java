package com.epam.training.student_anton_marhol.hardcore.ui.page.google;

import static com.epam.training.student_anton_marhol.hardcore.ui.util.FrameSwitches.switchToMyframeOfPricingCalculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingCalculatorMailPage extends GoogleCloudParentPage {

    @FindBy(xpath = "//b[@class='ng-binding']")
    WebElement totalCostInPricingCalculator;

    public PricingCalculatorMailPage(WebDriver driver) {
        super(driver);
    }

    public String getEstimatedCostInPricingCalculator() {
        driver.switchTo().window(googleCloudTab);
        switchToMyframeOfPricingCalculator(driver);
        return totalCostInPricingCalculator.getText()
                .replaceFirst("Estimated Component Cost: ", "")
                .replaceFirst(" per 1 month", "");
    }
}
