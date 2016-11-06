import base.TestBase;
import helpers.RegistrationDataProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.FailedReporter;
import pages.AuthenticationPage;
import pages.MyAccountPage;
import pages.RegistrationPage;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Created by olapanovich on 30.10.16.
 */

@Listeners(FailedReporter.class)
public class RegistrationTest extends TestBase{

    private RegistrationPage registrationPage;
    private AuthenticationPage authenticationPage;
    private MyAccountPage myAccountPage;
    private static final String EXPECTED_TITLE = "MY ACCOUNT";


    @Test(dataProviderClass = RegistrationDataProvider.class, dataProvider = "registrationDataProvider", groups = {"smoke", "registration"})
    @TestCaseID("E-3")
    @Stories("Verify the ability to register")
    @Feature("RegisterTest")
    public void registrationTest(String firstName, String lastName, String password, String address,
                                 String city, String postcode, String mobilePhone, String alias) throws InterruptedException {

        authenticationPage = homePage.getHeader().clickSignIn();
        authenticationPage.enterEmail(generateRandomEmail());
        registrationPage = authenticationPage.clickCreateAccountButton();
        myAccountPage = registrationPage.registerCustomer(firstName, lastName, password, address, city, postcode, mobilePhone, alias);
        Assert.assertEquals(myAccountPage.getTitle(), EXPECTED_TITLE);
    }
}