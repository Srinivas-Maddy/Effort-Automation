package com.effort.nxt.test.works;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
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
		@Parameters({"siteURL","browser", "headless"})
		public void initEffortLogin(String siteUrl,String browser, String headless) throws Exception {
			logger.info("starting of initEfforrt Login Method in work creation process");
			this.driver=this.getWebDriver(browser, headless, WebDriversEnum.ADD_WORK_PROCESS_DRIVER);
			this.goToSite(siteUrl, driver);
			this.addWork=new AddWorkProcess(driver);
			this.loginPage = new LoginPage(driver);
			this.loginPage.enterUserName(testDataProp.getProperty("name"));
			this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
			this.loginPage.clickOnLoginButton();
			loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
				
			logger.info("Ending of initEffortLogin method in Work Creation process");			
		}
		
		
		@Test(priority = 1, description="Add the work in the web app", groups = {"sanity"})
		@Description("Test Case #1, Assigning the work")
		@Severity(SeverityLevel.BLOCKER)
		@Story("Test Case #1, Assign the work to the user")
		public void AddWork() throws InterruptedException {			
			logger.info("Starting of the AddWork method");
			
			loginPage.ClickonWebApp();
			loginPage.clickOnCancelButtonOnWebAppHomeScreen();
			this.addWork.clickOnProcessModule();
			this.addWork.clickOnWorkName();
			this.addWork.clickOnAddWorkBtn();
			this.addWork.enterWorkName("Test work 001");
			this.addWork.clickOnWorkEndDate();
			this.addWork.clickOnCurrentDateTime();
			//this.addWork.pickWorkEndDate();
			this.addWork.assignEmplpoyee("Srinivas Maddy");
			this.addWork.clickOnSave();
			
			logger.info("Ending the Addwork Method");					
		}
		


		@AfterClass(alwaysRun = true)
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
