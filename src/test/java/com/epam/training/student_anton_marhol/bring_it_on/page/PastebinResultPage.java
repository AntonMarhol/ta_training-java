package com.epam.training.student_anton_marhol.bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinResultPage  extends ParentPage{

    private static final String CSS_SELECTOR_FOR_TITLE_NAME = "h1";
    private static final String CSS_SELECTOR_FOR_TEXT_CONTENT = "pre";
    private static final String XPATH_SELECTOR_FOR_COLOR_OF_TEXT = "//*[@class='kw2']";

    @FindBy (xpath = "//a[text()='raw']")
    private WebElement buttonRAW;

    public PastebinResultPage(WebDriver driver) {
        super(driver);
    }

    public String tittleName () {
        return new WebDriverWait(driver, SHORT_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CSS_SELECTOR_FOR_TITLE_NAME)))
                .getText();
    }

    public String textContent () {

        waitForElementToBeClickable(buttonRAW);
        buttonRAW.click();

        return new WebDriverWait(driver, SHORT_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CSS_SELECTOR_FOR_TEXT_CONTENT)))
                .getText();
    }

    public Color colorOfText() {
        return Color.fromString(new WebDriverWait(driver, SHORT_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_SELECTOR_FOR_COLOR_OF_TEXT)))
                .getCssValue("color"));
    }

    private void waitForElementToBeClickable(WebElement element){
        new WebDriverWait(driver, BASE_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(element));
    }
}
