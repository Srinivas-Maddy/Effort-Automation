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

	@FindBy(xpath = "(//ul[@id='orderedUl']/li)[10]/a")
	private WebElement webappthreedots;
	
	@FindBy(xpath="//ul[@id='orderedUl']/li/a")
    private List<WebElement> navigationBar;	

	@FindBy(xpath = "(//ul[@class='dropdown-menu'])[1]/li")
	private List<WebElement> webappthreedotsdata;

	@FindBy(xpath = "(//button[contains(@class,'btn-block')])[2]")
	private WebElement entityexportimportoption;

	@FindBy(xpath = "(//ul[@class='dropdown-menu btn-block'])[2]/li[2]")
	private WebElement exportSelected;
	
	@FindBy(xpath="//div[@id='progress']")
	private WebElement exportSelectedStatusMsg;

	@FindBy(xpath = "(//div[@class='container-fluid bg-1'])[2]")
	private WebElement scrollform;

	@FindBy(xpath = "//table[@id='example']/tbody/tr/td[1]")
	private List<WebElement> entityselectcheckbox;
	
	@FindBy(xpath="(//input[@id='selecctall'])[1]")
	private WebElement selctedAllCheckBox;

	@FindBy(xpath = "(//ul[@class='dropdown-menu btn-block'])[2]/li[3]")
	private WebElement entityexportall;
	
	@FindBy(xpath = "(//div[@class='jconfirm-buttons']/button)[1]")
	private WebElement entityexportallconfirmbtn;
	
	@FindBy(xpath="//a[text()='Click here to see the status of report']")
	private WebElement exportAllStatusMes;

	@FindBy(id = "filters")
	private WebElement filters;

	@FindBy(xpath = "(//div[text()='Entity Name'])[2]/input")
	private WebElement filtersentitynametextfield;

	@FindBy(id = "search")
	private WebElement filtersapplybtn;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu btn-block'])[2]/li[4]")
	private WebElement exportfiltered;
	
	@FindBy(xpath="//div[@id='progress']")
	private WebElement filterSeletedStatusMsg;
	
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
		hardWait(3);
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
	
	public void clickOnEntityModule() {
		logger.info("Starting of click On entity module");
		for (int i = 0; i <this.navigationBar.size(); i++){
			String navNames=this.navigationBar.get(i).getText();
			if(navNames.equalsIgnoreCase("Automation Entity teju1")) {
				waitUntilElementVisible(driver, this.navigationBar.get(i));
				this.navigationBar.get(i).click();
				break;
			}
			
		}
		logger.info("Ending of click On entity module");
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
	
	public void selectAllEntityCheckBox() throws InterruptedException {
		Thread.sleep(2000);
		waitUntilElementVisible(driver, this.selctedAllCheckBox);
		scrollDown(0, this.selctedAllCheckBox);
		this.selctedAllCheckBox.click();
	}

	public String selectEntityExportSelected() throws InterruptedException {
		logger.info("Starting of entityExportSelected Method");
		waitUntilElementVisible(driver, this.entityexportimportoption);
		this.entityexportimportoption.click();
		waitUntilElementVisible(driver, this.exportSelected);
		this.exportSelected.click();
		waitUntilElementVisible(driver, this.exportSelectedStatusMsg);
		Thread.sleep(8000);
		String statusMsg=this.exportSelectedStatusMsg.getText();
		logger.info("Ending of entityExportSelected Method");
		return statusMsg;
	}

	public String selectEntityExportAll() throws InterruptedException {
		logger.info("Starting of entityExportAll Method");
	    scrollDown(100, this.entityexportimportoption);
		waitUntilElementVisible(driver, this.entityexportimportoption);
		this.entityexportimportoption.click();
		waitUntilElementVisible(driver, this.entityexportall);
		this.entityexportall.click();
		waitUntilElementVisible(driver, this.entityexportallconfirmbtn);
		this.entityexportallconfirmbtn.click();
		Thread.sleep(2000);
//		waitUntilElementVisible(driver, this.confirmBtn);
//		this.confirmBtn.click();
//		Thread.sleep(2000);
		waitUntilElementVisible(driver, this.exportAllStatusMes);
		String acutulExportAllStatus=this.exportAllStatusMes.getText();
		logger.info("Ending of entityExportAll Method");
		return acutulExportAllStatus;
	}

	public void clickOnFilters(String filterentityname)  {
		logger.info("Starting of clickOnFilters Method");
		scrollDown(100, filters);
		waitUntilElementVisible(driver, this.filters);
	    scrollDown(500,this.filters);
     	waitUntilElementVisible(driver, this.filters);
		this.filters.click();
		waitUntilElementVisible(driver, this.filtersentitynametextfield);
		this.filtersentitynametextfield.sendKeys(filterentityname);
		waitUntilElementVisible(driver, this.filtersapplybtn);
		this.filtersapplybtn.click();
		logger.info("Ending of clickOnFilters Method");
	}

	public String selectEntityExportFiltered() throws InterruptedException {
		logger.info("Starting of selectEntityExportFiltered Method");
		waitUntilElementVisible(driver, this.entityexportimportoption);
		this.entityexportimportoption.click();
		waitUntilElementVisible(driver, this.exportfiltered);
		this.exportfiltered.click();
		Thread.sleep(5000);
		//Thread.sleep(2000);
		waitUntilElementVisible(driver, this.filterSeletedStatusMsg);
		String exportFilterStatus=this.filterSeletedStatusMsg.getText();
		logger.info("Ending of selectEntityExportFiltered Method");
		return exportFilterStatus;
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
