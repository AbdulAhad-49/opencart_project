package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
public class TC_002_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void test_Login() {
		logger.info("Starting TC_002_LoginTest");
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("****  Click My Account Button *****");
			hp.clickLogin();
			logger.info("****  Click Login Button  ****");
			
			LoginPage lp=new LoginPage(driver);
			lp.setTxtEmail(rb.getString("email"));
			lp.setTxtPassword(rb.getString("password"));
			lp.clickLoginBtn();
			logger.info("****  Click Login Button for sign In  ****");
			

			MyAccountPage myap=new MyAccountPage(driver);
			boolean targetpage=myap.isMyAccountPageExists();
			Assert.assertEquals(targetpage, true);	
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("Finishing TC_002_LoginTest");
	}
}
