package com.epam.training.student_anton_marhol.bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinResultPage {

    private static final String CSS_SELECTOR_FOR_TITLE_NAME = "h1";
    private static final String CSS_SELECTOR_FOR_TEXT_CONTENT = "pre";
    private static final String XPATH_SELECTOR_FOR_COLOR_OF_TEXT = "//*[@class='kw2']";

    private final WebDriver driver;

    @FindBy (xpath = "//a[text()='raw']")
    private WebElement buttonRAW;

    public PastebinResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String tittleName () {

        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CSS_SELECTOR_FOR_TITLE_NAME)))
                .getText();
    }

    public String textContent () {

        waitForElementToBeClickable(buttonRAW);
        buttonRAW.click();

        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CSS_SELECTOR_FOR_TEXT_CONTENT)))
                .getText();
    }

    public Color colorOfText() {

        return Color.fromString(new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_SELECTOR_FOR_COLOR_OF_TEXT)))
                .getCssValue("color"));
    }

    private void waitForElementToBeClickable(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
    }
}