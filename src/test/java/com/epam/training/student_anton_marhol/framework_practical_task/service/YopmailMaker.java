package com.epam.training.student_anton_marhol.framework_practical_task.service;

import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.yopmail.YopmailHomePage;
import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.yopmail.YopmailMailPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Configuration;


public class YopmailMaker extends ServiceParentClass{

    public YopmailMaker(WebDriver driver) {
        super(driver);
    }

    @SuppressWarnings("deprecation")
    @Configuration(description = "create new yopmail box and return its mail address")
    public String getYopmailEmailAddress() {
        return new YopmailHomePage(driver)
                .openNewTab()
                .openYopmail()
                .generateMail()
                .copyGeneratedMail()
                .goToMailPage()
                .clickCheckInboxButton()
                .getMailAdress();
    }

    @SuppressWarnings("deprecation")
    @Configuration(description = "return mail address in the letter in yopmail")
    public String getEmailAddressInLetter() {
        return new YopmailMailPage(driver)
                .getMailAdress();
    }
}
