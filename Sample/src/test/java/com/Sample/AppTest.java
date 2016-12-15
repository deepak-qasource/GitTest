package com.Sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest
{
	
	 
	 //This method will return two dimensional array.
	 //This method behaves as data provider for LogIn_Test method.
	 @DataProvider
	 public Object[][] LoginCredentials(){
	  //Created two dimensional array with 4 rows and 2 columns.
	  //4 rows represents test has to run 4 times.
	  //2 columns represents 2 data parameters.
	  Object[][] Cred = new Object[4][2];
	  
	  Cred[0][0] = "UserId1";
	  Cred[0][1] = "Pass1";
	  
	  Cred[1][0] = "UserId2";
	  Cred[1][1] = "Pass2";
	  
	  Cred[2][0] = "UserId3";
	  Cred[2][1] = "Pass3";
	  
	  Cred[3][0] = "UserId4";
	  Cred[3][1] = "Pass4";
	  return Cred; //Returned Cred
	 }
	 
	 //Give data provider method name as data provider.
	 //Passed 2 string parameters as LoginCredentials() returns 2 parameters In object.
	 @Test(dataProvider="LoginCredentials")
	 public void LogIn_Test(String Usedid, String Pass){
	  System.out.println(Usedid +Pass);
	  }
@Test
public void TestPass(){
	Assert.assertTrue(true);
}

}
