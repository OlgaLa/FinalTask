package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.Locators.get;

/**
 * Created by olapanovich on 30.10.16.
 */
public class CartPage extends PageBase{


    private static final By ITEM_CART_TITLE = get("CartPage.ItemTitle");
    private static final By DELETE_ICON = get("CartPage.DeleteIcon");
    private static final By EMPTY_CART_MESSAGE = get("CartPage.EmptyCartMessage");
    private static final By PROCEED_TO_CHECKOUT_1 = get("CartPage.ProceedToCheckoutButton1");


    WebDriverWait wait = new WebDriverWait(driver, 15);

    public CartPage(WebDriver driver) { super(driver); }

    public String getItemCartTitle() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(ITEM_CART_TITLE)));
        return driver.findElement(ITEM_CART_TITLE).getText();
    }

    public void clickDeleteIcon() throws InterruptedException {

        driver.findElement(DELETE_ICON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMPTY_CART_MESSAGE));
    }

    public String getEmptyCardMessage() {

        System.out.print(driver.findElement(EMPTY_CART_MESSAGE).getText());
        return driver.findElement(EMPTY_CART_MESSAGE).getText();
    }

    public AuthenticationPage clickProceedToCheckoutForUnauthorizedUser() {

        driver.findElement(PROCEED_TO_CHECKOUT_1).click();
        return new AuthenticationPage(driver);
    }


}
