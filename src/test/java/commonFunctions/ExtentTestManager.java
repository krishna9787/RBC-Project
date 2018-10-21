package commonFunctions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {
	private static ExtentReports extent = ExtentReportsManager.getReporter();
	private static ExtentTest testreportchrome;
	private static ExtentTest testreportfirefox;
	private static ExtentTest testreport;

	// Method to initialize ExtentTest
	public static synchronized void initTestReports(String tcname, String tcdescription, String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			testreportchrome = extent.startTest(tcname, tcdescription);
		} else if (browser.equalsIgnoreCase("firefox")) {
			testreportfirefox = extent.startTest(tcname, tcdescription);
		}
	}

	public static synchronized void endTestReports() {
		extent.flush();

	}

	//method to return ExtentTest object depending on the browser passed
	public static synchronized ExtentTest getTest(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			testreport = testreportchrome;
		} else if (browser.equalsIgnoreCase("firefox")) {
			testreport = testreportfirefox;
		}
		return testreport;
	}

	//method to return ExtentTest object to add logs and snapshot as per the ITestResult passed from Listner Class
	public static synchronized ExtentTest getListnerTest(String browser) {
		if (browser.equalsIgnoreCase("chrometest")) {
			testreport = testreportchrome;
		} else if (browser.equalsIgnoreCase("firefoxtest")) {
			testreport = testreportfirefox;
		}
		return testreport;
	}

}
