package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailMailPage extends ParentPage{

    private static final String LETTER_FROM_GOOGLE_CLOUD = "//span[text()='Google Cloud Sales']";

    @FindBy (id = "egen")
    WebElement generatedMail;

    @FindBy (xpath = "//span[text()='Check Inbox']")
    WebElement checkInBox;

    @FindBy (id = "refresh")
    WebElement refreshMail;

    public YopmailMailPage(WebDriver driver) {
        super(driver);
    }

    public SendEstimateByMailPage copyGeneratedMail() {

        yopmailMail = generatedMail.getText();

        return new SendEstimateByMailPage(driver);
    }

    public YopmailMailPage goToTheMailBox() {

        driver.switchTo().window(yopmailWindow);
        checkInBox.click();

        return this;
    }

    public WebDriver checkForLetter(){

        driver.switchTo().frame(INBOX_FRAME_OF_YOPMAIL_INBOX);

        try {
            waitForPresenceElementByXpath(LETTER_FROM_GOOGLE_CLOUD);
        }
        catch (TimeoutException exception) {
            driver.switchTo().defaultContent();
            refreshMail.click();
        }

        driver.switchTo().frame(INBOX_FRAME_OF_YOPMAIL_INBOX);
        waitForPresenceElementByXpath(LETTER_FROM_GOOGLE_CLOUD);

        return driver;
    }
}
