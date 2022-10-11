package com.epam.training.student_anton_marhol.framework_practical_task.test;

import com.epam.training.student_anton_marhol.framework_practical_task.service.PricingCalculatorMaker;
import com.epam.training.student_anton_marhol.framework_practical_task.service.YopmailMaker;
import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google.EstimateResultPage;
import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.yopmail.YopmailMailPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorTest extends CommonConditions {

    EstimateResultPage estimateResultPage;

    @Test(description = "Fill the form and send estimate by email")
    public void formSetup() {
        estimateResultPage = PricingCalculatorMaker.fillTheForm(driver, instances);
        Assert.assertEquals(estimateResultPage.getTitle(driver), GOOGLE_CLOUD_TAB_TITLE, "Tab title is incorrect");
    }

    @Test(priority = 1, description = "Compare generated email address and address in mail box")
    public void mailAddress() {
        Assert.assertEquals(new YopmailMaker(driver).getEmailAddressInLetter(), yopmailMail, "Generated email is different from mail box email.");
    }

    @Test(priority = 1, description = "Compare estimated cost in mail and on estimate page")
    public void totalEstimatedCost() {
        Assert.assertEquals(new YopmailMailPage(driver).getTotalEstimatedCostInMail(), estimateResultPage.getTotalEstimatedCostInPricingCalculator(), "Total cost in The Letter and in The Calculator is not the same.");
    }
}
