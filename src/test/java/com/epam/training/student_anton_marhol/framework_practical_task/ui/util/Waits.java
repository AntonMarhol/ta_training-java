package com.epam.training.student_anton_marhol.framework_practical_task.ui.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class Waits {

    public static final Duration LONG_WAIT_TIME = Duration.ofSeconds(30);
    public static final Duration BASE_WAIT_TIME = Duration.ofSeconds(10);

    public static WebElement waitForPresenceElementById(String selectorForElement, WebDriver driver){
        return new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.id(selectorForElement)));
    }

    public static void waitForPresenceElementByXpath(String selectorForElement, WebDriver driver){
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorForElement)));
    }

    public static WebElement waitForPresenceElementByLinkText(String text, WebDriver driver){
        return new WebDriverWait(driver, LONG_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
    }

    public static void waitForNumberOfWindow(int numberOfWindow, WebDriver driver) {
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(numberOfWindowsToBe(numberOfWindow));
    }

    public static void waitForFrameAndSwitchToIt(String frame, WebDriver driver){
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }
}
