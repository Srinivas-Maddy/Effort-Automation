package com.effort.nxt.test.imports;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
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

public class EmployeeBulkUplods extends BaseAutomationTest {

	private static final Logger logger = Logger.getLogger(EmployeeBulkUplods.class.getName());
	private ImportPages importpage = null;
	private final String EXPECTED_SHEET_VALIDATION = "All rows have correct data";
	private String exptectedSheetProcessingStatus = "Processed";
	private final String EXPECTED_EMP_CUSTOMER_MAPPING_STATUS = "Mapping successfully done";
	private final String EXPECTED_EMP_CUSTOMER_TYPE_MAPPING_STATUS = "We've received the sheet you uploaded. An email will be sent to"
			+ " you notifying the status of the update. The following are the files that were uploaded:";
	private final String EXPECTED_ROUTE_MAPPING_STATUS = "* Note : No files are currently in process.";
	private final String EXPECTED_EMP_LEAVE_BALANCE_STATUS = "All rows have correct data";
	private final String EXPECTED_EMP_ID_UPDATE_STATUS = "Processed";
	private final String EXPECTED_ROUTE_ASSIGNMENT = "We've received the sheet you uploaded. An email will be sent to you notifying the status of the update."
			+ " The following are the files that were uploaded:";
	private final String EXPECTED_TERRITORY_MAPPING_STATUS = "We've received the sheet you uploaded. An email will be sent to you notifying the status of the update. The following are the files that were uploaded:";
	private final String EXPECTED_WORK_ASSIGNMENT_STATUS = "Successful";

