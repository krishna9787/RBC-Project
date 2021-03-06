package commonfunctions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	@Parameters({"browser"})
	@BeforeClass
	public synchronized void setUp(String browser) throws Exception {
		try {
			ExtentTestManager.initTestReports("signInPageVerification " + browser, browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HandleDriver.initDriver(browser);
	}

	@Parameters({"browser"})
	@AfterClass
	public synchronized void teardown(String browser) {
		HandleDriver.endDriver(browser);
	}
}
