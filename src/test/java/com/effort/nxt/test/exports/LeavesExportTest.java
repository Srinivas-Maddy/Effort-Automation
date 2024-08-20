package com.effort.nxt.test.exports;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.exports.LeavesExportPage;
import com.effort.nxt.test.BaseAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LeavesExportTest extends BaseAutomationTest{
	
	private static final Logger logger = Logger.getLogger(LeavesExportTest.class.getName());
	private LeavesExportPage leavesexportpage=null;
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" ,"browser", "headless","userName","password"})
	public void initEffortLogin(String siteURL , String browser, String headless, String userName, String password) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.LEAVES_EXPORT_DRIVER);
		this.goToSite(siteURL, driver);
		this.leavesexportpage = new LeavesExportPage(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(userName);
		this.loginPage.clickOnPassword(password);
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(userName, password);
		
		logger.info("Ending of initEffortLogin Method");
	}
	
	@Test(priority = 1 , description = "TestCase #1 , Go to Leaves and select Export All ", groups= {"sanity"})
	@Description("Download All Leaves using ExportAll")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1 ,Downloading all Leaves Information using Export All")
	public void leavesExportAll() throws InterruptedException {
		logger.info("Starting of entityExportAll Method");
		
		loginPage.ClickonWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		leavesexportpage.clickOnThreeDots();
		leavesexportpage.clickOnLeaves(leavesDataProp.getProperty("leavesname"));
		leavesexportpage.selectLeavesExportAll();
		
		logger.info("Ending of entityExportAll Method");		
	}
	
	@Test(priority = 2 , description = "TestCase #2 , Go to Leaves and select Export Selected ", groups= {"sanity"})
	@Description("Download All Leaves using ExportSelected")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2 ,Downloading all Leaves Information using Export Selected")
	public void leavesExportSelected() throws InterruptedException {
		logger.info("Starting of leavesExportSelected Method");
		
		leavesexportpage.selectLeavesExportSelected();
		
		logger.info("Ending of leavesExportSelected Method");		
	}
	
	
	@Test(priority = 3 , description = "TestCase #3 , Go to Leaves and select Export Filtered ", groups= {"sanity"})
	@Description("Download All Leaves using ExportFiltered")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3 ,Downloading all Leaves Information using Export Filtered")
	public void leavesExportFiltered() throws InterruptedException {
		logger.info("Starting of leavesExportFiltered Method");
		
		leavesexportpage.selectLeavesExportFiltered(leavesDataProp.getProperty("leavesexportempname"), leavesDataProp.getProperty("passedleavesexportempname"));
		
		logger.info("Ending of leavesExportFiltered Method");		
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
