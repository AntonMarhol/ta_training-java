package com.epam.training.student_anton_marhol.i_can_win.util;

public class LocatorCreator {

    public static final String BASE_LOCATOR = "//li[text()='%s']";

    public static String createXPath(String baseLocator, String instanceValue){

        return String.format(baseLocator,instanceValue);
    }
}
