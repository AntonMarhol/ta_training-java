package com.epam.training.student_anton_marhol.hardcore.ui.page.yopmail;

import static com.epam.training.student_anton_marhol.hardcore.ui.util.FrameSwitches.INBOX_FRAME_OF_YOPMAIL_INBOX;
import static com.epam.training.student_anton_marhol.hardcore.ui.util.FrameSwitches.switchToInboxFrameOfYopmail;
import static com.epam.training.student_anton_marhol.hardcore.ui.util.Waitings.waitForFrameAndSwitchToIt;
import static com.epam.training.student_anton_marhol.hardcore.ui.util.Waitings.waitForPresenceElementByXpath;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailMailPage extends YopmailParentPage {

    private static final String LETTER_FROM_GOOGLE_CLOUD = "//div[text()='Google Cloud Price Estimate']";

    @FindBy (id = "egen")
    WebElement generatedMail;
    @FindBy (xpath = "//span[text()='Check Inbox']")
    WebElement checkInBoxButton;
    @FindBy (id = "refresh")
    WebElement refreshMailButton;

    public YopmailMailPage(WebDriver driver) {
        super(driver);
    }

    public MailBoxPage copyGeneratedMail() {
        yopmailMail = generatedMail.getText();
        return new MailBoxPage(driver);
    }

    public YopmailMailPage goToTheMailBox() {
        driver.switchTo().window(yopmailTab);
        checkInBoxButton.click();
        return this;
    }

    public void clickRefreshMailButton() {
        driver.switchTo().defaultContent();
        refreshMailButton.click();
    }

    public YopmailMailPage checkForLetter(){
        clickRefreshMailButton();
        waitForFrameAndSwitchToIt(INBOX_FRAME_OF_YOPMAIL_INBOX, driver);
        try {
            waitForPresenceElementByXpath(LETTER_FROM_GOOGLE_CLOUD, driver);
        }
        catch (TimeoutException exception) {
            clickRefreshMailButton();
            waitForFrameAndSwitchToIt(INBOX_FRAME_OF_YOPMAIL_INBOX, driver);
            waitForPresenceElementByXpath(LETTER_FROM_GOOGLE_CLOUD, driver);
        }
        return new YopmailMailPage(driver);
    }

    public String getYopmailTabTitle(){
        driver.switchTo().window(yopmailTab);
        switchToInboxFrameOfYopmail(driver);
        return driver.getTitle();
    }
}
