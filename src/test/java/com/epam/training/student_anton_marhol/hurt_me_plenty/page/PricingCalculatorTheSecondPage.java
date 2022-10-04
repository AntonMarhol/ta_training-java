package com.epam.training.student_anton_marhol.hurt_me_plenty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingCalculatorTheSecondPage extends ParentPage{
                                                             // CLICK TO SELECT DATA IN FORM
    @FindBy (id = "select_463")
    WebElement typeOfGPUDropDownList;

    @FindBy (id = "select_465")
    WebElement numberOfGPUDropDownList;

    @FindBy (id = "select_value_label_419")
    WebElement localSSDDropDownList;

    @FindBy (id = "select_value_label_88")
    WebElement datacenterLocationDropDownList;

    @FindBy (id = "select_value_label_89")
    WebElement committedUsageDropDownList;
                                                                    // SELECT DATA TO FILL
    @FindBy(xpath = "//md-option[@id='select_option_470']")
    WebElement typeOfGPU;

    @FindBy (xpath = "//md-option[@id='select_option_474']")
    WebElement numberOfGPU;

    @FindBy (xpath = "//md-option[@id='select_option_446']")
    WebElement localSSD;

    @FindBy (xpath = "//md-option[@id='select_option_228']")
    WebElement datacenterLocation;

    @FindBy (xpath = "//md-option[@id='select_option_128']")
    WebElement committedUsage;
                                                                        // BUTTON AND CHECK-BOX
    @FindBy (xpath = "//md-checkbox[@aria-label='Add GPUs']/div")
    WebElement checkBoxAddGPUs;

    @FindBy (xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    WebElement buttonAddToEstimate;

    public PricingCalculatorTheSecondPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorTheSecondPage fillTheSecondPartOfForm(){
                                                                               // SELECT CHECK-BOX
        if(!checkBoxAddGPUs.isSelected()) checkBoxAddGPUs.click();
                                                                               // SELECT GPUs TYPE
        setElement(typeOfGPUDropDownList, typeOfGPU);
                                                                               // SELECT NUMBER OF GPUs
        setElement(numberOfGPUDropDownList, numberOfGPU);
                                                                               // SELECT LOCAL SSD
        setElement(localSSDDropDownList, localSSD);
                                                                              // SELECT DATACENTER LOCATION (REGION)
        setElement(datacenterLocationDropDownList, datacenterLocation);
                                                                             // SELECT COMMITTED USAGE (COMMITMENT TERM)
        setElement(committedUsageDropDownList, committedUsage);

    return this;
}
    public EstimateResultPage pressTheButtonAddToEstimate(){

        buttonAddToEstimate.click();

        return new EstimateResultPage(driver);
    }
}


