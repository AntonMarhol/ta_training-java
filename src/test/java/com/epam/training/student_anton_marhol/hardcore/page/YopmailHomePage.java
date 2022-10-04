package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class YopmailHomePage extends ParentPage{

    private static final String YOPMAIL_URL = "https://yopmail.com/en/";
    private static final String BUTTON_GENERATE_EMAIL_XPATH = "//a[@title = 'Disposable Email Address Generator creates a new temporary email address for you in one click!']";

    @FindBy (xpath = BUTTON_GENERATE_EMAIL_XPATH)
    WebElement buttonGenerateEmail;

    YopmailHomePage(WebDriver driver){
        super(driver);
    }

    public YopmailMailPage generateMail() {

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(YOPMAIL_URL);

        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(numberOfWindowsToBe(2));

        yopmailTab = driver.getWindowHandle();

        waitForPresenceElementByXpath(BUTTON_GENERATE_EMAIL_XPATH);
        buttonGenerateEmail.click();

        return new YopmailMailPage(driver);
    }
}
