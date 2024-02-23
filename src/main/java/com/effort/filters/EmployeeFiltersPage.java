package com.effort.filters;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class EmployeeFiltersPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(EmployeeFiltersPage.class.getName());

	@FindBy(xpath = "((//a/span)[4]/span)[2]")
	private WebElement userNameBtn;

	@FindBy(xpath = "(//ul[@class='dropdown-menu'])[2]/li/a")
	private List<WebElement> logoutBtn;

	@FindBy(xpath = "//ul[@class='list-inline']/li[2]/h5/a")
	private WebElement webApp;

	@FindBy(xpath = "//li[@id='employees']/a")
	private WebElement employees;

	@FindBy(id = "empNofilt")
	private WebElement inputEmpId;

	@FindBy(id = "search")
	private WebElement applyBtn;

	@FindBy(id = "empNamefilt")
	private WebElement inputEmpFreeText;

	@FindBy(id = "s2id_empId")
	private WebElement employeeNamePicker;

	@FindBy(xpath = "//input[@id='s2id_autogen5_search']")
	private WebElement inputEmpThreeLetters;
	
	@FindBy(id="reset")
	private WebElement resetBtn;

	@FindBy(id = "activeStats")
	private WebElement activeCheckbox;

	@FindBy(id = "disabledStats")
	private WebElement disableCheckbox;

	@FindBy(id = "provisioned")
	private WebElement provisionedCheckbox;

	@FindBy(id = "notProvisioned")
	private WebElement notProvisionChechbox;

	@FindBy(id = "webUserStatus")
	private WebElement webUserCheckbox;

	@FindBy(xpath = "//ul[@role='listbox']/li[1]")
	private WebElement empThreeLetterName;
	
	@FindBy(id="empPhonefilt")
	private WebElement inputEmpPhone;
	
	@FindBy(id="empEmailfilt")
	private WebElement inputEmpEmail;
	
	@FindBy(id="s2id_managerId")
	private WebElement managersDropDown;
	
	@FindBy(xpath="//div[@id='select2-drop']/ul/li/div")
	private List<WebElement> managersList;

	@FindBy(xpath = "//a[@id='filters']")
	private WebElement filtersbtn;

	@FindBy(xpath = "//a[contains(text(),'Reset')]")
	private WebElement Resetbtn;

	@FindBy(xpath = "//img[@title='Activation Completed']")
	private WebElement actualactiveemp;

	@FindBy(xpath = "//input[@id='activeStats']")
	private WebElement activecheckbox;

	@FindBy(id = "disabledStats")
	private WebElement Disabledcheckbox;

	@FindBy(xpath = "//input[@id='provisioned']")
	private WebElement provisionedcheckbox;

	@FindBy(id = "notProvisioned")
	private WebElement notprovisionedcheckbox;

	@FindBy(xpath = "//img[@title='Disabled']")
	private WebElement actualdisabledEmp;

	@FindBy(xpath = "//img[@title='Activation Completed']")
	private WebElement actualprovisionedEmp;

	@FindBy(xpath = "//img[@title='Activation Incomplete']")
	private WebElement actualnotprovisionedEmp;

	@FindBy(xpath = "//input[@id='empNamefilt']")
	private WebElement freetxtfield;

	@FindBy(xpath = "(//tbody[1]/tr[2]/td)[4]")
	private WebElement actualempfreetext;
	
	//Employee Results WebElements
	@FindBy(xpath = "//table[@id='example']/tbody/tr/td[3]")
	private WebElement empIdFitlerResult;

	@FindBy(xpath = "//table[@id='example']/tbody/tr/td[4]")
	private List<WebElement> listOfEmployeeNames;

	@FindBy(xpath = "//table[@id='example']/tbody/tr/td[4]")
	private WebElement empThreeLetterFitlerResult;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td[8]")
	private WebElement empPhoneResult;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td[6]")
	private WebElement empManagerResult;
	
    //Expected Results Variables
	private String employeeName;
	private String managerName;

	@FindBy(id = "filters")
	private WebElement filterBtn;

	public EmployeeFiltersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnWebApp() {
		logger.info("Starting of ClickonWebApp Method");

		hardWait(3);
		waitUntilElementVisible(driver, webApp);
		clickOnWebElement(this.webApp);

		logger.info("Ending of ClickonWebApp Method ");

	}

	public void clickOnEmplpyeeModule() {
		logger.info("Starting of Click on ClickonEmployees Method");

		waitUntilElementVisible(driver, this.employees);
		clickOnWebElement(this.employees);

		logger.info("Ending of Click on ClickonEmployees Method ");
	}

	public void clickOnFilter() {
		logger.info("Starting of click on filter button");

		hardWait(5);
		waitUntilElementVisible(driver, this.filterBtn);
		clickOnWebElement(this.filterBtn);

		logger.info("Ending of click on filter button");

	}

	public void clickOnReset(String status) {
		logger.info("Starting of clickOnReset Method");

		if (status.equals("Active")) {
			
			waitUntilElementVisible(driver, this.resetBtn);
			clickOnWebElement(this.resetBtn);
			waitUntilElementVisible(driver, this.activeCheckbox);
			clickOnWebElement(this.activeCheckbox);
			
		} else if (status.equals("Disabled")) {
			
			clickOnWebElement(this.resetBtn);
			clickOnWebElement(this.disableCheckbox);
			
		} else if (status.equals("provisioned")) {
			
			clickOnWebElement(this.resetBtn);
			clickOnWebElement(this.provisionedCheckbox);
			
		} else if (status.equals("Not provision")) {
			
			clickOnWebElement(this.resetBtn);
			clickOnWebElement(this.notProvisionChechbox);
			
		} else if (status.equals("Web User")) {
			
			clickOnWebElement(this.resetBtn);
			clickOnWebElement(this.webUserCheckbox);
		}

		logger.info("Ending of clickOnReset Method");

	}

	public void clickOnApplyButton() {

		logger.info("Starting of clickOnApplyButton Method");

		waitUntilElementVisible(driver, this.applyBtn);
		clickOnWebElement(this.applyBtn);
		hardWait(5);

		logger.info("Endig of clickOnApplyButton Method");
	}

	public String enterEmpId(String empId) {

		logger.info("Starting of  enterEmpId Method");

		scrollIntoView(this.inputEmpId);
		waitUntilElementVisible(driver, this.inputEmpId);
		this.inputEmpId.sendKeys(empId);
		clickOnApplyButton();
		waitUntilElementVisible(driver, this.empIdFitlerResult);
		String resultEmpId = this.empIdFitlerResult.getText();

		logger.info("Ending of enterEmpId Method ");

		return resultEmpId;
	}

	public String enterEmpNameFreeText(String empName) {

		logger.info("Starting of enterEmpNameFreeText");

		waitUntilElementVisible(driver, this.inputEmpFreeText);
		this.inputEmpFreeText.sendKeys(empName);
		clickOnApplyButton();
		for (int i = 0; i < listOfEmployeeNames.size(); i++) {
			hardWait(5);
			String empNames = this.listOfEmployeeNames.get(i).getText();
			if (empNames.equalsIgnoreCase(empName)) {
				employeeName = this.listOfEmployeeNames.get(i).getText();
				break;
			}
		}
		logger.info("Ending of enterEmpNameFreeText");

		return employeeName;
	}

	public String searchWithThreeLetters(String empName) {

		logger.info("Starting of searchWithThreeLetters method");

		waitUntilElementVisible(driver, this.employeeNamePicker);
		clickOnWebElement(this.employeeNamePicker);
		waitUntilElementVisible(driver, this.inputEmpThreeLetters);
		this.inputEmpThreeLetters.sendKeys(empName);
		waitUntilElementVisible(driver, this.empThreeLetterName);
		this.empThreeLetterName.click();
		clickOnApplyButton();
		waitUntilElementVisible(driver, this.empThreeLetterFitlerResult);
		String resultEmpName = this.empThreeLetterFitlerResult.getText();

		logger.info("Ending of searchWithThreeLetters method");

		return resultEmpName;
	}
	
	public String enterEmployeePhone(String empPhone) {
		logger.info("Starting of enterEmployeePhone Method");
		
		waitUntilElementVisible(driver, this.inputEmpPhone);
		this.inputEmpPhone.sendKeys(empPhone);
		clickOnApplyButton();
		waitUntilElementVisible(driver, this.empPhoneResult);
		String phoneNumber=this.empPhoneResult.getText();
		
		logger.info("Ending of enterEmployeePhone Method");
 
		return phoneNumber;
	}
	
	public String enterEmpEmail(String empEmail) {
		logger.info("Starting of enterEmpEmail Method");

		waitUntilElementVisible(driver, this.inputEmpEmail);
		this.inputEmpEmail.sendKeys(empEmail);
		clickOnApplyButton();
		waitUntilElementVisible(driver, this.empThreeLetterFitlerResult);
		String resultEmp = this.empThreeLetterFitlerResult.getText();
		
		logger.info("Ending of enterEmpEmail Method");
		
		return resultEmp;
	}
	
	public String selectEmpManagerName(String managerName) {
		logger.info("Starting of selectEmpManagerName Method");
		
		waitUntilElementVisible(driver, this.managersDropDown);
		clickOnWebElement(this.managersDropDown);
		
		for (int i = 0; i < managersList.size(); i++) {
			String Manager=this.managersList.get(i).getText();
			if (Manager.equalsIgnoreCase(managerName)) {
				this.managersList.get(i).click();
				clickOnApplyButton();
				waitUntilElementVisible(driver, this.empManagerResult);
				managerName=this.empManagerResult.getText();
				break;
			}
		}
		logger.info("Ending of selectEmpManagerName Method");
		
		return managerName;

	}

	public String activeEmployeesValidation() {
		logger.info("Starting of Click on activeEmployeesValidation Method");
		WebElement disabledimageElement = this.actualactiveemp;
		String actualactiveemp = disabledimageElement.getAttribute("title");
		return actualactiveemp;
	}

	public void selectDisabledCheckbox(String disabledempid) {
		logger.info("Starting of Click on selectDisabledCheckbox Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.Resetbtn);
		this.Resetbtn.click();
		waitUntilElementVisible(driver, this.Disabledcheckbox);
		this.Disabledcheckbox.click();
		waitUntilElementVisible(driver, this.inputEmpId);
		this.inputEmpId.sendKeys(disabledempid);
		waitUntilElementVisible(driver, this.applyBtn);
		this.applyBtn.click();
		logger.info("Ending of Click on selectDisabledCheckbox Method ");
	}

	public String disabledEmployeesValidation() throws InterruptedException {
		logger.info("Starting of Click on disabledEmployeesValidation Method");
		WebElement disabledimageElement = this.actualdisabledEmp;
		String actualSrc = disabledimageElement.getAttribute("title");
		return actualSrc;

	}

	public void selectProvisionedCheckbox(String provisionedempid) {
		logger.info("Starting of Click on selectProvisionedCheckbox Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.Resetbtn);
		this.Resetbtn.click();
		waitUntilElementVisible(driver, this.provisionedcheckbox);
		this.provisionedcheckbox.click();
		waitUntilElementVisible(driver, this.inputEmpId);
		this.inputEmpId.sendKeys(provisionedempid);
		waitUntilElementVisible(driver, this.applyBtn);
		this.applyBtn.click();
		logger.info("Ending of Click on selectProvisionedCheckbox Method ");
	}

	public String provisionedEmployeesValidation() throws InterruptedException {
		logger.info("Starting of Click on provisionedEmployeesValidation Method");
		WebElement provisinedimageElement = this.actualprovisionedEmp;
		String actualSrc = provisinedimageElement.getAttribute("title");
		return actualSrc;

	}

	public void selectNotProvisionedCheckbox(String notprovisionedempid) {
		logger.info("Starting of Click on selectNotProvisionedCheckbox Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.Resetbtn);
		this.Resetbtn.click();
		waitUntilElementVisible(driver, this.notprovisionedcheckbox);
		this.notprovisionedcheckbox.click();
		waitUntilElementVisible(driver, this.inputEmpId);
		this.inputEmpId.sendKeys(notprovisionedempid);
		waitUntilElementVisible(driver, this.applyBtn);
		this.applyBtn.click();

		logger.info("Ending of Click on selectNotProvisionedCheckbox Method ");
	}

	public String notProvisionedEmployeesValidation() throws InterruptedException {
		logger.info("Starting of Click on notProvisionedEmployeesValidation Method");
		WebElement notprovisinedimageElement = this.actualnotprovisionedEmp;
		String actualSrc = notprovisinedimageElement.getAttribute("title");
		return actualSrc;

	}

	// public void EnterEmployeesFilterFreeText(String empfreetext) {
	// logger.info("Starting of Click on EnterEmployeesFilterFreeText Method");
	// waitUntilElementVisible(driver, this.filtersbtn);
	// this.filtersbtn.click();
	// waitUntilElementVisible(driver, this.Resetbtn);
	// this.Resetbtn.click();
	// waitUntilElementVisible(driver, this.activecheckbox);
	// this.activecheckbox.click();
	// waitUntilElementVisible(driver, this.freetxtfield);
	// this.freetxtfield.sendKeys(empfreetext);
	// waitUntilElementVisible(driver, this.applyBtn);
	// this.applyBtn.click();
	// }
	//
	// public String employeesFilterfreetextValidation() {
	// logger.info("Starting of Click on employeesFilterfreetextValidation Method");
	// waitUntilElementVisible(driver,this.actualempfreetext);
	// String actualempfreetext = this.actualempfreetext.getText();
	// return actualempfreetext;
	// }

	public void employeeFiltersLogOut() throws InterruptedException {
		logger.info("Starting of LogOut Method");
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", userNameBtn);
		waitUntilElementVisible(driver, userNameBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.userNameBtn);
		for (int i = 0; i < this.logoutBtn.size(); i++) {
			String dropdownNames = this.logoutBtn.get(i).getText();
			if (dropdownNames.equalsIgnoreCase("Logout")) {
				waitUntilElementVisible(driver, this.logoutBtn.get(i));
				this.logoutBtn.get(i).click();
				break;
			}

		}
		logger.info("Ending of LogOut Method");
	}

}
