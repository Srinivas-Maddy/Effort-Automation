package com.effort.exports;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class EntitiesExportPage extends BaseAutomationPage {

	private static Logger logger = Logger.getLogger(EntitiesExportPage.class.getName());

	@FindBy(xpath = "//a[contains(text(),'Web App')]")
	private WebElement webApp;

	@FindBy(id = "dots")
	private WebElement webappthreedots;

	@FindBy(xpath = "(//ul[@class='dropdown-menu'])[1]/li")
	private List<WebElement> webappthreedotsdata;

	@FindBy(xpath = "(//button[contains(@class,'btn-block')])[2]")
	private WebElement entityexportimportoption;

	@FindBy(xpath = "(//ul[@class='dropdown-menu btn-block'])[2]/li[2]")
	private WebElement exportSelected;

	@FindBy(xpath = "(//div[@class='container-fluid bg-1'])[2]")
	private WebElement scrollform;

	@FindBy(xpath = "//table[@id='example']/tbody/tr/td[1]")
	private List<WebElement> entityselectcheckbox;

	@FindBy(xpath = "(//ul[@class='dropdown-menu btn-block'])[2]/li[3]")
	private WebElement entityexportall;

	@FindBy(id = "filters")
	private WebElement filters;

	@FindBy(xpath = "(//div[text()='Entity Name'])[2]/input")
	private WebElement filtersentitynametextfield;

	@FindBy(id = "search")
	private WebElement filtersapplybtn;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu btn-block'])[2]/li[4]")
	private WebElement exportfiltered;
	
	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;
	

	public EntitiesExportPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void ClickonWebApp() {
		logger.info("Starting of ClickonWebApp Method");
		waitUntilElementVisible(driver, this.webApp);
		this.webApp.click();
		logger.info("Ending of ClickonWebApp Method");

	}

	public void clickOnDots() throws InterruptedException {
		logger.info("Starting of clickOnDots Method");
		waitUntilElementVisible(driver, this.webappthreedots);
		this.webappthreedots.click();
		Thread.sleep(500);
		logger.info("Ending of clickOnDots Method");
	}

	public void pickEntityName(String autoentityname) {
		logger.info("Starting of pickEntityName Method");
		for (int i = 0; i < this.webappthreedotsdata.size(); i++) {
			String EntityName = this.webappthreedotsdata.get(i).getText();
			if (EntityName.equalsIgnoreCase(autoentityname)) {
				waitUntilElementVisible(driver, this.webappthreedotsdata.get(i));
				this.webappthreedotsdata.get(i).click();
				break;
			}
		}
		logger.info("Ending of pickEntityName Method");
	}

	public void entitySelectionCheckbox() throws InterruptedException {
		logger.info("Starting of selectCustomertoExport Method");
		Thread.sleep(500);
		scrollDown(100, scrollform);
		for (int i = 0; i<=4; i++) {
			waitUntilElementVisible(driver, this.entityselectcheckbox.get(i));
			this.entityselectcheckbox.get(i).click();
		}

		logger.info("Ending of selectCustomertoExport Method");
	}

	public void selectEntityExportSelected() throws InterruptedException {
		logger.info("Starting of entityExportSelected Method");
		waitUntilElementVisible(driver, this.entityexportimportoption);
		this.entityexportimportoption.click();
		waitUntilElementVisible(driver, this.exportSelected);
		this.exportSelected.click();
		Thread.sleep(1000);
		this.refresh();
		logger.info("Ending of entityExportSelected Method");
	}

	public void selectEntityExportAll() throws InterruptedException {
		logger.info("Starting of entityExportAll Method");
		scrollDown(100, scrollform);
		waitUntilElementVisible(driver, this.entityexportimportoption);
		this.entityexportimportoption.click();
		waitUntilElementVisible(driver, this.entityexportall);
		this.entityexportall.click();
		Thread.sleep(1000);
		logger.info("Ending of entityExportAll Method");
	}

	public void clickOnFilters(String filterentityname) {
		logger.info("Starting of clickOnFilters Method");
		waitUntilElementVisible(driver, this.filters);
		this.filters.click();
		waitUntilElementVisible(driver, this.filtersentitynametextfield);
		this.filtersentitynametextfield.sendKeys(filterentityname);
		waitUntilElementVisible(driver, this.filtersapplybtn);
		this.filtersapplybtn.click();
		logger.info("Ending of clickOnFilters Method");
	}

	public void selectEntityExportFiltered() throws InterruptedException {
		logger.info("Starting of selectEntityExportFiltered Method");
		waitUntilElementVisible(driver, this.entityexportimportoption);
		this.entityexportimportoption.click();
		waitUntilElementVisible(driver, this.exportfiltered);
		this.exportfiltered.click();
		Thread.sleep(2000);
		logger.info("Ending of selectEntityExportFiltered Method");
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
