package com.epam.training.student_anton_marhol.bring_it_on.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ParentPage {

    protected final WebDriver driver;
    protected static final Duration BASE_WAIT_TIME = Duration.ofSeconds(10);
    protected static final Duration SHORT_WAIT_TIME = Duration.ofSeconds(5);

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void selectElementAndInsert(WebElement clickElement, WebElement insertElement) {
        clickElement.click();
        new WebDriverWait(driver, SHORT_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(insertElement));
        insertElement.click();
    }
}
