package com.epam.training.student_anton_marhol.i_can_win.test;

import com.epam.training.student_anton_marhol.i_can_win.page.PastebinHomePage;
import com.epam.training.student_anton_marhol.i_can_win.page.PastebinHomePageForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PastebinTest {

    private static final String TITLE = "Pastebin.com - #1 paste tool since 2002!";
    private static final String EXPIRATION = "10 Minutes";
    private static final String TEXT = "Hello from WebDriver";
    private static final String NAME = "helloweb";

    private WebDriver driver;

    @BeforeClass(description = "Create driver and open max size window")
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "Create new paste on Pastebin and compare title of the page")
    public void isPastebinTitleCorrect() {
        PastebinHomePageForm pastebinHomePageForm = new PastebinHomePage(driver)
                .openPage()
                .fillTextForm(TEXT)
                .openExpirationDropDownList()
                .insertExpiration(EXPIRATION)
                .insertPasteName(NAME)
                .createNewPaste();
        Assert.assertEquals(pastebinHomePageForm.getPageTitle(), TITLE, "Title is not correct.");
    }

    @AfterClass(alwaysRun = true, description = "Close browser after tests")
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
