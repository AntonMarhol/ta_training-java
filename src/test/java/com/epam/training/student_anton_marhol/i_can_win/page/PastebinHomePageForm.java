package com.epam.training.student_anton_marhol.i_can_win.page;

import static com.epam.training.student_anton_marhol.i_can_win.util.LocatorCreator.BASE_LOCATOR;
import static com.epam.training.student_anton_marhol.i_can_win.util.LocatorCreator.createXPath;
import static com.epam.training.student_anton_marhol.i_can_win.util.Waitings.waitForElementToBeClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinHomePageForm extends ParentPage{

    @FindBy (id = "postform-text")
    private WebElement textPostform;

    @FindBy (id = "select2-postform-expiration-container")
    private WebElement expirationDropDownList;

    @FindBy (id = "postform-name")
    private WebElement namePostform;

    @FindBy (xpath = "//button[@class='btn -big']")
    private WebElement createPasteButton;

    public PastebinHomePageForm(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePageForm fillTextForm(String text) {
        waitForElementToBeClickable(textPostform, driver);
        textPostform.sendKeys(text);
        return this;
    }

    public PastebinHomePageForm openExpirationDropDownList() {
        waitForElementToBeClickable(expirationDropDownList, driver);
        expirationDropDownList.click();
        return this;
    }

    public PastebinHomePageForm insertExpiration(String expiration) {
        WebElement element = driver.findElement(By.xpath(createXPath(BASE_LOCATOR, expiration)));
        waitForElementToBeClickable(element, driver);
        element.click();
        return this;
    }

    public PastebinHomePageForm insertPasteName(String name) {
        waitForElementToBeClickable(namePostform, driver);
        namePostform.sendKeys(name);
        return this;
    }

    public PastebinHomePageForm createNewPaste () {
        waitForElementToBeClickable(createPasteButton, driver);
        createPasteButton.click();
        return this;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}
