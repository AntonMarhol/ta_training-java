package com.epam.training.student_anton_marhol.i_can_win.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PastebinTest {

    private static final String TITLE = "Pastebin.com - #1 paste tool since 2002!";

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new PastebinHomePage(new ChromeDriver())
                .openPage()
                .fillFields()
                .createNewPaste();
    }

    @Test
    public void createNewPasteOnPestebin() {

        Assert.assertEquals(TITLE,driver.getTitle());
    }

    @AfterClass(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
