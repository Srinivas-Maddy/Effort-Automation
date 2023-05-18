package com.effort.works;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class AddWorkProcess extends BaseAutomationPage{
	
	private static final Logger logger=Logger.getLogger(AddWorkProcess.class);
	
	@FindBy(xpath="//a[contains(text(),'Web App')]")
	private WebElement webApp;
	
	@FindBy(id="work")
	private WebElement workModule;
	
	@FindBy(id="searchText")
	private WebElement searchBox;
	
	@FindBy(xpath="//h5[contains(text(),'Automation Action Procoss')]")
	private WebElement workName;
	
	@FindBy(xpath="//button[@id='addWorkBtn']")
	private WebElement addWorkBtn;
	
	@FindBy(xpath="//input[@id='fields0_fieldValue']")
	private WebElement workNamefield;
	
	@FindBy(xpath="//input[@id='fields2_fieldValueDateTime']")
	private WebElement workEndDate;
	
	@FindBy(xpath="(//div[@class='xdsoft_calendar'])[3]/table/tbody/tr/td")
	//(//div[@class='xdsoft_calendar'])[3]/table/tbody/tr/td/div
	private List<WebElement> dateTimes;
	
	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;
	
	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;
		

	public AddWorkProcess(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	public void clickOnWebApp() {
		logger.info("Starting of clickOn WebApp method");
		waitUntilElementVisible(driver, this.webApp);
		this.webApp.click();
		logger.info("Ending of clicOnWebApp Method");
	}
	
	public void clickOnProcessModule() {
		logger.info("Starting of clickOnProcess module method");
		waitUntilElementVisible(driver, this.workModule);
        this.workModule.click();
		logger.info("Ending of clickOnProcess module method");
	}
	
	
	
	public void clickOnWorkName(){
		logger.info("Starting of click on work name method");
		waitUntilElementVisible(driver, this.searchBox);
		this.searchBox.sendKeys("Automation Action Procoss");
		waitUntilElementVisible(driver, this.workName);
		this.workName.click();
		logger.info("ending of click on work name method");
	}
	
	public void clickOnAddWorkBtn() {
		logger.info("Starting of clickOnAddWorkBtn method");
		waitUntilElementVisible(driver, this.addWorkBtn);
		this.addWorkBtn.click();
		logger.info("Ending of clickOnAddWorkBtn menthod");
	}
	
	public void enterWorkName(String workName) {
		logger.info("Starting of enterWorkName method");
		waitUntilElementVisible(driver, this.workNamefield);
		this.workNamefield.sendKeys(workName);
	}
	
	public void clickOnWorkEndDate() {
		logger.info("Starting of clickOnWorkEndDate method");
		waitUntilElementVisible(driver, this.workEndDate);
		this.workEndDate.click();
	}
	
	public void clickOnCurrentDateTime() throws InterruptedException {
		logger.info("Starting of clickOnCurrentDateTime method");
		//Get the current date as number
		String presentDate=getCurrentDateAsNumber();
		Thread.sleep(500);
		for(int i=0;i<=dateTimes.size()-1;i++) {
			Thread.sleep(100);
			String date=dateTimes.get(i).getText();
			if(dateTimes.get(i).getText().equalsIgnoreCase(presentDate)) {
				waitUntilElementVisible(driver, dateTimes.get(i));
				dateTimes.get(i).click();
				break;
			}
		}
		this.workEndDate.click();
		logger.info("Ending of clickOnDatePicker method");
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
