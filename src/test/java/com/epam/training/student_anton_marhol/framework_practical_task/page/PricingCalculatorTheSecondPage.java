package com.epam.training.student_anton_marhol.framework_practical_task.page;

import com.epam.training.student_anton_marhol.framework_practical_task.model.Instances;
import static com.epam.training.student_anton_marhol.framework_practical_task.util.StringUtils.createXPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PricingCalculatorTheSecondPage extends ParentPage {

    protected static final String NUMBER_OF_GPU_LOCATOR = "//*[@id='select_container_466']//child::div[contains(text(),'%s')]/..";
    protected static final String DATACENTER_LOCATION_LOCATOR = "//*[@id='select_container_124']//child::md-option/child::div[contains(text(),'%s')]/..";
    protected static final String COMMITTED_USAGE_LOCATOR = "//*[@id='select_container_131']//child::md-option/child::div[contains(text(),'%s')]/..";
                                                                      // CLICK TO OPEN DROP DOWN LIST
    @FindBy (id = "select_463")
    WebElement GPUTypeDropDownList;

    @FindBy (id = "select_465")
    WebElement numberOfGPUsDropDownList;

    @FindBy (xpath = "//label[contains(text(),'Local SSD')]/..")
    WebElement localSSDDropDownList;

    @FindBy (id = "select_value_label_88")
    WebElement datacenterLocationDropDownList;

    @FindBy (id = "select_value_label_89")
    WebElement committedUsageDropDownList;
                                                                        // BUTTON AND CHECK-BOX
    @FindBy (xpath = "//md-checkbox[@aria-label='Add GPUs']/div")
    WebElement checkBoxAddGPUs;

    @FindBy (xpath = "//button[contains(@class,'md-raised md-primary cpc-button md-button md-ink-ripple') and contains(text(),'Add to Estimate')]")
    WebElement buttonAddToEstimate;

    public PricingCalculatorTheSecondPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorTheSecondPage fillTheSecondPartOfForm(Instances instances){
        if (instances.getCheckboxAddGPU().equals("true")) {
            scrollPageByAmount(0,200);
            if (!checkBoxAddGPUs.isSelected()) clickByJavaScript(checkBoxAddGPUs);
            logger.info("Checkbox Add GPU selected");
            setNewElement(GPUTypeDropDownList, createXPath(BASE_LOCATOR, instances.getTypeOfGPU()));
            setNewElement(numberOfGPUsDropDownList, createXPath(NUMBER_OF_GPU_LOCATOR, instances.getNumberOfGPUs()));
        }
        else {
            if (checkBoxAddGPUs.isSelected()) {
                scrollPageByAmount(0, 200);
                clickByJavaScript(checkBoxAddGPUs);
                logger.info("Checkbox Add GPU unselected");
            }
        }
        setNewElement(localSSDDropDownList,createXPath(BASE_LOCATOR, instances.getLocalSSD()));
        setNewElement(datacenterLocationDropDownList,createXPath(DATACENTER_LOCATION_LOCATOR, instances.getDatacenterLocation()));

        if (instances.getCommittedUsagePeriod().equals("Yes")) {
            setNewElement(committedUsageDropDownList,createXPath(COMMITTED_USAGE_LOCATOR, instances.getCommittedUsage()));
        }
    return this;
}

    public SendEstimateByMailPage pressTheButtonAddToEstimate(){
        buttonAddToEstimate.click();
        logger.info("Added to Estimate");
        return new SendEstimateByMailPage(driver);
    }
}


