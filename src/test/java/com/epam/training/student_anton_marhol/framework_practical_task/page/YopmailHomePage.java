package com.epam.training.student_anton_marhol.framework_practical_task.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class YopmailHomePage extends ParentPage {

    protected static final String YOPMAIL_URL = "https://yopmail.com/en/";

    private static final String GENERATE_EMAIL_XPATH = "//a[@title = 'Disposable Email Address Generator creates a new temporary email address for you in one click!']";

    @FindBy (xpath = GENERATE_EMAIL_XPATH)
    WebElement createEmailByEmailGenerator;

    public YopmailHomePage(WebDriver driver){
        super(driver);
    }

    public YopmailMailPage generateMail() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(YOPMAIL_URL);

        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(numberOfWindowsToBe(2));

        yopmailTab = driver.getWindowHandle();

        waitForPresenceElementByXpath(GENERATE_EMAIL_XPATH);
        createEmailByEmailGenerator.click();

        return new YopmailMailPage(driver);
    }
}
