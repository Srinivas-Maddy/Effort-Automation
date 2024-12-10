package com.effort.nxt.util;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.log4testng.Logger;
import com.aventstack.extentreports.Status;
import com.effort.nxt.test.BaseAutomationTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class TestListener implements ITestListener {

	private final Logger logger = Logger.getLogger(TestListener.class.getClass());

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	// iTestResult: An object representing the result of a test method's execution
	// (from TestNG framework).
	// iTestResult.getMethod(): Retrieves the method object representing the current
	// test method.
	// .getConstructorOrMethod(): Retrieves either the constructor or the method
	// metadata.
	// .getName(): Gets the name of the method.
	// Result: Returns the method name as a String

	public void saveScreenshotPNG(String screenshotType, WebDriver driver) {

		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		Allure.getLifecycle().addAttachment(
				screenshotType + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")),
				"image/png", "png", screenshot);
	}

	// Text attachments for Allure
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("========================================================================");
		logger.debug("*** Test Suite " + context.getName() + " started ***");
		logger.info("========================================================================");
	}

	@Override

	public void onFinish(ITestContext context) {
		logger.info("========================================================================");
		logger.debug(("*** Test Suite " + context.getName() + " ending ***"));
		logger.info("========================================================================");

		// Set email content with test results
		StringBuilder emailContent = new StringBuilder();
		emailContent.append("Hi Team,").append("\n\n");
		emailContent.append(context.getName()).append(" is Completed").append("\n\n");
		emailContent.append("Test Suite Name :").append(context.getSuite().getName()).append("\n");
		emailContent.append("Module Name :").append(context.getName()).append("\n\n");
		emailContent.append("========================").append("\n\n");
		emailContent.append("No of Test Cases Executed : ").append(context.getAllTestMethods().length).append("\n\n");
		emailContent.append("No of Test Cases Passed : ").append(context.getPassedTests().size()).append("\n\n");
		emailContent.append("No of Test Cases Failed : ").append(context.getFailedTests().size()).append("\n\n");
		emailContent.append("No of Test Cases Skipped : ").append(context.getSkippedTests().size()).append("\n\n");
		emailContent.append("========================").append("\n\n");

		emailContent.append("Click here to view the detailed report.").append("\n");
		emailContent.append("https://spoorswebautomationreport.netlify.app/").append("\n\n");

		// Add detailed information for Passed Test Cases
		emailContent.append("Detailed Information Of Passed Test Cases").append("\n");
		emailContent.append("============================================").append("\n");

		List<ITestResult> passedTests = new ArrayList<>(context.getPassedTests().getAllResults());
		passedTests.sort(Comparator.comparingLong(ITestResult::getStartMillis));

		for (ITestResult result : passedTests) {
			emailContent.append("Pass : ").append(result.getName()).append("\n");
		}

		// Add detailed information for Failed Test Cases
		emailContent.append("\nDetailed Information Of Failed Test Cases").append("\n");
		emailContent.append("============================================").append("\n");

		List<ITestResult> failedTests = new ArrayList<>(context.getFailedTests().getAllResults());
		failedTests.sort(Comparator.comparingLong(ITestResult::getStartMillis));

		for (ITestResult result : failedTests) {
			emailContent.append("Fail : ").append(result.getName()).append("\n\n");
			emailContent.append("Exception: ").append(result.getThrowable().getMessage()).append("\n\n");
		}

		// Add detailed information for Skipped Test Cases
		emailContent.append("Detailed Information Of Skipped Test Cases").append("\n");
		emailContent.append("============================================").append("\n");

		List<ITestResult> skippedTests = new ArrayList<>(context.getSkippedTests().getAllResults());
		skippedTests.sort(Comparator.comparingLong(ITestResult::getStartMillis));

		for (ITestResult result : skippedTests) {
			emailContent.append("Skip : ").append(result.getName()).append("\n\n");
		}

		emailContent.append("Thanks,\n").append("Test Team");

		//saikiran.devarakonda@spoors.in,srinivas.maddy@spoors.in,sirisha.dande@spoors.in,komal.jidage@spoors.in,venkatesh.avula@spoors.in
		EmailSender.sendEmail(
				"saikiran.devarakonda@spoors.in,srinivas.maddy@spoors.in,sirisha.dande@spoors.in,komal.jidage@spoors.in,venkatesh.avula@spoors.in",
				"Web Automation Sanity Report", emailContent.toString());

		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("========================================================================");
		logger.debug(("*** Running test method " + result.getMethod().getMethodName() + "***"));
		logger.info("========================================================================");
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("========================================================================");
		logger.debug("*** Executed " + result.getMethod().getMethodName() + " test successfully***");
		logger.info("========================================================================");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		logger.info("========================================================================");
		logger.debug("*** Test execution " + iTestResult.getMethod().getMethodName() + " failed***");
		logger.info("========================================================================");

		Object testClass = iTestResult.getInstance();
		WebDriver driver = ((BaseAutomationTest) testClass).getChildWebDriver();

		if (driver != null) {
			logger.info(String.format("Screenshot captured for test case: %s", getTestMethodName(iTestResult)));

			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
						.equals("complete"));
				saveScreenshotPNG("Test_Failure_Screenshot_", driver);

			} catch (Exception e) {
				logger.error("Error while capturing screenshot: ", e);
			}

		}
	}

	/*
	 * public void onTestFailure2(ITestResult result) { logger.info(
	 * "========================================================================");
	 * logger.debug("*** Test execution " + result.getMethod().getMethodName() +
	 * " failed***"); logger.info(
	 * "========================================================================");
	 * 
	 * ExtentTest test = ExtentTestManager.getTest();
	 * test.fail(result.getThrowable()); try { ExtentTestManager.failTest(test,
	 * result.getMethod().getMethodName()); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * test.log(Status.FAIL, "Test Failed"); }
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("========================================================================");
		logger.debug("*** Test " + result.getMethod().getMethodName() + " skipped***");
		logger.info("========================================================================");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.info("========================================================================");
		logger.debug("*** Test failed but within percentage % " + result.getMethod().getMethodName());
		logger.info("========================================================================");
	}

	@AfterSuite
	public void generateAllureReport() {
		String[] command = { "allure", "generate", "allure-results", "--clean" };
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		AtomicReference<Process> process = new AtomicReference<>();

		try {
			process.set(processBuilder.start());

			Thread timeoutThread = new Thread(() -> {
				try {
					Thread.sleep(5000); // 5 seconds timeout
					if (process.get().isAlive()) {
						process.get().destroy(); // Kill the process if it's still running
						throw new RuntimeException("Could not generate Allure report: Timeout after 5 seconds");
					}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			});
			timeoutThread.start();

			int exitCode = process.get().waitFor();
			timeoutThread.interrupt(); // Interrupt timeout thread if process finishes on time

			if (exitCode != 0) {
				throw new RuntimeException("Could not generate Allure report");
			}

			System.out.println("Allure report successfully generated");

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (process.get() != null) {
				process.get().destroy();
			}
		}
	}
}
