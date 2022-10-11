package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.yopmail;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.UtilMethods.scrollPageToElement;
import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Waitings.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

public class YopmailHomePage extends YopmailParentPage {

    private static final String BUTTON_GENERATE_EMAIL = "//b[text()='Random Email Address']";

    @FindBy (xpath = BUTTON_GENERATE_EMAIL)
    WebElement buttonGenerateEmail;

    public YopmailHomePage(WebDriver driver) {
        super(driver);
    }

    public YopmailHomePage openYopmail() {
        driver.get(YOPMAIL_URL);
        yopmailTab = driver.getWindowHandle();
        waitForNumberOfWindow(2, driver);
        LOGGER.info("Yopmail tab opened with Yopmail Homepage");
        return this;
    }

    public GenerateYopmailAddressPage generateMail() {
        waitForPresenceElementByXpath(BUTTON_GENERATE_EMAIL, driver);
        scrollPageToElement(buttonGenerateEmail, driver);
        buttonGenerateEmail.click();
        LOGGER.info("Mail address generated");
        return new GenerateYopmailAddressPage(driver);
    }

    public YopmailHomePage openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        LOGGER.info("New tab opened.");
        return this;
    }
}
