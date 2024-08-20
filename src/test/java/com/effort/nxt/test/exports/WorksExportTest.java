package com.effort.nxt.test.exports;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.exports.WorkExportsPage;
import com.effort.nxt.test.BaseAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import junit.framework.Assert;

public class WorksExportTest extends BaseAutomationTest{
	
	private static final Logger logger = Logger.getLogger(WorksExportTest.class.getName());
	private WorkExportsPage worksExport=null;
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" ,"browser", "headless","userName","password"})
	public void initEffortLogin(String siteURL , String browser, String headless, String userName, String password) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.WORKS_EXPORTS_DRIVER);
		this.goToSite(siteURL, driver);
		this.worksExport = new WorkExportsPage(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(userName);
		this.loginPage.clickOnPassword(password);
		this.loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(userName, password);
		
		logger.info("Ending of initEffortLogin Method");
	}
	
	@Test(priority = 1 , description = "TestCase #1 , Go to Works and select Export All ", groups= {"sanity"})
	@Description("Download Export All work Using export all option in work")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1 ,Downloading all works using Export All options")
	public void worksExportAll() {
		logger.info("Starting of worksExportAll Method");
		
		this.worksExport.clickOnWebApp();
		this.worksExport.clickOnProcessModule();
		this.worksExport.clickOnProccessName();
		this.worksExport.clickOnExportOptions();
		this.worksExport.clickOnExportAllOption();
		this.worksExport.clickOnConfirm();
		
		logger.info("Ending of worksExportAll Method");
	}
	
	@Test(priority = 2 , description = "TestCase #2 , Export the selected works data ", groups= {"sanity"})
	@Description("Download the selected works data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1 ,Export Selected")
	public void worksExportSelected() {
		logger.info("Starting of worksExportSelected Method");
		
		this.worksExport.clickOnProcessModule();
		this.worksExport.clickOnProccessName();
		this.worksExport.clickOnYetToStartWorks();
		this.worksExport.selectCheckbox();
		this.worksExport.clickOnExportOptions();
		this.worksExport.clickOnSelectAll();
		Assert.assertEquals(expectedAssertionsProp.getProperty("works.exportSelected.status"),
				            this.worksExport.getSheetDownloadStatus());
		
		logger.info("Ending of worksExportSelected Method");
	}
	
	@Test(priority = 3 , description = "TestCase #3 , Export the filtered works data ", groups= {"sanity"})
	@Description("Download the filtered works data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1 ,Export Filtered")
	public void worksExportFiltered() {
		logger.info("Starting of worksExportSelected Method");
		
		this.worksExport.clickOnProcessModule();
		this.worksExport.clickOnProccessName();
		this.worksExport.clickOnFilter();
		this.worksExport.clickOnReset();
		this.worksExport.selectEmployee("Srinivas");
		this.worksExport.clickOnApplyFilter();
		this.worksExport.clickOnExportOptions();
		this.worksExport.clickOnExportFiltered();
		Assert.assertEquals(expectedAssertionsProp.getProperty("works.exportFiltered.status"),
				            this.worksExport.getExportFilteredtatus());
		
		logger.info("Ending of worksExportSelected Method");
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
