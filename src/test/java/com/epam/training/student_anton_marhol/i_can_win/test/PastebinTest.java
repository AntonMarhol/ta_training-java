package com.epam.training.student_anton_marhol.i_can_win.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastebinTest {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPasteOnPestebin() {

        new PastebinHomePage(driver)
                .openPage()
                .fillFields()
                .createNewPaste();
    }

    @AfterMethod(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
