package com.epam.training.student_anton_marhol.framework_practical_task.business_objects.builder;

import java.util.ResourceBundle;

public class InstancesReader {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("parameters"));

    public static String getInstances(String key) {
        return resourceBundle.getString(key);
    }
}
