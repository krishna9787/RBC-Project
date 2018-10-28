package commonfunctions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.LogStatus;

public class HandleDriver {
	private static WebDriver driverchrome;
	private static WebDriver driverfirefox;
	private static WebDriver driver;

	//method to initialize Webdriver
	public static synchronized WebDriver initDriver(String url, String browser) throws Exception {
		
		//try-catch for invalid System.setProperty path
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./src/chromedriver");
				driverchrome = new ChromeDriver();
				driver = driverchrome;
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./src/geckodriver");
				driverfirefox = new FirefoxDriver();
				driver = driverfirefox;
			}
		}catch(Exception e) {
			ExtentTestManager.getTest(browser).log(LogStatus.FAIL, "Driver not Loaded");
			throw new Exception("Driver not Loaded", e);
		}
		
		// try-catch for invalid URL
		try {
			driver.get(url);
			if(!driver.getTitle().contains("Amazon.ca")) {
				throw new Exception("URL not correct");
			}
		}catch(Exception e) {
			ExtentTestManager.getTest(browser).log(LogStatus.FAIL, "URL not correct");
			throw new Exception("URL not correct", e);
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	//method to return Webdriver
	public static synchronized WebDriver getDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = driverchrome;
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = driverfirefox;
		}
		return driver;
	}

	//method to close browser
	public static synchronized void endDriver(String browser){
		if (browser.equalsIgnoreCase("chrome")) {
			driverchrome.quit();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driverfirefox.quit();

		}
	}
}
