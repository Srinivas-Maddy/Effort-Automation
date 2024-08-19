package com.effort.nxt.test.works;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
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
	private FormSubmission addWork1;

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
		this.addWork1 = new FormSubmission(driver);

		LoginToApplication(userName, password);

		logger.info("Ending of initEffortLogin method in Work Creation process");
	}

    @Test(priority = 1, description = "Add the work in the web app", groups ={"sanity" })
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
		this.addWork1.enterCurrency(formDataProp.getProperty("currency"));
		this.addWork.clickOnDatePicker(formDataProp.getProperty("formDate"));
		this.addWork1.enterDuration(formDataProp.getProperty("Duration"));
		this.addWork.enterNumberData(formDataProp.getProperty("Number"));
		this.addWork.enterTextData(formDataProp.getProperty("Text"));
		this.addWork.pickTime(formDataProp.getProperty("formTime"));
		this.addWork1.enterEmail(formDataProp.getProperty("Email"));
		this.addWork1.manaualLocaionsEneted(formDataProp.getProperty("Lat"), formDataProp.getProperty("long"));
		this.addWork1.phoneNumber(formDataProp.getProperty("MobileNumber"));
		this.addWork1.URL(formDataProp.getProperty("URL"));

		addWork1.uploadAudio(USER_DIR + formDataProp.getProperty("formsubmission.audio.mp3"));
		// this.formSub.audioData();

		addWork1.uploadDocument(USER_DIR + formDataProp.getProperty("formsubmission.document.xlsx"));
		// this.formSub.documentUpload();

		addWork1.uploadImage(USER_DIR + formDataProp.getProperty("formsubmission.image.jpg"));
		// this.formSub.imageUpload();

		addWork1.uploadVideo(USER_DIR + formDataProp.getProperty("formsubmission.video.mp4"));
		// this.formSub.videoUpload();

		this.addWork.pickCountry();
		this.addWork1.pickCustomer();
		this.addWork.pickCustomerType();
		this.addWork.pickEmployee();

		this.addWork.SelectTerritory();
		this.addWork.selectYesOrNo();
		addWork.selectCustomEntity();
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

		logger.info("Ending the Addwork Method");
	}

	@Test(priority = 2, description = "modify the work in the web app", groups ={ "sanity" })
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

	@Test(priority = 4, description = "Delete select work", groups = { "sanity" })
	@Description("Test Case #4, Delete select work")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #4, Delete select work")
	public void deleteSelectedWork() throws InterruptedException {
		logger.info("Starting of the deleteSelectedWork method");

		addWork.getWorkId();

		addWork.clickOnWorkSelectButton();

		addWork.deleteSelectedWork();

		addWork.filterWork();

		Assert.assertTrue(addWork.isWorkdDeletedSucessfully());

		logger.info("Ending the deleteSelectedWork Method");
	}

	@Test(priority = 5, description = "Delete filtered work", groups = { "sanity" })
	@Description("Test Case #5, Delete filtered work")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #5, Delete filtered work")
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
