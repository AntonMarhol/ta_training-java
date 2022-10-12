package com.epam.training.student_anton_marhol.framework_practical_task.ui.page;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.LocatorCreator.createXPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        LOGGER.info("Opening [" + dropDownListElement.getText() + "] drop down list");
        scrollPageToElement(dropDownListElement).click();
        LOGGER.info("Drop down list [" + dropDownListElement.getText() + "] opened");
    }

    protected void setNewElement(String baseOfLocator, String instanceValue){
        LOGGER.info("Selecting " + instanceValue + " element");
        String locator = createXPath(baseOfLocator, instanceValue);
        scrollPageToElement(driver.findElement(By.xpath(locator))).click();
        LOGGER.info("Element [" + instanceValue + "] selected");
    }

    public WebElement scrollPageToElement(WebElement element){
        LOGGER.info("Looking for " + element + " on page");
        try {
            new Actions(driver)
                    .scrollToElement(element)
                    .perform();
            LOGGER.info("Scrolled to " + element);
        }
        catch (Exception exception){
            LOGGER.info("The " + element + " already in view");
        }
        return element;
    }
}
