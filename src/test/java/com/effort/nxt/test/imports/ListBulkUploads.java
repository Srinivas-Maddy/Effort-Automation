package com.effort.nxt.test.imports;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.imports.ImportPages;
import com.effort.nxt.test.BaseAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ListBulkUploads extends BaseAutomationTest{
	
	private static final Logger logger = Logger.getLogger(ListBulkUploads.class.getName());
	private ImportPages importpage=null;
	private final String EXPECTED_BULK_IMPORT_STATUS="Processed";
	
	@BeforeClass(alwaysRun = true)
	@Parameters({ "siteURL", "browser" })
	public void initEffortLogin(String siteURL, String browser) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, WebDriversEnum.LIST_BULKUPLOAD);
		this.goToSite(siteURL, driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		this.importpage=new ImportPages(driver);
		
		logger.info("Ending of initEffortLogin Method");
	}	
	
	@Test(priority = 1, description="List Spec Bulk Upload", groups = {"sanity"})
	@Description("List Bulk upload through the import module")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the List bulk upload through the imports")
	public void listImports() throws InterruptedException {
		logger.info("Starting of Customer Bulk Upload test case");
		this.importpage.clickOnWebApp();
		this.importpage.clickOnImports();
		String importSheetPath=System.getProperty("user.dir")+"\\MediaFiles\\List_Template_TestList.xls";
		String actualStatusMsg=this.importpage.importListUpload(importProp.getProperty("listSpecName"),importSheetPath);
		Assert.assertEquals(actualStatusMsg,EXPECTED_BULK_IMPORT_STATUS);
		logger.info("Ending of Customer Bulk Upload test case");

	}	
	
	@AfterClass(alwaysRun = true)
	public void LogOutImports() {
		logger.info("Starting of LogOutCustomer Method");
		this.importpage.logOut();
		logger.info("Ending of LogOutCustomer Method");

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
