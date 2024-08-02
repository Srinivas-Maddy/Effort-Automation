package com.effort.list;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class ListPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(ListPage.class.getName());

	@FindBy(xpath = "//a[contains(text(),'App Builder')]")
	private WebElement appBuilderCard;

	@FindBy(id = "listMenu")
	private WebElement listMenu;

	@FindBy(xpath = "//input[@value='Create List']")
	private WebElement createListSpecBtn;

	@FindBy(id = "entityTitle")
	private WebElement listTitleField;

	@FindBy(xpath = "//input[contains(@value,'Add Field')]")
	private WebElement addListFieldsBtn;

	@FindBy(id = "entityFieldIdentifier1")
	private WebElement listIdentiferCheckBox;

	@FindBy(id = "entityFieldSpecs1_fieldLabel")
	private WebElement fieldLabelNameInput;

	@FindBy(xpath = "//ul[contains(@id,'select2-results')]/li/div")
	private List<WebElement> listFields;

	@FindBy(xpath = "//div[contains(@id, 's2id_entityFieldSpecs')]")
	private WebElement datatypeDropdown;

	@FindBy(id = "publishButton")
	private WebElement publishBtn;

	@FindBy(id = "syncScope_SyncAll1")
	private WebElement syncAllRadioBtn;

	@FindBy(id = "saveBtn")
	private WebElement saveBtn;

	@FindBy(id = "skipButton")
	private WebElement warningAcceptBtn;

	@FindBy(xpath = "//a[contains(text(),'Add')]")
	private WebElement addListCard;

	@FindBy(id = "externalId")
	private WebElement listNo;

	@FindBy(xpath = "//div[@id='entityFieldsTotal']/div/div/div[1]/span")
	private List<WebElement> addListFields;

	@FindBy(xpath = "(//div[@class='xdsoft_calendar'])[1]/table/tbody/tr/td[contains(@class,'xdsoft_current xdsoft_today')]")
	private WebElement currentDateInCalender;

	@FindBy(xpath = "//ul[@id='select2-results-45']/li[2]")
	private WebElement yesOrNo_DrpDwn;

	@FindBy(xpath = "//ul[@id='select2-results-46']/li[2]")
	private WebElement dropDownValue;

	@FindBy(xpath = "//ul[@id='select2-results-47']/li[2]")
	private WebElement customerValue;

	@FindBy(xpath = "//div[@class='xdsoft_timepicker active']/div/div/div[@class='xdsoft_time xdsoft_current']")
	private WebElement timeSlot;

	@FindBy(xpath = "//ul[@id='select2-results-48']/li[2]")
	private WebElement listItem;

	@FindBy(xpath = "//ul[@id='select2-results-49']/li[3]")
	private WebElement empData;

	@FindBy(xpath = "//table[contains(@class,'pq-grid-table')]/tbody/tr/td[2]/div/img")
	private List<WebElement> multiCustomerPicker;

	@FindBy(xpath = "//div[@class='col-md-12 pd-0']/ul[1]")
	private WebElement pickerOkBtn;

	@FindBy(xpath = "//ul[@id='select2-results-50']/li[2]")
	private WebElement territoryData;

	@FindBy(xpath = "(//table[contains(@class,'pq-grid-table')]/tbody/tr/td[2])[2]")
	private WebElement selectEntity;

	@FindBy(xpath = "//input[contains(@class,'btn btn-success btn-block')]")
	private WebElement okBtn;

	@FindBy(xpath = "//ul[@id='select2-results-51']/li[2]")
	private WebElement selectGroupValue;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[2]/a")
	private WebElement editOption;

	@FindBy(id = "fields0_fieldValue")
	private WebElement listTextField;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[1]/input")
	private WebElement checkBox;

	@FindBy(id = "deleteLists")
	private WebElement deleteBtn;

	@FindBy(id = "searchButtonForForms")
	private WebElement searchBtn;

	@FindBy(id = "search")
	private WebElement searchBtnOnPopUp;

	@FindBy(xpath = "//a[contains(text(),'Withdraw')]")
	private WebElement withDrawCard;

	@FindBy(id = "searchText")
	private WebElement searchBox;

	@FindBy(id = "save1")
	private WebElement addListSaveBtn;

	public String listSpecName = null;

	public ListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnAppBuilder() {
		logger.info("Starting of clickOnWebBuilder Method");

		waitUntilElementVisible(driver, this.appBuilderCard);
		clickOnWebElement(this.appBuilderCard);

		logger.info("Ending of clickOnWebBuilder Method");
	}

	public void clickOnListMenu() {
		logger.info("Starting of clickOnListMenu Method");

		waitUntilElementVisible(driver, this.listMenu);
		clickOnWebElement(this.listMenu);

		logger.info("Ending of clickONListMenu Method");
	}

	public void clickOnCreateListSpec() {
		logger.info("Starting of clickOnListSpec Method");

		waitUntilElementVisible(driver, this.createListSpecBtn);
		clickOnWebElement(this.createListSpecBtn);

		logger.info("Ending of clickOnListSpec Method");
	}

	public void enterTitleName(String specTitle) {
		logger.info("Starting of enterTitleName Method");

		switchWindow();
		waitUntilElementVisible(driver, this.listTitleField);
		listSpecName = specTitle + "_" + getCurrentDateTime();
		this.listTitleField.sendKeys(listSpecName);

		logger.info("Ending of enterTitleName Method");
	}

	public void selectListFields() {
		logger.info("Starting of selectListFields Method");

		waitUntilElementVisible(driver, this.addListFieldsBtn);
		clickOnWebElement(this.addListFieldsBtn);
		waitUntilElementVisible(driver, this.datatypeDropdown);
		clickOnWebElement(this.datatypeDropdown);
		int counter = 1;
		for (int i = 0; i < listFields.size(); i++) {
			String fieldDatatype = this.listFields.get(i).getText();
			hardWait(2);
			clickOnWebElement(listFields.get(i));
			hardWait(1);
			if (counter < 3)
				driver.findElement(
						By.xpath("//table[@id='formFields']/tbody/tr[" + counter + "]/td[2]/input[@type='checkbox']"))
						.click();
			driver.findElement(By.id("entityFieldSpecs" + counter + "_fieldLabel")).sendKeys(fieldDatatype + "_Auto");
			if (fieldDatatype.contains("Single-select List"))
				driver.findElement(By.xpath("//textarea[@id='entityFieldSpecs" + counter + "_fieldType_value']"))
						.sendKeys("123");
			if (fieldDatatype.contains("Employee Group"))
				break;
			waitUntilElementVisible(driver, this.addListFieldsBtn);
			scrollIntoView(this.addListFieldsBtn);
			clickOnWebElement(this.addListFieldsBtn);
			counter++;
			driver.findElement(By.xpath("//table[@id='formFields']/tbody/tr[" + counter + "]/td[4]")).click();
		}

		logger.info("Ending of selectListFields Method");
	}

	public void clickOnPublish() {
		logger.info("Starting of clickOnPublish Method");

		waitUntilElementVisible(driver, this.publishBtn);
		scrollIntoView(this.publishBtn);
		clickOnWebElement(this.publishBtn);
		driver.switchTo().alert().accept();
		waitUntilElementVisible(driver, this.syncAllRadioBtn);
		clickOnWebElement(this.syncAllRadioBtn);
		waitUntilElementVisible(driver, this.saveBtn);
		clickOnWebElement(this.saveBtn);
		waitUntilElementVisible(driver, this.warningAcceptBtn);
		clickOnWebElement(this.warningAcceptBtn);

		logger.info("Starting of clickOnPublish Method");
	}

	public void clickOnAddListCard() {
		logger.info("Starting of clickOnAddListCard Method");

		waitUntilElementVisible(driver, this.addListCard);
		clickOnWebElement(this.addListCard);

		logger.info("Ending of clickOnAddListCard Method");
	}

	public void enterListNumber(String listNo) {
		logger.info("Starting of enterListNumber Method");

		waitUntilElementVisible(driver, this.listNo);
		this.listNo.sendKeys(listNo);

		logger.info("Ending of enterListNumber Method");
	}

	public void enterTextFieldValue(String textData) {

		logger.info("Starting of enterListItemData Method");

		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(2);
			if (label.equalsIgnoreCase("Text")) {
				WebElement textFieldInput = driver.findElement(By.xpath("//input[@id='fields" + i + "_fieldValue']"));
				waitUntilElementVisible(driver, textFieldInput);
				textFieldInput.sendKeys(textData);
				break;
			}

		}

		logger.info("Ending of enterListItemData Method");

	}

	public void enterNumberValue(String numberData) {

		logger.info("Starting of enterNumberValue Method");

		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(2);
			if (label.equalsIgnoreCase("Number")) {
				WebElement numberFieldInput = driver.findElement(By.xpath("//input[@id='fields" + i + "_fieldValue']"));
				waitUntilElementVisible(driver, numberFieldInput);
				numberFieldInput.sendKeys(numberData);
				break;
			}

		}

		logger.info("Ending of enterNumberValue Method");

	}

	public void pickCurrentDate() {
		logger.info("Starting of pickCurrentDate method");

		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(2);
			WebElement fieldObj = driver.findElement(By.xpath("//input[@id='fields" + i + "_fieldValue']"));
			waitUntilElementVisible(driver, fieldObj);
			if (label.equalsIgnoreCase("Date")) {
				fieldObj.click();
				hardWait(2);
				waitUntilElementVisible(driver, this.currentDateInCalender);
				this.currentDateInCalender.click();
				break;
			}
		}

		logger.info("Ending of pickCurrentDate method");
	}

	public void pickYesOrNo() {
		logger.info("Starting of pickYesOrNo Method");
		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("YesNo")) {
				WebElement picker = driver.findElement(By.xpath("//div[@id='s2id_fields" + i + "_fieldValue']"));
				scrollIntoView(picker);
				picker.click();
				waitUntilElementVisible(driver, this.yesOrNo_DrpDwn);
				this.yesOrNo_DrpDwn.click();
				break;
			}
		}
		logger.info("Ending of pickYesOrNo Method");
	}

	public void selectDropdown() {
		logger.info("Starting of selectDropdown Method");

		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("Single-select List")) {
				WebElement picker = driver.findElement(By.xpath("//div[@id='s2id_fields" + i + "_fieldValue']"));
				scrollIntoView(picker);
				picker.click();
				waitUntilElementVisible(driver, this.dropDownValue);
				this.dropDownValue.click();
				break;
			}
		}

		logger.info("Ending of selectDropdown Method");
	}

	public void selectCustomer() {
		logger.info("Starting of selectCustomer Method");

		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("Customer")) {
				WebElement picker = driver.findElement(By.xpath("//div[@id='s2id_fields" + i + "_fieldValue']"));
				scrollIntoView(picker);
				picker.click();
				waitUntilElementVisible(driver, this.customerValue);
				this.customerValue.click();
				break;
			}
		}

		logger.info("Ending of selectCustomer Method");
	}

	public void enterEmail(String email) {
		logger.info("Starting of enterEmail Method");
		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("Email")) {
				WebElement emailField = driver.findElement(By.xpath("//input[@id='fields" + i + "_fieldValue']"));
				emailField.sendKeys(email);
				break;
			}
		}
		logger.info("Ending of enterEmail Method");
	}

	public void enterPhone(String phoneNumber) {
		logger.info("Starting of enterPhone Method");
		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("Phone")) {
				WebElement emailField = driver.findElement(By.xpath("//input[@id='fields" + i + "_fieldValue']"));
				emailField.sendKeys(phoneNumber);
				break;
			}
		}
		logger.info("Starting of enterPhone Method");
	}

	public void enterURL(String url) {
		logger.info("Starting of enterURL Method");
		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("URL")) {
				WebElement emailField = driver.findElement(By.xpath("//input[@id='fields" + i + "_fieldValue']"));
				emailField.sendKeys(url);
				break;
			}
		}
		logger.info("Ending of enterURL Method");
	}

	public void selectTime() {
		logger.info("Starting of selectTime Methond");

		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("Time")) {
				WebElement timePicker = driver.findElement(By.xpath("//input[@id='fields" + i + "_fieldValue']"));
				clickOnWebElement(timePicker);
				hardWait(10);
				waitUntilElementVisible(driver, this.timeSlot);
				clickOnWebElement(this.timeSlot);
				break;
			}
		}

		logger.info("Ending of selectTime Methond");
	}

	public void selecPicklist() {
		logger.info("Starting of selectTime Methond");

		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("List")) {
				WebElement listPicker = driver.findElement(By.xpath("//div[@id='s2id_fields" + i + "_fieldValue']"));
				clickOnWebElement(listPicker);
				hardWait(1);
				waitUntilElementVisible(driver, this.listItem);
				clickOnWebElement(this.listItem);
				break;
			}
		}

		logger.info("Ending of selectTime Methond");
	}

	public void selecEmployee() {
		logger.info("Starting of selecEmployee Methond");

		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("Employee")) {
				WebElement empPicker = driver.findElement(By.xpath("//div[@id='s2id_fields" + i + "_fieldValue']"));
				clickOnWebElement(empPicker);
				hardWait(1);
				waitUntilElementVisible(driver, this.empData);
				clickOnWebElement(this.empData);
				break;
			}
		}

		logger.info("Ending of selecEmployee Methond");
	}

	public void selecMultiPickCustomers() {
		logger.info("Starting of selecMultiPickCustomers Methond");

		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("Multi Pick Customer")) {
				WebElement Picker = driver.findElement(By.xpath("//button[@class='fields" + i + "_fieldValue']"));
				clickOnWebElement(Picker);
				hardWait(2);
				for (int j = 0; j < multiCustomerPicker.size(); j++) {
					hardWait(2);
					waitUntilElementVisible(driver, this.multiCustomerPicker.get(j));
					clickOnWebElement(this.multiCustomerPicker.get(j));
					if (j > 1) {
						waitUntilElementVisible(driver, pickerOkBtn);
						clickOnWebElement(pickerOkBtn);
						break;
					}
				}
				break;
			}
		}

		logger.info("Ending of selecEmployee Methond");
	}

	public void selectTerritory() {
		logger.info("Starting of selectTerritory Methond");

		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("Territory")) {
				WebElement territoryPicker = driver
						.findElement(By.xpath("//div[@id='s2id_fields" + i + "_fieldValue']"));
				clickOnWebElement(territoryPicker);
				hardWait(1);
				waitUntilElementVisible(driver, this.territoryData);
				clickOnWebElement(this.territoryData);
				break;
			}
		}

		logger.info("Ending of selectTerritory Methond");
	}

	public void selectEntity() {
		logger.info("Starting of selectEntity Methond");

		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("Custom Entity")) {
				WebElement entityPicker = driver.findElement(By.xpath("//select[@id='fields" + i + "_fieldValue']"));
				scrollIntoView(entityPicker);
				clickOnWebElement(entityPicker);
				hardWait(5);

				clickOnWebElement(searchBtn);
				clickOnWebElement(searchBtnOnPopUp);
				waitUntilElementVisible(driver, this.selectEntity);
				clickOnWebElement(this.selectEntity);
				waitUntilElementVisible(driver, this.okBtn);
				clickOnWebElement(this.okBtn);
				break;

			}
		}

		logger.info("Ending of selectEntity Methond");
	}

	public void selectEmployeeGroup() {
		logger.info("Starting of selectEmployeeGroup Methond");

		for (int i = 0; i < this.addListFields.size(); i++) {

			String listFieldName = this.addListFields.get(i).getText();
			String[] labelName = listFieldName.split("_");
			String label = labelName[0];
			hardWait(1);
			if (label.equalsIgnoreCase("Employee Group")) {
				WebElement groupPicker = driver.findElement(By.xpath("//div[@id='s2id_fields" + i + "_fieldValue']"));
				clickOnWebElement(groupPicker);
				hardWait(1);
				waitUntilElementVisible(driver, this.selectGroupValue);
				clickOnWebElement(this.selectGroupValue);
				break;
			}
		}

		logger.info("Ending of selectEmployeeGroup Methond");
	}

	public void clickOnEdit() {
		logger.info("Starting of clickOnEdit method");

		hardWait(10);
		waitUntilElementVisible(driver, this.editOption);
		clickOnWebElement(this.editOption);

		logger.info("Ending of clickOnEdit Method");
	}

	public void enterModifiedData(String modifiedData) {
		logger.info("Starting of enterModifiedData Method");

		hardWait(2);
		waitUntilElementVisible(driver, this.listTextField);
		this.listTextField.sendKeys(modifiedData);

		logger.info("Ending of enterModifiedData Method");
	}

	public void selectEntityCheckbox() {
		logger.info("Starting of selectEntityCheckbox Method");

		hardWait(2);
		waitUntilElementVisible(driver, this.checkBox);
		clickOnWebElement(this.checkBox);

		logger.info("Ending of selectEntityCheckbox Method");
	}

	public void clickOnDelete() {
		logger.info("Starting of clickOnDelete Method");

		waitUntilElementVisible(driver, this.deleteBtn);
		clickOnWebElement(this.deleteBtn);
		driver.switchTo().alert().accept();

		logger.info("Ending of clickOnDelete Method");
	}

	public void searchListSpec() {
		logger.info("Starting of searchListSpec Method");

		waitUntilElementVisible(driver, searchBox);
		this.searchBox.sendKeys(listSpecName);
		WebElement listSpec = driver.findElement(By.xpath("//a[contains(text(),'" + listSpecName + "')]"));
		waitUntilElementVisible(driver, listSpec);
		clickOnWebElement(listSpec);

		logger.info("Ending of searchListSpec Method");
	}

	public void clickOnWithDrawCard() {
		logger.info("Starting of clickOnWithDrawCard method");

		hardWait(5);
		waitUntilElementVisible(driver, this.withDrawCard);
		clickOnWebElement(this.withDrawCard);
		hardWait(5);
		Alert confirmation = driver.switchTo().alert();
		confirmation.accept();

		logger.info("Ending of clickOnWithDrawCard method");

	}

	public void clickOnSaveBtn() {
		logger.info("Starting of clickOnSaveBtn Method");

		waitUntilElementVisible(driver, this.addListSaveBtn);
		scrollIntoView(this.addListSaveBtn);
		this.addListSaveBtn.click();

		logger.info("Starting of clickOnSaveBtn Method");
	}

}
