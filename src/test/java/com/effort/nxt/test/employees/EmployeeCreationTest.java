package com.effort.nxt.test.employees;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.employees.EmployeeCreation;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EmployeeCreationTest extends BaseAutomationTest{
	

	private static final Logger logger=Logger.getLogger(EmployeeCreationTest.class.getName());
	private EmployeeCreation empCreation;
	private static final String expectedEmpSavedMsg = "Saved successfully";
	
	@BeforeClass (alwaysRun = true)
	@Parameters({"siteURL","browser"})
	public void initEffortLogin(String siteUrl,String browser) throws Exception {
		logger.info("starting of initEfforrt Login Method of Employee process");
		this.driver=this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
		this.goToSite(siteUrl, driver);
		this.empCreation=new EmployeeCreation(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		this.empCreation.clickOnWebApp();
		logger.info("Ending of initEffortLogin method in Work Creation process");			
	}
	
	
	@Test(priority = 1, description="Go to Employees and Add the employee details", groups = {"sanity"})
	@Description("Create the employee")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee creation by clicking on add employee button")
	public void AddEmployee() throws InterruptedException {
		logger.info("Starting of AddEmployee Method");
		empCreation.clickOnEmployees();
		empCreation.clickOnAddEmpBtn();
		empCreation.switchNewWindow();
		empCreation.enterFirstName(empDataProp.getProperty("firstName"));
		empCreation.enterLastName(empDataProp.getProperty("lastName"));
		empCreation.EmpId();
		empCreation.managerCheckBox();
		empCreation.qrCodeCheckBox();	
		empCreation.EmpEmail();
		empCreation.EmpPhone();
		empCreation.clickOnSaveBtn();
		String actualEmpSavedMsg = empCreation.EmpSavedSuccsusfullyMsg();
		Assert.assertEquals(actualEmpSavedMsg, expectedEmpSavedMsg);
		logger.info("Ending of AddEmployee Method");		
	}
	
	
	@Test(priority = 2, description="Modify the employee data", groups = {"sanity"})
	@Description("Modify the employee")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee modification in list screen")
	public void modifyEmployee() throws InterruptedException {
		logger.info("Starting of modifyEmployee Method");
		empCreation.clickOnFilter();
		empCreation.filterEmployeeName();
		empCreation.clickOnEditButton();
		logger.info("Ending of modifyEmployee Method");
	}
	
	@AfterClass(alwaysRun = true)
	public void logOutForm() {
		logger.info("Starting of Log-out Method");
		empCreation.logOut();	
		logger.info("Ending of log-out Method");
	}
	
	


}
