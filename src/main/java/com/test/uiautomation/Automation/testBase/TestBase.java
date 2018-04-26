package com.test.uiautomation.Automation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.uiautomation.Automation.customListner.Listner;
import com.test.uiautomation.Automation.customListner.WebEventListner;
import com.test.uiautomation.Automation.excelReader.Excel_Reader;

public class TestBase {
	
 public static final Logger log=Logger.getLogger(TestBase.class.getName());
	
  public static WebDriver dr;
  //String url="http://automationpractice.com/index.php";
 //String browser="firefox";
  Excel_Reader excel;
  Listner lis;
  public EventFiringWebDriver driver;
  public WebEventListner eventlistner;
  Properties props;
  public static ExtentReports extendReports;
  public static ExtentTest extendTest;
  
  
  /*public WebDriver getDriver() {
		return driver;
	}
  
  public void setDriver(EventFiringWebDriver driver) {
		this.driver = driver;
	}*/
  
  public void loadData() throws IOException
  {
	  props=new Properties();
	  File file=new File(System.getProperty("user.dir")+"/src/main/java/com/test/uiautomation/Automation/config/config.properties");
	  FileInputStream fis=new FileInputStream(file);
	  props.load(fis);
	  
	 
  }
  
  public void init() throws IOException
  {
	  loadData();
	  extendReports=new ExtentReports(System.getProperty("user.dir")+"/src/main/java/com/test/uiautomation/Automation/reports/test"+System.currentTimeMillis()+".html",false);
	  selectBrowser(props.getProperty("browser"));
	  //lis=new Listner(dr);
	  getUrl(props.getProperty("url"));
	  String log4jConfPath="log4j.properties";
	  PropertyConfigurator.configure(log4jConfPath);
	  BasicConfigurator.configure();
	  
  }
  
  public void selectBrowser(String browser)
  {
	  if(browser.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		  log.info("Creating Object for"+browser);
		  dr=new FirefoxDriver();
		 driver=new EventFiringWebDriver(dr);
		  eventlistner=new WebEventListner();
		  driver.register(eventlistner);
		  
		  
	  }
	  else
	  {
          System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
          log.info("Creating Object for"+browser);
          dr=new ChromeDriver();
  		  driver=new EventFiringWebDriver(dr);
		  eventlistner=new WebEventListner();
		  driver.register(eventlistner);
	  }
  }
  
  
  public void getUrl(String url)
  {
	  log.info("Browser is navigating to"+url);
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }
  
  
  public String[][] getData(String excelName,String sheetName)
  {
	
     String path=System.getProperty("user.dir")+"/src/main/java/com/test/uiautomation/Automation/data/"+excelName;
	  excel=new Excel_Reader(path);
	  String[][] data= excel.getDataFromSheet(sheetName, excelName);
	  return data;
  }
  
  
  public void getScreenshot(String name)
  {
	  
	  Calendar calender=Calendar.getInstance();
	  SimpleDateFormat formater=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
	  
	  File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
	  try
	  {
		  String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/uiautomation/Automation/screenshots/";
		  File destFile=new File(reportDirectory+name+"_"+formater.format(calender.getTime())+".png");
		  FileUtils.copyFile(srcFile,destFile);
		 //This will help us to link the screenshot in testNG report
		 Reporter.log("<a href='"+destFile.getAbsolutePath()+"'> <img src='"+destFile.getAbsolutePath() +"'height='100 width='100'/></a>");
	}
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
  }
  
  public void getResult(ITestResult result)
  {
	  if(result.getStatus()==ITestResult.SUCCESS)
	  {
		  extendTest.log(LogStatus.PASS, result.getName()+ "test is pass ");
	  }
	  else if(result.getStatus()==ITestResult.SKIP)
	  {
		  extendTest.log(LogStatus.SKIP, result.getName()+ "test is Skipped and Skiped reason is"+result.getThrowable());
		  
	  }
	  else if(result.getStatus()==ITestResult.FAILURE)
	  {
		  extendTest.log(LogStatus.ERROR, result.getName()+ "test is failed "+result.getThrowable());
		  String Screen= captureScreen("");
		  extendTest.log(LogStatus.FAIL,extendTest.addScreenCapture(Screen));
	  }
	  else if(result.getStatus()==ITestResult.STARTED)
	  {
		  extendTest.log(LogStatus.INFO, result.getName()+ "test is started ");
	  }
	  
	  
  }

public String captureScreen(String fileName) {
	if(fileName=="")
	{
		fileName="blank";
	}
	File destFile=null;
	Calendar calender=Calendar.getInstance();
	  SimpleDateFormat formater=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
	  
	  File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
	  try
	  {
		  String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/uiautomation/Automation/screenshots/";
		  destFile=new File(reportDirectory+fileName+"_"+formater.format(calender.getTime())+".png");
		  FileUtils.copyFile(srcFile,destFile);
		 //This will help us to link the screenshot in testNG report
		 Reporter.log("<a href='"+destFile.getAbsolutePath()+"'> <img src='"+destFile.getAbsolutePath() +"'height='100 width='100'/></a>");
	}
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	return destFile.toString();
}

@AfterMethod
public void afterMethod(ITestResult result)
{
	getResult(result);
}

@BeforeMethod
public void beforeMethod(Method result)
{
	extendTest=extendReports.startTest(result.getName());
	extendTest.log(LogStatus.INFO, result.getName()+" test started ");
}
  
@AfterClass(alwaysRun=true)
public void endTest()
{
	closeBrowser();
}

private void closeBrowser() {
	driver.quit();
	log.info("browser is closed");
	extendReports.endTest(extendTest);
	extendReports.flush();
	
	
}

}
