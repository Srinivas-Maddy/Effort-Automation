package com.effort.nxt.test.works;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
import com.effort.nxt.test.BaseAutomationTest;
import com.effort.works.ActionProcess;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ActionProcessTest extends BaseAutomationTest {

	private static final Logger logger = Logger.getLogger(ActionProcessTest.class.getName());
	private ActionProcess actionProcess;

	@BeforeClass (alwaysRun = true)
	@Parameters({ "siteURL", "browser" })
	public void initEffortLogin(String siteURL, String browser) throws Exception {
		logger.info("Starting of initEffortLogin method in creationOfCustomerTest");

		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);

		this.goToSite(siteURL, driver);

		this.actionProcess = new ActionProcess(driver);
		this.loginPage = new LoginPage(driver);

		logger.info("Ending of initEffortLogin method in creationOfCustomerTest");

	}

	@Test(priority = 1, description = " Test Case #1 , Go to Action Process", groups = {"sanity"})
	@Description("Test Case #1, Go to Action Process")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, Create Action Process")
	public void logIn() {
		logger.info("Starting of logIn method");

		loginPage.enterUserName(testDataProp.getProperty("name"));
		loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		loginPage.clickOnLoginButton();
		actionProcess.clickOnConfigurator();
		// loginPage.clickOnWebApp();

		logger.info("Ending of logIn method");
	}

	@Test(priority = 2, description = " Test Case #1 , Go to Action Process", groups = {"sanity"})
	@Description("Test Case #2, Go to Action Process")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, Create Action Process")
	public void actionProcessCreation() throws InterruptedException {
		logger.info("Starting of actionProcessCreation method");

		actionProcess.clickOnToActionProcess();
		actionProcess.clickOnToActionProcessCard();
		actionProcess.clickOnCreateProcess();
		actionProcess.clickOnMyOwn();
		actionProcess.clickOnProcessName(testDataProp.getProperty("processName"));
		actionProcess.clickOnNext();
		Thread.sleep(5000);
		actionProcess.clickOnNext();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(5000);
		actionProcess.clickOnNext();
		Thread.sleep(3000);
		actionProcess.clickOnAddAction();
		Thread.sleep(3000);
		actionProcess.clickOnAction1(testDataProp.getProperty("startAction"));
		Thread.sleep(3000);
		actionProcess.clickOnSelectForm();
		actionProcess.clickOnForm();
		Thread.sleep(3000);
		actionProcess.clickOnAddAction();
		Thread.sleep(3000);
		actionProcess.clickOnAction2(testDataProp.getProperty("endAction"));
		Thread.sleep(3000);
		actionProcess.clickOnSelectForm();
		Thread.sleep(3000);
		actionProcess.clickOnForm();
		Thread.sleep(3000);
		actionProcess.clickOnNext();
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(3000);
		actionProcess.clickOnNext();
		Thread.sleep(3000);
		actionProcess.clickOnNext();
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(3000);
		actionProcess.clickOnSkipButton();
		Thread.sleep(3000);
		actionProcess.clickOnNext();
		Thread.sleep(3000);
		actionProcess.clickOnNext();
		Thread.sleep(3000);
		
		logger.info("Ending of actionProcessCreation method");
	}

	@Test(priority = 3, description = " Test Case #1 , Verify Created Action Process", groups = {"sanity"})
	@Description("Test Case #3, Verify created Action Process")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3, Verify Action Process")
	public void actionProcessVerification() throws InterruptedException {
		logger.info("Starting of actionProcessVerification method");

		actionProcess.clickOnProfileName();
		actionProcess.clickOnSwitchToWebapp();
		actionProcess.clickOnToActionProcess();
		Thread.sleep(3000);
		actionProcess.clickOnSearchWorks(testDataProp.getProperty("processName"));
		Thread.sleep(3000);
		String workVerify = this.actionProcess.getWorkText();
		Assert.assertEquals(workVerify, expectedAssertionsProp.getProperty("work.verify"));
		Thread.sleep(3000);
	}

	@Test(priority = 4, description = " Test Case #4 , WithDraw Created Action Process", groups = {"sanity"})
	@Description("Test Case #3, Withdraw created Action Process")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3, Verify Action Process")
	public void actionProcessWithdraw() throws InterruptedException {
		logger.info("Starting of actionProcessWithdraw method");
		actionProcess.clickOnProfileName();
		Thread.sleep(3000);
		actionProcess.clickOnToConfigurator();
		Thread.sleep(3000);
		actionProcess.clickOnToActionProcess();
		actionProcess.clickOnToActionProcessCard();
		Thread.sleep(3000);
		actionProcess.clickOnSearchWorks1(testDataProp.getProperty("processName"));
		Thread.sleep(3000);
		actionProcess.clickOnSelectWork();
		Thread.sleep(3000);
		actionProcess.clickOnWithdraw();
		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		Thread.sleep(5000);
		actionProcess.clickOnSearchWorks1(testDataProp.getProperty("processName"));

	}

	

}
