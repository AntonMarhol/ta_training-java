package com.epam.training.student_anton_marhol.i_can_win.page;

import org.openqa.selenium.WebDriver;

public class PastebinHomePage extends ParentPage{

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePageForm openPage() {
        driver.get(HOME_PAGE_URL);
        return new PastebinHomePageForm(driver);
    }
}
