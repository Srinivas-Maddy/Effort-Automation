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
	private WebElement filterWorkAssignEmployee;

	@FindBy(xpath = "//input[@id='s2id_autogen14_search']")
	private WebElement enterFilterAssignEmpName;

	@FindBy(xpath = "//li[contains(@class,'highlighted')]")
	private WebElement selectEmp;

	@FindBy(xpath = "(//span[contains(text(),'Select Employee')])[2]")
	private WebElement filterWorkEmployee;

	@FindBy(xpath = "(//span[contains(text(),'Select Employee')])[3]")
	private WebElement filterWorkFilledEmployee;

	@FindBy(xpath = "//input[@id='s2id_autogen15_search']")
	private WebElement enterFilterEmpName;

	@FindBy(xpath = "//input[@id='s2id_autogen16_search']")
	private WebElement enterFilterFilledEmpName;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[7]")
	private WebElement workFieldAssignEmployee;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[21]/a")
	private WebElement workFieldEmployee;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[40]/a")
	private WebElement filteredWorkFieldEmployee;

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

	@FindBy(xpath = "//label[text()='Customer']/following-sibling::div//input")
	private WebElement filterWorkCustomerField;

	@FindBy(xpath = "//div[@role='option']")
	private WebElement filterWorkCustomerSelect;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[19]")
	private WebElement workFieldCustomer;

	@FindBy(xpath = "//input[@flable='Customer Type']")
	private WebElement filterWorkCustomerType;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[20]")
	private WebElement workFieldCustomerType;

	@FindBy(xpath = "//label[text()='Territory']/following-sibling::div//div")
	private WebElement filterWorkTerritory;

	@FindBy(xpath = "//span[text()='HYD']")
	private WebElement filterSelectTerritory;

	@FindBy(xpath = "//label[text()='Territory']/following-sibling::div//div//input")
	private WebElement workFieldInputTerritory;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[22]")
	private WebElement workFieldTerritory;

	@FindBy(xpath = "//select[@flable='YesNo']")
	private WebElement filterWorkYesOrNo;

	@FindBy(xpath = "//option[@value='yes']")
	private WebElement filterWorkYes;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[23]")
	private WebElement workFieldYesOrNo;

	@FindBy(xpath = "//input[@id='yetToStartWork']")
	private WebElement filterYetToStartWork;

	@FindBy(xpath = "//input[@id='workInProgress']")
	private WebElement filterWorkInProgress;

	@FindBy(xpath = "//input[@id='UnCompleted']")
	private WebElement filterInCompletedWork;

	@FindBy(xpath = "//input[@id='rejected']")
	private WebElement filterRejectedWork;

	@FindBy(xpath = "//input[@id='viewUnassigned']")
	private WebElement filterUnassignedWork;

	@FindBy(xpath = "//input[@id='viewAssigned']")
	private WebElement filterAssignedWork;

	@FindBy(xpath = "//input[@id='completed']")
	private WebElement filterCompletedWork;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[33]")
	private WebElement filteredYetToStartWork;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[30]")
	private WebElement filteredWorkStatus;

	@FindBy(xpath = "//div[@id='s2id_lastActivity']")
	private WebElement filterLastActivity;

	@FindBy(xpath = "//div[@id='s2id_nextActivity']")
	private WebElement filterNextActivity;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[33]")
	private WebElement filteredLastActivity;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[37]")
	private WebElement filteredNextActivity;

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

	public void filterWorkWithAssignEmployeeName(String WorkAssignEmp) {
		logger.info("Starting of filterWorkWithAssignEmployeeName method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkAssignEmployee);
		clickUsingActionClass(filterWorkAssignEmployee);

		waitUntilElementVisible(driver, this.enterFilterAssignEmpName);
		enterFilterAssignEmpName.sendKeys(WorkAssignEmp);

		waitUntilElementVisible(driver, this.selectEmp);
		clickUsingActionClass(selectEmp);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithAssignEmployeeName menthod");
	}

	public void filterWorkWithEmployeeName(String workEmp) {
		logger.info("Starting of filterWorkWithAssignEmployeeName method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		scrollIntoView(filterWorkEmployee);

		waitUntilElementVisible(driver, this.filterWorkEmployee);
		clickUsingActionClass(filterWorkEmployee);

		hardWait(2);
		waitUntilElementVisible(driver, this.enterFilterEmpName);
		enterFilterEmpName.sendKeys(workEmp);
		hardWait(2);
		waitUntilElementVisible(driver, this.selectEmp);
		clickUsingActionClass(selectEmp);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithAssignEmployeeName menthod");
	}

	public void filterWorkWithFilledEmployeeName(String workFilledEmp) {
		logger.info("Starting of filterWorkWithFilledEmployeeName method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkFilledEmployee);
		clickUsingActionClass(filterWorkFilledEmployee);

		waitUntilElementVisible(driver, this.enterFilterFilledEmpName);
		enterFilterFilledEmpName.sendKeys(workFilledEmp);

		waitUntilElementVisible(driver, this.selectEmp);
		clickUsingActionClass(selectEmp);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithFilledEmployeeName menthod");
	}

	public void filterWorkWithLastActivity() {
		logger.info("Starting of filterWorkWithLastActivity method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterLastActivity);
		clickUsingActionClass(filterLastActivity);

		waitUntilElementVisible(driver, this.selectEmp);
		clickUsingActionClass(selectEmp);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithLastActivity menthod");
	}

	public void filterWorkWithNextActivity() {
		logger.info("Starting of filterWorkWithNextActivity method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterNextActivity);
		clickUsingActionClass(filterNextActivity);

		waitUntilElementVisible(driver, this.selectEmp);
		clickUsingActionClass(selectEmp);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithNextActivity menthod");
	}

	public void filterWorkWithTeerritory(String workTerritory) {
		logger.info("Starting of filterWorkWithTeerritory method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkTerritory);
		scrollIntoView(filterWorkTerritory);
		clickUsingActionClass(filterWorkTerritory);

		waitUntilElementVisible(driver, this.workFieldInputTerritory);
		workFieldInputTerritory.sendKeys(workTerritory);

		waitUntilElementVisible(driver, this.filterSelectTerritory);
		clickUsingActionClass(filterSelectTerritory);

		clickUsingActionClass(filterWorkTerritory);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithTeerritory menthod");
	}

	public void filterWorkWithYesOrNo() {
		logger.info("Starting of filterWorkWithYesOrNo method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkYesOrNo);
		scrollIntoView(filterWorkYesOrNo);
		clickUsingActionClass(filterWorkYesOrNo);
		filterWorkYesOrNo.sendKeys("Y");

		clickUsingActionClass(filterWorkYesOrNo);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithYesOrNo menthod");
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

	public void filterWorkWithCustomer(String WorkCustomer) {
		logger.info("Starting of filterWorkWithCustomer method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkCustomerField);
		filterWorkCustomerField.sendKeys(WorkCustomer);

		waitUntilElementVisible(driver, this.filterWorkCustomerSelect);
		clickUsingActionClass(filterWorkCustomerSelect);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithCustomer menthod");
	}

	public void filterWorkWithCustomerType(String WorkCustomerType) {
		logger.info("Starting of filterWorkWithCustomerType method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		waitUntilElementVisible(driver, this.filterWorkCustomerType);
		filterWorkCustomerType.sendKeys(WorkCustomerType);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWorkWithCustomerType menthod");
	}

	public void filterYetToStartWork() {
		logger.info("Starting of filterYetToStartWork method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		scrollIntoView(filterYetToStartWork);

		waitUntilElementVisible(driver, this.filterYetToStartWork);
		clickUsingActionClass(filterYetToStartWork);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterYetToStartWork menthod");
	}

	public void filterCompletedWork() {
		logger.info("Starting of filterCompletedWork method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		scrollIntoView(filterCompletedWork);

		waitUntilElementVisible(driver, this.filterCompletedWork);
		clickUsingActionClass(filterCompletedWork);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterCompletedWork menthod");
	}

	public void filterIncompletedWork() {
		logger.info("Starting of filterIncompletedWork method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		scrollIntoView(filterCompletedWork);

		waitUntilElementVisible(driver, this.filterInCompletedWork);
		clickUsingActionClass(filterInCompletedWork);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterIncompletedWork menthod");
	}

	public void filterRejectedWork() {
		logger.info("Starting of filterRejectedWork method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		scrollIntoView(filterRejectedWork);

		waitUntilElementVisible(driver, this.filterRejectedWork);
		clickUsingActionClass(filterRejectedWork);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterRejectedWork menthod");
	}

	public void filterUnassignedWork() {
		logger.info("Starting of filterUnassignedWork method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		scrollIntoView(filterUnassignedWork);

		waitUntilElementVisible(driver, this.filterUnassignedWork);
		clickUsingActionClass(filterUnassignedWork);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterUnassignedWork menthod");
	}

	public void filterAssignedWork() {
		logger.info("Starting of filterAssignedWork method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		scrollIntoView(filterAssignedWork);

		waitUntilElementVisible(driver, this.filterAssignedWork);
		clickUsingActionClass(filterAssignedWork);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterAssignedWork menthod");
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

	public String isWorkAssignEmployeeFieldDisplayed() {
		logger.info("Starting of isWorkAssignEmployeeFieldDisplayed method");

		String isWorkAssignEmployeeFieldDisplayed;
		hardWait(4);

		try {

			isWorkAssignEmployeeFieldDisplayed = workFieldAssignEmployee.getText();

		} catch (Exception e) {

			isWorkAssignEmployeeFieldDisplayed = workFieldAssignEmployee.getText();
		}

		logger.info("Ending of isWorkAssignEmployeeFieldDisplayed method");

		return isWorkAssignEmployeeFieldDisplayed;
	}

	public boolean isWorkAssignEmpFieldDisplayed() {
		logger.info("Starting of isWorkAssignEmpFieldDisplayed method");

		boolean isWorkAssignEmpFieldDisplayed = false;
		hardWait(4);

		try {

			if (isWorkAssignEmpFieldDisplayed = workFieldAssignEmployee.getText().isEmpty()) {
				isWorkAssignEmpFieldDisplayed = true;
			}

		} catch (Exception e) {

			try {

				if (isWorkAssignEmpFieldDisplayed = workFieldAssignEmployee.getText().isEmpty()) {
					isWorkAssignEmpFieldDisplayed = true;
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

		logger.info("Ending of isWorkAssignEmployeeFieldDisplayed method");

		return isWorkAssignEmpFieldDisplayed;
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

	public String isWorkFilledEmployeeFieldDisplayed() {
		logger.info("Starting of isWorkFilledEmployeeFieldDisplayed method");

		String isWorkFilledEmployeeFieldDisplayed;
		hardWait(4);

		try {

			isWorkFilledEmployeeFieldDisplayed = filteredWorkFieldEmployee.getText();

		} catch (Exception e) {

			isWorkFilledEmployeeFieldDisplayed = filteredWorkFieldEmployee.getText();
		}

		logger.info("Ending of isWorkEmployeeFieldDisplayed method");

		return isWorkFilledEmployeeFieldDisplayed;
	}

	public String isWorkTerritoryFieldDisplayed() {
		logger.info("Starting of isWorkTerritoryFieldDisplayed method");

		String isWorkTerritoryFieldDisplayed;
		hardWait(4);

		try {

			isWorkTerritoryFieldDisplayed = workFieldTerritory.getText();

		} catch (Exception e) {

			isWorkTerritoryFieldDisplayed = workFieldTerritory.getText();
		}

		logger.info("Ending of isWorkTerritoryFieldDisplayed method");

		return isWorkTerritoryFieldDisplayed;
	}

	public String isWorkYesOrNoFieldDisplayed() {
		logger.info("Starting of isWorkYesOrNoFieldDisplayed method");

		String isWorkYesOrNoFieldDisplayed;
		hardWait(4);

		try {

			isWorkYesOrNoFieldDisplayed = workFieldYesOrNo.getText();

		} catch (Exception e) {

			isWorkYesOrNoFieldDisplayed = workFieldYesOrNo.getText();
		}

		logger.info("Ending of isWorkYesOrNoFieldDisplayed method");

		return isWorkYesOrNoFieldDisplayed;
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

	public String isWorkCustomerFieldDisplayed() {
		logger.info("Starting of isWorkCustomerFieldDisplayed method");

		String isWorkCustomerFieldDisplayed;
		hardWait(4);

		try {

			isWorkCustomerFieldDisplayed = workFieldCustomer.getText();

		} catch (Exception e) {

			isWorkCustomerFieldDisplayed = workFieldCustomer.getText();
		}

		logger.info("Ending of isWorkCustomerFieldDisplayed method");

		return isWorkCustomerFieldDisplayed;
	}

	public String isWorkCustomerTypeFieldDisplayed() {
		logger.info("Starting of isWorkCustomerTypeFieldDisplayed method");

		String isWorkCustomerTypeFieldDisplayed;
		hardWait(4);

		try {

			isWorkCustomerTypeFieldDisplayed = workFieldCustomerType.getText();

		} catch (Exception e) {

			isWorkCustomerTypeFieldDisplayed = workFieldCustomerType.getText();
		}

		logger.info("Ending of isWorkCustomerTypeFieldDisplayed method");

		return isWorkCustomerTypeFieldDisplayed;
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

	public String isYetToStartWorksDisplayed() {
		logger.info("Starting of isYetToStartWorksDisplayed method");

		String isYetToStartWorksDisplayed;
		hardWait(4);

		try {

			isYetToStartWorksDisplayed = filteredYetToStartWork.getText();

		} catch (Exception e) {

			isYetToStartWorksDisplayed = filteredYetToStartWork.getText();
		}

		logger.info("Ending of isYetToStartWorksDisplayed method");

		return isYetToStartWorksDisplayed;
	}

	public String workStatusDisplayed() {
		logger.info("Starting of workStatusDisplayed method");

		String workStatusDisplayed;
		hardWait(4);

		try {

			workStatusDisplayed = filteredWorkStatus.getText();

		} catch (Exception e) {

			workStatusDisplayed = filteredWorkStatus.getText();
		}

		logger.info("Ending of isCompletedWorksDisplayed method");

		return workStatusDisplayed;
	}

	public String workLastActivityDisplayed() {
		logger.info("Starting of workLastActivityDisplayed method");

		String workLastActivityDisplayed;
		hardWait(4);

		try {

			workLastActivityDisplayed = filteredLastActivity.getText();

		} catch (Exception e) {

			workLastActivityDisplayed = filteredLastActivity.getText();
		}

		logger.info("Ending of workLastActivityDisplayed method");

		return workLastActivityDisplayed;
	}

	public String workNextActivityDisplayed() {
		logger.info("Starting of workNextActivityDisplayed method");

		String workNextActivityDisplayed;
		hardWait(4);

		try {

			workNextActivityDisplayed = filteredNextActivity.getText();

		} catch (Exception e) {

			workNextActivityDisplayed = filteredNextActivity.getText();
		}

		logger.info("Ending of workNextActivityDisplayed method");

		return workNextActivityDisplayed;
	}

}
