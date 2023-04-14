package com.effort.works;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class ActionProcess extends BaseAutomationPage{

	private static final Logger logger = Logger.getLogger(ActionProcess.class.getName());


	@FindBy(xpath = "//a[contains(text(),'App Builder')]")
	private WebElement configurator; 


	@FindBy(xpath = "//span[@class=\"fa fa-user\"]")
	private WebElement profileName;

	@FindBy(xpath = "//a[contains(text(),\" Switch to Configurator\")]")
	private WebElement switchToConfigurator;

	@FindBy(xpath = "//i[@class=\"fa fa-tasks\"]")
	private WebElement actionProcess;

	@FindBy(xpath = "//li[@title=\"Action Process\"]")
	private WebElement actionProcessCard;

	@FindBy(xpath = "//input[@value=\"Create Process \"]")
	private WebElement createProcess;	

	@FindBy(xpath = "//a[contains(text(),'Create On My Own')]")
	private WebElement createOnMyOwn;

	@FindBy(xpath = "//input[@id=\"workSpecTitle\"]")
	private WebElement processName;

	@FindBy(xpath = "//input[@id=\"nxtButton\"]")
	private WebElement nextButton;

	@FindBy(xpath = "//button[contains(text(),'Add Action')]")
	private WebElement addAction; 

	@FindBy(xpath = "//input[@name=\"workActionSpec[0].actionName\"]")
	private WebElement action1;

	@FindBy(xpath = "//span[contains(text(),'----Select Form---')]")
	private WebElement selectForm;

	@FindBy(xpath = "//div[contains(text(),'actionForm')]")
	private WebElement formSelection;

	@FindBy(xpath = "//input[@name=\"workActionSpec[1].actionName\"]")
	private WebElement action2;

	@FindBy(xpath = "//input[@value=\"Skip\"]")
	private WebElement skipButton;

	@FindBy(xpath = "//a[contains(text(),'Switch to Web App')]")
	private WebElement switchToWebapp;

	@FindBy(xpath = "//input[@id=\"searchText\"]")
	private WebElement searchWorks;

	@FindBy(xpath = "//h5[contains(text(),'Automation Work Process')]")
	private WebElement createdWork;

	@FindBy(xpath = "//a[contains(text(),'Automation Work Process')]")
	private WebElement selectWork;

	@FindBy(xpath = "//a[contains(text(),'Withdraw')]")
	private WebElement withdraw;

	//InitiMentod
	public ActionProcess(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnConfigurator() {
		logger.info("Starting of clickOnConfigurator method");

		this.implicitWait();
		this.configurator.click();

		logger.info("Ending of clickOnConfigurator method");
	}

	public void clickOnProfileName() {
		logger.info("Starting of clickOnProfileName method");

		this.implicitWait();
		this.profileName.click();

		logger.info("Ending of clickOnProfileName method");
	}
	public void clickOnToConfigurator() {
		logger.info("Starting of clickOnToConfigurator method");

		this.implicitWait();
		this.switchToConfigurator.click();

		logger.info("Ending of clickOnToConfigurator method");
	}
	public void clickOnToActionProcess() {
		logger.info("Starting of clickOnToActionProcess method");

		this.implicitWait();
		this.actionProcess.click();

		logger.info("Ending of clickOnToActionProcess method");
	}

	public void clickOnToActionProcessCard() {
		logger.info("Starting of clickOnToActionProcessCard method");

		this.implicitWait();
		this.actionProcessCard.click();

		logger.info("Ending of clickOnToActionProcessCard method");
	}

	public void clickOnCreateProcess() {
		logger.info("Starting of clickOnCreateProcess method");

		this.implicitWait();
		this.createProcess.click();

		logger.info("Ending of clickOnCreateProcess method");
	}

	public void clickOnMyOwn() {
		logger.info("Starting of clickOnMyOwn method");

		this.implicitWait();
		this.createOnMyOwn.click();

		logger.info("Ending of clickOnMyOwn method");
	}

	public void clickOnProcessName(String processName) {
		logger.info("Starting of clickOnProcessName method");

		this.implicitWait();
		this.processName.sendKeys(processName);

		logger.info("Ending of clickOnProcessName method");
	}

	public void clickOnNext() {
		logger.info("Starting of clickOnNext method");

		this.implicitWait();
		this.nextButton.click();

		logger.info("Ending of clickOnNext method");
	}

	public void clickOnAddAction() {
		logger.info("Starting of clickOnAddAction method");

		this.implicitWait();
		this.addAction.click();

		logger.info("Ending of clickOnAddAction method");
	}

	public void clickOnAction1(String startAction) {
		logger.info("Starting of clickOnAction1 method");

		this.implicitWait();
		this.action1.sendKeys(startAction);

		logger.info("Ending of clickOnAction1 method");
	}

	public void clickOnAction2(String endAction) {
		logger.info("Starting of clickOnAction2 method");

		this.implicitWait();
		this.action2.sendKeys(endAction);

		logger.info("Ending of clickOnAction2 method");
	}

	public void clickOnSelectForm() {
		logger.info("Starting of clickOnSelectForm method");

		this.implicitWait();
		this.selectForm.click();

		logger.info("Ending of clickOnSelectForm method");
	}

	public void clickOnForm() {
		logger.info("Starting of clickOnForm method");

		this.implicitWait();
		this.formSelection.click();

		logger.info("Ending of clickOnForm method");
	}

	public void clickOnSkipButton() {
		logger.info("Starting of clickOnSkipButton method");

		this.implicitWait();
		this.skipButton.click();

		logger.info("Ending of clickOnSkipButton method");
	}

	public void clickOnSwitchToWebapp() {
		logger.info("Starting of clickOnSwitchToWebapp method");

		this.implicitWait();
		this.switchToWebapp.click();

		logger.info("Ending of clickOnSwitchToWebapp method");
	}

	public void clickOnSearchWorks(String autoWork) {
		logger.info("Starting of clickOnSearchWorks method");

		this.implicitWait();
		this.searchWorks.sendKeys(autoWork);

		logger.info("Ending of clickOnSearchWorks method");
	}

	public void clickOnSearchWorks1(String withdrawWork) {
		logger.info("Starting of clickOnSearchWorks method");

		this.implicitWait();
		this.searchWorks.sendKeys(withdrawWork);

		logger.info("Ending of clickOnSearchWorks method");
	}
	public String getWorkText() {
		logger.info("Starting of getWorkText method");
		this.explicitWait(createdWork);
		logger.info("Ending of getWorkText method");

		return createdWork.getText();
	}

	public void clickOnSelectWork() {
		logger.info("Starting of clickOnSelectWork method");

		this.implicitWait();
		this.selectWork.click();

		logger.info("Ending of clickOnSelectWork method");
	}

	public void clickOnWithdraw() {
		logger.info("Starting of clickOnWithdraw method");

		this.implicitWait();
		this.withdraw.click();

		logger.info("Ending of clickOnWithdraw method");
	}


}