package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import commonfunctions.ExtentTestManager;

public class KindlePaperwhiteProductPage extends AbstractPage {

	// Constructor
	public KindlePaperwhiteProductPage(String browser) {
		super(browser);
	}

	// Locators
	@FindBy(name = "quantity")
	WebElement selquantity;

	@FindBy(css = "#add-to-cart-button")
	WebElement addtocart;

	@FindBy(css = "span#productTitle")
	WebElement kindlepaperwhitetitle;

	// Method to check if Kindle Paperwhite page is loaded
	public synchronized void isKindlePaperwhitePageLoaded(String browser) throws Exception {
		// call method to wait till page is loaded
		isPageLoaded(browser, kindlepaperwhitetitle, "Kindle Paperwhite Product");

		// verify if page is Kindle Paperwhite
		if (!kindlepaperwhitetitle.getText().contains("Kindle Paperwhite")) {
			Assert.fail();
		}
	}

	// Method to select quantity as 2 if quantity dropdown is displayed
	public synchronized void selectQuantity(String browser, String quant) {
		Assert.assertTrue(selquantity.isDisplayed());
		Select s = new Select(selquantity);
		s.selectByValue(quant);
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Quantity Selected as " +quant);
	}

	// Method to click 'Add to Cart' button if displayed
	public synchronized AddToOrderPage clickAddToCart(String browser) {
		Assert.assertTrue(addtocart.isDisplayed());
		addtocart.click();
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Add to Cart Link Clicked");
		return new AddToOrderPage(browser);
	}
}
