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
	
	private EmployeeFiltersPage empPage;
	
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" , "browser", "headless","userName","password"})
	
	public void initEffortLogin(String siteURL , String browser, String headless, String userName, String passWord) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.EMPLOYEE_FILTERS_DRIVER);
		this.goToSite(siteURL, driver);
		this.empPage = new EmployeeFiltersPage(driver);
		this.loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.clickOnPassword(passWord);
		loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(userName, passWord);
		
		logger.info("Ending of initEffortLogin Method");	
	}
	
	@Test(priority = 1,description = "Test Case#1, Employee ID Filters" , groups = {"sanity"})
	@Description("Filter employee based on employee Id")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee Filter Functionality")
	public void employeeIdFilters(){
		logger.info("Starting of employeeIdFilters Method");
		
		empPage.clickOnWebApp();
		empPage.clickOnEmplpyeeModule();
		empPage.clickOnFilter();
		Assert.assertEquals(expectedAssertionsProp.getProperty("EmployeeFilterTest.empId"), empPage.enterEmpId(expectedAssertionsProp.getProperty("EmployeeFilterTest.empId")));
		
		logger.info("Ending of employeeIdFilters Method");
	}

	@Test(priority = 2,description = "Test Case#2, Employee Free text Filters" , groups = {"sanity"})
	@Description("Filter employee based on employee free text")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee Filter Functionality")
	public void employeeFreeTextFilter() {
		logger.info("Starting of employeeFreeTextFilter method");
		
		empPage.clickOnFilter();
		empPage.clickOnReset("Active");
		Assert.assertEquals(expectedAssertionsProp.getProperty("EmployeeFilterTest.empNameFreeText"),empPage.enterEmpNameFreeText(expectedAssertionsProp.getProperty("EmployeeFilterTest.empNameFreeText")));
		
		logger.info("Starting of employeeFreeTextFilter method");
	}
	
	@Test(priority = 3,description = "Test Case#3, Employee Three letter Filters" , groups = {"sanity"})
	@Description("Filter employee based on employee three letters filter")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee Filter Functionality")
	public void employeeThreeLetterFilter() {
		logger.info("Starting of employeeThreeLetterFilter method");

		empPage.clickOnFilter();
		empPage.clickOnReset("Active");
		Assert.assertEquals(expectedAssertionsProp.getProperty("EmployeeFilterTest.empThreeLetterSearch"),empPage.searchWithThreeLetters(expectedAssertionsProp.getProperty("EmployeeFilterTest.empThreeLetterSearch")));

		logger.info("Ending of employeeThreeLetterFilter method");
	}
	
	@Test(priority = 4,description = "Test Case#4, Employee Phone number Filters" , groups = {"sanity"})
	@Description("Filter employee based on employee phone number")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee Filter Functionality")
	public void employeePhoneFilter() {
		logger.info("Starting of employeePhoneFilter Method");
		
		empPage.clickOnFilter();
		empPage.clickOnReset("Active");
		Assert.assertEquals(expectedAssertionsProp.getProperty("EmployeeFilterTest.phone"),empPage.enterEmployeePhone(expectedAssertionsProp.getProperty("EmployeeFilterTest.phone")));
		
		logger.info("Ending of employeePhoneFilter Method");
	}
	
	@Test(priority = 5,description = "Test Case#5, Employee Email Filters" , groups = {"sanity"})
	@Description("Filter employee based on employee email")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee Filter Functionality")
	public void employeeEmailFilter() {
		logger.info("Starting of employeeEmailFilter Method");

		empPage.clickOnFilter();
		empPage.clickOnReset("Active");
		Assert.assertEquals(expectedAssertionsProp.getProperty("EmployeeFilterTest.empNameFreeText"),empPage.enterEmpEmail(expectedAssertionsProp.getProperty("EmployeeFilterTest.email")));

		logger.info("Ending of employeeEmailFilter Method");
	}
	
	@Test(priority = 6,description = "Test Case#6, Employee Manager Filters" , groups = {"sanity"})
	@Description("Filter employee based on employee manager")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee Filter Functionality")
	public void employeeManagerFilter() {
		logger.info("Starting of employeeManagerFilter Method");
		
		empPage.clickOnFilter();
		empPage.clickOnReset("Active");
		Assert.assertEquals(expectedAssertionsProp.getProperty("EmployeeFilterTest.Manager"),empPage.selectEmpManagerName(expectedAssertionsProp.getProperty("EmployeeFilterTest.Manager")));
		
		logger.info("Ending of employeeManagerFilter Method");

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
