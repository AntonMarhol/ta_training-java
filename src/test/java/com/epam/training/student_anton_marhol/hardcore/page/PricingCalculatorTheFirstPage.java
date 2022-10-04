package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingCalculatorTheFirstPage extends ParentPage {

    private static final String TAB_COMPUTE_ENGINE_XPATH = "//div[@class='tab-holder compute']";
    private static final String NUMBER_OF_INSTANCES = "4";

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
    WebElement numberOfInstances;

    @FindBy (xpath = "//md-option[@id='select_option_92']")
    WebElement operationSystem;

    @FindBy (xpath = "//md-option[@id='select_option_105']")
    WebElement provisioningModel;

    @FindBy (xpath = "//md-option[@id='select_option_201']")
    WebElement seriesOfMachine;

    @FindBy (xpath = "//md-option[@id='select_option_425']")
    WebElement machineType;


    public PricingCalculatorTheFirstPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorTheFirstPage activateTabHolder() {

        switchToMyframeOfPricingCalculator();

        driver.findElement(By.xpath(TAB_COMPUTE_ENGINE_XPATH)).click();

        return this;
    }

    public PricingCalculatorTheSecondPage fillTheFisrstPartOfForm(){

        numberOfInstances.sendKeys(NUMBER_OF_INSTANCES);
                                                                            // SELECT OS
        setElement(operationSystemDropDownList, operationSystem);
                                                                            // SELECT PROVISIONING MODEL
        setElement(provisioningModelDropDownList, provisioningModel);
                                                                            // SELECT SERIES OF MACHINE
        setElement(seriesOfMachineDropDownList, seriesOfMachine);
                                                                            // SELECT MACHINE TYPE (INSTANCE TYPE)
        setElement(machineTypeDropDownList, machineType);

        return new PricingCalculatorTheSecondPage(driver);
    }
}
