package com.epam.training.student_anton_marhol.bring_it_on.test;

import com.epam.training.student_anton_marhol.bring_it_on.page.PastebinResultPage;
import com.epam.training.student_anton_marhol.bring_it_on.page.PastebinHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.support.Color;

public class PastebinTest {

    private static final String TITLE_NAME = "how to gain dominance among developers";
    private static final String TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                        "git push origin master --force";
    private static final Color COLOR = Color.fromString("#c20cb9");

    private static final String HIGHLIGHTING = "Bash";
    private static final String EXPIRATION_TIME = "10 Minutes";

    WebDriver driver;
    PastebinResultPage pastebinResultPage;

    @BeforeClass(description = "Opening Pastebin, filling the form and opening published Pastebin")
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pastebinResultPage = new PastebinHomePage(driver)
                .openPage()
                .fillTextField(TEXT)
                .openHighlightingDropDownList()
                .selectSyntaxHighlighting(HIGHLIGHTING)
                .openExpirationTimeDropDownList()
                .selectExpirationTime(EXPIRATION_TIME)
                .fillNameInPostform(TITLE_NAME)
                .createNewPaste();
    }

    @Test (description = "Check for title name is correct")
    public void pasteNameTitle() {
        Assert.assertEquals(pastebinResultPage.getTittleName(), TITLE_NAME, "Tittle name in published Pastebin is wrong");
    }

    @Test (description = "Check for bush colored text")
    public void isBashColored() {
        Assert.assertEquals(pastebinResultPage.getColorOfText(), COLOR, "There is no bush highlighting");
    }

    @Test (priority = 1, description = "Compare text to be not different from inserted")
    public void textContents() {
        Assert.assertEquals(pastebinResultPage.clickRawButton().getTextContent(), TEXT, "Content text is different from expected");
    }

    @AfterClass(alwaysRun = true, description = "Close browser in all cases")
    public void browserShutDown() {
        driver.quit();
    }
}
