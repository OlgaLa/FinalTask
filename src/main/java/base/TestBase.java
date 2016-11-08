package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by olapanovich on 3.11.16.
 */
public class TestBase {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "../chromedriver");
        String browser = System.getProperty("browser") != null ? System.getProperty("browser").toLowerCase() : "chrome";

        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }

    public String generateRandomEmail() {

        Random random = new Random();
        int randomNumber = random.nextInt(10000) + 10000;
        return "o.wartooth+"+randomNumber+"@gmail.com";
    }

}

