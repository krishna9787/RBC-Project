package pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;

import commonfunctions.ExtentTestManager;
import commonfunctions.HandleDriver;
import junit.framework.Assert;

public class AbstractPage {
	
	public AbstractPage(String browser) {
		WebDriver driver = HandleDriver.getDriver(browser);
		PageFactory.initElements(driver, this);
	}
	
	// generic method to handle page loading
	public static synchronized void isPageLoaded(String browser, WebElement we, String pagename) throws Exception {
		WebDriver driver = HandleDriver.getDriver(browser);
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(we));
		} catch (Exception e) {
			ExtentTestManager.getTest(browser).log(LogStatus.FAIL, pagename + " page is not loaded successfully");
			Assert.fail();
			throw new Exception(pagename + " page is not loaded successfully", e);
		}
		
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, pagename + " page is loaded successfully");
	}
}
