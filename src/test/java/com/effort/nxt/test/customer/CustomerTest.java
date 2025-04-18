package com.effort.nxt.test.customer;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.base.LoginPage;
import com.effort.customers.CustomerPage;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CustomerTest extends BaseAutomationTest {

	private static final Logger logger = Logger.getLogger(CustomerTest.class.getName());
	private CustomerPage custmrCreation;
	private static final String expectedModifiedMsg = "Customer Modified Successfully";
	private static final String expecteddeletepopupmsg = "Customer Deleted Successfully";

	@BeforeClass(alwaysRun = true)
	@Parameters({ "siteURL", "browser" })
	public void initEffortLogin(String siteURL, String browser) throws Exception {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
		this.goToSite(siteURL, driver);
		this.custmrCreation = new CustomerPage(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterUserName(testDataProp.getProperty("name"));
		this.loginPage.clickOnPassword(testDataProp.getProperty("password1"));
		this.loginPage.clickOnLoginButton();
		this.custmrCreation.ClickonWebApp();

		logger.info("Ending of initEffortLogin Method");
	}

	@Test(priority = 1, description = "Go to Customer and Add customer Details", groups = { "sanity" })
	@Description("Create the Customer and Add the Customer Details")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Customer Creation on clicking add Customer button")
	public void AddCustomer() throws InterruptedException {
		logger.info("Starting of AddCustomer Method");
		custmrCreation.ClickonCustomer();
		custmrCreation.ClickonAddCustomerBtn();
		custmrCreation.SwitchNewWindow();
		custmrCreation.EnterCustomerID();
		custmrCreation.EnterCustomerName(custmrDataProp.getProperty("firstName"));
		custmrCreation.CustmrPhone();
		custmrCreation.CustmrLocationLat(custmrDataProp.getProperty("lat"));
		custmrCreation.CustmrLocationlong(custmrDataProp.getProperty("log"));
		custmrCreation.EnterCustmrStreet(custmrDataProp.getProperty("street"));
		custmrCreation.EnterCustmrLandmark(custmrDataProp.getProperty("landmark"));
		custmrCreation.EnterCustmrArea(custmrDataProp.getProperty("area"));
		custmrCreation.EnterCustmrCity(custmrDataProp.getProperty("city"));
		custmrCreation.EnterCustmrDistrict(custmrDataProp.getProperty("district"));
		custmrCreation.EnterCustmrPincode(custmrDataProp.getProperty("pincode"));
		custmrCreation.EnterCustmrState(custmrDataProp.getProperty("state"));
		custmrCreation.selectCountry();
		custmrCreation.EnterCustmrText(custmrDataProp.getProperty("text"));
		custmrCreation.PrimryCustmrFirstName(custmrDataProp.getProperty("primryfirstname"));
		custmrCreation.PrimryCustmrLastName(custmrDataProp.getProperty("primrylastname"));
		custmrCreation.PrimryCustmrTitle(custmrDataProp.getProperty("primrytitle"));
		custmrCreation.PrimryCustmrPhone();
		custmrCreation.PrimryCustmrEmail();
		custmrCreation.SecondryCustmrFirstName(custmrDataProp.getProperty("secondryfirstname"));
		custmrCreation.SecondryCustmrLastName(custmrDataProp.getProperty("secondrylastname"));
		custmrCreation.SecondryCustmrTitle(custmrDataProp.getProperty("secondrytitle"));
		custmrCreation.SecondryCustmrPhone();
		custmrCreation.SecondryCustmrEmail();
		custmrCreation.ClickonSaveButton();
		logger.info("Ending of AddCustomer Method");
	}

	@Test(priority = 2, description = "Modify Customer Data by Clicking Edit Button", groups = "sanity")
	@Description("Modification of Customer Details")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Customer modification by clicking edit button")
	public void modifyCustomer() throws InterruptedException {
		logger.info("Starting of modifyCustomer Method");
		custmrCreation.ClickonEditBtn();
		custmrCreation.ModifiedCustomerID();
		custmrCreation.ModifiedCustomerName(custmrDataProp.getProperty("modifiedcustomername"));
		custmrCreation.ModifiedCustomeraddstreet(custmrDataProp.getProperty("modifiedaddstreet"));
		custmrCreation.ModifiedCustomerLandmark(custmrDataProp.getProperty("modifiedlandmark"));
		custmrCreation.ModifiedPrimryFirstName(custmrDataProp.getProperty("modifiedprimryfirstname"));
		custmrCreation.ModifiedsecondryFirstName(custmrDataProp.getProperty("modifiedsecondryfirstname"));
		custmrCreation.ClickonSaveButton();
		String actualMsg = custmrCreation.CaptureModifiedMsg();
		Assert.assertEquals(actualMsg, expectedModifiedMsg);
		logger.info("Ending of modifyCustomer Method");
	}

	@Test(priority = 3, description = "Mapping Customer to Employee by Selecting Checkbox", groups = "sanity")
	@Description("Mapping Customer to Employee")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Mapping Customers to Employee to asign Work")
	public void CustmrtoEmployeeMapping() throws InterruptedException {
		logger.info("Starting of CustmrtoEmployeeMapping");
		custmrCreation.CustmrMaptoEmployee();
		custmrCreation.AssignCustmrtoEmployee();
		custmrCreation.ClickonAssign();
		logger.info("Ending of CustmrtoEmployeeMapping");
	}

	@Test(priority = 4, description = "Deleting Customers by Selecting Checkbox", groups = "sanity")
	@Description("Deleting Customers")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Deleting the Customers")

	public void customerDeletion() throws InterruptedException {
		logger.info("Starting of customerDeletion Method");
		custmrCreation.SelectCustmrtoDelete();
		custmrCreation.ClickonDeleteBtn();
		String deletepopupmsg = custmrCreation.ClickonDeleteBtn();
		Assert.assertEquals(deletepopupmsg, expecteddeletepopupmsg);
		logger.info("Ending of customerDeletion Method");
	}

	@AfterClass(alwaysRun = true)
	public void LogOutCustomer() {
		logger.info("Starting of LogOutCustomer Method");
		custmrCreation.LogOut();
		logger.info("Ending of LogOutCustomer Method");

	}

}
