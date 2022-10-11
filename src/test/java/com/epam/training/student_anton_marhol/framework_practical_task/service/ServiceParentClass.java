package com.epam.training.student_anton_marhol.framework_practical_task.service;

import org.openqa.selenium.WebDriver;

public class ServiceParentClass {

    protected WebDriver driver;

    public ServiceParentClass(WebDriver driver) {
        this.driver = driver;
    }
}
