package com.epam.training.student_anton_marhol.hurt_me_plenty.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FunctionalTest extends ParentTestClass{

    @Test(description = "Verify provision model")
    public void provisionModel() {
        Assert.assertEquals(estimateResultPage.getProvisionModel(), PROVISION_MODEL, "Provision model is not correct.");
    }

    @Test (description = "Verify instance type")
    public void instanceType() {
        Assert.assertEquals(estimateResultPage.getInstanceType(), INSTANCE_TYPE, "Instance type is not correct.");
    }

    @Test (description = "Verify region")
    public void region() {
        Assert.assertEquals(estimateResultPage.getTheRegion(), REGION, "Region is not correct.");
    }

    @Test (description = "Verify local SSD")
    public void localSSD() {
        Assert.assertEquals(estimateResultPage.getLocalSSD(), LOCAL_SSD, "Local SSD is not correct.");
    }

    @Test (description = "Verify commitment term")
    public void verifyCommitmentTerm(){
        Assert.assertEquals(estimateResultPage.getCommitmentTerm(), COMMITMENT_TERM, "Commitment term is wrong.");
    }

    @Test (description = "Verify total estimated cost")
    public void totalEstimatedCost() {
        Assert.assertEquals(estimateResultPage.getTotalEstimatedCost(), TOTAL_ESTIMATED_COST, "Total estimated cost is wrong.");
    }
}
