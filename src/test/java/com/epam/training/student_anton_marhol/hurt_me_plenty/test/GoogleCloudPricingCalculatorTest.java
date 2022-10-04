package com.epam.training.student_anton_marhol.hurt_me_plenty.test;

import com.epam.training.student_anton_marhol.hurt_me_plenty.page.EstimateResultPage;
import com.epam.training.student_anton_marhol.hurt_me_plenty.page.GoogleCloudHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorTest {

    private static final String PROVISION_MODEL = "Regular";
    private static final String INSTANCE_TYPE = "n1-standard-8";
    private static final String REGION = "Frankfurt";
    private static final String LOCAL_SSD = "2x375 GiB";
    private static final String COMMITMENT_TERM = "1 Year";
    private static final String TOTAL_ESTIMATED_COST = "USD 1,081.20";
    private static final String BROWSER_TITLE = "Google Cloud Pricing Calculator";

    EstimateResultPage estimateResultPage;
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void browserSetupTest(){

        estimateResultPage = new GoogleCloudHomePage(driver)
                .openPage()
                .searchOnHomePage()
                .lookingForPricingCalculatorInSearchResult()
                .activateTabHolder()
                .fillTheFisrstPartOfForm()
                .fillTheSecondPartOfForm()
                .pressTheButtonAddToEstimate();

        Assert.assertEquals(driver.getTitle(), BROWSER_TITLE);
    }

    @Test
    public void provisionModelTest() {

        Assert.assertEquals(estimateResultPage.lookForProvisionModel(), PROVISION_MODEL);
    }

    @Test
    public void instanceTypeTest() {

        Assert.assertEquals(estimateResultPage.lookForInstanceType(), INSTANCE_TYPE);
    }

    @Test
    public void regionTest() {

        Assert.assertEquals(estimateResultPage.lookForTheRegion(), REGION);
    }

    @Test
    public void localSSDTest() {

        Assert.assertEquals(estimateResultPage.lookForLocalSSD(), LOCAL_SSD);
    }

    @Test
    public void commitmentTermTest() {

        Assert.assertEquals(estimateResultPage.lookForCommitmentTerm(), COMMITMENT_TERM);
    }

    @Test
    public void totalEstimatedCostTest() {

        Assert.assertEquals(estimateResultPage.lookForTotalEstimatedCost(), TOTAL_ESTIMATED_COST);
    }

    @AfterClass(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
    }
}
