package com.epam.training.student_anton_marhol.bring_it_on.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FieldsOnPastebinHomePage extends ParentPage{

    private static final String TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                        "git push origin master --force";
    private static final String NAME = "how to gain dominance among developers";

    @FindBy(id = "postform-text")
    private WebElement formToFillTheText;

    @FindBy (id = "select2-postform-format-container")
    private WebElement syntaxHighlightingDropDownList;

    @FindBy (xpath = "//li[text()='Bash']")
    private WebElement bashSyntaxHighlighting;

    @FindBy (id = "select2-postform-expiration-container")
    private WebElement expirationTimeDropDownList;

    @FindBy (xpath = "//li[text()='10 Minutes']")
    private WebElement expirationTime;

    @FindBy (id = "postform-name")
    private WebElement formToFillName;

    @FindBy (xpath = "//button[@class='btn -big']")
    private WebElement buttonCreatePaste;

    public FieldsOnPastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public FieldsOnPastebinHomePage fillFields () {
                                                                        //INSERT NEW PASTE TEXT
        formToFillTheText.sendKeys(TEXT);
                                                                        //SELECT SYNTAX HIGHLIGHTING
        selectElementAndInsert(syntaxHighlightingDropDownList, bashSyntaxHighlighting);
                                                                        //SELECT EXPIRATION TIME
        selectElementAndInsert(expirationTimeDropDownList, expirationTime);
                                                                        //INSERT PASTE NAME
        formToFillName.sendKeys(NAME);

        return this;
    }

    public PastebinResultPage createNewPaste () {
                                                                        //CREATE PASTE
        buttonCreatePaste.click();
        new WebDriverWait(driver,BASE_WAIT_TIME).until(CustomConditions.jQueryAJAXsCompleted());

        return new PastebinResultPage(driver);
    }
}
