package com.epam.training.student_anton_marhol.framework_practical_task.page;

import static com.epam.training.student_anton_marhol.framework_practical_task.test.CommonConditions.yopmailMail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SendEstimateByMailPage extends ParentPage {

    private static final String BUTTON_TO_INSERT_MAIL_ADDRESS_LOCATOR = "email_quote";
    private static final String FIELD_FOR_INPUT_EMAIL = "//label[text()='Email ']/following-sibling::input";

    @FindBy (xpath = "//div[@class='md-dialog-container ng-scope']/child::md-dialog/child::form/child::md-dialog-actions/child::button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    WebElement buttonToSendEstimateByMail;

    @FindBy (id = BUTTON_TO_INSERT_MAIL_ADDRESS_LOCATOR)
    WebElement buttonOpenMailAddressForm;

    @FindBy (xpath = FIELD_FOR_INPUT_EMAIL)
    WebElement mailAddressField;

    public SendEstimateByMailPage(WebDriver driver){
        super(driver);
    }

    public YopmailHomePage selectOptionSendByEmail(){
        waitForPresenceElementById(BUTTON_TO_INSERT_MAIL_ADDRESS_LOCATOR);
<<<<<<< HEAD
=======
//        new Actions(driver)
//                .scrollToElement(buttonOpenMailAddressForm)
//                .perform();
>>>>>>> 76bda087ce1475a3b159fa232b114c6b89fc6f0c
        buttonOpenMailAddressForm.click();
        logger.info("Mail address form opened");
        googleCloudTab = driver.getWindowHandle();

        return new YopmailHomePage(driver);
    }

    public YopmailMailPage sendByEmail() {
        driver.switchTo().window(googleCloudTab);
        logger.info("Switched to Google Cloud tab");
                                                        // refresh Pricing Calculator Tab frames for stable work
        switchToMyframeOfPricingCalculator();

        waitForPresenceElementByXpath(FIELD_FOR_INPUT_EMAIL);
        mailAddressField.sendKeys(yopmailMail);

        buttonToSendEstimateByMail.click();
        logger.info("Estimate sent by email");
        return new YopmailMailPage(driver);
    }
}
