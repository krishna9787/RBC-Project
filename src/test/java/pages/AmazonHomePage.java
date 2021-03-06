package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import commonfunctions.ExtentTestManager;

public class AmazonHomePage extends BasePage{

	//Constructor
	public AmazonHomePage(String browser) {
		super(browser);
	}

	//Locators
	@FindBy(id = "nav-link-shopall")
	WebElement shopdeptlink;

	@FindBy(css = ".nav-logo-link")
	WebElement amazonlogo;

	// Method to click 'Shop By Department' Link if displayed
	public synchronized ShopByDeptPage navigateToShopByDptPage(String browser) throws Exception {
		// call method to wait till page is loaded
		isPageLoaded(browser, amazonlogo, "Amazon Home");
		Assert.assertTrue(shopdeptlink.isDisplayed());
		shopdeptlink.click();
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Shop by Department link found and clicked");
		return new ShopByDeptPage(browser);
	}
}
