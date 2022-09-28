package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorTheFirstPage extends ParentPage {

    private static final String TAB_COMPUTE_ENGINE_XPATH = "//div[@class='tab-holder compute']";
    private static final String NUMBER_OF_INSTANCES = "4";

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

    @FindBy (xpath = "//md-option[@id='select_option_92']")
    WebElement selectOS;

    @FindBy (xpath = "//md-option[@id='select_option_105']")
    WebElement selectProvisioningModel;

    @FindBy (xpath = "//md-option[@id='select_option_201']")
    WebElement selectSeriesOfMachine;

    @FindBy (xpath = "//md-option[@id='select_option_425']")
    WebElement selectMachineType;


    public PricingCalculatorTheFirstPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorTheFirstPage activateTabHolder() {

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ZERO_FRAME_OF_PRICING_CALCULATOR));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(MYFRAME_FRAME_OF_PRICING_CALCULATOR)));

        driver.findElement(By.xpath(TAB_COMPUTE_ENGINE_XPATH)).click();

        return this;
    }

    public PricingCalculatorTheSecondPage fillTheFisrstPartOfForm(){

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        selectNumberOfInstances.sendKeys(NUMBER_OF_INSTANCES);
                                                                            // SELECT OS
        setElement(clickToSelectOS,selectOS,executor);
                                                                            // SELECT PROVISIONING MODEL
        setElement(clickToSelectProvisioningModel,selectProvisioningModel,executor);
                                                                            // SELECT SERIES OF MACHINE
        setElement(clickToSelectSeriesOfMachine,selectSeriesOfMachine,executor);
                                                                            // SELECT MACHINE TYPE (INSTANCE TYPE)
        setElement(clickToSelectMachineType,selectMachineType,executor);

        return new PricingCalculatorTheSecondPage(driver);
    }
}
