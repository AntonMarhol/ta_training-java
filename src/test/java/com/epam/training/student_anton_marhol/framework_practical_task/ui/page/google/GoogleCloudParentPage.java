package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google;

import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.ParentPage;

import org.openqa.selenium.WebDriver;

public class GoogleCloudParentPage extends ParentPage {

    protected static final String BASE_LOCATOR = "//md-option/child::div[contains(text(),'%s')]";
    protected static final String NUMBER_OF_GPU_LOCATOR = "//md-option[contains(@value,'%s') and contains(@ng-disabled,'minGPU')]";
    protected static final String DATACENTER_LOCATION_LOCATOR = "//md-select-menu[contains(@class,'md-overflow')]//div[contains(text(),'%s')]/..";
    protected static final String COMMITTED_USAGE_LOCATOR = "//div[contains(@class,'md-active')]//div[contains(text(),'%s')]/..";

    public GoogleCloudParentPage(WebDriver driver) {
        super(driver);
    }
}
