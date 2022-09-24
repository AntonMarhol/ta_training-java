package com.epam.training.student_anton_marhol.i_can_win.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage {

    private static final String HOME_PAGE_URL = "https://pastebin.com";
    private WebDriver driver;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public FillFieldsOnPastebinHomePage openPage() {

        driver.get(HOME_PAGE_URL);

        return new FillFieldsOnPastebinHomePage(driver);
    }
}
