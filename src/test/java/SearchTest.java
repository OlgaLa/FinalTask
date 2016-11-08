import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.FailedReporter;
import pages.SearchResultsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

/**
 * Created by olapanovich on 30.10.16.
 */

@Listeners(FailedReporter.class)
public class SearchTest extends TestBase {

    private SearchResultsPage searchResultsPage;
    private static final String SEARCH_ITEM ="Blouse";


    @Test(groups = {"smoke", "search"})
    @TestCaseId("E-4")
    @Stories("Verify the ability to search items")
    @Features("SearchTest")
    public void searchTest() {

        searchResultsPage = homePage.getHeader().searchItem(SEARCH_ITEM);
        Assert.assertNotEquals(searchResultsPage.getSearchResults(), 0, "No search result");
    }
}
