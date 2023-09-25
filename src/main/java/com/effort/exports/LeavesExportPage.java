package com.effort.exports;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class LeavesExportPage extends BaseAutomationPage {
	private static Logger logger = Logger.getLogger(LeavesExportPage.class.getName());
	
	@FindBy(xpath = "//a[contains(text(),'Web App')]")
	private WebElement webApp;
	
	@FindBy(xpath = "//a[text()=' Leaves']")
	private WebElement leaves;
	
	@FindBy(xpath="//li[@id='dots']/a")
	private WebElement threeDots;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu'])[1]/li/a")
	private List<WebElement> threeDotList;
	
	@FindBy(xpath = "//button[contains(@class,'btn-block')]")
	private WebElement leavesexportimportoption;

	@FindBy(xpath = "(//ul[@class='dropdown-menu btn-block']/li)[1]/a")
	private WebElement leavesexportall;
	
	@FindBy(xpath = "(//div[@class='container-fluid bg-1'])[2]")
	private WebElement scrollform;
	
	@FindBy(xpath = "//table[@id='example']/tbody/tr/td[1]")
	private List<WebElement> leavescheckbox;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu btn-block']/li)[2]/a")
	private WebElement leavesexportselected;
	
	@FindBy(xpath="//a[@id='filters']")
	private WebElement leavesfilters;
	
	@FindBy(xpath = "(//div[@class='select2-container select2-container-multi form-control'])[1]")
	private WebElement leavesempnamefield;

	@FindBy(xpath = "(//ul[@class='select2-choices'])[1]/li/input")
	private WebElement leavesempnameinputfield;
	
	@FindBy(xpath = "(//ul[@class='select2-results'])[3]/li/div/span")
	private List<WebElement> leavesempnamesdata;
	
	@FindBy(xpath="//a[@id='search']")
	private WebElement filtersapplybtn;
	
	@FindBy(xpath="//a[@id='reset']")
	private WebElement filtersresetbtn;

	@FindBy(xpath="(//ul[@class='dropdown-menu btn-block']/li)[3]/a")
	private WebElement leavesexportfiltered;
	
	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;
	
	public LeavesExportPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void ClickonWebApp() {
		logger.info("Starting of ClickonWebApp Method");
		waitUntilElementVisible(driver, this.webApp);
		this.webApp.click();
		logger.info("Ending of ClickonWebApp Method");
	}
	
	public void clickOnThreeDots() {
		logger.info("Starting of clickOnThreeDots Method");
		waitUntilElementVisible(driver, this.threeDots);
		this.threeDots.click();
		logger.info("Ending of clickOnThreeDots Method");
	}
	
	public void clickOnLeaves(String leaves) {
		logger.info("Starting of clickOnLeaves method");
		for (int i = 0; i < this.threeDotList.size(); i++) {
			String listNames=this.threeDotList.get(i).getText();
			if(listNames.equalsIgnoreCase(leaves)){
				waitUntilElementVisible(driver, this.threeDotList.get(i));
				this.threeDotList.get(i).click();
				break;
			}
		}
	}
	
	/*
	 * public void clickOnLeaves() {
	 * logger.info("Starting of clickOnLeaves Method");
	 * waitUntilElementVisible(driver, this.leaves); this.leaves.click();
	 * logger.info("Ending of clickOnLeaves Method"); }
	 */
	
	public void selectLeavesExportAll()  {
		logger.info("Starting of selectLeavesExportAll Method");
		waitUntilElementVisible(driver, this.leavesexportimportoption);
		this.leavesexportimportoption.click();
		waitUntilElementVisible(driver, this.leavesexportall);
		this.leavesexportall.click();
		logger.info("Ending of selectLeavesExportAll Method");
	}
	
	public void selectLeavesExportSelected() throws InterruptedException  {
		logger.info("Starting of selectLeavesExportSelected Method");
		Thread.sleep(1000);
		scrollDown(100, this.scrollform);
		for(int i =0 ; i<=3 ; i++) {
			this.leavescheckbox.get(i).click();
		}
		waitUntilElementVisible(driver, this.leavesexportimportoption);
		this.leavesexportimportoption.click();
		waitUntilElementVisible(driver, this.leavesexportselected);
		this.leavesexportselected.click();
		logger.info("Ending of selectLeavesExportSelected Method");
	}
	
	public void selectLeavesExportFiltered(String leavesexportempname,String passedleavesexportempname) {
		logger.info("Starting of selectLeavesExportFiltered Method");
		waitUntilElementVisible(driver, this.leavesfilters);
		this.leavesfilters.click();
		waitUntilElementVisible(driver, this.filtersresetbtn);
		this.filtersresetbtn.click();
		waitUntilElementVisible(driver, this.filtersapplybtn);
		this.filtersapplybtn.click();
		waitUntilElementVisible(driver, this.leavesfilters);
		this.leavesfilters.click();
		waitUntilElementVisible(driver, this.leavesempnameinputfield);
		this.leavesempnameinputfield.click();
		this.leavesempnameinputfield.sendKeys(leavesexportempname);
		for(int i = 0;i<this.leavesempnamesdata.size();i++){
		String leavesname = this.leavesempnamesdata.get(i).getText();
		if(leavesname.equalsIgnoreCase(passedleavesexportempname)){
			waitUntilElementVisible(driver, this.leavesempnamesdata.get(i));
			this.leavesempnamesdata.get(i).click();
			break;
		}	
		}
		waitUntilElementVisible(driver, this.filtersapplybtn);
		this.filtersapplybtn.click();
		waitUntilElementVisible(driver, this.leavesexportimportoption);
		this.leavesexportimportoption.click();
		waitUntilElementVisible(driver, this.leavesexportfiltered);
		this.leavesexportfiltered.click();
		logger.info("Ending of selectLeavesExportFiltered Method");
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
