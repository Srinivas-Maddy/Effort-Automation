
package com.effort.works;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class AddWorkProcess extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(AddWorkProcess.class);

	@FindBy(xpath = "//a[contains(text(),'Web App')]")
	private WebElement webApp;

	@FindBy(id = "work")
	private WebElement workModule;

	@FindBy(id = "searchText")
	private WebElement searchBox;

	@FindBy(xpath = "//h5[contains(text(),'Automation Action Procoss')]")
	private WebElement workName;

	@FindBy(xpath = "//h5[contains(text(),'Asmart Work Process')]")
	private WebElement smartWorkName;

	@FindBy(xpath = "//button[@id='addWorkBtn']")
	private WebElement addWorkBtn;

	@FindBy(xpath = "//input[@id='fields0_fieldValue']")
	private WebElement workNamefield;

	@FindBy(xpath = "//input[@id='fields1_fieldValueDateTime']")
	private WebElement workStartDate;

	@FindBy(xpath = "//input[@id='fields2_fieldValueDateTime']")
	private WebElement workEndDate;

	@FindBy(xpath = "//div[contains(@style,'display: block; left')]/div[1]/div[2]/table/tbody/tr/td")
	private List<WebElement> dateTimes;

	@FindBy(xpath = "//div[contains(@style,'display: block; left')]/div/div/button[3]")
	private WebElement calenderMonthBtn;

	@FindBy(id = "availability_proceedAnyWay")
	private WebElement acceptBtn;

	@FindBy(xpath = "(//div[@class='xdsoft_timepicker active'])[8]/div/div/div")
	private List<WebElement> timePickers;

	@FindBy(xpath = "(//span[contains(text(),'Select Employee')])[4]")
	private WebElement assigneeDropdown;

	@FindBy(xpath = "//div[@class='select2-search']/input[contains(@aria-activedescendant,'select2-result-label')]")
	private WebElement enterName;

	@FindBy(xpath = "(//div[@class='select2-search']/input[contains(@aria-activedescendant,'select2-result-label')])[2]")
	private WebElement assignEmpName;

	@FindBy(xpath = "//div[@id='select2-drop']/ul/li")
	private List<WebElement> employeeNames;

	@FindBy(xpath = "//input[@id='save1']")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[contains(text(),'Proceed Anyway')]")
	private WebElement btnProcessAnyway;

	@FindBy(xpath = "(//div[@class='xdsoft_timepicker active'])[2]/div/div[1]/div")
	private List<WebElement> timers;

	@FindBy(xpath = "//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath = "//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;

	@FindBy(xpath = "//input[@class='field date form-control']")
	private WebElement datePicker;

	@FindBy(id = "fields4_fieldValue")
	private WebElement textField;

	@FindBy(id = "fields8_fieldValue")
	private WebElement numberfield;

	@FindBy(id = "fields9_fieldValue")
	private WebElement timeField;

	@FindBy(id = "s2id_fields18_fieldValue")
	private WebElement countryDropdown;

	@FindBy(xpath = "(//li[@role='presentation'])[2]")
	private WebElement countryList;

	@FindBy(xpath = "//div[@id='s2id_fields20_fieldValue']")
	private WebElement customerTypePicker;

	@FindBy(xpath = "//ul[@id='select2-results-2']/li[2]")
	private WebElement selectTypeItem;

	@FindBy(xpath = "//select[@id='fields21_fieldValue']/following-sibling::button")
	private WebElement employeePicker;

	@FindBy(xpath = "//div[@id='s2id_fields4_fieldValue']")
	private WebElement smartWorkEmployeePicker;

	@FindBy(xpath = "//div[@id='s2id_fields3_fieldValue']")
	private WebElement assignSmartWorkEmployeePicker;

	@FindBy(xpath = "//table[@class='pq-grid-table pq-grid-td-border-right pq-grid-td-border-bottom ']/tbody/tr[3]/td[2]")
	private WebElement pickerSelection;

	@FindBy(xpath = "//input[@value='Ok']")
	private WebElement okBtn;

	@FindBy(xpath = "//div[@id='s2id_fields22_fieldValue']")
	private WebElement terrioryField;

	@FindBy(xpath = "//ul[@id='select2-results-3']/li[2]")
	private WebElement territoryItemSelection;

	@FindBy(xpath = "//div[@id='s2id_fields23_fieldValue']")
	private WebElement YesOrNoBtn;

	@FindBy(xpath = "//ul[@id='select2-results-4']/li[2]")
	private WebElement selectYesOrNoValue;

	@FindBy(xpath = "//select[@id='fields24_fieldValue']")
	private WebElement customEntityField;

	@FindBy(xpath = "//div[@id='s2id_fields25_fieldValue']")
	private WebElement dropdownField;

	@FindBy(xpath = "//div[@id='s2id_fields26_fieldValue']")
	private WebElement multiSelectDropdownField;

	@FindBy(xpath = "//input[@type='file']")
	private List<WebElement> fileChoose;

	@FindBy(xpath = "//select[@id='fields29_fieldValue']/following-sibling::a")
	private WebElement multiPickList;

	@FindBy(xpath = "//select[@id='fields30_fieldValue']")
	private WebElement formField;

	@FindBy(xpath = "//select[@id='fields31_fieldValue']")
	private WebElement PickListField;

	@FindBy(xpath = "//img[@id='add']")
	private WebElement secAddBtn;

	@FindBy(xpath = "//input[@id='sectionFields0_fieldValue']")
	private WebElement secTextField;

	@FindBy(xpath = "//input[@id='sectionFields1_fieldValue']")
	private WebElement secCurrencyField;

	@FindBy(xpath = "//input[@id='sectionFields2_fieldValue']")
	private WebElement secDateField;

	@FindBy(xpath = "//input[@id='sectionFields3_fieldValue']")
	private WebElement secEmailField;

	@FindBy(xpath = "//input[@id='sectionFields4_fieldValue']")
	private WebElement secNumberField;

	@FindBy(xpath = "//input[@id='sectionFields5_fieldValue']")
	private WebElement secPhoneField;

	@FindBy(xpath = "//i[@title='Edit']")
	private WebElement workEditIcon;

	@FindBy(xpath = "//div[contains(text(),'created successfull')]")
	private WebElement workCreatedSucessfullyText;

	@FindBy(xpath = "//div[contains(text(),'modified successfull')]")
	private WebElement workModifiedSucessfullyText;

	@FindBy(xpath = "//div[contains(text(),'successfull')]")
	private WebElement sucessfullyText;

	@FindBy(xpath = "//input[@id='selectWork']")
	private WebElement selectWork;

	@FindBy(xpath = "//button[@id='assignTo']")
	private WebElement reassignWorkBtn;

	@FindBy(xpath = "//span[contains(text(),'Search for Employees')]")
	private WebElement selectEmployee;

	@FindBy(xpath = "//input[@id='s2id_autogen9_search']")
	private WebElement searchEmp;

	@FindBy(xpath = "//div[@role='option']")
	private WebElement selectEmp;

	@FindBy(xpath = "//input[@id='assignWorks']")
	private WebElement workAssignBtn;

	@FindBy(xpath = "//a[contains(text(),'REASSIGN')]")
	private WebElement empReassigned;

	@FindBy(xpath = "//button[@id='deleteWorks']")
	private WebElement deleteWorkBtn;

	@FindBy(xpath = "//input[@id='deleteSelectedCheckBox']")
	private WebElement deleteCheckbox;

	@FindBy(xpath = "//input[@id='deleteSelected']")
	private WebElement deleteSelected;

// (//tr[contains(@class,
// 'selected')]//td//a[contains(@href,'/effortx/web/work/details/view/')])[2]
	@FindBy(xpath = "(//a[contains(@href,'/effortx/web/work/details/view/')])[2]")
	private WebElement workId;

	@FindBy(xpath = "//td[text()='No data available. Please re-check the filters']")
	private WebElement noResultsFount;

	@FindBy(xpath = "//button[@id='filters']")
	private WebElement workFilterBtn;

	@FindBy(xpath = "//button[@id='reset']")
	private WebElement resetFilterBtn;

	@FindBy(xpath = "//input[@id='filtWorkId']")
	private WebElement workIdTxt;

	@FindBy(xpath = "//button[@id='search']")
	private WebElement applyFilterBtn;

	@FindBy(xpath = "//button[@id='deleteFilteredWorks']")
	private WebElement deleteFilteredWorkBtn;

	@FindBy(xpath = "//input[@id='deleteFilteredCheckBox']")
	private WebElement deleteFilteredCheckbox;

	@FindBy(xpath = "//input[@id='deleteFiltered']")
	private WebElement deleteFiltered;

	@FindBy(xpath = "//button[@id='gotoNextAction2']")
	private WebElement workActionButton;

	@FindBy(xpath = "//button[contains(@onclick, 'accept')]")
	private WebElement smartWorkAcceptBtn;

	@FindBy(xpath = "//span[text()='Ok']")
	private WebElement smartWorkOkBtn;

	@FindBy(xpath = "//label[text()='Completed']")
	private WebElement workCompleted;

	@FindBy(xpath = "//img[@id='addAttachment']/parent::div/preceding-sibling::div")
	private WebElement addWorkAttachement;

	@FindBy(xpath = "//i[@id='workAttachmentsDataToggle']")
	private WebElement workAttachmentTgl;

	@FindBy(xpath = "//td[contains(text(),'All Field Form Auto')]")
	private WebElement AttachedWork;

	@FindBy(xpath = "//button[contains(@id,\"attachment_create\")]")
	private WebElement workAttachement;

	@FindBy(id = "yetToStartCount")
	private WebElement yetToStartCount_card;

	@FindBy(id = "unAssignedCount")
	private WebElement unAssignedCount_card;

	@FindBy(id = "rejectedCount")
	private WebElement rejectedCount_card;

	@FindBy(id = "inProgressWorkCount")
	private WebElement inProgressWorkCount_card;

	@FindBy(id = "completedCount")
	private WebElement completedCount_card;

	@FindBy(id = "yoursCount")
	private WebElement yoursCount_card;

	@FindBy(id = "teamsCount")
	private WebElement teamsCount_card;

	@FindBy(id = "switchActionableWork")
	private WebElement yoursToggleBtn;

	@FindBy(id = "switchTeamActionableWork")
	private WebElement teamsToggleBtn;

	@FindBy(xpath = "//div[contains(text(),'Showing')]")
	private WebElement totalWorks_txt;

	@FindBy(id = "pendingCount")
	private WebElement pendingCount;

	@FindBy(id = "actionableCount")
	private WebElement actionableCount;

	@FindBy(id = "teamActionableCount")
	private WebElement teamActionableCount;

	@FindBy(id = "updatedTodayCount")
	private WebElement updatedTodayCount;

	public AddWorkProcess(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public static String workID;

	public void clickOnWebApp() {
		logger.info("Starting of clickOn WebApp method");

		hardWait(3);
		waitUntilElementVisible(driver, this.webApp);
		this.webApp.click();

		logger.info("Ending of clicOnWebApp Method");

	}

	public void clickOnDatePicker(String date) {
		logger.info("Starting of clickOnDatePicker method");

		waitUntilElementVisible(driver, datePicker);
		this.datePicker.sendKeys(date);
		implicitWait();
		clickOnWebElement(datePicker);

		logger.info("Ending of clickOnDatePicker method");
	}

	public void SetDateInSection(String date) {
		logger.info("Starting of clickOnDatePicker method");

		waitUntilElementVisible(driver, secDateField);
		this.secDateField.sendKeys(date);
		implicitWait();
		clickOnWebElement(secDateField);

		logger.info("Ending of clickOnDatePicker method");
	}

	public void enterEmailInSection(String email) {
		logger.info("Starting of enter Email method");

		waitUntilElementVisible(driver, this.secEmailField);
		this.secEmailField.sendKeys(email);

		logger.info("Ending of enter Email method");
	}

	public void enterNumberData(String numberData) {
		logger.info("Starting of enter number method");

		waitUntilElementVisible(driver, numberfield);
		this.numberfield.sendKeys(numberData);

		logger.info("Ending of enter number method");
	}

	public void enterNumberInSection(String numberData) {
		logger.info("Starting of enter number method");

		waitUntilElementVisible(driver, secNumberField);
		this.secNumberField.sendKeys(numberData);

		logger.info("Ending of enter number method");
	}

	public void phoneNumberInSection(String phoneNumber) {
		logger.info("Starting of phoneNumber method");

		this.secPhoneField.sendKeys(phoneNumber);

		logger.info("Ending of phoneNumber method");

	}

	public void enterTextData(String TextData) {
		logger.info("Starting of enterTextData method");

		waitUntilElementVisible(driver, textField);
		this.textField.sendKeys(TextData);

		logger.info("Ending of enterTextData method");
	}

	public void enterTextDataInSection(String TextData) {
		logger.info("Starting of enterTextData method");

		waitUntilElementVisible(driver, secTextField);
		this.secTextField.sendKeys(TextData);

		logger.info("Ending of enterTextData method");
	}

	public void enterCurrencyInSection(String CurrencyValue) {
		logger.info("Starting of enterCurrency method");

		waitUntilElementVisible(driver, secCurrencyField);
		this.secCurrencyField.sendKeys(CurrencyValue);

		logger.info("Ending of enterCurrency method");
	}

	public void pickTime(String time) throws InterruptedException {
		logger.info("Starting of pickTime method");

		waitUntilElementVisible(driver, this.timeField);
		scrollDown(100, timeField);
		this.timeField.sendKeys(time);
		this.timeField.click();
		/*
		 * String currentTime = getCurrentTime(); String[] timeString =
		 * currentTime.split(":"); Integer hour = Integer.parseInt(timeString[0]); hour
		 * = hour * 60; Integer min = Integer.parseInt(timeString[1]); int index = hour
		 * + min; int timerItemsCount = timers.size(); if (timerItemsCount != 1440) {
		 * index = 50; } Thread.sleep(1000); //this.timers.get(index).click();
		 * clickUsingActionClass(timers.get(index));
		 */

		logger.info("Ending of enterTextData method");
	}

	public void pickCountry() {
		logger.info("Starting of pickCountry method");

		waitUntilElementVisible(driver, this.countryDropdown);
		scrollIntoView(countryDropdown);
		this.countryDropdown.click();
		waitUntilElementVisible(driver, this.countryList);
		this.countryList.click();

		logger.info("Ending of pickCountry method");

	}

	public void pickCustomerType() {
		logger.info("Starting of pick coustomer method");

		waitUntilElementVisible(driver, this.customerTypePicker);
		this.customerTypePicker.click();
		waitUntilElementVisible(driver, this.countryList);
		this.countryList.click();

		logger.info("Ending of pick coustomer method");
	}

	public void pickEmployee() throws InterruptedException {
		logger.info("Starting of pick Employee method");

		waitUntilElementVisible(driver, this.employeePicker);
		this.employeePicker.click();
		Thread.sleep(3000);
		waitUntilElementVisible(driver, this.pickerSelection);
		this.pickerSelection.click();
		this.okBtn.click();

		logger.info("Ending of pick Employee method");
	}

	public void SelectTerritory() {
		logger.info("Starting of SelectTerritory method");

		waitUntilElementVisible(driver, this.terrioryField);
		this.terrioryField.click();
		waitUntilElementVisible(driver, this.countryList);
		this.countryList.click();

		logger.info("Ending of SelectTerritory method");
	}

	public void selectYesOrNo() {
		logger.info("Starting of select yes or no method");

		waitUntilElementVisible(driver, this.YesOrNoBtn);
		this.YesOrNoBtn.click();
		waitUntilElementVisible(driver, this.countryList);
		this.countryList.click();

		logger.info("Ending of yes or no method");
	}

	public void selectCustomEntity() {
		logger.info("Starting of select custom entity method");

		waitUntilElementVisible(driver, this.customEntityField);
		this.customEntityField.click();
		hardWait(4);
		waitUntilElementVisible(driver, this.pickerSelection);
		this.pickerSelection.click();
		this.okBtn.click();

		logger.info("Ending of custom entity method");

	}

	public void SelectDropdown() {
		logger.info("Starting of SelectDropdown method");

		waitUntilElementVisible(driver, this.dropdownField);
		this.dropdownField.click();
		waitUntilElementVisible(driver, this.countryList);
		this.countryList.click();

		logger.info("Ending of SelectDropdown method");
	}

	public void SelectMultiDropdown() {
		logger.info("Starting of SelectMultiDropdown method");

		waitUntilElementVisible(driver, this.multiSelectDropdownField);
		this.multiSelectDropdownField.click();
		waitUntilElementVisible(driver, this.countryList);
		this.countryList.click();

		logger.info("Ending of SelectMultiDropdown method");
	}

	public void uploadMultiImage(String filepath) {
		logger.info("Starting of uploadMultiImage method");

		this.fileChoose.get(4).sendKeys(filepath);

		logger.info("Ending of uploadMultiImage method");
	}

	public void uploadMultiDocument(String filepath) {
		logger.info("Starting of uploadMultiDocument method");

		this.fileChoose.get(5).sendKeys(filepath);

		logger.info("Ending of uploadMultiDocument method");
	}

	public void pickMultiPickList() throws InterruptedException {
		logger.info("Starting of pickMultiPickList method");

		waitUntilElementVisible(driver, this.multiPickList);
		this.multiPickList.click();
		Thread.sleep(3000);
		waitUntilElementVisible(driver, this.pickerSelection);
		this.pickerSelection.click();
		this.okBtn.click();

		logger.info("Ending of pickMultiPickList method");
	}

	public void formField() throws InterruptedException {
		logger.info("Starting of formField method");

		waitUntilElementVisible(driver, this.formField);
		this.formField.click();
		Thread.sleep(3000);
		waitUntilElementVisible(driver, this.pickerSelection);
		this.pickerSelection.click();
		this.okBtn.click();

		logger.info("Ending of formField method");
	}

	public void pickListField() throws InterruptedException {
		logger.info("Starting of pickMultiPickList method");

		waitUntilElementVisible(driver, this.PickListField);
		this.PickListField.click();
		Thread.sleep(3000);
		waitUntilElementVisible(driver, this.pickerSelection);
		this.pickerSelection.click();
		this.okBtn.click();

		logger.info("Ending of pickMultiPickList method");
	}

	public void clickOnSectionAddButton() {
		logger.info("Starting of clickOn WebApp method");

		hardWait(3);
		scrollIntoView(secAddBtn);
		waitUntilElementVisible(driver, this.secAddBtn);
		clickUsingActionClass(secAddBtn);
		hardWait(5);

		logger.info("Ending of clicOnWebApp Method");
	}

	public void clickOnProcessModule() {
		logger.info("Starting of clickOnProcess module method");

		waitUntilElementVisible(driver, this.workModule);
		this.workModule.click();

		logger.info("Ending of clickOnProcess module method");
	}

	public void clickOnWorkName() {
		logger.info("Starting of click on work name method");

		waitUntilElementVisible(driver, this.searchBox);
		this.searchBox.sendKeys("Automation Action Procoss");
		waitUntilElementVisible(driver, this.workName);
		this.workName.click();

		logger.info("ending of click on work name method");
	}

	public void clickOnSmartWorkName() {
		logger.info("Starting of clickOnSmartWorkName method");

		waitUntilElementVisible(driver, this.smartWorkName);
		this.searchBox.sendKeys("Asmart Work Process");
		waitUntilElementVisible(driver, this.smartWorkName);
		this.smartWorkName.click();

		logger.info("ending of clickOnSmartWorkName method");
	}

	public void clickOnAddWorkBtn() {
		logger.info("Starting of clickOnAddWorkBtn method");

		waitUntilElementVisible(driver, this.addWorkBtn);
		this.addWorkBtn.click();

		logger.info("Ending of clickOnAddWorkBtn menthod");
	}

	public void enterWorkName(String workName) {
		logger.info("Starting of enterWorkName method");

		hardWait(5);
		workNamefield.clear();
		waitUntilElementVisible(driver, this.workNamefield);
		this.workNamefield.sendKeys(workName);

		logger.info("Ending of enterWorkName menthod");

	}

	public void clickOnWorkEndDate() throws InterruptedException {
		logger.info("Starting of clickOnWorkEndDate method");

		waitUntilElementVisible(driver, this.workEndDate);
		Thread.sleep(10000);
		this.workEndDate.click();
		waitUntilElementVisible(driver, this.calenderMonthBtn);
		clickOnWebElement(this.calenderMonthBtn);

		logger.info("Ending of clickOnWorkEndDate method");
	}

	public void clickOnCurrentDateTime() throws InterruptedException {
		logger.info("Starting of clickOnCurrentDateTime method");

		String presentDate = getTomorrowDateAsNumber(1);
		for (int i = 0; i <= dateTimes.size() - 1; i++) {
			hardWait(2);
			String actualDate = (String) ((JavascriptExecutor) driver).executeScript("return $(arguments[0]).text();",
					dateTimes.get(i));
			if (actualDate.equalsIgnoreCase(presentDate)) {
// clickOnWebElement(dateTimes.get(i));
				waitUntilElementVisible(driver, dateTimes.get(i));
				clickUsingActionClass(dateTimes.get(i));
				break;
			}
		}
		this.workEndDate.click();

		logger.info("Ending of clickOnDatePicker method");
	}

	public void pickWorkEndDate() {
		logger.info("Starting of pickWorkEndDate Method");

		String currentTime = getCurrentTimeAsFiveMinInterval();
		for (int i = 0; i < timePickers.size(); i++) {
			String timeIntervals = (String) ((JavascriptExecutor) driver)
					.executeScript("return $(arguments[0]).text();", timePickers.get(i));
			if (timeIntervals.equalsIgnoreCase(currentTime)) {
				waitUntilElementVisible(driver, timePickers.get(i));
				timePickers.get(i).click();
				break;
			}

		}

		logger.info("Ending of pickerWorkEndDate Method");
	}

	public void assignEmplpoyee(String assigneeName) {
		logger.info("Starting of assign Employee");

		scrollIntoView(assigneeDropdown);

		waitUntilElementVisible(driver, this.assigneeDropdown);
		this.assigneeDropdown.click();
		waitUntilElementVisible(driver, this.enterName);
		this.enterName.sendKeys(assigneeName);
		for (int i = 0; i < employeeNames.size(); i++) {
			String actualEmpName = employeeNames.get(i).getText();
			if (actualEmpName.equalsIgnoreCase(assigneeName)) {
				waitUntilElementVisible(driver, employeeNames.get(i));
				employeeNames.get(i).click();
				break;
			}

		}
		hardWait(3);

		logger.info("Ending of assign Employee");
	}

	public void assignSmartWorkEmplpoyee(String assigneeName) {
		logger.info("Starting of assignSmartWorkEmplpoyee");

		waitUntilElementVisible(driver, this.assignSmartWorkEmployeePicker);
		this.assignSmartWorkEmployeePicker.click();
		waitUntilElementVisible(driver, this.assignEmpName);
		this.assignEmpName.sendKeys(assigneeName);
		for (int i = 0; i < employeeNames.size(); i++) {
			String actualEmpName = employeeNames.get(i).getText();
			if (actualEmpName.equalsIgnoreCase(assigneeName)) {
				waitUntilElementVisible(driver, employeeNames.get(i));
				employeeNames.get(i).click();
				break;
			}

		}
		hardWait(3);

		logger.info("Ending of assignSmartWorkEmplpoyee");
	}

	public void smartWorkEmplpoyee(String assigneeName) {
		logger.info("Starting of smartEmplpoyeee");

		waitUntilElementVisible(driver, this.smartWorkEmployeePicker);
		this.smartWorkEmployeePicker.click();
		waitUntilElementVisible(driver, this.enterName);
		this.enterName.sendKeys(assigneeName);
		for (int i = 0; i < employeeNames.size(); i++) {
			String actualEmpName = employeeNames.get(i).getText();
			if (actualEmpName.equalsIgnoreCase(assigneeName)) {
				waitUntilElementVisible(driver, employeeNames.get(i));
				employeeNames.get(i).click();
				break;
			}

		}
		hardWait(3);

		logger.info("Ending of smartEmplpoyee");
	}

	public void clickOnSave() {
		logger.info("Starting of clickOnSave method");

		try {
			waitUntilElementVisible(driver, this.saveBtn);
			this.saveBtn.click();
// Process Conflict Alert Handling
			try {
				waitUntilElementVisible(driver, this.btnProcessAnyway);
				this.btnProcessAnyway.click();
			} catch (Exception e1) {
				logger.info("Process Anyway Btn is not visible");
			}

// Employee OnLeave Alert Handle

			try {
				this.hardWait(3);
				if (this.acceptBtn.isDisplayed()) {
					this.acceptBtn.click();
				}
			} catch (Exception e2) {
				logger.info("On Leave Alert was not displayed");
			}

		} catch (Exception e) {
			System.out.println("Work Not Saved ");
		}

		hardWait(2);

		logger.info("Ending of clickOnSave method");
	}

	public void clickOnSaveWhileNewAdd() {
		logger.info("Starting of clickOnSaveWhileNewAdd method");

		for (int i = 0; i < 1; i++) {

			waitUntilElementVisible(driver, this.saveBtn);
			this.saveBtn.click();
// Process Conflict Alert Handling
			try {
				if (sucessfullyText.isDisplayed()) {
					break;
				}

			} catch (Exception e) {
				try {
					waitUntilElementVisible(driver, this.btnProcessAnyway);
					this.btnProcessAnyway.click();
				} catch (Exception e1) {
					logger.info("Process Anyway Btn is not visible");
				}
			}

// Employee OnLeave Alert Handle
			try {
				if (sucessfullyText.isDisplayed()) {
					break;
				}

			} catch (Exception e) {
				try {
					if (this.acceptBtn.isDisplayed()) {
						this.acceptBtn.click();
					}
				} catch (Exception e2) {
					logger.info("On Leave Alert was not displayed");
				}
			}

		}

		hardWait(2);

		logger.info("Ending of clickOnSaveWhileNewAdd method");
	}

	public boolean isWorkAddedSucessfully() {
		logger.info("Starting of isWorkAddedSucessfully method");

		boolean isWorkAddedSucessfully = false;

		try {

			if (workCreatedSucessfullyText.isDisplayed()) {

				isWorkAddedSucessfully = true;
				
				String IDWork  = workCreatedSucessfullyText.getText();
                workID = IDWork.substring(8, 16);

			}
		} catch (Exception e) {

			isWorkAddedSucessfully = false;
		}

		logger.info("Ending of isWorkAddedSucessfully method");

		return isWorkAddedSucessfully;
	}

	public boolean isWorkModifiedSucessfully() {
		logger.info("Starting of isWorkModifiedSucessfully method");

		boolean isWorkModifiedSucessfully = false;

		try {
			waitUntilElementVisible(driver, workModifiedSucessfullyText);

			if (workModifiedSucessfullyText.isDisplayed()) {

				isWorkModifiedSucessfully = true;
			}

		} catch (Exception e) {

			isWorkModifiedSucessfully = false;
		}

		logger.info("Ending of isWorkModifiedSucessfully method");

		return isWorkModifiedSucessfully;
	}

	public void clickOnEditIcn() {
		logger.info("Starting of clickOnEditIcn method");

		waitUntilElementVisible(driver, this.workEditIcon);
		clickOnWebElementUsingJavascript(workEditIcon);

		logger.info("Ending of clickOnEditIcn menthod");
	}

	public void clickOnWorkSelectButton() {
		logger.info("Starting of clickOnWorkSelectButton method");

		hardWait(3);
		scrollIntoView(this.selectWork);
		waitUntilElementVisible(driver, this.selectWork);
		clickOnWebElementUsingJavascript(selectWork);
		hardWait(3);

		logger.info("Ending of clickOnWorkSelectButton menthod");
	}

	public void clickOnReaAsignWork() {
		logger.info("Starting of clickOnReaAsignWork method");

		waitUntilElementVisible(driver, this.reassignWorkBtn);
		clickOnWebElementUsingJavascript(reassignWorkBtn);
		hardWait(2);

		logger.info("Ending of clickOnReaAsignWork menthod");
	}

	public void deleteSelectedWork() {
		logger.info("Starting of clickOnDeleteWork method");

		hardWait(3);
		waitUntilElementVisible(driver, this.deleteWorkBtn);
		clickOnWebElementUsingJavascript(deleteWorkBtn);
		hardWait(3);

		waitUntilElementVisible(driver, this.deleteCheckbox);
		clickOnWebElementUsingJavascript(deleteCheckbox);
		hardWait(5);

		waitUntilElementVisible(driver, this.deleteSelected);
		clickOnWebElementUsingJavascript(deleteSelected);

		hardWait(6);

		driver.switchTo().alert().accept();

		logger.info("Ending of clickOnDeleteWork menthod");
	}

	public void deleteFilteredWork() {
		logger.info("Starting of deleteFilteredWork method");

		waitUntilElementVisible(driver, this.deleteFilteredWorkBtn);
		clickOnWebElementUsingJavascript(deleteFilteredWorkBtn);
		hardWait(3);

		waitUntilElementVisible(driver, this.deleteFilteredCheckbox);
		clickOnWebElementUsingJavascript(deleteFilteredCheckbox);
		hardWait(3);

		waitUntilElementVisible(driver, this.deleteFiltered);
		clickOnWebElementUsingJavascript(deleteFiltered);

		hardWait(3);

		logger.info("Ending of deleteFilteredWork menthod");
	}

	public void clickOnSelectEmployee() {
		logger.info("Starting of clickOnselectEmployee method");

		hardWait(3);
		waitUntilElementVisible(driver, this.selectEmployee);
		clickUsingActionClass(selectEmployee);
		hardWait(3);

		logger.info("Ending of clickOnselectEmployee menthod");
	}

	public void clickOnSeachEmp(String empName) {
		logger.info("Starting of clickOnSeachEmp method");

		waitUntilElementVisible(driver, this.searchEmp);
		clickOnWebElementUsingJavascript(searchEmp);
		searchEmp.sendKeys(empName);

		logger.info("Ending of clickOnSeachEmp menthod");
	}

	public void clickOnEmp() {
		logger.info("Starting of clickOnSeachEmp method");

		waitUntilElementVisible(driver, this.selectEmp);
		clickUsingActionClass(selectEmp);

		logger.info("Ending of clickOnSeachEmp menthod");
	}

	public void assignWork() {
		logger.info("Starting of assignWork method");
		hardWait(2);
		waitUntilElementVisible(driver, this.workAssignBtn);
		clickOnWebElementUsingJavascript(workAssignBtn);

		this.hardWait(3);
		logger.info("Ending of assignWork menthod");
	}

	public void filterWork() {
		logger.info("Starting of filterWork method");
		hardWait(3);

		waitUntilElementVisible(driver, this.workFilterBtn);
		clickOnWebElementUsingJavascript(workFilterBtn);

		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickUsingActionClass(resetFilterBtn);

		scrollIntoView(workIdTxt);
		waitUntilElementVisible(driver, this.workIdTxt);
// clickUsingActionClass(workIdTxt);
		workIdTxt.sendKeys(workID);

		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickUsingActionClass(applyFilterBtn);

		logger.info("Ending of filterWork menthod");
	}

	public boolean isWorkReassignedSucessfully() {
		logger.info("Starting of isWorkReassignedSucessfully method");
		this.hardWait(3);

		boolean isWorkReassignedSucessfully = false;

		scrollIntoView(workFilterBtn);
		try {

			if (empReassigned.isDisplayed()) {

				isWorkReassignedSucessfully = true;
			}
		} catch (Exception e) {

			isWorkReassignedSucessfully = false;
		}

		logger.info("Ending of isWorkReassignedSucessfully method");

		return isWorkReassignedSucessfully;
	}

	public boolean isWorkCompletedSucessfully() {
		logger.info("Starting of isWorkCompletedSucessfully method");

		boolean isWorkCompletedSucessfully = false;

		scrollIntoView(workCompleted);
		try {

			if (workCompleted.isDisplayed()) {

				isWorkCompletedSucessfully = true;
			}
		} catch (Exception e) {

			isWorkCompletedSucessfully = false;
		}

		logger.info("Ending of isWorkCompletedSucessfully method");

		return isWorkCompletedSucessfully;
	}

	public void getWorkId() {
		logger.info("Starting of getWorkId method");

		hardWait(3);

		waitUntilElementVisible(driver, this.workId);
		workID = workId.getText();

		logger.info("Ending of getWorkId menthod");
	}

	public String getSmartWorkId() {
		logger.info("Starting of getWorkId method");

		hardWait(3);

		waitUntilElementVisible(driver, this.workId);
		workID = workId.getText();

		logger.info("Ending of getWorkId menthod");
		return workID;
	}

	public void clickOnWorkId() {
		logger.info("Starting of clickOnWorkId method");

		hardWait(3);

		waitUntilElementVisible(driver, this.workId);
		clickOnWebElementUsingJavascript(workId);

		logger.info("Ending of clickOnWorkId menthod");
	}

	public void clickOnWorkActionButton() {
		logger.info("Starting of clickOnWorkActionButton method");

		hardWait(5);

		waitUntilElementVisible(driver, this.workActionButton);
		clickOnWebElement(workActionButton);

		logger.info("Ending of clickOnWorkActionButton menthod");
	}

	public void clickOnWorkAttachmentButton() {
		logger.info("Starting of clickOnWorkAttachmentButton method");

		hardWait(2);

		waitUntilElementVisible(driver, this.workAttachement);
		clickOnWebElement(workAttachement);

		hardWait(3);

		logger.info("Ending of clickOnWorkAttachmentButton menthod");
	}

	public void clickOnAccept() {
		logger.info("Starting of clickOnAccept method");

		hardWait(3);

		waitUntilElementVisible(driver, this.smartWorkAcceptBtn);
		clickOnWebElement(smartWorkAcceptBtn);

		logger.info("Ending of clickOnAccept menthod");
	}

	public void clickOnOkButton() {
		logger.info("Starting of clickOnOkButton method");

		hardWait(3);

		clickOnWebElement(smartWorkOkBtn);

		logger.info("Ending of clickOnOkButton menthod");
	}

	public boolean isWorkdDeletedSucessfully() {
		logger.info("Starting of isWorkdDeletedSucessfully method");

		hardWait(5);
		boolean isWorkdDeletedSucessfully = false;
		scrollIntoView(workFilterBtn);

		try {

			if (noResultsFount.isDisplayed()) {

				isWorkdDeletedSucessfully = true;
			}
		} catch (Exception e) {

			isWorkdDeletedSucessfully = false;
		}

		logger.info("Ending of isWorkdDeletedSucessfully method");

		return isWorkdDeletedSucessfully;
	}

	public void clickOnAddWorkAttachmentButton() {
		logger.info("Starting of clickOnWorkAttachmentButton method");

		hardWait(3);
		this.scrollIntoView(addWorkAttachement);

		clickOnWebElement(addWorkAttachement);

		logger.info("Ending of clickOnWorkAttachmentButton menthod");
	}

	public void clickOnAttachmentViewButton() {
		logger.info("Starting of clickOnAttachmentViewButton method");

		scrollIntoView(addWorkAttachement);

		clickUsingActionClass(addWorkAttachement);//workAttachmentTgl

		hardWait(3);

		logger.info("Ending of clickOnAttachmentViewButton menthod");
	}

	public boolean isWorkAttachmentAddedSucessfully() {
		logger.info("Starting of isWorkAttachmentAddedSucessfully method");

		boolean isWorkAttachmentAddedSucessfully = false;

		hardWait(3);

		try {
			scrollIntoView(AttachedWork);

			waitUntilElementVisible(driver, AttachedWork);
			if (AttachedWork.isDisplayed()) {

				isWorkAttachmentAddedSucessfully = true;
			}
		} catch (Exception e) {

			isWorkAttachmentAddedSucessfully = false;
		}

		logger.info("Ending of isWorkAttachmentAddedSucessfully method");

		return isWorkAttachmentAddedSucessfully;
	}

	private int number;

	public boolean isYetToStartCountDisplayed() {
		logger.info("Starting of isYetToStartCountDisplayed Method");

		Boolean isYetToStartCountDisplayed = false;
		waitUntilElementVisible(driver, yetToStartCount_card);
		hardWait(3);
		String yetToStart = yetToStartCount_card.getText();
		number = Integer.valueOf(yetToStart);

		if (number > 0) {

			clickOnWebElement(yetToStartCount_card);
			/////////////////
			hardWait(3);
			String worksCountText = totalWorks_txt.getText();
			// int length = worksCountText.length();
			String text;

			if (number < 10) {
				text = worksCountText.substring(18, 20);
			} else if (number > 9) {
				text = worksCountText.substring(18, 21);
			} else {
				text = worksCountText.substring(18, 22);
			}

			String totalCust = text.trim();
			hardWait(3);
			// totalCustomersText.substring(4);
			if (totalCust.equalsIgnoreCase(yetToStart)) {
				isYetToStartCountDisplayed = true;
			}
		} else {
			logger.info("The yet to start count was zero");
			isYetToStartCountDisplayed = true;
		}
		logger.info("Ending of isYetToStartCountDisplayed Method");
		return isYetToStartCountDisplayed;

	}

	public boolean isUnassignedCountDisplayed() {
		logger.info("Starting of isUnassignedCountDisplayed Method");

		Boolean isUnassignedCountDisplayed = false;
		waitUntilElementVisible(driver, unAssignedCount_card);
		hardWait(3);
		String yetToStart = unAssignedCount_card.getText();
		number = Integer.valueOf(yetToStart);

		if (number > 0) {

			clickOnWebElement(unAssignedCount_card);
			/////////////////
			hardWait(3);
			String worksCountText = totalWorks_txt.getText();
			// int length = worksCountText.length();
			String text;

			if (number < 10) {
				text = worksCountText.substring(18, 20);
			} else if (number > 9) {
				text = worksCountText.substring(18, 21);
			} else {
				text = worksCountText.substring(18, 22);
			}

			String totalCust = text.trim();
			hardWait(3);
			// totalCustomersText.substring(4);
			if (totalCust.equalsIgnoreCase(yetToStart)) {
				isUnassignedCountDisplayed = true;
			}
		} else {
			logger.info("The Unassigned count was zero");
			isUnassignedCountDisplayed = true;
		}

		logger.info("Ending of isUnassignedCountDisplayed Method");
		return isUnassignedCountDisplayed;

	}

	public boolean isRejectedCountDisplayed() {
		logger.info("Starting of isRejectedCountDisplayed Method");

		Boolean isRejectedCountDisplayed = false;
		waitUntilElementVisible(driver, rejectedCount_card);
		hardWait(3);
		String yetToStart = rejectedCount_card.getText();

		number = Integer.valueOf(yetToStart);

		if (number > 0) {

			clickOnWebElement(rejectedCount_card);
			/////////////////
			hardWait(3);
			String worksCountText = totalWorks_txt.getText();
			// int length = worksCountText.length();
			String text;

			if (number < 10) {
				text = worksCountText.substring(18, 20);
			} else if (number > 9) {
				text = worksCountText.substring(18, 21);
			} else {
				text = worksCountText.substring(18, 22);
			}

			String totalCust = text.trim();
			hardWait(3);
			// totalCustomersText.substring(4);
			if (totalCust.equalsIgnoreCase(yetToStart)) {
				isRejectedCountDisplayed = true;
			}
		} else {
			logger.info("The Rejected count was zero");
			isRejectedCountDisplayed = true;
		}
		logger.info("Ending of isRejectedCountDisplayed Method");
		return isRejectedCountDisplayed;

	}

	public boolean isInProgressCountDisplayed() {
		logger.info("Starting of isInProgressCountDisplayed Method");

		Boolean isInProgressCountDisplayed = false;
		waitUntilElementVisible(driver, inProgressWorkCount_card);
		hardWait(3);
		String yetToStart = inProgressWorkCount_card.getText();

		number = Integer.valueOf(yetToStart);

		if (number > 0) {

			clickOnWebElement(inProgressWorkCount_card);
			/////////////////
			hardWait(3);
			String worksCountText = totalWorks_txt.getText();
			// int length = worksCountText.length();
			String text;

			if (number < 10) {
				text = worksCountText.substring(18, 20);
			} else if (number > 9) {
				text = worksCountText.substring(18, 21);
			} else {
				text = worksCountText.substring(18, 22);
			}

			String totalCust = text.trim();
			hardWait(3);
			// totalCustomersText.substring(4);
			if (totalCust.equalsIgnoreCase(yetToStart)) {
				isInProgressCountDisplayed = true;
			}
		} else {
			logger.info("The In Progress count was zero");
			isInProgressCountDisplayed = true;
		}

		logger.info("Ending of isInProgressCountDisplayed Method");
		return isInProgressCountDisplayed;

	}

	public boolean isCompletedCountDisplayed() {
		logger.info("Starting of isCompletedCountDisplayed Method");

		Boolean isCompletedCountDisplayed = false;
		waitUntilElementVisible(driver, completedCount_card);
		hardWait(3);
		String yetToStart = completedCount_card.getText();

		number = Integer.valueOf(yetToStart);

		if (number > 0) {

			clickOnWebElement(completedCount_card);
			/////////////////
			hardWait(3);
			String worksCountText = totalWorks_txt.getText();
			// int length = worksCountText.length();
			String text;

			if (number < 10) {
				text = worksCountText.substring(18, 20);
			} else if (number > 9) {
				text = worksCountText.substring(18, 21);
			} else {
				text = worksCountText.substring(18, 22);
			}

			String totalCust = text.trim();
			hardWait(3);
			// totalCustomersText.substring(4);
			if (totalCust.equalsIgnoreCase(yetToStart)) {
				isCompletedCountDisplayed = true;
			}
		} else {
			logger.info("The completed count was zero");
			isCompletedCountDisplayed = true;
		}
		logger.info("Ending of isCompletedCountDisplayed Method");
		return isCompletedCountDisplayed;

	}

	public boolean isYoursCountDisplayed() {
		logger.info("Starting of isYoursCountDisplayed Method");

		Boolean isYoursCountDisplayed = false;
		waitUntilElementVisible(driver, yoursCount_card);
		hardWait(3);
		String yetToStart = yoursCount_card.getText();

		number = Integer.valueOf(yetToStart);

		if (number > 0) {

			clickOnWebElement(yoursCount_card);
			/////////////////
			hardWait(3);
			String worksCountText = totalWorks_txt.getText();
			// int length = worksCountText.length();
			String text;

			if (number < 10) {
				text = worksCountText.substring(18, 20);
			} else if (number > 9) {
				text = worksCountText.substring(18, 21);
			} else {
				text = worksCountText.substring(18, 22);
			}

			String totalCust = text.trim();
			hardWait(3);
			// totalCustomersText.substring(4);
			if (totalCust.equalsIgnoreCase(yetToStart) && yoursToggleBtn.isSelected()) {
				isYoursCountDisplayed = true;
			}
		} else {
			logger.info("The Yours count was zero");
			isYoursCountDisplayed = true;
		}
		logger.info("Ending of isYoursCountDisplayed Method");
		return isYoursCountDisplayed;

	}

	public boolean isTeamCountDisplayed() {
		logger.info("Starting of isTeamCountDisplayed Method");

		Boolean isTeamCountDisplayed = false;
		waitUntilElementVisible(driver, teamsCount_card);
		hardWait(3);
		String yetToStart = teamsCount_card.getText();

		number = Integer.valueOf(yetToStart);

		if (number > 0) {

			clickOnWebElement(teamsCount_card);
			/////////////////
			hardWait(3);
			String worksCountText = totalWorks_txt.getText();
			// int length = worksCountText.length();
			String text;

			if (number < 10) {
				text = worksCountText.substring(18, 20);
			} else if (number > 9) {
				text = worksCountText.substring(18, 21);
			} else {
				text = worksCountText.substring(18, 22);
			}

			String totalCust = text.trim();
			hardWait(3);
			// totalCustomersText.substring(4);
			if (totalCust.equalsIgnoreCase(yetToStart) && teamsToggleBtn.isSelected()) {
				isTeamCountDisplayed = true;
			}
		} else {
			logger.info("The Teams count was zero");
			isTeamCountDisplayed = true;
		}
		logger.info("Ending of isTeamCountDisplayed Method");
		return isTeamCountDisplayed;

	}

	public boolean ispendingCountDisplayed() {
		logger.info("Starting of ispendingCountDisplayed Method");

		driver.navigate().refresh();
		Boolean ispendingCountDisplayed = false;
		scrollIntoView(pendingCount);

		waitUntilElementVisible(driver, pendingCount);
		hardWait(3);
		String yetToStart = pendingCount.getText();

		number = Integer.valueOf(yetToStart);

		if (number > 0) {

			clickOnWebElement(pendingCount);
			/////////////////
			hardWait(3);
			String worksCountText = totalWorks_txt.getText();
			// int length = worksCountText.length();
			String text;

			if (number < 10) {
				text = worksCountText.substring(18, 20);
			} else if (number > 9) {
				text = worksCountText.substring(18, 21);
			} else {
				text = worksCountText.substring(18, 22);
			}

			String totalCust = text.trim();
			hardWait(3);
			// totalCustomersText.substring(4);
			if (totalCust.equalsIgnoreCase(yetToStart)) {
				ispendingCountDisplayed = true;
			}
		} else {
			logger.info("The pending count was zero");
			ispendingCountDisplayed = true;
		}
		logger.info("Ending of ispendingCountDisplayed Method");
		return ispendingCountDisplayed;

	}

	public boolean yoursCountDisplayed() {
		logger.info("Starting of yoursCountDisplayed Method");

		Boolean actionableCountDisplayed = false;
		waitUntilElementVisible(driver, actionableCount);
		hardWait(3);
		String yetToStart = actionableCount.getText();

		number = Integer.valueOf(yetToStart);

		if (number > 0) {

			clickOnWebElement(actionableCount);
			/////////////////
			hardWait(3);
			String worksCountText = totalWorks_txt.getText();
			// int length = worksCountText.length();
			String text;

			if (number < 10) {
				text = worksCountText.substring(18, 20);
			} else if (number > 9) {
				text = worksCountText.substring(18, 21);
			} else {
				text = worksCountText.substring(18, 22);
			}

			String totalCust = text.trim();
			hardWait(3);
			// totalCustomersText.substring(4);
			if (totalCust.equalsIgnoreCase(yetToStart) && yoursToggleBtn.isSelected()) {
				actionableCountDisplayed = true;
			}
		} else {
			logger.info("The Yours count was zero");
			actionableCountDisplayed = true;
		}

		logger.info("Ending of yoursCountDisplayed Method");
		return actionableCountDisplayed;

	}

	public boolean teamActionableCountDisplayed() {
		logger.info("Starting of teamActionableCountDisplayed Method");

		Boolean teamActionableCountDisplayed = false;
		waitUntilElementVisible(driver, teamActionableCount);
		hardWait(3);
		String yetToStart = teamActionableCount.getText();

		number = Integer.valueOf(yetToStart);

		if (number > 0) {

			clickOnWebElement(teamActionableCount);
			/////////////////
			hardWait(3);
			String worksCountText = totalWorks_txt.getText();
			// int length = worksCountText.length();
			String text;

			if (number < 10) {
				text = worksCountText.substring(18, 20);
			} else if (number > 9) {
				text = worksCountText.substring(18, 21);
			} else {
				text = worksCountText.substring(18, 22);
			}

			String totalCust = text.trim();
			hardWait(3);
			// totalCustomersText.substring(4);
			if (totalCust.equalsIgnoreCase(yetToStart) && teamsToggleBtn.isSelected()) {
				teamActionableCountDisplayed = true;
			}
		} else {
			logger.info("The teams count was zero");
			teamActionableCountDisplayed = true;
		}
		logger.info("Ending of teamActionableCountDisplayed Method");
		return teamActionableCountDisplayed;

	}

	public boolean updatedTodayCountDisplayed() {
		logger.info("Starting of updatedTodayCountDisplayed Method");

		Boolean updatedTodayCountDisplayed = false;
		waitUntilElementVisible(driver, updatedTodayCount);
		hardWait(3);
		String yetToStart = updatedTodayCount.getText();

		number = Integer.valueOf(yetToStart);

		if (number > 0) {

			clickOnWebElement(updatedTodayCount);
			/////////////////
			hardWait(3);
			String worksCountText = totalWorks_txt.getText();
			// int length = worksCountText.length();
			String text;

			if (number < 10) {
				text = worksCountText.substring(18, 20);
			} else if (number > 9) {
				text = worksCountText.substring(18, 21);
			} else {
				text = worksCountText.substring(18, 22);
			}

			String totalCust = text.trim();
			hardWait(3);
			// totalCustomersText.substring(4);
			if (totalCust.equalsIgnoreCase(yetToStart)) {
				updatedTodayCountDisplayed = true;
			}
		} else {
			logger.info("The Updated Today count was zero");
			updatedTodayCountDisplayed = true;
		}
		logger.info("Ending of updatedTodayCountDisplayed Method");
		return updatedTodayCountDisplayed;

	}

	public int matrixCount() {
		return this.number;
	}

	public void logOut() {
		logger.info("Starting of Logout method");

		hardWait(3);
		waitUntilElementVisible(driver, userNameBtn);
		userNameBtn.click();
		if (logoutBtn.get(logoutBtn.size() - 1).getText().equalsIgnoreCase("Logout")) {
			logoutBtn.get(logoutBtn.size() - 1).click();
		}

		logger.info("Ending of Logout method");
	}

}