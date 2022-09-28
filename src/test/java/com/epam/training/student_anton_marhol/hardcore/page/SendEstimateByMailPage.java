package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendEstimateByMailPage extends ParentPage{

    private static final String SEND_ESTIMATE_BY_MAIL_LOCATOR = "email_quote";
    private static final String INPUT_EMAIL_FIELD = "//label[text()='Email ']/following-sibling::input";

    @FindBy (xpath = "//div[@class='md-dialog-container ng-scope']/child::md-dialog/child::form/child::md-dialog-actions/child::button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    WebElement buttonSendByMail;

    @FindBy (id = SEND_ESTIMATE_BY_MAIL_LOCATOR)
    WebElement clickToSendByMail;

    @FindBy (xpath = INPUT_EMAIL_FIELD)
    WebElement insertMail;

    public SendEstimateByMailPage(WebDriver driver){
        super(driver);
    }

    public YopmailHomePage selectSendByEmail(){

        waitForPresenceElementById(SEND_ESTIMATE_BY_MAIL_LOCATOR);
        clickToSendByMail.click();
        googleCloudWindow = driver.getWindowHandle();

        return new YopmailHomePage(driver);
    }

    public YopmailMailPage sendByEmail() {

        driver.switchTo().window(googleCloudWindow);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(ZERO_FRAME_OF_PRICING_CALCULATOR);
        driver.switchTo().frame(MYFRAME_FRAME_OF_PRICING_CALCULATOR);

        waitForPresenceElementByXpath(INPUT_EMAIL_FIELD);
        insertMail.sendKeys(yopmailMail);

        buttonSendByMail.click();

        return new YopmailMailPage(driver);
    }
}
