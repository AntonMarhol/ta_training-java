package com.epam.training.student_anton_marhol.framework_practical_task.ui.util;

import static com.epam.training.student_anton_marhol.framework_practical_task.ui.page.ParentPage.LOGGER;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UtilMethods {
    public static WebElement scrollPageToElement(WebElement element, WebDriver driver){
        try {
            new Actions(driver)
                    .scrollToElement(element)
                    .perform();
            LOGGER.info("Scroll to " + element);
        }
        catch (Exception exception){
            LOGGER.info("The " + element + " already in view");
        }
        return element;
    }
}
