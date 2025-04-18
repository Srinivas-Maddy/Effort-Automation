package com.effort.nxt.test.exports;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
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

	//Before class test case was execute once class loaded in the jvm
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL","browser"})
	public void initEffortLogin(String siteUrl,String browser) throws Exception {
		logger.info("starting of initEfforrt Login Method in work creation process");
		this.driver=this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
		this.goToSite(siteUrl, driver);
		this.empExport=new EmployeeExportPage(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		this.empExport.clickOnWebApp();
		logger.info("Ending of initEffortLogin method in Work Creation process");			
	}
	
	@Test(priority = 1, description="Go to Emplpyee module and downlooad export all", groups = {"sanity"})
	@Description("Test Case #1, Download Export All employees")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, Downloading Employee Export All sheet")
	public void employeeExportAll() {
		logger.info("Starting of the employeeExportAll method");
		this.empExport.clickOnEmployeeModule();
		this.empExport.clickOnExportOptions();
		this.empExport.clickOnExportAll();
		this.empExport.clickOnConfirm();
		this.empExport.switchWindow();
		String actualMessage=this.empExport.getConfirmationMessage();
		Assert.assertEquals(actualMessage, ExportAllConfirmationMsg);
		logger.info("Ending the employeeExportAll Method");				
	}
	
	
	@Test(priority = 1, description="Go to Emplpyee module and select the employees and download xls", groups = {"sanity"})
	@Description("Test Case #1, Download Export selected employees")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, Downloading selected employees sheet")
	public void employeeExportSelected() {
		logger.info("Starting of the employee Export selected method");
		
		logger.info("Ending the Export selected Method");				
	}
	
	

	@AfterClass(alwaysRun = true)
	public void logOutForm() {
		logger.info("Starting of Log-out Method");
		this.empExport.logOut();	
		logger.info("Ending of log-out Method");
	}

}
