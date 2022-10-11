package com.epam.training.student_anton_marhol.hurt_me_plenty.ui.page;

import static com.epam.training.student_anton_marhol.hurt_me_plenty.ui.util.LocatorCreator.createXPath;
import static com.epam.training.student_anton_marhol.hurt_me_plenty.ui.util.UtilMethods.clickByJavaScript;
import static com.epam.training.student_anton_marhol.hurt_me_plenty.ui.util.Waitings.waitForElementInvisibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    protected static final String HOMEPAGE_URL = "https://cloud.google.com/";
    protected static final String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";

    protected final WebDriver driver;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void selectValue (String baseOfLocator, String instanceValue){
        WebElement element = driver.findElement(By.xpath(createXPath(baseOfLocator, instanceValue)));
        clickByJavaScript(element, driver);
        waitForElementInvisibility(driver, element);
    }
}
