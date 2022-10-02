package com.epam.training.student_anton_marhol.framework_practical_task.service;

import java.util.ResourceBundle;

public class InstancesReader {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("settings"));

    public static String getInstances(String key) {
        return resourceBundle.getString(key);
    }
}
