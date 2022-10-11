package com.epam.training.student_anton_marhol.hardcore.test;

import com.epam.training.student_anton_marhol.hardcore.ui.page.google.PricingCalculatorMailPage;
import com.epam.training.student_anton_marhol.hardcore.ui.page.yopmail.MailBoxPage;
import com.epam.training.student_anton_marhol.hardcore.ui.page.yopmail.YopmailMailPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorTest extends ParentTestClass{

    @Test (description = "Open pricing calculator, fill the form and send result by mail.")
    public void browserTitle() {
        yopmailMailPage = new YopmailMailPage(driver);
        Assert.assertEquals(yopmailMailPage.getYopmailTabTitle(),BROWSER_TITLE, "Title of page is incorrect.");
    }

    @Test (description = "Compare estimate cost in letter and in calculator.")
    public void totalEstimatedCost() {
        MailBoxPage mailBoxPage = new MailBoxPage(driver);
        PricingCalculatorMailPage pricingCalculatorMailPage = new PricingCalculatorMailPage(driver);
        Assert.assertEquals(mailBoxPage.getEstimatedCostInMail(),pricingCalculatorMailPage.getEstimatedCostInPricingCalculator(), "Total cost in The Letter and in The Calculator is not the same.");
    }
}
