package com.epam.training.student_anton_marhol.bring_it_on.page;

import static com.epam.training.student_anton_marhol.bring_it_on.util.LocatorCreator.BASE_LOCATOR;
import static com.epam.training.student_anton_marhol.bring_it_on.util.Waitings.BASE_WAIT_TIME;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FieldsOnPastebinHomePage extends ParentPage{

    @FindBy(id = "postform-text")
    private WebElement pastebinTextPostform;

    @FindBy (id = "select2-postform-format-container")
    private WebElement syntaxHighlightingDropDownList;

    @FindBy (id = "select2-postform-expiration-container")
    private WebElement expirationTimeDropDownList;

    @FindBy (id = "postform-name")
    private WebElement namePostform;

    @FindBy (xpath = "//button[@class='btn -big']")
    private WebElement createPasteButton;

    public FieldsOnPastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public FieldsOnPastebinHomePage fillTextField(String text) {
        pastebinTextPostform.sendKeys(text);
        return this;
    }

    public FieldsOnPastebinHomePage openHighlightingDropDownList () {
        syntaxHighlightingDropDownList.click();
        return this;
    }

    public FieldsOnPastebinHomePage selectSyntaxHighlighting(String highlighting) {
        selectDropDownListElement(BASE_LOCATOR, highlighting);
        return this;
    }

    public FieldsOnPastebinHomePage openExpirationTimeDropDownList() {
        expirationTimeDropDownList.click();
        return this;
    }

    public FieldsOnPastebinHomePage selectExpirationTime(String expirationTime) {
        selectDropDownListElement(BASE_LOCATOR,expirationTime);
        return this;
    }

    public FieldsOnPastebinHomePage fillNameInPostform(String name){
        namePostform.sendKeys(name);
        return this;
    }

    public PastebinResultPage createNewPaste () {
        createPasteButton.click();
        new WebDriverWait(driver,BASE_WAIT_TIME).until(CustomConditions.jQueryAJAXsCompleted());
        return new PastebinResultPage(driver);
    }
}
