package com.epam.training.student_anton_marhol.hardcore.ui.page;

import static com.epam.training.student_anton_marhol.hardcore.ui.util.LocatorCreator.createXPath;
import static com.epam.training.student_anton_marhol.hardcore.ui.util.Util.clickByJavaScript;
import static com.epam.training.student_anton_marhol.hardcore.ui.util.Waitings.waitForElementInvisibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    protected static final String CLOUD_PRICING_CALCULATOR_SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";
    protected static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/";
    protected static final String YOPMAIL_URL = "https://yopmail.com/en/";

    public static String yopmailMail;
    public static String googleCloudTab;
    public static String yopmailTab;

    protected final WebDriver driver;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void setElement(String baseOfLocator, String instanceValue){
        WebElement element = driver.findElement(By.xpath(createXPath(baseOfLocator, instanceValue)));
        clickByJavaScript(element, driver);
        waitForElementInvisibility(element, driver);
    }
}
