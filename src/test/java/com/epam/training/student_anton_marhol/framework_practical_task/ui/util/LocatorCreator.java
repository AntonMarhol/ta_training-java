package com.epam.training.student_anton_marhol.framework_practical_task.ui.util;

public class LocatorCreator {

    public static String createXPath(String baseLocator, String instanceValue){
        return String.format(baseLocator,instanceValue);
    }
}
