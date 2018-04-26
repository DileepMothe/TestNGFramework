package com.test.uiautomation.Automation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public static final Logger log=Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;
	
    @FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
    
    @FindBy(xpath="//*[@id='email']")
    WebElement loginEmailAddress;

    
    @FindBy(xpath="//*[@id='passwd']")
    WebElement loginPassword;
    
    
    @FindBy(xpath="//*[@id='SubmitLogin']")
    WebElement signInButton;
    
    @FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
    WebElement authenicationFailed;
    
   
    
    public HomePage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public void loginApplicationTest(String emailAddress,String password)
    {
    	log.info("Clicking on Sign in link in homepage");
    	signIn.click();
    	log.info("Entering the email address as"+emailAddress);
    	loginEmailAddress.sendKeys(emailAddress);
    	log.info("Entering the password as"+password);
    	loginPassword.sendKeys(password);
    	log.info("Clicking on Signin button");
    	signInButton.click();
    }
    
    public String getErrorText()
    {
    	return authenicationFailed.getText();
    }
}
