import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.FailedReporter;
import pages.ProductPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

/**
 * Created by olapanovich on 31.10.16.
 */

@Listeners(FailedReporter.class)
public class ProductPageTest extends TestBase {

    private ProductPage productPage;
    private static final String PRODUCT_CATEGORY = "T-shirts";

    @Test(groups = {"smoke", "product"})
    @TestCaseId("E-6")
    @Stories("Verify that the T-shirt is in Women catalog")
    @Features("CatalogTest")
    public void productPageTest() {
        productPage = homePage.getHeader().clickTShirtsSubcategory();
        Assert.assertTrue(productPage.getProduct().getProductTitle().contains(PRODUCT_CATEGORY), "Product name doesn't contain T-shirts");
    }
}
