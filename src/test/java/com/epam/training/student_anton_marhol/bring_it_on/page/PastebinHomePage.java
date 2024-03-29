package com.epam.training.student_anton_marhol.bring_it_on.page;

import static com.epam.training.student_anton_marhol.bring_it_on.util.Waitings.BASE_WAIT_TIME;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage extends ParentPage{

        public PastebinHomePage(WebDriver driver) {
            super(driver);
        }

        public FieldsOnPastebinHomePage openPage() {
            driver.get(HOME_PAGE_URL);
            new WebDriverWait(driver, BASE_WAIT_TIME).until(CustomConditions.jQueryAJAXsCompleted());
            return new FieldsOnPastebinHomePage(driver);
        }
}
