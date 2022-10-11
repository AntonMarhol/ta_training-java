package com.epam.training.student_anton_marhol.hardcore.ui.page.yopmail;

import static com.epam.training.student_anton_marhol.hardcore.ui.util.Waitings.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

public class YopmailHomePage extends YopmailParentPage {

    private static final String BUTTON_GENERATE_EMAIL = "//b[text()='Random Email Address']";

    @FindBy (xpath = BUTTON_GENERATE_EMAIL)
    WebElement buttonGenerateEmail;

    YopmailHomePage(WebDriver driver){
        super(driver);
    }

    public YopmailMailPage generateMail() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(YOPMAIL_URL);
        waitForNumberOfWindow(2, driver);
        yopmailTab = driver.getWindowHandle();
        waitForPresenceElementByXpath(BUTTON_GENERATE_EMAIL, driver);
        buttonGenerateEmail.click();
        return new YopmailMailPage(driver);
    }
}
