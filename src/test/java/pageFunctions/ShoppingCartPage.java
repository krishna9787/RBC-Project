package pageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.HandleDriver;
import commonFunctions.ExtentTestManager;

public class ShoppingCartPage {
	private WebDriver driver;
	
	public ShoppingCartPage(String browser) {
		driver = HandleDriver.getDriver(browser);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(@class,'hlb-checkout-button')]")
	WebElement proceedcheckout;
	
	@FindBy(xpath="//*[@id='hl-confirm']/div[1]/span[2]")
	WebElement checkcart;
	
	//method to check the quantity in Cart
	public synchronized void checkCart(String browser) {
		Assert.assertEquals(checkcart.getText(),"2 items added to Cart");
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Verified 2 items in Cart");
	}
	
	//method to verify if Proceed to checkout button is displayed and clicked
	public synchronized void proceedToCheckout(String browser) {
		driver = HandleDriver.getDriver(browser);
		Assert.assertEquals(proceedcheckout.isDisplayed(),true);
		proceedcheckout.click();
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Proceed To Checkout is Clicked");
	}
}
