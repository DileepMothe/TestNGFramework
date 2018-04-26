package com.test.uiautomation.Automation.uiActions;

import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage {
	
	public static final Logger log=Logger.getLogger(RegistrationPage.class.getName());
	
	WebDriver driver;
	Random random=new Random();
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(id="email_create")
	WebElement EmailAddress;
		
	@FindBy(id="SubmitCreate")
	WebElement CreateAccountButton;
	
	@FindBy(id="id_gender1")
	WebElement title;
	
	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(xpath="//*[@id='days']")
	WebElement dayDropdownList;
	
	@FindBy(xpath="//*[@id='months']")
	WebElement monthDropdowList;
	
	@FindBy(xpath="//*[@id='years']")
	WebElement yearDropdownList;
	
	@FindBy(id="firstname")
	WebElement firstnameAddress;
	
	@FindBy(id="lastname")
	WebElement lastnameAddress;
	
	@FindBy(id="company")
	WebElement companyName;
	
	@FindBy(id="address1")
	WebElement address1Details;
	
	@FindBy(id="address2")
	WebElement address2Details;
	
	@FindBy(id="city")
	WebElement cityname;
	
	@FindBy(id="id_state")
	WebElement stateDropdownList;
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	@FindBy(id="id_country")
	WebElement countryDropdownList;
	
	@FindBy(id="other")
	WebElement additionalInformationTextbox;
	
	@FindBy(id="phone")
	WebElement phoneNumberTextbox;
	
	@FindBy(id="phone_mobile")
	WebElement mobilePhoneTextbox;
	
	@FindBy(id="alias")
	WebElement aliasAddressDetails;
	
	@FindBy(id="submitAccount")
	WebElement registerButton;
	
	 public RegistrationPage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }
	
	
	public void registration() throws InterruptedException
	{
		signIn.click();
		Thread.sleep(5000);
		EmailAddress.sendKeys(System.currentTimeMillis()+"@gmail.com");
		CreateAccountButton.click();
		Thread.sleep(5000);
		title.click();
		firstName.sendKeys("firstname");
		lastName.sendKeys("lastname");
		password.sendKeys("Deepdil");
		Select date=new Select(dayDropdownList);
		date.selectByValue("10");
	    Select month=new Select(monthDropdowList);
		month.selectByValue("3");
		Select year=new Select(yearDropdownList);
		year.selectByValue("1992");
		companyName.sendKeys("ABC Technologies");
		address1Details.sendKeys("H.NO:4-2-424");
		address2Details.sendKeys("TulasiNagar");
		cityname.sendKeys("Hyderabad");
		Select state=new Select(stateDropdownList);
		state.selectByVisibleText("Indiana");
		postcode.sendKeys("46001");
		Select country=new Select(countryDropdownList);
		country.selectByVisibleText("United States");
		additionalInformationTextbox.sendKeys("Nothing");
		phoneNumberTextbox.sendKeys("0401233455");
		mobilePhoneTextbox.sendKeys("9876543210");
		aliasAddressDetails.sendKeys("Borabanda");
		registerButton.click();
		
		
	}
	
}
