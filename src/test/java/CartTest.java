import base.TestBase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.FailedReporter;
import pages.CartPage;
import pages.SearchResultsPage;
import ru.yandex.qatools.allure.annotations.Stories;


/**
 * Created by olapanovich on 30.10.16.
 */

@Listeners(FailedReporter.class)
public class CartTest extends TestBase {

    private SearchResultsPage searchResultsPage;
    private CartPage cartPage;
    private String productText;
    private static final String SEARCH_ITEM ="Blouse";
    private static final String CART_MESSAGE = "Your shopping cart is empty.";

    SoftAssert soft_assert = new SoftAssert();

    @Test(groups = {"smoke", "cart"})
    @TestCaseID("E-5")
    @Stories("Verify the ability to add and delete items from cart")
    @Feature("CartTest")
    public void cartTest() throws InterruptedException {

        searchResultsPage = homePage.getHeader().searchItem(SEARCH_ITEM);
        productText = searchResultsPage.getProduct().getProductTitle();
        searchResultsPage.getProduct().addProductToCart();
        cartPage = searchResultsPage.getHeader().clickCart();
        soft_assert.assertEquals(cartPage.getItemCartTitle(), productText);
        cartPage.clickDeleteIcon();
        soft_assert.assertEquals(cartPage.getEmptyCardMessage(), CART_MESSAGE);
        soft_assert.assertAll();
    }
}