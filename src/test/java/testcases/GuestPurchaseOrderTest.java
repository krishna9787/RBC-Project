package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AddToOrderPage;
import pages.AmazonHomePage;
import pages.KindlePaperwhiteProductPage;
import pages.ShopByDeptPage;
import pages.ShoppingCartPage;
import pages.SignInPage;

public class GuestPurchaseOrderTest extends AbstractTest{
	
	@Parameters({"browser"}) //browser value is passed in every method to handle parallel browser testing
	@Test
	public synchronized void signInPageVerification(String browser) throws Exception {
		AmazonHomePage ahp = new AmazonHomePage(browser);
		
		ShopByDeptPage sdp = ahp.navigateToShopByDptPage(browser);
		
		KindlePaperwhiteProductPage pacp = sdp.navigateToKindlePaperwhitePage(browser);
		pacp.isKindlePaperwhitePageLoaded(browser); //check if page loaded is for Kindle Paperwhite product
		pacp.selectQuantity(browser,"2");
		
		AddToOrderPage aop = pacp.clickAddToCart(browser);
		
		ShoppingCartPage scp = aop.navigateToShoppingCartPage(browser);
		scp.verifyCartContent(browser,"Kindle Paperwhite","2");
		
		SignInPage sip = scp.navigateToSignInPage(browser);
		sip.guestSignInVerification(browser);
	}
	
}
