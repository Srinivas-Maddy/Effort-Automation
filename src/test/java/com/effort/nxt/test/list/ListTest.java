package com.effort.nxt.test.list;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.list.ListPage;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ListTest extends BaseAutomationTest{
	
	private static final Logger logger=Logger.getLogger(ListTest.class.getName());
	private ListPage list=null;
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL","browser", "headless","userName","password"})
	public void initEffortLogin(String siteURL , String browser, String headless, String userName, String password) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.LEAVES_DRIVER);
	    this.goToSite(siteURL, driver);
	    this.list = new ListPage(driver);
	    this.loginPage = new LoginPage(driver);
	    loginPage.enterUserName(userName);
	    loginPage.clickOnPassword(password);
	    loginPage.clickOnLoginButton();
	    loginPage.clickOnSignOutFromAllSessions(userName,password);
	   
		logger.info("Ending of initEffortLogin Method");
	}
	
	@Test(priority=1, description = "#Test Case 1 : List Spec Creation", groups={"Sanity"})
	@Description("List Spec Creation in App builder")
	@Severity(SeverityLevel.BLOCKER)
	@Story("List Spec Creation")
	public void listSpecCreation() {
		logger.info("Start of lisSpecCreation Method");
		
		list.clickOnAppBuilder();
		list.clickOnListMenu();
		list.clickOnCreateListSpec();
		list.enterTitleName(listProp.getProperty("listSpecTitleName"));
		list.selectListFields();
		
		logger.info("Ending of lisSpecCreation Method");
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
