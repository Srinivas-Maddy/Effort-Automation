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
		list.clickOnPublish();
		
		logger.info("Ending of lisSpecCreation Method");
	}
	
	@Test(priority=2, description = "#Test Case 2 : Add list item", groups={"Sanity"})
	@Description("Add list item")
	@Severity(SeverityLevel.BLOCKER)
	@Story("List item Added")
	public void addListItem() {
		logger.info("Starting of addListitem method");
		
		list.clickOnAddListCard();
		list.enterListNumber(listProp.getProperty("list.no"));
		list.enterTextFieldValue(listProp.getProperty("list.text.data"));
		list.enterNumberValue(listProp.getProperty("list.number.data"));
		list.pickCurrentDate();
		list.pickYesOrNo();
		list.selectDropdown();
		list.selectCustomer();
		list.enterEmail(listProp.getProperty("list.email.data"));
		list.enterPhone(listProp.getProperty("list.phone.data"));
		list.enterURL(listProp.getProperty("list.url.data"));
		list.selectTime();
		list.selecPicklist();
		list.selecEmployee();
		list.selecMultiPickCustomers();
		list.selectTerritory();
		list.selectEntity();
		list.selectEmployeeGroup();
		list.clickOnSaveBtn();
		
		logger.info("Ending of addListitem method");	
	}
	
	@Test(priority=3, description = "#Test Case 3 : Modified the added list item", groups={"Sanity"})
	@Description("Modified Entity list item")
	@Severity(SeverityLevel.BLOCKER)
	@Story("List Item Modify")
	public void modifyListItem() {
		logger.info("Starting of modifyListItem method");
		
		list.clickOnEdit();
		list.enterModifiedData(listProp.getProperty("list.modified.data"));
		list.clickOnSaveBtn();
		
		logger.info("Ending of modifyListItem method");
	}
	
	@Test(priority=4, description = "#Test Case 4 : Delete the list item", groups={"Sanity"})
	@Description("Delete Entity list item")
	@Severity(SeverityLevel.BLOCKER)
	@Story("List Item delete")
	public void deleteListItem() {
		logger.info("Starting of deleteListItem method");

		list.selectEntityCheckbox();
		list.clickOnDelete();
		
		logger.info("Starting of deleteListItem method");
	}
	
	@Test(priority=5, description = "#Test Case 4 : Delete the list Spec", groups={"Sanity"})
	@Description("Delete Entity list item")
	@Severity(SeverityLevel.BLOCKER)
	@Story("List Item delete")
	public void listSpecWithDraw() {
		logger.info("Starting of listSpecWithDraw method");
		
		list.clickOnListMenu();
		list.searchListSpec();
		list.clickOnWithDrawCard();
		
		logger.info("Starting of deleteListItem method");
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
