package com.effort.nxt.test.entities;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.entities.EntitiesProcess;
import com.effort.nxt.test.BaseAutomationTest;
import com.effort.nxt.test.works.ActionProcessTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EntitiesProcessTest extends BaseAutomationTest {
	
	private static final Logger logger = Logger.getLogger(EntitiesProcessTest.class.getName());
	private EntitiesProcess entitiesprocess;
	
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" , "browser"})
	public void initEffortLogin(String siteURL ,String browser ) throws Exception {
		logger.info("Starting of initinitEffort Login Method in Entities Process");
		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
		this.goToSite(siteURL, driver);
		this.entitiesprocess = new EntitiesProcess(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		this.entitiesprocess.clickonAppBuilder();
		logger.info("Ending of initinitEffortLogin Method Entities Process");
	}
	
	@Test(priority= 1,description="Test Case #1 ,Entities Spec Creation" , groups= {"sanity"})
	@Description("Test Case #1 , Creating Entities Spec")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1 , Create Entities Spec Process")
	public void entitySpecCreation() throws InterruptedException {
		logger.info("Starting of entitySpecCreation Method");
		entitiesprocess.clickonEntities();
		entitiesprocess.clickonCreateEntity();
		entitiesprocess.enterEntityName(entityDataProp.getProperty("entityname"));
		entitiesprocess.enterEntityDescription(entityDataProp.getProperty("entitydescription"));
		entitiesprocess.selectAllFields();
		entitiesprocess.clickonNextButton();
		entitiesprocess.selectEntityCheckboxs();
		entitiesprocess.clickOnSkipButton();
		entitiesprocess.selectCheckinActivitytoPerform();	
		entitiesprocess.selectWebandMobileCheckbox();		
		logger.info("Ending of entitySpecCreation Method");
	}
	
	@Test(priority= 2,description="Test Case #2 ,Entities Spec Modification" , groups= {"sanity"})
	@Description("Test Case #2 , Modify Entities Spec")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2 , Modify Entities Spec Process")
	public void entitySpecModification() {
		logger.info("Starting of entitySpecModification Method");
		entitiesprocess.clickOnModifyEntitySpec();
		entitiesprocess.enterModifiedName(entityDataProp.getProperty("specmodifiedname"));	
		entitiesprocess.enterModifiedDescription(entityDataProp.getProperty("specmodifieddescription"));
		logger.info("Ending of entitySpecModification Method");
	}
	
	@Test(priority= 3,description="Test Case #3 ,Entities Spec Deletion" , groups= {"sanity"})
	@Description("Test Case #3 , Delete Entities Spec")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3 , Delete Entities Spec Process")
	public void entitySpecDeletion() throws InterruptedException {
		logger.info("Starting of entitySpecDeletion Method");
		entitiesprocess.deleteEntitySpec();
		logger.info("Starting of entitySpecDeletion Method");
	}
	
	@AfterClass(alwaysRun = true)
	public void logoutEntitites() {
		logger.info("Starting of logoutEntitites Method");		
		entitiesprocess.logOutEntitites();
		logger.info("Ending of logoutEntitites Method");
	}
	

	

}
