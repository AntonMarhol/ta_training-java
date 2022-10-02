package com.epam.training.student_anton_marhol.framework_practical_task.util;

public class StringUtils {

    public static String createXPath(String baseLocator, String instanceValue){

        return String.format(baseLocator,instanceValue);
    }
}
