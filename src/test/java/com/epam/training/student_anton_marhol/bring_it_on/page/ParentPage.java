package com.epam.training.student_anton_marhol.bring_it_on.page;

import static com.epam.training.student_anton_marhol.bring_it_on.util.LocatorCreator.createXPath;
import static com.epam.training.student_anton_marhol.bring_it_on.util.Waitings.waitForElementToBeClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    protected static final String HOME_PAGE_URL = "https://pastebin.com";

    protected final WebDriver driver;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void selectDropDownListElement(String locator, String instanceValue) {
        WebElement element = driver.findElement(By.xpath(createXPath(locator, instanceValue)));
        waitForElementToBeClickable(element, driver);
        element.click();
    }
}
