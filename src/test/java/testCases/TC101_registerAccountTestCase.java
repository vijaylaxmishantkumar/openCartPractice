package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegistrationPage;
import testBase.Baseclass;

public class TC101_registerAccountTestCase extends Baseclass {

	@Test(groups={"Master","Sanity"})
	public void registerTest() {

		try {
			logger.info("***** Starting TC101_registerAccountTestCase *****");
			HomePage hp = new HomePage(driver);

			logger.info("Clicked on My Acconut");
			hp.clickMyAccount();
			logger.info("Clicked on register");
			hp.clickRegister();

			RegistrationPage rp = new RegistrationPage(driver);

			logger.info("Filling out registration Page");
			rp.firstName(randomString());
			rp.lastName(randomString());
			rp.email(randomString() + "@gmail.com");
			rp.phone(randomNumber());

			String pass = randomAlphaNumeric();
			rp.password(pass);
			rp.ConPassword(pass);
			rp.condition();
			rp.continueButton();

			logger.info("*** Validating message ***");
			String msg = rp.confirmMsg();
			
			if (msg.equals("Your Account Has Been Created!")) {
                Assert.assertTrue(true);
			} else {
				logger.error("*** RegisterTest failed ***");
				logger.debug("*** Debug logs ***");
				 Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***** Finishing TC101_registerAccountTestCase *****");
	}
}
