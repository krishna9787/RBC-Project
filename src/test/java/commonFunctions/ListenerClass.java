package commonFunctions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

public class ListenerClass implements ITestListener {

	public void onFinish(ITestContext arg0) {
		ExtentTestManager.endTestReports();
		HandleDriver.endDriver(arg0.getName());
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult testresult) {
		ITestContext arg0 = testresult.getTestContext();
		String browser = arg0.getName();
		WebDriver driver = HandleDriver.getListnerDriver(browser);
		// Take screenshot.
		String base64Screenshot = "data:image/png;base64,"
				+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		// ExtentReports log and screenshot operation for failed tests.
		ExtentTestManager.getListnerTest(browser).log(LogStatus.FAIL,
				"Test Failed \t" + ExtentTestManager.getListnerTest(browser).addBase64ScreenShot(base64Screenshot));
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult testresult) {
		ITestContext arg0 = testresult.getTestContext();
		String browser = arg0.getName();
		WebDriver driver = HandleDriver.getListnerDriver(browser);
		// Take screenshot.
		String base64Screenshot = "data:image/png;base64,"
				+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		// ExtentReports log and screenshot operation for passed tests.
		ExtentTestManager.getListnerTest(browser).log(LogStatus.PASS,
				"Test Passed \t" + ExtentTestManager.getListnerTest(browser).addBase64ScreenShot(base64Screenshot));
	}

}
