package com.effort.filters;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;
import com.effort.works.AddWorkProcess;

public class WorkFiltersPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(AddWorkProcess.class);

	@FindBy(xpath = "//a[contains(text(),'Web App')]")
	private WebElement webApp;

	@FindBy(xpath = "//button[@id='filters']")
	private WebElement workFilterBtn;

	@FindBy(xpath = "//button[@id='reset']")
	private WebElement resetFilterBtn;

	@FindBy(xpath = "//input[@id='filtWorkId']")
	private WebElement workIdTxt;

	@FindBy(xpath = "//button[@id='search']")
	private WebElement applyFilterBtn;

	@FindBy(xpath = "(//a[contains(@href,'/effortx/web/work/details/view/')])[2]")
	private WebElement workId;

	@FindBy(xpath = "//input[@flable='Work Name']")
	private WebElement filterWorkName;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[4]/span")
	private WebElement workName;

	@FindBy(xpath = "//input[@flable='Starts_1']")
	private WebElement filterWorkStartDate;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[5]")
	private WebElement workStartDate;

	@FindBy(xpath = "//input[@flable='Work Ends Date_1']")
	private WebElement filterWorkEndDate;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[6]")
	private WebElement workEndDate;

	@FindBy(xpath = "(//span[contains(text(),'Select Employee')])[1]")
	private WebElement filterWorkEmployee;

	@FindBy(xpath = "//input[@id='s2id_autogen14_search']")
	private WebElement enterFilterEmpName;

	@FindBy(xpath = "//li[contains(@class,'highlighted')]")
	private WebElement selectEmp;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[7]/a")
	private WebElement workFieldEmployee;

	@FindBy(xpath = "//input[@flable='Text']")
	private WebElement filterWorkText;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[8]")
	private WebElement workFieldText;

	@FindBy(xpath = "//input[@flable='Currency']")
	private WebElement filterWorkCurrency;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[9]")
	private WebElement workFieldCurrency;

	@FindBy(xpath = "//input[@flable='Date_1']")
	private WebElement filterWorkDateFrom;

	@FindBy(xpath = "//input[@flable='Date_2']")
	private WebElement filterWorkDateEnd;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[10]")
	private WebElement workFieldDate;
	
	@FindBy(xpath = "//input[@flable='Duration']")
	private WebElement filterWorkDuration;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[11]")
	private WebElement workFieldDuration;
	
	@FindBy(xpath = "//input[@flable='Number']")
	private WebElement filterWorkNumber;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[12]")
	private WebElement workFieldNumber;

	@FindBy(xpath = "//input[@flable='Time_1']")
	private WebElement filterWorkTimeFrom;

	@FindBy(xpath = "//input[@flable='Time_2']")
	private WebElement filterWorkTimeEnd;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[13]")
	private WebElement workFieldTime;
	
	@FindBy(xpath = "//input[@flable='Emal']")
	private WebElement filterWorkEmail;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[14]")
	private WebElement workFieldEmail;
	
	@FindBy(xpath = "//input[@flable='Phone']")
	private WebElement filterWorkPhone;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[16]")
	private WebElement workFieldPhone;
	
	@FindBy(xpath = "//input[@flable='Country']")
	private WebElement filterWorkCountry;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[18]")
	private WebElement workFieldCountry;
	
	
	public WorkFiltersPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
	}

	public void clickOnWebApp() {
		logger.info("Starting of clickOn WebApp method");

		hardWait(3);
		waitUntilElementVisible(driver, this.webApp);
		this.webApp.click();

		logger.info("Ending of clicOnWebApp Method");

	}

	public void filterWorkWithId(String WorkId) {
		logger.info("Starting of filterWorkWithId method");

		hardWait(3);
		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		scrollIntoView(workIdTxt);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.workIdTxt);
		// clickUsingActionClass(workIdTxt);
		workIdTxt.sendKeys(WorkId);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithId menthod");
	}

	public void filterWorkWithName(String WorkName) {
		logger.info("Starting of filterWorkWithName method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkName);
		// clickUsingActionClass(workIdTxt);
		filterWorkName.sendKeys(WorkName);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithName menthod");
	}

	public void filterWorkWithStartDate(String WorkStartDate) {
		logger.info("Starting of filterWorkWithStartDate method");
		hardWait(3);

		
		
		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkStartDate);
		filterWorkStartDate.sendKeys(WorkStartDate);

		// waitUntilElementVisible(driver, this.applyFilterBtn);
		// clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithStartDate menthod");
	}

	public void filterWorkWithEndDate(String WorkEndDate, String WorkId) {
		logger.info("Starting of filterWorkWithStartDate method");
		hardWait(3);

		// waitUntilElementVisible(driver, this.workFilterBtn);
		// clickOnWebElementUsingJavascript(workFilterBtn);

		// waitUntilElementVisible(driver, this.resetFilterBtn);
		// clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkEndDate);
		filterWorkEndDate.sendKeys(WorkEndDate);

		scrollIntoView(workIdTxt);
		
		waitUntilElementVisible(driver, this.workIdTxt);
		workIdTxt.sendKeys(WorkId);
		
		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithStartDate menthod");
	}

	public void filterWorkWithEmployeeName(String WorkEndDate) {
		logger.info("Starting of filterWorkWithStartDate method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkEmployee);
		clickUsingActionClass(filterWorkEmployee);

		waitUntilElementVisible(driver, this.enterFilterEmpName);
		enterFilterEmpName.sendKeys(WorkEndDate);

		waitUntilElementVisible(driver, this.selectEmp);
		clickUsingActionClass(selectEmp);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithStartDate menthod");
	}

	public void filterWorkWithText(String WorkText) {
		logger.info("Starting of filterWorkWithText method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkText);
		filterWorkText.sendKeys(WorkText);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithText menthod");
	}

	public void filterWorkWithCurrency(String WorkCurrency) {
		logger.info("Starting of filterWorkWithCurrency method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		scrollIntoView(filterWorkCurrency);

		waitUntilElementVisible(driver, this.filterWorkCurrency);
		filterWorkCurrency.sendKeys(WorkCurrency);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithCurrency menthod");
	}

	public void filterWorkWithDate(String WorkDate) {
		logger.info("Starting of filterWorkWithDate method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		scrollIntoView(filterWorkDateFrom);

		waitUntilElementVisible(driver, this.filterWorkDateFrom);
		filterWorkDateFrom.sendKeys(WorkDate);

		clickOnWebElement(filterWorkDateEnd);
		waitUntilElementVisible(driver, this.filterWorkDateEnd);
		filterWorkDateEnd.sendKeys(WorkDate);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithDate menthod");
	}

	public void filterWorkWithDuration(String WorkDuration) {
		logger.info("Starting of filterWorkWithDuration method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		scrollIntoView(filterWorkDuration);

		waitUntilElementVisible(driver, this.filterWorkDuration);
		filterWorkDuration.sendKeys(WorkDuration);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithDuration menthod");
	}
	
	public void filterWorkWithNumber(String WorkNumber) {
		logger.info("Starting of filterWorkWithNumber method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkNumber);
		filterWorkNumber.sendKeys(WorkNumber);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithNumber menthod");
	}
	
	public void filterWorkWithTime(String WorkTimeStart, String WorkTimeEnd) {
		logger.info("Starting of filterWorkWithTime method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkTimeFrom);
		filterWorkTimeFrom.sendKeys(WorkTimeStart);
		
		waitUntilElementVisible(driver, this.filterWorkTimeEnd);
		filterWorkTimeEnd.sendKeys(WorkTimeEnd);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithTime menthod");
	}
	
	public void filterWorkWithPhone(String WorkPhone) {
		logger.info("Starting of filterWorkWithPhone method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkPhone);
		filterWorkPhone.sendKeys(WorkPhone);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithPhone menthod");
	}
	
	public void filterWorkWithEmail(String WorkEmail) {
		logger.info("Starting of filterWorkWithEmail method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkEmail);
		filterWorkEmail.sendKeys(WorkEmail);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithEmail menthod");
	}
	
	public void filterWorkWithCountry(String WorkCountry) {
		logger.info("Starting of filterWorkWithCountry method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkCountry);
		filterWorkCountry.sendKeys(WorkCountry);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithCountry menthod");
	}
	
	
	public void clickOnWorkId() {
		logger.info("Starting of clickOnWorkId method");

		hardWait(3);

		waitUntilElementVisible(driver, this.workId);
		clickOnWebElementUsingJavascript(workId);

		logger.info("Ending of clickOnWorkId menthod");
	}

	public String isWorkIdDisplayed() {
		logger.info("Starting of isWorkIdDisplayed method");
		String isWorkIdDisplayed;
		hardWait(4);
		try {

			isWorkIdDisplayed = workId.getText();

		} catch (Exception e) {

			isWorkIdDisplayed = workId.getText();
		}

		logger.info("Ending of isWorkIdDisplayed method");

		return isWorkIdDisplayed;
	}

	public String isWorkNameDisplayed() {
		logger.info("Starting of isWorkNameDisplayed method");

		String isWorkNameDisplayed;
		hardWait(4);
		
		try {
			isWorkNameDisplayed = workName.getText();

		} catch (Exception e) {

			isWorkNameDisplayed = workName.getText();
		}

		logger.info("Ending of isWorkNameDisplayed method");

		return isWorkNameDisplayed;
	}

	public String isWorkStartDateDisplayed() {
		logger.info("Starting of isWorkStartDateDisplayed method");

		String isWorkStartDateDisplayed;

		hardWait(6);

		try {

			isWorkStartDateDisplayed = workStartDate.getText();

		} catch (Exception e) {

			isWorkStartDateDisplayed = workStartDate.getText();
		}

		logger.info("Ending of isWorkStartDateDisplayed method");

		return isWorkStartDateDisplayed;
	}

	public String isWorkEndDateDisplayed() {
		logger.info("Starting of isWorkEndDateDisplayed method");

		String isWorkEndDateDisplayed;

		hardWait(6);

		try {

			isWorkEndDateDisplayed = workEndDate.getText();

		} catch (Exception e) {

			isWorkEndDateDisplayed = workEndDate.getText();
		}

		logger.info("Ending of isWorkEndDateDisplayed method");

		return isWorkEndDateDisplayed;
	}

	public String isWorkEmployeeFieldDisplayed() {
		logger.info("Starting of isWorkEmployeeFieldDisplayed method");

		String isWorkEmployeeFieldDisplayed;
		hardWait(4);

		try {

			isWorkEmployeeFieldDisplayed = workFieldEmployee.getText();

		} catch (Exception e) {

			isWorkEmployeeFieldDisplayed = workFieldEmployee.getText();
		}

		logger.info("Ending of isWorkEmployeeFieldDisplayed method");

		return isWorkEmployeeFieldDisplayed;
	}

	public String isWorkTextFieldDisplayed() {
		logger.info("Starting of isWorkTextFieldDisplayed method");

		String isWorkTextFieldDisplayed;
		hardWait(4);

		try {

			isWorkTextFieldDisplayed = workFieldText.getText();

		} catch (Exception e) {

			isWorkTextFieldDisplayed = workFieldText.getText();
		}

		logger.info("Ending of isWorkTextFieldDisplayed method");

		return isWorkTextFieldDisplayed;
	}

	public String isWorkCurrencyFieldDisplayed() {
		logger.info("Starting of isWorkCurrencyFieldDisplayed method");

		String isWorkCurrencyFieldDisplayed;
		hardWait(4);

		try {

			isWorkCurrencyFieldDisplayed = workFieldCurrency.getText();

		} catch (Exception e) {

			isWorkCurrencyFieldDisplayed = workFieldCurrency.getText();
		}

		logger.info("Ending of isWorkCurrencyFieldDisplayed method");

		return isWorkCurrencyFieldDisplayed;
	}

	public String isWorkDateFieldDisplayed() {
		logger.info("Starting of isWorkDateFieldDisplayed method");

		String isWorkDateFieldDisplayed;
		hardWait(4);

		try {

			isWorkDateFieldDisplayed = workFieldDate.getText();

		} catch (Exception e) {

			isWorkDateFieldDisplayed = workFieldDate.getText();
		}

		logger.info("Ending of isWorkDateFieldDisplayed method");

		return isWorkDateFieldDisplayed;
	}

	public String isWorkDurationFieldDisplayed() {
		logger.info("Starting of isWorkDurationFieldDisplayed method");

		String isWorkDurationFieldDisplayed;
		hardWait(4);

		try {

			isWorkDurationFieldDisplayed = workFieldDuration.getText();

		} catch (Exception e) {

			isWorkDurationFieldDisplayed = workFieldDuration.getText();
		}

		logger.info("Ending of isWorkDurationFieldDisplayed method");

		return isWorkDurationFieldDisplayed;
	}

	public String isWorkNumberFieldDisplayed() {
		logger.info("Starting of isWorkNumberFieldDisplayed method");

		String isWorkNumberFieldDisplayed;
		hardWait(4);

		try {

			isWorkNumberFieldDisplayed = workFieldNumber.getText();

		} catch (Exception e) {

			isWorkNumberFieldDisplayed = workFieldNumber.getText();
		}

		logger.info("Ending of isWorkNumberFieldDisplayed method");

		return isWorkNumberFieldDisplayed;
	}

	public String isWorkTimeFieldDisplayed() {
		logger.info("Starting of isWorkTimeFieldDisplayed method");

		String isWorkTimeFieldDisplayed;
		hardWait(4);

		try {

			isWorkTimeFieldDisplayed = workFieldTime.getText();

		} catch (Exception e) {

			isWorkTimeFieldDisplayed = workFieldTime.getText();
		}

		logger.info("Ending of isWorkTimeFieldDisplayed method");

		return isWorkTimeFieldDisplayed;
	}
	
	public String isWorkPhoneFieldDisplayed() {
		logger.info("Starting of isWorkPhoneFieldDisplayed method");

		String isWorkPhoneFieldDisplayed;
		hardWait(4);

		try {

			isWorkPhoneFieldDisplayed = workFieldPhone.getText();

		} catch (Exception e) {

			isWorkPhoneFieldDisplayed = workFieldPhone.getText();
		}

		logger.info("Ending of isWorkTimeFieldDisplayed method");

		return isWorkPhoneFieldDisplayed;
	}
	

	public String isWorkCountryFieldDisplayed() {
		logger.info("Starting of isWorkCountryFieldDisplayed method");

		String isWorkCountryFieldDisplayed;
		hardWait(4);

		try {

			isWorkCountryFieldDisplayed = workFieldCountry.getText();

		} catch (Exception e) {

			isWorkCountryFieldDisplayed = workFieldCountry.getText();
		}

		logger.info("Ending of isWorkCountryFieldDisplayed method");

		return isWorkCountryFieldDisplayed;
	}
	
	public String isWorkEmailFieldDisplayed() {
		logger.info("Starting of isWorkEmailFieldDisplayed method");

		String isWorkEmailFieldDisplayed;
		hardWait(4);

		try {

			isWorkEmailFieldDisplayed = workFieldEmail.getText();

		} catch (Exception e) {

			isWorkEmailFieldDisplayed = workFieldEmail.getText();
		}

		logger.info("Ending of isWorkEmailFieldDisplayed method");

		return isWorkEmailFieldDisplayed;
	}

	
}
