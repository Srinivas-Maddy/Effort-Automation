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

	@Test(priority = 5, description = "Filter work With assign Employee", groups = { "sanity" })
	@Description("Test Case #5, Filter work With assign Employee")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #5, Filter work With assign Employee")
	public void filerWorkWithAssignEmployeeName() throws InterruptedException {
		logger.info("Starting of the filerWorkWithAssignEmployeeName method");

		workfilter.filterWorkWithAssignEmployeeName(filtersDataProp.getProperty("Work.EmpName"));

		Assert.assertEquals(workfilter.isWorkAssignEmployeeFieldDisplayed(), filtersDataProp.getProperty("Work.EmpName"));

		logger.info("Ending the filerWorkWithAssignEmployeeName Method");

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

		Assert.assertEquals(workfilter.isWorkEmailFieldDisplayed(), filtersDataProp.getProperty("work.Email"));

		logger.info("Ending the filerWorkWithEmail Method");

	}
	
	@Test(priority = 13, description = "Filter work With Phone", groups = { "sanity" })
	@Description("Test Case #13, Filter work With Phone")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #13, Filter work With Phone")
	public void filerWorkWithPhone() throws InterruptedException {
		logger.info("Starting of the filerWorkWithPhone method");

		workfilter.filterWorkWithPhone(filtersDataProp.getProperty("work.Phone"));

		Assert.assertEquals(workfilter.isWorkPhoneFieldDisplayed(), filtersDataProp.getProperty("work.Phone"));

		logger.info("Ending the filerWorkWithPhone Method");

	}
	
	@Test(priority = 14, description = "Filter work With Country", groups = { "sanity" })
	@Description("Test Case #14, Filter work With Country")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #14, Filter work With Country")
	public void filerWorkWithCountry() throws InterruptedException {
		logger.info("Starting of the filerWorkWithCountry method");

		workfilter.filterWorkWithCountry(filtersDataProp.getProperty("work.Country"));

		Assert.assertEquals(workfilter.isWorkCountryFieldDisplayed(), filtersDataProp.getProperty("work.Country"));

		logger.info("Ending the filerWorkWithCountry Method");

	}
	
	@Test(priority = 15, description = "Filter work With Customer", groups = { "sanity" })
	@Description("Test Case #15, Filter work With Customer")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #15, Filter work With Customer")
	public void filerWorkWithCustomer() throws InterruptedException {
		logger.info("Starting of the filerWorkWithCustomer method");

		workfilter.filterWorkWithCustomer(filtersDataProp.getProperty("work.Customer"));

		Assert.assertEquals(workfilter.isWorkCustomerFieldDisplayed(), filtersDataProp.getProperty("work.Customer"));

		logger.info("Ending the filerWorkWithCustomer Method");

	}
	
	@Test(priority = 16, description = "Filter work With Customer Type", groups = { "sanity" })
	@Description("Test Case #16, Filter work With Customer Type")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #16, Filter work With Customer Type")
	public void filerWorkWithCustomerType() throws InterruptedException {
		logger.info("Starting of the filerWorkWithCustomerType method");

		workfilter.filterWorkWithCustomerType(filtersDataProp.getProperty("work.CustomerType"));

		Assert.assertEquals(workfilter.isWorkCustomerFieldDisplayed(), filtersDataProp.getProperty("work.CustomerType"));

		logger.info("Ending the filerWorkWithCustomerType Method");

	}
	
	@Test(priority = 17, description = "Filter work With Employee", groups = { "sanity" })
	@Description("Test Case #17, Filter work With Employee")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #17, Filter work With Employee")
	public void filerWorkWithEmployeeName() throws InterruptedException {
		logger.info("Starting of the filerWorkWithEmployeeName method");

		workfilter.filterWorkWithEmployeeName(filtersDataProp.getProperty("Work.EmpName"));

		Assert.assertEquals(workfilter.isWorkEmployeeFieldDisplayed(), filtersDataProp.getProperty("Work.EmpName"));

		logger.info("Ending the filerWorkWithEmployeeName Method");

	}	
	
	@Test(priority = 18, description = "Filter work With Territory", groups = { "sanity" })
	@Description("Test Case #18, Filter work With Territory")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #18, Filter work With Territory")
	public void filerWorkWithTerritory() throws InterruptedException {
		logger.info("Starting of the filerWorkWithTerritory method");

		workfilter.filterWorkWithTeerritory(filtersDataProp.getProperty("work.Territory"));

		Assert.assertEquals(workfilter.isWorkTerritoryFieldDisplayed(), filtersDataProp.getProperty("work.Territory"));

		logger.info("Ending the filerWorkWithTerritory Method");

	}	
	
	@Test(priority = 19, description = "Filter work With YesOrNo", groups = { "sanity" })
	@Description("Test Case #19, Filter work With YesOrNo")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #19, Filter work With YesOrNo")
	public void filerWorkWithYesOrNo() throws InterruptedException {
		logger.info("Starting of the filerWorkWithTerritory method");

		workfilter.filterWorkWithYesOrNo();

		Assert.assertEquals(workfilter.isWorkYesOrNoFieldDisplayed(), filtersDataProp.getProperty("work.YesOrNo"));

		logger.info("Ending the filerWorkWithYesOrNo Method");

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
