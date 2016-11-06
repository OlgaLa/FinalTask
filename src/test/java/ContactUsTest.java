import base.TestBase;
import helpers.ContactUsProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.FailedReporter;
import pages.ContactUsPage;
import ru.yandex.qatools.allure.annotations.Stories;


/**
 * Created by olapanovich on 29.10.16.
 */

@Listeners(FailedReporter.class)
public class ContactUsTest extends TestBase {

    private ContactUsPage contactUsPage;
    private static final String SUCCESS_MESSAGE = "Your message has been successfully sent to our team.";
    private static final String VALIDATIOM_MESSAGE = "There is 1 error\n" +"The message cannot be blank.";


    @Test(dataProviderClass = ContactUsProvider.class, dataProvider = "contactUslDataProvider", groups = {"smoke", "contact-us"})
    @TestCaseID("E-1")
    @Stories("Verify that contact us form sends successfully")
    @Feature("ContactUsTest")
    public void contactUsTest(String order, String message) {

        contactUsPage = homePage.getHeader().clickContactUs();
        contactUsPage.sendEmail(generateRandomEmail(), order, message);
        Assert.assertEquals(contactUsPage.getResultMessage(), SUCCESS_MESSAGE);
    }

    @Test(dataProviderClass = ContactUsProvider.class, dataProvider = "contactUsEmptyMessageDataProvider", groups = {"smoke", "contact-us"})
    @TestCaseID("E-2")
    @Stories("Verify that error message appears if Message area is empty")
    @Feature("ContactUsTest")
    public void contactUsEmptyMessageTest(String order, String message) {

        contactUsPage = homePage.getHeader().clickContactUs();
        contactUsPage.sendEmail(generateRandomEmail(), order, message);
        Assert.assertEquals(contactUsPage.getValidationResultMessage(), VALIDATIOM_MESSAGE);
    }

}

