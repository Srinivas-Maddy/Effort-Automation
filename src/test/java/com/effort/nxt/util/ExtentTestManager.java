package com.effort.nxt.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.effort.base.BaseAutomationPage;


public class ExtentTestManager extends BaseAutomationPage {

	public ExtentTestManager(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();

	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {
		extent.flush();
	}

	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

	public static synchronized void failTest(ExtentTest test, String testName) throws IOException {

		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

		/*
		 * //String testResult = getScreenshot(testName);
		 * test.error(MarkupHelper.createLabel(testResult, ExtentColor.RED)); try {
		 * test.addScreenCaptureFromPath(testResult,testName);
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */


	}

}
