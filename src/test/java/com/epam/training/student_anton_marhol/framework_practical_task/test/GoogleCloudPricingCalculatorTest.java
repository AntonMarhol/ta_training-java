package com.epam.training.student_anton_marhol.framework_practical_task.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.training.student_anton_marhol.framework_practical_task.model.Instances;
import com.epam.training.student_anton_marhol.framework_practical_task.page.GoogleCloudHomePage;
import com.epam.training.student_anton_marhol.framework_practical_task.page.ResultPage;
import com.epam.training.student_anton_marhol.framework_practical_task.service.InstancesCreator;

public class GoogleCloudPricingCalculatorTest extends CommonConditions{

    @Test
    public void browserSetupTest() {

        Instances instances = InstancesCreator.withCredentialsFromProperties();
        String currentMailAddress = new GoogleCloudHomePage(driver)
                .openPage()
                .searchOnHomePage()
                .lookingForPricingCalculatorInSearchResult()
                .activateTabHolder()
                .fillTheFisrstPartOfForm(instances)
                .fillTheSecondPartOfForm(instances)
                .pressTheButtonAddToEstimate()
                .selectOptionSendByEmail()
                .generateMail()
                .copyGeneratedMail()
                .backToPricingCalculatorTab()
                .sendByEmail()
                .goToTheMailBox()
                .checkForLetter()
                .isMailAdressCreated();

        Assert.assertEquals(currentMailAddress, yopmailMail);
    }

    @Test (priority = 1)
    public void totalEstimatedCostTest() {

        ResultPage resultPage = new ResultPage(driver);

        Assert.assertEquals(resultPage.lookForTotalEstimatedCostInMail(),resultPage.lookForTotalEstimatedCostInPricingCalculator());
    }
}
