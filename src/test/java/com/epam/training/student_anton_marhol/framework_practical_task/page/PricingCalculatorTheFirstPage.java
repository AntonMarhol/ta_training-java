package com.epam.training.student_anton_marhol.framework_practical_task.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.training.student_anton_marhol.framework_practical_task.model.Instances;
import static com.epam.training.student_anton_marhol.framework_practical_task.util.StringUtils.createXPath;

public class PricingCalculatorTheFirstPage extends ParentPage {

    private static final String TAB_COMPUTE_ENGINE_XPATH = "//div[@class='tab-holder compute']";

                                                            // CLICK TO SELECT DATA IN FORM
    @FindBy (id = "select_value_label_82")
    WebElement clickToSelectOS;

    @FindBy (id = "select_value_label_83")
    WebElement clickToSelectProvisioningModel;

    @FindBy (id = "select_value_label_85")
    WebElement clickToSelectSeriesOfMachine;

    @FindBy (id = "select_value_label_86")
    WebElement clickToSelectMachineType;
                                                                    // SELECT DATA TO FILL
    @FindBy (id = "input_90")
    WebElement selectNumberOfInstances;

    public PricingCalculatorTheFirstPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorTheFirstPage activateTabHolder() {
        waitForPricingCalculatorFrames();

        driver.findElement(By.xpath(TAB_COMPUTE_ENGINE_XPATH)).click();

        return this;
    }

    public PricingCalculatorTheSecondPage fillTheFisrstPartOfForm(Instances instances){
        selectNumberOfInstances.sendKeys(instances.getNumberOfInstances());
                                                                            // SELECT OS
        setNewElement(clickToSelectOS,createXPath(BASE_LOCATOR, instances.getOperatingSystemOrSoftware()));
                                                                            // SELECT PROVISIONING MODEL
        setNewElement(clickToSelectProvisioningModel,createXPath(BASE_LOCATOR, instances.getProvisioningModel()));
                                                                            // SELECT SERIES OF MACHINE
        setNewElement(clickToSelectSeriesOfMachine,createXPath(BASE_LOCATOR, instances.getMachineSeries()));
                                                                            // SELECT MACHINE TYPE (INSTANCE TYPE)
        setNewElement(clickToSelectMachineType,createXPath(BASE_LOCATOR, instances.getMachineType()));

        return new PricingCalculatorTheSecondPage(driver);
    }

    public String getTitleOfCurrentPage() {
        waitForPricingCalculatorFrames();
        return driver.getTitle();
    }

    public void waitForPricingCalculatorFrames() {
        new WebDriverWait(driver, LONG_WAIT_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ZERO_FRAME_OF_PRICING_CALCULATOR));
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(MYFRAME_FRAME_OF_PRICING_CALCULATOR)));
    }
}
