package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Swither.switchToMyframeOfPricingCalculator;
import com.epam.training.student_anton_marhol.framework_practical_task.business_objects.model.Instances;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingCalculatorFormPage extends GoogleCloudParentPage {

//    private static final By TAB_COMPUTE_ENGINE_XPATH = By.xpath("//div[@title='Compute Engine']");

    @FindBy (xpath = "//div[@title='Compute Engine']")
    private WebElement tabComputeEngineButton;
    @FindBy (xpath = "//label[contains(text(),'Operating System / Software')]/..//md-select-value")
    private WebElement operationSystemDropDownList;
    @FindBy (xpath = "//label[contains(text(),'Provisioning model')]/..//md-select-value")
    private WebElement provisioningModelDropDownList;
    @FindBy (xpath = "//label[contains(text(),'Series')]/..//md-select-value")
    private WebElement seriesOfMachineDropDownList;
    @FindBy (xpath = "//label[contains(text(),'Machine type')]/..//md-select-value")
    private WebElement machineTypeDropDownList;
    @FindBy (xpath = "//label[contains(text(),'Number of instances')]/..//input")
    private WebElement numberOfInstancesPostform;
    @FindBy (xpath = "//md-select[@placeholder='GPU type']")
    private WebElement typeOfGPUDropDownList;
    @FindBy (xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUsDropDownList;
    @FindBy (xpath = "//label[contains(text(),'Local SSD')]/..")
    private WebElement localSSDDropDownList;
    @FindBy (xpath = "//label[contains(text(),'Datacenter location')]/..//md-select")
    private WebElement datacenterLocationDropDownList;
    @FindBy (xpath = "//md-select[contains(@aria-label,'Committed usage: None')]/md-select-value")
    private WebElement committedUsageDropDownList;
    @FindBy (xpath = "//md-checkbox[@aria-label='Add GPUs']/div")
    private WebElement addGPUsCheckBox;
    @FindBy (xpath = "//button[contains(@aria-label,'Add to Estimate')]")
    private WebElement addToEstimateButton;

    public PricingCalculatorFormPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorMailPage fillTheForm(Instances instances){
                new PricingCalculatorFormPage(driver)
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
                        .pushTheButtonAddToEstimate();
        return new PricingCalculatorMailPage(driver);
    }

    public PricingCalculatorFormPage activateTabHolder() {
        LOGGER.info("Activating TAB Compute Engine");
        switchToMyframeOfPricingCalculator(driver);
//        driver.findElement(TAB_COMPUTE_ENGINE_XPATH).click();
        tabComputeEngineButton.click();
        LOGGER.info("TAB Compute Engine activated");
        return this;
    }

    public PricingCalculatorFormPage selectNumberOfInstances(Instances instances) {
        LOGGER.info("Selecting number of instances");
        numberOfInstancesPostform.sendKeys(instances.getNumberOfInstances());
        LOGGER.info("Number of instances selected");
        return this;
    }

    public PricingCalculatorFormPage openOperationSystemDropDownList() {
        LOGGER.info("Opening OS drop down list");
        openDropDownList(operationSystemDropDownList);
        LOGGER.info("OS drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectOperationSystem(Instances instances) {
        LOGGER.info("Selecting OS");
        setNewElement(BASE_LOCATOR, instances.getOperatingSystemOrSoftware());
        LOGGER.info("OS selected");
        return this;
    }

    public PricingCalculatorFormPage openProvisioningModelDropDownList(){
        LOGGER.info("Opening provision model drop down list");
        openDropDownList(provisioningModelDropDownList);
        LOGGER.info("Provision model drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectProvisioningModel(Instances instances){
        LOGGER.info("Selecting provision model");
        setNewElement(BASE_LOCATOR, instances.getProvisioningModel());
        LOGGER.info("Provision model selected");
        return this;
    }

    public PricingCalculatorFormPage openSeriesOfMachineDropDownList(){
        LOGGER.info("Opening Series of machine drop down list");
        openDropDownList(seriesOfMachineDropDownList);
        LOGGER.info("Series of machine drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectSeriesOfMachine(Instances instances){
        LOGGER.info("Selecting machine series.");
        setNewElement(BASE_LOCATOR, instances.getMachineSeries());
        LOGGER.info("Machine series selected");
        return this;
    }

    public PricingCalculatorFormPage openMachineTypeDropDownList(){
        LOGGER.info("Opening machine type drop down list");
        openDropDownList(machineTypeDropDownList);
        LOGGER.info("Machine type drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectMachineType(Instances instances){
        LOGGER.info("Selecting machine type");
        setNewElement(BASE_LOCATOR, instances.getMachineType());
        LOGGER.info("Machine type selected");
        return this;
    }

    public PricingCalculatorFormPage checkAddGPUsAndFillDependentFields (Instances instances) {
        LOGGER.info("Checking of necessity add GPUs");
        if (instances.getCheckboxAddGPU().equals("true")) {
            LOGGER.info("Adding GPUs is necessity. Adding it.");
            pushAddGPUCheckBox();
            openTypeOfGPUDropDownList();
            selectTypeOfGPU(instances);
            openNumberOfGPUDropDownList();
            selectNumberOfGPU(instances);
            LOGGER.info("GPUs added");
        }
        else {
            LOGGER.info("Adding GPUs is NOT necessity");
        }
        return this;
    }

    public PricingCalculatorFormPage addCommittedUsage(Instances instances) {
        LOGGER.info("Checking of necessity add Committed usage");
        if (instances.getCommittedUsagePeriod().equals("Yes")){
            LOGGER.info("Add committed usage is necessity. Adding it.");
            openCommittedUsageDropDownList();
            selectCommittedUsage(instances);
            LOGGER.info("Committed usage added");
        }
        else {
            LOGGER.info("Add Committed usage is NOT necessity");
        }
        return this;
    }

    public PricingCalculatorFormPage pushAddGPUCheckBox() {
        LOGGER.info("Activating add GPU check-box");
        if (!addGPUsCheckBox.isSelected()) {
            addGPUsCheckBox.click();
            LOGGER.info("Add GPU check-box activated");
        }
        else {
            LOGGER.info("Add GPU check-box have already activated before");
        }

        return this;
    }

    public PricingCalculatorFormPage openTypeOfGPUDropDownList() {
        LOGGER.info("Opening type of GPU drop down list");
        openDropDownList(typeOfGPUDropDownList);
        LOGGER.info("Type of GPU drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectTypeOfGPU(Instances instances){
        LOGGER.info("Selecting GPU type");
        setNewElement(BASE_LOCATOR, instances.getTypeOfGPU());
        LOGGER.info("GPU type selected");
        return this;
    }

    public PricingCalculatorFormPage openNumberOfGPUDropDownList() {
        LOGGER.info("Opening number of GPU type drop down list");
        openDropDownList(numberOfGPUsDropDownList);
        LOGGER.info("Number of GPU type drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectNumberOfGPU(Instances instances) {
        LOGGER.info("Selecting number of GPUs");
        setNewElement(NUMBER_OF_GPU_LOCATOR, instances.getNumberOfGPUs());
        LOGGER.info("Number of GPUs selected");
        return this;
    }

    public PricingCalculatorFormPage openLocalSSDDropDownList() {
        LOGGER.info("Opening Local SSD drop down list");
        openDropDownList(localSSDDropDownList);
        LOGGER.info("Local SSD drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectLocalSSD(Instances instances) {
        LOGGER.info("Selecting local SSD");
        setNewElement(BASE_LOCATOR, instances.getLocalSSD());
        LOGGER.info("Local SSD selected");
        return this;
    }

    public PricingCalculatorFormPage openDatacenterLocationDropDownList() {
        LOGGER.info("Opening data center drop down list");
        openDropDownList(datacenterLocationDropDownList);
        LOGGER.info("Data center drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectDatacenterLocation(Instances instances) {
        LOGGER.info("Selecting datacenter location");
        setNewElement(DATACENTER_LOCATION_LOCATOR, instances.getDatacenterLocation());
        LOGGER.info("Datacenter location selected");
        return this;
    }

    public PricingCalculatorFormPage openCommittedUsageDropDownList() {
        LOGGER.info("Opening committed usage drop down list");
        openDropDownList(committedUsageDropDownList);
        LOGGER.info("Committed usage drop down list opened");
        return this;
    }

    public PricingCalculatorFormPage selectCommittedUsage(Instances instances){
        LOGGER.info("Selecting committed usage");
        setNewElement(COMMITTED_USAGE_LOCATOR, instances.getCommittedUsage());
        LOGGER.info("Committed usage selected");
        return this;
    }

    public PricingCalculatorMailPage pushTheButtonAddToEstimate(){
        LOGGER.info("Clicking add to Estimate");
        addToEstimateButton.click();
        LOGGER.info("Added to Estimate");
        return new PricingCalculatorMailPage(driver);
    }

    public String getTitle() {
        LOGGER.info("Looking for Pricing calculator tab title");
        switchToMyframeOfPricingCalculator(driver);
        LOGGER.info("Returning Pricing calculator tab title");
        return driver.getTitle();
    }
}
