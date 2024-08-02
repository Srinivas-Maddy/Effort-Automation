package com.effort.nxt.test.territories;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.base.LoginPage;
import com.effort.common.WebDriversEnum;
import com.effort.nxt.test.BaseAutomationTest;
import com.effort.territories.TerritoriesPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class TerritoriesTest extends BaseAutomationTest{
	
	private static final Logger logger=Logger.getLogger(TerritoriesTest.class.getName());
	private TerritoriesPage territory=null;
	
	    //Before class test case was execute once class loaded in the jvm
		@BeforeClass (alwaysRun = true)
		@Parameters({"siteURL","browser", "headless"})
		public void initEffortLogin(String siteUrl,String browser, String headless) throws Exception {
			logger.info("starting of initEfforrt Login Method in TerritoriesTest Class");
			
			this.driver=this.getWebDriver(browser, headless, WebDriversEnum.FORMS_DRIVER);
			this.goToSite(siteUrl, driver);
			this.territory=new TerritoriesPage(driver);
			this.loginPage = new LoginPage(driver);
			LoginToApplication(testDataProp.getProperty("config.user"), testDataProp.getProperty("config.password"));
            this.territory.clickOnAppBuilder();
            
			logger.info("Ending of initEffortLogin method in TerritoriesTest Class");			
		}
	
		@Test(priority = 1, description="Creating Territory in App Builder", groups = {"sanity"})
		@Description("Territory Spec Creating in the app builder")
		@Severity(SeverityLevel.BLOCKER)
		@Story("Territory Creation")
		public void createTerritory() {
			logger.info("Starting of createTerritory Method");
			
			this.territory.clickOnTerritoryModule();
			this.territory.clickOnManageTerritories();
			this.territory.clickOnCreateTerritory();
			this.territory.enterTerritoryName(testDataProp.getProperty("territory.name"));
			this.territory.enterTerritoryNo(testDataProp.getProperty("territory.no"));
			this.territory.clickOnSave();
			Assert.assertEquals(this.territory.getTerritoryConfirmationMsg(),
					            expectedAssertionsProp.getProperty("territory.created.status"));	
			
			logger.info("Ending of createTerritory Method");
		}
		
		@Test(priority = 2, description="Modifying Territory in App Builder", groups = {"sanity"})
		@Description("Territory Spec Modification in the app builder")
		@Severity(SeverityLevel.BLOCKER)
		@Story("Territory Modification")
		public void modifyTerritory() {
			logger.info("Starting of modifyTerritory Method");
			
			this.territory.clickOnEdit();
			this.territory.enterModifiedName(testDataProp.getProperty("territory.name"));
			this.territory.clickOnSave();

			logger.info("Ending of modifyTerritory Method");		
		}
		
		@Test(priority = 3, description="Employee Territory Mapping", groups = {"sanity"})
		@Description("Mapping the territory to employee in app builder")
		@Severity(SeverityLevel.BLOCKER)
		@Story("Employee Territory Mapping")	
		public void empTerritoryMapping() {
			logger.info("Starting of empTerritoryMapping Method");
			
			this.territory.clickOnMapEmpOption();
			this.territory.selectEmp(testDataProp.getProperty("territory.empId"));
			this.territory.moveRightSide();
			this.territory.clickOnMappingSaveBtn();
			Assert.assertEquals(this.territory.getTerritoryConfirmationMsg(),
		            expectedAssertionsProp.getProperty("territory.created.status"));
			
			logger.info("Ending of empTerritoryMapping Method");
		}
		
		@Test(priority = 4, description="Filter Territory by name", groups = {"sanity"})
		@Description("Check filter functionality by search with territory name")
		@Severity(SeverityLevel.BLOCKER)
		@Story("Territory Filter By Name")
		public void filterTerritoryByName() {
			logger.info("Starting of filterTerritoryByName Method");
			
			
			
			logger.info("Ending of filterTerritoryByName Method");		
		}
		
		@Test(priority = 5, description = "Deleted the territory", groups = {"sanity"})
		@Description("Deleting the Created Territory")
		@Severity(SeverityLevel.BLOCKER)
		@Story("Territory Deletion")
		public void deleteTerritory() {
			logger.info("Starting of deleteTerritory Method");
			
			this.territory.clickOnDelete();
			
			logger.info("Ending of deleteTerritory Method");
		}
		
		
		@Test(priority = 6, description = "Create Territory With Cricle", groups = {"sanity"})
		@Description("Creating the territory with circle")
		@Severity(SeverityLevel.BLOCKER)
		@Story("Territory Creation with circle")
		public void territoryCreationWithCircle() {
			
			logger.info("Starting of territoryCreationWithCircle Method");
			
			this.territory.clickOnCreateTerritory();
			this.territory.enterTerritoryName(testDataProp.getProperty("territory.circle.name"));
			this.territory.enterTerritoryNo(testDataProp.getProperty("territory.circle.no"));
			this.territory.clickOnType();
			this.territory.selectCircleType();
			this.territory.enterLocationAddress(testDataProp.getProperty("territory.location"));
			this.territory.clickOnMap();
			this.territory.clickOnSave();
			
			logger.info("Ending of territoryCreationWithCircle Method");	
		}
		
		
		
		
		//After All the test cases executed it will quite the browser object
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
