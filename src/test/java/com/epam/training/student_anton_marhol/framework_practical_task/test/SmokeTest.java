package com.epam.training.student_anton_marhol.framework_practical_task.test;

import com.epam.training.student_anton_marhol.framework_practical_task.service.PricingCalculatorMaker;
import com.epam.training.student_anton_marhol.framework_practical_task.service.YopmailMaker;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends CommonCondition {

    @Test(groups = { "smoketest" }, description = "Check for Pricing calculator page will open and compare title")
    public void basicGoogleCloudFunction() {
        Assert.assertEquals(new PricingCalculatorMaker(driver).getTitleOfPage(driver), GOOGLE_CLOUD_TAB_TITLE, "Tab title is incorrect");
    }

    @Test(groups = { "smoketest" }, description = "Compare generated email with email in the mail box ")
    public void basicYopmailFunction() {
        Assert.assertEquals(new YopmailMaker(driver).getYopmailEmailAddress(), yopmailMail, "Generated email is different from mail box email.");
    }
}
