package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import commonfunctions.ExtentTestManager;

public class ShoppingCartPage extends BasePage{

	//Constructor
	public ShoppingCartPage(String browser) {
		super(browser);
	}

	//Locators
	@FindBy(xpath = "//*[contains(@class,'hlb-checkout-button')]")
	WebElement proceedcheckout;

	@FindBy(xpath = "//*[@id='hl-confirm']/div[1]/span[2]")
	WebElement checkcart;
	
	@FindBy(xpath = "//*[contains(@class,'hlb-item-link')]")
	WebElement ordereditemlink;

	// method to verify content in the Cart
	public synchronized void verifyCartContent(String browser, String cartcontent, String quantity) throws Exception {
		// call method to wait till page is loaded
		isPageLoaded(browser, ordereditemlink, "Shopping Cart");
		
		//verify if the cart has whatever is ordered
		if(!ordereditemlink.getText().contains(cartcontent)) {
			Assert.fail();
		}
		
		//verify if the quantify is as per request
		Assert.assertEquals(checkcart.getText(), quantity+" items added to Cart");
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Verified "+quantity+" items in Cart");
	}

	// method to click 'Proceed to checkout button' if displayed
	public synchronized SignInPage navigateToSignInPage(String browser) {
		Assert.assertTrue(proceedcheckout.isDisplayed());
		proceedcheckout.click();
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Proceed To Checkout is Clicked");
		return new SignInPage(browser);
	}
}
