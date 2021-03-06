package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static helpers.Locators.get;

/**
 * Created by olapanovich on 30.10.16.
 */
public class AuthenticationPage extends PageBase{

    private static final By EMAIL_INPUT = get("AuthentificationPage.EmailInput");
    private static final By CREATE_ACCOUNT_BUTTON = get("AuthentificationPage.CreateAccountButton");


    public AuthenticationPage(WebDriver driver) {  super(driver);   }

    public void enterEmail(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public RegistrationPage clickCreateAccountButton() {
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        System.out.print("Click Create Account Button");
        return new RegistrationPage(driver);
    }
}
