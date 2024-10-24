package com.effort.nxt.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

    // Logger for logging information
    private final Logger logger = Logger.getLogger(TestListener.class.getClass());

    // Lists to store the ITestResult objects of passed, failed, and skipped tests in the order they are executed
    private List<ITestResult> passedTestOrder = new ArrayList<>();
    private List<ITestResult> failedTestOrder = new ArrayList<>();
    private List<ITestResult> skippedTestOrder = new ArrayList<>();

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

        // Build the email content with test results
        StringBuilder emailContent = new StringBuilder();
        emailContent.append("Hi Team,").append("\n\n");
        emailContent.append(context.getName()).append(" is Completed").append("\n\n");
        emailContent.append("Test Suite Name : ").append(context.getSuite().getName()).append("\n");
        emailContent.append("Module Name : ").append(context.getName()).append("\n\n");
        emailContent.append("========================").append("\n\n");
        emailContent.append("No of Test Cases Executed : ").append(context.getAllTestMethods().length).append("\n\n");
        emailContent.append("No of Test Cases Passed : ").append(context.getPassedTests().size()).append("\n\n");
        emailContent.append("No of Test Cases Failed : ").append(context.getFailedTests().size()).append("\n\n");
        emailContent.append("No of Test Cases Skipped : ").append(context.getSkippedTests().size()).append("\n\n");
        emailContent.append("========================").append("\n\n");

        emailContent.append("Click here to view the detailed report: ").append("\n");
        emailContent.append("https://spoorswebautomationreport.netlify.app/").append("\n\n");

        // Passed test cases in the execution order
        emailContent.append("Detailed Information Of Passed Test Cases").append("\n");
        emailContent.append("============================================").append("\n");
        for (ITestResult result : passedTestOrder) {
            emailContent.append("Pass : ").append(result.getMethod().getMethodName()).append("\n");
        }

        emailContent.append("\n");
        emailContent.append("Detailed Information Of Failed Test Cases").append("\n");
        emailContent.append("============================================").append("\n");
        for (ITestResult result : failedTestOrder) {
            emailContent.append("Fail : ").append(result.getMethod().getMethodName()).append("\n");

            // Append the exception message for failed tests
            emailContent.append("Exception: ").append(result.getThrowable().getMessage()).append("\n\n");
        }

        emailContent.append("\n");
        emailContent.append("Detailed Information Of Skipped Test Cases").append("\n");
        emailContent.append("============================================").append("\n");
        for (ITestResult result : skippedTestOrder) {
            emailContent.append("Skip : ").append(result.getMethod().getMethodName()).append("\n");

            // Add a placeholder message for skipped tests (these typically don't have exceptions)
            emailContent.append("Reason: Test was skipped.\n\n");
        }

        emailContent.append("Thanks,\n").append("Test Team");

        // Send email with the generated content
        EmailSender.sendEmail("saikiran.devarakonda@spoors.in,srinivas.maddy@spoors.in,sirisha.dande@spoors.in,komal.jidage@spoors.in,venkatesh.avula@spoors.in",
            "Web Automation Sanity Report", emailContent.toString());

        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("========================================================================");
        logger.debug("*** Running test method " + result.getMethod().getMethodName() + " ***");
        logger.info("========================================================================");
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("========================================================================");
        logger.debug("*** Executed " + result.getMethod().getMethodName() + " test successfully ***");
        logger.info("========================================================================");

        // Add the passed test result to the list in execution order
        passedTestOrder.add(result);

        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("========================================================================");
        logger.debug("*** Test execution " + result.getMethod().getMethodName() + " failed ***");
        logger.info("========================================================================");

        // Add the failed test result to the list in execution order
        failedTestOrder.add(result);

        ExtentTest test = ExtentTestManager.getTest();
        test.fail(result.getThrowable());
        try {
            ExtentTestManager.failTest(test, result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        test.log(Status.FAIL, "Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("========================================================================");
        logger.debug("*** Test " + result.getMethod().getMethodName() + " skipped ***");
        logger.info("========================================================================");

        // Add the skipped test result to the list in execution order
        skippedTestOrder.add(result);

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
        String[] command = {"allure", "generate", "allure-results", "--clean"};
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