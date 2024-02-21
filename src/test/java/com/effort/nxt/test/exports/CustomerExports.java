package com.effort.nxt.test.exports;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.exports.CustomerExportPage;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CustomerExports extends BaseAutomationTest {
	private static final Logger logger = Logger.getLogger(CustomerExports.class);
	private CustomerExportPage custmrExpt=null;
	private static final String EXPECTEDEXPORTCNFRMMSG = "The report will be emailed to the registered email address when it is ready.";
	private static final String EXPECTEDEXPORTSELECTEDSUCCESSMSG = "Data download process is successful.";
	private static final String EXPECTEDEXPORTFILTEREDSUCCESMSG="Data download process is successful.";
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" , "browser", "headless"})
	public void initEffortLogin(String siteUrl , String browser, String headless) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.CUSTOMERS_EXPORTS_DRIVER);
		this.goToSite(siteUrl, driver);
		this.custmrExpt = new CustomerExportPage(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
	
		logger.info("Ending of initEffortLogin Method");
	}
	
	@Test(priority = 1 ,description = "Go to Customer module and downlooad export all" ,groups = "sanity")
	@Description("Download Customer Export All")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Downloading Customer Export All Excell Sheet")
	public void CustmrExportAll() throws InterruptedException {
		logger.info("Starting of CustmrExportAll Method");
		loginPage.ClickonWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		custmrExpt.ClickonCustomerModule();
		custmrExpt.ClickonExport();
		custmrExpt.SelcetExportAll();
		custmrExpt.ExportConfirm();
		custmrExpt.SwitchtoNewWindow();
		String actualExptCnfrmMsg = custmrExpt.ExportConfirmMsg();
		Assert.assertEquals(actualExptCnfrmMsg, EXPECTEDEXPORTCNFRMMSG);
		logger.info("Ending of CustmrExportAll Method");
		
	}
	
	@Test(priority = 2, description = "Go to Customer Module and Select Export Selected" , groups="sanity")
	@Description("Download Export Selected Customers Excell Sheet")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Downloading the Export Selected Excell Sheet")
	public void customerExportSelected() throws InterruptedException {
		logger.info("Starting of customerExportSelected Method");
		custmrExpt.ClickonCustomerModule();
		custmrExpt.customerSelectionCheckbox();
		custmrExpt.ClickonExport();
		custmrExpt.clickonExportSelected();
		custmrExpt.SwitchtoNewWindow();
		String actualexportselectedscuccessmsg = custmrExpt.exportSelectedSuccessMsg();
		Assert.assertEquals(actualexportselectedscuccessmsg, EXPECTEDEXPORTSELECTEDSUCCESSMSG);	
		logger.info("Ending of customerExportSelected Method");
	}
	

	@Test(priority = 3, description = "Go to customer Module and Select Export Filtered" , groups="sanity")
	@Description("Download Export Filtered Excell Sheet")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Downloading the ExportFiltered Excell Sheet")
	public void customerExportFiltered() throws InterruptedException {
		logger.info("Starting of customerExportFiltered Method");
		custmrExpt.ClickonCustomerModule();
		custmrExpt.ClickOnFilter();
		custmrExpt.filterCustomerName();
		custmrExpt.selectCustomerName();
		custmrExpt.clickOnApply();;
		custmrExpt.ClickonExport();
		custmrExpt.clickOnExportFiltered();
		custmrExpt.SwitchtoNewWindow();
		String actualexportfilteredsuccesmsg = custmrExpt.exportFilteredConfirmMessage();
		Assert.assertEquals(actualexportfilteredsuccesmsg, EXPECTEDEXPORTFILTEREDSUCCESMSG);
		logger.info("Ending of customerExportFiltered Method");
		
	}
	
//	@AfterClass(alwaysRun=true)
//	public void logOut(){
//		logger.info("Starting of Log-out Method");
//		this.custmrExpt.logOut();	
//		
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
