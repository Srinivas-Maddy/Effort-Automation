package com.effort.filters;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class EmployeeFiltersPage extends BaseAutomationPage{

	private static final Logger logger = Logger.getLogger(EmployeeFiltersPage.class.getName());
	
	@FindBy(xpath = "((//a/span)[4]/span)[2]")
	private WebElement userNameBtn;

	@FindBy(xpath = "(//ul[@class='dropdown-menu'])[2]/li/a")
	private List<WebElement> logoutBtn;
	
	@FindBy(xpath = "(//div[@class='dashboard-cards']/ul/li)[2]")
	private WebElement webApp;
	
	@FindBy(xpath="//li[@id='employees']/a")
	private WebElement employees;
	
	@FindBy(xpath="//input[@id='empNofilt']")
	private WebElement inputEmpId;
	
	@FindBy(xpath="//a[@title='Apply']")
	private WebElement applyBtn;	
	
	@FindBy(xpath="//a[@id='filters']")
	private WebElement filtersbtn;
	
	@FindBy(xpath="//a[contains(text(),'Reset')]")
	private WebElement Resetbtn;
	
	@FindBy(xpath="//img[@title='Activation Completed']")
	private WebElement actualactiveemp;
	
	@FindBy(xpath="//input[@id='activeStats']")
	private WebElement activecheckbox;
	
	@FindBy(id="disabledStats")
	private WebElement Disabledcheckbox;
	
	@FindBy(xpath="//input[@id='provisioned']")
	private WebElement provisionedcheckbox;
	
	@FindBy(id ="notProvisioned")
	private WebElement notprovisionedcheckbox;
	
	@FindBy(xpath="//img[@title='Disabled']")
	private WebElement actualdisabledEmp;
	
	@FindBy(xpath="//img[@title='Activation Completed']")
	private WebElement actualprovisionedEmp;
	
	@FindBy(xpath="//img[@title='Activation Incomplete']")
	private WebElement actualnotprovisionedEmp;
	
	@FindBy(xpath="//input[@id='empNamefilt']")
	private WebElement freetxtfield;
	
	@FindBy(xpath="(//tbody[1]/tr[2]/td)[4]")
	private WebElement actualempfreetext;

	
	public EmployeeFiltersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void ClickonWebApp() {
		logger.info("Starting of ClickonWebApp Method");
		waitUntilElementVisible(driver, webApp);
		this.webApp.click();
		logger.info("Ending of ClickonWebApp Method ");

	}
	public void ClickonEmployees() {
		logger.info("Starting of Click on ClickonEmployees Method");
		waitUntilElementVisible(driver, this.employees);
		this.employees.click();
		logger.info("Ending of Click on ClickonEmployees Method ");

	}
	public void selectActiveEmployee(String empId) {
		logger.info("Starting of Click on enterEmployeesFiltersID Method");
		scrollDown(100, this.filtersbtn);
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.inputEmpId);
		this.inputEmpId.sendKeys(empId);
		waitUntilElementVisible(driver, this.applyBtn);
		this.applyBtn.click();
		logger.info("Ending of Click on enterEmployeesFiltersID Method ");
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
	
	
	
//	public void EnterEmployeesFilterFreeText(String empfreetext) {
//		logger.info("Starting of Click on EnterEmployeesFilterFreeText Method");
//		waitUntilElementVisible(driver, this.filtersbtn);
//		this.filtersbtn.click();
//		waitUntilElementVisible(driver, this.Resetbtn);
//		this.Resetbtn.click();
//		waitUntilElementVisible(driver, this.activecheckbox);
//		this.activecheckbox.click();
//		waitUntilElementVisible(driver, this.freetxtfield);
//		this.freetxtfield.sendKeys(empfreetext);
//		waitUntilElementVisible(driver, this.applyBtn);
//		this.applyBtn.click();
//	}
//	
//	public String employeesFilterfreetextValidation() {
//		logger.info("Starting of Click on employeesFilterfreetextValidation Method");
//		waitUntilElementVisible(driver,this.actualempfreetext);
//		String actualempfreetext = this.actualempfreetext.getText();
//		return actualempfreetext;
//	}
	
	public void employeeFiltersLogOut() throws InterruptedException {
		logger.info("Starting of LogOut Method");
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",userNameBtn );
		waitUntilElementVisible(driver, userNameBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.userNameBtn);
		for(int i=0; i<this.logoutBtn.size();i++) {
			String dropdownNames=this.logoutBtn.get(i).getText();
			if (dropdownNames.equalsIgnoreCase("Logout")){
				waitUntilElementVisible(driver,this.logoutBtn.get(i));
				this.logoutBtn.get(i).click();
				break;
			}

		}
		logger.info("Ending of LogOut Method");
	}

	
}
