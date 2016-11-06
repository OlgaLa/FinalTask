package helpers;

import org.testng.annotations.DataProvider;

/**
 * Created by olapanovich on 30.10.16.
 */
public class RegistrationDataProvider {

    @DataProvider
    public static Object[][] registrationDataProvider() {
        return new Object[][]{
                new Object[]{"First Name", "Last Name", "password", "address", "City", "12345", "12345678912", "Alias", }
        };
    }
}
