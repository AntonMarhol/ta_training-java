package com.epam.training.student_anton_marhol.hurt_me_plenty.test;

import com.epam.training.student_anton_marhol.hurt_me_plenty.service.FormFiller;
import com.epam.training.student_anton_marhol.hurt_me_plenty.ui.page.EstimateResultPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ParentTestClass {

    protected static final String PROVISION_MODEL = "Regular";
    protected static final String INSTANCE_TYPE = "n1-standard-8";
    protected static final String REGION = "Frankfurt";
    protected static final String LOCAL_SSD = "2x375 GiB";
    protected static final String COMMITMENT_TERM = "1 Year";
    protected static final String TOTAL_ESTIMATED_COST = "USD 1,081.20";

    EstimateResultPage estimateResultPage;
    WebDriver driver;

    @BeforeClass(description = "Open browser and maximize")
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        estimateResultPage = FormFiller.fillEstimateForm(driver);
    }

    @AfterClass(alwaysRun = true, description = "Close browser in all cases")
    public void browserShutDown() {
        driver.quit();
    }
}
