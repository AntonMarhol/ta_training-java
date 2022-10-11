package com.epam.training.student_anton_marhol.framework_practical_task.service;

import com.epam.training.student_anton_marhol.framework_practical_task.business_objects.model.Instances;
import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google.EstimateResultPage;
import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google.GoogleCloudHomePage;

import org.openqa.selenium.WebDriver;

public class PricingCalculatorMaker extends ServiceParentClass{

    protected static final String LOCATOR_FOR_CLOUD_PRICING_CALCULATOR = "Google Cloud Platform Pricing Calculator";

    public PricingCalculatorMaker(WebDriver driver) {
        super(driver);
    }

    public static EstimateResultPage fillTheForm(WebDriver driver, Instances instances) {
        return new GoogleCloudHomePage(driver)
                .openPage()
                .search(LOCATOR_FOR_CLOUD_PRICING_CALCULATOR)
                .openPricingCalculator(LOCATOR_FOR_CLOUD_PRICING_CALCULATOR)
                .activateTabHolder()
                .selectNumberOfInstances(instances)
                .openOperationSystemDropDownList()
                .selectOperationSystem(instances)
                .openProvisioningModelDropDownList()
                .selectProvisioningModel(instances)
                .openSeriesOfMachineDropDownList()
                .selectSeriesOfMachine(instances)
                .openMachineTypeDropDownList()
                .selectMachineType(instances)
                .checkAddGPUsAndFillDependentFields(instances)
                .openLocalSSDDropDownList()
                .selectLocalSSD(instances)
                .openDatacenterLocationDropDownList()
                .selectDatacenterLocation(instances)
                .addCommittedUsage(instances)
                .pushTheButtonAddToEstimate()
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

    public String getTitleOfPage(WebDriver driver) {
        return new GoogleCloudHomePage(driver)
                .openPage()
                .search(LOCATOR_FOR_CLOUD_PRICING_CALCULATOR)
                .openPricingCalculator(LOCATOR_FOR_CLOUD_PRICING_CALCULATOR)
                .getTitle();
    }
}