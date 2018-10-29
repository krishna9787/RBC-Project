package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.LogStatus;
import commonfunctions.ExtentTestManager;
import org.testng.Assert;

public class SignInPage extends AbstractPage{

	//Constructor
	public SignInPage(String browser) {
		super(browser);
	}

	//Locators
	@FindBy(css = "#ap_email")
	WebElement email;
	
	@FindBy(id = "ap_password")
	WebElement password;
	
	@FindBy(css = ".a-spacing-small")
	WebElement signinheader;
	
	//method to check if Email or Phone number is asked
	public synchronized SignInPage guestSignInVerification(String browser) throws Exception {
		//call method to wait till page is loaded
		isPageLoaded(browser,email,"SignIn");
		
		//verify if on Sign in page
		Assert.assertEquals(signinheader.getText(), "Sign in");
		
		//verify if email number is asked
		Assert.assertTrue(password.isDisplayed());
		Assert.assertTrue(email.isDisplayed());
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Email or Phone number is asked");
		return this;
	}
}
