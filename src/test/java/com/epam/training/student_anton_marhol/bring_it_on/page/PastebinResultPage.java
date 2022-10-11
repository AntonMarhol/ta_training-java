package com.epam.training.student_anton_marhol.bring_it_on.page;

import static com.epam.training.student_anton_marhol.bring_it_on.util.Utils.getColorFromElementByXPath;
import static com.epam.training.student_anton_marhol.bring_it_on.util.Utils.getTextFromElementByCSS;
import static com.epam.training.student_anton_marhol.bring_it_on.util.Waitings.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

public class PastebinResultPage  extends ParentPage{

    private static final String TITLE_NAME_CSS_SELECTOR = "h1";
    private static final String TEXT_CONTENT_CSS_SELECTOR = "pre";
    private static final String COLOR_OF_TEXT_XPATH_SELECTOR = "//*[@class='kw2']";

    @FindBy (xpath = "//a[text()='raw']")
    private WebElement rawButton;

    public PastebinResultPage(WebDriver driver) {
        super(driver);
    }

    public String getTittleName() {
        return getTextFromElementByCSS(TITLE_NAME_CSS_SELECTOR, driver);
    }

    public PastebinResultPage clickRawButton(){
        waitForElementToBeClickable(rawButton,driver);
        rawButton.click();
        return this;
    }

    public String getTextContent() {
        return getTextFromElementByCSS(TEXT_CONTENT_CSS_SELECTOR,driver);
    }

    public Color getColorOfText() {
        return getColorFromElementByXPath(COLOR_OF_TEXT_XPATH_SELECTOR, driver);
    }
}
