package com.effort.dayplan;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class DayplannerPage extends BaseAutomationPage{

	private static final Logger logger= Logger.getLogger(DayplannerPage.class);

	@FindBy(xpath="//ul[@id='orderedUl']/li[@id='dots']")
	private WebElement meatBallsMenu;

	@FindBy(xpath="(//ul[@class='dropdown-menu'])[1]/li/a")
	private List<WebElement> menuItems;

	@FindBy(id="searchEmployeeText")
	private WebElement employee_SearchBar;

	@FindBy(xpath="//ul[@class='employeeList']/li/span")
	private List<WebElement> employeesList;

	@FindBy(id="customerDialogButton1")
	private WebElement addCustomer_Btn;

	@FindBy(xpath="//div[@class='pq-cont']/table/tbody/tr/td[2]/div/img")
	private List<WebElement> customers_CheckBoxs;

	@FindBy(xpath="//input[@value='OK']")
	private WebElement ok_Btn;

	@FindBy(id="save1")
	private WebElement save_Btn;
	
	@FindBy(xpath="//input[@id='customEntityDialogButton']")
	private List<WebElement> entityNames_Btn;

	@FindBy(xpath = "//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath = "//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;

	public DayplannerPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnMeatBallsMenu() {
		logger.info("Starting of clickOnMeatBallsMenu Method");

		waitUntilElementVisible(driver, this.meatBallsMenu);
		clickOnWebElement(this.meatBallsMenu);

		logger.info("Ending of clickOnMeataBallsMenu Method");
	}

	public void clickOnDayPlan() {
		logger.info("Starting of clickOnDayPlan Method");

		for (int i = 0; i < this.menuItems.size(); i++) {
			String menuItemNames=this.menuItems.get(i).getText();
			if (menuItemNames.equalsIgnoreCase("Day Plans")) {
				waitUntilElementVisible(driver, this.menuItems.get(i));
				clickOnWebElement(this.menuItems.get(i));
				break;
			}
		}

		logger.info("Ending of clickOnDayPlan Method");
	}

	public void selectEmployeeInSearchBar(String empName) {
		logger.info("Starting of selectEmployeeInSearchBar Method");

		waitUntilElementVisible(driver, this.employee_SearchBar);
		this.employee_SearchBar.sendKeys(empName);
		for (int i = 0; i < this.employeesList.size(); i++) {
			String employeeName=this.employeesList.get(i).getText();
			if (employeeName.equalsIgnoreCase(empName)) {
				waitUntilElementVisible(driver, this.employeesList.get(i));
				clickOnWebElement(this.employeesList.get(i));
				break;
			}
		}

		logger.info("Ending of selectEmployeeInSearchBar Method");
	}

	public void clickOnAddCustomerButton() {
		logger.info("Starting of clickOnAddCustomerButton Method");

		waitUntilElementVisible(driver, this.addCustomer_Btn);
		clickOnWebElement(this.addCustomer_Btn);

		logger.info("Ending of clickOnAddCustomerButton Method");
	}

	public void selectCustomerCheckBoxes() {
		logger.info("Starting of selectCustomerCheckBoxes Method");

		for (int i = 0; i < this.customers_CheckBoxs.size(); i++) {
			waitUntilElementVisible(driver, this.customers_CheckBoxs.get(i));
			this.customers_CheckBoxs.get(i).click();
			if(i==4) {
				break;
			}

		}

		logger.info("Ending of selectCustomerCheckBoxes Method");
	}

	public void modifySelectedCustomers() {
		logger.info("Starting of modifySelectedCustomers method");

		for (int i = 0; i < this.customers_CheckBoxs.size(); i++) {
			waitUntilElementVisible(driver, this.customers_CheckBoxs.get(i));
			this.customers_CheckBoxs.get(i).click();
			if(i==4) {
				break;
			}
		}

		logger.info("Ending of modifySelectedCustomers method");

	}

	public void clickOnOkButton() {
		logger.info("Starting of clickOnOkButton Method");

		waitUntilElementVisible(driver, this.ok_Btn);
		clickOnWebElement(this.ok_Btn);

		logger.info("Ending of clickOnOkButton Method");
	}

	public String clickOnSaveButton() {
		logger.info("Starting of clickOnSaveButton Method");

		waitUntilElementVisible(driver, this.save_Btn);
		this.save_Btn.click();
		String message=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		logger.info("Ending of clickOnSaveButton Method");
		
		return message;
	}
	
	public void clickOnEntityButton(String entityName) {
		logger.info("Starting of clickOnEntityButton Method");
		
		for (int i = 0; i < this.entityNames_Btn.size(); i++) {
			String entitySpecName=this.entityNames_Btn.get(i).getAttribute("value");
			if (entitySpecName.equalsIgnoreCase(entityName)) {
				waitUntilElementVisible(driver, this.entityNames_Btn.get(i));
				clickOnWebElement(this.entityNames_Btn.get(i));
				break;
			}
		}
		
		logger.info("Ending of clickOnEntityButton Method");;
	}
	
	
	

	public void LogOut() {
		logger.info("Starting of LogOut Method");
		
		hardWait(3);
		waitUntilElementVisible(driver, userNameBtn);
		mouseHoverAndClick(userNameBtn);
		//userNameBtn.click();
		if (logoutBtn.get(logoutBtn.size() - 1).getText().equalsIgnoreCase("LogOut")) {
			logoutBtn.get(logoutBtn.size() - 1).click();
		}

		logger.info("Ending of LogOut Method");
	}


}
