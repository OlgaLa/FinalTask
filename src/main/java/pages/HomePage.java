package pages;

//import base.PageBase;
import base.PageBase;
import org.openqa.selenium.WebDriver;
import pages.part.Header;
import pages.part.Product;

/**
 * Created by olapanovich on 29.10.16.
 */
public class HomePage extends PageBase {

    private Product product;

    public HomePage(WebDriver driver) {
        super(driver);
        product = new Product(driver);
    }

    public Product getProduct() {  return product; }
}
