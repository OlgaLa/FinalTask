package pages.part;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;

import static helpers.Locators.get;

/**
 * Created by olapanovich on 29.10.16.
 */
public class Header {

    private static final By CONTACT_US_BUTTON = get("Header.ContactUsButton");
    private static final By SIGN_IN_BUTTON = get("Header.SignInButton");
    private static final By SEARCH_INPUT = get("Header.SearchInput");
    private static final By SEARCH_BUTTON = get("Header.SearchButton");
    private static final By CART_BUTTON = get("Headers.CartButton");
    private static final By WOMEN_CATEGORY = get("Header.WomenCategory");
    private static final By T_SHIRTS_SUBCATEGORY = get("Header.TShirtsSubcategory");
    private static final By USER_ACCOUNT_BUTTON = get("Header.UserAccountButton");

    private WebDriver driver;

    public Header(WebDriver driver) { this.driver = driver; }

    public ContactUsPage clickContactUs() {

        driver.findElement(CONTACT_US_BUTTON).click();
        System.out.print("Click Contact Us");
        return new ContactUsPage(driver);
    }

    public AuthenticationPage clickSignIn() {

        driver.findElement(SIGN_IN_BUTTON).click();
        System.out.print("Click Sign In");
        return new AuthenticationPage(driver);
    }

    public SearchResultsPage searchItem(String item) {

        driver.findElement(SEARCH_INPUT).sendKeys(item);
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchResultsPage(driver);
    }

    public CartPage clickCart() {

        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }


    public ProductPage clickTShirtsSubcategory() {

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(WOMEN_CATEGORY)).perform();
        builder.moveToElement(driver.findElement(T_SHIRTS_SUBCATEGORY)).click().perform();
        return new ProductPage(driver);

    }

    public MyAccountPage clickUserAccount() {

        driver.findElement(USER_ACCOUNT_BUTTON).click();
        return new MyAccountPage(driver);
    }


}
