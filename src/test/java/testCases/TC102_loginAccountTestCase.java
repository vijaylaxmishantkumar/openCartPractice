package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginAccountPage;
import pageObject.MyAccountPage;
import testBase.Baseclass;

public class TC102_loginAccountTestCase extends Baseclass {

	@Test(groups={"Regression","Master"})
	public void loginaAccountTest() {
		try {
			logger.info("***** Starting TC102_loginAccountTestCase *****");
			HomePage hp = new HomePage(driver);

			logger.info("Clicked on My Account");
			hp.clickMyAccount();
			logger.info("Clicked on login");
			hp.clickLogin();

			logger.info("Fill up the details");
			LoginAccountPage lp = new LoginAccountPage(driver);
			lp.setUsername(property.getProperty("Username"));
			lp.setPassword(property.getProperty("Password"));
			lp.clickLoginButton();
			
			logger.info("Validating the header");
			MyAccountPage mp = new MyAccountPage(driver);
			
//			if(mp.isMyAccountDisplayed()) {
//				Assert.assertTrue(true);
//			}else {
//				Assert.assertTrue(false);
//			}
			
			//OR
			//Assert.assertTrue(mp.isMyAccountDisplayed());
			
			// OR
			Assert.assertEquals(mp.isMyAccountDisplayed(), true, "Login Failed");
			
			mp.clickLogout();
		} catch (Exception e) {
			logger.error("*** Failed LoginPageTest ***");
			Assert.fail();
		}
		logger.info("***** Finishing TC102_loginAccountTestCase *****");
	}
}
