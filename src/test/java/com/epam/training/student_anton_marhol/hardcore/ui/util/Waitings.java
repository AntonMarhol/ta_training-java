package com.epam.training.student_anton_marhol.hardcore.ui.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class Waitings {

    public static final Duration LONG_WAIT_TIME = Duration.ofSeconds(30);
    public static final Duration BASE_WAIT_TIME = Duration.ofSeconds(10);
    public static final Duration SHORT_WAIT_TIME = Duration.ofSeconds(5);

    public static void waitForElementInvisibility(WebElement element, WebDriver driver){
        new WebDriverWait(driver, SHORT_WAIT_TIME)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForPresenceElementById(String selectorForElement, WebDriver driver){
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.id(selectorForElement)));
    }

    public static void waitForPresenceElementByXpath(String selectorForElement, WebDriver driver){
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorForElement)));
    }

    public static void waitForFrameAndSwitchToIt(String frame, WebDriver driver){
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    public static void waitForPresenceElementByLinkText(String text, WebDriver driver){
        new WebDriverWait(driver, LONG_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
    }

    public static void waitForNumberOfWindow(int numberOfWindow, WebDriver driver) {
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(numberOfWindowsToBe(numberOfWindow));
    }
}
