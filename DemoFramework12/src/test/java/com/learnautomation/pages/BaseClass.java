package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExelDataProvider exel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite //as soon as test suit start it run before suit
	public void setupSuit() {

		Reporter.log("Setting up report and test is getting ready" , true);
		exel = new ExelDataProvider();
		config = new ConfigDataProvider();
		
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.id")+"/Reports/FreeCRM" +Helper.getCurrentDataTime()+ ".html"));
		 report = new ExtentReports();
		 report.attachReporter(extent);
		 
		 Reporter.log("Setting done :-Test can be started" , true);
	}

	@BeforeClass
	public void setup() {

		Reporter.log("Try to start browser and getting application ready" , true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.StagingURL());

		 Reporter.log("Browser and Application up and running" , true);
	}

	@AfterClass
	public void tearDown() {

		BrowserFactory.quiteBrowser(driver);

	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		
		 Reporter.log("Test is about to end" , true);
		 
		if(result.getStatus()==ITestResult.FAILURE) {
			
			//Helper.captcureScreenshot(driver);
			
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captcureScreenshot(driver)).build());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS) {
			
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captcureScreenshot(driver)).build());
		}
		report.flush();
		
		 Reporter.log("Test compleated >>>>report generated" , true);
	}

}
