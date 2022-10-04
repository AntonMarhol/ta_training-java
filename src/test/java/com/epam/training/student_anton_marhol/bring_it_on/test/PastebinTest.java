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

    WebDriver driver;
    PastebinResultPage pastebinResultPage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pastebinResultPage = new PastebinHomePage(driver)
                .openPage()
                .fillFields()
                .createNewPaste();
    }

    @Test
    public void pasteNameTitleTest() {
        Assert.assertEquals(pastebinResultPage.tittleName(), TITLE_NAME);
    }

    @Test
    public void bashColoredTest() {
        Assert.assertEquals(pastebinResultPage.colorOfText(), COLOR);
    }

    @Test
    public void textContentsTest() {
        Assert.assertEquals(pastebinResultPage.textContent(), TEXT);
    }

    @AfterClass(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
    }
}
