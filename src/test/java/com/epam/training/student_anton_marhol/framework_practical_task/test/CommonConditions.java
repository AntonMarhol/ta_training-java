package com.epam.training.student_anton_marhol.framework_practical_task.test;

import com.epam.training.student_anton_marhol.framework_practical_task.driver.DriverSingleton;
import com.epam.training.student_anton_marhol.framework_practical_task.util.TestListener;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

    public static String yopmailMail;

    protected static final String GOOGLE_CLOUD_TAB_TITLE = "Google Cloud Pricing Calculator";

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver= DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void browserShutDown() {
        DriverSingleton.closeDriver();
    }
}
