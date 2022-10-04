package com.epam.training.student_anton_marhol.bring_it_on.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage extends ParentPage{

        private static final String HOME_PAGE_URL = "https://pastebin.com";

        public PastebinHomePage(WebDriver driver) {
            super(driver);
        }

        public FillFieldsOnPastebinHomePage openPage() {
            driver.get(HOME_PAGE_URL);
            new WebDriverWait(driver, BASE_WAIT_TIME).until(CustomConditions.jQueryAJAXsCompleted());

            return new FillFieldsOnPastebinHomePage(driver);
        }
}
