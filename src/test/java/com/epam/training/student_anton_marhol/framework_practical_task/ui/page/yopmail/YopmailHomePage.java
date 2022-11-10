package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.yopmail;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Waits.*;

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
        LOGGER.info("Opening Yopmail tab with Yopmail Homepage");
        driver.get(YOPMAIL_URL);
        yopmailTab = driver.getWindowHandle();
        waitForNumberOfWindow(2, driver);
        LOGGER.info("Yopmail tab opened with Yopmail Homepage");
        return this;
    }

    public GenerateYopmailAddressPage generateMail() {
        LOGGER.info("Generating Mail address");
        waitForPresenceElementByXpath(BUTTON_GENERATE_EMAIL, driver);
        scrollPageToElement(buttonGenerateEmail);
        buttonGenerateEmail.click();
        LOGGER.info("Mail address generated");
        return new GenerateYopmailAddressPage(driver);
    }

    public YopmailHomePage openNewTab() {
        LOGGER.info("Opening New tab");
        driver.switchTo().newWindow(WindowType.TAB);
        LOGGER.info("New tab opened");
        return this;
    }
}
