package com.test.uiautomation.Automation.registrationPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.uiautomation.Automation.testBase.TestBase;
import com.test.uiautomation.Automation.uiActions.RegistrationPage;




public class TC001_VerifyRegistrationWithValidData extends TestBase {
	
public static final Logger log=Logger.getLogger(TC001_VerifyRegistrationWithValidData.class.getName());
	
RegistrationPage registrationPage;
	
	@BeforeClass
	public void setUP() throws IOException
	{
		init();
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() throws InterruptedException
	{
		log.info("================Staring of Test Excecution==================");
		registrationPage=new RegistrationPage(driver);
		registrationPage.registration();
		//Assert.assertEquals(registrationPage.getErrorText(), "Authentication failed.");
		log.info("================Ending of Test Excecution==================");
		
	}
	
	/*@AfterTest
	public void end()
	{
		driver.close();
	}*/
}
