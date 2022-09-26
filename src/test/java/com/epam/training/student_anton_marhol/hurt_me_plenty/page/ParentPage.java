package com.epam.training.student_anton_marhol.hurt_me_plenty.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParentPage {

    protected final WebDriver driver;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void setElement(WebElement clickElement, WebElement selectElement, JavascriptExecutor executor){

        clickElement.click();
        executor.executeScript("arguments[0].click();", selectElement);
        waitForElementInvisibility(driver, selectElement);
    }

    protected void waitForElementInvisibility(WebDriver driver, WebElement element){

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.invisibilityOf(element));
    }
}
