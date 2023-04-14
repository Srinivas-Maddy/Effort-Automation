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
	
	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;
	
	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;
	
	
	@FindBy(id="work")
	private WebElement workModule;

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
