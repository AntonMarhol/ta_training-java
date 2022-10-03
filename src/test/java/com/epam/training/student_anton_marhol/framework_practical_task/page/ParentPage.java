package com.epam.training.student_anton_marhol.framework_practical_task.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class ParentPage {

    protected static final Duration LONG_WAIT_TIME = Duration.ofSeconds(30);
    protected static final Duration BASE_WAIT_TIME = Duration.ofSeconds(10);
    protected static final Duration SHORT_WAIT_TIME = Duration.ofSeconds(5);

    protected static final String LOCATOR_FOR_CLOUD_PRICING_CALCULATOR = "Google Cloud Platform Pricing Calculator";
    protected static final String BASE_LOCATOR = "//md-option/child::div[contains(text(),'%s')]";
                                                                                // the first frame of pricing calculator form
    protected static final int ZERO_FRAME_OF_PRICING_CALCULATOR = 0;
                                                                                // the frame to fill form of pricing calculator
    protected static final String MYFRAME_FRAME_OF_PRICING_CALCULATOR = "myFrame";
                                                                                // the inbox frame of yopmail
    protected static final String INBOX_FRAME_OF_YOPMAIL_INBOX = "ifinbox";

    static String googleCloudTab;
    static String yopmailTab;

    protected final Logger logger = LogManager.getRootLogger();

    protected final WebDriver driver;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void setNewElement(WebElement dropDownListElement, String locator){
        scrollPageByAmount(0,100);
        dropDownListElement.click();

        waitForPresenceElementByXpath(locator);

        WebElement element = driver.findElement(By.xpath(locator));
        clickByJavaScript(element);

        logger.info("Element [" + dropDownListElement.getText() + "] selected");
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

    protected void clickByJavaScript(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected void switchToMyframeOfPricingCalculator(){
        driver.switchTo().defaultContent();
        new WebDriverWait(driver, LONG_WAIT_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ZERO_FRAME_OF_PRICING_CALCULATOR));
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(MYFRAME_FRAME_OF_PRICING_CALCULATOR)));
    }

    protected void scrollPageByAmount(int pixelsX, int pixelsY){
        new Actions(driver)
                .scrollByAmount(pixelsX,pixelsY)
                .perform();
    }
}
