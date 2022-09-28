package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingCalculatorTheSecondPage extends ParentPage {

                                                             // CLICK TO SELECT DATA IN FORM
    @FindBy (id = "select_463")
    WebElement clickToClickToSelectGPUType;

    @FindBy (id = "select_465")
    WebElement clickToSelectNumberOfGPU;

    @FindBy (id = "select_value_label_419")
    WebElement clickToSelectLocalSSD;

    @FindBy (id = "select_value_label_88")
    WebElement clickToSelectDatacenterLocation;

    @FindBy (id = "select_value_label_89")
    WebElement clickToCommittedUsage;
                                                                    // SELECT DATA TO FILL
    @FindBy(xpath = "//md-option[@id='select_option_470']")
    WebElement selectGPUType;

    @FindBy (xpath = "//md-option[@id='select_option_474']")
    WebElement selectNumberOfGPU;

    @FindBy (xpath = "//md-option[@id='select_option_446']")
    WebElement selectLocalSSD;

    @FindBy (xpath = "//md-option[@id='select_option_228']")
    WebElement selectDatacenterLocation;

    @FindBy (xpath = "//md-option[@id='select_option_128']")
    WebElement selectCommittedUsage;
                                                                        // BUTTON AND CHECK-BOX
    @FindBy (xpath = "//md-checkbox[@aria-label='Add GPUs']/div")
    WebElement checkBoxAddGPUs;

    @FindBy (xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    WebElement buttonAddToEstimate;

    public PricingCalculatorTheSecondPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorTheSecondPage fillTheSecondPartOfForm(){

        JavascriptExecutor executor = (JavascriptExecutor) driver;
                                                                               // SELECT CHECK-BOX
        if(!checkBoxAddGPUs.isSelected()) executor.executeScript("arguments[0].click();", checkBoxAddGPUs);
                                                                               // SELECT GPUs TYPE
        setElement(clickToClickToSelectGPUType,selectGPUType,executor);
                                                                               // SELECT NUMBER OF GPUs
        setElement(clickToSelectNumberOfGPU,selectNumberOfGPU,executor);
                                                                               // SELECT LOCAL SSD
        setElement(clickToSelectLocalSSD,selectLocalSSD,executor);
                                                                              // SELECT DATACENTER LOCATION (REGION)
        setElement(clickToSelectDatacenterLocation,selectDatacenterLocation,executor);
                                                                             // SELECT COMMITTED USAGE (COMMITMENT TERM)
        setElement(clickToCommittedUsage,selectCommittedUsage,executor);

    return this;
}

    public SendEstimateByMailPage pressTheButtonAddToEstimate(){

        buttonAddToEstimate.click();

        return new SendEstimateByMailPage(driver);
    }
}


