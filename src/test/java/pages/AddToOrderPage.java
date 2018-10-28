package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;

import commonfunctions.ExtentTestManager;
import commonfunctions.ExternalWaitLoadPage;
import commonfunctions.HandleDriver;

public class AddToOrderPage {
	private WebDriver driver;

	//Constructor
	public AddToOrderPage(String browser) {
		driver = HandleDriver.getDriver(browser);
		PageFactory.initElements(driver, this);
	}

	//Locators
	@FindBy(xpath = "//div[@class='a-popover-wrapper']/header/button[1]")
	WebElement closebutton;

	@FindBy(css = "#a-autoid-21>span>input")
	WebElement continuebutton;
	
	@FindBy(css =".a-popover-header-content")
	WebElement addtoordertitle;
	
	// method to click 'close icon or continue button' on add to Order Page
	public synchronized ShoppingCartPage navigateToShoppingCartPage(String browser) throws Exception{
		// call method to wait till page is loaded
		ExternalWaitLoadPage.isPageLoaded(browser, addtoordertitle, "Add to Order");
		
		// sometimes close button not recognized in chrome
		driver = HandleDriver.getDriver(browser);
		if (browser.equalsIgnoreCase("firefox")) {
			Assert.assertTrue(closebutton.isDisplayed());
			Actions a = new Actions(driver);
			a.moveToElement(closebutton).click(closebutton).build().perform(); // Sometimes not working without
																				// moveToElement
		} else if (browser.equalsIgnoreCase("chrome")) {
			Assert.assertTrue(continuebutton.isDisplayed());
			Actions a = new Actions(driver);
			a.moveToElement(continuebutton).click(continuebutton).build().perform();// Sometimes not working without
																					// moveToElement
		}
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "None Selected in Add to Order Screen");
		return new ShoppingCartPage(browser);
	}
}
