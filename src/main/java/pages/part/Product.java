package pages.part;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static helpers.Locators.get;

/**
 * Created by olapanovich on 30.10.16.
 */
public class Product {

    private static final By ADD_TO_CART_BUTTON= get("Product.AddToCartButton");
    private static final By ITEM_TITLE = get("Product.ItemTitle");
    private static final By ITEM_IMAGE = get("Product.ItemImage");
    private static final By CROSS = get("Product.Cross");
    List<WebElement> items;
    private WebDriver driver;

    public Product(WebDriver driver) { this.driver = driver; }


    public void clickAddToCart() {

        Actions builder = new Actions(driver);
        items = driver.findElements(ITEM_IMAGE);
        builder.moveToElement(items.get(0)).perform();
        builder.moveToElement(driver.findElement(ADD_TO_CART_BUTTON)).click().perform();

    }

    public void closeProductPopUp() {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(CROSS)));
        driver.findElement(CROSS).click();

    }

    public void addProductToCart() throws InterruptedException {

        clickAddToCart();
        closeProductPopUp();
    }

    public String getProductTitle() {

        return driver.findElement(ITEM_TITLE).getText();
    }

}
