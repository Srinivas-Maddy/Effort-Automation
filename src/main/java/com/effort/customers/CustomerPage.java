package com.effort.customers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class CustomerPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(CustomerPage.class.getName());

	String parentwind = driver.getWindowHandle();
	String CustomerFirstName = null;

	@FindBy(xpath = "//a[contains(text(),'Web App')]")
	private WebElement webAppCard;

	@FindBy(xpath = "//a[contains(text(),'Customers')]")
	private WebElement customers;

	@FindBy(xpath = "//li/a/button[@type='button']")
	private WebElement addCustomer;

	@FindBy(xpath = "//input[@name='customerNo']")
	private WebElement customerId;

	@FindBy(xpath = "//input[@name='customerName']")
	private WebElement customerName;

	@FindBy(xpath = "//input[@name='customerPhone']")
	private WebElement customerPhone;

	@FindBy(xpath = "//input[@id='customerLat']")
	private WebElement custmrlatitude;

	@FindBy(xpath = "//input[@id='customerLong']")
	private WebElement custmrlongitude;

	@FindBy(xpath = "//input[@name='customerAddressStreet']")
	private WebElement addStreet;

	@FindBy(xpath = "//input[@name='customerAddressLandMark']")
	private WebElement landMark;

	@FindBy(xpath = "//input[@name='customerAddressArea']")
	private WebElement area;

	@FindBy(xpath = "//input[@name='customerAddressCity']")
	private WebElement city;

	@FindBy(xpath = "//input[@name='customerAddressDistrict']")
	private WebElement district;

	@FindBy(xpath = "//input[@name='customerAddressPincode']")
	private WebElement pinCode;

	@FindBy(xpath = "//input[@name='customerAddressState']")
	private WebElement state;

	@FindBy(xpath = "//div[@class='select2-container sysField']")
	private WebElement countryDropDown;

	@FindBy(xpath = "//ul[@class='select2-results']/li/div")
	private List<WebElement> countryNames;

	@FindBy(xpath = "//input[@name='formAndField.fields[2].fieldValue']")
	private WebElement text;

	@FindBy(xpath = "//input[@class='field currency form-control']")
	private WebElement custmrcurrency;

	@FindBy(xpath = "(//img[@class='ui-datepicker-trigger'])[2]")
	private WebElement datePicker;

	@FindBy(xpath = "(//div[@id='ui-datepicker-div']//tbody/tr/td)[@data-handler='selectDay']")
	private List<WebElement> dates;

	@FindBy(xpath = "(//img[@class='ui-datepicker-trigger'])[last()]")
	private WebElement date1Picker;

	@FindBy(xpath = "(//div[@id='ui-datepicker-div']//tbody/tr/td)[@data-handler='selectDay']")
	private List<WebElement> dates1;

	@FindBy(xpath = "(//input[@class='field dateTime form-control'])[2]")
	private WebElement datetimepicker;

	@FindBy(xpath = "(//div[@class='xdsoft_calendar'])[2]/table/tbody/tr/td")
	private List<WebElement> datetimes;

	@FindBy(xpath = "(//div/input[@class='field dateTime form-control'])[last()]")
	private WebElement datetime1picker;

	@FindBy(xpath = "(//div[@class='xdsoft_calendar'])[3]/table/tbody/tr/td")
	private List<WebElement> datetimes1;

	@FindBy(xpath = "(//input[@class='sysField form-control numeric'])[2]")
	private WebElement number;

	@FindBy(xpath = "(//input[@class='time form-control'])[1]")
	private WebElement timefield;

	@FindBy(xpath = "(//div[@class='xdsoft_timepicker active']/div)[4]/div[@class='xdsoft_time_variant']/div")
	private List<WebElement> time;

	@FindBy(xpath = "(//div/input[@class='field form-control'])[1]")
	private WebElement customfieldEmail;

	@FindBy(xpath = "(//div/input[@class='mapField form-control'])[1]")
	private WebElement customfieldlocationlat;

	@FindBy(xpath = "(//div/input[@class='mapField form-control'])[2]")
	private WebElement customfieldlocationlog;

	@FindBy(xpath = "//div/input[@class='field form-control inputTypePhone']")
	private WebElement customfieldphone;

	@FindBy(xpath = "(//div/input[@class='field form-control'])[2]")
	private WebElement customfieldURL;

	@FindBy(xpath = "//div/input[@class='fileAudio']")
	private WebElement customfieldaudio;

	@FindBy(xpath = "//div/input[@class='fileImage']")
	private WebElement customfieldimage;

	@FindBy(xpath = "//div/input[@class='file']")
	private WebElement customfieldsignature;

	@FindBy(xpath = "//div/input[@class='fileVideo']")
	private WebElement customfieldvideo;

	@FindBy(xpath = "//div/select[@class='field customEntityPick form-control']")
	private WebElement customentityfield;

	@FindBy(xpath = "//table[@class='pq-grid-table pq-grid-td-border-right pq-grid-td-border-bottom ']/tbody/tr[2]/td[2]")
	private WebElement customentitypicker;

	@FindBy(xpath = "//input[@class='btn btn-success btn-block']")
	private WebElement customentityokbtn;

	@FindBy(xpath = "//div/select[@class='field cusPick form-control']")
	private WebElement customerpickfield;

	@FindBy(xpath = "//table[@class='pq-grid-table pq-grid-td-border-right pq-grid-td-border-bottom ']/tbody/tr[3]/td[2]")
	private WebElement customerpicker;

	@FindBy(xpath = "//input[@value='OK']")
	private WebElement customerpickokbtn;

	@FindBy(xpath = "//div/select[@class='field pickemployees form-control']")
	private WebElement employeepickfield;

	@FindBy(xpath = "//table[@class='pq-grid-table pq-grid-td-border-right pq-grid-td-border-bottom ']/tbody/tr[5]/td[2]")
	private WebElement employeepicker;

	@FindBy(xpath = "//input[@class='btn  btn-success']")
	private WebElement employeepickokbtn;

	@FindBy(xpath = "//div[@class='select2-container field pickForms']")
	private WebElement formfield;

	@FindBy(xpath = "(//ul[@class='select2-results'])[last()]/li[3]")
	private WebElement selectform;

	@FindBy(xpath = "(//div[@class='select2-container field'])[1]")
	private WebElement YesorNofield;

	@FindBy(xpath = "//ul[@class='select2-results']//li//div")
	private List<WebElement> Yesvalue;

	@FindBy(xpath = "//a[contains(text(),'Click here to Select Lists')]")
	private WebElement multipicklistfield;

	@FindBy(xpath = "((//div[@class='pq-cont']/table/tbody/tr)[3]/td)[2]")
	private WebElement multipicklistvalues;

	@FindBy(xpath = "(//input[contains(@class , 'btn')])[6]")
	private WebElement multipickokbtn;

	@FindBy(xpath = "//div[contains(@class,'select2-container-multi field')]")
	private WebElement multiselectdropdownfield;

	@FindBy(xpath = "(//ul[@class='select2-results'])[9]/li[1]")
	private WebElement multiselectdropdownvalue;

	@FindBy(xpath = "(//div/select[@class='field entPick form-control'])[2]")
	private WebElement picklistfield;

	@FindBy(xpath = "(//div[@class='pq-cont']/table/tbody/tr)[3]/td[2]")
	private WebElement picklistvalue;

	@FindBy(xpath = "(//input[@type='submit'])[2]")
	private WebElement picklistokbtn;

	@FindBy(xpath = "(//div/input[@class='sysField form-control numeric'])[3]")
	private WebElement groupnumber;

	@FindBy(xpath = "(//div/input[@class='time form-control'])[2]")
	private WebElement grouptime;

	@FindBy(xpath = "(//div[@class='xdsoft_time_box xdsoft_scroller_box'])[5]/div[1]/div")
	private List<WebElement> grouptimelist;

	@FindBy(xpath = "(//div[@class='select2-container field'])[2]/a/span[1]")
	private WebElement dropdownfield;

	@FindBy(xpath = "//div[@id='select2-drop']//ul/li[2]")
	private WebElement dropdownvalue;

	@FindBy(xpath = "//input[@name='primaryContactFirstName']")
	private WebElement primryCustmrFirstName;

	@FindBy(xpath = "//input[@name='primaryContactLastName']")
	private WebElement primryCustmrLastName;

	@FindBy(xpath = "//input[@name='primaryContactTitle']")
	private WebElement primryCustmrTitle;

	@FindBy(xpath = "//input[@name='primaryContactPhone']")
	private WebElement primryCustmrPhone;

	@FindBy(xpath = "(//input[contains(@class,'compEmail')])[1]")
	private WebElement primryCustmrEmail;

	@FindBy(xpath = "//input[@name='secondaryContactFirstName']")
	private WebElement secondryCustmrFirstName;

	@FindBy(xpath = "//input[@name='secondaryContactLastName']")
	private WebElement secondryCustmrLastName;

	@FindBy(xpath = "//input[@name='secondaryContactTitle']")
	private WebElement secondryCustmrTitle;

	@FindBy(xpath = "//input[@name='secondaryContactPhone']")
	private WebElement secondryCustmrPhone;

	@FindBy(xpath = "//input[@name='secondaryContactEmail']")
	private WebElement secondryCustmrEmail;

	@FindBy(xpath = "//input[@id='save']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//div[text()=' Customer Created Succesfully']")
	private WebElement custmrcreatedsuccessmsg;

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

	@FindBy(xpath = "(//div[@class='select2-container form-control'])[2]")
	private WebElement assignDrpDown;

	@FindBy(xpath = "(//div[@class='select2-search'])[2]/input")
	private WebElement enterFieldInput;

	@FindBy(xpath = "(//ul[@class='select2-results'])[5]/li/div")
	private List<WebElement> empNameInDropDown;

	@FindBy(id = "assignCustomers")
	private WebElement applyBtn;

	@FindBy(id = "deleteCustomers")
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

		waitUntilElementVisible(driver, webAppCard);
		this.webAppCard.click();
		
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

	public void customerPhoneNumber() {
		logger.info("Starting of customerPhoneNumber Method");
		
		String RandomPhone = randomMobileNumbers();
		waitUntilElementVisible(driver, customerPhone);
		customerPhone.sendKeys(RandomPhone);
		
		logger.info("Ending of customerPhoneNumber Method");
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
		for (int i = 0; i < this.countryNames.size(); i++) {
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

	public void enterCustomerCurrency(String CurrencyValue) {
		logger.info("Starting of enterCustomerCurrency Method");
		
		waitUntilElementVisible(driver, custmrcurrency);
		this.custmrcurrency.sendKeys(CurrencyValue);

		logger.info("Ending of enterCustomerCurrency Method");
	}

	public void clickOnDatePicker() {
		logger.info("Starting of clickOnDatePicker Method");
		
		waitUntilElementVisible(driver, datePicker);
		this.datePicker.click();
		
		logger.info("Ending of clickOnDatePicker Method");
	}

	public void pickCurrentDate() throws InterruptedException {
		logger.info("Starting of pickCurrentDate Method");
		
		String presentdate = getCurrentDateAsNumber();
		Thread.sleep(500);
		for (int i = 0; i <= dates.size() - 1; i++) {
			String actualdate = dates.get(i).getText();
			if (actualdate.equalsIgnoreCase(presentdate)) {
				waitUntilElementVisible(driver, dates.get(i));
				dates.get(i).click();
				break;
			}
		}
		
		logger.info("Ending of pickCurrentDate Method");
	}

	public void clickOnDate1Picker() {
		logger.info("Starting of clickOnDate1Picker Method");
		
		waitUntilElementVisible(driver, date1Picker);
		this.date1Picker.click();
		
		logger.info("Ending of clickOnDate1Picker Method");
	}

	public void pickCurrentDate1() throws InterruptedException {
		logger.info("Starting of pickCurrentDate1 Method");
		
		String presentdate = getCurrentDateAsNumber();
		Thread.sleep(500);
		for (int i = 0; i <= dates1.size() - 1; i++) {
			String actualdate = dates1.get(i).getText();
			if (actualdate.equalsIgnoreCase(presentdate)) {
				waitUntilElementVisible(driver, dates1.get(i));
				dates1.get(i).click();
				break;
			}
		}
		
		logger.info("Ending of pickCurrentDate1 Method");
	}

	public void clickOnDateTimePicker() {
		logger.info("Starting of clickOnDateTimePicker Method");
		
		waitUntilElementVisible(driver, datetimepicker);
		mouseHoverAndClick(datetimepicker);
	//	this.datetimepicker.click();
		
		logger.info("Ending of clickOnDateTimePicker Method");
	}

	public void pickCurrentDateTime() throws InterruptedException {
		logger.info("Starting of pickCurrentDateTime Method");
		
		String presentdatetime = getCurrentDateAsNumber();
		Thread.sleep(500);
		for (int i = 0; i <= datetimes.size() - 1; i++) {
			String actualdatetime = datetimes.get(i).getText();
			if (actualdatetime.equalsIgnoreCase(presentdatetime)) {
				waitUntilElementVisible(driver, datetimes.get(i));
				datetimes.get(i).click();
				break;
			}
		}
		this.datetimepicker.click();
		
		logger.info("Ending of pickCurrentDateTime Method");
	}

	public void clickOnDateTime1Picker() throws InterruptedException {
		logger.info("Starting of clickOnDateTime1Picker Method");
		
		scrollDown(100, datetime1picker);
		waitUntilElementVisible(driver, this.datetime1picker);
		this.datetime1picker.click();
		
		logger.info("Ending of clickOnDateTime1Picker Method");
	}

	public void pickCurrentDateTime1() throws InterruptedException {
		logger.info("Starting of pickCurrentDateTime1 Method");
		
		String presentdatetime = getCurrentDateAsNumber();
		Thread.sleep(500);
		for (int i = 0; i <= datetimes1.size() - 1; i++) {
			hardWait(3);
			String actualdatetime = datetimes1.get(i).getText();
			if (actualdatetime.equalsIgnoreCase(presentdatetime)) {
				waitUntilElementVisible(driver, datetimes1.get(i));
				datetimes1.get(i).click();
				break;
			}
		}
		this.datetime1picker.click();
		
		logger.info("Ending of pickCurrentDateTime1 Method");
	}

	public void enterCustomFieldNumber(String Number) {
		logger.info("Starting of enterCustomFieldNumber Method");
		
		waitUntilElementVisible(driver, number);
		this.number.sendKeys(Number);
		
		logger.info("Ending of enterCustomFieldNumber Method");
	}

	public void pickTime() throws InterruptedException {
		logger.info("Starting of pickTime Method");
		
		waitUntilElementVisible(driver, this.timefield);
		scrollDown(100, timefield);
		this.timefield.click();
		String currentTime = getCurrentTime();
		String[] timeString = currentTime.split(":");
		Integer hour = Integer.parseInt(timeString[0]);
		hour = hour * 60;
		Integer min = Integer.parseInt(timeString[1]);
		int Index = hour + min;
		int timeItemCount = time.size();
		if (timeItemCount != 1440) {
			Index = 50;
		}
		Thread.sleep(1000);
		this.time.get(Index).click();

		logger.info("Ending of pickTime Method");
	}

	public void enterCustomFieldEmail(String CustmEmail) {
		logger.info("Starting of enterCustomerFieldEmail Method");
		
		waitUntilElementVisible(driver, customfieldEmail);
		this.customfieldEmail.sendKeys(CustmEmail);
		
		logger.info("Ending of enterCustomerFieldEmail Method");
	}

	public void selectCustomFieldLat(String CustmFieldlat) {
		logger.info("Starting of selectCustomerFieldLat Method");
		
		waitUntilElementVisible(driver, customfieldlocationlat);
		this.customfieldlocationlat.sendKeys(CustmFieldlat);
		
		logger.info("Ending of selectCustomerFieldLat Method");
	}

	public void selectCustomFieldLog(String CustmFieldlog) {
		logger.info("Starting of selectCustomerFieldLog Method");
		
		waitUntilElementVisible(driver, customfieldlocationlog);
		this.customfieldlocationlog.sendKeys(CustmFieldlog);
		
		logger.info("Ending of selectCustomerFieldLog Method");
	}

	public void enterCustomFieldPhone() {
		logger.info("Starting of enterCustomFieldPhone Method");
		
		String customfieldphonenumbr = randomMobileNumbers();
		waitUntilElementVisible(driver, customfieldphone);
		this.customfieldphone.sendKeys(customfieldphonenumbr);
		
		logger.info("Ending of enterCustomFieldPhone Method");
	}

	public void enterCustomFieldURL(String custmfieldURL) {
		logger.info("Starting of enterCustomFieldURL Method");
		
		waitUntilElementVisible(driver, customfieldURL);
		this.customfieldURL.sendKeys(custmfieldURL);
		
		logger.info("Ending of enterCustomFieldURL Method");
	}

	public void selectAudio() {
		logger.info("Starting of selectAudio Method ");
		
		waitUntilElementVisible(driver, customfieldaudio);
		String audiofilePath = System.getProperty("user.dir") + "/MediaFiles/Audofile.mp3";
		this.customfieldaudio.sendKeys(audiofilePath);
		
		logger.info("Ending of selectAudio Method ");
	}

	public void selectImage() throws IOException, InterruptedException {
		logger.info("Starting of selectImage Method ");
		
		waitUntilElementVisible(driver, this.customfieldimage);
		String imagefilepath = System.getProperty("user.dir") + "/MediaFiles/image.jpg";
		this.customfieldimage.sendKeys(imagefilepath);
		
		logger.info("Ending of selectImage Method ");
	}

	public void selectSignature() {
		logger.info("Starting of selectSignature Method ");
		
		waitUntilElementVisible(driver, this.customfieldsignature);
		String signatuerfilepath = System.getProperty("user.dir") + "/MediaFiles/Signature.jpg";
		this.customfieldsignature.sendKeys(signatuerfilepath);
		
		logger.info("Ending of selectSignature Method ");
	}

	public void selectVideo() {
		logger.info("Starting of selectVideo Method ");
		
		waitUntilElementVisible(driver, this.customfieldvideo);
		String videofilepath = System.getProperty("user.dir") + "/MediaFiles/Video.mp4";
		this.customfieldvideo.sendKeys(videofilepath);
		
		logger.info("Ending of selectVideo Method ");
	}

	public void pickCustomEntity() {
		logger.info("Starting of customerPickField Method");
		
		waitUntilElementVisible(driver, customentityfield);
		this.customentityfield.click();
		waitUntilElementVisible(driver, customentitypicker);
		this.customentitypicker.click();
		waitUntilElementVisible(driver, customentityokbtn);
		this.customentityokbtn.click();
		
		logger.info("Ending of customerPickField Method");
	}

	public void pickCustomer() throws InterruptedException {
		logger.info("Starting of customPicker Method");
		
		scrollDown(100, customerpickfield);
		waitUntilElementVisible(driver, customerpickfield);
		this.customerpickfield.click();
		waitUntilElementVisible(driver, customerpicker);
		this.customerpicker.click();
		waitUntilElementVisible(driver, customerpickokbtn);
		this.customerpickokbtn.click();
		
		logger.info("Ending of customPicker Method");
	}

	public void pickEmployee() {
		logger.info("Starting of employeePicker Method");
		
		scrollDown(100, employeepickfield);
		waitUntilElementVisible(driver, employeepickfield);
		this.employeepickfield.click();
		waitUntilElementVisible(driver, employeepicker);
		this.employeepicker.click();
		waitUntilElementVisible(driver, employeepickokbtn);
		this.employeepickokbtn.click();
		
		logger.info("Ending of employeePicker Method");
	}

	public void pickForm() throws InterruptedException {
		logger.info("Starting of formPicker Method");
		
		waitUntilElementVisible(driver, formfield);
		this.formfield.click();
		waitUntilElementVisible(driver, selectform);
		this.selectform.click();
		
		logger.info("Ending of formPicker Method");
	}

	public void pickYesOrNo() {
		logger.info("Starting of pickYesOrNo Method");
		
		waitUntilElementVisible(driver, this.YesorNofield);
		this.YesorNofield.click();
		int yesOrNoOptionCount = 0;
		while (yesOrNoOptionCount < Yesvalue.size()) {
			if (Yesvalue.get(yesOrNoOptionCount).getText().equalsIgnoreCase("Yes")) {
				Yesvalue.get(yesOrNoOptionCount).click();
				break;
			}
			yesOrNoOptionCount++;
		}
		
		logger.info("Ending of pickYesOrNo Method");
	}

	public void pickMultiPickList() {
		logger.info("Starting of pickMultiPickList Method");
		
		scrollDown(100, multipicklistfield);
		waitUntilElementVisible(driver, this.multipicklistfield);
		clickOnWebElement(this.multipicklistfield);
		hardWait(5);
		waitUntilElementVisible(driver, this.multipicklistvalues);
		this.multipicklistvalues.click();
		waitUntilElementVisible(driver, this.multipickokbtn);
		this.multipickokbtn.click();
		
		logger.info("Ending of pickMultiPickList Method");
	}

	public void pickMultiSelectDropDown() {
		logger.info("Starting of pickMultiSelectDropDown Method");
		try {
			scrollIntoView(multiselectdropdownfield);
			waitUntilElementVisible(driver, this.multiselectdropdownfield);
			clickOnWebElement(multiselectdropdownfield);
			waitUntilElementVisible(driver, this.multiselectdropdownvalue);
			clickOnWebElement(multiselectdropdownvalue);
			
		}catch (Exception e) {
			scrollIntoView(multiselectdropdownfield);
			waitUntilElementVisible(driver, this.multiselectdropdownfield);
			clickOnWebElement(multiselectdropdownfield);
			waitUntilElementVisible(driver, this.multiselectdropdownvalue);
			clickOnWebElement(multiselectdropdownvalue);
		}
		
		
		logger.info("Ending of pickMultiSelectDropDown Method");
	}

	public void pickPickList() {
		logger.info("Starting of pickPickList Method");
		
		waitUntilElementVisible(driver, this.picklistfield);
		this.picklistfield.click();
		waitUntilElementVisible(driver, this.picklistvalue);
		this.picklistvalue.click();
		waitUntilElementVisible(driver, this.picklistokbtn);
		this.picklistokbtn.click();
		
		logger.info("Ending of pickPickList Method");
	}

	public void enterGroupNumber(String GroupNumber) {
		logger.info("Starting of enterGroupNumber Method");
		
		waitUntilElementVisible(driver, this.groupnumber);
		this.groupnumber.sendKeys(GroupNumber);
		
		logger.info("Ending of enterGroupNumber Method");
	}

	public void pickGroupTime() throws InterruptedException {
		logger.info("Starting of pickGroupTime Method");
		
		waitUntilElementVisible(driver, this.grouptime);
		scrollDown(100, grouptime);
		this.grouptime.click();
		String currentTime = getCurrentTime();
		String[] timeString = currentTime.split(":");
		Integer hour = Integer.parseInt(timeString[0]);
		hour = hour * 60;
		Integer min = Integer.parseInt(timeString[1]);
		int Index = hour + min;
		int timeItemCount = grouptimelist.size();
		if (timeItemCount != 1440) {
			Index = 50;
		}
		Thread.sleep(1000);
		this.grouptimelist.get(Index).click();

		logger.info("Ending of pickGroupTime Method");
	}

	public void pickDropDown() throws InterruptedException {
		logger.info("Starting of pickDropDown Method");
		
		Thread.sleep(500);
		waitUntilElementVisible(driver, this.dropdownfield);
		this.dropdownfield.click();
		waitUntilElementVisible(driver, this.dropdownvalue);
		this.dropdownvalue.click();
		
		logger.info("Ending of pickDropDown Method");
	}

	public void PrimryCustmrFirstName(String primryfirstname) {
		logger.info("Starting of PrimryCustmrFirstName Method");
		
		waitUntilElementVisible(driver, primryCustmrFirstName);
		this.primryCustmrFirstName.sendKeys(primryfirstname);
		
		logger.info("Ending of PrimryCustmrFirstName Method");
	}

	public void PrimryCustmrLastName(String primryLastName) {
		logger.info("Starting of PrimryCustmrLastName Method");
		
		waitUntilElementVisible(driver, primryCustmrLastName);
		this.primryCustmrLastName.sendKeys(primryLastName);
		
		logger.info("Ending of PrimryCustmrLastName Method");
	}

	public void PrimryCustmrTitle(String PrimeryTitle) {
		logger.info("Starting of PrimryCustmrTitle Method");
		
		waitUntilElementVisible(driver, primryCustmrTitle);
		this.primryCustmrTitle.sendKeys(PrimeryTitle);
		
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

	public void SecondryCustmrFirstName(String SecondryFirstName) {
		logger.info("Starting of SecondryCustmrFirstName Method");
		
		waitUntilElementVisible(driver, secondryCustmrFirstName);
		this.secondryCustmrFirstName.sendKeys(SecondryFirstName);
		
		logger.info("Ending of SecondryCustmrFirstName Method");
	}

	public void SecondryCustmrLastName(String SecondryLastName) {
		logger.info("Starting of SecondryCustmrLastName Method");
		
		waitUntilElementVisible(driver, secondryCustmrLastName);
		this.secondryCustmrLastName.sendKeys(SecondryLastName);
		
		logger.info("Ending of SecondryCustmrLastName Method");
	}

	public void SecondryCustmrTitle(String SecondryTitle) {
		logger.info("Starting of SecondryCustmrTitle Method");
		
		waitUntilElementVisible(driver, secondryCustmrTitle);
		this.secondryCustmrTitle.sendKeys(SecondryTitle);
		
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

	public String customerCreatedSuccesMsg() {
		logger.info("Starting of customerCreatedSuccesMsg Method ");
		
		waitUntilElementVisible(driver, custmrcreatedsuccessmsg);
		String custmrcreatdsuccesmsg = this.custmrcreatedsuccessmsg.getText();
		
		logger.info("Ending of customerCreatedSuccesMsg Method ");
		return custmrcreatdsuccesmsg;
	}

	public void ClickonEditBtn() throws InterruptedException {
		logger.info("Starting of ClickonEditBtn Method");
		
		Thread.sleep(500);
		scrollDown(100, form);
		
		int i = 0;
		while (i < editBtn.size()) {
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
		
		logger.info("Ending of CaptureModifiedMsg Method");
		return CustmrModifiedMsg;
	}

	public void CustmrMaptoEmployee() throws InterruptedException {
		logger.info("Starting of CustmrMaptoEmployee Method");
		
		Thread.sleep(500);
		scrollDown(100, form);
		for (int i = 0; i <= 5; i++) {
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

	public void ClickonAssign(String empname, String dropdownempname) throws InterruptedException {
		logger.info("Starting of ClickonAssign method");
		
		waitUntilElementVisible(driver, assignDrpDown);
		this.assignDrpDown.click();
		Thread.sleep(1000);
		waitUntilElementVisible(driver, enterFieldInput);
		this.enterFieldInput.sendKeys(empname);
		int count = 0;
		while (count < this.empNameInDropDown.size()) {
			String dropdnempname = this.empNameInDropDown.get(count).getText();
			//if (dropdnempname.equalsIgnoreCase(dropdownempname)) {
				waitUntilElementVisible(driver, this.empNameInDropDown.get(count));
				this.empNameInDropDown.get(count).click();
				break;
		//	}
			//count++;
		}
		hardWait(3);
		waitUntilElementVisible(driver, applyBtn);
		try {
			applyBtn.click();
		} catch (Exception e) {
			mouseHoverAndClick(applyBtn);
		}
		
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			logger.info("No alert displayed");
		}
		//this.applyBtn.click();
		
		logger.info("Ending of ClickonAssign method");
	}

	public void SelectCustmrtoDelete() throws InterruptedException {
		logger.info("Starting of SelectCustmrtoDelete Method");
		
		Thread.sleep(500);

		scrollDown(100, form);
		for (int i = 0; i < 3; i++) {
			this.custmrmapingcheckbox.get(i).click();
		}
		
		logger.info("Ending of SelectCustmrtoDelete Method");
	}

	public String ClickonDeleteBtn() throws InterruptedException {
		logger.info("Starting of ClickonDelete Method");
		
		waitUntilElementVisible(driver, deleteBtn);
		this.deleteBtn.click();
		driver.switchTo().alert().accept();
		Thread.sleep(10000);
		String capturedDeleteMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		logger.info("Ending of ClickonDeleteBtn Method");
		return capturedDeleteMsg;

	}

	public void LogOut() {
		logger.info("Starting of LogOut Method");
		hardWait(3);
		waitUntilElementVisible(driver, userNameBtn);
		mouseHoverAndClick(userNameBtn);
		//userNameBtn.click();
		if (logoutBtn.get(logoutBtn.size() - 1).getText().equalsIgnoreCase("LogOut")) {
			logoutBtn.get(logoutBtn.size() - 1).click();
		}
		
		logger.info("Ending of LogOut Method");
	}

}
