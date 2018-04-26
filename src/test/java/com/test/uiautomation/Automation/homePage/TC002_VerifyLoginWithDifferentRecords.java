package com.test.uiautomation.Automation.homePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.uiautomation.Automation.testBase.TestBase;
import com.test.uiautomation.Automation.uiActions.HomePage;

public class TC002_VerifyLoginWithDifferentRecords extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC002_VerifyLoginWithDifferentRecords.class.getName());
	
	
	HomePage homepage;
	
	@DataProvider(name="loginData")
	public String[][] getTestData()
	{
		String[][]testResults=getData("TestData.xlsx","LoginData");
		return testResults;
	}
	
	@BeforeClass
	public void setUP() throws IOException
	{
		init();
	}
	
	@Test(dataProvider="loginData")
	public void testLogin(String emailAddress,String password,String runmode )
	{
		if(runmode.equalsIgnoreCase("n"))
		{
			throw new SkipException("User is marked this record as not to run");
		}
		else
		{
		log.info("================Staring of Test Excecution==================");
		homepage.loginApplicationTest(emailAddress, password);
		homepage.getErrorText();
		log.info("================Ending of Test Excecution==================");
		}
		
	}
	
	/*@AfterTest
	public void end()
	{
		driver.close();
	}*/
}
