package com.effort.nxt.test.employees;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.effort.common.WebDriversEnum;
import com.effort.employees.EmployeeCreation;
import com.effort.nxt.test.BaseAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EmployeeCreationTest extends BaseAutomationTest{
	

	private static final Logger logger=Logger.getLogger(EmployeeCreationTest.class.getName());
	private EmployeeCreation empCreation;
	private static final String expectedEmpSavedMsg = "Saved successfully";

	@BeforeClass (alwaysRun = true)
	@Parameters({"siteURL","browser","userName", "password", "headless"})
	public void initEffortLogin(String siteUrl,String browser,String userName, String password, String headless) throws Exception {
		logger.info("starting of initEfforrt Login Method of Employee process");
	
		this.driver=this.getWebDriver(browser, headless, WebDriversEnum.EMPLOYEE_CREATION_DRIVER);
		this.goToSite(siteUrl, driver);
		this.empCreation=new EmployeeCreation(driver);
		LoginToApplication(userName, password);
		loginPage.clickOnSignOutFromAllSessions(testDataProp.getProperty("name"), testDataProp.getProperty("password1"));
		
		logger.info("Ending of initEffortLogin method in Work Creation process");			
	}
	
	
	@Test(priority = 1, description="Go to Employees and Add the employee details", groups = {"sanity"})
	@Description("Create the employee")
	@Epic("Employee Module")
	@Feature("Employee Creation")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee creation by clicking on add employee button")
	public void AddEmployee() throws InterruptedException, IOException {
		logger.info("Starting of AddEmployee Method");
		
		loginPage.ClickonWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		empCreation.clickOnEmployees();
		empCreation.clickOnAddEmpBtn();
		this.addEmpBasicFields();
		String actualEmpSavedMsg = empCreation.saveAndValidateEmployeCreated();
		
		Assert.assertEquals(actualEmpSavedMsg, expectedEmpSavedMsg);
		
		logger.info("Ending of AddEmployee Method");		
	}
	
	
	@Test(priority = 2, description="Employee Creation with user defined fields", groups = {"sanity"})
	@Epic("Employees")
	@Feature("Employee Creation with user defined fields")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Create employee along with the user defined fields")
	public void  employeeCreationWithUserDefinedFields() {
		logger.info("Starting of employeeCreationWithUserDefinedFields Method");
		
		empCreation.clickOnEmployees();
		empCreation.clickOnAddEmpBtn();
		this.addEmpBasicFields();
		empCreation.clickOnUserDefinedSection();
		empCreation.enterTextValue(empDataProp.getProperty("employee.text"));
		
		empCreation.saveAndValidateEmployeCreated();
		
		logger.info("Ending of employeeCreationWithUserDefinedFields Method");
	}
	
	
	
	
	
	@Test(priority = 3, description="Modify the employee data", groups = {"sanity"})
	@Description("Modify the employee")
	@Epic("Employee Module")
	@Feature("Employee Modification")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Employee modification in list screen")
	public void modifyEmployee() {
		logger.info("Starting of modifyEmployee Method");
		
		empCreation.clickOnFilter();
		empCreation.filterEmployeeName();
		empCreation.clickOnEditButton();
		empCreation.enterModifiedFirstName(empDataProp.getProperty("Emp.Modified.FirstName"));
		empCreation.enterModifiedLastName(empDataProp.getProperty("Emp.Modified.lastName"));
		empCreation.clickOnSave();
		
		logger.info("Ending of modifyEmployee Method");
	}
	
	@Test(priority = 4, description="Employee Disable", groups = {"sanity"})
	@Description("Disable Employee")
	@Epic("Employee Module")
	@Feature("Employee Disable")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Employee Disable in list screen")
	public void disableEmployee() {
		logger.info("Starting of Employee Disable Method");
		
		empCreation.clickOnFilter();
		empCreation.clickOnReset();
		empCreation.disableEmployee();	
		
		logger.info("Ending of Employee Disable Method");
	}
	
	
	public void addEmpBasicFields() {
		logger.info("Starting of addEmpBasicFields ");
		
		this.empCreation.switchNewWindow();
		this.empCreation.enterFirstName(empDataProp.getProperty("firstName"));
		this.empCreation.enterLastName(empDataProp.getProperty("lastName"));
		this.empCreation.EmpId();
		this.empCreation.managerCheckBox();
		this.empCreation.qrCodeCheckBox();	
		this.empCreation.EmpEmail();
		this.empCreation.EmpPhone();
		this.empCreation.clickOnAdvanceDetails();
		this.empCreation.selectManagerName(empDataProp.getProperty("employee.managerName"));
		this.empCreation.uploadEmpPhoto();
		this.empCreation.enterEmpDesignation(empDataProp.getProperty("employee.designation"));
		this.empCreation.selectEmpRole(empDataProp.getProperty("employee.role"));
		this.empCreation.selectEmpGroup(empDataProp.getProperty("employee.group"));
		this.empCreation.selectAutoMapCustomerOption(empDataProp.getProperty("automapcustomer"));
		this.empCreation.selecTerritory(empDataProp.getProperty("employee.territory"));
		
		logger.info("Ending of addEmpBasicFields ");
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
