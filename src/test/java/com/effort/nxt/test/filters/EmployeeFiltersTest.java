package com.effort.nxt.test.filters;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.filters.EmployeeFiltersPage;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EmployeeFiltersTest extends BaseAutomationTest {
	private static final Logger logger = Logger.getLogger(EmployeeFiltersTest.class.getName());
	
	EmployeeFiltersPage employeefilterspage;
	private static final String EXPECTEDEMPLOYEEID="SR001";
	private static final String EXPECTEDEMPLOYEEFREETEXT ="Automation_2023-02-23 Emp";
	
	private String expectedEmpid=null;
	private String expectedEmpfreetxt=null;
	
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" , "browser"})
	
	public void initEffortLogin(String siteURL , String browser) throws Exception {

		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
		this.goToSite(siteURL, driver);
		this.employeefilterspage = new EmployeeFiltersPage(driver);
		this.loginPage = new LoginPage(driver);
		loginPage.enterUserName(testDataProp.getProperty("name"));
		loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		loginPage.clickOnLoginButton();
		employeefilterspage.ClickonWebApp();
		logger.info("Ending of initEffortLogin Method");	
	}
	
	@Test(priority = 1 ,description = "TestCase #1 , Employee Filters" , groups={"sanity"})
	@Description("Appling Filters in Employee Field")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1 , Employee Filters")
	
	public void EmployeeIDFilter(String empID) {
		logger.info("Starting of EmployeeFilter Method");
		employeefilterspage.ClickonEmployees();
		String actualEmpId=employeefilterspage.EnterEmployeesFiltersID(filtersDataProp.getProperty(empID));
		Assert.assertEquals(actualEmpId, EXPECTEDEMPLOYEEID);
		logger.info("Ending of EmployeeFilter Method");
	}

	public void EmployeeFreeTextFilter(String empfreetext) {
		logger.info("Starting of EmployeeFreeTextFilter Method");
		String actualEmpFreeTesxt=employeefilterspage.EnterEmployeesFilterFreeText(empfreetext);
		Assert.assertEquals(actualEmpFreeTesxt, EXPECTEDEMPLOYEEFREETEXT);
		logger.info("Ending of EmployeeFreeTextFilter Method");
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void employeeFiltersLogout() {
		logger.info("Starting of employeeFiltersLogout Method");
		
		employeefilterspage.employeeFiltersLogOut();
		
		logger.info("Ending of employeeFiltersLogout Method");
		
	}
	
	
}
