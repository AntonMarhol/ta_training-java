package com.epam.training.student_anton_marhol.framework_practical_task.page;

import static com.epam.training.student_anton_marhol.framework_practical_task.test.CommonConditions.yopmailMail;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopmailMailPage extends ParentPage {

    private static final String LETTER_FROM_GOOGLE_CLOUD = "//div[text()='Google Cloud Price Estimate']";

    @FindBy (id = "egen")
    WebElement generatedMail;

    @FindBy (xpath = "//span[text()='Check Inbox']")
    WebElement buttonCheckInBox;

    @FindBy (id = "refresh")
    WebElement buttonRefreshMail;

    @FindBy (xpath = "//div[@class='bname']")
    WebElement mailBoxAdress;

    public YopmailMailPage(WebDriver driver) {
        super(driver);
    }

    public YopmailMailPage copyGeneratedMail() {
        yopmailMail = generatedMail.getText();
        logger.info("Mail address copied");
        return new YopmailMailPage(driver);
    }

    public SendEstimateByMailPage backToPricingCalculatorTab(){
        logger.info("Back to Pricing Calculator tab from Yopmail tab");
        return new SendEstimateByMailPage(driver);
    }

    public YopmailMailPage goToTheMailBox() {
        driver.switchTo().window(yopmailTab);
        buttonCheckInBox.click();
        logger.info("Opened Yopmail tab with Yopmail Inbox page");
        return this;
    }

    public String isMailAdressCreated() {
                                    // switching to default content otherwise mailbox address will not be found
        driver.switchTo().defaultContent();
        logger.info("Email address caught in mailbox");
        return mailBoxAdress.getText();
    }

    public YopmailMailPage checkForLetter(){
        driver.switchTo().defaultContent();
        buttonRefreshMail.click();
        logger.info("Mail page refreshed");

        waitForFrameAndSwitchToIt(INBOX_FRAME_OF_YOPMAIL_INBOX);
        try {
            waitForPresenceElementByXpath(LETTER_FROM_GOOGLE_CLOUD);
        }
        catch (TimeoutException exception) {
            driver.switchTo().defaultContent();
            buttonRefreshMail.click();
            logger.info("Mail page refreshed second time");

            waitForFrameAndSwitchToIt(INBOX_FRAME_OF_YOPMAIL_INBOX);
            waitForPresenceElementByXpath(LETTER_FROM_GOOGLE_CLOUD);
        }
        logger.info("Letter found");
        return this;
    }

    private void waitForFrameAndSwitchToIt(String frame){
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }
}
