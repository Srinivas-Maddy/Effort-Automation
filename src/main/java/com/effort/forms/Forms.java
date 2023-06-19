package com.effort.forms;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.effort.base.BaseAutomationPage;

public class Forms extends BaseAutomationPage{

	private static final Logger logger = Logger.getLogger(Forms.class.getName());
	public static String formSpecName;

	@FindBy(xpath="//a[text()='App Builder']")
	private WebElement configurator;

	@FindBy(xpath="//li[@id='forms']")
	private WebElement formsModuleNavbar;

	@FindBy(xpath="//input[@value='Create Form']")
	private WebElement createFormBtn;

	@FindBy(xpath="(//div[@id='popupDetails']/div/div/div)[1]")
	private WebElement createOnMyOwn;
	
	@FindBy(id="formTitle")
	private WebElement formTitle;
	
	@FindBy(id="showHelpText")
	private WebElement formSpecHelpText;
	
	@FindBy(xpath="//span[@class='fieldLabel']")
	private List<WebElement> fieldLabels;
	
	@FindBy(id="myInput")
    private WebElement labelSearch;
	
	@FindBy(xpath="//ul[@id='formFields-0']")
	private WebElement dropedArea;
	
	@FindBy(xpath="//span[@id='pageLabel-0']")
	private WebElement page;
	
	@FindBy(id="publishButton")
	private WebElement publishBtn;
	
	@FindBy(id="customerActivityFormNo")
	private WebElement customerActvitiyNoBtn;
	
	@FindBy(xpath="//a[contains(text(),'Modify Design')]")
	private WebElement modifyCard;
	
	@FindBy(xpath="//ul[@class='list-group fieldType-group basic']/li[2]")
	private WebElement addCurrencyField;
	
	@FindBy(id="save1")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@id='search']")
	private WebElement goBackFormModule;
	
	@FindBy(id="searchText")
	private WebElement formSpecSearch;
	
	@FindBy(xpath="//a[contains(text(),'Withdraw')]")
	private WebElement withDrawnCard;
	
	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu']/li)[5]")
	private WebElement webAppBtn;
	
	@FindBy(id="forms")
	private WebElement formModule;
	
	@FindBy(id="searchText")
	private WebElement formSearch;
	
	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;
	
	@FindBy(xpath="//h3[@class='list-title']")
	private WebElement formName;
	

	//Default constructor 
	public Forms(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnConfigurator() {

		logger.info("Starting of clickOnConfigurator Method");
		this.configurator.click();
		logger.info("Ending of clickOnConfigurator Method");
	}

	public void clickOnFormsModuleNavBar() {
		logger.info("Starting of formsModuleNavBar method");
		this.formsModuleNavbar.click();
		logger.info("End of formsModuleNavBar");
	}

	public void clickOnCreateForm() {
		logger.info("Starting of Create own form  method");
		waitUntilElementVisible(driver, createFormBtn);
		this.createFormBtn.click();
		waitUntilElementVisible(driver, createOnMyOwn);
		createOnMyOwn.click();
		logger.info("End of create form");
	}
	
	public String formTitle(String title, String helpText) {
		logger.info("Starting of formsModuleNavBar method");
        waitUntilElementVisible(driver, formTitle);
        formSpecName=title+"_"+getCurrentDateTime();
		formTitle.sendKeys(formSpecName);
		waitUntilElementVisible(driver, formSpecHelpText);
		formSpecHelpText.sendKeys(helpText+"_"+getCurrentDateTime());
		return formSpecName;
		
	}
	
	public void selectAllFields() throws InterruptedException {
		logger.info("Starting of select all fields method");
		
		List<String> ignoreDatatypes=new ArrayList<String>();
		ignoreDatatypes.add("Multi Pick List");
		ignoreDatatypes.add("Multi Select Dropdown");
		ignoreDatatypes.add("Dropdown");
		ignoreDatatypes.add("Datespan");
		ignoreDatatypes.add("DateTimespan");
		ignoreDatatypes.add("Location diff");
		ignoreDatatypes.add("Number To Word");
		ignoreDatatypes.add("Timespan");
		ignoreDatatypes.add("Repeatable Section");
		ignoreDatatypes.add("Fields Group");
		ignoreDatatypes.add("Audio (Read Only)");
		ignoreDatatypes.add("Document (Read Only)");
		ignoreDatatypes.add("Image (Read Only)");
		ignoreDatatypes.add("URL (Read Only)");
		ignoreDatatypes.add("Video (Read Only)");
		
		int count=0;
		for (int i=0; i<fieldLabels.size();i++) {
		
			if(ignoreDatatypes.contains(fieldLabels.get(i).getText())) {
				continue;
			}else {
				waitUntilElementVisible(driver, fieldLabels.get(i));
				Actions action=new Actions(driver);
				waitUntilElementVisible(driver, dropedArea);
				action.dragAndDrop(fieldLabels.get(i), dropedArea).perform();
				scrollDown(100,dropedArea);
				Thread.sleep(2000);
				if(count==0){
					continue;
				}else{
					driver.findElement(By.xpath("//input[@id='formFieldSpecs"+count+"_isRequired']")).click();	
				}
				count++;		
			}

		}
		waitUntilElementVisible(driver, publishBtn);
		publishBtn.click();
		waitUntilElementVisible(driver, customerActvitiyNoBtn);
		customerActvitiyNoBtn.click();
		waitUntilConfiramtionAlert(driver);
		driver.switchTo().alert().accept();
		logger.info("Ending of form spec creation");

		
	}
	
	
	public String formSpecValidation() {
		logger.info("Starting of formSpecValidation method");
		String createdFormSpecName=driver.findElement(By.xpath("//h4[contains(text(),'"+formSpecName+"')]")).getText();
		logger.info("Starting of formSpecValidation method");
		return createdFormSpecName;				
	}
	
	
	public void formSpecModification() {
		logger.info("Starting of formSpecModification method");
		waitUntilElementVisible(driver, this.modifyCard);
		this.modifyCard.click();
		waitUntilElementVisible(driver, this.addCurrencyField);
		Actions action=new Actions(driver);
		action.dragAndDrop(this.addCurrencyField, this.dropedArea);
		waitUntilElementVisible(driver, this.saveBtn);
		this.saveBtn.click();
		driver.switchTo().alert().accept();
		logger.info("Ending of formSpecModification method");
	}
	
	public void withDrawnForm() {
		logger.info("Starting of withDranForm method");
        waitUntilElementVisible(driver, goBackFormModule);
		goBackFormModule.click();
		waitUntilElementVisible(driver, this.formSearch);
		this.formSearch.sendKeys(formSpecName);
		driver.findElement(By.xpath("//a[contains(text(),'"+formSpecName+"')]")).click();
		waitUntilElementVisible(driver, this.withDrawnCard);
		this.withDrawnCard.click();
		driver.switchTo().alert().accept();
		logger.info("Starting of withDranForm method");
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
