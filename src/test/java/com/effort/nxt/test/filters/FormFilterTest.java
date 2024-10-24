package com.effort.nxt.test.filters;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.filters.FormFiltersPage;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class FormFilterTest extends BaseAutomationTest{

	private static final Logger logger = Logger.getLogger(FormFilterTest.class.getName());
	private FormFiltersPage formFilter=null;
	
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" , "browser", "headless","userName","password"})
	public void initEffortLogin(String siteURL , String browser, String headless, String userName, String password ) throws InterruptedException {
		logger.info("Starting of initEffortLogin Method");
		
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.FORM_FILTER_DRIVER);
		driver.get(siteURL);
		this.formFilter = new FormFiltersPage(driver);
		this.loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.clickOnPassword(password);
		loginPage.clickOnLoginButton();
		loginPage.clickOnSignOutFromAllSessions(userName,password);
	
		logger.info("Ending of initEffortLogin Method");
	}
	
	@Test(priority = 1 ,description = "TestCase#1 ,Validate to check Form filter is working as expected by form id" , groups = {"sanity"} )
	@Description("Checking Form filter with Form id")
	@Severity(SeverityLevel.BLOCKER)
	@Story("FORM FILTER FUNCTIONALITY By FORM ID")
	public void filterByFormID() {
		logger.info("Starting of filterByFormID Method");
		
		loginPage.ClickonWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		this.formFilter.clickOnForms();
		this.formFilter.clickOnFormSpec();
		this.formFilter.clickOnFilter();
		this.formFilter.clickOnReset();
		this.formFilter.filterWithFormId(filtersDataProp.getProperty("form.filter.formid"));
		this.formFilter.clickOnApply();
		
		Assert.assertEquals(expectedAssertionsProp.getProperty("FormFiltertest.formID"), 
							this.formFilter.getFormIDResult());
		
		
		logger.info("Ending of filterByFormID Method");
	}
	
	@Test(priority = 2 ,description = "TestCase#2 ,Validate to check Form filter is working as expected by FilledBy" , groups = {"sanity"} )
	@Description("Checking Form filter with Form filled by")
	@Severity(SeverityLevel.BLOCKER)
	@Story("FORM FILTER FUNCTIONALITY By Filled Employee")
	public void filterByFilledBy() {
		logger.info("Starting of filterByFilledBy Method");
		
		this.formFilter.clickOnFilter();
		this.formFilter.clickOnReset();
		this.formFilter.selectFiledByName(filtersDataProp.getProperty("form.filter.emp"));
		this.formFilter.clickOnApply();
		
		Assert.assertEquals(expectedAssertionsProp.getProperty("FormFiltertest.emp"), 
							this.formFilter.getFilledByNameResult());
		
		
		logger.info("Ending of filterByFormID Method");
	}
	
	@Test(priority = 3 ,description = "TestCase#3 ,Validate to check Form filter is working as expected by Modified By" , groups = {"sanity"} )
	@Description("Checking Form filter with Form Modified by")
	@Severity(SeverityLevel.BLOCKER)
	@Story("FORM FILTER FUNCTIONALITY By Modified Name")
	public void filterByModifiedBy() {
		logger.info("Starting of filterByFilledBy Method");
		
		this.formFilter.clickOnFilter();
		this.formFilter.clickOnReset();
		this.formFilter.selectModifiedByName(filtersDataProp.getProperty("form.filter.emp"));
		this.formFilter.clickOnApply();
		
		Assert.assertEquals(expectedAssertionsProp.getProperty("FormFiltertest.emp"), 
							this.formFilter.getModifiedByNameResult());
		
		
		logger.info("Ending of filterByFormID Method");
	}
	
	
	@Test(priority = 4 ,description = "TestCase#4 ,Validate to check Form filter is working as expected Filled Dated" , groups = {"sanity"} )
	@Description("Checking Form filter with Form Filled Date")
	@Severity(SeverityLevel.BLOCKER)
	@Story("FORM FILTER FUNCTIONALITY By Filled Date")
	public void filterFilledDate() {
		logger.info("Starting of filterFilledDate Method");
		
		this.formFilter.clickOnFilter();
		this.formFilter.clickOnReset();
		this.formFilter.clickOnFilledDate();
		this.formFilter.clickOnEndDate();
		this.formFilter.clickOnApply();
		
		logger.info("Ending of filterFilledDate Method");
	}
	
	@Test(priority = 5 ,description = "TestCase#5 ,Validate to check Form filter based on the currency value" , groups = {"sanity"} )
	@Description("Checking Form filter based on currecny value")
	@Severity(SeverityLevel.BLOCKER)
	@Story("FORM FILTER FUNCTIONALITY BASED ON CURRENCY VALUE")
	public void filterBasedOnCurrecny() {
		logger.info("Starting of filterBasedOnCurrecny Method");
		
		this.formFilter.clickOnFilter();
		this.formFilter.clickOnReset();
		this.formFilter.enterCurrency(filtersDataProp.getProperty("form.filter.currency"));
		this.formFilter.clickOnApply();
		
		Assert.assertEquals(expectedAssertionsProp.getProperty("FormFiltertest.currency"), 
				this.formFilter.getCurrencyFilterResult());
		
		logger.info("Ending of filterBasedOnCurrecny Method");
	}
	
	
	@Test(priority = 6 ,description = "TestCase#6 ,Validate to check Form filter based on the date" , groups = {"sanity"} )
	@Description("Checking Form filter based on Date value")
	@Severity(SeverityLevel.BLOCKER)
	@Story("FORM FILTER FUNCTIONALITY BASED ON DATE VALUE")
	public void filterBasedOnDate() {
		logger.info("Starting of filterBasedOnDate Method");
		
		this.formFilter.clickOnFilter();
		this.formFilter.clickOnReset();
		this.formFilter.clickOnFormDate();
		this.formFilter.clickOnToDate();
		this.formFilter.clickOnApply();
		
		logger.info("Ending of filterBasedOnDate Method");
	}
	
	@Test(priority = 7 ,description = "TestCase#7 ,Validate to check Form filter based on the Currency Value" , groups = {"sanity"} )
	@Description("Checking Form filter based on Currency Value")
	@Severity(SeverityLevel.BLOCKER)
	@Story("FORM FILTER FUNCTIONALITY BASED ON CURRENCY VALUE")
	public void filterNumberValue() {
		logger.info("Starting of filterCurrencyValue method");
		
		this.formFilter.clickOnFilter();
		this.formFilter.clickOnReset();
		this.formFilter.enterNumberValue(filtersDataProp.getProperty("form.filter.number"));
		this.formFilter.clickOnApply();
		
		Assert.assertEquals(expectedAssertionsProp.getProperty("FormFiltertest.number"), this.formFilter.getNumberResult());
		
		logger.info("Ending of filterCurrencyValue method");
	}
	
	
	@Test(priority = 8 ,description = "TestCase#8 ,Validate to check Form filter based on the Text Value" , groups = {"sanity"} )
	@Description("Checking Form filter based on Text Value")
	@Severity(SeverityLevel.BLOCKER)
	@Story("FORM FILTER FUNCTIONALITY BASED ON TEXT VALUE")
	public void filterTextValue() {
		logger.info("Starting of filterTextValue Method");
		
		this.formFilter.clickOnFilter();
		this.formFilter.clickOnReset();
		this.formFilter.enterTextInputValue(filtersDataProp.getProperty("form.filter.text"));
		this.formFilter.clickOnApply();

		Assert.assertEquals(expectedAssertionsProp.getProperty("FormFiltertest.text"),this.formFilter.getTextFilterResult());

		logger.info("Ending of filterTextValue Method");

	}
	
	@Test(priority = 9 ,description = "TestCase#8 ,Validate to check Form filter based on the Email" , groups = {"sanity"} )
	@Description("Checking Form filter based on Email Value")
	@Severity(SeverityLevel.BLOCKER)
	@Story("FORM FILTER FUNCTIONALITY BASED ON Email VALUE")
	public void filterByEmail() {
		logger.info("Starting of filterByEmail Method");
		
		this.formFilter.clickOnFilter();
		this.formFilter.clickOnReset();
		this.formFilter.enterEmailId(filtersDataProp.getProperty("form.filter.email"));
		this.formFilter.clickOnApply();
		
		Assert.assertEquals(expectedAssertionsProp.getProperty("FormFiltertest.email"), this.formFilter.getEmailFilterResult());
		
		logger.info("Ending of filterByEmail Method");
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
