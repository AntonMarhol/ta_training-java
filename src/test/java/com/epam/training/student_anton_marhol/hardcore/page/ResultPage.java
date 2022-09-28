package com.epam.training.student_anton_marhol.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EstimateResultPage {

//    @FindBy (xpath = "//md-list-item[@class='md-1-line md-no-proxy ng-scope']/following-sibling::md-list-item")
//    WebElement provisionModel;
//
//    @FindBy (xpath = "//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex']")
//    WebElement instanceType;
//
//    @FindBy (xpath = "//md-list-item[@class='md-1-line md-no-proxy']")
//    WebElement region;
//
//    @FindBy (xpath = "//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex']/../following-sibling::md-list-item/following-sibling::md-list-item/child::div")
//    WebElement localSSD;
//
//    @FindBy (xpath = "//md-list-item[@class='md-1-line md-no-proxy ng-scope']/child::div")
//    WebElement commitmentTerm;

    @FindBy (xpath = "//b[@class='ng-binding']")
    WebElement totalCost;

    private final WebDriver driver;

    public EstimateResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public String lookForProvisionModel () {
//
//        return provisionModel.getText().replaceFirst("Provisioning model: ","");
//    }
//
//    public String lookForInstanceType () {
//
//        return instanceType.getText()
//                .replaceFirst("Instance type: ","")
//                .replaceFirst("\nCommitted Use Discount applied","");
//    }
//
//    public String lookForTheRegion () {
//
//        return region.getText().replaceFirst("Region: ","");
//    }
//
//    public String lookForLocalSSD() {
//
//        return localSSD.getText()
//                .replaceFirst("Local SSD: ","")
//                .replaceFirst("\nCommitted Use Discount applied","");
//    }
//
//    public String lookForCommitmentTerm () {
//
//        return commitmentTerm.getText().replaceFirst("Commitment term: ","");
//    }

    public String lookForTotalEstimatedCost() {



        return totalCost.getText()
                .replaceFirst("Estimated Component Cost: ", "")
                .replaceFirst(" per 1 month", "");
    }
}
