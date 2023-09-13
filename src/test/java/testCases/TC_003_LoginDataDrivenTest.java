package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp) {
		logger.info("Starting TC_002_LoginTest");
		
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("****  Click My Account Button *****");
			hp.clickLogin();
			logger.info("****  Click Login Button  ****");
			
			LoginPage lp=new LoginPage(driver);
			lp.setTxtEmail(email);
			lp.setTxtPassword(pwd);
			lp.clickLoginBtn();
			logger.info("****  Click Login Button for sign In  ****");
			

			MyAccountPage myap=new MyAccountPage(driver);
			boolean targetpage=myap.isMyAccountPageExists();
		
			if(exp.equals("Valid")) {
				if(targetpage==true) {
					myap.clickLogout();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equals("Invalid")) {
				if(targetpage==true) {
					myap.clickLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
		
		logger.info("Finishing TC_002_LoginTest");
	}
}
