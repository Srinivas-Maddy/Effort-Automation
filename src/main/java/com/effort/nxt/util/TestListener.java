package com.effort.nxt.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.effort.base.BaseAutomationPage;

public class TestListener  implements ITestListener {
	

	
	private final Logger logger = Logger.getLogger(TestListener.class.getClass());

	public void onStart(ITestContext context) {
		logger.info("========================================================================");
		logger.debug("*** Test Suite " + context.getName() + " started ***");
		logger.info("========================================================================");
	}

	public void onFinish(ITestContext context) {
		logger.info("========================================================================");
		logger.debug(("*** Test Suite " + context.getName() + " ending ***"));
		logger.info("========================================================================");
		
		
        // Set email content with test results
        StringBuilder emailContent = new StringBuilder();
        emailContent.append("Hi Team,").append("\n\n");
        emailContent.append("Sanity Checklist for ").append(context.getName()).append(" is Completed").append("\n\n");
        emailContent.append("Test Suite Name :").append(context.getSuite().getName()).append("\n");
        emailContent.append("Module Name :").append(context.getName()).append("\n\n");
        emailContent.append("========================").append("\n\n");
        emailContent.append("No of Test Cases Executed : ").append(context.getAllTestMethods().length).append("\n\n");
        emailContent.append("No of Test Cases Passed : ").append(context.getPassedTests().size()).append("\n\n");
        emailContent.append("No of Test Cases Failed : ").append(context.getFailedTests().size()).append("\n\n");
        emailContent.append("No of Test Cases Skipped : ").append(context.getSkippedTests().size()).append("\n\n\n");
        emailContent.append("========================").append("\n\n");
        
        emailContent.append("Detailed Informatation Of Passed Test Cases").append("\n");
        emailContent.append("============================================").append("\n");
        for (ITestResult result : context.getPassedTests().getAllResults()) {
            emailContent.append("Test Passed: ").append(result.getName()).append("\n");
        }
        
        emailContent.append("\n");
        emailContent.append("Detailed Informatation Of Failed Test Cases").append("\n");
        emailContent.append("============================================").append("\n");
        
        for (ITestResult result : context.getFailedTests().getAllResults()) {
            emailContent.append("Test Failed: ").append(result.getName()).append("\n\n");
            emailContent.append("Exception: ").append(result.getThrowable().getMessage()).append("\n\n");
        }

        emailContent.append("Thanks,\n").append("Test Team");	

		EmailSender.sendEmail("test_team@spoors.in", "Web Automation Sanity Report", emailContent.toString());

		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		logger.info("========================================================================");
		logger.debug(("*** Running test method " + result.getMethod().getMethodName() + "***"));
		logger.info("========================================================================");
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("========================================================================");
		logger.debug("*** Executed " + result.getMethod().getMethodName() + " test successfully***");
		logger.info("========================================================================");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		logger.info("========================================================================");
		logger.debug("*** Test execution " + result.getMethod().getMethodName() + " failed***");
		logger.info("========================================================================");

		ExtentTest test = ExtentTestManager.getTest();
		test.fail(result.getThrowable());
			try {
				ExtentTestManager.failTest(test, result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		test.log(Status.FAIL,"Test Failed");
	
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("========================================================================");
		logger.debug("*** Test " + result.getMethod().getMethodName() + " skipped***");
		logger.info("========================================================================");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.info("========================================================================");
		logger.debug("*** Test failed but within percentage % " + result.getMethod().getMethodName());
		logger.info("========================================================================");
	}
}
