package com.test.uiautomation.Automation.customListner;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListner implements WebDriverEventListener{
	
	public static final Logger log=Logger.getLogger(WebEventListner.class.getName());

	public void beforeAlertAccept(WebDriver driver) {
		log.info("before alert accept");
		
	}

	public void afterAlertAccept(WebDriver driver) {
		log.info("Alert is accepted");
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		log.info("Alert is dismissed");
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		log.info("before alert dismiss ");		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		log.info(" before Navigating to "+url);
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		log.info("Navigated to "+url);
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		log.info("Before Nagivating back to previous page");
		
	}

	public void afterNavigateBack(WebDriver driver) {
		log.info("Navigated to prevoius page");
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		log.info("Before Nagivating forwatd to previous page");
		
	}

	public void afterNavigateForward(WebDriver driver) {
		log.info("Navigated to forwatd page");
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		log.info("Before Navigation refresh");
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		log.info("Page is refreshed");
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log.info("Trying to found the element"+by.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log.info("Found Element"+by.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		log.info("before clicking on the element"+element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		log.info("Clicked on the element"+element.toString());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log.info("Value of element"+element.toString()+"before changes made");
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log.info("Value of element"+element.toString()+"after changes made");
		
	}

	public void beforeScript(String script, WebDriver driver) {
		log.info("before Script"+script.toString());
		
	}

	public void afterScript(String script, WebDriver driver) {
		log.info("after Script"+script.toString());
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		log.info("Exception is occured"+throwable);
		
	}
	

}
