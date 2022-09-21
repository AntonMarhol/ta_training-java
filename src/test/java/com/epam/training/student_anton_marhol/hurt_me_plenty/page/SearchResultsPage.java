package com.epam.training.student_anton_marhol.hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchResultsPage {

    private static final String SEARCH_TEXT_IN_RESULTS = "Google Cloud Platform Pricing Calculator";

    private final WebDriver driver;

//    @FindBy (xpath = "//div[@class='gsc-resultsbox-visible']//div[@class='gs-title']/a")
//    WebElement searchForTheLink;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PricingCalculatorPage lookingForPricingCalculatorInSearchResult () throws InterruptedException {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.linkText(SEARCH_TEXT_IN_RESULTS))));
        driver.findElement(By.linkText(SEARCH_TEXT_IN_RESULTS)).click();

        return new PricingCalculatorPage(driver);
    }
}
