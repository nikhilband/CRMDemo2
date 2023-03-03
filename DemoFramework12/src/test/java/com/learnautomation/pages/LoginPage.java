package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
//	public LoginPage(WebDriver ldriver) {
	
	//	this.driver = ldriver;
		
	//this file is updated
//	}

	
	@FindBy(xpath =  "//a[@href='https://ui.freecrm.com']")  WebElement login1;
	@FindBy(xpath= "//a[contains(text(),'Sign Up')]") WebElement sinup;
	@FindBy(xpath = "//a[contains(text(),'Got an account? Log in here')]") WebElement login;
	@FindBy(name= "email")WebElement uname;
	@FindBy(name = "password")WebElement password1;
	@FindBy(xpath = "//div[contains(text(),'Login')]")WebElement log;
	
	
	public void loginToCRM(String usernameApplication,String passwordApplication) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		login1.click();
		//sinup.click();
		//login.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		uname.sendKeys(usernameApplication);
		password1.sendKeys(passwordApplication);
		log.click();
		
	}
	
}
