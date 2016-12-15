package com.Sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	static WebDriver driver;
	 
	 @BeforeTest
	    public void setup(){
		 	driver = new FirefoxDriver();
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	         driver.get("http://bebotechnologies.com/"); 
	        
	    } 
	 
	  @AfterTest
	 public void tearDown(){ 
	   driver.quit();
	     }

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	} 
	 
}
