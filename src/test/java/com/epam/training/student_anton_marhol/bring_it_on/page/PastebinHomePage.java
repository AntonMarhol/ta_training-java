package com.epam.training.student_anton_marhol.bring_it_on.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage {

        private static final String HOME_PAGE_URL = "https://pastebin.com";
        private final WebDriver driver;

        public PastebinHomePage(WebDriver driver) {
            this.driver = driver;
        }

        public FillFieldsOnPastebinHomePage openPage() {

            driver.get(HOME_PAGE_URL);
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(CustomConditions.jQueryAJAXsCompleted());

            return new FillFieldsOnPastebinHomePage(driver);
        }
}
