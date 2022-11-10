package com.epam.training.student_anton_marhol.framework_practical_task.service;

import com.epam.training.student_anton_marhol.framework_practical_task.business_objects.model.Instances;
import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google.EstimateResultPage;
import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google.GoogleCloudHomePage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Configuration;

public class PricingCalculatorMaker extends ServiceParentClass{

    protected static final String LOCATOR_FOR_CLOUD_PRICING_CALCULATOR = "Google Cloud Platform Pricing Calculator";

    public PricingCalculatorMaker(WebDriver driver) {
        super(driver);
    }

    @SuppressWarnings("deprecation")
    @Configuration(description = "fill the form in pricing calculator fot prepare page for tests, send letter with estimate result and wait for it")
    public static EstimateResultPage fillTheForm(WebDriver driver, Instances instances) {
        return new GoogleCloudHomePage(driver)
                .openPage()
                .search(LOCATOR_FOR_CLOUD_PRICING_CALCULATOR)
                .openPricingCalculator(LOCATOR_FOR_CLOUD_PRICING_CALCULATOR)
                .fillTheForm(instances)
                .openMailAddressForm()
                .openNewTab()
                .goToYopmailHomePage()
                .openYopmail()
                .generateMail()
                .copyGeneratedMail()
                .goToPricingCalculatorTab()
                .fillMailAddressForm()
                .clickSendEstimateByMailButton()
                .goToYopmailMailPage()
                .clickCheckInboxButton()
                .checkForLetter();
    }

    @SuppressWarnings("deprecation")
    @Configuration(description = "looking for pricing calculator and return its page title")
    public String getTitleOfPage(WebDriver driver) {
        return new GoogleCloudHomePage(driver)
                .openPage()
                .search(LOCATOR_FOR_CLOUD_PRICING_CALCULATOR)
                .openPricingCalculator(LOCATOR_FOR_CLOUD_PRICING_CALCULATOR)
                .getTitle();
    }
}
