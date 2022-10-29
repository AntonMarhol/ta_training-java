package com.epam.training.student_anton_marhol.framework_practical_task.test_listener;

import com.epam.training.student_anton_marhol.framework_practical_task.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener extends TestListenerAdapter implements IConfigurationListener {

    private Logger log = LogManager.getRootLogger();

    @Override
    public void onConfigurationFailure(ITestResult var1) {
        saveScreenshot();
        log.info("Configuration didn't prepare.");
    }

    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
        log.info("Test failed. ");
    }

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) DriverSingleton.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                    + getCurrentTimeAsString() +
                    ".png"));
            log.error("Save screenshot");
        }
        catch (IOException ioException){
            log.error("Failed to save screenshot: " + ioException.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(dateTimeFormatter);
    }
}
