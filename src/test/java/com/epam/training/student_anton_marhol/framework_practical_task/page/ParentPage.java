package com.epam.training.student_anton_marhol.framework_practical_task.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParentPage {

    protected static final Duration LONG_WAIT_TIME = Duration.ofSeconds(30);
    protected static final Duration BASE_WAIT_TIME = Duration.ofSeconds(10);
    protected static final Duration SHORT_WAIT_TIME = Duration.ofSeconds(5);

    protected static final String LOCATOR_FOR_CLOUD_PRICING_CALCULATOR_IN_SEARCH_RESULT = "Google Cloud Platform Pricing Calculator";

    protected static final String BASE_LOCATOR = "//md-option/child::div[contains(text(),'%s')]";
                                                                                // the first frame of pricing calculator form
    protected static final int ZERO_FRAME_OF_PRICING_CALCULATOR = 0;
                                                                                // the frame to fill form of pricing calculator
    protected static final String MYFRAME_FRAME_OF_PRICING_CALCULATOR = "myFrame";
                                                                                // the inbox frame of yopmail
    protected static final String INBOX_FRAME_OF_YOPMAIL_INBOX = "ifinbox";

    static String googleCloudTab;
    static String yopmailTab;

    protected final WebDriver driver;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void setNewElement(WebElement clickElement, String locator){
        clickElement.click();

        waitForPresenceElementByXpath(locator);
        WebElement element = driver.findElement(By.xpath(locator));

        clickByScript(element);
        waitForElementInvisibility(element);
    }

    protected void waitForElementInvisibility(WebElement element){
        new WebDriverWait(driver, SHORT_WAIT_TIME)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForPresenceElementById(String selectorForElement){
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.id(selectorForElement)));
    }

    protected void waitForPresenceElementByXpath(String selectorForElement){
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorForElement)));
    }

    protected void clickByScript(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
