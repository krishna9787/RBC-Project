package pageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.HandleDriver;
import commonFunctions.ExtentTestManager;
import org.testng.Assert;

public class SignInPage {
	private WebDriver driver;

	public SignInPage(String browser) {
		driver = HandleDriver.getDriver(browser);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#ap_email")
	WebElement email;
	
	//method to check if Email or Phone number is asked
	public synchronized void signInVerification(String browser) {
		Assert.assertEquals(email.isDisplayed(), true);
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Email or Phone number is asked");
	}
}
