package com.effort.forms;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class FormSubmission extends BaseAutomationPage{

	private static final Logger logger = Logger.getLogger(FormSubmission.class.getName());

	private static String formListScreenWindow=null;

	@FindBy(xpath="//a[text()='Web App']")
	private WebElement webApp;

	@FindBy(id="forms")
	private WebElement formsModule;

	@FindBy(id="searchText")
	private WebElement searchBox;

	@FindBy(xpath="(//h5[contains(text(),'All Field Form Auto')])[2]")
	private WebElement formName;

	@FindBy(id="addForms")
	private WebElement addFormBtn;

	@FindBy(xpath="//input[@class='field currency form-control']")
	private WebElement currencyField;

	@FindBy(xpath="//input[@class='field date form-control']")
	private WebElement datePicker;

	@FindBy(xpath="//body/div[4]/div[1]/div/table/tbody/tr/td/div")
	private List<WebElement> dates;

	@FindBy(xpath="//input[@id='fields3_fieldValueDateTime']")
	private WebElement dateTimepicker;

	@FindBy(xpath="//body/div[5]/div[1]/div/table/tbody/tr/td")
	private List<WebElement> dateTimes;

	@FindBy(xpath="//input[@placeholder='HH:MM:SS']")
	private WebElement duration;

	@FindBy(id="fields5_fieldValue")
	private WebElement monthPicker;

	@FindBy(xpath="//table[@class='month-picker-month-table']/tr/td/a/span")
	private List<WebElement> months;

	@FindBy(id="fields6_fieldValue")
	private WebElement numberfield;

	@FindBy(id="fields7_fieldValue")
	private WebElement textField;

	@FindBy(id="fields8_fieldValue")
	private WebElement timeField;

	@FindBy(xpath="(//div[@class='xdsoft_timepicker active'])[2]/div/div[1]/div")
	private List<WebElement> timers;

	@FindBy(id="fields10_fieldValue")
	private WebElement emailField;

	@FindBy(id="mapHome11")
	private WebElement mapField;

	@FindBy(xpath="//img[@onclick='showMarkedLocation()']")
	private WebElement getLoctionIcon;

	@FindBy(id="fields11_fieldValue1")
	private WebElement latInputField;

	@FindBy(id="fields11_fieldValue2")
	private WebElement longInputField;

	@FindBy(id="fields12_fieldValue")
	private WebElement phoneNumberField;

	@FindBy(id="fields13_fieldValue")
	private WebElement urlField;

	@FindBy(xpath="//div[@class='upload hov documentuploader15']")
	private WebElement audioField;

	@FindBy(xpath="//div[@class='upload hov documentuploader16']")
	private WebElement documentField;

	@FindBy(xpath="//div[@class='upload hov uploader17']")
	private WebElement imageField;

	@FindBy(xpath="//div[@class='upload hov documentuploader18']")
	private WebElement videoField;

	@FindBy(id="s2id_fields20_fieldValue")
	private WebElement countryDropdown;

	@FindBy(xpath="(//li[@role='presentation'])[2]")
	private WebElement countitem;

	@FindBy(xpath="//select[@class='field cusPick form-control']")
	private WebElement customerPicker;

	@FindBy(xpath="//table[@class='pq-grid-table pq-grid-td-border-right pq-grid-td-border-bottom ']/tbody/tr[3]/td[2]")
	private WebElement pickerSelection;
	
	//@FindBy(xpath="//table[@class='pq-grid-table pq-grid-td-border-right pq-grid-td-border-bottom ']/tbody/tr[3]/td[2]")
	//private WebElement empSelct;

	@FindBy(xpath="//input[@value='OK']")
	private WebElement okBtn;
	
	@FindBy(xpath="//div[@id='s2id_fields22_fieldValue']")
	private WebElement customerTypePicker;
	
	@FindBy(xpath="//ul[@id='select2-results-2']/li[2]")
	private WebElement selectTypeItem;
	
	@FindBy(xpath="//select[@id='fields23_fieldValue']")
	private WebElement employeePicker;
	
	@FindBy(xpath="//b[contains(text(),'Click here to Select Customer')]")
	private WebElement multiPicker;
	
	@FindBy(xpath="(//table[@class='pq-grid-table pq-grid-td-border-right pq-grid-td-border-bottom ']/tbody/tr/td[2]/div/img)[1]")
	private WebElement multiCustomerlistFirstItem;
	
	@FindBy(xpath="(//table[@class='pq-grid-table pq-grid-td-border-right pq-grid-td-border-bottom ']/tbody/tr/td[2]/div/img)[2]")
	private WebElement multiCustomerlistSecondItem;
	
	@FindBy(xpath="//div[@id='s2id_fields25_fieldValue']")
	private WebElement terrioryField;
	
	@FindBy(xpath="//ul[@id='select2-results-3']/li[2]")
	private WebElement territoryItemSelection;
	
	@FindBy(xpath="//div[@id='s2id_fields26_fieldValue']")
	private WebElement YesOrNoBtn;
	
	@FindBy(xpath="//ul[@id='select2-results-4']/li[2]")
	private WebElement selectYesOrNoValue;

	@FindBy(id="save")
	private WebElement saveBtn;

	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;





	//Default constructor to initialized the driver
	public FormSubmission(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//Click on the web app after login
	public void clickWebApp() {
		logger.info("Starting of clickWebApp method");
		waitUntilElementVisible(driver, webApp);
		this.webApp.click();
		logger.info("Ending of clickWebApp method");	
	}

	//Click on form in the navigation bar
	public void clickOnForms() {
		logger.info("Starting of clickOnForms method");
		waitUntilElementVisible(driver, formsModule);
		this.formsModule.click();
		logger.info("Starting of clickOnForms method");
	}

	//Click On form name search option 
	public void sendFormName(String formName) {
		logger.info("Starting of send form name method");
		waitUntilElementVisible(driver, searchBox);
		this.searchBox.sendKeys(formName);
		logger.info("ending the send form name method");
	}

	//click on the form name
	public void clickOnFormName() {
		logger.info("Starting of click on form name method");
		waitUntilElementVisible(driver, formName);
		this.formName.click();
		this.formListScreenWindow=driver.getWindowHandle();
		logger.info("Ending of click on form name method");
	}

	//click on add form btn
	public void clickOnAddFormBtn() {
		logger.info("Starting of click on Add form botton method");
		waitUntilElementVisible(driver, addFormBtn);
		this.addFormBtn.click();
		logger.info("ending of click on Add form botton method");		
	}

	//Switching the page
	public void switchNewWindow() {
		logger.info("Starting of switchNewWindow method");
		String  parentWind=driver.getWindowHandle();
		Set<String> newWindows=driver.getWindowHandles();
		Iterator<String> I1= newWindows.iterator();

		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parentWind.equals(child_window))
			{
				driver.switchTo().window(child_window);

			}
		}
		logger.info("Ending of switchNewWindow method");

	}


	public void enterCurrency(String CurrencyValue) {
		logger.info("Starting of enterCurrency method");
		waitUntilElementVisible(driver, currencyField);
		this.currencyField.sendKeys(CurrencyValue);
		logger.info("Ending of enterCurrency method");
	}

	public void clickOnDatePicker() {
		logger.info("Starting of clickOnDatePicker method");
		waitUntilElementVisible(driver, datePicker);
		this.datePicker.click();
		implicitWait();
		logger.info("Ending of clickOnDatePicker method");		
	}

	public void clickOnCurrentDate() throws InterruptedException {
		logger.info("Starting of click on current date method");
		//Get the current date as number
		String presentDate=getCurrentDateAsNumber();
		Thread.sleep(500);
		for(int i=0;i<=dates.size()-1;i++) {
			String actualDate=dates.get(i).getText();
			if(actualDate.equalsIgnoreCase(presentDate)) {
				waitUntilElementVisible(driver, dates.get(i));
				dates.get(i).click();
				break;
			}
		}
		logger.info("Ending of ClickOnCurrentDate method");

	}

	public void clickOnDateTimePicker() {
		logger.info("Starting of clickOnDateTimePicker method");
		waitUntilElementVisible(driver, dateTimepicker);
		this.dateTimepicker.click();
		logger.info("Ending of clickOnDateTimePicker method");
	}

	public void clickOnCurrentDateTime() throws InterruptedException {
		logger.info("Starting of clickOnCurrentDateTime method");
		//Get the current date as number
		String presentDate=getCurrentDateAsNumber();
		Thread.sleep(500);
		for(int i=0;i<=dateTimes.size()-1;i++) {
			if(dateTimes.get(i).getText().equalsIgnoreCase(presentDate)) {
				waitUntilElementVisible(driver, dateTimes.get(i));
				dateTimes.get(i).click();
				break;
			}
		}
		this.dateTimepicker.click();
		logger.info("Ending of clickOnDatePicker method");
	}


	public void enterDuration(String durationValue) {
		logger.info("Starting of enterDuration mentiond");
		waitUntilElementVisible(driver, this.duration);
		//this.duration.click();
		clickOnWebElement(duration);
		this.duration.sendKeys(durationValue);
		logger.info("Ending of enterDuration mentiond");

	}

	public void ClickOnMonthPicker() {
		logger.info("Starting of ClickOnMonthPicker method");
		waitUntilElementVisible(driver, monthPicker);
		//this.monthPicker.click();
		clickOnWebElement(monthPicker);
		logger.info("Ending of ClickOnMonthPicker method");
	}

	public void clickOnCurrentMonth() {
		logger.info("Starting of clickOnCurrentDateTime method");
		for(int i=0;i<=months.size()-1;i++){
			if(months.get(i).getText().equalsIgnoreCase("Feb.")) {
				months.get(i).click();
				break;
			}
		}
		logger.info("Ending of clickOnDatePicker method");
	}


	public void enterNumberData(String numberData) {
		logger.info("Starting of enter number method");
		waitUntilElementVisible(driver, numberfield);
		this.numberfield.sendKeys(numberData);
		logger.info("Ending of enter number method");
	}

	public void enterTextData(String TextData) {
		logger.info("Starting of enterTextData method");
		waitUntilElementVisible(driver, textField);
		this.textField.sendKeys(TextData);
		logger.info("Ending of enterTextData method");
	}


	public void pickTime() throws InterruptedException {
		logger.info("Starting of pickTime method");
		waitUntilElementVisible(driver, this.timeField);
		scrollDown(100, timeField);
		this.timeField.click();
		String currentTime=getCurrentTime();
		String[] timeString =currentTime.split(":");
		Integer hour= Integer.parseInt(timeString[0]);
		hour = hour*60;
		Integer min= Integer.parseInt(timeString[1]);
		int index = hour+min;
		int timerItemsCount=timers.size();
		if(timerItemsCount != 1440) {
			index = 50;
		}
		Thread.sleep(1000);
		this.timers.get(index).click();

		logger.info("Ending of enterTextData method");
	}


	public void enterEmail(String email) {
		logger.info("Starting of enter Email method");
		waitUntilElementVisible(driver, this.emailField);
		this.emailField.sendKeys(email);
		logger.info("Ending of enter Email method");		
	}

	public void clickOnMapIcon() {
		logger.info("Starting of ClickOnMap method");
		waitUntilElementVisible(driver, this.mapField);
		this.mapField.click();
		logger.info("Starting of ClickOnMap method");

	}

	public void clickOnCurrentLocation() {
		logger.info("Starting of clickOnCurrentLocation method");
		// Store the current window handle
		String currentWindow=driver.getWindowHandle();
		waitUntilElementVisible(driver, this.mapField);
		this.mapField.click();
		Set<String> newWindows=driver.getWindowHandles();
		Iterator<String> I1= newWindows.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(formListScreenWindow.equals(child_window)) {
				continue;
			}
			if(!currentWindow.equals(child_window))
			{
				driver.switchTo().window(child_window);
				//waitUntilElementVisible(driver, this.getLoctionIcon);
				this.getLoctionIcon.click();
				//	this.confirmMapLocationBtn.click();
			}
		}	

	}


	public void manaualLocaionsEneted(String lat, String longitube) {
		logger.info("Starting of manaualLocaionsEneted method");
		this.latInputField.sendKeys(lat);
		this.longInputField.sendKeys(longitube);
		logger.info("Ending of manaualLocaionsEneted method");
	}


	public void phoneNumber(String phoneNumber) {
		logger.info("Starting of phoneNumber method");
		this.phoneNumberField.sendKeys(phoneNumber);
		logger.info("Ending of phoneNumber method");

	}

	public void URL(String url) {
		logger.info("Starting of phoneNumber method");
		this.urlField.sendKeys(url);
		logger.info("Ending of phoneNumber method");

	}

	public void audioData() throws IOException, InterruptedException {
		logger.info("Starting of audioData method");
		waitUntilElementVisible(driver, this.audioField);
		this.audioField.click();
		String pathExeFile=System.getProperty("user.dir")+ "\\Autoit\\AudioScript.exe";
		Runtime.getRuntime().exec(pathExeFile);
		Thread.sleep(5000);
		logger.info("Ending of audioData method");
	}

	public void documentUpload() throws IOException, InterruptedException{
		logger.info("Starting of documentUpload method");
		waitUntilElementVisible(driver, this.documentField);
		this.documentField.click();
		//Thread.sleep(5000);
		String pathExeFile=System.getProperty("user.dir")+"\\AutoIt\\Documentpicker.exe";
		Runtime.getRuntime().exec(pathExeFile);
		Thread.sleep(5000);

	}

	public void imageUpload() throws IOException, InterruptedException{
		logger.info("Starting of imageUpload method");
		waitUntilElementVisible(driver, this.imageField);
		this.imageField.click();
		String pathExeFile=System.getProperty("user.dir")+"\\AutoIt\\ImagePicker.exe";
		Runtime.getRuntime().exec(pathExeFile);
		Thread.sleep(5000);
		logger.info("Ending of imageUpload method");

	}

	public void videoUpload() throws IOException, InterruptedException{
		logger.info("Starting of videoUpload method");
		waitUntilElementVisible(driver, this.videoField);
		this.videoField.click();
		String pathExeFile=System.getProperty("user.dir")+"\\AutoIt\\VideoPicker.exe";
		Runtime.getRuntime().exec(pathExeFile);
		Thread.sleep(5000);
		logger.info("Ending of videoUpload method");
	}

	public void pickCountry() {
		logger.info("Starting of pickCountry method");
		waitUntilElementVisible(driver, this.countryDropdown);
		this.countryDropdown.click();
		waitUntilElementVisible(driver, this.countitem);
		this.countitem.click();	
		logger.info("Ending of pickCountry method");

	}

	public void pickCustomer() {
		logger.info("Starting of pick coustomer method");
		waitUntilElementVisible(driver, this.customerPicker);
		this.customerPicker.click();
		waitUntilElementVisible(driver, this.pickerSelection);
		this.pickerSelection.click();
		this.okBtn.click();
		logger.info("Ending of pick coustomer method");
	}
	
	public void pickCustomerType() {
		logger.info("Starting of pick coustomer method");
	    waitUntilElementVisible(driver, this.customerTypePicker);
	    this.customerTypePicker.click();
	    waitUntilElementVisible(driver, this.selectTypeItem);
	    this.selectTypeItem.click();
		logger.info("Ending of pick coustomer method");   
	}
	
	public void pickEmployee() {
		logger.info("Starting of pick Employee method");
		waitUntilElementVisible(driver, this.employeePicker);
		this.employeePicker.click();
		waitUntilElementVisible(driver, this.pickerSelection);
		this.pickerSelection.click();
		this.okBtn.click();
		logger.info("Ending of pick Employee method");
	}
	
	public void pickMultiPickCustomer() {
		logger.info("Starting of pick Multi-Select Customer method");
		waitUntilElementVisible(driver, this.multiPicker);
		this.multiPicker.click();
		waitUntilElementVisible(driver, this.multiCustomerlistFirstItem);
		this.multiCustomerlistFirstItem.click();
		waitUntilElementVisible(driver, this.multiCustomerlistSecondItem);
		this.multiCustomerlistSecondItem.click();
		this.okBtn.click();
		logger.info("Ending of pick Multi-Select Customer method");
	}
	
	
	public void SelectTerritory(){
		logger.info("Starting of SelectTerritory method");
		waitUntilElementVisible(driver, this.terrioryField);
		this.terrioryField.click();
		waitUntilElementVisible(driver, this.territoryItemSelection);
		this.territoryItemSelection.click();
	}
	
	public void selectYesOrNo() {
		logger.info("Starting of select yes or no method");
		waitUntilElementVisible(driver, this.YesOrNoBtn);
		this.YesOrNoBtn.click();
		waitUntilElementVisible(driver, this.selectYesOrNoValue);
		this.selectYesOrNoValue.click();

	}
			

	public void clickOnSave() {
		logger.info("Starting of Click on Save method");
		waitUntilElementVisible(driver, saveBtn);
		this.saveBtn.click();
		logger.info("Starting of Click on Save method");
	}

	public void logOut() {
		logger.info("Starting of Logout method");
		waitUntilElementVisible(driver, userNameBtn);
		userNameBtn.click();
		if(logoutBtn.get(logoutBtn.size()-1).getText().equalsIgnoreCase("Logout")){
			logoutBtn.get(logoutBtn.size()-1).click();
		}
		logger.info("Ending of Logout method");
	}



}
