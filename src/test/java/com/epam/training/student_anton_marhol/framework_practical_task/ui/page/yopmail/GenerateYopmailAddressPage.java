package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.yopmail;

import static com.epam.training.student_anton_marhol.framework_practical_task.test.CommonCondition.yopmailMail;
import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Swither.switchToTab;
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
        LOGGER.info("Copying Mail address");
        yopmailMail = generatedMail.getText();
        LOGGER.info("Mail address copied");
        return this;
    }

    public PricingCalculatorMailPage goToPricingCalculatorTab(){
        LOGGER.info("Opening Pricing Calculator tab");
        switchToTab(googleCloudTab, driver);
        LOGGER.info("Pricing Calculator tab opened");
        return new PricingCalculatorMailPage(driver);
    }

    public YopmailMailPage goToMailPage(){
        LOGGER.info("Opening Yopmail tab");
        switchToTab(yopmailTab, driver);
        LOGGER.info("Yopmail tab opened");
        return new YopmailMailPage(driver);
    }
}
