package com.epam.training.student_anton_marhol.i_can_win.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    protected static final String HOME_PAGE_URL = "https://pastebin.com";

    protected WebDriver driver;

    public ParentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
