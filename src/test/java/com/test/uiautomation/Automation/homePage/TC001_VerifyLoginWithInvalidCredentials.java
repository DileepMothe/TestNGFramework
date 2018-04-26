package com.test.uiautomation.Automation.homePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.uiautomation.Automation.testBase.TestBase;
import com.test.uiautomation.Automation.uiActions.HomePage;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase{
	
	public static final Logger log=Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	
	HomePage homepage;
	
	@BeforeClass
	public void setUP() throws IOException
	{
		init();
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials()
	{
		log.info("================Staring of Test Excecution==================");
		homepage=new HomePage(driver);
		homepage.loginApplicationTest("test@gmail.com","password123");
		Assert.assertEquals(homepage.getErrorText(), "Authentication failed.");
		getScreenshot("loginapplication");
		log.info("================Ending of Test Excecution==================");
		
	}
	
	/*@AfterTest
	public void end()
	{
		driver.close();
	}*/

}
