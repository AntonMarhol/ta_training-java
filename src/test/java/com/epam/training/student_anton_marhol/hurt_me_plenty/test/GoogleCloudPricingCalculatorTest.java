package com.epam.training.student_anton_marhol.hurt_me_plenty.test;

import com.epam.training.student_anton_marhol.hurt_me_plenty.page.GoogleCloudHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorTest {

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void homePage() throws InterruptedException {

        new GoogleCloudHomePage(driver)
                .openPage()
                .searchOnHomePage()
                .lookingForPricingCalculatorInSearchResult()
                .tabHolderActivate();
    }







    @AfterClass(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
