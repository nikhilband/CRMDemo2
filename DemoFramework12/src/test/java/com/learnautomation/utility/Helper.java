package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//screenshot, alert,frame,windows,sys issues,javascript executor 
	
			public static String captcureScreenshot(WebDriver driver) {
				
				 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 
				 String screenshotPath = System.getProperty("user.dir") + "/ScreenShot/FreeCRM_" + getCurrentDataTime() + ".png";
				 
				 try {
						FileHandler.copy(src, new File (screenshotPath));
						
						System.out.println("ScreenShot capture");
					} catch (IOException e) {
						System.out.println("Unable to capture screenshot" + e.getMessage());
					}
					return screenshotPath;
				
			}

			
			public static String  getCurrentDataTime() {
				
				DateFormat custumFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
				
				Date currentDate= new Date();
				
				return custumFormat.format(currentDate);
			}
	}
