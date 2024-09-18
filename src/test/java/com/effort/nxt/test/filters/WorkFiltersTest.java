package com.effort.nxt.test.filters;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.filters.WorkFiltersPage;
import com.effort.nxt.test.BaseAutomationTest;
import com.effort.works.AddWorkProcess;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class WorkFiltersTest extends BaseAutomationTest {
	
	private static final Logger logger = Logger.getLogger(WorkFiltersTest.class);
	private WorkFiltersPage workfilter;
	private AddWorkProcess addWork;

	
	@BeforeClass(alwaysRun = true)
	@Parameters({ "siteURL", "browser", "userName", "password", "headless" })
	public void initEffortLogin(String siteURL, String browser, String userName, String password, String headless)
			throws Exception {
		logger.info("starting of initEfforrt Login Method in work creation process");
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.ADD_WORK_PROCESS_DRIVER);
		this.goToSite(siteURL, driver);
		this.addWork = new AddWorkProcess(driver);
		this.loginPage = new LoginPage(driver);
		this.workfilter = new WorkFiltersPage(driver);
		LoginToApplication(userName, password);

		logger.info("Ending of initEffortLogin method in Work Creation process");
	}

	@Test(priority = 1, description = "Filter work With ID", groups = { "sanity" })
	@Description("Test Case #1, Filter work With ID")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, Filter work With ID")
	public void filerWorkWithID() throws InterruptedException {
		logger.info("Starting of the filerWorkWithID method");
		
		loginPage.ClickonWebApp();

		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		this.addWork.clickOnProcessModule();
		this.addWork.clickOnWorkName();
		
		workfilter.filterWorkWithId(filtersDataProp.getProperty("Work.id"));
		
		Assert.assertEquals(workfilter.isWorkIdDisplayed(), filtersDataProp.getProperty("Work.id"));
		
		logger.info("Ending the filerWorkWithID Method");
		}
	
	@Test(priority = 2, description = "Filter work With Name", groups = { "sanity" })
	@Description("Test Case #2, Filter work With Name")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2, Filter work With Name")
	public void filerWorkWithName() throws InterruptedException {
		logger.info("Starting of the filerWorkWithName method");
		
		workfilter.filterWorkWithName(filtersDataProp.getProperty("Work.Name"));
				
		Assert.assertEquals(workfilter.isWorkNameDisplayed(), filtersDataProp.getProperty("Work.Name"));
		
		logger.info("Ending the filerWorkWithName Method");
		}
	
	@Test(priority = 3, description = "Filter work With Start Date", groups = { "sanity" })
	@Description("Test Case #3, Filter work With Start Date")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3, Filter work With Start Date")
	public void filerWorkWithStartDate() throws InterruptedException {
		logger.info("Starting of the filerWorkWithStartDate method");
		
		workfilter.filterWorkWithStartDate(filtersDataProp.getProperty("Work.StartDate"));
		
		Assert.assertEquals(workfilter.isWorkStartDateDisplayed(),expectedAssertionsProp.getProperty("Work.StateDate"));
		
		logger.info("Ending the filerWorkWithStartDate Method");
		
		}
	
	@Test(priority = 4, description = "Filter work With End Date", groups = { "sanity" })
	@Description("Test Case #4, Filter work With End Date")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, Filter work With End Date")
	public void filerWorkWithEndDate() throws InterruptedException {
		logger.info("Starting of the filerWorkWithEndDate method");
		
		workfilter.filterWorkWithEndDate(filtersDataProp.getProperty("Work.EndDate"));
		
		Assert.assertEquals(workfilter.isWorkEndDateDisplayed(),expectedAssertionsProp.getProperty("Work.EndDate"));
		
		logger.info("Ending the filerWorkWithEndDate Method");
		
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
