package com.epam.training.student_anton_marhol.hardcore.test;

import com.epam.training.student_anton_marhol.hardcore.page.ResultPage;
import com.epam.training.student_anton_marhol.hardcore.page.GoogleCloudHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorTest {

    private static final String BROWSER_TITLE = "Inbox";

    ResultPage resultPage;

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {

        driver = new ChromeDriver();
    }

    @Test
    public void browserSetupTest() {

        driver = new GoogleCloudHomePage(driver)
                .openPage()
                .searchOnHomePage()
                .lookingForPricingCalculatorInSearchResult()
                .activateTabHolder()
                .fillTheFisrstPartOfForm()
                .fillTheSecondPartOfForm()
                .pressTheButtonAddToEstimate()
                .selectOptionSendByEmail()
                .generateMail()
                .copyGeneratedMail()
                .sendByEmail()
                .goToTheMailBox()
                .checkForLetter();

        Assert.assertEquals(driver.getTitle(),BROWSER_TITLE);
    }

    @Test
    public void totalEstimatedCostTest() {

        resultPage = new ResultPage(driver);

        Assert.assertEquals(resultPage.lookForEstimatedCostInMail(),resultPage.lookForTotalEstimatedCostInPricingCalculator());
    }

    @AfterClass(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
    }
}
