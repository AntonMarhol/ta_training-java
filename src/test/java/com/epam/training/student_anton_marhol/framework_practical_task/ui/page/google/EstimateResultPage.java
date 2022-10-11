package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.FrameAndTabSwithers.switchToMyframeOfPricingCalculator;
import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.FrameAndTabSwithers.switchToTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EstimateResultPage extends GoogleCloudParentPage {

    @FindBy(xpath = "//b[contains(text(),'Total Estimated Cost:')]")
    WebElement totalCostInPricingCalculator;

    public EstimateResultPage(WebDriver driver) {
        super(driver);
    }

    public String getTotalEstimatedCostInPricingCalculator() {
        switchToTab(googleCloudTab, driver);
        switchToMyframeOfPricingCalculator(driver);
        return totalCostInPricingCalculator.getText()
                .replaceFirst("Total Estimated Cost: ", "")
                .replaceFirst(" per 1 month", "");
    }

    public String getTitle(WebDriver driver){
        switchToTab(googleCloudTab, driver);
        switchToMyframeOfPricingCalculator(driver);
        return driver.getTitle();
    }
}
