package com.effort.nxt.test.filters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.filters.EmployeeFiltersPage;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EmployeeFiltersTest extends BaseAutomationTest {
	private static final Logger logger = Logger.getLogger(EmployeeFiltersTest.class.getName());
	
	private EmployeeFiltersPage employeefilterspage;
	
	private static final String EXPECTED_ACTIVE_EMPLOYEE_STATUS="Activation Completed";
	private static final String EXPECTED_DISABLED_EMPLOYEE_STATUS="Disabled";
	private static final String EXPECTED_PROVISIONED_EMPLOYEE_STATUS="Activation Completed";
	private static final String EXPECTED_NOTPROVISIONED_EMPLOYEE_STATUS="Activation Incomplete";
	//private static final String EXPECTEDEMPLOYEEFREETEXT ="Automation_2023-02-23 Emp";
	
//	private String expectedEmpid=null;
//	private String expectedEmpfreetxt=null;
	
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" , "browser"})
	
	public void initEffortLogin(String siteURL , String browser) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, WebDriversEnum.EMPLOYEE_FILTERS_DRIVER);
		this.goToSite(siteURL, driver);
		this.employeefilterspage = new EmployeeFiltersPage(driver);
		this.loginPage = new LoginPage(driver);
		loginPage.enterUserName(testDataProp.getProperty("name"));
		loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		
		logger.info("Ending of initEffortLogin Method");	
	}
	
	@Test(priority = 1,description = "Test Case#1, Employee Filters" , groups = {"sanity"})
	@Description("Employee Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1,Employee Filters")
	public void employeeFilters() throws InterruptedException {
		logger.info("Starting of employeeFilters Method");
		employeefilterspage.ClickonWebApp();
		employeefilterspage.ClickonEmployees();
		
		employeefilterspage.selectActiveEmployee(filtersDataProp.getProperty("empID"));
		String actualactiveemp = employeefilterspage.activeEmployeesValidation();
		assertEquals(actualactiveemp, EXPECTED_ACTIVE_EMPLOYEE_STATUS);
		
		employeefilterspage.selectDisabledCheckbox(filtersDataProp.getProperty("disabledempid"));
		String actualdisabledemp= employeefilterspage.disabledEmployeesValidation();
		assertEquals(actualdisabledemp, EXPECTED_DISABLED_EMPLOYEE_STATUS);
		
		employeefilterspage.selectProvisionedCheckbox(filtersDataProp.getProperty("provisionedempid"));
		String actualprovisinedemp= employeefilterspage.provisionedEmployeesValidation();
		assertEquals(actualprovisinedemp, EXPECTED_PROVISIONED_EMPLOYEE_STATUS);
		
		employeefilterspage.selectNotProvisionedCheckbox(filtersDataProp.getProperty("notprovisionedempid"));
		String actualnotprovisionedemp = employeefilterspage.notProvisionedEmployeesValidation();
		assertEquals(actualnotprovisionedemp, EXPECTED_NOTPROVISIONED_EMPLOYEE_STATUS);
		
		logger.info("Ending of employeeFilters Method");
	}

	@AfterClass(alwaysRun = true)
	public void employeeFiltersLogout() throws InterruptedException {
		logger.info("Starting of employeeFiltersLogout Method");
		
		employeefilterspage.employeeFiltersLogOut();
		
		logger.info("Ending of employeeFiltersLogout Method");
		
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
