package helpers;


import org.testng.annotations.DataProvider;

/**
 * Created by olapanovich on 30.10.16.
 */
public class ContactUsProvider {

    @DataProvider(name = "contactUslDataProvider")
    public static Object[][] contactUslDataProvider() {
        return new Object[][]{
                new Object[]{"123", "Message 123"}
        };
    }

    @DataProvider(name = "contactUsEmptyMessageDataProvider")
    public static Object[][] contactUsEmptyMessageDataProvider() {
        return new Object[][]{
                new Object[]{"123", ""}
        };
    }
}