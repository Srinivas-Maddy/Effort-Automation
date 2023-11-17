package com.effort.nxt.test.dayplan;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.effort.common.WebDriversEnum;
import com.effort.dayplan.DayplannerPage;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class DayplannerTest extends BaseAutomationTest{
	
	private static final Logger logger=Logger.getLogger(DayplannerTest.class.getClass());
	private DayplannerPage dayPlanner;
	
	@BeforeClass(alwaysRun = true)
	@Parameters({ "siteURL", "browser" ,"userName", "password", "headless"})
	public void initEffortLogin(String siteURL, String browser, String userName, String password ,String headless) throws Exception {
		logger.info("Starting of initEffortLogin menthod in DayplannerTest");
		
		this.driver=this.getWebDriver(browser,headless,WebDriversEnum.DAY_PLANNER_DRIVER);
		this.goToSite(siteURL, driver);
		this.dayPlanner=new DayplannerPage(driver);
		LoginToApplication(userName, password);
		
		logger.info("Ending of initEffortLogin method in DayplannerTest");
	}
	
	@Test(priority = 1, description="Creating day planner in the web application", groups = {"sanity"})
	@Description("Assign the Day Plan to the employee through web application")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Day Planner Assignment")
	public void createDayPlan() {
		logger.info("Starting of createDayPlan Method");
		
		this.loginPage.ClickonWebApp();
		this.dayPlanner.clickOnMeatBallsMenu();
		this.dayPlanner.clickOnDayPlan();
		this.dayPlanner.selectEmployeeInSearchBar(dayPlannerProp.getProperty("employeeName"));
		this.dayPlanner.clickOnAddCustomerButton();
		this.dayPlanner.selectCustomerCheckBoxes();
		this.dayPlanner.clickOnOkButton();
		this.dayPlanner.clickOnSaveButton();
		Assert.assertEquals(this.dayPlanner.clickOnSaveButton(),expectedAssertionsProp.getProperty("dayplanner.created.text"));
		logger.info("Ending of createDayPlan Method");
		
	}
	
	@Test(priority = 2, description="Modifying the day planner in the web application", groups = {"sanity"})
	@Description("Modifying the Day Plan to the employee through web application")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Day Planner Modification")
	public void modifyDayPlan() {
		logger.info("Starting of modifyDayPlan Method");
		
		this.dayPlanner.clickOnMeatBallsMenu();
		this.dayPlanner.clickOnDayPlan();
		this.dayPlanner.selectEmployeeInSearchBar(dayPlannerProp.getProperty("employeeName"));
		this.dayPlanner.clickOnAddCustomerButton();
		this.dayPlanner.modifySelectedCustomers();
		this.dayPlanner.clickOnOkButton();
		this.dayPlanner.clickOnSaveButton();
		
		logger.info("Ending of createDayPlan Method");
		
	}
	
	@Test(priority = 3, description="Creating the dayplanner with custom entity", groups = {"sanity"})
	@Description("Dayplanner creation with entities")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Day Planner creation with custom entities")
	public void createDayPlannerEntity() {
		logger.info("Starting of createDayPlannerEntity Method");
		
		this.dayPlanner.clickOnMeatBallsMenu();
		this.dayPlanner.clickOnDayPlan();
		this.dayPlanner.selectEmployeeInSearchBar(dayPlannerProp.getProperty("employeeName"));
		this.dayPlanner.clickOnEntityButton(dayPlannerProp.getProperty("entitySpecName"));
		this.dayPlanner.selectCustomerCheckBoxes();
		this.dayPlanner.clickOnOkButton();
		this.dayPlanner.clickOnSaveButton();
		Assert.assertEquals(this.dayPlanner.clickOnSaveButton(),expectedAssertionsProp.getProperty("dayplanner.created.text"));
			
		logger.info("Ending of createDayPlan Method");
		
	}
	
	
	

	
	/*
	 * @AfterClass(alwaysRun = true) public void logOutDayPlanner() {
	 * logger.info("Starting of logOutDayPlanner Method");
	 * 
	 * this.dayPlanner.LogOut();
	 * 
	 * logger.info("Ending of logOutDayPlanner Method"); }
	 */
	
	@AfterClass(alwaysRun = true)
	public void quitDriver() {
		logger.info("Starting of quitDriver Method");
		
		try {
			
			if (this.driver!=null) {
				Thread.sleep(2000);
				driver.quit();
				
				logger.info("Driver quit successfully");

			}
			
		} catch (Exception e) {
               logger.info(e.getMessage());
		}
		
		logger.info("Ending of quitDriver Method");

	}
}
