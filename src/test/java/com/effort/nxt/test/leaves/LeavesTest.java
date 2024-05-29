package com.effort.nxt.test.leaves;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.leaves.LeavesPage;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LeavesTest extends BaseAutomationTest{
	
	private static final Logger logger = Logger.getLogger(LeavesTest.class.getName());
	private LeavesPage leavespage;
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL","browser", "headless","userName","password"})
	public void initEffortLogin(String siteURL , String browser, String headless, String userName, String password) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.LEAVES_DRIVER);
	    this.goToSite(siteURL, driver);
	    this.leavespage = new LeavesPage(driver);
	    this.loginPage = new LoginPage(driver);
	    loginPage.enterUserName(userName);
	    loginPage.clickOnPassword(password);
	    loginPage.clickOnLoginButton();
	    loginPage.clickOnSignOutFromAllSessions(userName,password);
	   
		logger.info("Ending of initEffortLogin Method");
	}
	
	@Test(priority = 1, description = "Test Case #1, Apply Leaves" ,groups = {"Sanity"},enabled = true)
	@Description("Appling Leaves")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1 , Appling Leaves")
	
	public void applyLeaves() throws InterruptedException
	{
		logger.info("Starting of applyLeaves Method");
		
		loginPage.ClickonWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		leavespage.clickOnThreeDots();
		leavespage.clickOnLeaves(leavesDataProp.getProperty("leavesname"));
		leavespage.clickOnApplyLeaves();
		leavespage.SwitchNewWindow();
		leavespage.pickLeavesFromDate();
		leavespage.clickOnTo();
		leavespage.pickLeaveType(leavesDataProp.getProperty("leavetype"));	
		leavespage.enterLeaveRemarks(leavesDataProp.getProperty("leaveRemark"));
		leavespage.leavesSave();
		
		logger.info("Ending of applyLeaves Method");
	}
	
	@Test(priority = 2, description = "Test Case #2, Approve Leaves" ,groups = {"Sanity"}, enabled=true)
	@Description("After Appling Leaves,Approve the Leave")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1 , Approve Leaves")
	
	public void approveLeaves() throws InterruptedException
	{
		logger.info("Starting of approveLeaves Method");
		
		leavespage.clickOnThreeDots();
		leavespage.clickOnLeaves(leavesDataProp.getProperty("leavesname"));
		leavespage.approvedPendingLeave();
		
		logger.info("Ending of approveLeaves Method");
	}
	
	@Test(priority = 3,description = "Test Case#3, Reject Leaves" , groups= {"Sanity"})
	@Description("Afetr Appling Leave,Reject the Leave")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3, Reject the Leave")
	public void rejectLeaves() throws InterruptedException {
		logger.info("Starting of rejectLeaves Method");
		
		leavespage.clickOnThreeDots();
		leavespage.clickOnLeaves(leavesDataProp.getProperty("leavesname"));
		leavespage.rejectPendingLeave();
		
		logger.info("Ending of rejectLeaves Method");
		
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
