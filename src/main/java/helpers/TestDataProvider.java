package helpers;


import org.testng.annotations.DataProvider;

/**
 * Created by olapanovich on 30.10.16.
 */
public class TestDataProvider {

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

    @DataProvider(name = "registrationDataProvider")
    public static Object[][] registrationDataProvider() {
        return new Object[][]{
                new Object[]{"First Name", "Last Name", "password", "address", "City", "12345", "12345678912", "Alias", }
        };
    }
}