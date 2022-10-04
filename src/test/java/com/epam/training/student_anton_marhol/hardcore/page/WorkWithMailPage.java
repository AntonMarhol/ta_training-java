package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkWithMailPage extends ParentPage{

    private static final String BUTTON_SEND_ESTIMATE_BY_MAIL_LOCATOR = "email_quote";
    private static final String FIELD_TO_INPUT_EMAIL_XPATH = "//label[text()='Email ']/following-sibling::input";

    @FindBy (xpath = "//div[@class='md-dialog-container ng-scope']/child::md-dialog/child::form/child::md-dialog-actions/child::button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    WebElement buttonSendByMail;

    @FindBy (id = BUTTON_SEND_ESTIMATE_BY_MAIL_LOCATOR)
    WebElement buttonOpenMailAddressForm;

    @FindBy (xpath = FIELD_TO_INPUT_EMAIL_XPATH)
    WebElement fieldForInsertMail;

    public WorkWithMailPage(WebDriver driver){
        super(driver);
    }

    public YopmailHomePage selectOptionSendByEmail(){

        waitForPresenceElementById(BUTTON_SEND_ESTIMATE_BY_MAIL_LOCATOR);
        buttonOpenMailAddressForm.click();
        googleCloudTab = driver.getWindowHandle();

        return new YopmailHomePage(driver);
    }

    public YopmailMailPage sendByEmail() {

        driver.switchTo().window(googleCloudTab);

        switchToMyframeOfPricingCalculator();

        waitForPresenceElementByXpath(FIELD_TO_INPUT_EMAIL_XPATH);
        fieldForInsertMail.sendKeys(yopmailMail);

        buttonSendByMail.click();

        return new YopmailMailPage(driver);
    }
}
