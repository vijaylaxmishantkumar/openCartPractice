package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginAccountPage;
import pageObject.MyAccountPage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC103_LoginDataDrivenTestcase extends Baseclass {

	@Test(dataProvider="LoginData",dataProviderClass = DataProviders.class,groups = {"Regression","Master"})
	public void loginaAccountDataDrivenTest(String username, String password, String result) {
	try {
		logger.info("***** Starting TC103_LoginDataDrivenTestcase *****");
		HomePage hp = new HomePage(driver);

		logger.info("Clicked on My Account");
		hp.clickMyAccount();
		logger.info("Clicked on login");
		hp.clickLogin();

		logger.info("Fill up the details");
		LoginAccountPage lp = new LoginAccountPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLoginButton();
		
		logger.info("Validating the header");
		MyAccountPage mp = new MyAccountPage(driver);
		
		/*Data is valid  - login success - test pass  - logout
		Data is valid -- login failed - test fail

		Data is invalid - login success - test fail  - logout
		Data is invalid -- login failed - test pass
		*/

		if(result.equalsIgnoreCase("valid")) {
			if(mp.isMyAccountDisplayed()) {
				mp.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		
		if(result.equalsIgnoreCase("invalid")){
            if(mp.isMyAccountDisplayed()) {
            	mp.clickLogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
	} catch (Exception e) {
		logger.error("*** Failed LoginPageTest ***");
		Assert.fail();
	}
	logger.info("***** Finishing TC103_LoginDataDrivenTestcase *****");
}

}
