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
import com.effort.works.WorkProcessCreation;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class WorkProcessCreationTest extends BaseAutomationTest{
	
	private static final Logger logger=Logger.getLogger(WorkProcessCreationTest.class.getName());
    private WorkProcessCreation processCreation;
	
	//Before class test case was execute once class loaded in the jvm
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL","browser"})
	public void initEffortLogin(String siteUrl,String browser) throws Exception {
		logger.info("starting of initEfforrt Login Method in work creation process");
		this.driver=this.getWebDriver(browser, WebDriversEnum.WORK_PROCESS_CREATION_DRIVER);
		this.goToSite(siteUrl, driver);
		this.processCreation=new WorkProcessCreation(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		this.processCreation.clickOnConfigurator();
		logger.info("Ending of initEffortLogin method in Work Creation process");			
	}

	
	@Test(priority = 1, description="Creating the work spec in configurator", groups = {"sanity"})
	@Description("Test Case #2, Creating the work spec")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2, Creating work Spec")
	public void workSpecCreation() throws InterruptedException {
		
		logger.info("Starting of the workSpecCreation method");
		logger.info("Click on the Process Option Menu bar and creating the process");
		processCreation.clickOnProcess();
		processCreation.clickOnActionProcess();
		processCreation.clickOnCreateProcess();
		processCreation.clickOnCreateMyOwnProcess();
		processCreation.workProcessTitle(testDataProp.getProperty("workTitleName"));
		processCreation.workProcessDiscription(testDataProp.getProperty("description"));
		processCreation.clickOnNextBtn();
		processCreation.clickOnAddFieldBtn();
		processCreation.clickOnFirstAddedField();
		processCreation.addUserDefinedFields();
		processCreation.selectActionForms();
		processCreation.clickNextCloneFieldData();
		processCreation.clickNextManageFlow();
		processCreation.clickSkipAutoAllocation();
		processCreation.clickNextSetting();
		processCreation.clickOtherSetting();
		
	}
	
	@Test(priority = 2, description="Validating Created Process Spec", groups = {"sanity"} )
	@Description("Test Case #2, Validate Created Process")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2, Validate Process")
	public void validationWorkSpec() {
		logger.info("Starting of validateCreateProcess method");
		String expectedWorkSpecName=processCreation.WorkSpecName+" Process Activities";
		String actualWorkSpecName=processCreation.getWorkProcessName();
		Assert.assertEquals(actualWorkSpecName, expectedWorkSpecName);
		logger.info("Ending of validateCreateProcess method");
	}
	
	
	@Test(priority = 3, description="Modifying the Work Spec", groups = {"sanity"} )
	@Description("Test Case #3, Modifying work spec")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3, Modifying the Process")
	public void modificationWorkSpec() {
		logger.info("Starting of modificationWorkSpec method");
		this.processCreation.ModifyWorkFields();
		logger.info("Ending of modificationWorkSpec method");

	}
	
	
	@Test(priority = 4, description="Withdraw Work Spec", groups = {"sanity"} )
	@Description("Test Case #4, Withdrawn work spec")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, Withdrawn Process")
	public void withDrawWorkSpec() {
		logger.info("Starting of modificationWorkSpec method");
		this.processCreation.withDrawWorkSpec();
		logger.info("Ending of modificationWorkSpec method");

	}
	
	
	@AfterClass(alwaysRun = true)
	public void logOutForm() throws InterruptedException {
		logger.info("Starting of Log-out Method");
		this.processCreation.logOut();
	
		logger.info("Ending of log-out Method");
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
