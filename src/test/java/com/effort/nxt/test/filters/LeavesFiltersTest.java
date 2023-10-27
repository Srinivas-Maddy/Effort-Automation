package com.effort.nxt.test.filters;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.filters.LeavesFiltersPage;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LeavesFiltersTest extends BaseAutomationTest {
	private static final Logger logger = Logger.getLogger(LeavesFiltersTest.class.getName());
	private LeavesFiltersPage leavesfilterpage;
	private static final String EXPECTED_APPLIED_LEAVES_STATUS ="Applied";
	private static final String EXPECTED_APPROVED_LEAVES_STATUS ="Approved";
	private static final String EXPECTED_CANCELLED_LEAVES_STATUS ="Cancelled";
	private static final String EXPECTED_REJECTED_EMPLOYEE_ID ="Rejected";
	private static final String EXPECTED_REPORTING_IMMEDIATE_MANAGER = "Srinivas Maddy";
	private static final String EXPECTED_LEAVES_TYPE="Leave";
	private static final String EXPECTED_MYLEAVES_STATUS ="Approved";
	private static final String EXPECTED_MYLEAVES_FROM_DATE = "Leave";
		
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" , "browser", "headless"})
	
	public void initEffortLogin(String siteURL , String browser, String headless ) throws InterruptedException {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.LEAVES_FILTERS_DRIVER);
		driver.get(siteURL);
		this.leavesfilterpage = new LeavesFiltersPage(driver);
		this.loginPage = new LoginPage(driver);
		loginPage.enterUserName(testDataProp.getProperty("name"));
		loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
	
		logger.info("Ending of initEffortLogin Method");
	}
	
	@Test(priority = 1 ,description = "TestCase#1 ,Validation of Leaves Filters" , groups = {"sanity"} )
	@Description("Validation of Leaves Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("TestCase #1, Validation of Leaves Filters")
	public void leavesFilters() throws InterruptedException {
		logger.info("Starting of leavesFilters Method");
		leavesfilterpage.clickOnWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		leavesfilterpage.clickOnThreeDots();
		leavesfilterpage.pickLeaves(leavesDataProp.getProperty("leavesname"));
		leavesfilterpage.clickOnLeavesFilters();
		leavesfilterpage.enterAppliedLeavesEmployeeName(leavesDataProp.getProperty("leavesEmployeeName"));
		String actualappliedLeaves = leavesfilterpage.appliedLeavesValidation();
		Assert.assertEquals(actualappliedLeaves, EXPECTED_APPLIED_LEAVES_STATUS);
		leavesfilterpage.clickOnLeavesFilters();
		leavesfilterpage.enterApprovedLeavesEmployeeName(leavesDataProp.getProperty("leavesEmployeeName"));
		String actualapprovedLeaves = leavesfilterpage.approvedLeavesValidation();
		Assert.assertEquals(actualapprovedLeaves, EXPECTED_APPROVED_LEAVES_STATUS);
		leavesfilterpage.clickOnLeavesFilters();
		leavesfilterpage.enterCancelledLeavesEmployeeName(leavesDataProp.getProperty("leavesEmployeeName"));
		String actualcancelledLeaves = leavesfilterpage.cancelledLeavesValidation();
		Assert.assertEquals(actualcancelledLeaves, EXPECTED_CANCELLED_LEAVES_STATUS);
		leavesfilterpage.clickOnLeavesFilters();
		leavesfilterpage.enterRejectedLeavesEmployeeName(leavesDataProp.getProperty("leavesEmployeeName"));
		String actualrejectedLeaves= leavesfilterpage.rejectedLeavesValidation();
		Assert.assertEquals(actualrejectedLeaves, EXPECTED_REJECTED_EMPLOYEE_ID);
		leavesfilterpage.clickOnLeavesFilters();
		leavesfilterpage.enterReportingManager(leavesDataProp.getProperty("leavesEmployeeName"));
		String actualreportingmangerresult= leavesfilterpage.reportingManagerValidation();
		Assert.assertEquals(actualreportingmangerresult, EXPECTED_REPORTING_IMMEDIATE_MANAGER);
		
		leavesfilterpage.clickOnLeavesFilters();
		
		leavesfilterpage.clickOnLeavesAppliedCheckbox();
		leavesfilterpage.pickAppliedLeavesDates(leavesDataProp.getProperty("leavedate"));
		
		boolean appliedDataDisplayed= leavesfilterpage.leavesDateValidation();//
		Assert.assertEquals(appliedDataDisplayed, true);
		leavesfilterpage.clickOnLeavesFilters();
		leavesfilterpage.selectLeaveType(leavesDataProp.getProperty("leavetype"));
		String actualleavestyperesult= leavesfilterpage.leavesTypeValidation();
		Assert.assertEquals(actualleavestyperesult, EXPECTED_LEAVES_TYPE);
		logger.info("Ending of leavesFilters Method");
	}
	
	@Test(priority = 2 ,description = "TestCase#2 ,Validation of MyLeaves Filters" , groups = {"sanity"} )
	@Description("Validation of MyLeaves Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("TestCase #2, Validation of MyLeaves Filters")
	public void myLeavesFilters() throws InterruptedException {
		logger.info("Starting of myLeavesFilters Method");
		//leavesfilterpage.clickOnLeaves();
		leavesfilterpage.clickOnViewMyLeaves();
		leavesfilterpage.SwitchNewWindow();
		leavesfilterpage.clickOnMyLeavesFilter();
		leavesfilterpage.selectAppliedStatus();
		leavesfilterpage.selectApprovedStatus();
		String actualmyleavesapprovedresult= leavesfilterpage.myleavesApprovedValidation();
		Assert.assertEquals(actualmyleavesapprovedresult, EXPECTED_MYLEAVES_STATUS);
		leavesfilterpage.selectCancelledStatus();
		leavesfilterpage.selectRejectedStatus();
		leavesfilterpage.pickMyLeavesFilterDates();
		leavesfilterpage.myleavesDatesValidation();
		String actualmyleavesdatesresult= leavesfilterpage.myleavesDatesValidation();
		Assert.assertEquals(actualmyleavesdatesresult, EXPECTED_MYLEAVES_FROM_DATE);
		
		logger.info("Ending of myLeavesFilters Method");
	}
	
	
	
	@AfterClass(alwaysRun = true)
	public void entityLeavesLogout() throws InterruptedException {
		logger.info("Starting of entityLeavesLogout Method");
		leavesfilterpage.filtersLeavesLogout();

		logger.info("Ending of entityLeavesLogout Method");
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
