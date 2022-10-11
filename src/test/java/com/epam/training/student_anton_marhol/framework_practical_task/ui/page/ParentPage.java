package com.epam.training.student_anton_marhol.framework_practical_task.ui.page;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.LocatorCreator.createXPath;
import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.UtilMethods.scrollPageToElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ParentPage {

    protected static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/";
    protected static final String YOPMAIL_URL = "https://yopmail.com/en/";

    public static String googleCloudTab;
    protected static String yopmailTab;

    public static final Logger LOGGER = LogManager.getRootLogger();
    protected final WebDriver driver;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void openDropDownList(WebElement dropDownListElement) {
        scrollPageToElement(dropDownListElement, driver).click();
        LOGGER.info("Element [" + dropDownListElement.getText() + "] opened");
    }

    protected void setNewElement(String baseOfLocator, String instanceValue){
        String locator = createXPath(baseOfLocator, instanceValue);
        scrollPageToElement(driver.findElement(By.xpath(locator)), driver).click();
        LOGGER.info("Element [" + locator + "] selected");
    }
}
