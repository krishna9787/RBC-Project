package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;

import commonfunctions.ExtentTestManager;
import commonfunctions.ExternalWaitLoadPage;
import commonfunctions.HandleDriver;

import org.testng.Assert;

public class SignInPage {
	private WebDriver driver;

	//Constructor
	public SignInPage(String browser) {
		driver = HandleDriver.getDriver(browser);
		PageFactory.initElements(driver, this);
	}

	//Locators
	@FindBy(css = "#ap_email")
	WebElement email;
	
	@FindBy(id = "ap_password")
	WebElement password;
	
	
	//method to check if Email or Phone number is asked
	public synchronized SignInPage guestSignInVerification(String browser) throws Exception {
		//call method to wait till page is loaded
		ExternalWaitLoadPage.isPageLoaded(browser,email,"SignIn");
		Assert.assertEquals(driver.getTitle(), "Amazon Sign In");
		Assert.assertTrue(password.isDisplayed());
		Assert.assertTrue(email.isDisplayed());
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Email or Phone number is asked");
		return this;
	}
}
