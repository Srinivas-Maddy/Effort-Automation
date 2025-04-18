package com.effort.test.forms;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.forms.Forms;
import com.effort.nxt.test.BaseAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class FormsTest extends BaseAutomationTest{

	private static final Logger logger=Logger.getLogger(FormsTest.class.getName());
	private Forms forms;
	private String formSpecExpectedTitle=null;
	

	//Before class test case was execute once class loaded in the jvm
	@BeforeClass (alwaysRun = true)
	@Parameters({"siteURL","browser"})
	public void initEffortLogin(String siteUrl,String browser) throws Exception {
		logger.info("starting of initEfforrt Login Method in work creation process");
		this.driver=this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
		this.goToSite(siteUrl, driver);
		this.forms=new Forms(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		this.forms.clickOnConfigurator();
		logger.info("Ending of initEffortLogin method in Work Creation process");			
	}
	
	
	@Test(priority = 1, description="Creating the Form spec in configurator", groups = {"sanity"})
	@Description("Form Spec Creation on Configurator Module")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Form Spec Creation in the navigation bar")
	public void formSpecCreation() throws InterruptedException {
		logger.info("Starting of formSpecCreation Method");
		forms.clickOnFormsModuleNavBar();
		forms.clickOnCreateForm();
		formSpecExpectedTitle=forms.formTitle(testDataProp.getProperty("formSpecTitle"), testDataProp.getProperty("helpText"));
		forms.selectAllFields();
		logger.info("Ending of formSpecCreation Method");

	}
	
	@Test(priority = 2, description="Form Spec Validation", groups = {"sanity"})
	@Description("Validating the form spec is created or not")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Form spec validation after created")
	public void formSpecValidation() {
		logger.info("Starting of formSpecValidation Method");
		String expectedFormSpecName=Forms.formSpecName+" Actions";
		String actualFormSpecName=forms.formSpecValidation();
		Assert.assertEquals(expectedFormSpecName, actualFormSpecName);
		logger.info("Ending of formSpecCreation Method");		
	}
	
	
	@Test(priority = 3, description="Form Spec Modification", groups = {"sanity"})
	@Description("Validating the form spec is created or not")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Form spec validation after created")
	public void formSpecModification() {
		logger.info("Starting of Form Modification Method");
		forms.formSpecModification();
		logger.info("Ending of formSpecCreation Method");		
	}
	
		
	@Test(priority = 4, description="Withdrawn the form spec in configurator", groups = {"sanity"})
	@Description("Form Spec Withdrawn in the configurator")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Form spec withdrawn")
	public void formSpecWithDrawn() {
		logger.info("Starting of Withdrawn Method");
		forms.withDrawnForm();
		logger.info("Ending of formSpecCreation Method");		
	}
	
	
	
	
	@AfterClass(alwaysRun = true)
	public void logOutForm() {
		logger.info("Starting of Log-out Method");
		forms.logOut();	
		logger.info("Ending of log-out Method");
	}

}
