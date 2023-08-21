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

public class CustomerBulkUploads extends BaseAutomationTest{
	
	private static final Logger logger = Logger.getLogger(CustomerBulkUploads.class.getName());
	private ImportPages importpage=null;
	private final String EXPECTED_CUSTOMER_BULK_IMPORT_STATUS="Successful";
	private final String EXPECTED_CUSTOMER_BULK_DELETE_STATUS="An Email will be sent after successful Deletion of Customers";
	
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
		this.importpage=new ImportPages(driver);
		this.importpage.clickOnWebApp();
		logger.info("Ending of initEffortLogin Method");
	}	
	
	@Test(priority = 1, description="Customer bulk upload", groups = {"sanity"})
	@Description("Customer bulk upload through bulk upload")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the customer bulk upload")
	public void customerBulkUpload() throws InterruptedException {
		logger.info("Starting of Customer Bulk Upload test case");
		this.importpage.clickOnImports();
		String importSheetPath=System.getProperty("user.dir")+"\\MediaFiles\\Customer_bulk_upload.xls";
		String actualStatusMsg=this.importpage.importCustomers(importProp.getProperty("customerBulkUpload"),importSheetPath);
		Assert.assertEquals(actualStatusMsg,EXPECTED_CUSTOMER_BULK_IMPORT_STATUS);
		logger.info("Ending of Customer Bulk Upload test case");

	}
		
	@Test(priority = 2, description="Customer bulk delete", groups = {"sanity"})
	@Description("Customer bulk delete through bulk upload")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the customer bulk delete")
	public void customerBulkDelete(){
		logger.info("Starting of Customer bulk delete test case");
		this.importpage.clickOnImports();
		String importSheetPath=System.getProperty("user.dir")+"\\MediaFiles\\Customer_Bulk_Delete.xls";
		String actualStatusMsg=this.importpage.importCustomerBulkDelete(importProp.getProperty("customerBulkDelete"),importSheetPath);
		Assert.assertEquals(actualStatusMsg,EXPECTED_CUSTOMER_BULK_DELETE_STATUS);
		logger.info("Ending of Customer Bulk Upload Method");

	}
	
	@Test(priority = 3, description="Customer Id bulk upload", groups = {"sanity"})
	@Description("Customer ID Bulk upload through imports")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the customer id update through imports")
	public void customerIdBulkUpload(){
		logger.info("Starting of Customer id updated test case");
		this.importpage.clickOnImports();
		String importSheetPath=System.getProperty("user.dir")+"\\MediaFiles\\Customer_ID_Update.xls";
		this.importpage.importCustomerIdUpadte(importProp.getProperty("customerIdUpload"),importSheetPath);
		logger.info("Ending of Customer Bulk Upload Method");

	}
		
	
	@AfterClass(alwaysRun = true)
	public void LogOutImports() {
		logger.info("Starting of LogOutCustomer Method");
		this.importpage.logOut();
		logger.info("Ending of LogOutCustomer Method");

	}

	

}
