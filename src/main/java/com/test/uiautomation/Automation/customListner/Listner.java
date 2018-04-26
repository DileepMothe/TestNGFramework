package com.test.uiautomation.Automation.customListner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.uiautomation.Automation.testBase.TestBase;

public class Listner extends TestBase implements ITestListener{
	
//	public WebDriver driver;
//	public Listner(WebDriver driver)
//	{
//		this.driver=driver;
//	}

	public void onTestStart(ITestResult result) {
		Reporter.log("Test Started Running"+result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		Calendar calender=Calendar.getInstance();
		  SimpleDateFormat formater=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		  String methodName=result.getName();
		  
		  if(result.isSuccess())
		  {
		  File srcFile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		  
		  try
		  {
			  String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/uiautomation/Automation/";
			  File destFile=new File((String)reportDirectory+"/success_screenshots/"+methodName+"_"+formater.format(calender.getTime())+".png");
			  FileUtils.copyFile(srcFile,destFile);
			 //This will help us to link the screenshot in testNG report
			 Reporter.log("<a href='"+destFile.getAbsolutePath()+"'> <img src='"+destFile.getAbsolutePath() +"'height='100 width='100'/></a>");
		}
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  }
		
	}

	public void onTestFailure(ITestResult result) {
		
		Calendar calender=Calendar.getInstance();
		  SimpleDateFormat formater=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		  String methodName=result.getName();
		  if(!result.isSuccess())
		  {
		  File srcFile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		  
		  try
		  {
			  String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/uiautomation/Automation/";
			  File destFile=new File((String)reportDirectory+"/failure_screenshots/"+methodName+"_"+formater.format(calender.getTime())+".png");
			  FileUtils.copyFile(srcFile,destFile);
			 //This will help us to link the screenshot in testNG report
			 Reporter.log("<a href='"+destFile.getAbsolutePath()+"'> <img src='"+destFile.getAbsolutePath() +"'height='100 width='100'/></a>");
		}
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  }
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test is Skipped"+result.getMethod().getMethodName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		//Reporter.log("Test is OnTest"+((ITestResult)context).getMethod().getMethodName());
		
	}

	public void onFinish(ITestContext context) {
		//Reporter.log("Test is OnFinish"+((ITestResult)context).getMethod().getMethodName());
		
	}
	
	
	

}
