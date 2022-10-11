package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.FrameAndTabSwithers.switchToMyframeOfPricingCalculator;
import com.epam.training.student_anton_marhol.framework_practical_task.business_objects.model.Instances;

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
        LOGGER.info("TAB Compute Engine activated");
        return this;
    }

    public PricingCalculatorFormPage selectNumberOfInstances(Instances instances) {
        numberOfInstancesPostform.sendKeys(instances.getNumberOfInstances());
        LOGGER.info("Number of instances selected");
        return this;
    }

    public PricingCalculatorFormPage openOperationSystemDropDownList() {
        openDropDownList(operationSystemDropDownList);
        LOGGER.info("OS drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectOperationSystem(Instances instances) {
        setNewElement(BASE_LOCATOR, instances.getOperatingSystemOrSoftware());
        LOGGER.info("OS selected");
        return this;
    }

    public PricingCalculatorFormPage openProvisioningModelDropDownList(){
        openDropDownList(provisioningModelDropDownList);
        LOGGER.info("Provision model drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectProvisioningModel(Instances instances){
        setNewElement(BASE_LOCATOR, instances.getProvisioningModel());
        LOGGER.info("Provision model selected");
        return this;
    }

    public PricingCalculatorFormPage openSeriesOfMachineDropDownList(){
        openDropDownList(seriesOfMachineDropDownList);
        LOGGER.info("Series of machine drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectSeriesOfMachine(Instances instances){
        setNewElement(BASE_LOCATOR, instances.getMachineSeries());
        LOGGER.info("Machine series selected");
        return this;
    }

    public PricingCalculatorFormPage openMachineTypeDropDownList(){
        openDropDownList(machineTypeDropDownList);
        LOGGER.info("Machine type drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectMachineType(Instances instances){
        setNewElement(BASE_LOCATOR, instances.getMachineType());
        LOGGER.info("Machine type selected");
        return this;
    }

    public PricingCalculatorFormPage checkAddGPUsAndFillDependentFields (Instances instances) {
        if (instances.getCheckboxAddGPU().equals("true")) {
            pushAddGPUCheckBox();
            openTypeOfGPUDropDownList();
            selectTypeOfGPU(instances);
            openNumberOfGPUDropDownList();
            selectNumberOfGPU(instances);
        }
        return this;
    }

    public PricingCalculatorFormPage addCommittedUsage(Instances instances) {
        if (instances.getCommittedUsagePeriod().equals("Yes")){
            openCommittedUsageDropDownList();
            selectCommittedUsage(instances);
        }
        return this;
    }

    public PricingCalculatorFormPage pushAddGPUCheckBox() {
        if (!addGPUsCheckBox.isSelected()) {
            addGPUsCheckBox.click();
        }
        LOGGER.info("Add GPU check-box activated");
        return this;
    }

    public PricingCalculatorFormPage openTypeOfGPUDropDownList() {
        openDropDownList(typeOfGPUDropDownList);
        LOGGER.info("Type of GPU drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectTypeOfGPU(Instances instances){
        setNewElement(BASE_LOCATOR, instances.getTypeOfGPU());
        LOGGER.info("GPU type selected");
        return this;
    }

    public PricingCalculatorFormPage openNumberOfGPUDropDownList() {
        openDropDownList(numberOfGPUsDropDownList);
        LOGGER.info("Number of GPU type drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectNumberOfGPU(Instances instances) {
        setNewElement(NUMBER_OF_GPU_LOCATOR, instances.getNumberOfGPUs());
        LOGGER.info("Number GPUs selected");
        return this;
    }

    public PricingCalculatorFormPage openLocalSSDDropDownList() {
        openDropDownList(localSSDDropDownList);
        LOGGER.info("Local SSD drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectLocalSSD(Instances instances) {
        setNewElement(BASE_LOCATOR, instances.getLocalSSD());
        LOGGER.info("Local SSD selected");
        return this;
    }

    public PricingCalculatorFormPage openDatacenterLocationDropDownList() {
        openDropDownList(datacenterLocationDropDownList);
        LOGGER.info("Data center drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectDatacenterLocation(Instances instances) {
        setNewElement(DATACENTER_LOCATION_LOCATOR, instances.getDatacenterLocation());
        LOGGER.info("Datacenter location selected");
        return this;
    }

    public PricingCalculatorFormPage openCommittedUsageDropDownList() {
        openDropDownList(committedUsageDropDownList);
        LOGGER.info("Committed usage drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectCommittedUsage(Instances instances){
        setNewElement(COMMITTED_USAGE_LOCATOR, instances.getCommittedUsage());
        LOGGER.info("Committed usage selected");
        return this;
    }

    public PricingCalculatorMailPage pushTheButtonAddToEstimate(){
        addToEstimateButton.click();
        LOGGER.info("Added to Estimate");
        return new PricingCalculatorMailPage(driver);
    }

    public String getTitle() {
        switchToMyframeOfPricingCalculator(driver);
        return driver.getTitle();
    }
}
