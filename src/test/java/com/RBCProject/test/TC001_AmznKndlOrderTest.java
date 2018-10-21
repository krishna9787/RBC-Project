package com.RBCProject.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commonFunctions.HandleDriver;
import commonFunctions.ExtentReportsManager;
import commonFunctions.ExtentTestManager;
import pageFunctions.AddToOrderPage;
import pageFunctions.ShopByDeptPage;
import pageFunctions.AmazonHomePage;
import pageFunctions.PaperwhiteAddCartPage;
import pageFunctions.ShoppingCartPage;
import pageFunctions.SignInPage;

public class TC001_AmznKndlOrderTest {
	@Parameters({ "url", "browser" })
	@Test
	public synchronized void TC001base(String url, String browser) {
		HandleDriver.initDriver(url, browser);
		ExtentReportsManager.initReporter(); // initializing ExtentReports for reporting
		ExtentTestManager.initTestReports("TC001-" + browser, // initializing ExtentTest for adding logs and screenshot
				"Verify that amazon asks for email address or phone number", browser);
		AmazonHomePage ahp = new AmazonHomePage(browser);
		ahp.isHomePageDispalyed(browser);
		ahp.clickShopByDept(browser);
		ShopByDeptPage sdp = new ShopByDeptPage(browser);
		sdp.clickKindlePaperwhite(browser);
		PaperwhiteAddCartPage acp = new PaperwhiteAddCartPage(browser);
		acp.addToCart(browser);
		AddToOrderPage atop = new AddToOrderPage(browser);
		atop.closeClick(browser);
		ShoppingCartPage pcp = new ShoppingCartPage(browser);
		pcp.checkCart(browser);
		pcp.proceedToCheckout(browser);
		SignInPage sp = new SignInPage(browser);
		sp.signInVerification(browser);
	}
}
