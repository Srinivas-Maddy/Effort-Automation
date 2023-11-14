package com.effort.nxt.test.routeplans;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.common.WebDriversEnum;
import com.effort.nxt.test.BaseAutomationTest;
import com.effort.pages.routes.RoutePlansPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class RoutePlanTest extends BaseAutomationTest {
	private static final Logger logger = Logger.getLogger(RoutePlanTest.class.getName());
	private RoutePlansPage routeplanspage;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "siteURL", "browser", "userName", "password", "headless" })

	public void initEffortLogin(String siteURL, String browser, String userName, String password, String headless)
			throws Exception {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.ROUTE_PLANS_DRIVER);
		this.goToSite(siteURL, driver);
		this.routeplanspage = new RoutePlansPage(driver);
		LoginToApplication(userName, password);

		logger.info("Ending of initEffortLogin Method");
	}

	@Test(priority = 1, description = "#Test Case= 1 ,verify creating of a new Routes Plan", groups = { "sanity" })
	@Description("#Test Case= 1 ,verify creating of a new Routes Plan")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 1, verify creating of a new Routes Plan")
	public void verifyCreatingRoutePlan() {
		logger.info("Starting of verifyCreatingRoutePlan Method");

		this.loginPage.ClickonWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		routeplanspage.clickOnRoutesModule(testDataProp.getProperty("routesname"));
		routeplanspage.clickOnCreateRoutesPlan();
		routeplanspage.enterRoutesPlanName(testDataProp.getProperty("routesplanname"));
		routeplanspage.enterRouteID(testDataProp.getProperty("routeId"));
		routeplanspage.enterRouteDuration(testDataProp.getProperty("duration"));
		routeplanspage.enterNightsTostay(testDataProp.getProperty("nightcount"));
		routeplanspage.clickOnAddCustomer();
		routeplanspage.pickCustomers();

		Assert.assertEquals(RoutePlansPage.routename, routeplanspage.routeNameValidation());
		Assert.assertTrue(routeplanspage.verifyIsEditedRoutePlanSavedSuccessfully());

		logger.info("Ending of verifyCreatingRoutePlan Method");
	}

	@Test(priority = 2, description = "#Test Case= 2, verify editing existing Routes Plan", groups = { "sanity" })
	@Description("#Test Case= 2, verify editing existing Routes Plan")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 2, verify editing existing Routes Plan")
	public void verifyEditingExistingRoutePlan() {
		logger.info("Starting of verifyEditingExistingRoutePlan Method");

		routeplanspage.clickOnEditIcon();
		routeplanspage.swichToNewWindow();
		routeplanspage.clickOnAddCustomer();
		routeplanspage.editPickedCustomers();
		routeplanspage.clickOnOkayButtonOnApplyChanges();
		
		Assert.assertTrue(routeplanspage.verifyIsEditedRoutePlanSavedSuccessfully());

		logger.info("Ending of verifyEditingExistingRoutePlan Method");
	}

	@Test(priority = 3, description = "#Test Case= 4 ,Assign Routes Plan", groups = { "sanity" })
	@Description("#Test Case= 3, Assigning Route plan to Employee")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 3, Assign Routes Plan")
	public void verifyDeletingROuteEmployee() {
		logger.info("Starting verifyDeletingROuteEmployee Method");

		routeplanspage.verifyDeletingTheRouteEmployee();

		logger.info("Ending of verifyDeletingROuteEmployee Method");
	}
	
	@Test(priority = 4, description = "#Test Case= 4 ,Assign Routes Plan", groups = { "sanity" })
	@Description("#Test Case= 4, Assigning Route plan to Employee")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 4, Assign Routes Plan")
	public void verifyAssignRoutePlan() {
		logger.info("Starting verifyAssignRoutePlan Method");

		routeplanspage.clickOnRoutesModule(testDataProp.getProperty("routesname"));
		routeplanspage.clickOnAssignButton();
		routeplanspage.pickRoutePlan(testDataProp.getProperty("routesplanname"));
		routeplanspage.pickRouteEmployee();
		routeplanspage.selectFromInRoutePlan();
		routeplanspage.clickOnAssignButtonOnRouteAssign();
		routeplanspage.clickOnMapAssignButton();
		
		Assert.assertTrue(routeplanspage.verifyIsEditedRoutePlanSavedSuccessfully());

		logger.info("Ending of verifyAssignRoutePlan Method");
	}

	@Test(priority = 5, description = "#Test Case= 5 ,verify editing Assigned Routes Plan", groups = { "sanity" })
	@Description("#Test Case= 5, verify editing Assigned Routes Plan")
	@Severity(SeverityLevel.CRITICAL)
	@Story("#Test Case= 5, verify editing Assigned Routes Plan")
	public void verifyEditingAssignedRoutePlan() {
		logger.info("Starting verifyEditingAssignedRoutePlan Method");

		routeplanspage.clickOnEditIcon();
		routeplanspage.editRouteEmployee();
		routeplanspage.clickOnSubmitButton();
		routeplanspage.clickOnMapAssignButton();
		
		Assert.assertTrue(routeplanspage.verifyIsEditedRoutePlanSavedSuccessfully());

		logger.info("Ending of verifyEditingAssignedRoutePlan Method");
	}

//	@AfterClass(alwaysRun = true)
//	public void logOutRoutes() throws InterruptedException {
//		logger.info("Starting of logOutRoutes Method");
//
//		routeplanspage.routesLogOut();
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
