package testCases;
import testBase.BaseClass;
import pageObjects.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
public class TC_001_AccountRegistraionTest extends BaseClass{

	@Test(groups= {"Regression","Master"})
	public void testAccountRegistration() throws InterruptedException {
		
		logger.debug("applications Logs .....");
		logger.info("***  Starting TC_001_AccountRegistraionTest ***");
		
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*** Click on My Account ***");
			hp.clickRegister();
			logger.info("*** Click on Register ***");
			
			
			AccountRegistrationPage arp=new AccountRegistrationPage(driver);
			
			logger.info("*** Providing customer Data ***");
			arp.setFirstName("ali");
			arp.setLastName("1234");
			arp.setEmail("ali1234@gmail.com");
			arp.setPassword("ali1234");
			arp.clickPolicyBtn();
			logger.info("*** Click on Policy Button ***");
			arp.clickContinueBtn();
			logger.info("*** Click on Continue Button ***");
			
			logger.info("*** Validating Confirmation MSG ***");
			Assert.assertEquals(arp.getConfirmationMsg(), "Your Account Has Been Created!","Not Getting Expected Message");
		}
		catch(Exception e) {
			logger.error("*** Test failed ***");
			Assert.fail();
		}
			
		logger.info("*** finish TC_001_AccountRegistraionTest ***");
	}
}
