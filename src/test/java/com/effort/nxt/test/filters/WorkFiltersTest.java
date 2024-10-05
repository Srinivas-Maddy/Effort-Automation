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

		workfilter.filterWorkWithEndDate(filtersDataProp.getProperty("Work.EndDate"), filtersDataProp.getProperty("Work.id"));

		Assert.assertEquals(workfilter.isWorkStartDateDisplayed(),
				expectedAssertionsProp.getProperty("Work.StateDate"));

		logger.info("Ending the filerWorkWithStartDate Method");

	}

	@Test(priority = 4, description = "Filter work With End Date", groups = { "sanity" })
	@Description("Test Case #4, Filter work With End Date")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, Filter work With End Date")
	public void filerWorkWithEndDate() throws InterruptedException {
		logger.info("Starting of the filerWorkWithEndDate method");

		//workfilter.filterWorkWithStartDate(filtersDataProp.getProperty("Work.StartDate"));

		//workfilter.filterWorkWithEndDate(filtersDataProp.getProperty("Work.EndDate"), filtersDataProp.getProperty("Work.id"));

		Assert.assertEquals(workfilter.isWorkEndDateDisplayed(), expectedAssertionsProp.getProperty("Work.EndDate"));

		logger.info("Ending the filerWorkWithEndDate Method");

	}

	@Test(priority = 5, description = "Filter work With Employee", groups = { "sanity" })
	@Description("Test Case #5, Filter work With Employee")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #5, Filter work With Employee")
	public void filerWorkWithEmployeeName() throws InterruptedException {
		logger.info("Starting of the filerWorkWithEmployeeName method");

		workfilter.filterWorkWithEmployeeName(filtersDataProp.getProperty("Work.EmpName"));

		Assert.assertEquals(workfilter.isWorkEmployeeFieldDisplayed(), filtersDataProp.getProperty("Work.EmpName"));

		logger.info("Ending the filerWorkWithEmployeeName Method");

	}

	@Test(priority = 6, description = "Filter work With Text", groups = { "sanity" })
	@Description("Test Case #6, Filter work With Text")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #6, Filter work With Text")
	public void filerWorkWithText() throws InterruptedException {
		logger.info("Starting of the filerWorkWithText method");

		workfilter.filterWorkWithText(filtersDataProp.getProperty("Work.text"));

		Assert.assertEquals(workfilter.isWorkTextFieldDisplayed(), filtersDataProp.getProperty("Work.text"));

		logger.info("Ending the filerWorkWithText Method");

	}

	@Test(priority = 7, description = "Filter work With Currency", groups = { "sanity" })
	@Description("Test Case #7, Filter work With Currency")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #7, Filter work With Currency")
	public void filerWorkWithCurrency() throws InterruptedException {
		logger.info("Starting of the filerWorkWithCurrency method");

		workfilter.filterWorkWithCurrency(filtersDataProp.getProperty("work.currency"));

		Assert.assertEquals(workfilter.isWorkCurrencyFieldDisplayed(), filtersDataProp.getProperty("work.currency"));

		logger.info("Ending the filerWorkWithCurrency Method");

	}

	@Test(priority = 8, description = "Filter work With Date", groups = { "sanity" })
	@Description("Test Case #8, Filter work With Date")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #8, Filter work With Date")
	public void filerWorkWithDate() throws InterruptedException {
		logger.info("Starting of the filerWorkWithDate method");

		workfilter.filterWorkWithDate(filtersDataProp.getProperty("work.Date"));

		Assert.assertEquals(workfilter.isWorkDateFieldDisplayed(), filtersDataProp.getProperty("work.Date"));

		logger.info("Ending the filerWorkWithDate Method");

	}
	
	@Test(priority = 9, description = "Filter work With Duration", groups = { "sanity" })
	@Description("Test Case #9, Filter work With Duration")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #9, Filter work With Duration")
	public void filerWorkWithDuration() throws InterruptedException {
		logger.info("Starting of the filerWorkWithDuration method");

		workfilter.filterWorkWithDuration(filtersDataProp.getProperty("work.Duration"));

		Assert.assertEquals(workfilter.isWorkDurationFieldDisplayed(), filtersDataProp.getProperty("work.Duration"));

		logger.info("Ending the filerWorkWithDuration Method");

	}
	
	@Test(priority = 10, description = "Filter work With Duration", groups = { "sanity" })
	@Description("Test Case #10, Filter work With Duration")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #10, Filter work With Duration")
	public void filerWorkWithNumber() throws InterruptedException {
		logger.info("Starting of the filerWorkWithNumber method");

		workfilter.filterWorkWithNumber(filtersDataProp.getProperty("work.Number"));

		Assert.assertEquals(workfilter.isWorkNumberFieldDisplayed(), filtersDataProp.getProperty("work.Number"));

		logger.info("Ending the filerWorkWithNumber Method");

	}
	
	@Test(priority = 11, description = "Filter work With Time", groups = { "sanity" })
	@Description("Test Case #11, Filter work With Time")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #11, Filter work With Time")
	public void filerWorkWithTime() throws InterruptedException {
		logger.info("Starting of the filerWorkWithTime method");

		workfilter.filterWorkWithTime(filtersDataProp.getProperty("work.TimeStart"), filtersDataProp.getProperty("work.TimeEnd"));

		Assert.assertEquals(workfilter.isWorkTimeFieldDisplayed(), filtersDataProp.getProperty("work.TimeEnd"));

		logger.info("Ending the filerWorkWithTime Method");

	}
	
	@Test(priority = 12, description = "Filter work With Email", groups = { "sanity" })
	@Description("Test Case #12, Filter work With Email")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #12, Filter work With Email")
	public void filerWorkWithEmail() throws InterruptedException {
		logger.info("Starting of the filerWorkWithEmail method");

		workfilter.filterWorkWithEmail(filtersDataProp.getProperty("work.Email"));

		Assert.assertEquals(workfilter.isWorkEmailFieldDisplayed(), filtersDataProp.getProperty("work.TimeEnd"));

		logger.info("Ending the filerWorkWithEmail Method");

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
