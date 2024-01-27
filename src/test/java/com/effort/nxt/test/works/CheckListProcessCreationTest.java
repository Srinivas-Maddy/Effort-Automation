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
	@Parameters({"siteURL","browser", "headless","userName","password"})
	public void initEffortLogin(String siteUrl,String browser, String headless, String userName, String passWord) throws Exception {
		logger.info("starting of initEfforrt Login Method in work creation process");
		
		this.driver=this.getWebDriver(browser, headless, WebDriversEnum.WORK_PROCESS_CREATION_DRIVER);
		this.goToSite(siteUrl, driver);
		this.checkListProcessCreation=new CheckListProcessCeationPage(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(userName);
		this.loginPage.clickOnPassword(passWord);
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(userName, passWord);
		this.checkListProcessCreation.clickOnAppBuilder();
		
		logger.info("Ending of initEffortLogin method in Work Creation process");			
	}
	

	@Test(priority = 1, description="Creating the checklist work spec in app builder", groups = {"sanity"})
	@Description("Test Case #1, Creating the checklist process work spec")
	@Severity(SeverityLevel.BLOCKER)
	@Story("CHECK-LIST PROCESS")
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
	
	
	@Test(priority = 2, description="Modifying the Spec and add new fields", groups = {"sanity"} )
	@Description("Test Case #2, Modifying work spec and new field")
	@Severity(SeverityLevel.BLOCKER)
	@Story("CHECK-LIST PROCESS")
	public void modifyCheckListProcess() {
		logger.info("Starting of modifyCheckListProcess");
		
		this.checkListProcessCreation.modifyWorkFields();
		
		logger.info("Ending of modifyCheckListProcess");

	}
	
	@Test(priority = 3, description="Withdrawing the checklist process spec", groups = {"sanity"} )
	@Description("Test Case #3, Deleting the work spec permenetly")
	@Severity(SeverityLevel.BLOCKER)
	@Story("CHECK-LIST PROCESS")
	public void withDrawChecklistProcess() {
		logger.info("Starting of withDrawChecklistProcess Method");
		
		this.checkListProcessCreation.withDrawWorkSpec();
		
		logger.info("Ending of withDrawChecklistProcess");
	}
	
	@Test(priority = 4, description="Creating Checklist process in home screen", groups = {"sanity"} )
	@Description("Test Case #4, Creating checklist process in home screen")
	@Severity(SeverityLevel.BLOCKER)
	@Story("CHECK-LIST PROCESS")
	public void createCheckListProcessInHome() {
		logger.info("Starting of createCheckListProcessInHome Method");
		
		this.checkListProcessCreation.specCreationInHome();
		this.checkListProcessCreation.enterProcessTitle(expectedAssertionsProp.getProperty("checklistprocess.worktitle"), expectedAssertionsProp.getProperty("checklistprocess.description"));
		this.checkListProcessCreation.addWorkField();
		this.checkListProcessCreation.manageForms();
		this.checkListProcessCreation.manageActivities();
		this.checkListProcessCreation.cloneFieldsData();
		this.checkListProcessCreation.manageFlow();
		this.checkListProcessCreation.defineAutoAllocation();
		this.checkListProcessCreation.settings();
		
		logger.info("Ending of createCheckListProcessInHome Method");

	}
	
	@Test(priority = 5, description="Withdrawing the checklist process spec In Home screen", groups = {"sanity"} )
	@Description("Test Case #3, Deleting the work spec permenetly in home screen")
	@Severity(SeverityLevel.BLOCKER)
	@Story("CHECK-LIST PROCESS")
	public void withDrawnSpecInHomeScreen() {
		logger.info("Starting of withDrawnSpecInHomeScreen method");
		
		this.checkListProcessCreation.withDrawWorkSpec();
		
		logger.info("Ennding of withDrawnSpecInHomeScreen method");

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
