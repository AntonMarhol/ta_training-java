package com.epam.training.student_anton_marhol.framework_practical_task.test;

import com.epam.training.student_anton_marhol.framework_practical_task.business_objects.builder.InstancesCreator;
import com.epam.training.student_anton_marhol.framework_practical_task.business_objects.model.Instances;
import com.epam.training.student_anton_marhol.framework_practical_task.driver.DriverSingleton;
import com.epam.training.student_anton_marhol.framework_practical_task.test_listener.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

    public static String yopmailMail;
    protected static final String GOOGLE_CLOUD_TAB_TITLE = "Google Cloud Pricing Calculator";

    Instances instances = InstancesCreator.withCredentialsFromProperties();
    WebDriver driver;

    @BeforeClass(description = "Open browser and maximize, run fillTheForm method to prepare browser for tests.")
    public void browserSetup() {
        driver= DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true, description = "Close browser in any case")
    public void browserShutDown() {
        DriverSingleton.closeDriver();
    }
}
