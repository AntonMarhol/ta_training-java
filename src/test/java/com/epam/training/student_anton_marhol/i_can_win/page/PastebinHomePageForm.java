package com.epam.training.student_anton_marhol.i_can_win.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePageForm {

    private static final String TEXT = "Hello from WebDriver";
    private static final String NAME = "helloweb";

    private WebDriver driver;

    @FindBy (id = "postform-text")
    private WebElement textForm;

    @FindBy (id = "select2-postform-expiration-container")
    private WebElement expirationDropDownList;

    @FindBy (xpath = "//li[text()='10 Minutes']")
    private WebElement expiration;

    @FindBy (id = "postform-name")
    private WebElement nameForm;

    @FindBy (xpath = "//button[@class='btn -big']")
    private WebElement buttonCreatePaste;

    public PastebinHomePageForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePageForm fillFields () {
        waitForElementToBeClickable(textForm);
        textForm.sendKeys(TEXT);

        waitForElementToBeClickable(expirationDropDownList);
        expirationDropDownList.click();

        waitForElementToBeClickable(expiration);
        expiration.click();

        waitForElementToBeClickable(nameForm);
        nameForm.sendKeys(NAME);

        return this;
    }

    public String createNewPaste () {
        waitForElementToBeClickable(buttonCreatePaste);
        buttonCreatePaste.click();

        return driver.getTitle();
    }

    private void waitForElementToBeClickable(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
    }
}
