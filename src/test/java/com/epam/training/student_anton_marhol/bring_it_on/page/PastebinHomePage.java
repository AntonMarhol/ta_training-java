package com.epam.training.student_anton_marhol.bring_it_on.page;

import org.openqa.selenium.WebDriver;

    public class PastebinHomePage {

        private static final String HOME_PAGE_URL = "https://pastebin.com";
        private final WebDriver driver;

        public PastebinHomePage(WebDriver driver) {
            this.driver = driver;
        }

        public FillFieldsOnPastebinHomePage openPage() {

            driver.get(HOME_PAGE_URL);
            CustomConditions.jQueryAJAXsCompleted();

            return new FillFieldsOnPastebinHomePage(driver);
        }
}
