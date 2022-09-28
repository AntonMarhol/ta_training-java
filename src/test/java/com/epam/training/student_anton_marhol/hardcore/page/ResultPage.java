package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends ParentPage{

    private static final String IFMAIL_FRAME_OF_YOPMAIL = "ifmail";

    @FindBy (xpath = "//*[text()='Total Estimated Monthly Cost']/../following-sibling::td/child::h3")
    WebElement totalCostInMail;

    @FindBy (xpath = "//b[@class='ng-binding']")
    WebElement totalCostInPricingCalculator;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public String lookForTotalEstimatedCostInPricingCalculator() {

        driver.switchTo().window(googleCloudWindow);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(ZERO_FRAME_OF_PRICING_CALCULATOR);
        driver.switchTo().frame(MYFRAME_FRAME_OF_PRICING_CALCULATOR);

        return totalCostInPricingCalculator.getText()
                .replaceFirst("Estimated Component Cost: ", "")
                .replaceFirst(" per 1 month", "");
    }

    public String lookForEstimatedCostInMail() {

        driver.switchTo().window(yopmailWindow);
        driver.switchTo().frame(IFMAIL_FRAME_OF_YOPMAIL);

        return totalCostInMail.getText();
    }
}
