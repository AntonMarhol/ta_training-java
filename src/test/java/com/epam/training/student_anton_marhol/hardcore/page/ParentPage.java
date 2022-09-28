package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParentPage {

    protected static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/";
    protected static final String YOPMAIL_URL = "https://yopmail.com/en/";

                                                                                // the first frame of pricing calculator form
    protected static final int ZERO_FRAME_OF_PRICING_CALCULATOR = 0;
                                                                                // the frame to fill form of pricing calculator
    protected static final String MYFRAME_FRAME_OF_PRICING_CALCULATOR = "myFrame";
                                                                                // the inbox frame of yopmail
    protected static final String INBOX_FRAME_OF_YOPMAIL_INBOX = "ifinbox";

    static String yopmailMail;
    static String googleCloudWindow;
    static String yopmailWindow;

    protected final WebDriver driver;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void setElement(WebElement clickElement, WebElement selectElement, JavascriptExecutor executor){

        clickElement.click();
        executor.executeScript("arguments[0].click();", selectElement);
        waitForElementInvisibility(selectElement);
    }

    protected void waitForElementInvisibility(WebElement element){

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForPresenceElementById(String selectorForElement){

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(selectorForElement)));
    }

    protected void waitForPresenceElementByXpath(String selectorForElement){

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorForElement)));
    }
}
