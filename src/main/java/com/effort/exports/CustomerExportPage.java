package com.effort.exports;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import com.effort.base.BaseAutomationPage;

public class CustomerExportPage extends BaseAutomationPage {

	private static final Logger logger=Logger.getLogger(CustomerExportPage.class);

	@FindBy(xpath = "//a[contains(text(),'Web App')]")
	private WebElement webApp;

	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;

	@FindBy(xpath = "//a[contains(text(),'Customers')]")
	private WebElement customers;

	@FindBy(xpath="//div[@class='dropdown']/button")
	private WebElement exportBtn;

	@FindBy(xpath="//ul[@class='dropdown-menu btn-block']/li/form/a[contains(text(),'Export All')]")
	private WebElement exportAll;

	@FindBy(xpath="//div[@class='jconfirm-buttons']/button[1]")
	private WebElement exportconfirmBtn;

	@FindBy(xpath="//div[@class='centered']/div[2]")
	private WebElement ExportCnfirmMsg;

	@FindBy(xpath = "//form[@id='command']")
	private WebElement scrollform;

	@FindBy(xpath = "//tbody//input[@id='selectWork']")
	private List<WebElement> customerselectcheckbox;

	@FindBy(xpath="//ul[@class='dropdown-menu btn-block']/li/form/a[3]")
	private WebElement exportselected;

	@FindBy(xpath="//div[@id='progress']")
	private WebElement exportselectedsuccessmsg;

	@FindBy(xpath="//ul/li/a[@id='filters']")
	private WebElement filters;

	@FindBy(xpath="//input[@id='s2id_autogen1']")
	private WebElement custmrnamefilter;

	@FindBy(xpath="//div[@id='select2-drop']/ul/li/div/span")
	private List<WebElement> customernameinput;

	@FindBy(xpath="//div/a[@id='search']")
	private WebElement filterapply;

	@FindBy(xpath="//ul/li/form/a[@id='exportFiltered']")
	private WebElement exportfiltered;

	@FindBy(xpath="//div[@id='progress']")
	private WebElement exportfilteredsuccesmsg;



	public CustomerExportPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void ClickonWebApp() {
		logger.info("Starting of ClickonWebApp Method");
		waitUntilElementVisible(driver, this.webApp);
		this.webApp.click();
		logger.info("Ending of ClickonWebApp Method");

	}

	public void ClickonCustomerModule() {
		logger.info("Starting of ClickonCustomerModule Method");
		waitUntilElementVisible(driver, customers);
		this.customers.click();
		logger.info("Ending of ClickonCustomerModule Method");

	}

	public void ClickonExport() {
		logger.info("Starting of ClickonExport Method");
		waitUntilElementVisible(driver, exportBtn);
		this.exportBtn.click();
		logger.info("Ending of ClickonExport  Method");
	}

	public void SelcetExportAll() {
		logger.info("Starting of SelcetExportAll Method");
		waitUntilElementVisible(driver, exportAll);
		this.exportAll.click();
		logger.info("Ending of SelcetExportAll Method");

	}

	public void ExportConfirm() throws InterruptedException {
		logger.info("Starting of ExportConfirm Method");
		waitUntilElementVisible(driver, exportconfirmBtn);
		Thread.sleep(5000);
		this.exportconfirmBtn.click();
		logger.info("Ending of ExportConfirm Method");
	}

	public void SwitchtoNewWindow() {
		logger.info("Starting of SwitchtoWindow Method");
		String parentWindow = driver.getWindowHandle();	
		Set<String> childWindow = driver.getWindowHandles();
		Iterator<String>it = childWindow.iterator();
		while(it.hasNext()) {
			String newWindow = it.next();
			if(!parentWindow.equals(newWindow)) {
				driver.switchTo().window(newWindow);		
			}	
		}
		logger.info("Ending of SwitchtoWindow Method");
	}

	public String ExportConfirmMsg() {
		logger.info("Starting of ExportConfirmMsg Method");
		waitUntilElementVisible(driver, ExportCnfirmMsg);
		String actualExprtCnfrmMsg = this.ExportCnfirmMsg.getText();
		return actualExprtCnfrmMsg;
	}

	public void customerSelectionCheckbox() throws InterruptedException {
		logger.info("Starting of selectCustomertoExport Method");
		Thread.sleep(500);
		scrollDown(100, scrollform );
		for(int i=0 ; i<6 ; i++) {
			this.customerselectcheckbox.get(i).click();
		}
		logger.info("Ending of selectCustomertoExport Method");
	}

	public void clickonExportSelected() {
		logger.info("Starting of exportSelected Method");
		waitUntilElementVisible(driver, exportselected);
		this.exportselected.click();		
		logger.info("Ending of exportSelected Method");
	}

	public String exportSelectedSuccessMsg() throws InterruptedException {
		logger.info("Starting of exportSelectedSuccessMsg Method");
		waitUntilElementVisible(driver, exportselectedsuccessmsg);
		Thread.sleep(7000);
		String actualexportSelectedSuccessMsg = this.exportselectedsuccessmsg.getText();
		return actualexportSelectedSuccessMsg;

	}

	public void ClickOnFilter() {
		logger.info("Starting of ClickOnFilter Method");
		scrollDown(100, scrollform);
		waitUntilElementVisible(driver, filters);
		this.filters.click();
		logger.info("Ending of ClickOnFilter Method");
	}

	public void filterCustomerName() {
		logger.info("Starting of filterCustomerName Method");
		waitUntilElementVisible(driver, custmrnamefilter);
		this.custmrnamefilter.sendKeys("customer");
		logger.info("Ending of filterCustomerName Method");	
	}
	
	public void selectCustomerName() {
		logger.info("Starting of selectCustomerName Method");
		int i=0;
		while(i<customernameinput.size()) {
			String customerName = this.customernameinput.get(i).getText();

			if(customerName.contains("Customer")) {
				this.customernameinput.get(i).click();
				break;
			}
			i++;
		}
		logger.info("Ending of selectCustomerName Method");
	}

	public void clickOnApply() {
		logger.info("Starting of clickOnApply Method");
		waitUntilElementVisible(driver, filterapply);
		this.filterapply.click();
		logger.info("Ending of clickOnApply Method");
	}

	public void clickOnExportFiltered() {
		logger.info("Starting of clickOnExportFiltered Method");
		waitUntilElementVisible(driver,exportfiltered);
		this.exportfiltered.click();
		logger.info("Ending of clickOnExportFiltered Method");
	}

	public String exportFilteredConfirmMessage() throws InterruptedException {
		logger.info("Starting of exportFilteredConfirmMessage Method");
		waitUntilElementVisible(driver, exportfilteredsuccesmsg);
		Thread.sleep(7000);
		String actualexportfilteredmsg = this.exportfilteredsuccesmsg.getText();
		return actualexportfilteredmsg;
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
