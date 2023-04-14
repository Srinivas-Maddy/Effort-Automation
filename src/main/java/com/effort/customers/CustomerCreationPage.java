package com.effort.customers;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.effort.base.BaseAutomationPage;
import com.effort.base.LoginPage;

public class CustomerCreationPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(LoginPage.class.getName());

	@FindBy(xpath = "//i[@class=\"fa fa-users\"]")
	private WebElement customers;

	@FindBy(xpath = "//input[@value=\"Add\"]")
	private WebElement addCustomer;

	@FindBy(xpath = "//input[@name=\"customerNo\"]")
	private WebElement customerId;

	@FindBy(xpath = "//input[@class=\"sysField form-control inputTypeCompanyLevelId\"]")
	private WebElement customerName;

	@FindBy(xpath = "//input[@id=\"field_3\"]")
	private WebElement customerPhone;

	@FindBy(xpath = "//img[@id=\"map\"]")
	private WebElement customerMap;

	@FindBy(xpath = "//span[contains(text(),'Confirm Location')]")
	private WebElement confirmLocation;

	@FindBy(xpath = "//input[@id=\"field_5\"]")
	private WebElement addStreet;

	@FindBy(xpath = "//input[@id=\"field_8\"]")
	private WebElement landMark;

	@FindBy(xpath = "//input[@id=\"field_6\"]")
	private WebElement area;

	@FindBy(xpath = "//input[@id=\"field_7\"]")
	private WebElement city;

	@FindBy(xpath = "//input[@id=\"field_22\"]")
	private WebElement district;

	@FindBy(xpath = "//input[@id=\"field_11\"]")
	private WebElement pinCode;

	@FindBy(xpath = "//input[@id=\"field_9\"]")
	private WebElement state;

	@FindBy(xpath = "//div[@class=\"select2-container sysField\"]")
	private WebElement selectCountry;

	@FindBy(xpath = "//div[contains(text(),'India')]")
	private WebElement india;

	public CustomerCreationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnCustomers() {
		logger.info("Starting of clickOnCustomers method");

		this.implicitWait();
		this.customers.click();

		logger.info("Ending of clickOnCustomers method");
	}

	public void clickOnAddCustomer() {
		logger.info("Starting of clickOnAddCustomer method");

		this.implicitWait();
		this.addCustomer.click();

		logger.info("Ending of clickOnAddCustomer method");
	}

	public void clickOnCustomerID(String cusId) {
		logger.info("Starting of clickOnCustomerID method");

		this.implicitWait();
		this.customerId.click();
		this.customerId.sendKeys(cusId);

		logger.info("Ending of clickOnCustomerID method");
	}
	
	/*
	 * public void clickOnCustomerName() {
	 * 
	 * WebElement customerName = driver.findElement(By.
	 * xpath("//input[@class=\"sysField form-control inputTypeCompanyLevelId\"]"));
	 * 
	 * JavascriptExecutor executor = (JavascriptExecutor)driver;
	 * 
	 * executor.executeScript("arguments[0].click()", customerName); }
	 */

	
	
	  public void clickOnCustomerName(String cusName) {
	  logger.info("Starting of clickOnCustomerName method");
	  
	  //this.implicitWait();
	  driver.findElement(By.xpath("//input[@class=\"sysField form-control inputTypeCompanyLevelId\"]")).click();
	  WebDriverWait wait = new WebDriverWait(driver, 3);
	  WebElement customerName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field_1")));
	  //this.customerName.click();
	  this.customerName.sendKeys(cusName);
	  
	  logger.info("Ending of clickOnCustomerName method"); }
	 

	public void clickOnCustomerPhone(String cusPhone) {
		logger.info("Starting of clickOnCustomerPhone method");

		this.implicitWait();
		this.customerPhone.sendKeys(cusPhone);

		logger.info("Ending of clickOnCustomerPhone method");
	}

	public void clickOnCustomerMap() {
		logger.info("Starting of clickOnCustomerMap method");

		this.implicitWait();
		this.customerMap.click();

		logger.info("Ending of clickOnCustomerMap method");
	}

	public void clickOnConfirmLocation() {
		logger.info("Starting of clickOnConfirmLocation method");

		this.implicitWait();
		this.confirmLocation.click();
		this.scrollDown(600,confirmLocation);
		logger.info("Ending of clickOnConfirmLocation method");
	}

	public void clickOnAddStreet(String street) {
		logger.info("Starting of clickOnAddStreet method");

		this.implicitWait();
		this.addStreet.sendKeys(street);

		logger.info("Ending of clickOnAddStreet method");
	}

	public void clickOnLandMark(String Bank) {
		logger.info("Starting of clickOnLandMark method");

		this.implicitWait();
		this.landMark.sendKeys(Bank);

		logger.info("Ending of clickOnLandMark method");
	}

	public void clickOnArea(String Area) {
		logger.info("Starting of clickOnLandMark method");

		this.implicitWait();
		this.area.sendKeys(Area);

		logger.info("Ending of clickOnLandMark method");
	}

	public void clickOnCity(String City) {
		logger.info("Starting of clickOnLandMark method");

		this.implicitWait();
		this.city.sendKeys(City);

		logger.info("Ending of clickOnLandMark method");
	}

	public void clickOnDistrict(String District) {
		logger.info("Starting of clickOnLandMark method");

		this.implicitWait();
		this.district.sendKeys(District);

		logger.info("Ending of clickOnLandMark method");
	}

	public void clickOnPincode(String pin) {
		logger.info("Starting of clickOnLandMark method");

		this.implicitWait();
		this.pinCode.sendKeys(pin);

		logger.info("Ending of clickOnLandMark method");
	}

	public void clickOnState(String State) {
		logger.info("Starting of clickOnLandMark method");

		this.implicitWait();
		this.state.sendKeys(State);

		logger.info("Ending of clickOnLandMark method");
	}

	public void clickOnSelectCountry() {
		logger.info("Starting of clickOnLandMark method");

		this.implicitWait();
		this.selectCountry.click();

		logger.info("Ending of clickOnLandMark method");
	}

	public void clickOnIndia() {
		logger.info("Starting of clickOnIndia method");

		this.implicitWait();
		this.india.click();

		logger.info("Ending of clickOnIndia method");
	}

}
