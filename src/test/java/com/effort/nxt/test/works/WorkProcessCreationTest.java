package com.effort.nxt.test.works;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.nxt.test.BaseAutomationTest;
import com.effort.works.WorkProcessCreation;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class WorkProcessCreationTest extends BaseAutomationTest {

	private static final Logger logger = Logger.getLogger(WorkProcessCreationTest.class.getName());
	private WorkProcessCreation processCreation;

	// Before class test case was execute once class loaded in the jvm
	@BeforeClass(alwaysRun = true)
	@Parameters({ "siteURL", "browser", "headless", "userName", "password" })
	public void initEffortLogin(String siteUrl, String browser, String headless, String userName, String password)
			throws Exception {
		logger.info("starting of initEfforrt Login Method in work creation process");

		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.WORK_PROCESS_CREATION_DRIVER);
		this.goToSite(siteUrl, driver);
		this.processCreation = new WorkProcessCreation(driver);
		this.loginPage = new LoginPage(driver);
		// LoginToApplication(userName, password);
		LoginToApplication(testDataProp.getProperty("config.user"), testDataProp.getProperty("config.password"));

		this.processCreation.clickOnConfigurator();

		logger.info("Ending of initEffortLogin method in Work Creation process");
	}

	@Test(priority = 1, description = "Creating the work spec in configurator", groups = { "sanity" })
	@Description("Test Case #2, Creating the work spec")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2, Creating work Spec")
	public void workSpecCreation() throws InterruptedException {

		logger.info("Starting of the workSpecCreation method");

		processCreation.clickOnProcess();
		processCreation.clickOnActionProcess();
		processCreation.clickOnCreateProcess();
		processCreation.clickOnCreateMyOwnProcess();
		processCreation.workProcessTitle(testDataProp.getProperty("workTitleName"));
		processCreation.workProcessDiscription(testDataProp.getProperty("description"));
		processCreation.clickOnNextBtn();
		processCreation.clickOnAddFieldBtn();
		processCreation.clickOnFirstAddedField();
		processCreation.addUserDefinedFields();
		processCreation.selectActionForms();
		processCreation.clickNextCloneFieldData();
		processCreation.clickNextManageFlow();
		processCreation.clickSkipAutoAllocation();
		processCreation.disableDefaultNotification();
		processCreation.clickNextSetting();
		processCreation.clickOtherSetting();

		logger.info("Ending of the workSpecCreation method");

	}

	@Test(priority = 2, description = "Validating Created Process Spec", groups = { "sanity" })
	@Description("Test Case #2, Validate Created Process")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2, Validate Process")
	public void validationWorkSpec() {
		logger.info("Starting of validateCreateProcess method");

		String expectedWorkSpecName = processCreation.WorkSpecName + " Process Activities";
		String actualWorkSpecName = processCreation.getWorkProcessName();
		Assert.assertEquals(actualWorkSpecName, expectedWorkSpecName);

		logger.info("Ending of validateCreateProcess method");
	}

	@Test(priority = 3, description = "Modifying the Work Spec", groups = { "sanity" })
	@Description("Test Case #3, Modifying work spec")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3, Modifying the Process")
	public void modificationWorkSpec() {
		logger.info("Starting of modificationWorkSpec method");

		this.processCreation.ModifyWorkFields();

		logger.info("Ending of modificationWorkSpec method");

	}

	@Test(priority = 4, description = "Manage fields Card Validation", groups = { "sanity" })
	@Description("Test Case #4, Manage fields Card is able to save without any exceptions")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, Manage fields Cards Validation")
	public void manageFieldsCardValidation() {
		logger.info("Starting of manageFieldsCardValidation method");

		String expectedStatus = this.processCreation
				.modifyManageFieldsCard(expectedAssertionsProp.getProperty("work.process.card.text"));
		Assert.assertEquals(expectedStatus, expectedAssertionsProp.getProperty("work.process.managefields.status"));

		logger.info("Ending of manageFieldsCardValidation method");

	}

	@Test(priority = 5, description = "Manage activities Cards Validation", groups = { "sanity" })
	@Description("Test Case #4, Manage activities Cards is able to save without any exceptions")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, Manage activities Cards Validation")
	public void manageActivitiesCardValidation() {
		logger.info("Starting of manageActivitiesCardValidation method");

		String expectedStatus = this.processCreation.modifyManageActivitiesCard(
				expectedAssertionsProp.getProperty("work.process.manage.activies.card.text"));
		Assert.assertEquals(expectedStatus,
				expectedAssertionsProp.getProperty("work.process.manage.activies.card.status"));

		logger.info("Ending of manageActivitiesCardValidation method");

	}

	@Test(priority = 6, description = "Restrict Employee Groups", groups = { "sanity" })
	@Description("Test Case #4, Employee Group Restriction")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, Employee Group Restiction in app builder")
	public void restrictEmployeeGroup() {
		logger.info("Starting of restrictEmployeeGroup method");

		this.processCreation.restrictAccessGroups(expectedAssertionsProp.getProperty("work.process.restrictEmpGroup"),
				expectedAssertionsProp.getProperty("wor.process.empGroupName"));

		logger.info("Ending of restrictEmployeeGroup method");
	}

	@Test(priority = 7, description = "manage permission configuration", groups = { "sanity" })
	@Description("Test Case #4, manage employee groups")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, Manage employee group permission")
	public void managePermissions() {
		logger.info("Starting of managePermissions method");

		this.processCreation
				.managePermission_Configuration(expectedAssertionsProp.getProperty("work.process.manageEmployeeGroup"));

		logger.info("Ending of managePermissions method");
	}

	@Test(priority = 8, description = "manage activity submission visiblity", groups = { "sanity" })
	@Description("Test Case #4, manage activity submission visiblity")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, manage activity submission visiblity")
	public void manageActivitySubmissionVisiblityConfiguration() {
		logger.info("Starting of manageActivitySubmissionVisiblityConfiguration method");

		this.processCreation.manageActivitySubmissionVisibility_Configuration(
				expectedAssertionsProp.getProperty("work.process.manageActivitySubmissions"));

		logger.info("Ending of managePermissions method");
	}

	@Test(priority = 9, description = "wotk settings configuration", groups = { "sanity" })
	@Description("Test Case #4, We can able to save the configuration")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, Work Setting card save functionality")
	public void workSettingsConfiguration() {
		logger.info("Starting of workSettingsConfiguration method");

		this.processCreation.settingsConfiguration(expectedAssertionsProp.getProperty("work.process.settings"));

		logger.info("Ending of workSettingsConfiguration method");
	}

	@Test(priority = 10, description = "Withdraw Work Spec", groups = { "sanity" })
	@Description("Test Case #4, Withdrawn work spec")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, Withdrawn Process")
	public void withDrawWorkSpec() {
		logger.info("Starting of withDrawWorkSpec method");

		this.processCreation.withDrawWorkSpec();

		logger.info("Ending of withDrawWorkSpec method");
	}

	@Test(priority = 11, description = "Create the activity process in the home screen", groups = { "sanity" })
	@Description("Test Case #4, Created the activity process in home screen")
	@Severity(SeverityLevel.BLOCKER)
	@Story("ACTION PROCESS CONFIGURATION")
	public void createActionProcessInHomeScreen() throws InterruptedException {
		logger.info("Starting of createActionProcessInHomeScreen Method");

		this.processCreation.clickOnHome();
		this.processCreation.clickOnCreateProcessInHomeScreen();
		processCreation.workProcessTitle(testDataProp.getProperty("workTitleName"));
		processCreation.workProcessDiscription(testDataProp.getProperty("description"));
		processCreation.clickOnNextBtn();
		processCreation.clickOnAddFieldBtn();
		processCreation.clickOnFirstAddedField();
		processCreation.addUserDefinedFields();
		processCreation.selectActionForms();
		processCreation.clickNextCloneFieldData();
		processCreation.clickNextManageFlow();
		processCreation.clickSkipAutoAllocation();
		processCreation.disableDefaultNotification();
		processCreation.clickNextSetting();
		processCreation.clickOtherSetting();

		logger.info("Ending of createActionProcessInHomeScreen Method");
	}

	@Test(priority = 12, description = "WithDraw the work spec it was created on home screen", groups = { "sanity" })
	@Description("Test Case #12, Withdrawn spec it was created on home")
	@Severity(SeverityLevel.BLOCKER)
	@Story("ACTION PROCESS CONFIGURATION")
	public void withWorkSpecHomeScreen() {
		logger.info("Starting of withWorkSpecHomeScreen Method");

		processCreation.withDrawSpecInHome();

		logger.info("Starting of withWorkSpecHomeScreen Method");
	}

	@Test(priority = 13, description = "WithDraw all active work specs", groups = { "sanity" }, enabled = false)
	@Description("Test Case #13, Withdrawn all work specs")
	@Severity(SeverityLevel.BLOCKER)
	@Story("ACTION PROCESS CONFIGURATION")
	public void withDrawAllWorkSpecs() {
		logger.info("Starting of withDrawAllWorkSpecs Method");

		processCreation.clickOnProcess();
		processCreation.clickOnActionProcess();
		processCreation.withDrawAllSpecs();

		logger.info("Ending of withDrawAllWorkSpecs Method");
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
