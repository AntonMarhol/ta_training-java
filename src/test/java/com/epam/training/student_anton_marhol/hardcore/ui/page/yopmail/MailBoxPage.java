package com.epam.training.student_anton_marhol.hardcore.ui.page.yopmail;

import static com.epam.training.student_anton_marhol.hardcore.ui.util.FrameSwitches.*;
import static com.epam.training.student_anton_marhol.hardcore.ui.util.Waitings.waitForPresenceElementById;
import static com.epam.training.student_anton_marhol.hardcore.ui.util.Waitings.waitForPresenceElementByXpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailBoxPage extends YopmailParentPage {

    private static final String MAIL_ADDRESS_FORM_BUTTON = "email_quote";
    private static final String INPUT_EMAIL_FIELD = "//label[text()='Email ']/following-sibling::input";

    @FindBy (xpath = "//button[contains(@aria-label,'Send Email')]")
    WebElement sendEstimateByMailButton;
    @FindBy (id = MAIL_ADDRESS_FORM_BUTTON)
    WebElement mailAddressFormButton;
    @FindBy (xpath = INPUT_EMAIL_FIELD)
    WebElement insertMailField;
    @FindBy (xpath = "//h3[text()='Total Estimated Monthly Cost']/../following-sibling::td/h3")
    WebElement totalCostInMail;

    public MailBoxPage(WebDriver driver){
        super(driver);
    }

    public YopmailHomePage selectOptionSendByEmail(){
        waitForPresenceElementById(MAIL_ADDRESS_FORM_BUTTON, driver);
        mailAddressFormButton.click();
        googleCloudTab = driver.getWindowHandle();
        return new YopmailHomePage(driver);
    }

    public MailBoxPage insertMail() {
        driver.switchTo().window(googleCloudTab);
        switchToMyframeOfPricingCalculator(driver);
        waitForPresenceElementByXpath(INPUT_EMAIL_FIELD, driver);
        insertMailField.sendKeys(yopmailMail);
        return this;
    }

    public YopmailMailPage clickButtonSendByMail(){
        sendEstimateByMailButton.click();
        return new YopmailMailPage(driver);
    }

    public String getEstimatedCostInMail() {
        driver.switchTo().window(yopmailTab);
                                        // switch to the Ifmail frame for correct work
        switchToIfmailFrameOfYopmail(driver);
        return totalCostInMail.getText();
    }
}
