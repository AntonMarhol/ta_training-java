package com.epam.training.student_anton_marhol.framework_practical_task.page;

import static com.epam.training.student_anton_marhol.framework_practical_task.test.CommonConditions.yopmailMail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        buttonOpenMailAddressForm.click();
        googleCloudTab = driver.getWindowHandle();

        return new YopmailHomePage(driver);
    }

    public YopmailMailPage sendByEmail() {
        driver.switchTo().window(googleCloudTab);
                                                        // refresh Pricing Calculator Tab frames for stable work
        switchToMyFrameOfPricingCalculator();

        waitForPresenceElementByXpath(FIELD_FOR_INPUT_EMAIL);
        mailAddressField.sendKeys(yopmailMail);

        buttonToSendEstimateByMail.click();

        return new YopmailMailPage(driver);
    }
}
