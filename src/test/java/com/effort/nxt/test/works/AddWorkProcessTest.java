package com.effort.nxt.test.works;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.nxt.test.BaseAutomationTest;
import com.effort.works.AddWorkProcess;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AddWorkProcessTest extends BaseAutomationTest{
	
	private static final Logger logger=Logger.getLogger(AddWorkProcessTest.class); 
	private AddWorkProcess addWork;
	
	//Before class test case was execute once class loaded in the jvm
		@BeforeClass(alwaysRun = true)
		@Parameters({"siteURL","browser"})
		public void initEffortLogin(String siteUrl,String browser) throws Exception {
			logger.info("starting of initEfforrt Login Method in work creation process");
			this.driver=this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
			this.goToSite(siteUrl, driver);
			this.addWork=new AddWorkProcess(driver);
			this.loginPage = new LoginPage(driver);
			this.loginPage.enterUserName(testDataProp.getProperty("name"));
			this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
			this.loginPage.clickOnLoginButton();
			this.addWork.clickOnWebApp();
			logger.info("Ending of initEffortLogin method in Work Creation process");			
		}
		
		
		@Test(priority = 1, description="Add the work in the web app", groups = {"sanity"})
		@Description("Test Case #1, Assigning the work")
		@Severity(SeverityLevel.BLOCKER)
		@Story("Test Case #1, Assign the work to the user")
		public void AddWork() {
			
			logger.info("Starting of the AddWork method");
			this.addWork.clickOnProcessModule();
			logger.info("Ending the Addwork Method");
					
		}
		
		@AfterClass(alwaysRun = true)
		public void logOutForm() {
			logger.info("Starting of Log-out Method");
			addWork.logOut();	
			logger.info("Ending of log-out Method");
		}

	

}
