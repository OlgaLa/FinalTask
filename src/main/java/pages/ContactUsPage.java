package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.io.File;

import static helpers.Locators.get;

/**
 * Created by olapanovich on 29.10.16.
 */
public class ContactUsPage extends PageBase {

    private static final By SUBJECT_DROPDOWN = get("ContactUsPage.SubjectDropdown");
    private static final By EMAIL_INPUT = get("ContactUsPage.EmailInput");
    private static final By ORDER_REFERENCE_INPUT = get("ContactUsPage.OrderReferenceInput");
    private static final By CHOOSE_FILE_INPUT = get("ContactUsPage.ChooseFileInput");
    private static final By MESSAGE_INPUT = get("ContactUsPage.MessageInput");
    private static final By SEND_BUTTON = get("ContactUsPage.SendButton");
    private static final By RESULT_MESSAGE = get("ContactUsPage.ResultMessage");
    private static final By VALIDATION_RESULT_MESSAGE = get("ContactUsPage.ValidationResultMessage");
    private static final String FILE_URL = "src/main/resources/ContactUsAttached.txt";
    private static final String VALUE = "2";

    public ContactUsPage(WebDriver driver) { super(driver); }

    private void selectSubject() {
        Select select = new Select(driver.findElement(SUBJECT_DROPDOWN));
        select.selectByValue(VALUE);
    }

    private void chooseFile() {
        File file = new File(FILE_URL);
        WebElement chooseFileInput = driver.findElement(CHOOSE_FILE_INPUT);
        chooseFileInput.sendKeys(file.getAbsolutePath());

    }

    public void sendEmail(String email, String order, String message) {
        selectSubject();
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(ORDER_REFERENCE_INPUT).sendKeys(order);
        chooseFile();
        driver.findElement(MESSAGE_INPUT).sendKeys(message);
        driver.findElement(SEND_BUTTON).click();
    }

    public String getResultMessage() {
        return driver.findElement(RESULT_MESSAGE).getText();
    }

    public String getValidationResultMessage() {
        return driver.findElement(VALIDATION_RESULT_MESSAGE).getText();
    }
}
