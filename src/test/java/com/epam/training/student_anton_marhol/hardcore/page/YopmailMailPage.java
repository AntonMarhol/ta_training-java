package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopmailMailPage extends ParentPage{

    private static final String LETTER_FROM_GOOGLE_CLOUD = "//div[text()='Google Cloud Price Estimate']";

    @FindBy (id = "egen")
    WebElement generatedMail;

    @FindBy (xpath = "//span[text()='Check Inbox']")
    WebElement buttonCheckInBox;

    @FindBy (id = "refresh")
    WebElement buttonRefreshMail;

    public YopmailMailPage(WebDriver driver) {
        super(driver);
    }

    public SendEstimateByMailPage copyGeneratedMail() {

        yopmailMail = generatedMail.getText();

        return new SendEstimateByMailPage(driver);
    }

    public YopmailMailPage goToTheMailBox() {

        driver.switchTo().window(yopmailTab);
        buttonCheckInBox.click();

        return this;
    }

    public ResultPage checkForLetter(){

        driver.switchTo().defaultContent();
        buttonRefreshMail.click();

        waitForFrameAndSwitchToIt(INBOX_FRAME_OF_YOPMAIL_INBOX);

        try {
            waitForPresenceElementByXpath(LETTER_FROM_GOOGLE_CLOUD);
        }
        catch (TimeoutException exception) {
            driver.switchTo().defaultContent();
            buttonRefreshMail.click();

            waitForFrameAndSwitchToIt(INBOX_FRAME_OF_YOPMAIL_INBOX);
            waitForPresenceElementByXpath(LETTER_FROM_GOOGLE_CLOUD);
        }

        return new ResultPage(driver);
    }

    protected void waitForFrameAndSwitchToIt(String frame){
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }
}
