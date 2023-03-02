package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
//	public LoginPage(WebDriver ldriver) {
	
	//	this.driver = ldriver;
		 
//	}

	
	@FindBy(xpath = "//a[text()='लॉग इन करें']") WebElement login1;
	@FindBy(xpath= "//a[contains(text(),'Sign Up')]") WebElement sinup;
	@FindBy(xpath = "//a[contains(text(),'Got an account? Log in here')]") WebElement login;
	@FindBy(name= "email")WebElement uname;
	@FindBy(name = "password")WebElement password1;
	@FindBy(xpath = "//div[contains(text(),'Login')]")WebElement log;
	
	
	public void loginToCRM(String usernameApplication,String passwordApplication) {
		
		login1.click();
		//sinup.click();
		//login.click();
		uname.sendKeys(usernameApplication);
		password1.sendKeys(passwordApplication);
		log.click();
		
	}
	
}
