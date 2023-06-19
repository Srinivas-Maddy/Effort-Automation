package com.effort.login;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class WebAppLogins extends BaseAutomationPage{

	private static final Logger logger = Logger.getLogger(WebAppLogins.class.getName());


	public WebAppLogins(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id=\"j_username\"]")
	private WebElement username;

	@FindBy(xpath = "//input[@id=\"password\"]")
	private WebElement password;

	@FindBy(xpath = "//button[@id=\"signInButton\"]")
	private WebElement loginButton;

	@FindBy(xpath = "//a[text()='Web App']")
	private WebElement webApp;

	@FindBy(xpath="//div[@id='invalidCredentialsMessage']")
	private WebElement invalidMessage;

	@FindBy(xpath="//a[contains(text(),'App Builder')]")
	private WebElement appBuilder;
	
	@FindBy(xpath="//a[contains(text(),'Reports Studio')]")
	private WebElement reportStudio;


	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;

	@FindBy(xpath="//span[contains(text(),'Multiple active sessions detected')]")
	private WebElement multipleActiveSession;


	@FindBy(xpath="//button[contains(text(),'Sign out all other sessions')]")
	private WebElement signOutAllSessions;


	public void enterUserName(String name) {
		logger.info("Starting of enterUserName method");
		waitUntilElementVisible(driver, this.username);
		this.username.click();
		this.username.sendKeys(name);
		logger.info("Ending of enterUserName method");
	}


	public void clickOnPassword(String password1) {
		logger.info("Starting of clickOnPassword method");
		waitUntilElementVisible(driver, this.password);
		this.password.sendKeys(password1);
		logger.info("Ending of clickOnPassword method");
	}

	public void clickOnLoginButton() {
		logger.info("Starting of clickOnLoginButton method");
		this.implicitWait();
		this.loginButton.click();
		logger.info("Ending of clickOnLoginButton method");
	}


	public String getErrorMessage() {
		waitUntilElementVisible(driver, this.invalidMessage);
		String errorMsg=this.invalidMessage.getText();
		return errorMsg;
	}

	public void clickOnWebApp() {
		logger.info("Starting of WebApp method");
		waitUntilElementVisible(driver, webApp);
		webApp.click();
		logger.info("Ending of Web App method");

	}

	public void clickOnAppBuilder() {
		logger.info("Starting of app builder");
		waitUntilElementVisible(driver, this.appBuilder);
		this.appBuilder.click();
		logger.info("Ending of app builder");
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
