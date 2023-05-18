package com.effort.exports;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class EmployeeExportPage extends BaseAutomationPage{

	private static final Logger logger=Logger.getLogger(EmployeeExportPage.class);

	@FindBy(xpath="//a[contains(text(),'Web App')]")
	private WebElement webApp;

	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;

	@FindBy(xpath="(//a[contains(text(),' Employees')])[1]")
	private WebElement employeeModule;

	@FindBy(xpath="//button[contains(text(),'Export & Import Options')]")
	private WebElement exportOptions;

	@FindBy(xpath="//ul[@id='additional-options']/li[3]/form/a[1]")
	private WebElement exportAll;

	@FindBy(xpath="//div[@class='jconfirm-buttons']/button[1]")
	private WebElement confirmBtn;

	@FindBy(xpath="//div[@class='centered']/div[2]")
	private WebElement confirmationMessage;

	public EmployeeExportPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}



	public void clickOnWebApp() {
		logger.info("Starting of clickOn WebApp method");
		waitUntilElementVisible(driver, this.webApp);
		this.webApp.click();
		logger.info("Ending of clicOnWebApp Method");
	}

	public void clickOnEmployeeModule(){
		logger.info("Starting of click on Employee method");
		waitUntilElementVisible(driver, this.employeeModule);
		this.employeeModule.click();
		logger.info("Ending of employee method");
	}

	public void clickOnExportOptions() {
		logger.info("Starting of clickOnExportOptions method");
		waitUntilElementVisible(driver, this.exportOptions);
		scrollDown(100, this.exportOptions);
		this.exportOptions.click();
		logger.info("Ending of clickOnExportOptions method");	
	}

	public void clickOnExportAll() {
		logger.info("Starting of clickOnExportAll method");
		waitUntilElementVisible(driver, this.exportAll);
		this.exportAll.click();
		logger.info("Ending of clickOnExportAll method");
	}

	public void clickOnConfirm() {
		logger.info("Starting of ClickOnConfirm");
		waitUntilElementVisible(driver, this.confirmBtn);
		this.confirmBtn.click();
		logger.info("Ending of ClickOnConfirm");
	}

	public void switchWindow(){
		logger.info("Starting of swtich window method");
		String parentWindow=driver.getWindowHandle();
		Set<String> multipleWindows=driver.getWindowHandles();
		Iterator<String> It= multipleWindows.iterator();
		while(It.hasNext()){
			String newWind=It.next();
			if(!parentWindow.equals(newWind)){
				driver.switchTo().window(newWind);
			}
		}		
	}

	public String getConfirmationMessage() {
		logger.info("Starting of getConfirmationMessage Method");
		waitUntilElementVisible(driver, this.confirmationMessage);
		String message=this.confirmationMessage.getText();
		return message;
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
