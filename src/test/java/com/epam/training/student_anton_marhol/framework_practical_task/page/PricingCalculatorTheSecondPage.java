package com.epam.training.student_anton_marhol.framework_practical_task.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.training.student_anton_marhol.framework_practical_task.model.Instances;
import static com.epam.training.student_anton_marhol.framework_practical_task.util.StringUtils.createXPath;

public class PricingCalculatorTheSecondPage extends ParentPage {

    protected static final String NUMBER_OF_GPU_LOCATOR = "//*[@id='select_container_466']//child::div[contains(text(),'%s')]/..";
    protected static final String DATACENTER_LOCATION_LOCATOR = "//*[@id='select_container_124']//child::md-option/child::div[contains(text(),'%s')]/..";
    protected static final String COMMITTED_USAGE_LOCATOR = "//*[@id='select_container_131']//child::md-option/child::div[contains(text(),'%s')]/..";
                                                             // CLICK TO SELECT DATA IN FORM
    @FindBy (id = "select_463")
    WebElement clickToSelectGPUType;

    @FindBy (id = "select_465")
    WebElement clickToSelectNumberOfGPUs;

    @FindBy (xpath = "//md-input-container[@class='md-input-has-placeholder md-input-has-value flex']/child::label[contains(text(),'Local SSD')]/..")
    WebElement clickToSelectLocalSSD;

    @FindBy (id = "select_value_label_88")
    WebElement clickToSelectDatacenterLocation;

    @FindBy (id = "select_value_label_89")
    WebElement clickToCommittedUsage;
                                                                        // BUTTON AND CHECK-BOX
    @FindBy (xpath = "//md-checkbox[@aria-label='Add GPUs']/div")
    WebElement checkBoxAddGPUs;

    @FindBy (xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    WebElement buttonAddToEstimate;

    public PricingCalculatorTheSecondPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorTheSecondPage fillTheSecondPartOfForm(Instances instances){
                                                                               // SELECT CHECK-BOX
        if (instances.getAddGPU().equals("true")) {
            if (!checkBoxAddGPUs.isSelected()) {
                clickByScript(checkBoxAddGPUs);
            }
            setNewElement(clickToSelectGPUType, createXPath(BASE_LOCATOR, instances.getTypeOfGPU()));
            setNewElement(clickToSelectNumberOfGPUs, createXPath(NUMBER_OF_GPU_LOCATOR, instances.getNumberOfGPUs()));
        }
        else {
            if (checkBoxAddGPUs.isSelected()) {
                clickByScript(checkBoxAddGPUs);
            }
        }
                                                                               // SELECT LOCAL SSD
        setNewElement(clickToSelectLocalSSD,createXPath(BASE_LOCATOR, instances.getLocalSSD()));
                                                                              // SELECT DATACENTER LOCATION (REGION)
        setNewElement(clickToSelectDatacenterLocation,createXPath(DATACENTER_LOCATION_LOCATOR, instances.getDatacenterLocation()));
                                                                             // SELECT COMMITTED USAGE (COMMITMENT TERM)
        if (instances.getCommittedUsagePeriod().equals("Yes")) {
            setNewElement(clickToCommittedUsage,createXPath(COMMITTED_USAGE_LOCATOR, instances.getCommittedUsage()));
        }
    return this;
}

    public SendEstimateByMailPage pressTheButtonAddToEstimate(){
        buttonAddToEstimate.click();
        return new SendEstimateByMailPage(driver);
    }
}


