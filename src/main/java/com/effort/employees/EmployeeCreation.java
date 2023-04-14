package com.effort.employees;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class EmployeeCreation extends BaseAutomationPage{

	private static final Logger logger = Logger.getLogger(EmployeeCreation.class.getName());
	String parentWind=driver.getWindowHandle();


	@FindBy(xpath="//a[contains(text(),'Web App')]")
	private WebElement webApp;

	@FindBy(xpath="//a[contains(text(),' Employees ')]")
	private WebElement employeeModule;

	@FindBy(xpath="//button[@id='addItems']")
	private WebElement addEmpBtn;

	@FindBy(xpath="//input[@id='empFirstName']")
	private WebElement firstName;

	@FindBy(id="empLastName")
	private WebElement empLastName;

	@FindBy(xpath="//input[@name='empNo']")
	private WebElement empId;

	@FindBy(id="manager")
	private WebElement managerCheckBox;

	@FindBy(id="generateQrCode")
	private WebElement qrCode;
	
	@FindBy(id="empEmail")
	private WebElement empEmail;
	
	@FindBy(xpath="//input[@name='empPhone']")
	private WebElement empPhone;
	
	@FindBy(xpath="//input[@id='save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;
	
	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;



	//Default constructor
	public EmployeeCreation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnWebApp() {
		logger.info("Starting of Click on web App method");
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
	}

	public void enterFirstName(String enterFirstName) {
		logger.info("Starting of enterFirstName method");
		waitUntilElementVisible(driver, firstName);
		firstName.sendKeys(enterFirstName+"_"+getCurrentDate());
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
		String empNo=getUniqueNumber("Auto_EMP");
		waitUntilElementVisible(driver, empId);
		empId.sendKeys(empNo);
		logger.info("ending of enterEmpId method");
	}

	public void managerCheckBox() {
		logger.info("Starting of managerCheckBox method");
		waitUntilElementVisible(driver, managerCheckBox);
		managerCheckBox.click();
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
		String randomEmail=randomEmailGenerator();
		waitUntilElementVisible(driver, empEmail);
		empEmail.sendKeys(randomEmail);
		logger.info("ending of enterEmpEmail method");
	}
	
	public void EmpPhone() {
		logger.info("Starting of enterEmpPhone method");
		String randomPhone=randomMobileNumbers();
		waitUntilElementVisible(driver, empPhone);
		empPhone.sendKeys(randomPhone);
		logger.info("ending of enterEmpPhone method");
	}
	
	public void clickOnSaveBtn() {
		logger.info("Starting of clickOnSaveBtn method");
		waitUntilElementVisible(driver, saveBtn);
		saveBtn.click();
		logger.info("ending of qrCodeCheckBox method");
	}

	public void logOut() {
		logger.info("Starting of Logout method");
		waitUntilElementVisible(driver, userNameBtn);
		userNameBtn.click();
		if(logoutBtn.get(logoutBtn.size()-1).getText().equalsIgnoreCase("Logout")) {
			logoutBtn.get(logoutBtn.size()-1).click();
		}
		logger.info("Ending of Logout method");
	}



}
