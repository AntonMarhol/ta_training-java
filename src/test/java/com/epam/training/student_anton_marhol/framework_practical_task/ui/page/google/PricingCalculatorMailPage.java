package com.epam.training.student_anton_marhol.framework_practical_task.ui.page.google;

import static com.epam.training.student_anton_marhol.framework_practical_task.test.CommonCondition.yopmailMail;
import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Swither.switchToMyframeOfPricingCalculator;
import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Waitings.waitForPresenceElementById;
import static com.epam.training.student_anton_marhol.framework_practical_task.ui.util.Waitings.waitForPresenceElementByXpath;
import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.yopmail.YopmailHomePage;
import com.epam.training.student_anton_marhol.framework_practical_task.ui.page.yopmail.YopmailMailPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

public class PricingCalculatorMailPage extends GoogleCloudParentPage {

    private static final String MAIL_ADDRESS_FORM_BUTTON = "email_quote";
    private static final String INPUT_EMAIL_FIELD = "//label[text()='Email ']/following-sibling::input";

    @FindBy (xpath = "//button[contains(@aria-label,'Send Email')]")
    WebElement sendEstimateByMailButton;

    @FindBy (id = MAIL_ADDRESS_FORM_BUTTON)
    WebElement mailAddressFormButton;

    @FindBy (xpath = INPUT_EMAIL_FIELD)
    WebElement mailAddressField;

    public PricingCalculatorMailPage(WebDriver driver){
        super(driver);
    }

    public PricingCalculatorMailPage openMailAddressForm() {
        LOGGER.info("Opening Mail address form");
        waitForPresenceElementById(MAIL_ADDRESS_FORM_BUTTON, driver);
        mailAddressFormButton.click();
        googleCloudTab = driver.getWindowHandle();
        LOGGER.info("Mail address form opened");
        return this;
    }

    public PricingCalculatorMailPage openNewTab() {
        LOGGER.info("Opening New tab");
        driver.switchTo().newWindow(WindowType.TAB);
        LOGGER.info("New tab opened");
        return this;
    }

    public PricingCalculatorMailPage fillMailAddressForm() {
        LOGGER.info("Filling Mail address form");
                                                // refresh Pricing Calculator Tab frames for stable work
        switchToMyframeOfPricingCalculator(driver);
        waitForPresenceElementByXpath(INPUT_EMAIL_FIELD, driver);
        mailAddressField.sendKeys(yopmailMail);
        LOGGER.info("Mail address form filled");
        return this;
    }

    public PricingCalculatorMailPage clickSendEstimateByMailButton() {
        LOGGER.info("Sending Estimate by email");
        scrollPageToElement(sendEstimateByMailButton);
        sendEstimateByMailButton.click();
        LOGGER.info("Estimate sent by email");
        return this;
    }

    public YopmailMailPage goToYopmailMailPage() {
        LOGGER.info("Go to the Yopmail mail page");
        return new YopmailMailPage(driver);
    }

    public YopmailHomePage goToYopmailHomePage() {
        LOGGER.info("Go to the Yopmail Home page");
        return new YopmailHomePage(driver);
    }
}
