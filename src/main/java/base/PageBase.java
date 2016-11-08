package base;

import org.openqa.selenium.WebDriver;
import pages.part.Header;

/**
 * Created by olapanovich on 29.10.16.
 */
public abstract class PageBase {
    private final Header HEADER;
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        HEADER = new Header(driver);
    }

    public WebDriver getDriver() { return driver; }

    public Header getHeader() {
        return HEADER;
    }


}

