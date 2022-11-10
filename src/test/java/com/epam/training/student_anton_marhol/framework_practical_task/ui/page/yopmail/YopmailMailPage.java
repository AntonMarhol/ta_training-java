package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.yopmail;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Swither.IFMAIL_FRAME_OF_YOPMAIL;
import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Swither.switchToTab;
import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Waits.waitForFrameAndSwitchToIt;
import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Waits.waitForPresenceElementByXpath;
import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google.EstimateResultPage;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailMailPage extends YopmailParentPage {

    private static final String LETTER_FROM_GOOGLE_CLOUD = "//div[text()='Google Cloud Price Estimate']";

    @FindBy (xpath = "//span[text()='Check Inbox']")
    WebElement buttonCheckInBox;
    @FindBy (id = "refresh")
    WebElement buttonRefreshMail;
    @FindBy (xpath = "//div[@class='bname']")
    WebElement mailBoxAdress;
    @FindBy (xpath = "//h3[text()='Total Estimated Monthly Cost']/../following-sibling::td/h3")
    WebElement totalCostInMail;

    public YopmailMailPage(WebDriver driver) {
        super(driver);
    }

    public YopmailMailPage clickCheckInboxButton() {
        LOGGER.info("Opening Yopmail tab with Yopmail Inbox page");
        switchToTab(yopmailTab, driver);
        scrollPageToElement(buttonCheckInBox);
        buttonCheckInBox.click();
        LOGGER.info("Opened Yopmail tab with Yopmail Inbox page");
        return this;
    }

    public void clickRefreshMailButton() {
        LOGGER.info("Refreshing Mail page");
        driver.switchTo().defaultContent();
        scrollPageToElement(buttonRefreshMail);
        buttonRefreshMail.click();
        LOGGER.info("Mail page refreshed");
    }

    public EstimateResultPage checkForLetter(){
        LOGGER.info("Looking for the Letter");
        clickRefreshMailButton();
        try {
            waitForFrameAndSwitchToIt(IFMAIL_FRAME_OF_YOPMAIL, driver);
            waitForPresenceElementByXpath(LETTER_FROM_GOOGLE_CLOUD, driver);
        }
        catch (TimeoutException exception) {
            clickRefreshMailButton();
            waitForFrameAndSwitchToIt(IFMAIL_FRAME_OF_YOPMAIL, driver);
            waitForPresenceElementByXpath(LETTER_FROM_GOOGLE_CLOUD, driver);
        }
        LOGGER.info("Letter found");
        return new EstimateResultPage(driver);
    }

    public String getMailAdress() {
        LOGGER.info("Looking for Email address in mailbox");
        switchToTab(yopmailTab, driver);
                                                  // switching to default content otherwise mailbox address will not be found
        driver.switchTo().defaultContent();
        LOGGER.info("Email address caught in mailbox");
        return mailBoxAdress.getText();
    }

    public String getTotalEstimatedCostInMail() {
        LOGGER.info("Looking for Total estimated cost in mail");
        switchToTab(yopmailTab, driver);
        driver.switchTo().frame(IFMAIL_FRAME_OF_YOPMAIL);
        LOGGER.info("Returning Total estimated cost in mail caught in mail");
        return totalCostInMail.getText()
                .replaceFirst("Total Estimated Cost: ", "");
    }
}
