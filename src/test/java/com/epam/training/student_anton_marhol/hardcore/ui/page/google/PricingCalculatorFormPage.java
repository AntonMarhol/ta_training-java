package com.epam.training.student_anton_marhol.hardcore.ui.page.google;

import static com.epam.training.student_anton_marhol.hardcore.ui.util.FrameSwitches.switchToMyframeOfPricingCalculator;
import static com.epam.training.student_anton_marhol.hardcore.ui.util.LocatorCreator.*;
import com.epam.training.student_anton_marhol.hardcore.ui.page.yopmail.MailBoxPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingCalculatorFormPage extends GoogleCloudParentPage {

    private static final String TAB_COMPUTE_ENGINE_XPATH = "//div[@title='Compute Engine']";

    @FindBy (xpath = "//label[contains(text(),'Operating System / Software')]/..//md-select-value")
    WebElement operationSystemDropDownList;
    @FindBy (xpath = "//label[contains(text(),'Provisioning model')]/..//md-select-value")
    WebElement provisioningModelDropDownList;
    @FindBy (xpath = "//label[contains(text(),'Series')]/..//md-select-value")
    WebElement seriesOfMachineDropDownList;
    @FindBy (xpath = "//label[contains(text(),'Machine type')]/..//md-select-value")
    WebElement machineTypeDropDownList;
    @FindBy (xpath = "//label[contains(text(),'Number of instances')]/..//input")
    WebElement numberOfInstancesPostform;
    @FindBy (xpath = "//md-select[@placeholder='GPU type']")
    WebElement typeOfGPUDropDownList;
    @FindBy (xpath = "//md-select[@placeholder='Number of GPUs']")
    WebElement numberOfGPUsDropDownList;
    @FindBy (xpath = "//label[contains(text(),'Local SSD')]/..")
    WebElement localSSDDropDownList;
    @FindBy (xpath = "//label[contains(text(),'Datacenter location')]/..//md-select")
    WebElement datacenterLocationDropDownList;
    @FindBy (xpath = "//md-select[contains(@aria-label,'Committed usage: None')]/md-select-value")
    WebElement committedUsageDropDownList;
    @FindBy (xpath = "//md-checkbox[@aria-label='Add GPUs']/div")
    WebElement addGPUsCheckBox;
    @FindBy (xpath = "//button[contains(@aria-label,'Add to Estimate')]")
    WebElement addToEstimateButton;

    public PricingCalculatorFormPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorFormPage activateTabHolder() {
        switchToMyframeOfPricingCalculator(driver);
        driver.findElement(By.xpath(TAB_COMPUTE_ENGINE_XPATH)).click();
        return this;
    }

    public PricingCalculatorFormPage selectNumberOfInstances(String number) {
        numberOfInstancesPostform.sendKeys(number);
        return this;
    }

    public PricingCalculatorFormPage openOperationSystemDropDownList() {
        operationSystemDropDownList.click();
        return this;
    }

    public PricingCalculatorFormPage selectOperationSystem(String operationSystem) {
        setElement(BASE_LOCATOR, operationSystem);
        return this;
    }

    public PricingCalculatorFormPage openProvisioningModelDropDownList(){
        provisioningModelDropDownList.click();
        return this;
    }

    public PricingCalculatorFormPage selectProvisioningModel(String provisioningModel){
        setElement(BASE_LOCATOR, provisioningModel);
        return this;
    }

    public PricingCalculatorFormPage openSeriesOfMachineDropDownList(){
        seriesOfMachineDropDownList.click();
        return this;
    }

    public PricingCalculatorFormPage selectSeriesOfMachine(String seriesOfMachine){
        setElement(BASE_LOCATOR, seriesOfMachine);
        return this;
    }

    public PricingCalculatorFormPage openMachineTypeDropDownList(){
        machineTypeDropDownList.click();
        return this;
    }

    public PricingCalculatorFormPage selectMachineType(String machineType){
        setElement(BASE_LOCATOR, machineType);
        return this;
    }

    public PricingCalculatorFormPage pushOnCheckBox() {
        if (!addGPUsCheckBox.isSelected()) addGPUsCheckBox.click();
        return this;
    }

    public PricingCalculatorFormPage openTypeOfGPUDropDownList() {
        typeOfGPUDropDownList.click();
        return this;
    }

    public PricingCalculatorFormPage selectTypeOfGPU(String typeOfGPU){
        setElement(BASE_LOCATOR, typeOfGPU);
        return this;
    }

    public PricingCalculatorFormPage openNumberOfGPUDropDownList() {
        numberOfGPUsDropDownList.click();
        return this;
    }

    public PricingCalculatorFormPage selectNumberOfGPU(String numberOfGPU) {
        setElement(NUMBER_OF_GPU_LOCATOR, numberOfGPU);
        return this;
    }

    public PricingCalculatorFormPage openLocalSSDDropDownList() {
        localSSDDropDownList.click();
        return this;
    }

    public PricingCalculatorFormPage selectLocalSSD(String localSSD) {
        setElement(BASE_LOCATOR, localSSD);
        return this;
    }

    public PricingCalculatorFormPage openDatacenterLocationDropDownList() {
        datacenterLocationDropDownList.click();
        return this;
    }

    public PricingCalculatorFormPage selectDatacenterLocation(String datacenterLocation) {
        setElement(DATACENTER_LOCATION_LOCATOR, datacenterLocation);
        return this;
    }

    public PricingCalculatorFormPage openCommittedUsageDropDownList() {
        committedUsageDropDownList.click();
        return this;
    }

    public PricingCalculatorFormPage selectCommittedUsage(String committedUsage){
        setElement(COMMITTED_USAGE_LOCATOR, committedUsage);
        return this;
    }

    public MailBoxPage pressTheButtonAddToEstimate(){
        addToEstimateButton.click();
        return new MailBoxPage(driver);
    }
}
