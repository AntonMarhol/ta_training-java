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
        driver.manage().window().maximize();
    }

    @Test
    public void browserSetupTest() {

        resultPage = new GoogleCloudHomePage(driver)
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

        Assert.assertEquals(resultPage.getYopmailTabTitle(),BROWSER_TITLE);
    }

    @Test
    public void totalEstimatedCostTest() {

        resultPage = new ResultPage(driver);

        Assert.assertEquals(resultPage.getEstimatedCostInMail(),resultPage.getEstimatedCostInPricingCalculator());
    }

    @AfterClass(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
    }
}
