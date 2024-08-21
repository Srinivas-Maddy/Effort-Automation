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

	@FindBy(xpath = "//input[@id='s2id_autogen1437_search']")
	private WebElement enterName;

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

	@FindBy(xpath = "//span[@id='select2-chosen-7']")
	private WebElement selectEmployee;

	@FindBy(xpath = "//input[@id='s2id_autogen7_search']")
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

	public void clickOnSave() {
		logger.info("Starting of clickOnSave method");

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
				if (this.acceptBtn.isDisplayed()) {
					this.acceptBtn.click();
				}
			} catch (Exception e2) {
				logger.info("On Leave Alert was not displayed");
			}
		

		hardWait(2);

		logger.info("Ending of clickOnSave method");
	}
	
	public void clickOnSaveWhileNewAdd() {
		logger.info("Starting of clickOnSaveWhileNewAdd method");

		for(int i =0; i<1;i++) {
			
			waitUntilElementVisible(driver, this.saveBtn);
			this.saveBtn.click();
			// Process Conflict Alert Handling
			try {
				if(sucessfullyText.isDisplayed()) {
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
				if(sucessfullyText.isDisplayed()) {
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
		hardWait(3);

		waitUntilElementVisible(driver, this.deleteSelected);
		clickOnWebElementUsingJavascript(deleteSelected);

		hardWait(3);

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

		waitUntilElementVisible(driver, this.workAssignBtn);
		clickOnWebElementUsingJavascript(workAssignBtn);

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

	public void getWorkId() {
		logger.info("Starting of getWorkId method");

		hardWait(3);

		waitUntilElementVisible(driver, this.workId);
		workID = workId.getText();

		logger.info("Ending of getWorkId menthod");
	}

	public boolean isWorkdDeletedSucessfully() {
		logger.info("Starting of isWorkdDeletedSucessfully method");

		hardWait(5);
		boolean isWorkdDeletedSucessfully = false;
		scrollIntoView(workFilterBtn);

		try {

			if (workId.isDisplayed()) {

				isWorkdDeletedSucessfully = false;
			}
		} catch (Exception e) {

			isWorkdDeletedSucessfully = true;
		}

		logger.info("Ending of isWorkdDeletedSucessfully method");

		return isWorkdDeletedSucessfully;
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
