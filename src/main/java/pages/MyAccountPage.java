package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static helpers.Locators.get;

/**
 * Created by olapanovich on 30.10.16.
 */
public class MyAccountPage extends PageBase {

    private static final By TITLE = get("MyAccountPage.Title");
    private static final By PROCEED_ADDRESS_BUTTON = get("MyAccountPage.ProceedAdderessButton");
    private static final By PROCEED_CARRIER_BUTTON = get("MyAccountPage.ProceedCarrierButton");
    private static final By TERMS_AGREEMENT_CHECKBOX = get("MyAccountPage.TermsAgrementCheckbox");
    private static final By PAY_BY_CHECK_BUTTON = get("MyAccountPage.PayByCheckButton");
    private static final By CONFIRM_ORDER_BUTTON=get("MyAccountPage.ConfirmOrderButton");
    private static final By ORDERS_HISTORY_BUTTON = get("MyAccountPage.OrderHistoryButton");
    private static final By ORDERS_TABLE = get("MyAccountPage.OrdersTable");
    private WebDriverWait wait;
    private List<WebElement> orders;


    public MyAccountPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    private void checkAgreeWihTerms() {
        driver.findElement(TERMS_AGREEMENT_CHECKBOX).click();
    }

    private void selectPaymentMethod() {
        driver.findElement(PAY_BY_CHECK_BUTTON).click();
    }

    private void clickConfirmOrderButton() {
        driver.findElement(CONFIRM_ORDER_BUTTON).click();
    }

    private void clickProceedAddressButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PROCEED_ADDRESS_BUTTON));
        driver.findElement(PROCEED_ADDRESS_BUTTON).click();
    }

    private void clickProceedCarrierButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PROCEED_CARRIER_BUTTON));
        driver.findElement(PROCEED_CARRIER_BUTTON).click();
    }

    public void finishCheckout() {
        clickProceedAddressButton();
        checkAgreeWihTerms();
        clickProceedCarrierButton();
        selectPaymentMethod();
        clickConfirmOrderButton();
    }

    public void clickOrdersHistoryButton() {
        driver.findElement(ORDERS_HISTORY_BUTTON).click();
    }

    public int checkOrdersTable() {
        orders = driver.findElements(ORDERS_TABLE);
        return orders.size();
    }
}
