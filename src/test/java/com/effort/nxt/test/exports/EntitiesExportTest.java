package com.effort.nxt.test.exports;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.exports.EntitiesExportPage;
import com.effort.nxt.test.BaseAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EntitiesExportTest extends BaseAutomationTest{
	
	private static final Logger logger = Logger.getLogger(EntitiesExportTest.class.getName());

	private EntitiesExportPage entitiesexportpage=null;
	//private EntitiesExportPage entitiesExpt=null;

	private String EXPORT_SELECTED_STUTUS="Data download process is successful.";
	private String EXPORT_ALL_STATUS="Click here to see the status of report";
	

	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" ,"browser", "headless"})
	
	public void initEffortLogin(String siteURL , String browser, String headless) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.ENTITIES_EXPORTS_DRIVER);
		this.goToSite(siteURL, driver);
		this.entitiesexportpage = new EntitiesExportPage(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		logger.info("Ending of initEffortLogin Method");
	}
		
		@Test(priority = 1 ,description= "TestCase #1 ,Go to Entities and select Export Selected " , groups= {"sanity"})
		@Description("Download Selected Entities")
		@Severity(SeverityLevel.BLOCKER)
		@Story("Test Case #1 , Downloading Seleceted Entities")
		public void entityExportSelected() throws InterruptedException
		{
			logger.info("Starting of entityExportSelected Method");
			entitiesexportpage.ClickonWebApp();
			loginPage.clickOnCancelButtonOnWebAppHomeScreen();
			entitiesexportpage.clickOnEntityModule();
			//entitiesexportpage.entitySelectionCheckbox();
			entitiesexportpage.selectAllEntityCheckBox();
			String actualSelectedExportStatus=entitiesexportpage.selectEntityExportSelected();	
			Assert.assertEquals(actualSelectedExportStatus, EXPORT_SELECTED_STUTUS);
			logger.info("Ending of entity ExportSelected Method");
		}
		
		@Test(priority = 2 , description = "TestCase #2 , Go to Entities and select Export All ", groups= {"sanity"})
		@Description("Download All Entities using ExportAll")
		@Severity(SeverityLevel.BLOCKER)
		@Story("Test Case #2 ,Downloading all Entities using Export All")
		public void entityExportAll() throws InterruptedException {
			logger.info("Starting of entityExportAll Method");
			entitiesexportpage.clickOnEntityModule();
			String actualExportAllStatus=entitiesexportpage.selectEntityExportAll();	
			Assert.assertEquals(actualExportAllStatus,EXPORT_ALL_STATUS);
			logger.info("Ending of entityExportAll Method");		
		}
		
		@Test(priority = 3 , description = "TestCase #3 , Go to Entities and select Export Filtered ", groups= {"sanity"})
		@Description("Download Filtered Entities")
		@Severity(SeverityLevel.BLOCKER)
		@Story("Test Case #3 ,Downloading Filtered Entities")
		public void entityExportFiltered() throws InterruptedException  {
			logger.info("Starting of entityExportAll Method");
			entitiesexportpage.clickOnEntityModule();
			entitiesexportpage.clickOnFilters(entityDataProp.getProperty("filterentityname"));
			entitiesexportpage.selectEntityExportFiltered();			
			logger.info("Ending of entityExportAll Method");		
		}
		
		@AfterClass(alwaysRun=true)
		public void logOut(){
			logger.info("Starting of Log-out Method");
			this.entitiesexportpage.logOut();
			
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


