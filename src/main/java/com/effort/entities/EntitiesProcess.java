package com.effort.entities;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.effort.base.BaseAutomationPage;


public class EntitiesProcess extends BaseAutomationPage {

	public static final Logger logger = Logger.getLogger(EntitiesProcess.class.getName());
	
	public static String name;
	
	@FindBy(xpath = "//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath = "//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;
	
	@FindBy(xpath = "//li/h5/a[text()='App Builder']")
	private WebElement appbuilder;

	@FindBy(id = "customEntity")
	private WebElement entities;
	
	@FindBy(id="configureCustomEntitySpecs")
	private WebElement createentitycard;
	
	@FindBy(id="customEntitySpecTitle")
	private WebElement specentityname;
	
	@FindBy(id="description")
	private WebElement entitydescription;
	
	@FindBy(id="nxtButton")
	private WebElement nextbtn;
	
	@FindBy(xpath="//div[@id='searchDataType']/ul[position()<last() - 1]/li[contains(@class,'btn-block')]")
	private List<WebElement> alldatatypefields;
	
	@FindBy(xpath="//span[contains(text(),'Multi Select Dropdown')]")
	private WebElement MultiDropdown;
	
	@FindBy(id="formFields-0")
	private WebElement dropdownarea;
	
	@FindBy(id="li_6")
	private WebElement currency;
	
	@FindBy(id="enableCustomEntityCheckInPop")
	private WebElement entitycheckinbox;
	
	@FindBy(id="dayPlanAllowdPop")
	private WebElement allowdayplancheckinbox;
	
	@FindBy(xpath="//input[@class='btn sqbtn skip']")
	private WebElement skipbutn;
	
	@FindBy(id="enforceCustomEntityCheckIn")
	private WebElement checkinbutn;
	
	@FindBy(id="locationMandatoryCheckForCustomEntity")
	private WebElement checktoperformbutn;
	
	@FindBy(id="enableProximityForCustomEntityCheckIn")
	private WebElement proximitycheckin;
	
	@FindBy(id="forceCustomEntityCheckInCheckOut")
	private WebElement forcedcheckin;
	
	@FindBy(xpath="(//tr[@id='customerCheckOut']/td)[2]/input")
	private WebElement proximitycheckout;
	
	@FindBy(id="forceCustomEntityCheckOut")
	private WebElement forcedcheckout;
	
	@FindBy(id="webAppDisplay")
	private WebElement displaywebapp ;
	
	@FindBy(id="mobileDisplay")
	private WebElement displaymobileapp ;
	
	@FindBy(id="appName")
	private WebElement selectdefaultwebappname;
	
	@FindBy(xpath="//input[@name='appNameForMobile']")
	private WebElement selectdefaultmobileappname;
	
	@FindBy(xpath="(//ul[@class='formspecActionsConfig']/li)[1]")
	private WebElement modifyentityspeccard;
	
	@FindBy(id ="customEntitySpecTitle")
	private WebElement modifyspecentityname;
	
	@FindBy(id ="description")
	private WebElement modifyspecentitydescription;
	
	@FindBy(xpath="//input[@class='btn buttonStyle']")
	private WebElement modifyspecentitysavebtn;
	
	@FindBy(xpath="(//ul[@class='formspecActionsConfig']/li)[9]")
	private WebElement withdrawspecentitycard;
	
	@FindBy(id="logout_id")
	private WebElement username;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu'])[2]/li[4]/a[text()=' Switch to Web App ']")
	private WebElement switchwebapp;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu'])[2]/li[5]/a[text()=' Switch to App Builder (Admin)']")
	private WebElement switchappbuilder;
	
	@FindBy(xpath="(//ul[@class='entityConfig']/li)[2]")
	private WebElement manageentity;

	

	
	public EntitiesProcess(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickonAppBuilder() {
		logger.info("Starting of clickonAppBuilder Method");
		waitUntilElementVisible(driver, this.appbuilder);
		this.appbuilder.click();
		logger.info("Ending of clickonAppBuilder Method");
	}

	public void clickonEntities() {
		logger.info("Starting of clickonEntities Method");
		waitUntilElementVisible(driver, entities);
		this.entities.click();
		logger.info("Ending of clickonEntities Method");
	}
	
	public void clickonCreateEntity() {
		logger.info("Starting of clickonCreateEntity Method");
		waitUntilElementVisible(driver, this.createentitycard);
		this.createentitycard.click();	
		logger.info("Ending of clickonCreateEntity Method");
	}
	
	public void enterEntityName(String EntityName) {
		logger.info("Starting of enterEntityName Method");
		waitUntilElementVisible(driver, this.specentityname);
		name=getUniqueNumber(EntityName);
		this.specentityname.sendKeys(name);	
		logger.info("Ending of enterEntityName Method");
	}
	
	public void enterEntityDescription(String EntityDescription) {
		logger.info("Starting of enterEntityDescription Method");
		waitUntilElementVisible(driver, this.entitydescription);
		this.entitydescription.sendKeys(EntityDescription);	
		waitUntilElementVisible(driver, this.nextbtn);
		this.nextbtn.click();
		logger.info("Ending of enterEntityDescription Method");
	}
	
	public void clickonNextButton() {
		logger.info("Starting of clickonNextButton Method");
		waitUntilElementVisible(driver, this.nextbtn);
		this.nextbtn.click();
		logger.info("Ending of clickonNextButton Method");
	}
	
	public void selectAllFields() throws InterruptedException {
		logger.info("Starting of selectAllFields Method");
		for(int i =0 ;i<alldatatypefields.size();i++) {
			waitUntilElementVisible(driver, this.alldatatypefields.get(i));
			Actions action = new Actions(driver);
			waitUntilElementVisible(driver, this.dropdownarea);
			action.dragAndDrop(this.alldatatypefields.get(i), this.dropdownarea).build().perform();
			scrollDown(100, alldatatypefields.get(i));
			Thread.sleep(1000);			
			}		
		logger.info("Ending of selectAllFields Method");
	}
					
	public void selectEntityCheckboxs() {
		logger.info("Starting of selectEntityCheckinboxs Method");
		waitUntilElementVisible(driver, this.entitycheckinbox);
		this.entitycheckinbox.click();
		waitUntilElementVisible(driver, allowdayplancheckinbox);
		this.allowdayplancheckinbox.click();
		this.nextbtn.click();
		driver.switchTo().alert().accept();
		waitUntilElementVisible(driver,this.nextbtn);
		this.nextbtn.click();	
		logger.info("Ending of selectEntityCheckinboxs Method");
	}
	
	public void clickOnSkipButton() {
		logger.info("Starting of clickOnSkipButton Method");
		waitUntilElementVisible(driver, skipbutn);
		this.skipbutn.click();
		logger.info("Starting of clickOnSkipButton Method");
	}
	
	public void selectCheckinActivitytoPerform() throws InterruptedException {
		logger.info("Starting of selectCheckinActivity Method");
		waitUntilElementVisible(driver, this.checkinbutn);
		this.checkinbutn.click();
		waitUntilElementVisible(driver, checktoperformbutn);
		this.checktoperformbutn.click();
		waitUntilElementVisible(driver, proximitycheckin);
		this.proximitycheckin.click();
		waitUntilElementVisible(driver, forcedcheckin);
		this.forcedcheckin.click();
		waitUntilElementVisible(driver, proximitycheckout);
		this.proximitycheckout.click();
		waitUntilElementVisible(driver, forcedcheckout);
		this.forcedcheckout.click();
		Actions action = new Actions(driver);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='90%'");
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", this.nextbtn);
		driver.switchTo().alert().accept();
		logger.info("Ending of selectCheckinActivity Method");	
	}
	
	public void selectWebandMobileCheckbox() {
		
		logger.info("Starting of selectWebandMobileCheckbox Method");
		waitUntilElementVisible(driver, this.displaywebapp);
		this.displaywebapp.click();
		waitUntilElementVisible(driver, this.selectdefaultwebappname);
		this.selectdefaultwebappname.click();
		waitUntilElementVisible(driver, this.displaymobileapp);
		this.displaymobileapp.click();
		waitUntilElementVisible(driver, this.selectdefaultmobileappname);
		this.selectdefaultmobileappname.click();
		scrollDown(50, this.nextbtn);
		waitUntilElementVisible(driver, this.nextbtn);
		this.nextbtn.click();
		logger.info("Ending of selectWebandMobileCheckbox Method");
	}
	
	public void clickOnModifyEntitySpec() {
		logger.info("Starting of clickOnModifyEntitySpec Method");
		waitUntilElementVisible(driver, this.modifyentityspeccard);
		this.modifyentityspeccard.click();	
		logger.info("Ending of clickOnModifyEntitySpec Method");
		}
	
	public void enterModifiedName(String modifyname) {
		logger.info("Starting of enterModifiedName Method");
		waitUntilElementVisible(driver, this.modifyspecentityname);
		this.modifyspecentityname.clear();
		this.modifyspecentityname.sendKeys(modifyname);
		logger.info("Ending of enterModifiedName Method");
		
	}
	
	public void enterModifiedDescription(String modifydescription) {
		logger.info("Starting of enterModifiedDescription Method");
		waitUntilElementVisible(driver, this.modifyspecentitydescription);
		this.modifyspecentitydescription.clear();
		this.modifyspecentitydescription.sendKeys(modifydescription);
		waitUntilElementVisible(driver, this.modifyspecentitysavebtn);
		this.modifyspecentitysavebtn.click();
		logger.info("Ending of enterModifiedDescription Method");
	}
	
	public void deleteEntitySpec() throws InterruptedException {
		logger.info("Starting of deleteEntitySpec Method");
		Thread.sleep(1000);
		scrollDown(100, this.withdrawspecentitycard);
		waitUntilElementVisible(driver, this.withdrawspecentitycard);
		this.withdrawspecentitycard.click();
		driver.switchTo().alert().accept();	
		logger.info("Ending of deleteEntitySpec Method");
		
		}
	
	public void clickOnSwitchToWebApp() {
		logger.info("Starting of clickOnSwitchToWebApp Method");
		waitUntilElementVisible(driver, this.username);
		this.username.click();
		waitUntilElementVisible(driver, this.switchwebapp);
		this.switchwebapp.click();
		logger.info("Ending of clickOnSwitchToWebApp Method");		
	}
	
	public void logOutEntitites() {
		logger.info("Starting of logOutEntitites Method");	
		waitUntilElementVisible(driver, userNameBtn);
		userNameBtn.click();
		if (logoutBtn.get(logoutBtn.size() - 1).getText().equalsIgnoreCase("Logout"))
		logoutBtn.get(logoutBtn.size() - 1).click();	
		logger.info("Ending of logOutEntitites Method");
	}

}
