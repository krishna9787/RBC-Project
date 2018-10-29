package commonfunctions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentTestManager {
	private static ExtentReports extent = ExtentReportsManager.getReporter();
	private static ExtentTest testreportchrome;
	private static ExtentTest testreportfirefox;
	private static ExtentTest testreport;

	// Method to initialize ExtentTest
	public static synchronized void initTestReports(String tcname, String browser) throws Exception {
		// throws exception to handle correct browser name
		if (browser.equalsIgnoreCase("chrome")) {
			testreportchrome = extent.startTest(tcname);
		} else if (browser.equalsIgnoreCase("firefox")) {
			testreportfirefox = extent.startTest(tcname);
		} else if (!browser.equalsIgnoreCase("chrome")) {
			if (!browser.equalsIgnoreCase("firefox")) {
				testreport = extent.startTest(tcname);
				testreport.log(LogStatus.FAIL, "Browser value is not correct");
				throw new Exception("Browser value not correct");
			}
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
