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
public class ImportTest extends BaseAutomationTest{
	
	private static final Logger logger = Logger.getLogger(ImportTest.class.getName());
    private ImportPages importpage=null;
    private String expectedSheetValidationMsg="All rows have correct data";
    private String exptectedSheetProcessingStatus="Processed";
    private String expectedEmpCustMappingSheetMsg="Mapping successfully done";
    
    
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
	
	

	@Test(priority = 1, description="Employee Build Upload", groups = {"sanity"}, enabled=false)
	@Description("Employee Build Upload through the import screen")
	@Epic("Imports Module")
	@Feature("Build Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee bulk upload")
	public void EmployeeBulkUpload() throws InterruptedException {
		logger.info("Starting of EmployeeBulkUpload Method");
		this.importpage.clickOnImports();
		String importSheetPath=System.getProperty("user.dir")+"\\MediaFiles\\EmployeeSheet.xls";
		String validationSheet=this.importpage.clickOnImportCard(importProp.getProperty("empImportCardName"),importSheetPath);
	    Assert.assertEquals(validationSheet,expectedSheetValidationMsg);
	    Assert.assertEquals(importpage.SheetProcessingStatus,exptectedSheetProcessingStatus);
		logger.info("Ending of EmployeeBulkUpload Method");

	}
	
	@Test(priority = 2, description="Employee customer mapping", groups = {"sanity"}, enabled=false)
	@Description("Customer mapping to employee")
	@Epic("Imports Module")
	@Feature("Build Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee customer mapping bulk import")
	public void EmployeeCustomerMapping() throws InterruptedException {
		logger.info("Starting of EmployeeBulkUpload Method");
		this.importpage.clickOnImports();
		String importSheetPath=System.getProperty("user.dir")+"\\MediaFiles\\EmployeeCustomerMapping.xls";
		String validationSheet=this.importpage.importCustomerMapping(importProp.getProperty("empCustomerMapping"),importSheetPath);
	    Assert.assertEquals(validationSheet, expectedEmpCustMappingSheetMsg);
		logger.info("Ending of EmployeeBulkUpload Method");

	}
	
	@Test(priority = 3, description="Employee List Mapping", groups = {"sanity"})
	@Description("Employee List mapping")
	@Epic("Imports Module")
	@Feature("Build Uploads")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee list mapping bulk imports")
	public void EmployeeListMapping() throws InterruptedException {
		logger.info("Starting of EmployeeBulkUpload Method");
		this.importpage.clickOnImports();
		String importSheetPath=System.getProperty("user.dir")+"\\MediaFiles\\ListItemsEmployeeMapping.xls";
		this.importpage.importEmployeeListMapping(importProp.getProperty("empListMapping"),importSheetPath, importProp.getProperty("listSpecName"));
		logger.info("Ending of EmployeeBulkUpload Method");

	}
		

	@AfterClass(alwaysRun = true)
	public void LogOutImports() {
		logger.info("Starting of LogOutCustomer Method");
		importpage.logOut();
		logger.info("Ending of LogOutCustomer Method");

	}

}
