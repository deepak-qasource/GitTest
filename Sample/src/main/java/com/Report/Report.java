
/**
 *  Pojo for generating Report.
 */
package com.Report;

import java.util.Date;

public class Report {

	private int testPassed;
	private int testFailed;
	private int testSkipped;
	private int totalTests;
	private String totalTime;
	private Date executionDate;
	private String environment;
	private double buildNumber;
	private String currentDir;

	public int getTotalTests() {
		return totalTests;
	}

	public void setTotalTests(int totalTests) {
		this.totalTests = totalTests;
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}

	private Date executionTime;

	public int getTestPassed() {
		return testPassed;
	}

	public void setTestPassed(int testPassed) {
		this.testPassed = testPassed;
	}

	public int getTestFailed() {
		return testFailed;
	}

	public void setTestFailed(int testFailed) {
		this.testFailed = testFailed;
	}

	public int getTestSkipped() {
		return testSkipped;
	}

	public void setTestSkipped(int testSkipped) {
		this.testSkipped = testSkipped;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String l) {
		this.totalTime = l;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public double getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(double buildNumber) {
		this.buildNumber = buildNumber;
	}

	public void setCurrentDir(String currentDir) {
		this.currentDir = currentDir;
	}

	public String getCurrentDir() {
		return currentDir;
	}

}
