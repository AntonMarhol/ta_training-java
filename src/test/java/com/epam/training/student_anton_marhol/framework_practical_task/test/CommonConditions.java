package com.epam.training.student_anton_marhol.framework_practical_task.test;

import com.epam.training.student_anton_marhol.framework_practical_task.driver.CreateDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CommonConditions {

    public static String yopmailMail;

    protected static final String GOOGLE_CLOUD_TAB_TITLE = "Google Cloud Pricing Calculator";

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver= CreateDriver.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void browserShutDown() {
        CreateDriver.closeDriver();
    }
}
