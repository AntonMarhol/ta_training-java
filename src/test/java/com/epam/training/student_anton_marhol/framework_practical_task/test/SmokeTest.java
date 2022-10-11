package com.epam.training.student_anton_marhol.framework_practical_task.test;

import com.epam.training.student_anton_marhol.framework_practical_task.service.PricingCalculatorMaker;
import com.epam.training.student_anton_marhol.framework_practical_task.service.YopmailMaker;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends CommonConditions {

    @Test(description = "Check for Pricing calculator page will open and compare title")
    public void basicGoogleCloudFunction() {
        PricingCalculatorMaker pricingCalculatorMaker = new PricingCalculatorMaker(driver);
        Assert.assertEquals(pricingCalculatorMaker.getTitleOfPage(driver), GOOGLE_CLOUD_TAB_TITLE, "Tab title is incorrect");
    }

    @Test(description = "Compare generated email with email in the mail box ")
    public void basicYopmailFunction() {
        YopmailMaker yopmailMaker = new YopmailMaker(driver);
        Assert.assertEquals(yopmailMaker.getYopmailEmailAddress(), yopmailMail, "Generated email is different from mail box email.");
    }
}
