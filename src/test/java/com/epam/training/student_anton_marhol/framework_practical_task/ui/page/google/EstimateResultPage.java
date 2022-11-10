package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Swither.switchToMyframeOfPricingCalculator;
import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Swither.switchToTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EstimateResultPage extends GoogleCloudParentPage {

    @FindBy(xpath = "//b[contains(text(),'Total Estimated Cost:')]")
    private WebElement totalCostInPricingCalculator;

    public EstimateResultPage(WebDriver driver) {
        super(driver);
    }

    public String getTotalEstimatedCostInPricingCalculator() {
        LOGGER.info("Look for total estimated cost in pricing calculator.");
        switchToTab(googleCloudTab, driver);
        switchToMyframeOfPricingCalculator(driver);
        LOGGER.info("Got total estimated cost in pricing calculator.");
        return totalCostInPricingCalculator.getText()
                .replaceFirst("Total Estimated Cost: ", "")
                .replaceFirst(" per 1 month", "");
    }

    public String getTitle(WebDriver driver){
        LOGGER.info("Look for GoogleCloud Tab title.");
        switchToTab(googleCloudTab, driver);
        switchToMyframeOfPricingCalculator(driver);
        LOGGER.info("Got GoogleCloud Tab title.");
        return driver.getTitle();
    }
}
