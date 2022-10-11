package com.epam.training.student_anton_marhol.hurt_me_plenty.ui.util;

public class LocatorCreator {

    public static final String BASE_LOCATOR = "//md-option/child::div[contains(text(),'%s')]";
    public static final String NUMBER_OF_GPU_LOCATOR = "//md-option[contains(@value,'%s') and contains(@ng-disabled,'minGPU')]";
    public static final String DATACENTER_LOCATION_LOCATOR = "//md-select-menu[contains(@class,'md-overflow')]//div[contains(text(),'%s')]/..";
    public static final String COMMITTED_USAGE_LOCATOR = "//div[contains(@class,'md-active')]//div[contains(text(),'%s')]/..";

    public static String createXPath(String baseLocator, String instanceValue){
        return String.format(baseLocator,instanceValue);
    }
}
