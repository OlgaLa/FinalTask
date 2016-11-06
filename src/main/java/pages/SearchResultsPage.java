package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.part.Product;

import static helpers.Locators.get;

/**
 * Created by olapanovich on 30.10.16.
 */
public class SearchResultsPage extends PageBase{

    private static final By SEARCH_RESULTS = get("Header.SearchResults");
    private Product product;

    public SearchResultsPage(WebDriver driver) {

        super(driver);
        product = new Product(driver);
    }

    public Product getProduct() {  return product; }

    public int getSearchResults() {

        System.out.print(driver.findElements(SEARCH_RESULTS).size());
        return driver.findElements(SEARCH_RESULTS).size();

    }

}
