package com.epam.training.student_anton_marhol.hardcore.test;

import com.epam.training.student_anton_marhol.hardcore.service.FormFiller;
import com.epam.training.student_anton_marhol.hardcore.ui.page.yopmail.YopmailMailPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ParentTestClass {

    protected static final String BROWSER_TITLE = "Inbox";

    YopmailMailPage yopmailMailPage;
    WebDriver driver;

    @BeforeClass(description = "open browser and maximize, do fillTheForm method to prepare browser for tests")
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        yopmailMailPage = FormFiller.fillTheForm(driver);
    }

    @AfterClass(alwaysRun = true, description = "close browser in all cases")
    public void browserShutDown() {
        driver.quit();
    }
}
