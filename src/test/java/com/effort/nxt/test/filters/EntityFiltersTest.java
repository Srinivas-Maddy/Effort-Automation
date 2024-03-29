package com.effort.nxt.test.filters;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.filters.EntityFiltersPage;
import com.effort.nxt.test.BaseAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EntityFiltersTest extends BaseAutomationTest{
	
	private static final Logger logger = Logger.getLogger(EntityFiltersTest.class.getName());
	
	private EntityFiltersPage entityfilterpage;
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" , "browser", "headless","userName","password"})
	
	public void initEffortLogin(String siteURL , String browser, String headless, String userName, String passWord) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.ENTITY_FILTERS_DRIVER);
	    this.goToSite(siteURL, driver);
	    this.entityfilterpage = new EntityFiltersPage(driver);
	    this.loginPage = new LoginPage(driver);
	    loginPage.enterUserName(userName);
	    loginPage.clickOnPassword(passWord);
	    loginPage.clickOnLoginButton();
	    loginPage.clickOnSignOutFromAllSessions(userName, passWord);
	  
		logger.info("Ending of initEffortLogin Method");
	}
	
	@Test(priority = 1, description = "Test Case #1, Validation of Entity Filters" ,groups = {"Sanity"})
	@Description("Validation of Entity Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1 , Validating Entity filters")		
	public void entityNameFilter() throws InterruptedException {
		logger.info("Starting of filterEntityName Method");
		
		loginPage.ClickonWebApp();
	    loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		this.entityfilterpage.clickOnEntityModule();
		String actualfltrentityname=entityfilterpage.enterFiltersEntityName(filtersDataProp.getProperty("filterentityname"));
		Assert.assertEquals(actualfltrentityname,expectedAssertionsProp.getProperty("EntityFiltersTest.entityName"));
	
		logger.info("Ending of filterEntityName Method");
	}
	

	@Test(priority = 2, description = "Test Case #2, Validation of Entity ID filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity ID Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityIdFilter() {
		logger.info("Starting of entityIdFiltering method");
		
		String actualfltrentityid=entityfilterpage.enterFilterEntityID(filtersDataProp.getProperty("filterentityid"));
		Assert.assertEquals(actualfltrentityid, expectedAssertionsProp.getProperty("EntityFiltersTest.entityId"));
		
		logger.info("Ending of entityIdFiltering method");
	}
	
	@Test(priority = 3, description = "Test Case #3, Validation of Entity location filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity Location Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityLocationFilter() {
		logger.info("Starting of entityLocationFilter method");
		
		String actualfltrentityid=entityfilterpage.enterFilterEntityID(filtersDataProp.getProperty("filterentityid"));
		Assert.assertEquals(actualfltrentityid, expectedAssertionsProp.getProperty("EntityFiltersTest.entityId"));
		
		logger.info("Ending of entityLocationFilter method");
	}
	
	@Test(priority = 4, description = "Test Case #4, Validation of Entity number filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity number Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityNumberFilter() throws InterruptedException {
		logger.info("Starting of entityNumberFilter method");
		
		String actualfltrentitynumber = entityfilterpage.enterFilterNumber(filtersDataProp.getProperty("filternumber"));
		Assert.assertEquals(actualfltrentitynumber,expectedAssertionsProp.getProperty("EntityFiltersTest.number"));
		
		logger.info("Ending of entityNumberFilter method");		
	}
	
	@Test(priority = 5, description = "Test Case #5, Validation of Entity Text filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity text Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityTextFilter() throws InterruptedException {
		logger.info("Starting of entityTextFilter method");
		
		String actualfltrentitytext = entityfilterpage.enterFilterText(filtersDataProp.getProperty("filtertext"));
		Assert.assertEquals(actualfltrentitytext,expectedAssertionsProp.getProperty("EntityFiltersTest.text") );
		
		logger.info("Ending of entityTextFilter method");		
	}
	
	@Test(priority = 6, description = "Test Case #6, Validation of Entity Email filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity Email Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityEmailFilter() throws InterruptedException {
		logger.info("Starting of entityEmailFilter method");
		
		String actualfltrentityemail = entityfilterpage.enterFilterEmail(filtersDataProp.getProperty("filteremail"));
		Assert.assertEquals(actualfltrentityemail,expectedAssertionsProp.getProperty("EntityFiltersTest.email") );
		
		logger.info("Ending of entityEmailFilter method");
	}
	
	@Test(priority = 7, description = "Test Case #7, Validation of Entity location filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity Location Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityUserLocationFilter() throws InterruptedException {
		logger.info("Starting of entityLocationFilter Method");
		
		String actualfltrentityloc = entityfilterpage.enterFilterLoc(filtersDataProp.getProperty("filterloc"));
		Assert.assertEquals(actualfltrentityloc,expectedAssertionsProp.getProperty("EntityFiltersTest.loc") );
		
		logger.info("Ending of entityLocationFilter Method");
	}
	

	@Test(priority = 8, description = "Test Case #8, Validation of Entity Phone filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity Phone Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityPhoneFilter() throws InterruptedException {
		logger.info("Starting of entityPhoneFilter Method");
		
		String actualfltrentityphone = entityfilterpage.enterFilterPhone(filtersDataProp.getProperty("filterphone"));
		Assert.assertEquals(actualfltrentityphone,expectedAssertionsProp.getProperty("EntityFiltersTest.phone"));
		
		logger.info("Ending of entityPhoneFilter Method");	
	}
	
	@Test(priority = 9, description = "Test Case #9, Validation of Entity Currency filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity Currency Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityCurrencyFilter() throws InterruptedException {
		logger.info("Starting of entityCurrencyFilter Method");

		String actualfltrentitycurrency = entityfilterpage.enterFilterCurrency(filtersDataProp.getProperty("filtercurrency"));
		Assert.assertEquals(actualfltrentitycurrency, expectedAssertionsProp.getProperty("EntityFiltersTest.currency"));
		
		logger.info("Ending of entityCurrencyFilter Method");
	}
	
	
	@Test(priority = 10, description = "Test Case #10, Validation of Entity URL filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity URL Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityUrlFilter() throws InterruptedException {
		logger.info("Starting of entityUrlFilter Method");

		String actualfltrentityurl = entityfilterpage.enterFilterUrl(filtersDataProp.getProperty("filterURL"));
		Assert.assertEquals(actualfltrentityurl,expectedAssertionsProp.getProperty("EntityFiltersTest.url"));
		
		logger.info("Ending of entityUrlFilter Method");
	}
	
	@Test(priority = 11, description = "Test Case #11, Validation of Entity Country filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity Country Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityCountryFiler() throws InterruptedException {
		logger.info("Starting of entityCountryFiler Method");
		
		String actualfltrentitycountry = entityfilterpage.enterFilterCountry(filtersDataProp.getProperty("filtercountry"));
		Assert.assertEquals(actualfltrentitycountry,expectedAssertionsProp.getProperty("EntityFiltersTest.country"));
		
		logger.info("Ending of entityCountryFiler Method");
	}
	
	@Test(priority = 12, description = "Test Case #12, Validation of Entity customer filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity customer Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityCustomerFilter() throws InterruptedException {
		logger.info("Starting of entityCustomerFilter Method");

		String actualfltrcustomerresult = entityfilterpage.pickFilterCustomer(filtersDataProp.getProperty("filterentitycustomer"));
		Assert.assertEquals(actualfltrcustomerresult,expectedAssertionsProp.getProperty("EntityFiltersTest.customer") );
		
		logger.info("Ending of entityCustomerFilter Method");
	}
	
	@Test(priority = 13, description = "Test Case #13, Validation of Entity multipick customer filtering" ,groups = {"Sanity"},enabled = false)
	@Description("Validation of Entity multipick customer Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityMultiCustomerFilter() throws InterruptedException {
		
		logger.info("Starting of entityMultiCustomerFilter Method");

		String actualfltrmultipickcustomerresult = entityfilterpage.pickFilterMultiPickCustomer(filtersDataProp.getProperty("filterentitymultipickcustomer"));
		Assert.assertEquals(actualfltrmultipickcustomerresult,expectedAssertionsProp.getProperty("EntityFiltersTest.customer") );
		
		logger.info("Ending of entityMultiCustomerFilter Method");
	}
	
	@Test(priority = 14, description = "Test Case #14, Validation of Entity territory filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity territory Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityTerritoryFilter() throws InterruptedException {
		
		logger.info("Starting of entityTerritoryFilter Method");

		String actualfltrterritoryresult = entityfilterpage.pickFilterTerritory(filtersDataProp.getProperty("filterterritory"));
		Assert.assertEquals(actualfltrterritoryresult, expectedAssertionsProp.getProperty("EntityFiltersTest.territory"));
		
		logger.info("Ending of entityTerritoryFilter Method");
	}
	

	@Test(priority = 15, description = "Test Case #15, Validation of Entity yes or no filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity yes or no Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityYesOrNoFilter() throws InterruptedException {
		
		logger.info("Starting of entityYesOrNoFilter Method");

		String actualfltryesornoresult=entityfilterpage.pickFilterYesOrNo(filtersDataProp.getProperty("filteryesorno"));
		Assert.assertEquals(actualfltryesornoresult, expectedAssertionsProp.getProperty("EntityFiltersTest.yes"));
		
		logger.info("Ending of entityYesOrNoFilter Method");
	}
	
	@Test(priority = 16, description = "Test Case #16, Validation of Entity customer type filtering" ,groups = {"Sanity"})
	@Description("Validation of Entity customer type  Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Entity filters")
	public void entityCustomerTypeFilter() throws InterruptedException {
		logger.info("Starting of entityCustomerTypeFilter Method");

		String actualfltrcustomertyperesult=entityfilterpage.enterFiltersCustomerType(filtersDataProp.getProperty("filtercustomertype"));
		Assert.assertEquals(actualfltrcustomertyperesult, expectedAssertionsProp.getProperty("EntityFiltersTest.type"));
		
		logger.info("Ending of entityCustomerTypeFilter Method");
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
