import base.TestBase;
import helpers.FailListener;
import helpers.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.FailedReporter;
import pages.*;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

/**
 * Created by olapanovich on 31.10.16.
 */

@Listeners(FailListener.class)
public class CheckoutTest extends TestBase{

    private CartPage cartPage;
    public AuthenticationPage authenticationPage;
    public RegistrationPage registrationPage;
    public MyAccountPage myAccountPage;

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "registrationDataProvider", groups = {"smoke", "checkout"})
    @TestCaseId("E-7")
    @Stories("Verify the proceed to checkout")
    @Features("CheckoutTest")
    public void checkoutTest(String firstName, String lastName, String password, String address,
                             String city, String postcode, String mobilePhone, String alias) {
        homePage.getProduct().addProductToCart();
        cartPage = homePage.getHeader().clickCart();
        authenticationPage = cartPage.clickProceedToCheckoutForUnauthorizedUser();
        authenticationPage.enterEmail(generateRandomEmail());
        registrationPage = authenticationPage.clickCreateAccountButton();
        myAccountPage = registrationPage.registerCustomer(firstName, lastName, password, address, city, postcode, mobilePhone, alias);
        myAccountPage.finishCheckout();
        myAccountPage.getHeader().clickUserAccount();
        myAccountPage.clickOrdersHistoryButton();
        Assert.assertNotEquals(myAccountPage.checkOrdersTable(), 0, "The oder is not displayed");
    }
}
