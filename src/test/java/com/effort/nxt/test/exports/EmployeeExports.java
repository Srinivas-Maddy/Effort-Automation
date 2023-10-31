package com.effort.nxt.test.exports;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.exports.EmployeeExportPage;
import com.effort.nxt.test.BaseAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EmployeeExports extends BaseAutomationTest{

	private static final Logger logger=Logger.getLogger(EmployeeExports.class);
	private EmployeeExportPage empExport=null;
	private static final String ExportAllConfirmationMsg="The report will be emailed to the registered email address when it is ready.";
    private static final String  EXPORT_SELECTED_STATUS="Data download process is successful.";
	//Before class test case was execute once class loaded in the jvm
    
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL","browser", "headless"})
	public void initEffortLogin(String siteUrl,String browser, String headless) throws Exception {
		logger.info("starting of initEfforrt Login Method in work creation process");
		this.driver=this.getWebDriver(browser, headless, WebDriversEnum.EMPLOYEE_EXPORTS_DRIVER);
		this.goToSite(siteUrl, driver);
		this.empExport=new EmployeeExportPage(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		
		logger.info("Ending of initEffortLogin method in Work Creation process");			
	}
	
	@Test(priority = 1, description="Go to Emplpyee module and downlooad export all", groups = {"sanity"})
	@Description("Test Case #1, Download Export All employees")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, Downloading Employee Export All sheet")
	public void employeeExportAll() throws InterruptedException {
		logger.info("Starting of the employeeExportAll method");
		this.empExport.clickOnWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		this.empExport.clickOnEmployeeModule();
		this.empExport.clickOnExportOptions();
		this.empExport.clickOnExportAll();
		this.empExport.clickOnConfirm();
		this.empExport.switchWindow();
		String actualMessage=this.empExport.getConfirmationMessage();
		Assert.assertEquals(actualMessage, ExportAllConfirmationMsg);
		logger.info("Ending the employeeExportAll Method");				
	}
	
	
	@Test(priority = 2, description="Employee Selected export", groups = {"sanity"})
	@Description("Test Case #1, Download Export selected employees")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, Downloading selected employees sheet")
	public void employeeExportSelected() throws InterruptedException {
		logger.info("Starting of the employee Export selected method");
		this.empExport.clickOnEmployeeModule();
        this.empExport.selectedEmployees();
		this.empExport.clickOnExportOptions();
		String actualStatus=this.empExport.clickOnExportSelected(exportDataProp.getProperty("exportSelected"));
        Assert.assertEquals(actualStatus,EXPORT_SELECTED_STATUS);
		logger.info("Ending the Export selected Method");				
	}
	
	
	@AfterClass(alwaysRun = true)
	public void logOutForm() {
		logger.info("Starting of Log-out Method");
		this.empExport.logOut();	
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
