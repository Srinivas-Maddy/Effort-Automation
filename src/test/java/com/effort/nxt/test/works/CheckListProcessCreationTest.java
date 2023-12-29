package com.effort.nxt.test.works;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.nxt.test.BaseAutomationTest;
import com.effort.works.CheckListProcessCeationPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CheckListProcessCreationTest extends BaseAutomationTest{
	
	private static final Logger logger=Logger.getLogger(CheckListProcessCreationTest.class.getName());
	private CheckListProcessCeationPage checkListProcessCreation;
	
	//Before class test case was execute once class loaded in the jvm
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL","browser", "headless"})
	public void initEffortLogin(String siteUrl,String browser, String headless) throws Exception {
		logger.info("starting of initEfforrt Login Method in work creation process");
		
		this.driver=this.getWebDriver(browser, headless, WebDriversEnum.WORK_PROCESS_CREATION_DRIVER);
		this.goToSite(siteUrl, driver);
		this.checkListProcessCreation=new CheckListProcessCeationPage(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		this.checkListProcessCreation.clickOnAppBuilder();
		
		logger.info("Ending of initEffortLogin method in Work Creation process");			
	}
	

	@Test(priority = 1, description="Creating the checklist work spec in app builder", groups = {"sanity"})
	@Description("Test Case #1, Creating the checklist process work spec")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2, Creating checklist process work Spec")
	public void createCheckListProcessSpec() {
		logger.info("Srarting of createCheckListProcessSpec method");
		
		this.checkListProcessCreation.clickOnWorkProcess();
		this.checkListProcessCreation.clickOnChecklistProcess();
		this.checkListProcessCreation.clickOnCreateProcess();
		String specName=this.checkListProcessCreation.enterProcessTitle(expectedAssertionsProp.getProperty("checklistprocess.worktitle"), expectedAssertionsProp.getProperty("checklistprocess.description"));
		this.checkListProcessCreation.addWorkField();
		this.checkListProcessCreation.manageForms();
		this.checkListProcessCreation.manageActivities();
		this.checkListProcessCreation.cloneFieldsData();
		this.checkListProcessCreation.manageFlow();
		this.checkListProcessCreation.defineAutoAllocation();
		String message=this.checkListProcessCreation.settings();
		Assert.assertEquals(message, specName+" "+expectedAssertionsProp.getProperty("checklistprocess.spec.SucessMes"));
		
		logger.info("Ending of createCheckListProcessSpec method");
		
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
