package com.Sample;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSample extends BaseTest {
	
	@Test
	public void TestSampleTest(){
		Assert.assertTrue(false);
		
	}
	
	
	@Test(dependsOnMethods = { "TestSampleTest" })
	public void TestSampleTest1(){
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void TestSampleTest2(){
		Assert.assertTrue(true);
		
	}
	@Test
	public void TestSampleTest3(){
		Assert.assertTrue(true);
		
	}
	@Test
	public void TestSampleTest4(){
		Assert.assertTrue(false);
		
	}
	@Test(dependsOnMethods = { "TestSampleTest" })
	public void TestSampleTest5(){
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void TestSampleTest6(){
		Assert.assertTrue(true);
		
	}
	
	
}
