package com.epam.training.student_anton_marhol.framework_practical_task.service;

import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.yopmail.YopmailHomePage;
import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.yopmail.YopmailMailPage;

import org.openqa.selenium.WebDriver;

public class YopmailMaker extends ServiceParentClass{

    public YopmailMaker(WebDriver driver) {
        super(driver);
    }

    public String getYopmailEmailAddress() {
        return new YopmailHomePage(driver)
                .openNewTab()
                .openYopmail()
                .generateMail()
                .copyGeneratedMail()
                .goToMaiThePage()
                .clickCheckInboxButton()
                .getMailAdress();
    }

    public String getEmailAddressInLetter() {
        return new YopmailMailPage(driver)
                .getMailAdress();
    }
}
