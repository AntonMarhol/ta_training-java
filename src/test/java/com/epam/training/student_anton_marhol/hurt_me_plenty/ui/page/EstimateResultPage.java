package com.epam.training.student_anton_marhol.hurt_me_plenty.ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EstimateResultPage extends ParentPage{

    @FindBy (xpath = "//div[contains(text(),'Provisioning model:')]")
    WebElement provisionModel;
    @FindBy (xpath = "//div[contains(text(),'Instance type:')]")
    WebElement instanceType;
    @FindBy (xpath = "//div[contains(text(),'Region:')]")
    WebElement region;
    @FindBy (xpath = "//div[contains(text(),'Local SSD:')]")
    WebElement localSSD;
    @FindBy (xpath = "//div[contains(text(),'Commitment term:')]")
    WebElement commitmentTerm;
    @FindBy (xpath = "//b[contains(text(),'Total Estimated Cost:')]")
    WebElement totalCost;

    public EstimateResultPage(WebDriver driver) {
        super(driver);
    }

    public String getProvisionModel() {
        return provisionModel.getText().replaceFirst("Provisioning model: ","");
    }

    public String getInstanceType() {
        return instanceType.getText()
                .replaceFirst("Instance type: ","")
                .replaceFirst("\nCommitted Use Discount applied","");
    }

    public String getTheRegion() {
        return region.getText().replaceFirst("Region: ","");
    }

    public String getLocalSSD() {
        return localSSD.getText()
                .replaceFirst("Local SSD: ","")
                .replaceFirst("\nCommitted Use Discount applied","");
    }

    public String getCommitmentTerm() {
        return commitmentTerm.getText().replaceFirst("Commitment term: ","");
    }

    public String getTotalEstimatedCost() {
        return totalCost.getText()
                .replaceFirst("Total Estimated Cost: ", "")
                .replaceFirst(" per 1 month", "");
    }
}
