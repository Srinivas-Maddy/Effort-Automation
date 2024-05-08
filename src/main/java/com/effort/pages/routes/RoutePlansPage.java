package com.effort.pages.routes;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.effort.base.BaseAutomationPage;

public class RoutePlansPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(RoutePlansPage.class.getName());

	String RoutePlanname = null;
	public static String routename;

	@FindBy(xpath = "//ul[@id='orderedUl']/li/a")
	private List<WebElement> barMainData;

	@FindBy(xpath = "//a[@value='Create Route Plan']")
	private WebElement btnCreateRoutePlan;

	@FindBy(id = "routeNameId")
	private WebElement txtRoutePlanNameField;

	@FindBy(id = "routeNumber")
	private WebElement txtRoutePlanIdField;

	@FindBy(id = "duration")
	private WebElement txtRouteDurationField;

	@FindBy(id = "minNightsToStay")
	private WebElement txtNightStayField;

	//@FindBy(id = "pickCustomer")
	@FindBy(xpath = "//button[contains(text(),'Add Customer')]")
	private WebElement btnAddCustomer;
	
	@FindBy(xpath="//tr[contains(@class,'pq-grid-row')]/td[2]/div/img")
	private List<WebElement> customerCheckBoxSelections;
	
	@FindBy(xpath = "//img[@dataindex='0']")
	private WebElement chkCustomerSelect;

	@FindBy(xpath = "//img[@dataindex='1']")
	private WebElement chkSecondCustomer;
	
	@FindBy(xpath = "//img[@dataindex='2']")
	private WebElement chkThirdCustomer;

	@FindBy(xpath = "//img[@dataindex='3']")
	private WebElement chkFourthCustomer;

	@FindBy(xpath = "//input[@value='OK']")
	private WebElement btnOk;
	
	@FindBy(xpath = "//input[@value='Ok']")
	private WebElement btnOkOnApplyChangesPopUp;

	@FindBy(xpath = "//button[@id='save']")
	private WebElement btnCustomerSave;

	@FindBy(id = "assignRoute")
	private WebElement btnRouteAassign;

	@FindBy(xpath = "//div[@id='select2-drop']//input")
	private WebElement txtRoutePlanInputField;

	@FindBy(xpath = "select2-container")
	private WebElement txtRouteEmployeeField;

	@FindBy(xpath = "//div[@class='select2-result-label']/span")
	private WebElement txtRouteEmployeeData;

	@FindBy(xpath = "//img[@title='Edit']")
	private WebElement icnEditAssign;

	@FindBy(id = "select2-chosen-2")
	private WebElement dprRoutePlan;

	@FindBy(id = "select2-chosen-3")
	private WebElement dprEmployee;

	@FindBy(xpath = "//div[contains(@id, 'select2-result-label')]")
	private List<WebElement> txtRoutePlanAssign;

	@FindBy(xpath = "//button[contains(text(),'Assign')]")
	private WebElement btnAssign;

	@FindBy(xpath = "//button[contains(text(),'Map and Assign')]")
	private WebElement btnMapAssign;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement btnSubmitOnAssign;

	@FindBy(xpath = "//span[contains(text(),'Saved successfully')]")
	private WebElement txtSavedSucessfully;

	@FindBy(xpath = "//input[@id='fromDate']")
	private WebElement txtFromDate;

	@FindBy(xpath = "//td[contains(@class, 'xdsoft_date xdsoft_current xdsoft_today')]")
	private WebElement btnTodaysDate;

	@FindBy(id = "selectForm")
	private WebElement chkRouteName;
	
	@FindBy(id = "deleteForms")
	private WebElement btnDelete;
	
	@FindBy(id = "logoutGear")
	private WebElement btnUserName;

	@FindBy(xpath = "(//ul[@class='dropdown-menu'])[2]/li/a")
	private List<WebElement> btnLogout;

	public RoutePlansPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnRoutesModule(String routesname) {
		logger.info("Starting of clickOnRoutesModule Method");

		for (int i = 0; i < this.barMainData.size(); i++) {
			String mainbaritemslist = this.barMainData.get(i).getText();
			if (mainbaritemslist.equalsIgnoreCase(routesname)) {
				waitUntilElementVisible(driver, this.barMainData.get(i));
				this.barMainData.get(i).click();
				break;
			}
		}

		logger.info("Ending of clickOnRoutesModule Method");
	}

	public void clickOnCreateRoutesPlan() {
		logger.info("Starting of enterRoutesPlanName Method");

		waitUntilElementVisible(driver, this.btnCreateRoutePlan);
		this.btnCreateRoutePlan.click();

		logger.info("Ending of enterRoutesPlanName Method");

	}

	public void enterRoutesPlanName(String routesplanname) {
		logger.info("Starting of enterRoutesPlanName Method");

		waitUntilElementVisible(driver, this.txtRoutePlanNameField);
		routename = routesplanname + "_" + getCurrentDate();
		this.txtRoutePlanNameField.sendKeys(routename);

		logger.info("Ending of enterRoutesPlanName Method");
	}
	
	public void verifyDeletingTheRouteEmployee() {
		logger.info("Starting of verifyDeletingTheRouteEmployee Method");

		hardWait(2);
		waitUntilElementVisible(driver, this.chkRouteName);
		this.chkRouteName.click();
		
		waitUntilElementVisible(driver, this.btnDelete);
		this.btnDelete.click();
		
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		

		logger.info("Ending of verifyDeletingTheRouteEmployee Method");
	}

	public void enterRouteID(String routeId) {
		logger.info("Starting of enterRouteID Method");

		waitUntilElementVisible(driver, this.txtRoutePlanIdField);
		String uniqurouteid = this.getUniqueNumber(routeId);
		this.txtRoutePlanIdField.sendKeys(uniqurouteid);

		logger.info("Ending of enterRouteID Method");
	}

	public void enterRouteDuration(String duration) {
		logger.info("Starting of enterRouteDuration Method");

		waitUntilElementVisible(driver, this.txtRouteDurationField);
		this.txtRouteDurationField.sendKeys(duration);

		logger.info("Ending of enterRouteDuration Method");
	}

	public void enterNightsTostay(String nightcount) {
		logger.info("Starting of enterNightsTostay Method");

		waitUntilElementVisible(driver, this.txtNightStayField);
		this.txtNightStayField.sendKeys(nightcount);

		logger.info("Ending of enterNightsTostay Method");
	}

	public void clickOnAddCustomer() {
		logger.info("Starting of clickOnAddCustomer Method");

		waitUntilElementVisible(driver, this.btnAddCustomer);
		this.btnAddCustomer.click();

		logger.info("Ending of clickOnAddCustomer Method");
	}

	public void pickCustomers() {
		logger.info("Starting of clickOnAddCustomer Method");

//		hardWait(2);
//		waitUntilElementVisible(driver, this.chkCustomerSelect);
//		this.chkCustomerSelect.click();
//		hardWait(2);
//		waitUntilElementVisible(driver, this.chkThirdCustomer);
//		this.chkThirdCustomer.click();
		for (int i = 0; i < customerCheckBoxSelections.size(); i++) {
			hardWait(10);
			waitUntilElementVisible(driver, customerCheckBoxSelections.get(i));
			if (i<4) {
				customerCheckBoxSelections.get(i).click();
			}else {
				break;
			}		
		}	
		waitUntilElementVisible(driver, this.btnOk);
		this.btnOk.click();
		waitUntilElementVisible(driver, this.btnCustomerSave);
		this.btnCustomerSave.click();
       // driver.switchTo().alert().accept();
        
		logger.info("Ending of clickOnAddCustomer Method");
	}
	
	public void editPickedCustomers() {
		logger.info("Starting of editPickedCustomers Method");

//		hardWait(2);
//		waitUntilElementVisible(driver, this.chkSecondCustomer);
//		this.chkSecondCustomer.click();
//		hardWait(2);
//		waitUntilElementVisible(driver, this.chkFourthCustomer);
		
		for (int i = 0; i < customerCheckBoxSelections.size(); i++) {
			hardWait(10);
			waitUntilElementVisible(driver, customerCheckBoxSelections.get(i));
			if (i<2) {
				customerCheckBoxSelections.get(i).click();
			}else {
				break;
			}		
		}	
	
		//this.chkFourthCustomer.click();
		waitUntilElementVisible(driver, this.btnOk);
		
		this.btnOk.click();
		waitUntilElementVisible(driver, this.btnCustomerSave);
		this.btnCustomerSave.click();
		
		logger.info("Ending of editPickedCustomers Method");
	}

	public String routeNameValidation() {
		logger.info("Starting of routeNameValidation Method");

		String actualroutename = driver.findElement(By.xpath("//a[text()='" + routename + "']")).getText();

		logger.info("Ending of routeNameValidation Method");
		return actualroutename;
	}

	public void clickOnAssignButton() {
		logger.info("Starting of clickOnAssignButton Method");

		hardWait(2);
		waitUntilElementVisible(driver, this.btnRouteAassign);
		this.btnRouteAassign.click();

		logger.info("Ending of clickOnAssignButton Method");
	}

	public void pickRoutePlan(String routesplanname) {
		logger.info("Starting of pickRoutePlan Method");

		waitUntilElementVisible(driver, this.dprRoutePlan);
		this.dprRoutePlan.click();
		waitUntilElementVisible(driver, this.txtRoutePlanInputField);
		this.txtRoutePlanInputField.sendKeys(routesplanname);
		hardWait(1);
		this.txtRoutePlanAssign.get(1).click();
		/*
		 * int i = 0; while (i < this.routeplandropdowndata.size()) {
		 * waitUntilElementVisible(driver, this.routeplandropdowndata.get(i));
		 * this.routeplandropdowndata.get(i).click(); break; }
		 */

		logger.info("Ending of pickRoutePlan Method");
	}

	public void pickRouteEmployee() {
		logger.info("Starting of pickRouteEmployee Method");

		waitUntilElementVisible(driver, this.dprEmployee);
		this.dprEmployee.click();
		waitUntilElementVisible(driver, this.txtRoutePlanAssign.get(1));
		// this.routeemployeeinputfield.sendKeys(empname);
		this.txtRoutePlanAssign.get(1).click();
		// waitUntilElementVisible(driver, this.routeempdropdata);
		// this.routeempdropdata.click();

		logger.info("Ending of pickRouteEmployee Method");
	}

	public void editRouteEmployee() {
		logger.info("Starting of editRouteEmployee Method");

		waitUntilElementVisible(driver, this.dprEmployee);
		this.dprEmployee.click();
		waitUntilElementVisible(driver, this.txtRoutePlanAssign.get(3));
		// this.routeemployeeinputfield.sendKeys(empname);
		this.txtRoutePlanAssign.get(1).click();
		// waitUntilElementVisible(driver, this.txtRouteEmployeeData);
		// this.txtRouteEmployeeData.click();

		logger.info("Ending of editRouteEmployee Method");
	}

	public void selectFromInRoutePlan() {
		logger.info("Starting of pickRouteEmployee Method");

		waitUntilElementVisible(driver, this.txtFromDate);
		this.txtFromDate.click();
		try {
			waitUntilElementVisible(driver, this.btnTodaysDate);
			this.btnTodaysDate.click();
		} catch (Exception e) {
			waitUntilElementVisible(driver, this.btnTodaysDate);
			this.btnTodaysDate.click();
		}

		logger.info("Ending of pickRouteEmployee Method");
	}

	public void clickOnEditIcon() {
		logger.info("Starting of clickOnEditIcon Method");

		waitUntilElementVisible(driver, this.icnEditAssign);
		this.icnEditAssign.click();

		logger.info("Ending of clickOnEditIcon Method");
	}

	public void clickOnRoutePlanDropDown() {
		logger.info("Starting of editTheRoutePlan Method");

		waitUntilElementVisible(driver, this.dprRoutePlan);
		this.dprRoutePlan.click();

		logger.info("Ending of editTheRoutePlan Method");
	}

	public void selectRoutePlan() {
		logger.info("Starting of selectRoutePlan Method");

		// waitUntilElementVisible(driver, this.txtRoutePlan.get(1));
		this.txtRoutePlanAssign.get(1).click();

		logger.info("Ending of selectRoutePlan Method");
	}

	public void editTheRoutePlan() {
		logger.info("Starting of editTheRoutePlan Method");

		// waitUntilElementVisible(driver, this.txtRoutePlan.get(1));
		this.txtRoutePlanAssign.get(1).click();

		logger.info("Ending of editTheRoutePlan Method");
	}

	public void clickOnSubmitButton() {
		logger.info("Starting of clickOnSubmitButton Method");

		// sssswaitUntilElementVisible(driver, this.btnSubmit);
		this.btnSubmitOnAssign.click();

		logger.info("Ending of clickOnSubmitButton Method");
	}

	public boolean verifyIsEditedRoutePlanSavedSuccessfully() {
		logger.info("Starting of verifyIsEditedRoutePlanSavedSuccessfully Method");

		boolean verifyIsEditedRoutePlanSavedSuccessfully = false;

		if (txtSavedSucessfully.isDisplayed()) {
			verifyIsEditedRoutePlanSavedSuccessfully = true;
		}

		logger.info("Ending of verifyIsEditedRoutePlanSavedSuccessfully Method");
		return verifyIsEditedRoutePlanSavedSuccessfully;
	}

	public void clickOnAssignButtonOnRouteAssign() {
		logger.info("Starting of clickOnAssignButtonOnRouteAssign Method");

		waitUntilElementVisible(driver, this.btnAssign);
		this.btnAssign.click();

		logger.info("Ending of clickOnAssignButtonOnRouteAssign Method");
	}
	
	public void clickOnRouteCheckBox() {
		logger.info("Starting of clickOnRouteCheckBox Method");

		waitUntilElementVisible(driver, this.chkRouteName);
		this.chkRouteName.click();

		logger.info("Ending of clickOnRouteCheckBox Method");
	}

	public void clickOnOkayButtonOnApplyChanges() {
		logger.info("Starting of clickOnOkayButtonOnApplyChanges Method");

		//driver.switchTo().alert().accept();
		waitUntilElementVisible(driver, this.btnOkOnApplyChangesPopUp);
		this.btnOkOnApplyChangesPopUp.click();
		//driver.switchTo().alert().accept();

		logger.info("Ending of clickOnOkayButtonOnApplyChanges Method");
	}

	public void swichToNewWindow() {
		logger.info("Starting of swichToNewWindow Method");

		switchToNewWindow(1);
		
		logger.info("Ending of swichToNewWindow Method");
	}

	public void clickOnMapAssignButton() {
		logger.info("Starting of clickOnMapAssignButton Method");

		try {
			if (btnMapAssign.isDisplayed()) {
				waitUntilElementVisible(driver, this.btnMapAssign);
				this.btnMapAssign.click();

			}
		} catch (Exception e) {
			logger.info("no need to map");
		}

		logger.info("Ending of clickOnMapAssignButton Method");
	}

	public void routesLogOut() throws InterruptedException {
		logger.info("Starting of routesLogOut Method");

		hardWait(5);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", btnUserName);
		waitUntilElementVisible(driver, btnUserName);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.btnUserName);
		for (int i = 0; i < this.btnLogout.size(); i++) {
			String dropdownNames = this.btnLogout.get(i).getText();
			if (dropdownNames.equalsIgnoreCase("Logout")) {
				waitUntilElementVisible(driver, this.btnLogout.get(i));
				this.btnLogout.get(i).click();
				break;
			}

		}

		logger.info("Ending of routesLogOut Method");
	}

}
