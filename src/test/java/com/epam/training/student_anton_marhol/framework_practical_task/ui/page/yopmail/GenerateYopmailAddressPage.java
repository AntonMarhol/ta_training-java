package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.yopmail;

import static com.epam.training.student_anton_marhol.framework_practical_task.test.CommonConditions.yopmailMail;
import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.FrameAndTabSwithers.switchToTab;
import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google.PricingCalculatorMailPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GenerateYopmailAddressPage extends YopmailParentPage {

    @FindBy(id = "egen")
    WebElement generatedMail;

    public GenerateYopmailAddressPage(WebDriver driver){
        super(driver);
    }

    public GenerateYopmailAddressPage copyGeneratedMail() {
        yopmailMail = generatedMail.getText();
        LOGGER.info("Mail address copied");
        return this;
    }

    public PricingCalculatorMailPage goToPricingCalculatorTab(){
        switchToTab(googleCloudTab, driver);
        LOGGER.info("Pricing Calculator tab opened");
        return new PricingCalculatorMailPage(driver);
    }

    public YopmailMailPage goToMaiThePage(){
        switchToTab(yopmailTab, driver);
        LOGGER.info("Yopmail opened");
        return new YopmailMailPage(driver);
    }
}
