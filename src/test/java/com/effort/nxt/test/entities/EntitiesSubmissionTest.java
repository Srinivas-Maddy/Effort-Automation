package com.effort.nxt.test.entities;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.entities.EntitiesSubmission;
import com.effort.nxt.test.BaseAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EntitiesSubmissionTest extends BaseAutomationTest{
	
	private static final Logger logger = Logger.getLogger(EntitiesSubmissionTest.class.getName());
	private EntitiesSubmission entitiessubmission;
	private static final String EXPECTEDCREATIONSUCCESMSG="Created Succesfully";
	private static final String EXPECTEDMODIFIEDSUCCESMSG="Modified Successfully";
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" , "browser", "headless"})
	public void initEffortLogin(String siteURL ,String browser , String headless) throws Exception {
		logger.info("Starting of initinitEffort Login Method in Entities Process");
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.ENTITIES_SUBMISSION_DRIVER);
		this.goToSite(siteURL, driver);
		this.entitiessubmission = new EntitiesSubmission(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();	
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		logger.info("Ending of initinitEffortLogin Method Entities Process");
	}
	
	@Test(priority = 1, description ="Test Case #1 , Add Entity" , groups= {"sanity"})
	@Description("Adding Entity Details")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1 , Add Entity Details")
	public void addEntity() throws InterruptedException {
		logger.info("Starting of addEntity Method");
		loginPage.ClickonWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		entitiessubmission.clickOnEntityModule();
		entitiessubmission.clickOnAddEntity();
		entitiessubmission.switchToNewWindow();
		entitiessubmission.enterEntityNameDetails(entityDataProp.getProperty("fillentityname"));
		entitiessubmission.enterEntityIDDetails();
		entitiessubmission.enterEntityLat(entityDataProp.getProperty("entitylocationlat"));
		entitiessubmission.enterEntityLog(entityDataProp.getProperty("entitylocationlog"));
		entitiessubmission.SelectEntityEmployee();
		entitiessubmission.enterEntityNumber(entityDataProp.getProperty("entitynumber"));
		entitiessubmission.enterEntityText(entityDataProp.getProperty("entitytext"));
		entitiessubmission.selectForm();
	    entitiessubmission.selectCustomEntity(); 
		entitiessubmission.pickEntityTime();
		entitiessubmission.clickEntityDateTime();
		entitiessubmission.pickEntityDateTime();
		entitiessubmission.enterEntityEmail(entityDataProp.getProperty("entityemail"));
		entitiessubmission.ClickEntityDate();
		entitiessubmission.pickEntityDate();
		entitiessubmission.enterEntityLocationLat(entityDataProp.getProperty("entitylocationlat"));
		entitiessubmission.enterEntityLocationLog(entityDataProp.getProperty("entitylocationlog"));
		entitiessubmission.enterEntityPhone();
		entitiessubmission.enterEntityCurrency(entityDataProp.getProperty("entitycurrency"));
		entitiessubmission.enterEntityURL(entityDataProp.getProperty("entityURL"));
		entitiessubmission.pickEntityAudio();
		entitiessubmission.pickEntityDocument();
		entitiessubmission.pickEntityImage();
	    entitiessubmission.pickEntitySignature();
	    entitiessubmission.pickEntityVideo();
	    entitiessubmission.pickEntityCountry();
	    entitiessubmission.selectEntityCustomer();
	    entitiessubmission.selectEntityMultiPickCustomer();
	    entitiessubmission.clickEntityTerritory();
	    entitiessubmission.pickEntityTerritory(entityDataProp.getProperty("territoryname"));
	    entitiessubmission.pickYesorNo(entityDataProp.getProperty("entityyesorno"));
	   // entitiessubmission.selectCustomerType(entityDataProp.getProperty("entitycustomertype"));
		//entitiessubmission.saveEntity();	
		String actualcreationsuccesmsg = entitiessubmission.saveEntityAndValidateCreatedEntity();
		Assert.assertEquals(actualcreationsuccesmsg, EXPECTEDCREATIONSUCCESMSG);
		logger.info("Ending of addEntity Method");
	}
	
	
	@Test(priority = 2 ,description = "Test Case 2 , Modify Entity" , groups= {"sanity"})
	@Description("Modifing an Entity")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case 2 , Modify Entity")
	public void modifyEntity() throws InterruptedException {
		logger.info("Starting of modifyEntity Method");
		entitiessubmission.ClickonEditBtn();
		entitiessubmission.modifyEntityName(entityDataProp.getProperty("modifiedentityname"));
		entitiessubmission.modifyEntityID();
		//entitiessubmission.saveEntity();
		String actualmodifiedsuccesmsg = entitiessubmission.saveEntityAndValidateModifiedEntity();
		Assert.assertEquals(actualmodifiedsuccesmsg, EXPECTEDMODIFIEDSUCCESMSG);
		
		logger.info("Ending of modifyEntity Method");
		
	}
	
	
	@Test(priority = 3 ,description = "Test Case 3 , Delete Entity" , groups= {"sanity"})
	@Description("Deleting an Entity")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case 3 , Delete Entity")
	public void deleteEntity() throws InterruptedException {
		logger.info("Starting of deleteEntity Method");
		entitiessubmission.selectEntitytoDelete();
		entitiessubmission.ClickonDeleteBtn();	
		logger.info("Ending of deleteEntity Method");	
	}	
	
	
//	@AfterClass(alwaysRun = true)
//	public void logoutEntitites() throws InterruptedException {
//		logger.info("Starting of logoutEntitites Method");
//		
//		entitiessubmission.LogOutEntity();
//		
//		
//		logger.info("Ending of logoutEntitites Method");
//	}
	
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


