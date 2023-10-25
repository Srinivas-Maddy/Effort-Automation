package com.effort.nxt.test.login;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.common.WebDriversEnum;
import com.effort.login.WebAppLogins;
import com.effort.nxt.test.BaseAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class WebAppLoginTest  extends BaseAutomationTest{
	private static final Logger logger = Logger.getLogger(WebAppLoginTest.class.getName());
	private String expectedInvalidLoginMessage="Invalid Email/Password.";
	private WebAppLogins login=null;
	private String currentTestMethodName =null;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "siteURL", "browser", "headless" })
	public void initEffortLogin(String siteURL, String browser, String headless) throws Exception {
		logger.info("Starting of initEffortLogin method in LoginTest");
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.WEB_APP_LOGIN_DRIVER);
		this.goToSite(siteURL, driver);
		this.login = new WebAppLogins(this.driver);
		logger.info("Ending of initEffortLogin method in LoginTest");
	}

	@Test(priority = 1, description = " Test Case #1 , LogIn", groups = {"sanity"})
	@Description("Test Case #1, Valid Username and password")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Web App login")
	public void WelcomScreen() {
		logger.info("Starting of logIn method");
		currentTestMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		login.enterUserName(testDataProp.getProperty("name"));
		login.clickOnPassword(testDataProp.getProperty("password1"));
		login.clickOnLoginButton();
		logger.info("Ending of logIn method");
	}

	@Test(priority = 2, description = " Test Case #3 , Validating Web App Page", groups = {"sanity"})
	@Description("Test Case #2, Click on WebApp")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Web App login")
	public void WebAppHomeScree(){
  
		logger.info("Starting of clickOnWebApp method");
		currentTestMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		login.enterUserName(testDataProp.getProperty("name"));
		login.clickOnPassword(testDataProp.getProperty("password1"));
		login.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		login.clickOnWebApp();
		logger.info("Ending of clickOnWebApp method");

	}
	

	@Test(priority = 3, description = " Test Case #3 , Validating AppBuilder Page", groups = {"sanity"})
	@Description("Test Case #2, Click on WebApp")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Web App login")
	public void AppBuilderHomeScreen(){
		logger.info("Starting of clickOnWebApp method");
		currentTestMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		login.enterUserName(testDataProp.getProperty("name"));
		login.clickOnPassword(testDataProp.getProperty("password1"));
		login.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		login.clickOnAppBuilder();
		logger.info("Ending of clickOnWebApp method");

	}
	

	@Test(priority = 4, description = " Test Case #3 , Validating Report studio Page", groups = {"sanity"})
	@Description("Test Case #2, Click on Report Studio")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Web App login")
	public void ReportStudioHomeScreen(){
		logger.info("Starting of clickOnWebApp method");
		currentTestMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		login.enterUserName(testDataProp.getProperty("name"));
		login.clickOnPassword(testDataProp.getProperty("password1"));
		login.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		login.clickOnReportStudio();
		logger.info("Ending of clickOnWebApp method");
	}
	

	@Test(priority = 5, description = " Test Case #3 , Click on App Builder", groups = {"sanity"})
	@Description("Test Case #2, Click on WebApp")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Web App login")
	public void InviteEmployeeScreen(){
		logger.info("Starting of clickOnWebApp method");
		currentTestMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		login.enterUserName(testDataProp.getProperty("name"));
		login.clickOnPassword(testDataProp.getProperty("password1"));
		login.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		login.inviteEmp("Srinivas", "Maddy Inv 01");
		logger.info("Ending of clickOnWebApp method");
	}
	

	@Test(priority = 6, description = " Test Case #2 , Invalid LogIn Details")
	@Description("Test Case #2, Invalid Username and password")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Web App login")
	public void invalidCreditionals(){
		logger.info("Starting of invalidCreditionals method");
		currentTestMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		login.enterUserName(testDataProp.getProperty("name"));
		login.clickOnPassword("Test@123");
		login.clickOnLoginButton();	
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		String actualError=login.getErrorMessage();
		Assert.assertEquals(actualError, expectedInvalidLoginMessage);
		logger.info("Ending of invalidCreditionals method");

	}
  
	@AfterMethod (groups = {"sanity"})
	public void logout() {
		logger.info("Starting of logout method");
		
		login.logOut(); 
		if (currentTestMethodName.equals("invalidCreditionals")) {
			driver.quit();
			return;
		}
		
	}


}
