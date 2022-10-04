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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPasteOnPestebin() {
        String pageTitle = new PastebinHomePage(driver)
                .openPage()
                .fillFields()
                .createNewPaste();

        Assert.assertEquals(pageTitle, TITLE);
    }

    @AfterClass(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
