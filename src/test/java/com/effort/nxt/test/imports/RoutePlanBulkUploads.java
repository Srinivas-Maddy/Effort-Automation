package com.effort.nxt.test.imports;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
import com.effort.imports.ImportPages;
import com.effort.nxt.test.BaseAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class RoutePlanBulkUploads extends BaseAutomationTest{
	
	private static final Logger logger = Logger.getLogger(RoutePlanBulkUploads.class.getName());
	private ImportPages importpage=null;
	private final String EXPECTED_ROUTE_PLAN_IMPORT_STATUS="We've received the sheet you uploaded. An email will be sent to you notifying the status of the update. The following are the files that were uploaded:";
	
	@BeforeClass(alwaysRun = true)
	@Parameters({ "siteURL", "browser" })
	public void initEffortLogin(String siteURL, String browser) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
		this.goToSite(siteURL, driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		this.importpage=new ImportPages(driver);
		this.importpage.clickOnWebApp();
		logger.info("Ending of initEffortLogin Method");
	}	
	
	@Test(priority = 1, description="Route Plan creation Bulk upload", groups = {"sanity"})
	@Description("Import Routes through the import module")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the Route Plan bulk upload through the imports")
	public void routePlanCreation() throws InterruptedException {
		logger.info("Starting of Customer Bulk Upload test case");
		this.importpage.clickOnImports();
		String importSheetPath=System.getProperty("user.dir")+"\\MediaFiles\\Route_Plan_Creation.xls";
		String acutalSatusMsg=this.importpage.importRoutePlan(importProp.getProperty("routePlan"),importSheetPath);
		Assert.assertEquals(acutalSatusMsg, EXPECTED_ROUTE_PLAN_IMPORT_STATUS);
	    logger.info("Ending of Customer Bulk Upload test case");
	}	
	
	@Test(priority = 2, description="Route Plan update through Bulk upload", groups = {"sanity"})
	@Description("Import Route plan update through import module")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the Route Plan updation through the imports")
	public void routePlanUpdation() throws InterruptedException {
		logger.info("Starting of Customer Bulk Upload test case");
		this.importpage.clickOnImports();
		String importSheetPath=System.getProperty("user.dir")+"\\MediaFiles\\Route_Plan_Updation.xls";
		String acutalSatusMsg=this.importpage.importRoutePlanUpdate(importProp.getProperty("routePlan"),importSheetPath);
		Assert.assertEquals(acutalSatusMsg, EXPECTED_ROUTE_PLAN_IMPORT_STATUS);
	    logger.info("Ending of Customer Bulk Upload test case");
	}	
	
	@Test(priority = 3, description="Replace the Route Plan through Bulk upload", groups = {"sanity"})
	@Description("Import Route plan replace through import module")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the Route Plan replace through the imports")
	public void routePlanReplace() throws InterruptedException {
		logger.info("Starting of Customer Bulk Upload test case");
		this.importpage.clickOnImports();
		String importSheetPath=System.getProperty("user.dir")+"\\MediaFiles\\Route_Plan_Creation_Replace.xls";
		String acutalSatusMsg=this.importpage.importRoutePlanReplace(importProp.getProperty("routePlan"),importSheetPath);
		Assert.assertEquals(acutalSatusMsg, EXPECTED_ROUTE_PLAN_IMPORT_STATUS);
	    logger.info("Ending of Customer Bulk Upload test case");
	}	
	
	
	
	@AfterClass(alwaysRun = true)
	public void LogOutImports() {
		logger.info("Starting of LogOutCustomer Method");
		this.importpage.logOut();
		logger.info("Ending of LogOutCustomer Method");

	}

	

}
