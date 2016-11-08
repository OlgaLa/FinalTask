package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import pages.part.Product;

/**
 * Created by olapanovich on 31.10.16.
 */
public class ProductPage extends PageBase {

    private Product product;

    public ProductPage(WebDriver driver) {
        super(driver);
        product = new Product(driver);
    }

    public Product getProduct() {  return product; }
}
