package com.effort.employees;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class EmployeeCreation extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(EmployeeCreation.class.getName());
	String parentWind = driver.getWindowHandle();
	String employeeFirstName = null;
	private String employeeId = null;
	private String disableLabel = "CLICK TO DISABLE";

	@FindBy(xpath = "//a[contains(text(),'Web App')]")
	private WebElement webApp;

	@FindBy(xpath = "//a[contains(text(),' Employees ')]")
	private WebElement employeeModule;

	@FindBy(xpath = "//a[@title='Add Employee']")
	private WebElement addEmpBtn;

	@FindBy(xpath = "//input[@id='empFirstName']")
	private WebElement firstName;

	@FindBy(id = "empLastName")
	private WebElement empLastName;

	@FindBy(xpath = "//input[@name='empNo']")
	private WebElement empId;

	@FindBy(id = "manager")
	private WebElement managerCheckBox;

	@FindBy(id = "generateQrCode")
	private WebElement qrCode;

	@FindBy(id = "empEmail")
	private WebElement empEmail;

	@FindBy(xpath = "//input[@name='empPhone']")
	private WebElement empPhone;

	@FindBy(xpath = "//div[@class='empAdavDetailsContainer bg-label']")
	private WebElement advanceDetails;

	@FindBy(id="s2id_managerEmail")
	private WebElement reportingManagerField;

	@FindBy(xpath="//div[@id='select2-drop']/div/input")
	private WebElement managerInputSearch;

	@FindBy(xpath="//div[@id='select2-drop']/div//following-sibling::ul/li[1]")
	private WebElement selectManagerName;

	@FindBy(xpath = "//div[@id='empAdavFieldsContainer']/div/div/ul/li/label[1]")
	private List<WebElement> empAdvanceList;

	@FindBy(xpath = "//div[@id='s2id_managerEmail']/a")
	private WebElement reportManagerdropdown;

	@FindBy(xpath = "//ul[@id='select2-results-3']/li/div")
	private List<WebElement> managerNames;

	@FindBy(xpath = "//input[@id='s2id_autogen3_search']")
	private WebElement managerNameInput;

	@FindBy(xpath = "//input[@id='employeeImage']")
	private WebElement chooseEmpImage;

	@FindBy(id = "designation")
	private WebElement designation;

	@FindBy(id="s2id_field_5")
	private WebElement roleField;

	@FindBy(xpath = "//span[@id='select2-chosen-5']")
	private WebElement roleDropDown;

	@FindBy(xpath = "//div[@id='select2-drop']/div//following-sibling::ul/li/div")
	private List<WebElement> empRoles;

	@FindBy(xpath = "//div[@id='s2id_empMappedGroups']")
	private WebElement empGrpDropDown;

	@FindBy(xpath = "//div[@id='select2-drop']//ul/li/div")
	private List<WebElement> empGrps;

	@FindBy(id = "s2id_mce")
	private WebElement autoMapDrpdown;

	@FindBy(xpath = "//div[@id='select2-drop']/ul/li")
	private List<WebElement> mapDropdown;

	@FindBy(id = "s2id_territoryIds")
	private WebElement territoryDropdown;

	@FindBy(xpath = "//div[@id='select2-drop']/ul/li/div")
	private List<WebElement> territoryOptions;

	@FindBy(xpath = "//input[@id='save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//div[@id='snackbarVal']")
	private WebElement EmpsavedMsg;

	@FindBy(id = "filters")
	private WebElement filterBtn;

	@FindBy(id = "empNamefilt")
	private WebElement EmployeefirstName;

	@FindBy(id = "search")
	private WebElement applyBtn;

	@FindBy(id="reset")
	private WebElement resetBtn;

	@FindBy(xpath = "//table/tbody/tr/td[2]/div/span/i")
	private List<WebElement> editButtons;

	@FindBy(id = "empNofilt")
	private WebElement empIdFilterScreen;

	@FindBy(xpath = "//button[@id='dropdownMenu1']")
	private WebElement actionMenu;

	@FindBy(xpath = "//ul[@aria-labelledby='dropdownMenu1']/li/a")
	private List<WebElement> actionDropDowns;

	@FindBy(id = "save1")
	private WebElement modifySaveBtn;

	@FindBy(id = "disableEmployee")
	private WebElement applyDisableEmp;

	@FindBy(xpath="//div[contains(@class,'empUserDefinedFieldsContainer')]/span")
	private WebElement userDefindFieldSection;

	@FindBy(id="fields0_fieldValue")
	private WebElement userDefinedTextInput;
	
	@FindBy(xpath="//input[contains(@id,'fieldValue')]")
	private List<WebElement> userDefinedInputFields;
	
	@FindBy(xpath="//span[contains(@id,'fieldValue_fieldLabel')]/label")
	private List<WebElement> userDefinedFieldLabels;

	@FindBy(xpath = "//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath = "//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;


	@FindBy(xpath="(//table[@id='example']/tbody/tr/td[2]/div/span[2]/button)[1]")
	private WebElement actionsThreeDot;

	@FindBy(xpath="(//span[@class='dropdown open']/ul/li/a)[1]")
	private WebElement customerMappingOption;

	@FindBy(xpath="//ul[@class='list-inline pull-left']/li/input[@value='Map More Customers']")
	private WebElement mapMoreCustomerBtn;

	@FindBy(xpath="//table[contains(@class,'pq-grid-table')]/tbody/tr/td[2]/div/img")
	private List<WebElement> customerPickerCheckbox;

	@FindBy(xpath="//input[@id='customerGridSubmit']")
	private WebElement customerPickerOKBtn;

	@FindBy(xpath="//input[@id='saveBtn']")
	private WebElement customerMappingSaveBtn;

	@FindBy(xpath="(//span[@class='dropdown open']/ul/li/a)[2]")
	private WebElement listMappingOption;

	@FindBy(xpath="//td[contains(text(),'Test List')]//following-sibling::td/a")
	private WebElement listSpecIcon;
	
	@FindBy(xpath="//iframe[@id='pop-iframe']")
	private WebElement listSpecFrame;
	
	@FindBy(xpath="//span[@class='ui-icon ui-icon-closethick']")
	private WebElement closePopup;

	@FindBy(xpath="//input[@id='entityDialogButton']")
	private WebElement mapMoreOption;

	@FindBy(xpath="//table[contains(@class,'pq-grid-table')]/tbody/tr/td[2]/div/img")
	private List<WebElement> listItemsCheckBoxes;

	@FindBy(xpath="//input[@value='OK']")
	private WebElement listItemPickerOkBtn;
	
	@FindBy(xpath="//input[@value='Save']")
	private WebElement listMappingSaveBtn;
	
	@FindBy(xpath="(//span[@class='dropdown open']/ul/li/a)[3]")
	private WebElement sendPasswordOption;
	
	@FindBy(id="empNamefilt")
	private WebElement empNameInputInFilter;
	
	@FindBy(id="snackbarVal")
	private WebElement passwordSentStatus;
	
	@FindBy(id="search")
	private WebElement applyBtnInFiter;
	
	@FindBy(xpath="//div[contains(@style,'position: absolute;')]//table/tbody/tr/td[contains(@class,'xdsoft_current ')]")
	private WebElement currentDatePicker;
	
	@FindBy(xpath="(//span[@class='dropdown open']/ul/li/a)[4]")
	private WebElement activationCodeOption;
	
	@FindBy(xpath="(//span[@class='dropdown open']/ul/li/a)[6]")
	private WebElement createdWebAccountOption;
	
	@FindBy(xpath="(//span[@class='dropdown open']/ul/li/a)[8]")
	private WebElement territoryMapOption;
	
	@FindBy(xpath="//select[@class='unselected']/option[contains(text(),'HYD')]")
	private WebElement territryValues;
	
	@FindBy(xpath="(//span[@class='glyphicon glyphicon-chevron-right'])[2]")
	private WebElement moveRightOption;
	
	@FindBy(xpath="//input[@value='Save']")
	private WebElement saveBtnInMapping;
	
	@FindBy(xpath="(//span[@class='dropdown open']/ul/li/a)[9]")
	private WebElement routePlanMapOption;
	
	@FindBy(xpath="//select[@class='unselected']/option[contains(text(),'April 27th route plan')]")
	private WebElement routePlan;
	
	@FindBy(xpath="(//span[@class='dropdown open']/ul/li/a)[10]")
	private WebElement typeMappingOption;
	
	@FindBy(xpath="//select[@class='unselected']/option[contains(text(),'Dellars')]")
	private WebElement typeVaule;
	
	@FindBy(id="totalCount")
	private WebElement totalEmpBtn;
	
	@FindBy(xpath="//div[@id='example_info']")
	private WebElement pageCount;
	
	@FindBy(id="requistionStatusCount")
	private WebElement approvalCount;
	
	public String totalEmpCount=null;
	public String approvalCountValue=null;

	public EmployeeCreation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnWebApp() {
		logger.info("Starting of Click on web App method");

		hardWait(3);
		waitUntilElementVisible(driver, webApp);
		this.webApp.click();

		logger.info("Ending of Click on web App method");
	}

	public void clickOnEmployees() {
		logger.info("Starting of clickOnEmployees method");
		waitUntilElementVisible(driver, employeeModule);
		employeeModule.click();
		logger.info("Ending of clickOnEmployees method");
	}

	public void clickOnAddEmpBtn() {
		logger.info("Starting of clickOnAddEmpBtn method");

		waitUntilElementVisible(driver, addEmpBtn);
		addEmpBtn.click();
		logger.info("Ending of clickOnAddEmpBtn method");
	}

	public void switchNewWindow() {
		logger.info("Starting of switchNewWindow method");

		Set<String> newWindows = driver.getWindowHandles();
		Iterator<String> I1 = newWindows.iterator();

		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parentWind.equals(child_window)) {
				driver.switchTo().window(child_window);
			}
		}
	}

	public void enterFirstName(String enterFirstName) {
		logger.info("Starting of enterFirstName method");

		waitUntilElementVisible(driver, firstName);
		this.employeeFirstName = enterFirstName + "_" + getCurrentDate();
		firstName.sendKeys(this.employeeFirstName);

		logger.info("Ending of enterFirstName method");
	}

	public void enterLastName(String enterLastName) {
		logger.info("Starting of enterLastName method");

		waitUntilElementVisible(driver, empLastName);
		empLastName.sendKeys(enterLastName);

		logger.info("ending of enterLastName method");
	}

	public void EmpId() {
		logger.info("Starting of enterEmpId method");

		employeeId = getUniqueNumber("Auto_EMP");
		waitUntilElementVisible(driver, empId);
		empId.sendKeys(this.employeeId);

		logger.info("ending of enterEmpId method");
	}

	public void managerCheckBox() {
		logger.info("Starting of managerCheckBox method");

		waitUntilElementVisible(driver, managerCheckBox);
		clickOnWebElement(managerCheckBox);

		logger.info("ending of managerCheckBox method");
	}

	public void qrCodeCheckBox() {
		logger.info("Starting of qrCodeCheckBox method");

		waitUntilElementVisible(driver, qrCode);
		qrCode.click();

		logger.info("ending of qrCodeCheckBox method");
	}

	public void EmpEmail() {
		logger.info("Starting of enterEmpEmail method");

		String randomEmail = randomEmailGenerator();
		waitUntilElementVisible(driver, empEmail);
		empEmail.sendKeys(randomEmail);

		logger.info("ending of enterEmpEmail method");
	}

	public void EmpPhone() {
		logger.info("Starting of enterEmpPhone method");

		String randomPhone = randomMobileNumbers();
		waitUntilElementVisible(driver, empPhone);
		empPhone.sendKeys(randomPhone);

		logger.info("ending of enterEmpPhone method");
	}

	public void clickOnAdvanceDetails() {
		logger.info("Starting of click on Advance details method");

		waitUntilElementVisible(driver, this.advanceDetails);
		scrollDown(0, advanceDetails);
		clickOnWebElement(this.advanceDetails);

		logger.info("Ending of click on Advance details method");
	}


	public void selectManagerName(String name) {
		logger.info("Starting of selectManagerName Method");

		waitUntilElementVisible(driver, this.reportingManagerField);
		this.reportingManagerField.click();
		waitUntilElementVisible(driver, this.managerInputSearch);
		this.managerInputSearch.sendKeys(name);
		waitUntilElementVisible(driver, this.selectManagerName);
		this.selectManagerName.click();

		logger.info("Ending of selectManagerName Method");
	}

	public void uploadEmpPhoto() {
		logger.info("Starting of uploadEmpPhoto Method");

		waitUntilElementVisible(driver, this.chooseEmpImage);
		String pathFile = System.getProperty("user.dir") + "/MediaFiles/IDCardPhoto.jpg";
		this.chooseEmpImage.sendKeys(pathFile);

		logger.info("Ending of uploadEmpPhoto Method");
	}

	public void enterEmpDesignation(String empDesignation) {
		logger.info("Starting of enterEmpDesignation Method");

		waitUntilElementVisible(driver, this.designation);
		this.designation.sendKeys(empDesignation);

		logger.info("Ennding of enterEmpDesignation Method");
	}

	public void selectEmpRole(String empRole) {
		logger.info("Starting of selectEmpRole Method");

		waitUntilElementVisible(driver, this.roleField);
		this.roleField.click();
		int count = 0;
		while (count < empRoles.size()) {
			if (empRoles.get(count).getText().equalsIgnoreCase(empRole)) {
				this.empRoles.get(count).click();
				break;
			}
			count++;
		}

		logger.info("Ending of selectEmpRole Method");
	}

	public void selectEmpGroup(String empGroup) {
		logger.info("Starting of selectEmpGroup Method");

		waitUntilElementVisible(driver, this.empGrpDropDown);
		this.empGrpDropDown.click();

		int grpCount = 0;
		while (grpCount < empGrps.size()) {
			if (empGrps.get(grpCount).getText().equalsIgnoreCase(empGroup)) {
				empGrps.get(grpCount).click();
				break;
			}
			grpCount++;
		}

		logger.info("Ending of selectEmpGroup Method");
	}

	public void selectAutoMapCustomerOption(String mapOption) {
		logger.info("Starting of automap Method");

		waitUntilElementVisible(driver, this.autoMapDrpdown);
		this.autoMapDrpdown.click();
		int mapOptions = 0;
		while (mapOptions < mapDropdown.size()) {
			if (mapDropdown.get(mapOptions).getText().equalsIgnoreCase(mapOption)) {
				mapDropdown.get(mapOptions).click();
				break;
			}
			mapOptions++;
		}

		logger.info("Ending of automap Method");
	}

	public void selecTerritory(String name) {
		logger.info("Starting of selecTerritory Method");

		scrollDown(500, this.territoryDropdown);
		waitUntilElementVisible(driver, this.territoryDropdown);
		this.territoryDropdown.click();
		int terrioryOptionsCount = 0;
		while (terrioryOptionsCount < territoryOptions.size()) {
			if (territoryOptions.get(terrioryOptionsCount).getText().equalsIgnoreCase(name)) {
				territoryOptions.get(terrioryOptionsCount).click();
				break;
			}
			terrioryOptionsCount++;
		}

		logger.info("Ending of selecTerritory Method");
	}

	public void clickOnSaveBtn() throws InterruptedException {
		logger.info("Starting of clickOnSaveBtn method");

		scrollDown(500, this.territoryDropdown);
		waitUntilElementVisible(driver, saveBtn);
		saveBtn.click();

		logger.info("ending of qrCodeCheckBox method");
	}

	public String saveAndValidateEmployeCreated(){
		logger.info("Starting of saveAndValidateEmployeCreated method");

		scrollDown(500, this.territoryDropdown);
		waitUntilElementVisible(driver, saveBtn);
		hardWait(2);
		saveBtn.click();

		try {
			waitUntilElementVisible(driver, EmpsavedMsg);
		} catch (Exception e) {
			waitUntilElementVisible(driver, EmpsavedMsg);
		}

		String actualEmpSavedMsg = this.EmpsavedMsg.getText();

		logger.info("ending of saveAndValidateEmployeCreated method");

		return actualEmpSavedMsg;
	}

	public String EmpSavedSuccsusfullyMsg() {
		logger.info("Starting of EmpSavedSuccsusfullyMsg Method");

		hardWait(2);
		try {
			waitUntilElementVisible(driver, EmpsavedMsg);
		} catch (Exception e) {
			waitUntilElementVisible(driver, EmpsavedMsg);
		}

		String actualEmpSavedMsg = this.EmpsavedMsg.getText();
		return actualEmpSavedMsg;
	}

	public void clickOnFilter() {
		logger.info("Starting of clickOnFilter method");
		scrollDown(100, this.filterBtn);
		waitUntilElementVisible(driver, this.filterBtn);
		this.filterBtn.click();
		logger.info("Ending of clickOnFilter method");
	}

	public void clickOnReset() {
		logger.info("Starting of clickOnReset Method");

		waitUntilElementVisible(driver, this.resetBtn);
		this.resetBtn.click();

		logger.info("Ending of clickOnReset Method");
	}

	public void filterEmployeeName() {
		logger.info("Starting of filterEmployeeName method");
		waitUntilElementVisible(driver, this.EmployeefirstName);
		this.EmployeefirstName.sendKeys(this.employeeFirstName);
		waitUntilElementVisible(driver, this.applyBtn);
		this.applyBtn.click();
		logger.info("Ending of filterEmployeeName method");

	}

	public void clickOnEditButton(){
		logger.info("Starting of clickOnEditButton method");
		hardWait(2);
		int i = 0;
		if (i < editButtons.size())
			this.editButtons.get(i).click();
		logger.info("Ending of clickOnEditButton method");
	}

	public void enterModifiedFirstName(String name) {
		logger.info("Starting of enterModifiedFirstName Method");

		waitUntilElementVisible(driver, this.firstName);
		this.firstName.clear();
		this.firstName.sendKeys(name+"_"+RandGeneratedString(4));

		logger.info("Ending of enterModifiedFirstName Method");	
	}


	public void enterModifiedLastName(String name) {
		logger.info("Starting of enterModifiedLastName Method");

		this.empLastName.clear();
		this.empLastName.sendKeys(name+"_"+RandGeneratedString(4));

		logger.info("Ending of enterModifiedLastName Method");
	}

	public void clickOnSave() {
		logger.info("Starting of ClickOnSave Method");

		waitUntilElementVisible(driver, this.modifySaveBtn);
		this.modifySaveBtn.click();

		logger.info("Ending of ClickOnSave Method");
	}
	
	
	public void filterEmpById() {
		logger.info("Starting of filterEmpById Method");
		
		hardWait(2);
		waitUntilElementVisible(driver, this.empIdFilterScreen);
		this.empIdFilterScreen.sendKeys(this.employeeId);
		waitUntilElementVisible(driver, this.applyBtn);
		this.applyBtn.click();
		hardWait(2);

		logger.info("Ending of filterEmpById Method");
	}

	public void disableEmployee() {
		logger.info("Starting of diable employee method");

		hardWait(2);
		waitUntilElementVisible(driver, this.actionMenu);
		this.actionMenu.click();
		for (int i = 0; i < actionDropDowns.size(); i++) {
			String ExpectedLabel = this.actionDropDowns.get(i).getText();
			if (this.disableLabel.equalsIgnoreCase(ExpectedLabel)) {
				this.actionDropDowns.get(i).click();
				break;
			}
		}
		waitUntilElementVisible(driver, this.applyDisableEmp);
		this.applyDisableEmp.click();
	}



	public void logOut() {
		logger.info("Starting of Logout method");
		waitUntilElementVisible(driver, userNameBtn);
		userNameBtn.click();
		if (logoutBtn.get(logoutBtn.size() - 1).getText().equalsIgnoreCase("Logout")) {
			logoutBtn.get(logoutBtn.size() - 1).click();
		}
		logger.info("Ending of Logout method");
	}


	public void clickOnUserDefinedSection() {
		logger.info("Starting of clickOnUserDefinedSection Method");

		waitUntilElementVisible(driver, this.userDefindFieldSection);
		this.userDefindFieldSection.click();

		logger.info("Ending of clickOnUserDefinedSection Method");
	}

	public void enterTextValue(String text) {
		logger.info("Starting of enterTextValue Method");

		waitUntilElementVisible(driver, this.userDefinedTextInput);
		this.userDefinedTextInput.sendKeys(text);

		logger.info("Ending of enterTextValue Method");
	}
	
	
	public void enterUserDefinedValue(String fieldLabel, String fieldValue) {
		logger.info("Starting of enterUserDefinedValue Method");
	
		
		for (int i = 0; i < userDefinedFieldLabels.size(); i++) {	
		    // Retrieve the field label
		    String userDefinedLabel = driver.findElement(By.xpath("//span[@id='fields"+i+ "_fieldValue_fieldLabel']/label")).getText();

		    // Check if input fields are provided and not empty
		    if (userDefinedInputFields != null && !userDefinedInputFields.isEmpty()) {
		        for (int j = 0; j < userDefinedInputFields.size(); j++) { // Fix increment variable
		            // Match the label
		            if (userDefinedLabel.equals(fieldLabel)) { 
		                // Wait until the input field is visible
		                waitUntilElementVisible(driver, userDefinedInputFields.get(j));
		                
		                //scroll to element visiblity
		                scrollIntoView(userDefinedInputFields.get(j));
		                // Locate the input field and set the value
		               driver.findElement(By.xpath("//input[@id='fields"+i+"_fieldValue']")).sendKeys(fieldValue);
		                
		                break; // Exit loop after match is found
		            }

		        }
		    }
		}
		
		logger.info("Ending of enterUserDefinedValue Method");
	}
	
	public void datePicker(String fieldLabel) {
		logger.info("Starting of userDefinedPicker Method");
		
		
		for (int i = 0; i < userDefinedFieldLabels.size(); i++) {	
		    // Retrieve the field label
		    String userDefinedLabel = driver.findElement(By.xpath("//span[@id='fields"+i+ "_fieldValue_fieldLabel']/label")).getText();

		    // Check if input fields are provided and not empty
		    if (userDefinedInputFields != null && !userDefinedInputFields.isEmpty()) {
		        for (int j = 0; j < userDefinedInputFields.size(); j++) { // Fix increment variable
		            // Match the label
		            if (userDefinedLabel.equals(fieldLabel)) { 
		                // Wait until the input field is visible
		                waitUntilElementVisible(driver, userDefinedInputFields.get(j));
		                
		                // Locate the pick field 
		               driver.findElement(By.xpath("//input[@id='fields"+i+"_fieldValue']")).click();
		               waitUntilElementVisible(driver, this.currentDatePicker);
		               clickOnWebElement(this.currentDatePicker);
		                break; // Exit loop after match is found
		            }

		        }
		    }
		}
		
		logger.info("Ending of userDefinedPicker Method");

	}

	public void clickOnThreeDots() {
		logger.info("Starting of clickOnthreedots method");

		try {
			if (actionsThreeDot.isDisplayed()) { // Check if the three dots option is displayed
				hardWait(5);
				scrollIntoView(actionsThreeDot); // Scroll the page until the element is visible
				waitUntilElementVisible(driver, actionsThreeDot); // Wait until the element is visible
				actionsThreeDot.click(); // Click on the three dots option
			} 
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e); // Log error, if Element is not visibled
			throw new RuntimeException("Searching Element is not visible in the page.", e); // Wrap in a single exception
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}

		logger.info("Ending of clickOnthreedots Method");
	}

	public void clickOnCustomerMappingOption() {
		logger.info("Starting of clickOnCustomerMappingOption Method ");

		try {
			if (customerMappingOption.isDisplayed()) {//Check if the customeMapping Option is displayed
				waitUntilElementVisible(driver, this.customerMappingOption);//Wait Until Element is visible
				this.customerMappingOption.click();//Click on the customer mapping option
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}


		logger.info("Ending of clickOnCustomerMappingOption Method ");
	}

	public void clickOnMapMoreOption() {
		logger.info("Starting of clickOnMapMoreOption Method");

		try {
			if (mapMoreCustomerBtn.isDisplayed()) {//Check if the mapMore Option is visible
				waitUntilElementVisible(driver, this.mapMoreCustomerBtn);//Wait Until element is visible
				this.mapMoreCustomerBtn.click(); //Click on Map More Option
			}	
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}

		logger.info("Ending of clickOnMapMoreOption Method");
	}

	public void selectCustomers() {
		logger.info("Starting of selectCustomers Method");


		if(customerPickerCheckbox!=null && !customerPickerCheckbox.isEmpty()) {// Fixed the condition to check for non-empty list
			int count=0;// Initialize count to 0
			for (int i = 0; i < customerPickerCheckbox.size(); i++) { 
				try {
					waitUntilElementVisible(driver, customerPickerCheckbox.get(i));// Wait until the element is visible
					this.customerPickerCheckbox.get(i).click();// Click the checkbox
					count++;
					if (count>=5){// Stop after interacting with 5 checkboxes
						break;
					}	
				}catch(Exception e) {
					logger.info("Error interacting with checkbox:"+e);// Log the error
				}

			}
		}else {
			logger.info("No checkboxes found to interact with.");
		}

		logger.info("Ending of selectCustomers Method");
	}

	public void clickOnOkay() {
		logger.info("Starting of clickOnOkay Method");

		try {
			if (customerPickerOKBtn.isDisplayed()) {//Check if the Ok button is visible
				waitUntilElementVisible(driver, this.customerPickerOKBtn);//Wait Until element is visible
				this.customerPickerOKBtn.click(); //Click on Ok Button in customer picker
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}

		logger.info("Ending of clickOnOkay Method");
	}

	public void clickOnMappingSave() {
		logger.info("Starting of clickOnMappingSave Method");

		try {
			if (customerMappingSaveBtn.isDisplayed()) { //Check if the save button is visible or not
				waitUntilElementVisible(driver, this.customerMappingSaveBtn); //Wait until element is visible
				this.customerMappingSaveBtn.click(); //Click on the Save Button
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}

		logger.info("Ending of clickOnMappingSave Method");
	}


	public void clickOnListMappingOption() {
		logger.info("Starting of clickOnListMappingOption Method");

		try {
			if (this.listMappingOption.isDisplayed()) {//Check if the ListMapping Option is visible or not
				waitUntilElementVisible(driver, this.listMappingOption); //Wait Until is Element is visible
				this.listMappingOption.click();
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}

		logger.info("Ending of clickOnListMappingOption Method");
	}

	public void clickOnListSpecIcon() {
		logger.info("Starting of clickOnListSpec Method");

		driver.switchTo().frame(listSpecFrame);

		try {
			if (this.listSpecIcon.isDisplayed()) { //Check if List spec icon is visible or not
				scrollIntoView(this.listSpecIcon);
				waitUntilElementVisible(driver, this.listSpecIcon);
				this.listSpecIcon.click();
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}

		logger.info("Ending of clickOnListSpec Method");
	}

	public void clickOnMapMoreOptionList() {
		logger.info("Starting of clickOnMapMoreOptionList Method");

		driver.switchTo().defaultContent();
		
		try {
			if (this.mapMoreOption.isDisplayed()) { //Check if the button is visible or not
				waitUntilElementVisible(driver, this.mapMoreOption); //Wait Until element is visible
				this.mapMoreOption.click(); //Click on the More map option
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}

		logger.info("Ending of clickOnMapMoreOptionList Method");
	}

	public void selectListItems() {
		logger.info("Starting of selectListItems Method");

		try {
			if (listItemsCheckBoxes!=null && !listItemsCheckBoxes.isEmpty()) { //Check if the list contains items or not

				for (int i = 0; i < this.listItemsCheckBoxes.size(); i++) {
					int count=0;
					waitUntilElementVisible(driver, this.listItemsCheckBoxes.get(i));
					this.listItemsCheckBoxes.get(i).click();
					if(count>=3) { // Stop after interacting with 3 checkboxes
						break;
					}
				}
			}		
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}

		logger.info("Ending of selectListItems Method");
	}

	public void clickOnOkListPicker() {
		logger.info("Starting of clickOnOkListPicker Method");

		try {
			if (listItemPickerOkBtn.isDisplayed()) { //Check if Ok button is displayed on the page
				waitUntilElementVisible(driver, this.listItemPickerOkBtn); //Wait Until element is visible.
				this.listItemPickerOkBtn.click(); //Click on the Ok button
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}

		logger.info("Ending of clickOnOkListPicker Method");
	}
	
	public void clickOnSaveListMapping() {
		logger.info("Starting of clickOnSaveListMapping method");
		
		try {
			if (listMappingSaveBtn.isDisplayed()) { //Check if the save button is displayed 
				waitUntilElementVisible(driver, this.listMappingSaveBtn);
				this.listMappingSaveBtn.click();
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Ending of clickOnSaveListMapping method");
	}
	
	
	public void clickOnSendNewOption() {
		logger.info("Starting of clickOnSendNewOption Method");
		
		try {
			if (this.sendPasswordOption.isDisplayed()) { //Check if the send new password option is displayed or not
				waitUntilElementVisible(driver, this.sendPasswordOption); //Wait for element visibility
				clickOnWebElement(sendPasswordOption); //Click on the send password option
				acceptSystemAlert(); //Accept the system alert pop-up screen
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
	
		logger.info("Ending of clickOnSendNewOption Method");
	}
	
	public String getStatus() {
		logger.info("Starting of getStatus Method");
		
		String status=null;
		
		try {
			if (passwordSentStatus.isDisplayed()) { //validate check password send pop up is displayed or not
				waitUntilElementVisible(driver, this.passwordSentStatus); 
				 status=this.passwordSentStatus.getText(); //Get the text from the alert 
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Ending of getStatus Method");
		
		return status;
	}
	
	public void enterEmployeeName(String name) {
		logger.info("Starting of enterEmployeeName Method");
		
		hardWait(5);
		try {
			if (this.empNameInputInFilter.isDisplayed()) { // Checking employee free text input field visible or not
				waitUntilElementVisible(driver, this.empNameInputInFilter); //Check whether Name free text is visible or not
				this.empNameInputInFilter.sendKeys(name);	
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		
		logger.info("Ending of enterEmployeeName Method");
	}
	
	public void clickOnApply() {
		logger.info("Starting of clickOnApply Method");
		
		try {
			if (this.applyBtnInFiter.isDisplayed()) { //validate to check apply btn is visible or not
				waitUntilElementVisible(driver, this.applyBtnInFiter);
				clickOnWebElement(this.applyBtnInFiter);
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		
		logger.info("Ending of clickOnApply Method");
	}
	
	public void clickOnActivationOption() {
		logger.info("Starting of clickOnActivationOption Method");
		
		try {
			
			if (this.activationCodeOption.isDisplayed()) { // checking the option is displayed or not
				waitUntilElementVisible(driver, this.activationCodeOption);
				clickOnWebElement(this.activationCodeOption);
				acceptSystemAlert();
			}
			
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		
		logger.info("Ending of clickOnActivationOption Method");
	}
	
	
	public void clickOnCreateWebAccount() {
		logger.info("Starting of clickOnCreateWebAccount Method");
		
		try {
			
			if (this.createdWebAccountOption.isDisplayed()) { // checking the option is displayed or not
				waitUntilElementVisible(driver, this.createdWebAccountOption);
				clickOnWebElement(this.createdWebAccountOption);
				acceptSystemAlert();
			}
			
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		
		logger.info("Ending of clickOnCreateWebAccount Method");
	}
	
	public void clickOnDeleteWebAccount() {
		logger.info("Starting of clickOnCreateWebAccount Method");
		
		try {
			
			if (this.createdWebAccountOption.isDisplayed()) { // checking the option is displayed or not
				waitUntilElementVisible(driver, this.createdWebAccountOption);
				clickOnWebElement(this.createdWebAccountOption);
				acceptSystemAlert();
			}
			
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Ending of clickOnCreateWebAccount Method");
	}
	
	
	public void clickOnTerritoryMappingOption() {
		logger.info("Starting of clickOnTerritoryMappingOption Method");
		
		try {
			
			if (this.territoryMapOption.isDisplayed()) { // checking the option is displayed or not
				waitUntilElementVisible(driver, this.territoryMapOption);
				clickOnWebElement(this.territoryMapOption);
			}
			
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Ending of clickOnTerritoryMappingOption Method");
	}
	
	
	public void selectTerriotryValue() {
		logger.info("Starting of selectTerriotryValue Method");
		
		try {
			waitUntilElementVisible(driver, this.territryValues);
			clickOnWebElement(this.territryValues);
			clickOnWebElement(this.moveRightOption);
			
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Ending of selectTerriotryValue Method");
	}
	
	
	public void clickOnSaveMapping() {
		
		try {
			
			if (this.saveBtnInMapping.isDisplayed()) { //Check whether save button is displayed or not
				
				waitUntilElementVisible(driver, this.saveBtnInMapping);
				clickOnWebElement(this.saveBtnInMapping);
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
	}
	
	
	public void clickOnRouteMappingOption() {
		logger.info("Starting of clickOnRouteMappingOption Method");
		
		try {
			
			if (this.routePlanMapOption.isDisplayed()) { // checking the option is displayed or not
				waitUntilElementVisible(driver, this.routePlanMapOption);
				clickOnWebElement(this.routePlanMapOption);
			}
			
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Ending of clickOnRouteMappingOption Method");
	}
	
	public void selectRoutePlan() {
		logger.info("Starting of selectRoutePlan Method");
		
		try {
			waitUntilElementVisible(driver, this.routePlan);
			clickOnWebElement(this.routePlan);
			clickOnWebElement(this.moveRightOption);
			
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Ending of selectRoutePlan Method");
	}
	
	public void clickOnTypeMappingOption() {
		logger.info("Starting of clickOnTypeMappingOption Method");
		
		try {
			
			if (this.typeMappingOption.isDisplayed()) { // checking the option is displayed or not
				waitUntilElementVisible(driver, this.typeMappingOption);
				clickOnWebElement(this.typeMappingOption);
			}
			
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Ending of clickOnTypeMappingOption Method");
	}
	
	public void selectTypeValue() {
		logger.info("Starting of selectTypeValue Method");
		
		try {
			waitUntilElementVisible(driver, this.typeVaule);
			clickOnWebElement(this.typeVaule);
			clickOnWebElement(this.moveRightOption);
			
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Ending of selectTypeValue Method");
	}
	
	public void clickOnTotalEmpBtn() {
		logger.info("Starting of clickOnTotalEmpBtn Method");
		
		try {
			
			if (this.totalEmpBtn.isDisplayed()) { //Validate the total employee button is displyed or not
				waitUntilElementVisible(driver, this.totalEmpBtn);
				clickOnWebElement(this.totalEmpBtn);
				totalEmpCount=this.totalEmpBtn.getText();
				hardWait(5);
			}
			
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Ending of clickOnTotalEmpBtn Method");
	}
	
	public String getTotalEmpCount() {
		logger.info("Starting of getTotalEmpCount Method");
		
		String finalCount=null;
		try {
			if (this.pageCount.isDisplayed()) { //Validate to check page count
				waitUntilElementVisible(driver, this.pageCount);
				String pageValue=this.pageCount.getText();
				String[] value=pageValue.split("of");
				String s1=value[1];
				String[] s3=s1.split(" ");
				String s4=s3[1];
				finalCount=s4.trim();
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Ending of getTotalEmpCount Method");
		
		return finalCount;
	}
	
	public void clickOnPendingApproval() {
		logger.info("Starting of clickOnPendingApproval Method");
		
		try {
			if (approvalCount.isDisplayed()) { // validate the check count page is displayed
				waitUntilElementVisible(driver, this.approvalCount);
				clickOnWebElement(this.approvalCount);
				approvalCountValue=this.approvalCount.getText();
				hardWait(5);
			}
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Ending of clickOnPendingApproval Method");
	}
	
	public String getApprovalCount() {
		logger.info("Starting of getApprovalCount Method");
		
		switchNewWindow();
		String approvalCount=null;
		
		try {
			if (this.pageCount.isDisplayed()) { //Validate to check page count
				waitUntilElementVisible(driver, this.pageCount);
				String pageValue=this.pageCount.getText();
				String[] split1=pageValue.split("of");
				String secondValue=split1[1];
				String[] split2=secondValue.split("entries");
				String firstValue=split2[0];
				approvalCount=firstValue.trim();
			}
			
		} catch (NoSuchElementException e) {
			logger.error("Error: Element is not visible : " + e.getMessage(), e);
			throw new RuntimeException("Searching Element is not visible in the page.", e);
		} catch (ElementNotInteractableException e) {
			logger.error("Error: Element is visible, But unable to interact the element " + e.getMessage(), e);
			throw new RuntimeException("Unable to Interact the element.", e);
		} catch (Exception e) {
			logger.error("Unexpected error occured : " + e.getMessage(), e);
			throw new RuntimeException("Unexpected failure during interaction.", e);
		}
		
		logger.info("Starting of getApprovalCount Method");
		
		return approvalCount;
	}
	
	
}
