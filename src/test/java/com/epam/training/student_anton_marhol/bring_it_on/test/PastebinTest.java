package com.epam.training.student_anton_marhol.bring_it_on.test;

import com.epam.training.student_anton_marhol.bring_it_on.page.PasteResultPage;
import com.epam.training.student_anton_marhol.bring_it_on.page.PastebinHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.Color;

public class PastebinTest {

    private static final String TITLE_NAME = "how to gain dominance among developers";
    private static final String TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                        "git push origin master --force";
    private static final Color COLOR = Color.fromString("#c20cb9");

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new PastebinHomePage(new ChromeDriver())
                .openPage()
                .fillFields()
                .createNewPaste();
    }

    @Test
    public void pasteNameTitleTest() {

        String resultTitleName = new PasteResultPage(driver).tittleName();

        Assert.assertEquals(TITLE_NAME, resultTitleName);
    }

    @Test
    public void bashColoredTest() {

        Color resultColorOfTitle = new PasteResultPage(driver).colorOfText();

        Assert.assertTrue(COLOR.equals(resultColorOfTitle));
    }

    @Test
    public void textContentsTest() {

        String resultContentsText = new PasteResultPage(driver).textContent();

        Assert.assertEquals(TEXT, resultContentsText);
    }

    @AfterClass(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
