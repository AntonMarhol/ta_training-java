package com.epam.training.student_anton_marhol.hurt_me_plenty.ui.util;

import static com.epam.training.student_anton_marhol.hardcore.ui.util.Waitings.BASE_WAIT_TIME;
import static com.epam.training.student_anton_marhol.hardcore.ui.util.Waitings.LONG_WAIT_TIME;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameSwitchers {

    public static final int ZERO_FRAME_OF_PRICING_CALCULATOR = 0;
    public static final String MYFRAME_FRAME_OF_PRICING_CALCULATOR = "myFrame";

    public static void switchToMyframeOfPricingCalculator(WebDriver driver){
        driver.switchTo().defaultContent();
        new WebDriverWait(driver, LONG_WAIT_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ZERO_FRAME_OF_PRICING_CALCULATOR));
        new WebDriverWait(driver, BASE_WAIT_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(MYFRAME_FRAME_OF_PRICING_CALCULATOR)));
    }
}
