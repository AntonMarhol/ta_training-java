package com.epam.training.student_anton_marhol.bring_it_on.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.training.student_anton_marhol.bring_it_on.util.Waitings.BASE_WAIT_TIME;

public class Utils {

    public static String getTextFromElementByCSS(String cssSelector, WebDriver driver){
        return new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)))
                .getText();
    }

    public static Color getColorFromElementByXPath(String xPathSelector, WebDriver driver) {
        return Color.fromString(new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathSelector)))
                .getCssValue("color"));
    }
}
