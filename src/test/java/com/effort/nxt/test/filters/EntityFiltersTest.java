package com.effort.nxt.test.filters;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.filters.EntityFiltersPage;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EntityFiltersTest extends BaseAutomationTest{
	
	private static final Logger logger = Logger.getLogger(EntityFiltersTest.class.getName());
	
	private static final String EXPECTED_FILTER_ENTITY_NAME="Entity07";
	private static final String EXPECTED_FILTER_ENTITY_ID="163126725381";
	private static final String EXPECTED_FILTER_ENTITY_LOCATION="17.443190433765462,78.36599349975586";
	private static final String EXPECTED_FILTER_ENTITY_NUMBER ="987654678";
	private static final String EXPECTED_FILTER_ENTITY_TEXT="Entity Automation Text";
	private static final String EXPECTED_FILTER_ENTITY_EMAIL="entitytext@nmail.com";
	private static final String EXPECTED_FILTER_ENTITY_LOC ="17.43236927611689,78.37943538650313";
	private static final String EXPECTED_FILTER_ENTITY_PHONE="987654567";
	private static final String EXPECTED_FILTER_ENTITY_CURRENCY="60000.00";
	private static final String EXPECTED_FILTER_ENTITY_URL="https://mail.google.com/mail/u/0/?tabrm&ogbl#chat/space/AAAAszuKn-I";
	private static final String EXPECTED_FILTER_ENTITY_COUNTRY="India";
	private static final String EXPECTED_FILTER_ENTITY_CUSTOMERNAME ="Entity07";
	private static final String EXPECTED_FILTER_ENTITY_MULTIPICKCUSTOMERNAME ="Entity07";
	private static final String EXPECTED_FILTER_ENTITY_TERRITORY="807090";
	private static final String EXPECTED_FILTER_ENTITY_YESORNO="Entity07";
	private static final String EXPECTED_FILTER_ENTITY_CUSTOMERTYPE ="Retailers";
	private static final String EXPECTED_FILTER_ENTITY_FILLEDBY="Bulkfilledtype";
	
	private EntityFiltersPage entityfilterpage;
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"siteURL" , "browser"})
	
	public void initEffortLogin(String siteURL , String browser) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
	    this.goToSite(siteURL, driver);
	    this.entityfilterpage = new EntityFiltersPage(driver);
	    this.loginPage = new LoginPage(driver);
	    loginPage.enterUserName(testDataProp.getProperty("name"));
	    loginPage.clickOnPassword(testDataProp.getProperty("password1"));
	    loginPage.clickOnLoginButton();
	    entityfilterpage.clickOnWebApp();
		logger.info("Ending of initEffortLogin Method");
	}
	
	@Test(priority = 1, description = "Test Case #1, Validation of Entity Filters" ,groups = {"Sanity"})
	@Description("Validation of Entity Filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1 , Validating Entity filters")
		
	public void filterEntityName() throws InterruptedException {
		logger.info("Starting of filterEntityName Method");
		
		entityfilterpage.clickOnDots();
		entityfilterpage.pickEntityName(filtersDataProp.getProperty("autoentityname"));
		String actualfltrentityname=entityfilterpage.enterFiltersEntityName(filtersDataProp.getProperty("filterentityname"));
		Assert.assertEquals(actualfltrentityname, EXPECTED_FILTER_ENTITY_NAME);
		String actualfltrentityid=entityfilterpage.enterFilterEntityID(filtersDataProp.getProperty("filterentityid"));
		Assert.assertEquals(actualfltrentityid, EXPECTED_FILTER_ENTITY_ID);
		String actualfltrentitylocation = entityfilterpage.enterFilterEntityLocation(filtersDataProp.getProperty("filterlocation"));
		Assert.assertEquals(actualfltrentitylocation, EXPECTED_FILTER_ENTITY_LOCATION);
		String actualfltrentitynumber = entityfilterpage.enterFilterNumber(filtersDataProp.getProperty("filternumber"));
		Assert.assertEquals(actualfltrentitynumber, EXPECTED_FILTER_ENTITY_NUMBER);
		String actualfltrentitytext = entityfilterpage.enterFilterText(filtersDataProp.getProperty("filtertext"));
		Assert.assertEquals(actualfltrentitytext, EXPECTED_FILTER_ENTITY_TEXT);
		String actualfltrentityemail = entityfilterpage.enterFilterEmail(filtersDataProp.getProperty("filteremail"));
		Assert.assertEquals(actualfltrentityemail, EXPECTED_FILTER_ENTITY_EMAIL);
		String actualfltrentityloc = entityfilterpage.enterFilterLoc(filtersDataProp.getProperty("filterloc"));
		Assert.assertEquals(actualfltrentityloc, EXPECTED_FILTER_ENTITY_LOC);
		String actualfltrentityphone = entityfilterpage.enterFilterPhone(filtersDataProp.getProperty("filterphone"));
		Assert.assertEquals(actualfltrentityphone, EXPECTED_FILTER_ENTITY_PHONE);
		String actualfltrentitycurrency = entityfilterpage.enterFilterCurrency(filtersDataProp.getProperty("filtercurrency"));
		Assert.assertEquals(actualfltrentitycurrency, EXPECTED_FILTER_ENTITY_CURRENCY);
		String actualfltrentityurl = entityfilterpage.enterFilterUrl(filtersDataProp.getProperty("filterURL"));
		Assert.assertEquals(actualfltrentityurl, EXPECTED_FILTER_ENTITY_URL);
		String actualfltrentitycountry = entityfilterpage.enterFilterCountry(filtersDataProp.getProperty("filtercountry"));
		Assert.assertEquals(actualfltrentitycountry, EXPECTED_FILTER_ENTITY_COUNTRY);
		String actualfltrcustomerresult = entityfilterpage.pickFilterCustomer(filtersDataProp.getProperty("filterentitycustomer"));
		Assert.assertEquals(actualfltrcustomerresult, EXPECTED_FILTER_ENTITY_CUSTOMERNAME);
		String actualfltrmultipickcustomerresult = entityfilterpage.pickFilterMultiPickCustomer(filtersDataProp.getProperty("filterentitymultipickcustomer"));
		Assert.assertEquals(actualfltrmultipickcustomerresult, EXPECTED_FILTER_ENTITY_MULTIPICKCUSTOMERNAME);
		String actualfltrterritoryresult = entityfilterpage.pickFilterTerritory(filtersDataProp.getProperty("filterterritory"));
		Assert.assertEquals(actualfltrterritoryresult, EXPECTED_FILTER_ENTITY_TERRITORY);
		String actualfltryesornoresult=entityfilterpage.pickFilterYesOrNo(filtersDataProp.getProperty("filteryesorno"));
		Assert.assertEquals(actualfltryesornoresult, EXPECTED_FILTER_ENTITY_YESORNO);
		String actualfltrcustomertyperesult=entityfilterpage.enterFiltersCustomerType(filtersDataProp.getProperty("filtercustomertype"));
		Assert.assertEquals(actualfltrcustomertyperesult, EXPECTED_FILTER_ENTITY_CUSTOMERTYPE);
		//String actualfltrfilledbyresult=entityfilterpage.pickFilterFilledBy(filtersDataProp.getProperty("filterentityfilledby"));
		//Assert.assertEquals(actualfltrfilledbyresult, EXPECTED_FILTER_ENTITY_FILLEDBY);
		
		logger.info("Ending of filterEntityName Method");
	}
	
	@AfterClass(alwaysRun = true)
	public void entityFiltersLogout() throws InterruptedException {
		logger.info("Starting of filtersEntityLogout Method");
		entityfilterpage.filtersEntityLogout();
		logger.info("Ending of filtersEntityLogout Method");
	}
	
}
