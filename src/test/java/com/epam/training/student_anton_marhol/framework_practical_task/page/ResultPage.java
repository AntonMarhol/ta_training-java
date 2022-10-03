package com.epam.training.student_anton_marhol.framework_practical_task.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends ParentPage {

    private static final String IFMAIL_FRAME_OF_YOPMAIL = "ifmail";

    @FindBy (xpath = "//*[text()='Total Estimated Monthly Cost']/../following-sibling::td/child::h3")
    WebElement totalCostInMail;

    @FindBy (xpath = "//b[@class='ng-binding']")
    WebElement totalCostInPricingCalculator;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public String lookForTotalEstimatedCostInPricingCalculator() {
        driver.switchTo().window(googleCloudTab);
        switchToMyframeOfPricingCalculator();

        return totalCostInPricingCalculator.getText()
                .replaceFirst("Estimated Component Cost: ", "")
                .replaceFirst(" per 1 month", "");
    }

    public String lookForTotalEstimatedCostInMail() {
        driver.switchTo().window(yopmailTab);
        driver.switchTo().frame(IFMAIL_FRAME_OF_YOPMAIL);

        return totalCostInMail.getText();
    }
}
