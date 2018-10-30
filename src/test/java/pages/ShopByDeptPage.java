package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import commonfunctions.ExtentTestManager;

public class ShopByDeptPage extends BasePage{

	//Constructor
	public ShopByDeptPage(String browser) {
		super(browser);
	}

	//Locators
	@FindBy(id="shopAllLinks")
	WebElement shopalllink;
	
	@FindBy(xpath = "//*[@id='shopAllLinks']/tbody/tr/td[2]/div[1]/ul[1]/li[2]")  	// complex xpath selected for browser compatibility																			
	WebElement paperwhitelink;
	

	// Method to click 'All-new Kindle Paperwhite' link if displayed
	public KindlePaperwhiteProductPage navigateToKindlePaperwhitePage(String browser) throws Exception {
		//call method to wait till page is loaded
		isPageLoaded(browser,shopalllink,"Shop By Department");
		Assert.assertTrue(paperwhitelink.isDisplayed());
		paperwhitelink.click();
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Kindle Paperwhite link found and clicked");
		return new KindlePaperwhiteProductPage(browser);
	}
}
