package com.effort.nxt.test.customer;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.effort.common.WebDriversEnum;
import com.effort.customers.CustomerPage;
import com.effort.nxt.test.BaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CustomerTest extends BaseAutomationTest {

	private static final Logger logger = Logger.getLogger(CustomerTest.class.getName());
	private CustomerPage custmrCreation;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "siteURL", "browser", "userName", "password", "headless" })
	public void initEffortLogin(String siteURL, String browser, String userName, String password, String headless)
			throws Exception {
		logger.info("Starting of initEffortLogin Method");
		this.driver = this.getWebDriver(browser, headless, WebDriversEnum.CUSTUMERTEST_DRIVER);
		this.goToSite(siteURL, driver);
		this.custmrCreation = new CustomerPage(driver);
		LoginToApplication(userName, password);

		logger.info("Ending of initEffortLogin Method");
	}

	@Test(priority = 1, description = "Go to Customer and Add customer Details", groups = { "sanity" })
	@Description("Create the Customer and Add the Customer Details")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Customer Creation on clicking add Customer button")
	public void AddCustomer() throws InterruptedException, IOException {
		logger.info("Starting of AddCustomer Method");

		loginPage.ClickonWebApp();
		loginPage.clickOnCancelButtonOnWebAppHomeScreen();
		custmrCreation.ClickonCustomer();
		custmrCreation.ClickonAddCustomerBtn();
		custmrCreation.SwitchNewWindow();
		custmrCreation.EnterCustomerID();
		custmrCreation.EnterCustomerName(custmrDataProp.getProperty("firstName"));
		custmrCreation.customerPhoneNumber();
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
		custmrCreation.enterCustomerCurrency(custmrDataProp.getProperty("customercurrency"));
		custmrCreation.clickOnDatePicker();
		custmrCreation.pickCurrentDate();
		custmrCreation.clickOnDate1Picker();
		custmrCreation.pickCurrentDate1();
		custmrCreation.clickOnDateTimePicker();
		custmrCreation.pickCurrentDateTime();
		custmrCreation.clickOnDateTime1Picker();
		custmrCreation.pickCurrentDateTime1();
		custmrCreation.enterCustomFieldNumber(custmrDataProp.getProperty("number"));
		custmrCreation.pickTime();
		custmrCreation.enterCustomFieldEmail(custmrDataProp.getProperty("customfieldemail"));
		custmrCreation.selectCustomFieldLat(custmrDataProp.getProperty("customfieldLat"));
		custmrCreation.selectCustomFieldLog(custmrDataProp.getProperty("customfieldLog"));
		custmrCreation.enterCustomFieldPhone();
		custmrCreation.enterCustomFieldURL(custmrDataProp.getProperty("customfieldurl"));
		custmrCreation.selectAudio();
		custmrCreation.selectImage();
		custmrCreation.selectSignature();
		custmrCreation.selectVideo();
		custmrCreation.pickCustomEntity();
		custmrCreation.pickCustomer();
		custmrCreation.pickEmployee();
		custmrCreation.pickForm();
		custmrCreation.pickYesOrNo();
		custmrCreation.pickMultiPickList();
		custmrCreation.pickMultiSelectDropDown();
		custmrCreation.pickPickList();
		custmrCreation.enterGroupNumber(custmrDataProp.getProperty("GroupNumber"));
		custmrCreation.pickGroupTime();
		custmrCreation.pickDropDown();
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
		Assert.assertEquals(custmrCreation.customerCreatedSuccesMsg(),
				expectedAssertionsProp.getProperty("customer.created.text"));

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
		// String actualMsg = custmrCreation.CaptureModifiedMsg();
		// Assert.assertEquals(actualMsg, EXPECTEDMODIFIEDMSG);

		Assert.assertEquals(custmrCreation.CaptureModifiedMsg(),
				expectedAssertionsProp.getProperty("customer.modified.text"));

		logger.info("Ending of modifyCustomer Method");
	}

	@Test(priority = 3, description = "Mapping Customer to Employee by SelectingCheckbox", groups = "sanity")
	@Description("Mapping Customer to Employee")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Mapping Customers to Employee to asign Work")
	public void CustmrtoEmployeeMapping() throws InterruptedException {
		logger.info("Starting of CustmrtoEmployeeMapping");
		
		custmrCreation.CustmrMaptoEmployee();
		custmrCreation.AssignCustmrtoEmployee();
		custmrCreation.ClickonAssign(custmrDataProp.getProperty("empname"),
				custmrDataProp.getProperty("dropdownempname"));
		
		logger.info("Ending of CustmrtoEmployeeMapping");
	}

	@Test(priority = 4, description = "Deleting Customers by Selecting Checkbox", groups = "sanity")
	@Description("Deleting Customers")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Deleting the Customers")
	public void customerDeletion() throws InterruptedException {
		logger.info("Starting of customerDeletion Method");
		custmrCreation.SelectCustmrtoDelete();
		// String deletepopupmsg =custmrCreation.ClickonDeleteBtn();
		// Assert.assertEquals(deletepopupmsg, EXPECTEDDELETEPOPUPMSG);

		Assert.assertEquals(custmrCreation.ClickonDeleteBtn(),
				expectedAssertionsProp.getProperty("customer.deleted.text"));

		logger.info("Ending of customerDeletion Method");
	}

	@Test(priority = 5, description = "Verify Customer matrix", groups = "sanity")
	@Description("Deleting Customers")
	@Severity(SeverityLevel.BLOCKER)
	@Story("verfiying the Customers matrix")
	public void customerMatrixValidation() {
		logger.info("Starting of customerMatrixValidation Method");

		Assert.assertTrue(custmrCreation.isTotalCustomerCountDisplayed());
		Assert.assertTrue(custmrCreation.isPendingRequisitionApprovalsCountDisplayed());
		Assert.assertTrue(custmrCreation.isTotalVisitsTodayCountDisplayed());

		logger.info("Ending of customerMatrixValidation Method");
	}

	@Test(priority = 6, description = "Verify activity snapshot page", groups = "sanity")
	@Description("activity SnapShot Validation Customers")
	@Severity(SeverityLevel.BLOCKER)
	@Story("activity SnapShot Validation")
	public void activitySnapShotValidation() {
		logger.info("Starting of activitySnapShotValidation Method");

		custmrCreation.clickOnActivitySnapshotButton();

		Assert.assertTrue(custmrCreation.isPlannedCustomersCountDisplayed());
		Assert.assertTrue(custmrCreation.isActualCustomerVisitsCountDisplayed());
		Assert.assertTrue(custmrCreation.isUnplannedCustomerVisitsCountDisplayed());

		Assert.assertTrue(custmrCreation.isFormActivitiesCountDisplayed());

		logger.info("Ending of activitySnapShotValidation Method");
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
