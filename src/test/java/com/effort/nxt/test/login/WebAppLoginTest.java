package com.effort.nxt.test.login;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
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
	private String currentMethodName =null;

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
	@Parameters({ "siteURL", "browser", "headless" , "userName", "password"})
	@Story("Web App login")
	public void WelcomScreen(String siteURL, String browser, String headless,String userName, String password) {
		logger.info("Starting of logIn method");
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();

		LoginToApplication(userName, password);

		logger.info("Ending of logIn method");
	}

	@Test(priority = 2, description = " Test Case #2 , Validating Web App Page", groups = {"sanity"})
	@Description("Test Case #2, Click on WebApp")
	@Severity(SeverityLevel.BLOCKER)
	@Parameters({ "siteURL", "browser", "headless" , "userName", "password"})
	@Story("Web App login")
	public void WebAppHomeScreen(String siteURL, String browser, String headless,String userName, String password){
  
		logger.info("Starting of clickOnWebApp method");

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();

		LoginToApplication(userName, password);
		login.clickOnWebApp();
		
		logger.info("Ending of clickOnWebApp method");

	}
	

	@Test(priority = 3, description = " Test Case #3 , Validating AppBuilder Page", groups = {"sanity"})
	@Description("Test Case #3, Click on WebApp")
	@Severity(SeverityLevel.BLOCKER)
	@Parameters({ "siteURL", "browser", "headless" , "userName", "password"})
	@Story("Web App login")
	public void AppBuilderHomeScreen(String siteURL, String browser, String headless,String userName, String password){
		logger.info("Starting of clickOnWebApp method");
		
		currentTestMethodName = Thread.currentThread().getStackTrace()[0].getMethodName();
		LoginToApplication(userName, password);
		login.clickOnAppBuilder();
		
		logger.info("Ending of clickOnWebApp method");

	}
	

	@Test(priority = 4, description = " Test Case #4 , Validating Report studio Page", groups = {"sanity"})
	@Description("Test Case #4, Click on Report Studio")
	@Severity(SeverityLevel.BLOCKER)
	@Parameters({ "siteURL", "browser", "headless" , "userName", "password"})
	@Story("Web App login")
	public void ReportStudioHomeScreen(String siteURL, String browser, String headless,String userName, String password){
		logger.info("Starting of clickOnWebApp method");
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
		currentTestMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LoginToApplication(userName, password);
		login.clickOnReportStudio();
		
		logger.info("Ending of clickOnWebApp method");
	}
	

	@Test(priority = 5, description = " Test Case #5 , Click on App Builder", groups = {"sanity"})
	@Description("Test Case #5, Click on WebApp")
	@Severity(SeverityLevel.BLOCKER)
	@Parameters({ "siteURL", "browser", "headless" , "userName", "password"})
	@Story("Web App login")
	public void InviteEmployeeScreen(String siteURL, String browser, String headless,String userName, String password){
		logger.info("Starting of clickOnWebApp method");
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
		
		LoginToApplication(userName, password);
		login.inviteEmp("Srinivas", "Maddy Inv 01");
		
		logger.info("Ending of clickOnWebApp method");
	}
	

	@Test(priority = 6, description = " Test Case #6 , Invalid LogIn Details", groups = {"NA"})
	@Description("Test Case #6, Invalid Username and password")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Web App login")
	public void invalidCreditionals(){
		logger.info("Starting of invalidCreditionals method");
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();

		login.enterUserName(testDataProp.getProperty("name"));
		login.clickOnPassword("Test@123");
		login.clickOnLoginButton();	
		String actualError=login.getErrorMessage();
		Assert.assertEquals(actualError, expectedInvalidLoginMessage);
		logger.info("Ending of invalidCreditionals method");

	}
  
	@AfterMethod (groups = {"sanity"})
	public void logout() {
		logger.info("Starting of logout method");
		
		logger.debug(currentMethodName);
		if (!currentMethodName.equals("invalidCreditionals")) {
		loginPage.logOut();
		
		}
	}


	@AfterMethod(alwaysRun = true)
	public void quitDriver() {
		logger.info("Starting of quitDriver Method");
		
		try {

			if (this.driver != null) {
				Thread.sleep(5000);
		       	driver.quit();
	       
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	
		logger.info("Ending of quitDriver Method");

	}
}