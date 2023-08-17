package com.effort.filters;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class EmployeeFiltersPage extends BaseAutomationPage{

	private static final Logger logger = Logger.getLogger(EmployeeFiltersPage.class.getName());
	
	@FindBy(xpath = "//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath = "//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Web App')]")
	private WebElement webApp;
	
	@FindBy(id="employees")
	private WebElement employees;
	
	@FindBy(id="empNofilt")
	private WebElement inputEmpId;
	
	@FindBy(xpath="//a[@title='Apply']")
	private WebElement applyBtn;	
	
	@FindBy(xpath="//a[@class='btn btn-default-2 pull-right']")
	private WebElement filtersbtn;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td[3]")
	private WebElement actualEmpId;
	
	@FindBy(xpath="//a[contains(text(),'Reset')]")
	private WebElement Resetbtn;
	
	@FindBy(id="empNamefilt")
	private WebElement freetxtfield;
	
	@FindBy(id="activeStats")
	private WebElement activecheckbox;
	
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
	public String EnterEmployeesFiltersID(String empId) {
		logger.info("Starting of Click on EnterEmployeesFiltersID Method");
		scrollDown(100, this.filtersbtn);
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.inputEmpId);
		this.inputEmpId.sendKeys(empId);
		waitUntilElementVisible(driver, this.applyBtn);
		this.applyBtn.click();
		waitUntilElementVisible(driver, this.actualEmpId);
		String actualEmpId=this.actualEmpId.getText();
		logger.info("Ending of Click on EnterEmployeesFiltersID Method ");
        return actualEmpId;
	}
	
	public String EnterEmployeesFilterFreeText(String empfreetext) {
		logger.info("Starting of Click on EnterEmployeesFilterFreeText Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.Resetbtn);
		this.Resetbtn.click();
		waitUntilElementVisible(driver, this.activecheckbox);
		this.activecheckbox.click();
		waitUntilElementVisible(driver, this.freetxtfield);
		this.freetxtfield.sendKeys(empfreetext);
		waitUntilElementVisible(driver, this.applyBtn);
		this.applyBtn.click();
		waitUntilElementVisible(driver,this.actualempfreetext);
		String actualempfreetext = this.actualempfreetext.getText();
		return actualempfreetext;
		
	}
	
	
	
	
	
	
	
	
	public void employeeFiltersLogOut() {
		logger.info("Starting of LogOut Method");
		waitUntilElementVisible(driver, userNameBtn);
		userNameBtn.click();
		if (logoutBtn.get(logoutBtn.size() - 1).getText().equalsIgnoreCase("LogOut")) {
			logoutBtn.get(logoutBtn.size() - 1).click();
		}
		logger.info("Ending of LogOut Method");
	}

	
}
