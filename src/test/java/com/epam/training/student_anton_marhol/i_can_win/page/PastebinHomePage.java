package com.epam.training.student_anton_marhol.i_can_win.page;

import org.openqa.selenium.WebDriver;

public class PastebinHomePage {

    private static final String HOME_PAGE_URL = "https://pastebin.com";
    private WebDriver driver;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public PastebinHomePageForm openPage() {

        driver.get(HOME_PAGE_URL);

        return new PastebinHomePageForm(driver);
    }
}
