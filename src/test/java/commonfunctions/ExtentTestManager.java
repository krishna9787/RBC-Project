package commonfunctions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class ExtentTestManager {
	private static ExtentReports extent = ExtentReportsManager.getReporter();
	private static ExtentTest testreportchrome;
	private static ExtentTest testreportfirefox;
	private static ExtentTest testreport;

	// Method to initialize ExtentTest
	public static synchronized void initTestReports(String tcname, String browser) throws Exception {
		// handle incorrect browser name
		if (browser.equalsIgnoreCase("chrome")) {
			testreportchrome = extent.startTest(tcname);
		} else if (browser.equalsIgnoreCase("firefox")) {
			testreportfirefox = extent.startTest(tcname);
		} else {
			testreport = extent.startTest(tcname);
			ExtentTestManager.getTest(browser).log(LogStatus.FAIL, browser + " browser value not correct");
			Assert.fail("Browser value not correct: " + browser);
		}
	}

	// method to return ExtentTest object
	public static synchronized ExtentTest getTest(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			testreport = testreportchrome;
		} else if (browser.equalsIgnoreCase("firefox")) {
			testreport = testreportfirefox;
		}
		return testreport;
	}
}