	@BeforeClass(alwaysRun = true)
	@Parameters({ "siteURL", "browser" , "headless"})
	public void initEffortLogin(String siteURL, String browser, String headless) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.EMPLOYEE_BULKUPLOAD);
		this.goToSite(siteURL, driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"),
				testDataProp.getProperty("password1"));
		this.importpage = new ImportPages(driver);
	
		logger.info("Ending of initEffortLogin Method");
	}

	@Test(priority = 1, description = "Employee Build Upload", groups = { "sanity" })
	@Description("Employee Build Upload through the import screen")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the employee bulk upload through the bulk upload")
	public void employeeBulkUpload() throws InterruptedException, EncryptedDocumentException, IOException {
		logger.info("Starting of EmployeeBulkUpload Method");
		this.importpage.clickOnWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		this.importpage.clickOnImports();
		String importSheetPath = System.getProperty("user.dir") + "/MediaFiles/EmployeeSheet.xls";
		String validationSheet = this.importpage.clickOnImportCard(importProp.getProperty("empImportCardName"),
				importSheetPath);
		Assert.assertEquals(validationSheet, EXPECTED_SHEET_VALIDATION);
		Assert.assertEquals(ImportPages.SheetProcessingStatus, exptectedSheetProcessingStatus);
		logger.info("Ending of EmployeeBulkUpload Method");

	}

	@Test(priority = 2, description = "Employee customer mapping", groups = { "sanity" })
	@Description("Customer mapping to employee")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the employee customer mapping through the bulk upload")
	public void employeeCustomerMapping() throws InterruptedException {
		logger.info("Starting of Emp Customer Mapping Method");
		this.importpage.clickOnImports();
		String importSheetPath = System.getProperty("user.dir") + "/MediaFiles/EmployeeCustomerMapping.xls";
		String validationSheet = this.importpage.importCustomerMapping(importProp.getProperty("empCustomerMapping"),
				importSheetPath);
		Assert.assertEquals(validationSheet, EXPECTED_EMP_CUSTOMER_MAPPING_STATUS);
		logger.info("Ending of Emp Customer Mapping Method");

	}

	@Test(priority = 3, description = "Employee Customer type mapping", groups = { "sanity" })
	@Description("Employee customer type mapping")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the employee customer type mapping through the bulk upload")
	public void employeeCustomerTypeMapping() throws InterruptedException {
		logger.info("Starting of Emp Customer type Mapping Method");
		this.importpage.clickOnImports();
		String importSheetPath = System.getProperty("user.dir") + "/MediaFiles/EmployeeCustomerTypeMapping.xls";
		String actualStatusMsg = this.importpage
				.importEmployeeCustomerTypeMapping(importProp.getProperty("empCustomer"), importSheetPath);
		Assert.assertEquals(actualStatusMsg, EXPECTED_EMP_CUSTOMER_TYPE_MAPPING_STATUS);
		logger.info("Ending of Emp Customer type Mapping Method");
	}

	@Test(priority = 4, description = "Employee Route Plan Mapping", groups = { "sanity" })
	@Description("Employee route plan mapping")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the employee route plan mapping through the bulk upload")
	public void employeeRoutePlanMapping() throws InterruptedException {
		logger.info("Starting of Emp Route Plan mapping Method");
		this.importpage.clickOnImports();
		String importSheetPath = System.getProperty("user.dir") + "/MediaFiles/Employee_Route_Plan_Mapping.xls";
		String actualStatusMsg = this.importpage.importRoutePlanMapping(importProp.getProperty("empRouteMapping"),
				importSheetPath);
		Assert.assertEquals(actualStatusMsg, EXPECTED_ROUTE_MAPPING_STATUS);
		logger.info("Ending of Emp route plan mapping Method");
	}

	@Test(priority = 5, description = "Employee Route Plan Assignment", groups = { "sanity" })
	@Description("Employee route plan Assignment")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the employee route plan assignment through the bulk upload")
	public void employeeRouteAssignment() throws InterruptedException {
		logger.info("Starting of Emp Route Plan Assignment Method");
		this.importpage.clickOnImports();
		String importSheetPath = System.getProperty("user.dir") + "/MediaFiles/Employee_Route_Plan_Assignment.xls";
		String actualStatusMsg = this.importpage.importRouteAssignment(importProp.getProperty("empRoutePlanAssignment"),
				importSheetPath);
		Assert.assertEquals(actualStatusMsg, EXPECTED_ROUTE_ASSIGNMENT);
		logger.info("Ending of Emp Route Plan Assignment Method");
	}

	@Test(priority = 6, description = "Employee Leave Balance update through bulk upload", groups = { "sanity" })
	@Description("Employee leave Balance")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the Emp leave balance through the bulk upload")
	public void employeeLeaveBalance() throws InterruptedException {
		logger.info("Starting of Emp Leave Balance Mapping Method");
		this.importpage.clickOnImports();
		String importSheetPath = System.getProperty("user.dir") + "/MediaFiles/Employee_leave_balance.xls";
		String actualStatusMsg = this.importpage.importEmployeeLeaveBalance(importProp.getProperty("empLeaveBalance"),
				importSheetPath);
		Assert.assertEquals(actualStatusMsg, EXPECTED_EMP_LEAVE_BALANCE_STATUS);
		logger.info("Ending of Emp Leave Balance Mapping Method");
	}

	@Test(priority = 7, description = "Employee ID update through bulk upload", groups = { "sanity" })
	@Description("Employee ID Update")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the Emp ID update through the bulk upload")
	public void employeeIDUpdate() throws InterruptedException {
		logger.info("Starting of Emp Id Update Method");
		this.importpage.clickOnImports();
		String importSheetPath = System.getProperty("user.dir") + "/MediaFiles/Employee_ID_Update.xls";
		String actualStatusMsg = this.importpage.importEmployeeIDUpdate(importProp.getProperty("empIdUpdate"),
				importSheetPath);
		Assert.assertEquals(actualStatusMsg, EXPECTED_EMP_ID_UPDATE_STATUS);
		logger.info("Ending of Emp Id Update  Method");
	}

	@Test(priority = 8, description = "Work Reassignment through bulk upload", groups = { "sanity" })
	@Description("Work Reassigment")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the work reassignment through the bulk upload")
	public void employeeWorkReassignment() throws InterruptedException {
		logger.info("Starting of Work Reassignment Method");
		this.importpage.clickOnImports();
		String importSheetPath = System.getProperty("user.dir") + "/MediaFiles/Employee_Work_Reassignment.xls";
		String actualStatusMsg = this.importpage.importEmployeeWorkReassignment(
				importProp.getProperty("empBulkWorkReassignment"), importSheetPath,
				importProp.getProperty("workSpecName"));
		Assert.assertEquals(actualStatusMsg, EXPECTED_WORK_ASSIGNMENT_STATUS);
		logger.info("Ending of Work Reassignment Method");
	}

	@Test(priority = 9, description = "Employee Terriotry Mapping", groups = { "sanity" })
	@Description("Employee Terriotry mapping")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the employee Terriotry items mapping through the bulk upload")
	public void employeeTerriotryMapping() throws InterruptedException {
		logger.info("Starting of Emp Terriotry Mapping Method");
		this.importpage.clickOnImports();
		String importSheetPath = System.getProperty("user.dir") + "/MediaFiles/Employee_Territory_Mapping.xls";
		String actualEmpTerritoryStatus = this.importpage
				.importEmpTerritoryMapping(importProp.getProperty("employeeTerritoryMapping"), importSheetPath);
		Assert.assertEquals(actualEmpTerritoryStatus, EXPECTED_TERRITORY_MAPPING_STATUS);
		logger.info("Ending of Emp Terriotry Mapping Method");

	}

	@Test(priority = 10, description = "Employee List Mapping", groups = { "sanity" })
	@Description("Employee List mapping")
	@Epic("Imports Module")
	@Feature("Bulk Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Validating the employee list items mapping through the bulk upload")
	public void employeeListMapping() throws InterruptedException {
		logger.info("Starting of Emp List Mapping Method");
		this.importpage.clickOnImports();
		String importSheetPath = System.getProperty("user.dir") + "/MediaFiles/ListItemsEmployeeMapping.xls";
		this.importpage.importEmployeeListMapping(importProp.getProperty("empListMapping"), importSheetPath,
				importProp.getProperty("listSpecName"));
		logger.info("Ending of Emp List Mapping Method");

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
