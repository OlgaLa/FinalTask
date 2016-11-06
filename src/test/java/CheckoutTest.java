import base.TestBase;
import helpers.RegistrationDataProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.FailedReporter;
import pages.*;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Created by olapanovich on 31.10.16.
 */

@Listeners(FailedReporter.class)
public class CheckoutTest extends TestBase{

    private CartPage cartPage;
    public AuthenticationPage authenticationPage;
    public RegistrationPage registrationPage;
    public MyAccountPage myAccountPage;



    @Test(dataProviderClass = RegistrationDataProvider.class, dataProvider = "registrationDataProvider", groups = {"smoke", "checkout"})
    @TestCaseID("E-7")
    @Stories("Verify the proceed to checkout")
    @Feature("CheckoutTest")
    public void checkoutTest(String firstName, String lastName, String password, String address,
                             String city, String postcode, String mobilePhone, String alias) throws InterruptedException {

        homePage.getProduct().addProductToCart();
        cartPage = homePage.getHeader().clickCart();
        Thread.sleep(5000);
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
