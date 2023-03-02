package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExelDataProvider;

public class LoginTestCRM extends BaseClass {

	@Test
	public void loginApp() {

		logger = report.createTest("Login to CRM");
		ExelDataProvider exel = new ExelDataProvider();
		// exel.getStringData("Login", 0, 0);
		// System.out.println(driver.getTitle());

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");
		loginpage.loginToCRM(exel.getStringData("Login", 0, 0), exel.getStringData("Login", 0, 1));

		// BrowserFactory.quitBrowser(driver);

		// Helper.captureScreenshot(driver);
		logger.pass("Login Success");
	}

}
