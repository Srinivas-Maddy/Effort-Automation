package com.effort.nxt.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Effort NXT ")
@Feature("Login Into EFFORT NXT")

public class LoginTest extends BaseAutomationTest {
	private static final Logger logger = Logger.getLogger(LoginTest.class.getName());

	@BeforeClass(alwaysRun = true)
	@Parameters({ "siteURL", "browser" })
	public void initEffortLogin(String siteURL, String browser) throws Exception {
		logger.info("Starting of initEffortLogin method in LoginTest");
		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
		this.goToSite(siteURL, driver);
		this.loginPage = new LoginPage(this.driver);
		logger.info("Ending of initEffortLogin method in LoginTest");

	}

	@Test(priority = 1, description = " Test Case #1 , LogIn", groups = {"sanity"})
	@Description("Test Case #1, Create Employee")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, Create Employee")
	public void logIn() {
		logger.info("Starting of logIn method");
		loginPage.enterUserName(testDataProp.getProperty("name"));
		loginPage.clickOnPassword(testDataProp.getProperty("password1"));
        loginPage.clickOnLoginButton();
        loginPage.clickOnWebApp();
		logger.info("Ending of logIn method");
	}
	
	@AfterClass (alwaysRun = true)
	public void logout() {
		logger.info("Starting of logout method");
		loginPage.logOut();
	}

	

	
}
