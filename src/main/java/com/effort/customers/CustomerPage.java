package com.effort.customers;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;
import com.effort.base.LoginPage;

public class CustomerPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(LoginPage.class.getName());

	String parentwind = driver.getWindowHandle();

	String CustomerFirstName = null;

	@FindBy(xpath = "//a[contains(text(),'Web App')]")
	private WebElement webApp;

	@FindBy(xpath = "//a[contains(text(),'Customers')]")
	private WebElement customers;

	@FindBy(xpath = "//li/a/button[@type='button']")
	private WebElement addCustomer;

	@FindBy(xpath = "//input[@id='field_2']")
	private WebElement customerId;

	@FindBy(xpath = "//input[@id='field_1']")
	private WebElement customerName;

	@FindBy(xpath = "//input[@id=\"field_3\"]")
	private WebElement customerPhone;

	@FindBy(xpath = "//input[@id='customerLat']")
	private WebElement custmrlatitude;

	@FindBy(xpath = "//input[@id='customerLong']")
	private WebElement custmrlongitude;

	//	@FindBy(xpath = "//img[@id=\"map\"]")
	//	private WebElement customerMap;
	//
	//	@FindBy(xpath = "//span[text()='Confirm Location']")
	//	private WebElement confirmLocation;

	@FindBy(xpath = "//input[@id=\"field_5\"]")
	private WebElement addStreet;

	@FindBy(xpath = "//input[@id=\"field_8\"]")
	private WebElement landMark;

	@FindBy(xpath = "//input[@id=\"field_6\"]")
	private WebElement area;

	@FindBy(xpath = "//input[@id=\"field_7\"]")
	private WebElement city;

	@FindBy(xpath = "//input[@id=\"field_22\"]")
	private WebElement district;

	@FindBy(xpath = "//input[@id=\"field_11\"]")
	private WebElement pinCode;

	@FindBy(xpath = "//input[@id=\"field_9\"]")
	private WebElement state;

	@FindBy(xpath = "//div[@id='s2id_field_10']")
	private WebElement countryDropDown;

	@FindBy(xpath = "//ul[@class='select2-results']/li/div")
	private List<WebElement> countryNames;

	@FindBy(xpath = "//input[@id='fields2_fieldValue']")
	private WebElement text;

	@FindBy(xpath = "//input[@id='field_12']")
	private WebElement primryCustmrFirstName;

	@FindBy(xpath = "//input[@id='field_13']")
	private WebElement primryCustmrLastName;

	@FindBy(xpath = "//input[@id='field_14']")
	private WebElement primryCustmrTitle;

	@FindBy(xpath = "//input[@id='field_16']")
	private WebElement primryCustmrPhone;

	@FindBy(xpath = "//input[@id='field_15']")
	private WebElement primryCustmrEmail;

	@FindBy(xpath = "//input[@id='field_17']")
	private WebElement secondryCustmrFirstName;

	@FindBy(xpath = "//input[@id='field_18']")
	private WebElement secondryCustmrLastName;

	@FindBy(xpath = "//input[@id='field_19']")
	private WebElement secondryCustmrTitle;

	@FindBy(xpath = "//input[@id='field_21']")
	private WebElement secondryCustmrPhone;

	@FindBy(xpath = "//input[@id='field_20']")
	private WebElement secondryCustmrEmail;

	@FindBy(xpath = "//input[@id='save']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//form[@id='command']")
	private WebElement form;

	@FindBy(xpath = "//table[@id='example']/tbody//td[@class=' dt-body-center'][2]/div/a/i")
	private List<WebElement> editBtn;

	@FindBy(xpath = "//div[@id='snackbar']")
	private WebElement modifiedmsg;

	@FindBy(xpath = "//tbody//input[@id='selectWork']")
	private List<WebElement> custmrmapingcheckbox;

	@FindBy(id = "assignTo")
	private WebElement ReAssign;

	@FindBy(xpath = "//a[@class='select2-choice select2-default']")
	private WebElement assignDrpDown;

	@FindBy(xpath = "//input[@id='s2id_autogen3_search']")
	private WebElement enterFieldInput;

	@FindBy(xpath = "//ul[@id='select2-results-3']/li/div/span")
	private WebElement empNameInDropDown;

	@FindBy(id = "assignCustomers")
	private WebElement applyBtn;

	@FindBy(id="deleteCustomers")
	private WebElement deleteBtn;

	@FindBy(xpath = "//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath = "//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;

	public CustomerPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void ClickonWebApp() {
		logger.info("Starting of Click on Web App Method");
		waitUntilElementVisible(driver, webApp);
		this.webApp.click();
		logger.info("Ending of Click on Web App Method ");

	}

	public void ClickonCustomer() {
		logger.info("Starting of ClickonCustomer Method");
		waitUntilElementVisible(driver, customers);
		this.customers.click();
		logger.info("Ending of ClickonCustomer Method");
	}

	public void ClickonAddCustomerBtn() {
		logger.info("Starting of ClickonAddCustomerBtn Method");
		waitUntilElementVisible(driver, addCustomer);
		this.addCustomer.click();
		logger.info("Ending of ClickonAddCustomerBtn Method");
	}

	public void SwitchNewWindow() {
		logger.info("Starting of SwitchNewWindow Method");
		Set<String> newwindows = driver.getWindowHandles();
		Iterator<String> I1 = newwindows.iterator();
		while (I1.hasNext()) {
			String child_Window = I1.next();
			if (!parentwind.equals(child_Window)) {
				driver.switchTo().window(child_Window);
			}
		}
		logger.info("Ending of SwitchNewWindow Method");
	}

	public void EnterCustomerID() {
		logger.info("Starting of EnterCustomerID Method");
		String cutmrID = getUniqueNumber("Auto_CUSTMR");
		waitUntilElementVisible(driver, customerId);
		customerId.sendKeys(cutmrID);
		logger.info("Ending of EnterCustomerID Method");
	}

	public void EnterCustomerName(String enterCustomerName) {
		logger.info("Starting of EnterCustomerName Method");
		waitUntilElementVisible(driver, customerName);
		this.CustomerFirstName = enterCustomerName + "_" + getCurrentDate();
		customerName.sendKeys(this.CustomerFirstName);
		logger.info("Ending of EnterCustomerName Method");
	}

	public void CustmrPhone() {

		logger.info("Starting of CustmrPhone Method");
		String RandomPhone = randomMobileNumbers();
		waitUntilElementVisible(driver, customerPhone);
		customerPhone.sendKeys(RandomPhone);
		logger.info("Ending of CustmrPhone Method");
	}

	public void CustmrLocationLat(String CustmrLat) {
		logger.info("Starting of CustmrLocationLat Method");
		waitUntilElementVisible(driver, custmrlatitude);
		this.custmrlatitude.sendKeys(CustmrLat);
		logger.info("Ending of CustmrLocationLat Method");
	}

	public void CustmrLocationlong(String CustmrLong) {
		logger.info("Starting of CustmrLocationlong Method");
		waitUntilElementVisible(driver, custmrlongitude);
		this.custmrlongitude.sendKeys(CustmrLong);
		logger.info("Ending of CustmrLocationlong Method");
	}

	public void EnterCustmrStreet(String Customerstreet) {
		logger.info("Starting of EnterCustmrStreet Method");
		waitUntilElementVisible(driver, addStreet);
		this.addStreet.sendKeys(Customerstreet);
		logger.info("Ending of EnterCustmrStreet Method");
	}

	public void EnterCustmrLandmark(String CustomerLandmark) {
		logger.info("Starting of EnterCustmrLandmark Method");
		waitUntilElementVisible(driver, landMark);
		this.landMark.sendKeys(CustomerLandmark);
		logger.info("Ending of EnterCustmrLandmark Method");
	}

	public void EnterCustmrArea(String EntercustomerArea) {
		logger.info("Starting of EnterCustmrArea Method");
		waitUntilElementVisible(driver, area);
		this.area.sendKeys(EntercustomerArea);
		logger.info("Ending of EnterCustmrArea Method");
	}

	public void EnterCustmrCity(String EntercustomerCity) {
		logger.info("Starting of EnterCustmrCity Method");
		waitUntilElementVisible(driver, city);
		this.city.sendKeys(EntercustomerCity);
		logger.info("Ending of EnterCustmrCity Method");
	}

	public void EnterCustmrDistrict(String EntercustomerDistrict) {
		logger.info("Starting of EnterCustmrDistrict Method");
		waitUntilElementVisible(driver, district);
		this.district.sendKeys(EntercustomerDistrict);
		logger.info("Ending of EnterCustmrDistrict Method");
	}

	public void EnterCustmrPincode(String EntercustomerPincode) {
		logger.info("Starting of EnterCustmrPincode Method");
		waitUntilElementVisible(driver, pinCode);
		this.pinCode.sendKeys(EntercustomerPincode);
		logger.info("Ending of EnterCustmrPincode Method");
	}

	public void EnterCustmrState(String EntercustomerState) {
		logger.info("Starting of EnterCustmrState Method");
		waitUntilElementVisible(driver, state);
		this.state.sendKeys(EntercustomerState);
		logger.info("Ending of EnterCustmrState Method");
	}

	public void selectCountry() {
		logger.info("Starting of Country Select Method");
		waitUntilElementVisible(driver, this.countryDropDown);
		this.countryDropDown.click();
		for (int i = 0; i <this.countryNames.size(); i++) {
			String countryName = this.countryNames.get(i).getText();
			if (countryName.equalsIgnoreCase("India")) {
				waitUntilElementVisible(driver, this.countryNames.get(i));
				this.countryNames.get(i).click();
				break;
			}
		}
		logger.info("Ending of Country Select Method");
	}

	public void EnterCustmrText(String EnterText) {
		logger.info("Starting of EnterCustmrText Method");
		waitUntilElementVisible(driver, text);
		this.text.sendKeys(EnterText);
		logger.info("Ending of EnterCustmrText Method");
	}

	public void PrimryCustmrFirstName(String EnterFirstName) {
		logger.info("Starting of PrimryCustmrFirstName Method");
		waitUntilElementVisible(driver, primryCustmrFirstName);
		this.primryCustmrFirstName.sendKeys(EnterFirstName);
		logger.info("Ending of PrimryCustmrFirstName Method");
	}

	public void PrimryCustmrLastName(String EnterLastName) {
		logger.info("Starting of PrimryCustmrLastName Method");
		waitUntilElementVisible(driver, primryCustmrLastName);
		this.primryCustmrLastName.sendKeys(EnterLastName);
		logger.info("Ending of PrimryCustmrLastName Method");
	}

	public void PrimryCustmrTitle(String EnterPrimeryTitle) {
		logger.info("Starting of PrimryCustmrTitle Method");
		waitUntilElementVisible(driver, primryCustmrTitle);
		this.primryCustmrTitle.sendKeys(EnterPrimeryTitle);
		logger.info("Ending of PrimryCustmrTitle Method");
	}

	public void PrimryCustmrPhone() {
		logger.info("Starting of PrimryCustmrPhone Method");
		String primryrandomphone = randomMobileNumbers();
		waitUntilElementVisible(driver, primryCustmrPhone);
		this.primryCustmrPhone.sendKeys(primryrandomphone);
		logger.info("Ending of PrimryCustmrPhone Method");
	}

	public void PrimryCustmrEmail() {
		logger.info("Starting of PrimryCustmrEmail Method");
		String primryrandmEmail = randomEmailGenerator();
		waitUntilElementVisible(driver, primryCustmrEmail);
		this.primryCustmrEmail.sendKeys(primryrandmEmail);
		logger.info("Ending of PrimryCustmrEmail Method");
	}

	public void SecondryCustmrFirstName(String EnterFirstName) {
		logger.info("Starting of SecondryCustmrFirstName Method");
		waitUntilElementVisible(driver, secondryCustmrFirstName);
		this.secondryCustmrFirstName.sendKeys(EnterFirstName);
		logger.info("Ending of SecondryCustmrFirstName Method");
	}

	public void SecondryCustmrLastName(String EnterLastName) {
		logger.info("Starting of SecondryCustmrLastName Method");
		waitUntilElementVisible(driver, secondryCustmrLastName);
		this.secondryCustmrLastName.sendKeys(EnterLastName);
		logger.info("Ending of SecondryCustmrLastName Method");
	}

	public void SecondryCustmrTitle(String EnterSecondryTitle) {
		logger.info("Starting of SecondryCustmrTitle Method");
		waitUntilElementVisible(driver, secondryCustmrTitle);
		this.secondryCustmrTitle.sendKeys(EnterSecondryTitle);
		logger.info("Ending of SecondryCustmrTitle Method");
	}

	public void SecondryCustmrPhone() {
		logger.info("Starting of SecondryCustmrPhone Method");
		String SecondryrandomPhone = randomMobileNumbers();
		waitUntilElementVisible(driver, secondryCustmrPhone);
		this.secondryCustmrPhone.sendKeys(SecondryrandomPhone);
		logger.info("Ending of SecondryCustmrPhone Method");
	}

	public void SecondryCustmrEmail() {
		logger.info("Starting of SecondryCustmrEmail Method");
		String secondryRandomEmail = randomEmailGenerator();
		waitUntilElementVisible(driver, secondryCustmrEmail);
		this.secondryCustmrEmail.sendKeys(secondryRandomEmail);
		logger.info("Ending of SecondryCustmrEmail Method");
	}

	public void ClickonSaveButton() {
		logger.info("Starting of ClickonSaveButton Method");
		waitUntilElementVisible(driver, SaveBtn);
		this.SaveBtn.click();
		logger.info("Ending of ClickonSaveButton Method");
	}

	public void ClickonEditBtn() throws InterruptedException {
		logger.info("Starting of ClickonEditBtn Method");
		Thread.sleep(500);
		scrollDown(100, form);
		for (int i = 0; i < editBtn.size(); i++) {
			this.editBtn.get(i).click();
			break;
		}
		logger.info("Ending of ClickonEditBtn Method");
	}

	public void ModifiedCustomerID() throws InterruptedException {
		logger.info("Starting of ModifiedCustomerID Method");
		waitUntilElementVisible(driver, customerId);
		this.customerId.clear();
		String customerModifiedId = randomMobileNumbers();
		this.customerId.sendKeys(customerModifiedId);
		logger.info("Ending of ModifiedCustomerID Method");
	}

	public void ModifiedCustomerName(String MdfydcustomerName) {
		logger.info("Starting of ModifiedCustomerName Method");
		waitUntilElementVisible(driver, customerName);
		this.customerName.clear();
		this.customerName.sendKeys(MdfydcustomerName);
		logger.info("Ending of ModifiedCustomerName Method");
	}

	public void ModifiedCustomeraddstreet(String Mdfydcustomeraddstreet) {
		logger.info("Starting of ModifiedCustomeraddstreet Method");
		waitUntilElementVisible(driver, addStreet);
		this.addStreet.clear();
		this.addStreet.sendKeys(Mdfydcustomeraddstreet);
		logger.info("Ending of ModifiedCustomeraddstreet Method");
	}

	public void ModifiedCustomerLandmark(String Mdfydcustomerlandmark) {
		logger.info("Starting of ModifiedCustomerLandmark Method");
		waitUntilElementVisible(driver, landMark);
		this.landMark.clear();
		this.landMark.sendKeys(Mdfydcustomerlandmark);
		logger.info("Ending of ModifiedCustomerLandmark Method");
	}

	public void ModifiedPrimryFirstName(String MdfydPrimryFirstName) {
		logger.info("Starting of ModifiedPrimryFirstName Method");
		waitUntilElementVisible(driver, primryCustmrFirstName);
		this.primryCustmrFirstName.clear();
		this.primryCustmrFirstName.sendKeys(MdfydPrimryFirstName);
		logger.info("Ending of ModifiedPrimryFirstName Method");
	}

	public void ModifiedsecondryFirstName(String MdfydsecondryFirstName) {
		logger.info("Starting of ModifiedPrimryFirstName Method");
		waitUntilElementVisible(driver, secondryCustmrFirstName);
		this.secondryCustmrFirstName.clear();
		this.secondryCustmrFirstName.sendKeys(MdfydsecondryFirstName);
		logger.info("Ending of ModifiedPrimryFirstName Method");
	}

	public String CaptureModifiedMsg() {
		logger.info("Starting of CaptureModifiedMsg Method");
		waitUntilElementVisible(driver, modifiedmsg);
		String CustmrModifiedMsg = this.modifiedmsg.getText();
		return CustmrModifiedMsg;
	}


	public void CustmrMaptoEmployee() throws InterruptedException {
		logger.info("Starting of CustmrMaptoEmployee Method");
		Thread.sleep(500);
		scrollDown(100, form);
		for (int i = 0; i <=5; i++) {
			this.custmrmapingcheckbox.get(i).click();
		}
		logger.info("Ending of CustmrMaptoEmployee Method");
	}

	public void AssignCustmrtoEmployee() {
		logger.info("Starting of AssignCustmrtoEmployee Method");
		waitUntilElementVisible(driver, ReAssign);
		this.ReAssign.click();
		logger.info("Ending of AssignCustmrtoEmployee Method");

	}

	public void ClickonAssign() {
		logger.info("Starting of ClickonAssign method");
		waitUntilElementVisible(driver, assignDrpDown);
		this.assignDrpDown.click();
		waitUntilElementVisible(driver, enterFieldInput);
		this.enterFieldInput.sendKeys("Automation");
		waitUntilElementVisible(driver, empNameInDropDown);
		this.empNameInDropDown.click();
		waitUntilElementVisible(driver, applyBtn);
		this.applyBtn.click();
		logger.info("Ending of ClickonAssign method");
	}

	public void SelectCustmrtoDelete() throws InterruptedException {
		logger.info("Starting of SelectCustmrtoDelete Method");
		Thread.sleep(500);
		scrollDown(100, form);
		for (int i = 0; i <3; i++) {
			this.custmrmapingcheckbox.get(i).click();
		}
		logger.info("Ending of SelectCustmrtoDelete Method");
	}
	public String ClickonDeleteBtn() throws InterruptedException{
		logger.info("Starting of ClickonDelete Method");
		waitUntilElementVisible(driver, deleteBtn);
		this.deleteBtn.click();
		driver.switchTo().alert().accept();
		Thread.sleep(9000);
		String capturedDeleteMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return capturedDeleteMsg;

	}

	public void LogOut() {
		logger.info("Starting of LogOut Method");
		waitUntilElementVisible(driver, userNameBtn);
		userNameBtn.click();
		if (logoutBtn.get(logoutBtn.size() - 1).getText().equalsIgnoreCase("LogOut")) {
			logoutBtn.get(logoutBtn.size()-1).click();
		}
		logger.info("Ending of LogOut Method");
	}

}
