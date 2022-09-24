package com.epam.training.student_anton_marhol.hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorPage {

//    private static final String

    private final WebDriver driver;

    @FindBy (xpath = "//div[@class='tab-holder compute']")
    WebElement tabHolder;

    public PricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void tabHolderActivate() throws InterruptedException {
        Thread.sleep(15000);

//        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tab-holder compute']")));
//        CustomConditions.jQueryAJAXsCompleted();
//        driver.findElement(By.linkText("COMPUTE ENGINE")).click();
        tabHolder.click();
    }
}
