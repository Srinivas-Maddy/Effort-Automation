package com.effort.test.forms;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.forms.FormSubmission;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class FormSubmissionTest extends BaseAutomationTest{
	
	private static final Logger logger = Logger.getLogger(FormSubmissionTest.class.getName());

	private FormSubmission formSub;
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL","browser", "headless","userName","password"})
	public void initEffortLogin(String siteUrl,String browser, String headless, String userName, String password) throws Exception {
		logger.info("starting of initEfforrt Login Method in Form Submission Class");
		
		this.driver=this.getWebDriver(browser, headless, WebDriversEnum.FORM_SUBMISSION_DRIVER);
		this.goToSite(siteUrl, driver);
		this.formSub=new FormSubmission(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(userName);
		this.loginPage.clickOnPassword(password);
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(userName,password);
		
		logger.info("Ending of initEffortLogin method in Form Submission Class");			
	}
	
	
	@Test(priority=1)
	@Description("Submit the all fields in the form")
	@Story("Add Form")
	public void submitForm() throws InterruptedException, IOException {
		logger.info("Starting of form submit method");
		
		loginPage.ClickonWebApp();
		this.formSub.clickOnForms();
		this.formSub.sendFormName(testDataProp.getProperty("formName"));
		this.formSub.clickOnFormName();
		this.formSub.clickOnAddFormBtn();
		this.formSub.switchNewWindow();
		this.formSub.enterCurrency(formDataProp.getProperty("currency"));
		this.formSub.clickOnDatePicker();
		this.formSub.clickOnCurrentDate();
		this.formSub.clickOnDateTimePicker();
		this.formSub.clickOnCurrentDateTime();
		this.formSub.enterDuration(formDataProp.getProperty("Duration"));
		this.formSub.ClickOnMonthPicker();
		this.formSub.clickOnCurrentMonth();
		this.formSub.enterNumberData(formDataProp.getProperty("Number"));
		this.formSub.enterTextData(formDataProp.getProperty("Text"));
		this.formSub.pickTime();
		this.formSub.enterEmail(formDataProp.getProperty("Email"));
		this.formSub.manaualLocaionsEneted(formDataProp.getProperty("Lat"), formDataProp.getProperty("long"));
		this.formSub.phoneNumber(formDataProp.getProperty("MobileNumber"));
		this.formSub.URL(formDataProp.getProperty("URL"));
			
		formSub.uploadAudio(USER_DIR + formDataProp.getProperty("formsubmission.audio.mp3"));
		//this.formSub.audioData();
		
		formSub.uploadDocument(USER_DIR + formDataProp.getProperty("formsubmission.document.xlsx"));
		//this.formSub.documentUpload();
		
		formSub.uploadImage(USER_DIR + formDataProp.getProperty("formsubmission.image.jpg"));
		//this.formSub.imageUpload();
		
		formSub.uploadVideo(USER_DIR + formDataProp.getProperty("formsubmission.video.mp4"));
	   //this.formSub.videoUpload();
		
		this.formSub.pickCountry();
		this.formSub.pickCustomer();
		this.formSub.pickCustomerType();
		this.formSub.pickEmployee();
		this.formSub.pickMultiPickCustomer();
		this.formSub.SelectTerritory();
		this.formSub.selectYesOrNo();
		this.formSub.clickOnSave();
		
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
