package commonFunctions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleDriver {
	private static WebDriver driverchrome;
	private static WebDriver driverfirefox;
	private static WebDriver driver;

	//method to initialize browser
	public static synchronized WebDriver initDriver(String url, String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/chromedriver");
			driverchrome = new ChromeDriver();
			driverchrome.get(url);
			driverchrome.manage().deleteAllCookies();
			driverchrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver = driverchrome;
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/geckodriver");
			driverfirefox = new FirefoxDriver();
			driverfirefox.get(url);
			driverfirefox.manage().deleteAllCookies();
			driverfirefox.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver = driverfirefox;
		}
		return driver;
	}

	public static synchronized WebDriver getDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = driverchrome;
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = driverfirefox;
		}
		return driver;
	}

	public static synchronized WebDriver getListnerDriver(String browser) {

		if (browser.equalsIgnoreCase("chrometest")) {
			driver = driverchrome;
		} else if (browser.equalsIgnoreCase("firefoxtest")) {
			driver = driverfirefox;
		}
		return driver;
	}

	public static synchronized void endDriver(String browser) {
		if (browser.equalsIgnoreCase("chrometest")) {
			driverchrome.close();
			driverchrome.quit();
		} else if (browser.equalsIgnoreCase("firefoxtest")) {
			driverfirefox.close();
			driverfirefox.quit();
		}

	}
}
