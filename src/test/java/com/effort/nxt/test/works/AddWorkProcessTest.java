package com.effort.nxt.test.works;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.filters.WorkFiltersPage;
import com.effort.forms.FormSubmission;
import com.effort.nxt.test.BaseAutomationTest;
import com.effort.works.AddWorkProcess;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AddWorkProcessTest extends BaseAutomationTest {

	private static final Logger logger = Logger.getLogger(AddWorkProcessTest.class);
	private AddWorkProcess addWork;
	private FormSubmission addwork;
	private WorkFiltersPage workfilter;

	// Before class test case was execute once class loaded in the jvm
	@BeforeClass(alwaysRun = true)
	@Parameters({ "siteURL", "browser", "userName", "password", "headless" })
	public void initEffortLogin(String siteURL, String browser, String userName, String password, String headless)
			throws Exception {
		logger.info("starting of initEfforrt Login Method in work creation process");
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.ADD_WORK_PROCESS_DRIVER);
		this.goToSite(siteURL, driver);
		this.addWork = new AddWorkProcess(driver);
		this.loginPage = new LoginPage(driver);
		this.addwork = new FormSubmission(driver);
		this.workfilter = new WorkFiltersPage(driver);
		LoginToApplication(userName, password);

		logger.info("Ending of initEffortLogin method in Work Creation process");
	}

	String smartWorkID;

	@Test(priority = 1, description = "Add the work in the web app", groups = { "sanity" })
	@Description("Test Case #1, Assigning the work")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, Assign the work to the user")
	public void AddWork() throws InterruptedException {
		logger.info("Starting of the AddWork method");

		loginPage.ClickonWebApp();

		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		this.addWork.clickOnProcessModule();
		this.addWork.clickOnWorkName();
		this.addWork.clickOnAddWorkBtn();
		this.addWork.enterWorkName(formDataProp.getProperty("WorkName") + addWork.getCurrentDateTime());
		this.addWork.clickOnWorkEndDate();
		this.addWork.clickOnCurrentDateTime();
		// this.addWork.pickWorkEndDate();
		this.addWork.enterTextData(formDataProp.getProperty("Text"));
		this.addwork.enterCurrency(formDataProp.getProperty("currency"));
		this.addWork.clickOnDatePicker(formDataProp.getProperty("formDate"));
		this.addwork.enterDuration(formDataProp.getProperty("Duration"));
		this.addWork.enterNumberData(formDataProp.getProperty("Number"));
		this.addWork.enterTextData(formDataProp.getProperty("Text"));
		this.addWork.pickTime(formDataProp.getProperty("formTime"));
		this.addwork.enterEmail(formDataProp.getProperty("Email"));
		this.addwork.manaualLocaionsEneted(formDataProp.getProperty("Lat"), formDataProp.getProperty("long"));
		this.addwork.phoneNumber(formDataProp.getProperty("MobileNumber"));
		this.addwork.URL(formDataProp.getProperty("URL"));

		addwork.uploadAudio(USER_DIR + formDataProp.getProperty("formsubmission.audio.mp3"));
		// this.formSub.audioData();

		addwork.uploadDocument(USER_DIR + formDataProp.getProperty("formsubmission.document.xlsx"));
		// this.formSub.documentUpload();

		addwork.uploadImage(USER_DIR + formDataProp.getProperty("formsubmission.image.jpg"));
		// this.formSub.imageUpload();

		addwork.uploadVideo(USER_DIR + formDataProp.getProperty("formsubmission.video.mp4"));
		// this.formSub.videoUpload();

		this.addWork.pickCountry();
		this.addwork.pickCustomer();
		this.addWork.pickCustomerType();
		this.addWork.pickEmployee();

		this.addWork.SelectTerritory();
		this.addWork.selectYesOrNo();
		// addWork.selectCustomEntity();
		addWork.SelectDropdown();
		addWork.SelectMultiDropdown();
		addWork.uploadMultiImage(USER_DIR + formDataProp.getProperty("formsubmission.image.jpg"));

		addWork.uploadMultiDocument(USER_DIR + formDataProp.getProperty("formsubmission.document.xlsx"));

		addWork.pickMultiPickList();
		// addWork.formField();
		addWork.pickListField();
		addWork.clickOnSectionAddButton();
		addWork.enterTextDataInSection(formDataProp.getProperty("Text"));

		this.addWork.enterCurrencyInSection(formDataProp.getProperty("currency"));

		this.addWork.SetDateInSection(formDataProp.getProperty("formDate"));

		this.addWork.enterEmailInSection(formDataProp.getProperty("Email"));

		this.addWork.enterNumberInSection(formDataProp.getProperty("Number"));

		this.addWork.phoneNumberInSection(formDataProp.getProperty("MobileNumber"));

		this.addWork.assignEmplpoyee(formDataProp.getProperty("AssignEmployee"));

		this.addWork.clickOnSave();

		Assert.assertTrue(addWork.isWorkAddedSucessfully());

		addWork.getWorkId();

		logger.info("Ending the Addwork Method");
	}

	@Test(priority = 2, description = "modify the work in the web app", groups = { "sanity" })
	@Description("Test Case #2, modify the work in the web app")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2, modify the work in the web app")
	public void ModifyWork() throws InterruptedException {
		logger.info("Starting of the ModifyWork method");

		addWork.clickOnEditIcn();

		this.addWork.enterWorkName(formDataProp.getProperty("WorkModified") + addWork.getCurrentDateTime());

		this.addWork.clickOnSave();

		Assert.assertTrue(addWork.isWorkModifiedSucessfully());

		logger.info("Ending the ModifyWork Method");
	}

	@Test(priority = 3, description = "Reassign the work", groups = { "sanity" })
	@Description("Test Case #3, Reassign the work")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3, Reassign the work")
	public void reaasignWork() throws InterruptedException {
		logger.info("Starting of the reaasignWork method");

		addWork.clickOnWorkSelectButton();

		addWork.clickOnReaAsignWork();

		addWork.clickOnSelectEmployee();

		addWork.clickOnSeachEmp(formDataProp.getProperty("empName"));

		addWork.clickOnEmp();

		addWork.assignWork();

		Assert.assertTrue(addWork.isWorkReassignedSucessfully());

		logger.info("Ending the reaasignWork Method");
	}

	@Test(priority = 4, description = "Complete work", groups = { "sanity" })
	@Description("Test Case #4, Complete work")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, Complete work")
	public void completeWork() throws InterruptedException {
		logger.info("Starting of the completeWork method");

		addWork.clickOnWorkId();

		this.ActionWork();

		this.smartWorkActionWork();

		this.smartWorkActionWork();

		Assert.assertTrue(addWork.isWorkCompletedSucessfully());

		logger.info("Ending the completeWork Method");
	}

	@Test(priority = 5, description = "Work Attachement", groups = { "sanity" })
	@Description("Test Case #5, work Attachement")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #5, work Attachement")
	public void workAttachement() throws InterruptedException {
		logger.info("Starting of the workAttachement method");

		addWork.clickOnAddWorkAttachmentButton();

		addWork.clickOnWorkAttachmentButton();

		addwork.enterCurrency(formDataProp.getProperty("currency"));

		addwork.clickOnSave();

		addWork.clickOnAttachmentViewButton();

		Assert.assertTrue(addWork.isWorkAttachmentAddedSucessfully());

		logger.info("Ending the workAttachement Method");
	}

	@Test(priority = 6, description = "Delete select work", groups = { "sanity" })
	@Description("Test Case #6, Delete select work")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #6, Delete select work")
	public void deleteSelectedWork() throws InterruptedException {
		logger.info("Starting of the deleteSelectedWork method");

		this.addWork.clickOnProcessModule();
		this.addWork.clickOnWorkName();

		addWork.filterWork();

		addWork.clickOnWorkSelectButton();

		addWork.deleteSelectedWork();

		addWork.filterWork();

		Assert.assertTrue(addWork.isWorkdDeletedSucessfully());

		logger.info("Ending the deleteSelectedWork Method");
	}

	@Test(priority = 7, description = "Verify works matrix", groups = "sanity")
	@Description("Verify works matrix")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify works matrix")
	public void workMatrixValidation() {
		logger.info("Starting of workMatrixValidation Method");

		Assert.assertTrue(addWork.isYetToStartCountDisplayed());

		if (addWork.matrixCount() > 0) {
			Assert.assertEquals(workfilter.isYetToStartWorksDisplayed(),
					filtersDataProp.getProperty("yetToStart.work"));

		}

		Assert.assertTrue(addWork.isUnassignedCountDisplayed());

		if (addWork.matrixCount() > 0) {
			Assert.assertTrue(workfilter.isWorkAssignEmpFieldDisplayed());

		}

		Assert.assertTrue(addWork.isRejectedCountDisplayed());

		if (addWork.matrixCount() > 0) {
			Assert.assertEquals(workfilter.workStatusDisplayed(), filtersDataProp.getProperty("rejected.work"));

		}

		Assert.assertTrue(addWork.isInProgressCountDisplayed());

		Assert.assertTrue(addWork.isCompletedCountDisplayed());

		if (addWork.matrixCount() > 0) {
			Assert.assertEquals(workfilter.workStatusDisplayed(), filtersDataProp.getProperty("completed.work"));

		}

		Assert.assertTrue(addWork.isYoursCountDisplayed());

		if (addWork.matrixCount() > 0) {
			Assert.assertEquals(workfilter.isWorkAssignEmployeeFieldDisplayed(),
					filtersDataProp.getProperty("Work.EmpName"));

		}

		Assert.assertTrue(addWork.isTeamCountDisplayed());

		if (addWork.matrixCount() > 0) {
			Assert.assertEquals(workfilter.isWorkAssignEmployeeFieldDisplayed(),
					filtersDataProp.getProperty("work.underEmpName"));

		}

		logger.info("Ending of workMatrixValidation Method");
	}

	@Test(priority = 8, description = "Verify works progress bar", groups = "sanity")
	@Description("Verify works progress bar")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify works progress bar")
	public void workProgressBarValidation() {
		logger.info("Starting of workProgressBarValidation Method");

		Assert.assertTrue(addWork.ispendingCountDisplayed());

		Assert.assertTrue(addWork.yoursCountDisplayed());

		if (addWork.matrixCount() > 0) {
			Assert.assertEquals(workfilter.isWorkAssignEmployeeFieldDisplayed(),
					filtersDataProp.getProperty("Work.EmpName"));

		}

		Assert.assertTrue(addWork.teamActionableCountDisplayed());

		if (addWork.matrixCount() > 0) {
			Assert.assertEquals(workfilter.isWorkAssignEmployeeFieldDisplayed(),
					filtersDataProp.getProperty("work.underEmpName"));

		}

		Assert.assertTrue(addWork.updatedTodayCountDisplayed());

		logger.info("Ending of workProgressBarValidation Method");
	}

	@Test(priority = 9, description = "Delete filtered work", groups = { "sanity" })
	@Description("Test Case #9, Delete filtered work")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #9, Delete filtered work")
	public void deleteFilteredWork() throws InterruptedException {
		logger.info("Starting of the deleteFilteredWork method");

		this.addWork.clickOnAddWorkBtn();

		this.addWork.enterWorkName(formDataProp.getProperty("WorkName") + addWork.getCurrentDateTime());

		this.addWork.enterTextData(formDataProp.getProperty("Text"));

		this.addWork.clickOnSaveWhileNewAdd();

		Assert.assertTrue(addWork.isWorkAddedSucessfully());

		addWork.getWorkId();

		addWork.filterWork();

		addWork.deleteFilteredWork();

		addWork.filterWork();

		Assert.assertTrue(addWork.isWorkdDeletedSucessfully());

		logger.info("Ending the deleteFilteredWork Method");
	}

	@Test(priority = 10, description = "Smart work Creation", groups = { "sanity" })
	@Description("Test Case #10, Smart Work Creation")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #10, Smart work creation")
	public void smartWorkCreation() throws InterruptedException {
		logger.info("Starting of the smartWorkCreation method");

		this.addWork.clickOnProcessModule();
		this.addWork.clickOnSmartWorkName();

		this.addWork.clickOnAddWorkBtn();

		this.addWork.enterWorkName(formDataProp.getProperty("smartWorkName") + addWork.getCurrentDateTime());
		this.addWork.clickOnWorkEndDate();
		this.addWork.clickOnCurrentDateTime();
		this.addWork.smartWorkEmplpoyee(formDataProp.getProperty("AssignEmployee"));

		this.addWork.assignSmartWorkEmplpoyee(formDataProp.getProperty("AssignEmployee"));

		this.addWork.clickOnSave();

		Assert.assertTrue(addWork.isWorkAddedSucessfully());

		smartWorkID = addWork.getSmartWorkId();

		logger.info("Ending the smartWorkCreation Method");
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 11, description = "Smart work Complete", groups = { "sanity" })
	@Description("Test Case #11, Smart Work Complete")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #11, Smart work Complete")
	public void smartWorkComplete(String userName, String password) throws InterruptedException {
		logger.info("Starting of the smartWorkComplete method");

		loginPage.logOutForSmartWork();

		this.loginPage.enterUserName(formDataProp.getProperty("smartWorkUserName"));
		this.loginPage.clickOnPassword(formDataProp.getProperty("smartWorkUserPassword"));
		this.loginPage.clickOnLoginButton();
		this.loginPage.clickOnSignOutFromAllSessions(formDataProp.getProperty("smartWorkUserName"),
				formDataProp.getProperty("smartWorkUserPassword"));

		loginPage.ClickonWebApp();
		this.addWork.clickOnProcessModule();
		this.addWork.clickOnSmartWorkName();
		workfilter.filterWorkWithId(smartWorkID);

		addWork.clickOnWorkId();

		addWork.clickOnAccept();
		addWork.clickOnOkButton();
		for (int i = 0; i < 7; i++) {

			this.smartWorkActionWork();
		}

		addWork.clickOnAccept();

		this.smartWorkActionWork();

		this.smartWorkActionWork();

		loginPage.logOutForSmartWork();

		LoginToApplication(userName, password);

		loginPage.ClickonWebApp();
		this.addWork.clickOnProcessModule();
		this.addWork.clickOnSmartWorkName();
		workfilter.filterWorkWithId(smartWorkID);

		addWork.clickOnWorkId();

		this.smartWorkActionWork();

		Assert.assertTrue(addWork.isWorkCompletedSucessfully());

		logger.info("Ending the smartWorkComplete Method");
	}

	public void ActionWork() throws InterruptedException {
		logger.info("Starting of the completeWork method");

		addWork.clickOnWorkActionButton();

		this.addwork.enterCurrency(formDataProp.getProperty("currency"));
		this.addwork.clickOnDatePicker();
		this.addwork.clickOnCurrentDate();
		this.addwork.clickOnDateTimePicker();
		this.addwork.clickOnCurrentDateTime();
		this.addwork.enterDuration(formDataProp.getProperty("Duration"));
		this.addwork.ClickOnMonthPicker();
		this.addwork.clickOnCurrentMonth();
		this.addwork.enterNumberData(formDataProp.getProperty("Number"));
		this.addwork.enterTextData(formDataProp.getProperty("Text"));
		this.addwork.pickTime();
		this.addwork.enterEmail(formDataProp.getProperty("Email"));
		this.addwork.manaualLocaionsEneted(formDataProp.getProperty("Lat"), formDataProp.getProperty("long"));
		this.addwork.phoneNumber(formDataProp.getProperty("MobileNumber"));
		this.addwork.URL(formDataProp.getProperty("URL"));

		addwork.uploadAudio(USER_DIR + formDataProp.getProperty("formsubmission.audio.mp3"));
		// this.formSub.audioData();

		addwork.uploadDocument(USER_DIR + formDataProp.getProperty("formsubmission.document.xlsx"));
		// this.formSub.documentUpload();

		addwork.uploadImage(USER_DIR + formDataProp.getProperty("formsubmission.image.jpg"));
		// this.formSub.imageUpload();

		addwork.uploadVideo(USER_DIR + formDataProp.getProperty("formsubmission.video.mp4"));
		// this.formSub.videoUpload();

		this.addwork.pickCountry();
		this.addwork.pickCustomer();
		this.addwork.pickCustomerType();
		this.addwork.pickEmployee();
		this.addwork.pickMultiPickCustomer();
		this.addwork.SelectTerritory();
		this.addwork.selectYesOrNo();
		this.addwork.clickOnSave();

		logger.info("Ending the completeWork Method");
	}

	public void smartWorkActionWork() throws InterruptedException {
		logger.info("Starting of the smartWorkActionWork method");

		addWork.clickOnWorkActionButton();

		this.addwork.enterCurrency(formDataProp.getProperty("currency"));

		this.addwork.clickOnSave();

		logger.info("Ending the smartWorkActionWork Method");
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
