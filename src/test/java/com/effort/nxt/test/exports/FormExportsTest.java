package com.effort.nxt.test.exports;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.exports.FormExportPage;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class FormExportsTest extends BaseAutomationTest{
	
	private static final Logger logger=Logger.getLogger(FormExportsTest.class);
	private FormExportPage formExportPage;
    private final String EXPECTED_EXPORT_SELECTED_STATUS="Data download process is successful.";
	
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL","browser", "headless"})
	public void initEffortLogin(String siteUrl,String browser, String headless) throws Exception {
		logger.info("starting of initEfforrt Login Method in work creation process");
		this.driver=this.getWebDriver(browser, headless, WebDriversEnum.FORM_EXPORTS_DRIVER);
		this.goToSite(siteUrl, driver);
		this.formExportPage=new FormExportPage(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
	
		logger.info("Ending of initEffortLogin method in Work Creation process");			
	}
	
	@Test(priority = 1, description = "Export selected functionality in forms", groups = {"sanity"})
	@Description("We are exporting the selected form submission data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Export Forms Selected Functionalioty")
	public void formExportSelected() throws InterruptedException {
		logger.info("Starting of formExportSelected method");
		loginPage.ClickonWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		this.formExportPage.clickOnFormsModule();
		this.formExportPage.clickOnForm(formDataProp.getProperty("formSpecName"));
		//this.formExportPage.clickOnLast30DaysData(formDataProp.getProperty("last30DaysData"));
		this.formExportPage.selecAllCheckBox();
		this.formExportPage.clickOnExportDrodDown();
		String actulStatusMsg=this.formExportPage.clickOnExportSelected(formDataProp.getProperty("exportSelected"));
		Assert.assertEquals(actulStatusMsg, EXPECTED_EXPORT_SELECTED_STATUS);
		logger.info("Ending of formExportSelected method");
		
	}
	
//	@AfterClass(alwaysRun = true)
//	public void logOutForm() {
//		logger.info("Starting of Log-out Method");
//		this.formExportPage.logOut();	
//		logger.info("Ending of log-out Method");
//	}
	
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
