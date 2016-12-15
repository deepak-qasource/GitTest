package com.Report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;

import org.testng.IInvokedMethodListener;
import org.apache.commons.io.FileUtils;

import org.testng.ISuite;

import org.testng.ISuiteListener;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestNGMethod;

import org.testng.ITestResult;

import org.testng.Reporter;

import com.Sample.BaseTest;


//import com.sun.jna.platform.FileUtils;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener {

	private int failedTestcases = 0;
	private int passedTestcases = 0;
	private int skippedTestcases = 0;
	private static Logger logger;
	private String outputDir;
	private WebDriver d;
	private String suiteName;
	String currentDir;
	GenerateChart gChart;
	private String testName;
	private File indexFile;
	FileWriter fileWriter;
	private static SuiteReporter suiteReporter;
	private int failedTest = 0;
	private int passedTest = 0;
	private  int skippedTest = 0;
	String description;
	GenerateSuiteChart gSuiteChart;
	private final String regressionSuiteName = "QASourceRegressionSuite";
	
	
	public Listener(){
		
		currentDir = System.getProperty("user.dir");
		
		outputDir = currentDir + "\\test-output\\custom-report";
		indexFile = new File(outputDir+ "\\index.html");	
		if(!outputDir.isEmpty())
		{
		try {
			FileUtils.deleteDirectory(new File(outputDir));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		ReportUtils.getfiles(outputDir);
		gChart = new GenerateChart();
		gSuiteChart = new GenerateSuiteChart();
		suiteReporter = new SuiteReporter(outputDir);
		
	
            
	}
	// This belongs to ISuiteListener and will execute before the Suite start
	//@Override
	public void onStart(ISuite suite) {
		failedTest = 0;
		passedTest = 0;
		skippedTest = 0;
		suiteName = suite.getName();
		
		logger = new Logger(outputDir, suiteName);

	}
	
	

	
	// This belongs to ITestListener and will execute before starting of Test set/batch 

	public void onStart(ITestContext arg0) {

	}

	// This belongs to ITestListener and will execute, once the Test set/batch is finished

	public void onFinish(ITestContext arg0) {
		


	}

	// This belongs to ITestListener and will execute only when the test is pass

	public void onTestSuccess(ITestResult test) {
		String screenshot;
		passedTest++;
		String params = "";
		if (test.getParameters().length != 0) {

			for (Object parameter : test.getParameters()) {

				params += parameter.toString() + ",";

			}
		}
			else
			{
				params = "NA";
			}
		screenshot = outputDir + "\\Screenshots\\";
		String screenshotName = test.getInstance().toString()
				+ "-"
				+ new SimpleDateFormat("yyyy-dd-MM 'at' hh-mm-ss")
						.format(System.currentTimeMillis()) + ".png";
		printTestResults(test);
		logger.log(testName, suiteName, test.getTestClass().getName(),description, "Pass",ReportUtils.parseTime(test.getStartMillis()),ReportUtils.parseTime(test.getEndMillis()), ReportUtils.parseTimeDiff(test.getEndMillis(),
				test.getStartMillis()), params , "NA", "NA", screenshotName); 
		//logger.log(test.toString());
		takeScreenshot(screenshotName,screenshot);

	

	}

	// This belongs to ITestListener and will execute only on the event of fail test

	public void onTestFailure(ITestResult test) {
		String screenshot;
		// This is calling the printTestResults method
		//failedTestcases++;
		failedTest++;
		String params = "";
		if (test.getParameters().length != 0) {

			for (Object parameter : test.getParameters()) {

				params += parameter.toString() + ",";

			}
		}
			else
			{
				params = "NA";
			}
		screenshot = outputDir + "\\Screenshots\\";
		String screenshotName = test.getInstance().toString()
				+ "-"
				+ new SimpleDateFormat("yyyy-dd-MM 'at' hh-mm-ss")
						.format(System.currentTimeMillis()) + ".png";
		printTestResults(test);
		logger.log(testName, suiteName, test.getTestClass().getName(),description, "Fail", ReportUtils.parseTime(test.getStartMillis()),ReportUtils.parseTime(test.getEndMillis()),ReportUtils.parseTimeDiff(test.getEndMillis(),
				test.getStartMillis()), params , ReportUtils.pstackHeader(test.getThrowable()), ReportUtils.pstackTrace(test.getThrowable()), screenshotName); 
		//logger.log(test.toString());
		takeScreenshot(screenshotName,screenshot);

	}

	// This belongs to ITestListener and will execute before the main test start (@Test)

	public void onTestStart(ITestResult test) {
		testName = test.getName();
	//logger.log("The execution of the main test starts now==");
		//logger.log(arg0.toString());
	}

	
	// This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped

	public void onTestSkipped(ITestResult test) {
		//skippedTestcases++;
		skippedTest++;
		String params = "";
		if (test.getParameters().length != 0) {

			for (Object parameter : test.getParameters()) {

				params += parameter.toString() + ",";

			}
		}
			else
			{
				params = "NA";
			}

		
		
		logger.log(testName, suiteName, test.getTestClass().getName(), description, "Skipped", ReportUtils.parseTime(test.getStartMillis()),ReportUtils.parseTime(test.getEndMillis()), ReportUtils.parseTimeDiff(test.getEndMillis(),
				test.getStartMillis()), params , "NA", "NA", "NA"); 
		//logger.log(test.toString());
		//takeScreenshot(screenshotName,outputDir + "custom-report\\Screenshots\\");

	}
	
	// This belongs to ISuiteListener and will execute, once the Suite is finished

		public void onFinish(ISuite arg0) {
			boolean match;
			match = matchString(suiteName.toString(), regressionSuiteName);
			
			if(match){
	
				gSuiteChart.genChart(regressionSuiteName, passedTestcases, failedTestcases, skippedTestcases, outputDir);		
				suiteReporter.closeSReport();	
			}
			else
			{
				
				gChart.genChart(suiteName.toString(), passedTest, failedTest, skippedTest, outputDir);			
				suiteReporter.SReport(suiteName);
				logger.closelogger();
			}
			failedTestcases = failedTestcases+failedTest;
			passedTestcases = passedTestcases + passedTest;
			skippedTestcases = skippedTestcases + skippedTest;
			System.out.println("failedTestcases "+ failedTestcases);
			System.out.println("passedTestcases "+passedTestcases);
			System.out.println("skippedTestcases "+skippedTestcases);
				failedTest = 0;
				passedTest = 0;
				skippedTest = 0;
		}

	private	boolean matchString(String a, String b){
		return a.contains(b);
	}

	// This is just a piece of shit, ignore this

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	// This is the method which will be executed in case of test pass or fail

	// This will provide the information on the test

	private void printTestResults(ITestResult result) {

		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);

		if (result.getParameters().length != 0) {

			String params = null;

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";

			}

			//logger.log("Test Method had the following parameters :============= " + params);

		}

		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";

			break;

		case ITestResult.FAILURE:

			status = "Failed";

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		//logger.log("Test Status: " + status);
		
	}

	// This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "About to begin executing following method :]]]]]] " + returnMethodName(arg0.getTestMethod());

		description = arg1.getMethod().getDescription();
    
		System.out.println("Description  "+description);
		//logger.log(textMsg);

	}

	// This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "Completed executing following method : ]]]]]" + returnMethodName(arg0.getTestMethod());

		//logger.log(textMsg);

	}

	// This will return method names to the calling function

	private String returnMethodName(ITestNGMethod method) {

		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}
	
	private void takeScreenshot(String screenShotFileName, String path) {

		String slocation = path + screenShotFileName;
		WebDriver d = BaseTest.getDriver();
		File srcFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		System.out.println("Screen capture saved at location "
				+ slocation);
		try {
			FileUtils.copyFile(srcFile, new File(slocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




}