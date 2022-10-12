package com.epam.training.student_anton_marhol.framework_practical_task.service;

import com.epam.training.student_anton_marhol.framework_practical_task.test_listener.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class ServiceParentClass {

    protected WebDriver driver;

    public ServiceParentClass(WebDriver driver) {
        this.driver = driver;
    }
}
