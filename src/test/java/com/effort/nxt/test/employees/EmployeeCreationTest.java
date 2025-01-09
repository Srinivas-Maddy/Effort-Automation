package com.effort.nxt.test.employees;

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
	
	
	@Test(priority = 1, description="Go to Employees and Add the employee details", groups = {"sanity"} )
	@Description("Create the employee")
	@Epic("Employee Module")
	@Feature("Employee Creation")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Employee creation by clicking on add employee button")
	public void AddEmployee() {
		logger.info("Starting of AddEmployee Method");
		
		//Step 1: Click on Web App
		loginPage.ClickonWebApp();
		
		//Step 2: Click on Cancel button on action required
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		
		//Step 3: Click on the employee module
		empCreation.clickOnEmployees();
		
		//Step 4: Click on the add employee btn
		empCreation.clickOnAddEmpBtn();
		
		//Step 5: Add the Basic fields data
		this.addEmpBasicFields();
		
		//Validate whether employee created successfully or not		
		Assert.assertEquals(empCreation.saveAndValidateEmployeCreated(), expectedAssertionsProp.getProperty("emp.created.status"));
		
		logger.info("Ending of AddEmployee Method");		
	}
	
	
	@Test(priority = 2, description="Employee Creation with user defined fields", groups = {"sanity"}, enabled=true)
	@Epic("Employees")
	@Feature("Employee Creation with user defined fields")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Create employee along with the user defined fields")
	public void  employeeCreationWithUserDefinedFields() {
		logger.info("Starting of employeeCreationWithUserDefinedFields Method");
		
		//Step 1: Click on Employee module
		empCreation.clickOnEmployees();
		
		//Step 2: Click On Add Employee Button
		empCreation.clickOnAddEmpBtn();
		
		//Step 3: Enter the basic details.
		this.addEmpBasicFields();
		
		//Step 4: Click on User defined field section
		empCreation.clickOnUserDefinedSection();
		
		//Step 5: Enter the user defined text field data
		empCreation.enterUserDefinedValue(empDataProp.getProperty("userdefined.text.label"),
				                          empDataProp.getProperty("userdefined.text.value"));
		
		//Step 6: Enter the user defined number field data
		empCreation.enterUserDefinedValue(empDataProp.getProperty("userdefined.number.label"),
                                          empDataProp.getProperty("userdefined.number.value"));
		
		//Step 7: Enter the user defined currency value data
		empCreation.enterUserDefinedValue(empDataProp.getProperty("userdefined.currency.label"),
                                          empDataProp.getProperty("userdefined.currency.value"));
		
		//Step 8: Pick the user defined date value
		empCreation.datePicker(empDataProp.getProperty("userdefined.date.label"));
		
		
		//Step 9: Enter the user defined Email data
		empCreation.enterUserDefinedValue(empDataProp.getProperty("userdefined.email.label"),
                                          empDataProp.getProperty("userdefined.email.value"));
		
		
		//Step 10: Enter the Phone number
		empCreation.enterUserDefinedValue(empDataProp.getProperty("userdefined.phone.label"),
		                                  empDataProp.getProperty("userdefined.phone.value"));
		
		//Validate whether employee created successfully or not		
	    Assert.assertEquals(empCreation.saveAndValidateEmployeCreated(), expectedAssertionsProp.getProperty("emp.created.status"));		
		
		
		logger.info("Ending of employeeCreationWithUserDefinedFields Method");
	}
	
	@Test(priority = 3, description="Modify the employee data", groups = {"sanity"},enabled=true)
	@Description("Modify the employee")
	@Epic("Employee Module")
	@Feature("Employee Modification")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Employee modification in list screen")
	public void modifyEmployee() {
		logger.info("Starting of modifyEmployee Method");
		
		//Step 1: Click on Employee
		empCreation.clickOnFilter();
		
		//Step 2: Filter Employee by name
		empCreation.filterEmployeeName();
		
		//Step 3: Click on the edit button
		empCreation.clickOnEditButton();
		
		//Step 4: Modified the first name
		empCreation.enterModifiedFirstName(empDataProp.getProperty("Emp.Modified.FirstName"));
		
		//Step 5: Modified the last name
		empCreation.enterModifiedLastName(empDataProp.getProperty("Emp.Modified.lastName"));
		
		//Step 6: Click on the save
		empCreation.clickOnSave();
		
		Assert.assertEquals(empCreation.getStatus(), expectedAssertionsProp.getProperty("emp.modified.status"));

		logger.info("Ending of modifyEmployee Method");
	}
	
	
	
	@Test(priority = 4, description="Customer Mapping through the employee screen", groups = {"sanity"},enabled=true)
	@Description("We are mapping the customers to the employeess in the employee module")
	@Epic("Employee Module")
	@Feature("Employee Customer Mapping")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Customer Mapping in action Option")
	public void customerMappingEmployee() {
		logger.info("Starting of customerMappingEmployee Method");
		
			//Step 1: Open the three dots menu
			empCreation.clickOnThreeDots();
			
			//Step2: Select Customer Mapping Option
			empCreation.clickOnCustomerMappingOption();
			
			//Step3: Open Map More Customer Option
			empCreation.clickOnMapMoreOption();
			
			//Step4: Select the top 5 customers in the picker
			empCreation.selectCustomers();
			
			//Step5: Click On Ok Button in the customer picker
			empCreation.clickOnOkay();
			
			//Step6: Click on the save button
			empCreation.clickOnMappingSave();
			
		logger.info("Ending of customerMappingEmployee Method");
	}
	
	
	@Test(priority = 5, description="List Mapping through the employee screen", groups = {"sanity"},enabled=true)
	@Description("We are mapping the List items to the employeess in the employee module")
	@Epic("Employee Module")
	@Feature("Employee List Mapping")
	@Severity(SeverityLevel.CRITICAL)
	@Story("List Mapping in action Option")
	public void listItemsMapToEmp() {
		logger.info("Starting of listItemsMapToEmp Method");
		
		    //Step 1: Click on Employee Filter
		    empCreation.clickOnFilter();
				
		   //Step 2: Click on Reset
		    empCreation.clickOnReset();
				
		    //Step 3: Search employee by id.
	        empCreation.filterEmpById();
	        
			//Step 1: Open the three dots menu
			empCreation.clickOnThreeDots();
			
			//Step2: Select List Mapping Option
			empCreation.clickOnListMappingOption();
			
			//Step3: Select the List Spec Icon in the list
			empCreation.clickOnListSpecIcon();
			
			//Step4: Click on the Map More option
			empCreation.clickOnMapMoreOptionList();
			
			//Step5: Select the list items in the picker
			empCreation.selectListItems();
			
			//Step6: Click on the Ok button
			empCreation.clickOnOkListPicker();
			
			//Step7: Clicked On save button on mapping
			empCreation.clickOnSaveListMapping();
			
		
		logger.info("Ending of listItemsMapToEmp Method");
	}
	
	@Test(priority = 6, description="Send the new Email Password", groups = {"sanity"},enabled=true)
	@Description("We will send the new password to the employee")
	@Epic("Employee Module")
	@Feature("Send New Password")
	@Severity(SeverityLevel.CRITICAL)
	@Story("List Mapping in action Option")
	public void sendNewPassword() {
		logger.info("Starting of sendNewPassword Method");
		
		//Step 1: Click on Filter
		empCreation.clickOnFilter();

		//Step 2: Enter the employee name
		empCreation.enterEmployeeName("Srinivas Maddy");
		
		//Step 3: Click On Apply Filter Btn
		empCreation.clickOnApply();
		
		//Step 4: Open the three dots menu
		empCreation.clickOnThreeDots();
		
		//Step 5: Click On the Send new password via email
		empCreation.clickOnSendNewOption();
		
		//Step 7: Validate whether password send Successfully or not
		Assert.assertEquals(empCreation.getStatus(), expectedAssertionsProp.getProperty("emp.password.status"));
		
		logger.info("Ending of sendNewPassword Method");
	}
	
	

	@Test(priority = 7, description="Creating Web Account Access", groups = {"sanity"},enabled=true)
	@Description("Creating web account access")
	@Epic("Employee Module")
	@Feature("Create Web Account")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Create Web Account")
	public void createWebAcccount() {
		logger.info("Starting of createWebAcccount Method");
		
		  //Step 1: Click on Employee Filter
	    empCreation.clickOnFilter();
			
	   //Step 2: Click on Reset
	    empCreation.clickOnReset();
			
	    //Step 3: Search employee by id.
        empCreation.filterEmpById();
		
		//Step 4: Open the three dots menu
		empCreation.clickOnThreeDots();
		
		//Step 5: Click on Create web Account option
		empCreation.clickOnCreateWebAccount();
		
		
		logger.info("Ending of createWebAcccount Method");
	}
	
	@Test(priority = 8, description="Deleteting Web Account Access", groups = {"sanity"},enabled=true)
	@Description("Creating web account access")
	@Epic("Employee Module")
	@Feature("Delete Web Account")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Delete Web Account")
	public void deleteWebAcccount() {
		logger.info("Starting of deleteWebAcccount Method");
		
		//Step 1: Click on Employee Filter
	    empCreation.clickOnFilter();
			
	    //Step 2: Click on Reset
	    empCreation.clickOnReset();
			
	    //Step 3: Search employee by id.
        empCreation.filterEmpById();
		
		//Step 4: Open the three dots menu
		empCreation.clickOnThreeDots();
		
		//Step 5: Click on Create web Account option
		empCreation.clickOnDeleteWebAccount();
		
		
		logger.info("Ending of deleteWebAcccount Method");
	}
	
	@Test(priority =9, description="Generating the activation code", groups = {"sanity"},enabled=true)
	@Description("Genarate Activation code from web")
	@Epic("Generate Activation code")
	@Feature("Generate activation code")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Activation code")
	public void generateMobileActiviationCode() {
		logger.info("Starting of generateMobileActiviationCode Method");
		
		//Step 1: Open the three dots menu
		empCreation.clickOnThreeDots();
		
		//Step2: Select generate mobile activation code option
		empCreation.clickOnActivationOption();
		
		//Step 3: Validate whether activation code send Successfully or not
		Assert.assertEquals(empCreation.getStatus(), expectedAssertionsProp.getProperty("emp.activation.status"));
		
		logger.info("Ending of generateMobileActiviationCode Method");
	}
	
	
	@Test(priority =10, description="Mapping the territories to the employees", groups = {"sanity"},enabled=true)
	@Description("Territory mapping")
	@Epic("Employee Module")
	@Feature("Employee territory Mapping")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Mapping")
	public void territoryMapping() {
		logger.info("Starting of territoryMapping Method");
		
		//Step 1: Click on Employee Filter
	    empCreation.clickOnFilter();
			
	    //Step 2: Click on Reset
	    empCreation.clickOnReset();
			
	    //Step 3: Search employee by id.
        empCreation.filterEmpById();
		
		//Step 4: Open the three dots menu
		empCreation.clickOnThreeDots();
		
		//Step 5: Click On territory mapping option
		empCreation.clickOnTerritoryMappingOption();
		
		//Step 6: Select the Value in the territory.
		empCreation.selectTerriotryValue();
		
		//Step 7: Click On Save
		empCreation.clickOnSaveMapping();
		
		//Step 8: Validate the Save territoru message
		Assert.assertEquals(empCreation.getStatus(), expectedAssertionsProp.getProperty("emp.territory.mapping.status"));

		logger.info("Ending of territoryMapping Method");
	}
	
	
	@Test(priority =11, description="Mapping the Route plan to the employees", groups = {"sanity"},enabled=true)
	@Description("Route mapping")
	@Epic("Employee Module")
	@Feature("Employee Route Mapping")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Mapping")
	public void routePlanMapping() {
		logger.info("Starting of routePlanMapping Method");
		
		//Step 1: Click on Employee Filter
	    empCreation.clickOnFilter();
			
	    //Step 2: Click on Reset
	    empCreation.clickOnReset();
			
	    //Step 3: Search employee by id.
        empCreation.filterEmpById();
		
		//Step 4: Open the three dots menu
		empCreation.clickOnThreeDots();
		
		//Step 5: Click on Route plan mapping option
		empCreation.clickOnRouteMappingOption();
		
		//Step 6: Select the route plan
		empCreation.selectRoutePlan();
		
		//Step 7: Click On Save
		empCreation.clickOnSaveMapping();
		
		//Step 8: Validate the Save route plan message
		Assert.assertEquals(empCreation.getStatus(), expectedAssertionsProp.getProperty("emp.route.mapping.status"));
		
		logger.info("Ending of routePlanMapping Method");
	}
	
	@Test(priority =12, description="Mapping the Customer type to the employees", groups = {"sanity"},enabled=true)
	@Description("Customer type mapping")
	@Epic("Employee Module")
	@Feature("Employee Customer type Mapping")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Mapping")
	public void customerTypeMapping() {
		logger.info("Starting of customerTypeMapping Method");
		
		//Step 1: Click on Employee Filter
	    empCreation.clickOnFilter();
			
	    //Step 2: Click on Reset
	    empCreation.clickOnReset();
			
	    //Step 3: Search employee by id.
        empCreation.filterEmpById();
		
		//Step 4: Open the three dots menu
		empCreation.clickOnThreeDots();
		
		//Step 5: Click on the type mapping
		empCreation.clickOnTypeMappingOption();
		
		//Step 6: Select the type value
		empCreation.selectTypeValue();
		
		//Step 7: Click On Save
		empCreation.clickOnSaveMapping();
				
		//Step 8: Validate the Save route plan message
		Assert.assertEquals(empCreation.getStatus(), expectedAssertionsProp.getProperty("emp.type.mapping.status"));
		
		
		logger.info("Ending of customerTypeMapping Method");
	}
	
	@Test(priority =13, description="Employee Disable", groups = {"sanity"},enabled=true)
	@Description("Disable Employee")
	@Epic("Employee Module")
	@Feature("Employee Disable")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Employee Disable in list screen")
	public void disableEmployee() {
		logger.info("Starting of Employee Disable Method");
		
		//Step 1: Click on Employee Filter
		empCreation.clickOnFilter();
		
		//Step 2: Click on Reset
		empCreation.clickOnReset();
		
		//Step 3: Search employee by id.
		empCreation.filterEmpById();
		
		//Step 4: Click on deleted button
		empCreation.disableEmployee();	
		
		logger.info("Ending of Employee Disable Method");
	}
	
	
	@Test(priority =14, description="Employee Total Count Validation", groups = {"sanity"})
	@Description("Validate the Total Employee count")
	@Epic("Employee Module")
	@Feature("Total Employess Count Display")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Employee Count Validate")	
	public void totalEmployeeCoutValidation() {
		logger.info("Starting of totalEmployeeCoutValidation Method");
		
		//Step 1: Click On Total Employee btn
		empCreation.clickOnTotalEmpBtn();
		
		//Step 2: Get the count from Page nation
		empCreation.getTotalEmpCount();
		
		//Step 3: Get the Actual Count in the Button
		String totalCount=empCreation.totalEmpCount;
		
		//Validate the both count are same or not
		Assert.assertEquals(empCreation.getTotalEmpCount(), totalCount);
		
		logger.info("Ending of totalEmployeeCoutValidation Method");
	}
	
	@Test(priority =15, description="Validate the Pending Approval Count", groups = {"sanity"})
	@Description("Validate the Pending Validate Count")
	@Epic("Employee Module")
	@Feature("Pending Approval")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Pending Approval Count Validate")
	public void pendingApprovalCountValidation() {
		logger.info("Starting of pendingApprovalCountValidation Method");
		
	    //Step 1: Click On Pending Approval Count 
		empCreation.clickOnPendingApproval();
		
		//Step 2: Get the pending approval Count in the approval screen
		String approvalCount=empCreation.approvalCountValue;
		
		//Validate the both count are same or not
		Assert.assertEquals(empCreation.getApprovalCount(), approvalCount);
		
		logger.info("Ending of pendingApprovalCountValidation Method");
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
