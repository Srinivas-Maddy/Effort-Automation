package com.effort.base;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(LoginPage.class.getName());

	@FindBy(xpath = "//input[@id=\"j_username\"]")
	private WebElement txtUserName;

	@FindBy(xpath = "//input[@id=\"password\"]")
	private WebElement txtPassword;

	@FindBy(xpath = "//button[@id=\"signInButton\"]")
	private WebElement btnLogin;

	@FindBy(xpath = "//a[text()='Web App']")
	private WebElement btnWebApp;
	
	@FindBy(xpath="//div[@id='invalidCredentialsMessage']")
	private WebElement txtInvalidMessage;

	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement btnUserName;

	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> btnlogout;

	@FindBy(xpath="//span[contains(text(),'Multiple active sessions detected')]")
	private WebElement multipleActiveSession;

	@FindBy(xpath="//button[contains(text(),'Sign out all other sessions')]")
	private WebElement btnSignOutAllSessions;
	
	@FindBy(xpath = "//a[contains(text(),'Web App')]")
	private WebElement webApp;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String name) {
		logger.info("Starting of enterUserName method");
		
     	waitUntilElementVisible(driver, this.txtUserName);
		this.txtUserName.click();
		this.txtUserName.sendKeys(name);
		
		logger.info("Ending of enterUserName method");
	}

	public void clickOnPassword(String password1) {
		logger.info("Starting of clickOnPassword method");
		
		waitUntilElementVisible(driver, this.txtPassword);
		this.txtPassword.sendKeys(password1);
		
		logger.info("Ending of clickOnPassword method");
	}

	public void clickOnLoginButton() {
		logger.info("Starting of clickOnLoginButton method");
		
		this.implicitWait();
		this.btnLogin.click();
		
		logger.info("Ending of clickOnLoginButton method");
	}

	public void clickOnWebApp() {
		logger.info("Starting of clickOnWebApp method");
		
		waitUntilElementVisible(driver, btnWebApp);
		btnWebApp.click();
		
		logger.info("Ending of clickOnWebApp method");

	}
	
	public void ClickonWebApp() {
		logger.info("Starting of Click on Web App Method");
		
		waitUntilElementVisible(driver, webApp);
		this.webApp.click();
		
		logger.info("Ending of Click on Web App Method ");

	}
	
	public void logOut() {
		logger.info("Starting of Logout method");
		
		waitUntilElementVisible(driver, btnUserName);
		btnUserName.click();
		if(btnlogout.get(btnlogout.size()-1).getText().equalsIgnoreCase("Logout")) {
			btnlogout.get(btnlogout.size()-1).click();
		}
		
		logger.info("Ending of Logout method");
	}
}

