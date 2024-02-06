package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_New_Accout_Registration extends BaseClass{
	
	@Test
	public void AccountRegistartion() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		RegistrationPage rp=new RegistrationPage(driver);
		logger.debug("****Application logs*****");
		logger.info("********clicking on my account********");
		hp.click_Createact();
		
		Thread.sleep(5000);
		logger.info("********Entering firstname********");
		rp.setFirstname(RB.getString("firstname"));
		logger.info("********Entering lastname********");
		rp.setLastname(RB.getString("lastname"));
		logger.info("********Entering emailid********");
		rp.setEmail(RB.getString("email"));
		logger.info("********Entering Password********");
		rp.setPassword(RB.getString("password"));
		logger.info("********Entering confirm password********");
		rp.setCnfPassword(RB.getString("cnfpwd"));
		logger.info("********Clicking on register********");
		rp.clickRegister();
		
		Assert.assertTrue(false);
		
		
				
	}

}
