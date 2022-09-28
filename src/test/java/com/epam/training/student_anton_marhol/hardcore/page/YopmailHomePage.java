package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class YopmailHomePage extends ParentPage{

    private static final String GENERATE_EMAIL_XPATH = "//a[@title = 'Disposable Email Address Generator creates a new temporary email address for you in one click!']";

    @FindBy (xpath = GENERATE_EMAIL_XPATH)
    WebElement createEmailByEmailGenerator;

    YopmailHomePage(WebDriver driver){
        super(driver);
    }

    public YopmailMailPage generateMail() {

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(YOPMAIL_URL);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(numberOfWindowsToBe(2));

        yopmailWindow = driver.getWindowHandle();

        waitForPresenceElementByXpath(GENERATE_EMAIL_XPATH);
        createEmailByEmailGenerator.click();

        return new YopmailMailPage(driver);
    }
}
