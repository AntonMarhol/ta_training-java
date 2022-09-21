package com.epam.training.student_anton_marhol.bring_it_on.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FillFieldsOnPastebinHomePage {

    private static final String TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                        "git push origin master --force";
    private static final String NAME = "how to gain dominance among developers";

    private final WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement fillTheText;

    @FindBy (id = "select2-postform-format-container")
    private WebElement selectHighlighting;

    @FindBy (xpath = "//li[text()='Bash']")
    private WebElement insertHighlighting;

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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        fillTheText.sendKeys(TEXT);

        selectHighlighting.click();
        wait.until(ExpectedConditions.elementToBeClickable(insertHighlighting));
        insertHighlighting.click();

        selectExpiration.click();
        wait.until(ExpectedConditions.elementToBeClickable(insertExpiration));
        insertExpiration.click();

        pasteName.sendKeys(NAME);

        return this;
    }

    public WebDriver createNewPaste () {

        createPaste.click();
        CustomConditions.jQueryAJAXsCompleted();

        return driver;
    }
}
