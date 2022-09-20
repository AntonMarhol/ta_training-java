package com.epam.training.student_anton_marhol.i_can_win.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillFieldsOnPastebinHomePage {

    private static final String TEXT = "Hello from WebDriver";
    private static final String NAME = "helloweb";

    private WebDriver driver;

    @FindBy (id = "postform-text")
    private WebElement fillTheText;

    @FindBy (id = "select2-postform-expiration-container")
    private WebElement selectExpiration;

    @FindBy (xpath = "//li[text()='10 Minutes']")
    private WebElement insertExpiration;

    @FindBy (id = "postform-name")
    private WebElement pasteName;

    @FindBy (xpath = "//button[@class='btn -big']")
    private WebElement createPaste;

    public FillFieldsOnPastebinHomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FillFieldsOnPastebinHomePage fillFields () {

        fillTheText.sendKeys(TEXT);
        selectExpiration.click();
        insertExpiration.click();
        pasteName.sendKeys(NAME);

        return this;
    }

    public void createNewPaste () {

        createPaste.click();
    }
}
