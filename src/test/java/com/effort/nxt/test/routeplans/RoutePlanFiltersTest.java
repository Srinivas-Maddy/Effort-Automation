package com.effort.nxt.test.routeplans;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.common.WebDriversEnum;
import com.effort.customers.CustomerPage;
import com.effort.nxt.test.BaseAutomationTest;
import com.effort.pages.routes.RoutePlanFilterPage;
import com.effort.pages.routes.RoutePlansPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class RoutePlanFiltersTest extends BaseAutomationTest {
	private static final Logger logger = Logger.getLogger(RoutePlanFiltersTest.class.getName());
	private RoutePlanFilterPage routeplanfilterpage;
	private RoutePlansPage routeplanspage;
	private CustomerPage custmrCreation;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "siteURL", "browser", "userName", "password", "headless" })

	public void initEffortLogin(String siteURL, String browser, String userName, String password, String headless)
			throws Exception {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.ROUTE_PLANS_DRIVER);
		this.goToSite(siteURL, driver);
		this.routeplanfilterpage = new RoutePlanFilterPage(driver);
		this.routeplanspage = new RoutePlansPage(driver);
		this.custmrCreation = new CustomerPage(driver);
		LoginToApplication(userName, password);

		logger.info("Ending of initEffortLogin Method");
	}

	@Test(priority = 1, description = "#Test Case= 1 ,verify incomplete Routes Plan", groups = { "sanity" })
	@Description("#Test Case= 1 ,verify incomplete Routes Plan")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 1, verify incomplete Routes Plan")
	public void verifyIncompleteRoutePlans() {
		logger.info("Starting of verifyIncompleteRoutePlans Method");

		this.loginPage.ClickonWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		routeplanspage.clickOnRoutesModule(testDataProp.getProperty("routesname"));
		routeplanfilterpage.clickOnFiltersButton();
		routeplanfilterpage.clickOnResetButton();
		routeplanfilterpage.clickOnIncompletedCheckBox();
		routeplanfilterpage.clickOnApplyButton();

		Assert.assertTrue(routeplanfilterpage.isIncompleteStatusDisplayed());

		logger.info("Ending of verifyIncompleteRoutePlans Method");
	}

	@Test(priority = 2, description = "#Test Case= 2 ,verify complete Routes Plan", groups = { "sanity" })
	@Description("#Test Case= 2 ,verify complete Routes Plan")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 2, verify complete Routes Plan")
	public void verifyCompleteRoutePlans() {
		logger.info("Starting of verifyCompleteRoutePlans Method");

		routeplanfilterpage.clickOnFiltersButton();
		routeplanfilterpage.clickOnResetButton();
		routeplanfilterpage.clickOnCompletedCheckBox();
		routeplanfilterpage.clickOnApplyButton();

		Assert.assertTrue(routeplanfilterpage.isCompleteStatusDisplayed());

		logger.info("Ending of verifyCompleteRoutePlans Method");
	}

	@Test(priority = 3, description = "#Test Case= 1 ,verify rejected Routes Plan", groups = { "sanity" })
	@Description("#Test Case= 3 ,verify rejected Routes Plan")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 3, verify rejected Routes Plan")
	public void verifyRejectedRoutePlans() {
		logger.info("Starting of verifyRejectedRoutePlans Method");

		routeplanfilterpage.clickOnFiltersButton();
		routeplanfilterpage.clickOnResetButton();
		routeplanfilterpage.clickOnRejectedCheckBox();
		routeplanfilterpage.clickOnApplyButton();

		Assert.assertTrue(routeplanfilterpage.isRejectedStatusDisplayed());

		logger.info("Ending of verifyRejectedRoutePlans Method");
	}

	@Test(priority = 4, description = "#Test Case= 1 ,verify todays Routes Plan", groups = { "sanity" })
	@Description("#Test Case= 4 ,verify todays Routes Plan")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 4, verify todays Routes Plan")
	public void verifyTodaysRoutePlans() {
		logger.info("Starting of verifyTodaysRoutePlans Method");

		routeplanfilterpage.clickOnFiltersButton();
		routeplanfilterpage.clickOnResetButton();
		routeplanfilterpage.clickOnTodaysRoutePlanCheckBox();
		routeplanfilterpage.clickOnApplyButton();

		Assert.assertTrue(routeplanfilterpage.isTodayRoutePlansDisplayed());

		logger.info("Ending of verifyTodaysRoutePlans Method");
	}

	@Test(priority = 5, description = "#Test Case= 5 ,verify past Routes Plan", groups = { "sanity" })
	@Description("#Test Case= 5 ,verify past Routes Plan")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 5, verify past Routes Plan")
	public void verifyPastRoutePlans() {
		logger.info("Starting of verifyPastRoutePlans Method");

		routeplanfilterpage.clickOnFiltersButton();
		routeplanfilterpage.clickOnResetButton();
		routeplanfilterpage.clickOnPastRoutePlan();
		routeplanfilterpage.clickOnApplyButton();

		Assert.assertTrue(routeplanfilterpage.isPastRoutePlansDisplayed());

		logger.info("Ending of verifyPastRoutePlans Method");
	}

	@Test(priority = 6, description = "#Test Case= 6 ,verify Upcoming Routes Plan", groups = { "sanity" })
	@Description("#Test Case= 6 ,verify Upcoming Routes Plan")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 6, verify Upcoming Routes Plan")
	public void verifyUpcomingRoutePlans() {
		logger.info("Starting of verifyUpcomingRoutePlans Method");

		routeplanfilterpage.clickOnFiltersButton();
		routeplanfilterpage.clickOnResetButton();
		routeplanfilterpage.clickOnUpcomingRoutePlan();
		routeplanfilterpage.clickOnApplyButton();

		Assert.assertTrue(routeplanfilterpage.isUpcomingRoutePlansDisplayed());

		logger.info("Ending of verifyUpcomingRoutePlans Method");
	}

	@Test(priority = 7, description = "#Test Case= 7 ,verify Employee selection in route plan filters", groups = {
			"sanity" })
	@Description("#Test Case= 7 ,verify Employee selection in route plan filters")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 7, verify Employee selection in route plan filters")
	public void verifyEmployeeDropDown() {
		logger.info("Starting of verifyEmployeeDropDown Method");

		routeplanfilterpage.clickOnFiltersButton();
		routeplanfilterpage.clickOnResetButton();
		routeplanfilterpage.clickOnEmployeeDropDown();
		routeplanfilterpage.selectEmployee();
		routeplanfilterpage.clickOnApplyButton();

		Assert.assertTrue(routeplanfilterpage.isSelectedEmployeeDisplayed());

		logger.info("Ending of verifyEmployeeDropDown Method");
	}

	@Test(priority = 8, description = "#Test Case= 8 ,verify Upcoming Routes Plan", groups = { "sanity" })
	@Description("#Test Case= 8 ,verify Upcoming Routes Plan")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 8, verify Upcoming Routes Plan")
	public void verifyManulSelect() {
		logger.info("Starting of verifyManulSelect Method");

		routeplanfilterpage.clickOnFiltersButton();
		routeplanfilterpage.clickOnResetButton();
		routeplanfilterpage.clickOnManualSpecifyCheckBox();
		routeplanfilterpage.setStartBetweenDate();
		routeplanfilterpage.setToDate();
	
		routeplanfilterpage.clickOnApplyButton();

		logger.info("Ending of verifyManulSelect Method");
	}

//	@AfterClass(alwaysRun = true)
//	public void logOutRoutes() throws InterruptedException {
//		logger.info("Starting of logOutRoutes Method");
//
//		custmrCreation.LogOut();
//
//		logger.info("Ending of logOutRoutes Method");
//	}

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
