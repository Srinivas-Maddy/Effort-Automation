package com.effort.territories;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class TerritoriesPage extends BaseAutomationPage{

	private static final Logger logger = Logger.getLogger(TerritoriesPage.class.getName());

	@FindBy(xpath="//a[contains(text(),'App Builder')]")
	private WebElement appBuilderCard;

	@FindBy(xpath="//li[@id='territory']")
	private WebElement territoryModuleInNavBar;

	@FindBy(xpath="//li[@id='configureCustomerTypes']/span[3]/a")
	private List<WebElement> territoryConfigCards;

	@FindBy(xpath="//a[contains(text(),'Create Territory')]")
	private WebElement createTerritoryBtn;

	@FindBy(id="territoryName")
	private WebElement territoryNameInput;
	
	@FindBy(id="territoryNo")
	private WebElement territoryNoInput;
	
	@FindBy(id="save")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[contains(text(),'Saved successfully')]")
	private WebElement createdTerritoryConfirmation;
	
	@FindBy(xpath="//table[@id='allLeave']/tbody/tr[3]/td[3]/a[1]/img")
	private WebElement editBtn;
	
	@FindBy(xpath="//table[@id='allLeave']/tbody/tr[3]/td[3]/a[2]/img")
	private WebElement empMapBtn;
	
	@FindBy(xpath="//select[@class='unselected']")
	private WebElement unselectedEmpList;
	
	@FindBy(xpath="//div[@class='col-md-2 center-block']/button[2]/span")
	private WebElement moveRightSideArrow;
	
	@FindBy(xpath="//input[@value='Save']")
	private WebElement mappingSaveBtn;
	
	@FindBy(xpath="//table[@id='allLeave']/tbody/tr[3]/td[3]/a[3]/img")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//div[@id='s2id_type']")
	private WebElement typeDropdown;
	
	@FindBy(xpath="//ul[@id='select2-results-1']/li[2]/div")
	private WebElement circleTypeOption;
	
	@FindBy(xpath="//div[@id='map_canvas']/div/div[3]/div[3]/input")
	private WebElement searchLocationInput;
	
	@FindBy(xpath="//map[@id='gmimap0']")
	private WebElement mapLocation;
	
	//Constructor
	public TerritoriesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnAppBuilder() {
		logger.info("Starting of clickOnAppBuilder Method");

		waitUntilElementVisible(driver, this.appBuilderCard);
		try {
			clickOnWebElement(appBuilderCard);
		} catch (Exception e) {
			clickOnWebElementUsingJavascript(appBuilderCard);
		}

		logger.info("Ending of clickOnAppBuilder Method");
	}

	public void clickOnTerritoryModule() {
		logger.info("Starting of clickOnTerritoryModule Method");

		waitUntilElementVisible(driver, this.territoryModuleInNavBar);
		try {
			clickOnWebElement(this.territoryModuleInNavBar);
		} catch (Exception e) {
			clickOnWebElementUsingJavascript(this.territoryModuleInNavBar);
		}

		logger.info("Ending of clickOnTerritoryModule Method");
	}

	public void clickOnManageTerritories() {
		logger.info("Starting of clickOnManageTerritories Method");

		for (int i = 0; i < this.territoryConfigCards.size(); i++) {

			String cardName=this.territoryConfigCards.get(i).getText();
			if (cardName.contains("Manage Territories")) {
				waitUntilElementVisible(driver, this.territoryConfigCards.get(i));
				try {
					clickOnWebElement(this.territoryConfigCards.get(i));
					break;
				} catch (Exception e) {
					clickOnWebElementUsingJavascript(this.territoryConfigCards.get(i));
					break;
				}
			}
		}

		logger.info("Ending of clickOnManageTerritories Method");
	}

	public void clickOnCreateTerritory() {
		logger.info("Starting of clickOnCreateTerritory Method");

		waitUntilElementVisible(driver, this.createTerritoryBtn);
		clickOnWebElement(this.createTerritoryBtn);

		logger.info("Ending of clickOnCreateTerritory Method");
	}

	public void enterTerritoryName(String nameOfTerritory) {
		logger.info("Starting of enterTerritoryName Method");

		String currentTime=getCurrentTime();
		waitUntilElementVisible(driver, this.territoryNameInput);
		try {
			this.territoryNameInput.sendKeys(nameOfTerritory+"_"+currentTime);
		} catch (Exception e) {
			this.territoryNameInput.sendKeys(nameOfTerritory+"_"+currentTime);
		}

		logger.info("Ending of enterTerritoryName Method");
	}
	
	public void enterTerritoryNo(String territoryNo) {
		logger.info("Starting of enterTerritoryNo Method");
		
		String Id=territoryNo+"_"+getCurrentTime();
		waitUntilElementVisible(driver, this.territoryNoInput);
		this.territoryNoInput.sendKeys(Id);
		
		logger.info("Ending of enterTerritoryNo Method");
	}
	
	public void clickOnSave() {
		logger.info("Starting of clickonSave Method");
		
		waitUntilElementVisible(driver, this.saveBtn);
		try {
			clickOnWebElement(this.saveBtn);
		} catch (Exception e) {
            clickOnWebElementUsingJavascript(this.saveBtn);
		}
		
		logger.info("Ending of clickonSave Method");
	}
	
	public String getTerritoryConfirmationMsg() {
		logger.info("Starting of getTerritoryConfirmationMsg Method");
		
		waitUntilElementVisible(driver, this.createdTerritoryConfirmation);
		String msg=this.createdTerritoryConfirmation.getText();
		
		logger.info("Ending of getTerritoryConfirmationMsg Method");
		return msg;		
	}
	
	public void clickOnEdit() {
		logger.info("Starting of clickOnEdit Method");
		
		waitUntilElementVisible(driver, this.editBtn);
		clickOnWebElement(this.editBtn);
		
		logger.info("Ending of clickOnEdit Method");

	}
	
	public void enterModifiedName(String modifiedName) {
		logger.info("Starting of enterModifiedName Method");
		
		waitUntilElementVisible(driver, this.territoryNameInput);
		this.territoryNameInput.clear();
		this.territoryNameInput.sendKeys(modifiedName+"_"+getCurrentTime());
		
		logger.info("Ending of enterModifiedName Method");
	}
	
	public void clickOnMapEmpOption() {
		logger.info("Starting of clickOnMapEmpOption Method");
		
		waitUntilElementVisible(driver, this.empMapBtn);
		clickOnWebElement(this.empMapBtn);
		
		logger.info("Ending of clickOnMapEmpOption Method");
	}
	
	public void selectEmp(String empID) {
		logger.info("Starting of selectEmp Method");
		
		waitUntilElementVisible(driver, this.unselectedEmpList);
		selectDropdown(this.unselectedEmpList, empID);
		
		logger.info("Ending of selectEmp Method");
	}
	
	public void moveRightSide() {
		logger.info("Starting of moveRightSide method");
		
		waitUntilElementVisible(driver,this.moveRightSideArrow);
		try {
			clickOnWebElement(this.moveRightSideArrow);
		} catch (Exception e) {
			clickOnWebElementUsingJavascript(this.moveRightSideArrow);
		}
		
		logger.info("Ending of moveRightSide method");
	}
	
	public void clickOnMappingSaveBtn() {
		logger.info("Starting of clickOnMappingSaveBtn Method");
		
		waitUntilElementVisible(driver, this.mappingSaveBtn);
		clickOnWebElement(this.mappingSaveBtn);
		
		logger.info("Ending of clickOnMappingSaveBtn Method");
	}
	
	public void clickOnDelete() {
		logger.info("Starting of clickOnDelete Method");
		
		waitUntilElementVisible(driver, this.deleteBtn);
		try {
			clickOnWebElement(this.deleteBtn);
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			clickOnWebElementUsingJavascript(this.deleteBtn);
			driver.switchTo().alert().accept();
        }
		
		logger.info("Ending of clickOnDelete Method");
	}
	
	public void clickOnType() {
		logger.info("Starting of clickOntype Method");
		
		waitUntilElementVisible(driver, this.typeDropdown);
		clickOnWebElement(this.typeDropdown);
		
		logger.info("Ending of clickOntype Method");	
	}
	
	public void selectCircleType() {
		
		logger.info("Starting of SelectCircle type method");
		
		waitUntilElementVisible(driver, this.circleTypeOption);
		clickOnWebElement(this.circleTypeOption);
		
		logger.info("Ending of SelectCircle type method");
	}
	
	public void enterLocationAddress(String locationName) {
		logger.info("Starting of enterLocationAddress type method");
		
		waitUntilElementVisible(driver, this.searchLocationInput);
		this.searchLocationInput.sendKeys(locationName);
		this.searchLocationInput.sendKeys(Keys.ENTER);
		
		logger.info("Starting of enterLocationAddress type method");
	}
	
	public void clickOnMap() {
		logger.info("Starting of clickOnMap Method");
		
		waitUntilElementVisible(driver, this.mapLocation);
		clickOnWebElement(this.mapLocation);
		driver.switchTo().alert().accept();
		
		logger.info("Ending of clickOnMap Method");
	}
	
	public void clickOnFilter() {
		logger.info("Starting of clickOnFilter Method");
		
		

		logger.info("Ending of clickOnFilter Method");
	}
	
	

}
