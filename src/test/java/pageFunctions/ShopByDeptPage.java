package pageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.ExtentTestManager;
import commonFunctions.HandleDriver;

public class ShopByDeptPage {
	private WebDriver driver;
	public ShopByDeptPage(String browser) {
		driver = HandleDriver.getDriver(browser);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='shopAllLinks']/tbody/tr/td[2]/div[1]/ul[1]/li[2]") //complex xpath selected for browser compatibility
	WebElement paperwhiteLink;
	
	//Method to verify if Paperwhite Link is displayed and to click it if displayed
	public void clickKindlePaperwhite(String browser) {
		Assert.assertEquals(paperwhiteLink.isDisplayed(), true);
		paperwhiteLink.click();
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Kindle Paperwhite link found and clicked");
	}
}
