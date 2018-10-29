package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import commonfunctions.HandleDriver;

public class AbstractTest {
	@Parameters({"browser"})
	@BeforeClass
	public synchronized void setUp(String browser) throws Exception {
		HandleDriver.initDriver(browser);
	}

	@Parameters({"browser"})
	@AfterClass
	public synchronized void teardown(String browser) {
		HandleDriver.endDriver(browser);
	}
}
