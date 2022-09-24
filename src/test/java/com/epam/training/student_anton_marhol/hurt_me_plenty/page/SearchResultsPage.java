package com.epam.training.student_anton_marhol.hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {

    private static final String SEARCH_TEXT_IN_RESULTS = "Google Cloud Platform Pricing Calculator";

    private final WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PricingCalculatorTheFirstPage lookingForPricingCalculatorInSearchResult (){

        new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText(SEARCH_TEXT_IN_RESULTS)));
        driver.findElement(By.linkText(SEARCH_TEXT_IN_RESULTS)).click();

        return new PricingCalculatorTheFirstPage(driver);
    }
}