package com.epam.training.student_anton_marhol.framework_practical_task.page;

import com.epam.training.student_anton_marhol.framework_practical_task.model.Instances;
import static com.epam.training.student_anton_marhol.framework_practical_task.util.StringUtils.createXPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingCalculatorTheFirstPage extends ParentPage {

    private static final String TAB_COMPUTE_ENGINE_XPATH = "//div[@class='tab-holder compute']";

                                                                    // CLICK TO SELECT DATA IN FORM
    @FindBy (id = "select_value_label_82")
    WebElement operationSystemDropDownList;

    @FindBy (id = "select_value_label_83")
    WebElement provisioningModelDropDownList;

    @FindBy (id = "select_value_label_85")
    WebElement seriesOfMachineDropDownList;

    @FindBy (id = "select_value_label_86")
    WebElement machineTypeDropDownList;
                                                                    // SELECT DATA TO FILL
    @FindBy (id = "input_90")
    WebElement fieldNumberOfInstances;

    public PricingCalculatorTheFirstPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorTheFirstPage activateTabHolder() {
        switchToMyframeOfPricingCalculator();
        driver.findElement(By.xpath(TAB_COMPUTE_ENGINE_XPATH)).click();
        logger.info("TAB Compute Engine activated");
        return this;
    }

    public PricingCalculatorTheSecondPage fillTheFisrstPartOfForm(Instances instances){
        fieldNumberOfInstances.sendKeys(instances.getNumberOfInstances());
        logger.info("Number of Instances selected");

        setNewElement(operationSystemDropDownList,createXPath(BASE_LOCATOR, instances.getOperatingSystemOrSoftware()));
        setNewElement(provisioningModelDropDownList,createXPath(BASE_LOCATOR, instances.getProvisioningModel()));
        setNewElement(seriesOfMachineDropDownList,createXPath(BASE_LOCATOR, instances.getMachineSeries()));
        setNewElement(machineTypeDropDownList,createXPath(BASE_LOCATOR, instances.getMachineType()));

        return new PricingCalculatorTheSecondPage(driver);
    }

    public String getTitleOfCurrentPage() {
        switchToMyframeOfPricingCalculator();
        return driver.getTitle();
    }
}
