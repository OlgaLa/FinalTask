package helpers;

import base.PageBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * Created by student on 03.11.2016.
 */
public class FailListener implements ITestListener {

    public PageBase pageBase;

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {

        captureScreenshot();
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] captureScreenshot() {
        TakesScreenshot takesScreenshot =(TakesScreenshot) pageBase.getDriver();
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }

}
