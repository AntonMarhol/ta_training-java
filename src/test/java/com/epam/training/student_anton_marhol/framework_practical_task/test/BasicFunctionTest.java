package com.epam.training.student_anton_marhol.framework_practical_task.test;

import com.epam.training.student_anton_marhol.framework_practical_task.page.GoogleCloudHomePage;
import com.epam.training.student_anton_marhol.framework_practical_task.page.YopmailHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicFunctionTest extends CommonConditions{

    @Test
    public void basicGoogleCloudFunctionTest() {

        String currentGooglePageTitle = new GoogleCloudHomePage(driver)
                .openPage()
                .searchOnHomePage()
                .lookingForPricingCalculatorInSearchResult()
                .getTitleOfCurrentPage();

        Assert.assertEquals(currentGooglePageTitle, GOOGLE_CLOUD_TAB_TITLE);
    }

    @Test
    public void basicYopmailFunctionTest() {

        String currentMailAddress = new YopmailHomePage(driver)
                .generateMail()
                .copyGeneratedMail()
                .goToTheMailBox()
                .isMailAdressCreated();

        Assert.assertEquals(currentMailAddress, yopmailMail);
    }
}
