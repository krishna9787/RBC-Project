package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;

import commonfunctions.ExtentTestManager;
import commonfunctions.ExternalWaitLoadPage;
import commonfunctions.HandleDriver;

public class ShopByDeptPage {

	//Constructor
	public ShopByDeptPage(String browser) {
		WebDriver driver = HandleDriver.getDriver(browser);
		PageFactory.initElements(driver, this);
	}

	//Locators
	@FindBy(id="shopAllLinks")
	WebElement shopalllink;
	
	@FindBy(xpath = "//*[@id='shopAllLinks']/tbody/tr/td[2]/div[1]/ul[1]/li[2]")  	// complex xpath selected for browser compatibility																			
	WebElement paperwhitelink;
	

	// Method to click 'All-new Kindle Paperwhite' link if displayed
	public KindlePaperwhiteProductPage navigateToKindlePaperwhitePage(String browser) throws Exception {
		//call method to wait till page is loaded
		ExternalWaitLoadPage.isPageLoaded(browser,shopalllink,"Shop By Department");
		Assert.assertTrue(paperwhitelink.isDisplayed());
		paperwhitelink.click();
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Kindle Paperwhite link found and clicked");
		return new KindlePaperwhiteProductPage(browser);
	}
}
