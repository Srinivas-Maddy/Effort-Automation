package com.effort.works;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(xpath="//input[@id='fields1_fieldValueDateTime']")
	private WebElement workStartDate;
	
	@FindBy(xpath="//input[@id='fields2_fieldValueDateTime']")
	private WebElement workEndDate;
	
	@FindBy(xpath="//div[contains(@style,'display: block; left')]/div/div/button[3]")
	private WebElement calenderMonthBtn;
	
	@FindBy(xpath="//div[contains(@style,'display: block; left')]/div[1]/div[2]/table/tbody/tr/td")
	private List<WebElement> dateTimes;
	
	@FindBy(id="availability_proceedAnyWay")
	private WebElement acceptBtn;
	
	@FindBy(xpath="(//div[@class='xdsoft_timepicker active'])[8]/div/div/div")
	private List<WebElement> timePickers;
	
	@FindBy(xpath="(//span[contains(text(),'Select Employee')])[3]")
	private WebElement assigneeDropdown;
	
	@FindBy(xpath="//input[@id='s2id_autogen319_search']")
	private WebElement enterName;
	
	@FindBy(xpath="//div[@id='select2-drop']/ul/li")
	private List<WebElement> employeeNames;
	
	@FindBy(xpath="//input[@id='save1']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[contains(text(),'Proceed Anyway')]")
	private WebElement btnProcessAnyway;

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
		hardWait(3);
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
		logger.info("Ending of enterWorkName menthod");
	}
			
	public void clickOnWorkEndDate() throws InterruptedException {
		logger.info("Starting of clickOnWorkEndDate method");
		waitUntilElementVisible(driver, this.workEndDate);
		Thread.sleep(10000);
		this.workEndDate.click();
		waitUntilElementVisible(driver, this.calenderMonthBtn);
		clickOnWebElement(this.calenderMonthBtn);
	}
	
	public void clickOnCurrentDateTime() throws InterruptedException {
		logger.info("Starting of clickOnCurrentDateTime method");
		//Get the current date as number
		String presentDate=getTomorrowDateAsNumber(1);
		for(int i=0;i<=dateTimes.size()-1;i++) {
			hardWait(2);
			String actualDate = (String) ((JavascriptExecutor)driver).executeScript("return $(arguments[0]).text();", dateTimes.get(i));
			if(actualDate.equalsIgnoreCase(presentDate)) {
				//clickOnWebElement(dateTimes.get(i));
				 waitUntilElementVisible(driver, dateTimes.get(i));
				 dateTimes.get(i).click();		 
				 break;
			}
		}
		this.workEndDate.click();
		logger.info("Ending of clickOnDatePicker method");
	}
	
	public void pickWorkEndDate() {
		logger.info("Starting of pickWorkEndDate Method");
		String currentTime=getCurrentTimeAsFiveMinInterval();
		for (int i = 0; i < timePickers.size(); i++){
			String timeIntervals=(String) ((JavascriptExecutor)driver).executeScript("return $(arguments[0]).text();", timePickers.get(i));
			if (timeIntervals.equalsIgnoreCase(currentTime)){
              waitUntilElementVisible(driver, timePickers.get(i));
              timePickers.get(i).click();
              break;
			}		
		}
		logger.info("Ending of pickerWorkEndDate Method");
	}
	
	public void assignEmplpoyee(String assigneeName) {
		logger.info("Starting of assign Employee");
		waitUntilElementVisible(driver, this.assigneeDropdown);
		this.assigneeDropdown.click();
		waitUntilElementVisible(driver, this.enterName);
		this.enterName.sendKeys(assigneeName);
		for (int i=0; i<employeeNames.size(); i++) {
			String actualEmpName= employeeNames.get(i).getText();
			if(actualEmpName.equalsIgnoreCase(assigneeName)) {
				waitUntilElementVisible(driver,employeeNames.get(i));
				employeeNames.get(i).click();
				break;
			}
		}		
		
	}
	

	public void clickOnSave() {
		logger.info("Starting of clickOnSave method");
		
        waitUntilElementVisible(driver, this.saveBtn);
        this.saveBtn.click();
        //Process Conflict Alert Handling
        try {
  		  waitUntilElementVisible(driver, this.btnProcessAnyway);
  		  this.btnProcessAnyway.click();
  		}catch(Exception e){
  			logger.info("Process Anyway Btn is not visible");
  		}
        //Employee OnLeave Alert Handle
        try{
        	if(this.acceptBtn.isDisplayed()) {
    			this.acceptBtn.click();
    			}
        }catch(Exception e) {
           logger.info("On Leave Alert was not displayed");	
        }
        
		logger.info("Ending of clickOnSave method");
	}
	
	public void logOut() {
		logger.info("Starting of Logout method");
		hardWait(3);
		waitUntilElementVisible(driver, userNameBtn);
		userNameBtn.click();
		if(logoutBtn.get(logoutBtn.size()-1).getText().equalsIgnoreCase("Logout")) {
			logoutBtn.get(logoutBtn.size()-1).click();
		}
		logger.info("Ending of Logout method");
	}

}
