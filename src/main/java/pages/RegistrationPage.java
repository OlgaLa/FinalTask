package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static helpers.Locators.get;

/**
 * Created by olapanovich on 30.10.16.
 */
public class RegistrationPage extends PageBase{

    private static final By GENDER_CHECKBOX = get("RegistrationPage.GenderCheckbox");
    private static final By FIRST_NAME_INPUT = get("RegistrationPage.FirstNameInput");
    private static final By LAST_NAME_INPUT = get("RegistrationPage.LastNameInput");
    private static final By PASSWORD_INPUT = get("RegistrationPage.PasswordInput");
    private static final By ADDRESS_INPUT = get("RegistrationPage.Address1Input");
    private static final By CITY_INPUT = get("RegistrationPage.CityInput");
    private static final By POSTCODE_INPUT = get("RegistrationPage.PostcodeInput");
    private static final By STATE_DROPDOWN = get("RegistrationPage.StateDropdown");
    private static final By COUNTRY_DROPDOWN = get("RegistrationPage.CountryDropdown");
    private static final By MOBILE_PHONE_INPUT = get("RegistrationPage.MobilePhoneInput");
    private static final By ALIAS_INPUT = get("RegistrationPage.AliasInput");
    private static final By REGISTER_BUTTON = get("RegistrationPage.RegisterButton");

    public RegistrationPage(WebDriver driver) {  super(driver);  }

    private void selectValue(By element) {

        Select dropdown = new Select(driver.findElement(element));
        dropdown.selectByIndex(1);
    }


    public MyAccountPage registerCustomer(String firstName, String lastName, String password, String address,
                                              String city, String postcode, String mobilePhone, String alias) {

        driver.findElement(GENDER_CHECKBOX).click();
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
        driver.findElement(CITY_INPUT).sendKeys(city);
        driver.findElement(POSTCODE_INPUT).sendKeys(postcode);
        selectValue(STATE_DROPDOWN);
        selectValue(COUNTRY_DROPDOWN);
        driver.findElement(MOBILE_PHONE_INPUT).sendKeys(mobilePhone);
        driver.findElement(ALIAS_INPUT).sendKeys(alias);
        driver.findElement(REGISTER_BUTTON).click();

        return new MyAccountPage(driver);
    }

}
