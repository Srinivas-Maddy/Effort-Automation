package com.effort.test.forms;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
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
	@Parameters({"siteURL","browser"})
	public void initEffortLogin(String siteUrl,String browser) throws Exception {
		logger.info("starting of initEfforrt Login Method in Form Submission Class");
		this.driver=this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
		this.goToSite(siteUrl, driver);
		this.formSub=new FormSubmission(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		logger.info("Ending of initEffortLogin method in Form Submission Class");			
	}
	
	
	@Test(priority=1)
	@Description("Submit the all fields in the form")
	@Story("Add Form")
	public void submitForm() throws InterruptedException, IOException {
		logger.info("Starting of form submit method");
		this.formSub.clickWebApp();
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
		this.formSub.audioData();
		this.formSub.documentUpload();
		this.formSub.imageUpload();
		this.formSub.videoUpload();
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
	public void logOutForm() {
		logger.info("Starting of Log-out Method");
		formSub.logOut();	
		logger.info("Ending of log-out Method");
	}
		

}
