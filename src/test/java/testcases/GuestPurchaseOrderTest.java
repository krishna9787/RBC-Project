package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonfunctions.BaseTest;
import pages.AddToOrderPage;
import pages.AmazonHomePage;
import pages.KindlePaperwhiteProductPage;
import pages.ShopByDeptPage;
import pages.ShoppingCartPage;
import pages.SignInPage;

//browser value is passed in every method to handle parallel browser testing. It is done by setting Thread Count to 2
//ideally parallel testing is performed using Selenium grid and there is no need to pass browser in that case
public class GuestPurchaseOrderTest extends BaseTest{
	
	@Parameters({"browser"}) 
	@Test
	public synchronized void signInPageVerification(String browser) throws Exception {
		AmazonHomePage ahp = new AmazonHomePage(browser);
		
		ShopByDeptPage sdp = ahp.navigateToShopByDptPage(browser);
		
		KindlePaperwhiteProductPage pacp = sdp.navigateToKindlePaperwhitePage(browser);
		pacp.isKindlePaperwhitePageLoaded(browser); //check if page loaded is for Kindle Paperwhite product
		pacp.selectQuantity(browser,"2");
		
		AddToOrderPage aop = pacp.clickAddToCartBtn(browser);
		
		ShoppingCartPage scp = aop.navigateToShoppingCartPage(browser);
		scp.verifyCartContent(browser,"Kindle Paperwhite","2");
		
		SignInPage sip = scp.navigateToSignInPage(browser);
		sip.verifyGuestSignText(browser);
	}
	
}
