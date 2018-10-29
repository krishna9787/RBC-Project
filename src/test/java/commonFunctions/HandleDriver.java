package commonfunctions;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class HandleDriver {
	private static WebDriver driverchrome;
	private static WebDriver driverfirefox;
	private static WebDriver driver;
	private static Properties p;
	private static String chromeproperty;
	private static String firefoxproperty;
	private static String url;

	//method to get values from properties file
	public static synchronized void getProperties(String browser) throws Exception {
		p = new Properties();
		FileInputStream fin;
		try {
			fin = new FileInputStream("setup.properties");
		}catch(Exception e){
			ExtentTestManager.getTest(browser).log(LogStatus.FAIL, "Incorrect path to properties file");
			throw new Exception("Incorrect path to properties file", e);
		}
		p.load(fin);
		chromeproperty = p.getProperty("chromedriverpath");
		firefoxproperty = p.getProperty("firefoxdriverpath");
		url = p.getProperty("url");
		
	}
	
	//method to initialize Webdriver
	public static synchronized WebDriver initDriver(String browser) throws Exception {
		getProperties(browser);
		//try-catch for invalid System.setProperty path
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromeproperty);
				driverchrome = new ChromeDriver();
				driver = driverchrome;
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", firefoxproperty);
				driverfirefox = new FirefoxDriver();
				driver = driverfirefox;
			} else {
				ExtentTestManager.getTest(browser).log(LogStatus.FAIL, browser + " browser value not correct");
				Assert.fail();
				//throw if browser value is not correct
				throw new Exception("Browser value not correct: " + browser);
			}
		} catch (Exception e) {
			ExtentTestManager.getTest(browser).log(LogStatus.FAIL, "Driver not Loaded");
			throw new Exception("Driver not Loaded: " + browser);
		}
		
		// try-catch for invalid URL
		driver.get(url);
		if(!driver.getTitle().contains("Amazon.ca")) {
			Assert.fail();
			throw new Exception("URL not correct");
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
