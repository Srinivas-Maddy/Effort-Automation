package com.effort.imports;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class ImportPages extends BaseAutomationPage{


	private static final Logger logger = Logger.getLogger(BaseAutomationPage.class.getName());

	public String sheetValidationStatus;
	public String empCustomerMappingStatus;
	public static String SheetProcessingStatus;	
	public static String empCustomerTypeMappingSheetStatusMsg;
	public static String routeMappingStatus;
	public static String empLeaveBalanceStatus;
	public static String empIdUpdateMsg;
	public static String routePlanAssignemetStatus;
	public static String workAssignmentStatus;
	public static String customerBulkUploadStatus;
	public static String cutomerBulkDeleteStatus;
	public static String TerritoryUploadStatus;
	public static String ListUploadStauts;
	public static String routeUploadedStatus;

	@FindBy(xpath="//a[contains(text(),'Web App')]")
	private WebElement WebApp;

	@FindBy(xpath="//div[@id='header_menu']/div[2]/ul/li/a")
	private List<WebElement> menubar; 

	@FindBy(xpath="//div[@class='Itembody']/ul/li/a[2]")
	private List<WebElement> employeeMenu;

	@FindBy(xpath="//div[@class='col-md-12']/div[2]/input")
	private WebElement chooseBtnEmpImport;

	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement importBtn;

	@FindBy(xpath="//div[contains(text(),'All rows have correct data')]")
	private WebElement correctDataEmp;

	@FindBy(xpath="//div[contains(text(),'Import Employee')]/following-sibling::div")
	private WebElement mappingSheetValidationStatus;

	@FindBy(xpath="//table[@id='empBulkUploads']/tbody/tr[1]/td[7]")
	private WebElement dataValiation;

	@FindBy(xpath="//div[@id='s2id_entitySpecId']")
	private WebElement listDropdown;

	@FindBy(xpath="//ul[@id='select2-results-1']/li/div")
	private List<WebElement> listSpecs;

	@FindBy(xpath="//div[@class='col-md-12']/form/div[3]/input")
	private WebElement chooseFileListImport;

	@FindBy(xpath="//div[@class='col-md-12']/div[2]/input")
	private WebElement chooseFileEmpCustTypeMappingBtn;

	@FindBy(xpath="//div[@style='color: orange;']")
	private WebElement empCustTypesheetUploadedStatuMsg;

	@FindBy(xpath="//div[@class='col-md-12']/div[2]/input")
	private WebElement chooseFileRouteMapping;

	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement routeMappingStatusMsg;

	@FindBy(xpath="//div[@class='col-md-12']/div[2]/input")
	private WebElement chooseFileLeaveBalance;

	@FindBy(xpath="//div[@class='pageBodyOld']/div[1]")
	private WebElement empLeaveUplodStatus;

	@FindBy(xpath="//table[@id='empBulkUploads']/tbody/tr/td[7]")
	private WebElement empIdUpdateStatus;

	@FindBy(xpath="//div[@class='container-fluid bg-1']/div[1]")
	private WebElement empRoutePlanAssignmentMsg;

	@FindBy(xpath="(//div[@id='s2id_workSpecId'])[1]")
	private WebElement workSpecDropdownBtn;

	@FindBy(xpath="//ul[@class='select2-results']/li")
	private List<WebElement> workSpecs;

	@FindBy(xpath="(//div[@class='form-group']/input)[1]")
	private WebElement chooseBtnWorkAssignemt;

	@FindBy(xpath="//table[@id='allWorkflows']/tbody/tr/td[6]")
	private WebElement AssignmentStatus;

	@FindBy(xpath="(//ul[@class='icons'])[3]/li/a[2]")
	private List<WebElement> customerMenu;

	@FindBy(xpath="//table[@id='allWorkflows']/tbody/tr[1]/td[5]")
	private WebElement customerImportSheetStatus;

	@FindBy(xpath="//div[@id='msg']/span")
	private WebElement customerBulkDeleteStatus;

	@FindBy(xpath="//div[@class='Itembody col-md-12 pd-0']/ul/li/a[2]")
	private List<WebElement> importsRemainigCardNames;

	@FindBy(xpath="//div[@style='color: orange;']")
	private WebElement empTerritoryUploadStatus;

	@FindBy(xpath="(//ul[@class='icons'])[4]/li/a[2]")
	private WebElement importListCard;

	@FindBy(xpath="//div[@id='s2id_entitySpecId']")
	private WebElement pickListDropDown;

	@FindBy(xpath="//ul[@id='select2-results-1']/li/div")
	private List<WebElement> listSpecsNames;

	@FindBy(xpath="(//div[@class='form-group'])[3]/input")
	private WebElement chooseFileOptionList;

	@FindBy(xpath="//table[@id='allWorkflows']/tbody/tr/td[7]")
	private WebElement listUploadStatus;

	@FindBy(xpath="(//ul[@class='icons'])[5]/li/a[2]")
	private List<WebElement> routesMenuCard;

	@FindBy(xpath="//div[@class='form-group']/input")
	private WebElement routesChooseButton;

	@FindBy(xpath="//label[@class='container-r'][2]/span")
	private WebElement updateExistingRadioBtn;
	
	@FindBy(xpath="//label[@class='container-r'][3]/span")
	private WebElement replaceRadioBtn;

	@FindBy(xpath="//div[@style='color: orange;']")
	private WebElement routesUploadStatus;

	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;

	public ImportPages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	

	public void clickOnWebApp() {
		logger.info("Starting of click on web app method");
		hardWait(3);
		waitUntilElementVisible(driver, this.WebApp);
		this.WebApp.click();
		logger.info("Ending of clickOnWebApp method");
	}

	public void clickOnImports() {
		logger.info("Starting of clickOnImports method");
		for (int i = 0; i<menubar.size(); i++) {
			String menuName=menubar.get(i).getText();
			if(menuName.equalsIgnoreCase("Imports")){
				waitUntilElementVisible(driver, menubar.get(i));
				menubar.get(i).click();
				break;
			}
		}	
		logger.info("Ending of clickOnImports method");
	}

	//Employee bulk upload
	public String clickOnImportCard(String card, String filePath) throws InterruptedException{
		logger.info("Starting on import employee card");
		for (int i = 0; i <employeeMenu.size(); i++){
			String cardName=employeeMenu.get(i).getText();
			if(cardName.equalsIgnoreCase(card)) {
				waitUntilElementVisible(driver, employeeMenu.get(i));
				employeeMenu.get(i).click();
				waitUntilElementVisible(driver, this.chooseBtnEmpImport);
				this.chooseBtnEmpImport.sendKeys(filePath);
				this.importBtn.click();
				Thread.sleep(5000);
				waitUntilElementVisible(driver, this.correctDataEmp);
				sheetValidationStatus=this.correctDataEmp.getText();
				driver.navigate().refresh();
				Thread.sleep(5000);
				driver.navigate().refresh();
				waitUntilElementVisible(driver, this.dataValiation);
				SheetProcessingStatus=this.dataValiation.getText();
				break;
			}
			logger.info("Ending of clicn on import employee card");

		}
		return sheetValidationStatus;

	}

	//Employee Customer Bulk import
	public String importCustomerMapping(String card, String filePath) throws InterruptedException {
		logger.info("Starting  on import Customer bulk upload method");

		for (int i = 0; i <employeeMenu.size(); i++){
			String cardName=employeeMenu.get(i).getText();

			if(cardName.equalsIgnoreCase(card)) {
				waitUntilElementVisible(driver, employeeMenu.get(i));
				employeeMenu.get(i).click();
				waitUntilElementVisible(driver, this.chooseBtnEmpImport);
				this.chooseBtnEmpImport.sendKeys(filePath);
				this.importBtn.click();
				Thread.sleep(2000);
				waitUntilElementVisible(driver, this.mappingSheetValidationStatus);
				empCustomerMappingStatus=this.mappingSheetValidationStatus.getText();	
				break;
			}
			logger.info("Ending  on import Customer bulk upload method");

		}
		return empCustomerMappingStatus;

	}

	//Employee List mapping bulk upload
	public void importEmployeeListMapping(String card, String filePath, String listName) throws InterruptedException {
		logger.info("Starting  on import Employee List mapping Method");

		for (int i = 0; i <employeeMenu.size(); i++){
			String cardName=employeeMenu.get(i).getText();

			if(cardName.equalsIgnoreCase(card)) {
				waitUntilElementVisible(driver, employeeMenu.get(i));
				employeeMenu.get(i).click();
				waitUntilElementVisible(driver, this.listDropdown);
				this.listDropdown.click();
				for (int j = 0; j <this.listSpecs.size(); j++) {
					waitUntilElementVisible(driver, this.listSpecs.get(i));
					String listSpecName=this.listSpecs.get(j).getText();
					if(listSpecName.equalsIgnoreCase(listName)) {
						this.listSpecs.get(j).click();
						waitUntilElementVisible(driver, this.chooseFileListImport);
						this.chooseFileListImport.sendKeys(filePath);
						this.importBtn.click();
						break;
					}
				}
			}
			logger.info("Ending  on import Employee List mapping Method");
		}

	}

	//Employee Customer type mapping
	public String importEmployeeCustomerTypeMapping(String card, String filePath) throws InterruptedException {
		logger.info("Starting on Employee customer type Mapping Method");

		for (int i = 0; i <employeeMenu.size(); i++){
			String cardName=employeeMenu.get(i).getText();
			if(cardName.equalsIgnoreCase(card)) {
				waitUntilElementVisible(driver, employeeMenu.get(i));
				employeeMenu.get(i).click();
				waitUntilElementVisible(driver, this.chooseFileEmpCustTypeMappingBtn);
				this.chooseFileEmpCustTypeMappingBtn.sendKeys(filePath);
				this.importBtn.click();
				Thread.sleep(5000);
				//driver.navigate().refresh();
				waitUntilElementVisible(driver, this.empCustTypesheetUploadedStatuMsg);
				empCustomerTypeMappingSheetStatusMsg=this.empCustTypesheetUploadedStatuMsg.getText();
				break;
			}
			logger.info("Ending on Employee customer type Mapping Method");

		}

		return empCustomerTypeMappingSheetStatusMsg;

	}

	//Employee Route Plan mapping
	public String importRoutePlanMapping(String card, String filePath) throws InterruptedException {
		logger.info("Starting  on Route Plan Mapping Method");

		for (int i = 0; i <employeeMenu.size(); i++){
			String cardName=employeeMenu.get(i).getText();
			if(cardName.equalsIgnoreCase(card)) {
				waitUntilElementVisible(driver, employeeMenu.get(i));
				employeeMenu.get(i).click();
				waitUntilElementVisible(driver, this.chooseFileRouteMapping);
				this.chooseFileRouteMapping.sendKeys(filePath);
				this.importBtn.click();
				Thread.sleep(5000);
				waitUntilElementVisible(driver, this.routeMappingStatusMsg);
				routeMappingStatus=this.routeMappingStatusMsg.getText();
				break;
			}
			logger.info("Ending on Route Plan Mapping Method");
		}			
		return routeMappingStatus;
	}

	public String importRouteAssignment(String card, String filePath) throws InterruptedException {
		logger.info("Starting  on Route Plan Assignment Method");

		for (int i = 0; i <employeeMenu.size(); i++){
			String cardName=employeeMenu.get(i).getText();
			if(cardName.equalsIgnoreCase(card)) {
				waitUntilElementVisible(driver, employeeMenu.get(i));
				employeeMenu.get(i).click();
				waitUntilElementVisible(driver, this.chooseFileRouteMapping);
				this.chooseFileRouteMapping.sendKeys(filePath);
				this.importBtn.click();
				Thread.sleep(5000);
				waitUntilElementVisible(driver, this.empRoutePlanAssignmentMsg);
				routePlanAssignemetStatus=this.empRoutePlanAssignmentMsg.getText();
				break;
			}
			logger.info("Ending  on Route Plan Assignment Method");
		}			
		return routePlanAssignemetStatus;
	}

	//Employee Leave Balance update mapping
	public String importEmployeeLeaveBalance(String card, String filePath) throws InterruptedException {
		logger.info("Starting  on Employee Leave Balance Method");

		for (int i = 0; i <employeeMenu.size(); i++){
			String cardName=employeeMenu.get(i).getText();
			if(cardName.equalsIgnoreCase(card)) {
				waitUntilElementVisible(driver, employeeMenu.get(i));
				employeeMenu.get(i).click();
				waitUntilElementVisible(driver, this.chooseFileLeaveBalance);
				this.chooseFileLeaveBalance.sendKeys(filePath);
				this.importBtn.click();
				waitUntilElementVisible(driver, this.empLeaveUplodStatus);
				empLeaveBalanceStatus=this.empLeaveUplodStatus.getText();
				break;

			}
			logger.info("Ending  on Employee Leave Balance Method");
		}			
		return empLeaveBalanceStatus;
	}

	//Employee ID Update
	public String importEmployeeIDUpdate(String card, String filePath) throws InterruptedException {
		logger.info("Starting  on import employee ID Update");

		for (int i = 0; i <employeeMenu.size(); i++){
			String cardName=employeeMenu.get(i).getText();
			if(cardName.equalsIgnoreCase(card)) {
				waitUntilElementVisible(driver, employeeMenu.get(i));
				employeeMenu.get(i).click();
				waitUntilElementVisible(driver, this.chooseFileLeaveBalance);
				this.chooseFileLeaveBalance.sendKeys(filePath);
				this.importBtn.click();
				waitUntilElementVisible(driver, this.empIdUpdateStatus);
				empIdUpdateMsg=this.empIdUpdateStatus.getText();
				break;

			}
			logger.info("Ending  on import employee ID Update");
		}			
		return empIdUpdateMsg;
	}

	//Bulk Work Assignment
	public String importEmployeeWorkReassignment(String card, String filePath, String workSpecName) throws InterruptedException {
		logger.info("Starting  on Work Assignment Bulk upload");

		for (int i = 0; i <employeeMenu.size(); i++){
			String cardName=employeeMenu.get(i).getText();
			if(cardName.equalsIgnoreCase(card)) {
				waitUntilElementVisible(driver, employeeMenu.get(i));
				employeeMenu.get(i).click();
				waitUntilElementVisible(driver, this.workSpecDropdownBtn);
				this.workSpecDropdownBtn.click();
				for (int j = 0; j < this.workSpecs.size(); j++) {
					String specName=this.workSpecs.get(j).getText();
					if(specName.equalsIgnoreCase(workSpecName)){
						this.workSpecs.get(j).click();
						waitUntilElementVisible(driver, this.chooseBtnWorkAssignemt);
						this.chooseBtnWorkAssignemt.sendKeys(filePath);
						this.importBtn.click();
						Thread.sleep(500);
						workAssignmentStatus=this.AssignmentStatus.getText();
						break;
					}
				}


			}
			logger.info("Ending  on Work Assignment Bulk upload");
		}			
		return workAssignmentStatus;
	}

	//Customer Bulk upload 
	public String importCustomers(String cardName, String filePath) throws InterruptedException{
		logger.info("Starting of import customer method");
		for (int i = 0; i < this.customerMenu.size(); i++) {
			String importCardName=this.customerMenu.get(i).getText();
			if(importCardName.equalsIgnoreCase(cardName)) {
				waitUntilElementVisible(driver, this.customerMenu.get(i));
				this.customerMenu.get(i).click();
				waitUntilElementVisible(driver, this.chooseBtnEmpImport);
				this.chooseBtnEmpImport.sendKeys(filePath);
				this.importBtn.click();
				driver.navigate().refresh();
				Thread.sleep(5000);
				driver.navigate().refresh();
				customerBulkUploadStatus=this.customerImportSheetStatus.getText();
				break;
			}
			logger.info("Ending of import customer method");
		}
		return customerBulkUploadStatus;
	}

	//Customer bulk delete
	public String importCustomerBulkDelete(String cardName, String filePath){
		logger.info("Starting of import customer delete method");
		for (int i = 0; i < this.customerMenu.size(); i++) {
			String importCardName=this.customerMenu.get(i).getText();
			if(importCardName.equalsIgnoreCase(cardName)) {
				waitUntilElementVisible(driver, this.customerMenu.get(i));
				this.customerMenu.get(i).click();
				waitUntilElementVisible(driver, this.chooseBtnEmpImport);
				this.chooseBtnEmpImport.sendKeys(filePath);
				this.importBtn.click();
				hardWait(3);
				waitUntilElementVisible(driver, this.customerBulkDeleteStatus);
				cutomerBulkDeleteStatus=this.customerBulkDeleteStatus.getText();
				break;
			}
			logger.info("Ending of import customer delete method");
		}
		return cutomerBulkDeleteStatus;
	}

	//Customer Id update through bulk upload
	public void importCustomerIdUpadte(String cardName,String filePath) {
		logger.info("Starting of import customer Id update method");
		for (int i = 0; i < this.customerMenu.size(); i++) {
			String importCardName=this.customerMenu.get(i).getText();
			if(importCardName.equalsIgnoreCase(cardName)) {
				waitUntilElementVisible(driver, this.customerMenu.get(i));
				this.customerMenu.get(i).click();
				waitUntilElementVisible(driver, this.chooseBtnEmpImport);
				this.chooseBtnEmpImport.sendKeys(filePath);
				this.importBtn.click();
				break;
			}	
			logger.info("ending of import customer ID update method");
		}
	}

	//Employee Territory Mapping
	public String importEmpTerritoryMapping(String cardName, String filePath) throws InterruptedException{
		logger.info("Starting of import employee territory mapping");
		for (int i = 0; i < this.importsRemainigCardNames.size(); i++){
			String importActualCardName=this.importsRemainigCardNames.get(i).getText();
			if(importActualCardName.equalsIgnoreCase(cardName)){
				waitUntilElementVisible(driver, this.importsRemainigCardNames.get(i));
				this.importsRemainigCardNames.get(i).click();
				Thread.sleep(5000);
				waitUntilElementVisible(driver, this.chooseBtnEmpImport);
				this.chooseBtnEmpImport.sendKeys(filePath);
				this.importBtn.click();
				waitUntilElementVisible(driver, this.empTerritoryUploadStatus);
				TerritoryUploadStatus=this.empTerritoryUploadStatus.getText();
				break;
			}
			logger.info("Ending of import employee territory mapping");
		}
		return TerritoryUploadStatus;
	}

	//Import List Moudle
	public String importListUpload(String specNamePro, String filePath) throws InterruptedException {
		logger.info("Starting of import list module");
		waitUntilElementVisible(driver, this.importListCard);
		this.importListCard.click();
		waitUntilElementVisible(driver, this.pickListDropDown);
		this.pickListDropDown.click();
		for (int i = 0; i < this.listSpecsNames.size(); i++) {
			String specName=this.listSpecsNames.get(i).getText();
			if (specName.equalsIgnoreCase(specNamePro)){
				waitUntilElementVisible(driver, this.listSpecsNames.get(i));
				this.listSpecsNames.get(i).click();	
				waitUntilElementVisible(driver, this.chooseFileOptionList);
				this.chooseFileOptionList.sendKeys(filePath);
				this.importBtn.click();
				Thread.sleep(4000);
				driver.navigate().refresh();
				Thread.sleep(5000);
				driver.navigate().refresh();
				waitUntilElementVisible(driver,this.listUploadStatus);
				ListUploadStauts=this.listUploadStatus.getText();
				break;
			}		
		}
		logger.info("Ending of import list method");
		return ListUploadStauts;		
	}

	//Import Routes creation 
	public String importRoutePlan(String cardName, String filePath) throws InterruptedException {
		logger.info("Starting of import route plan");

		for (int i = 0; i < this.routesMenuCard.size(); i++){
			String routeCardName=this.routesMenuCard.get(i).getText();
			if (routeCardName.equalsIgnoreCase(routeCardName)) {
				this.routesMenuCard.get(i).click();
				waitUntilElementVisible(driver, this.routesChooseButton);
				this.routesChooseButton.sendKeys(filePath);
				this.importBtn.click();
				Thread.sleep(5000);
				waitUntilElementVisible(driver, this.routesUploadStatus);
				routeUploadedStatus=this.routesUploadStatus.getText();
				break;
			}

		}
		return routeUploadedStatus;

	}

	//Import Routes creation 
	public String importRoutePlanUpdate(String cardName, String filePath) throws InterruptedException {
		logger.info("Starting of import route plan");

		for (int i = 0; i < this.routesMenuCard.size(); i++){
			String routeCardName=this.routesMenuCard.get(i).getText();
			if (routeCardName.equalsIgnoreCase(routeCardName)) {
				this.routesMenuCard.get(i).click();
				waitUntilElementVisible(driver, this.routesChooseButton);
				this.routesChooseButton.sendKeys(filePath);
				waitUntilElementVisible(driver, this.updateExistingRadioBtn);
				this.updateExistingRadioBtn.click();
				this.importBtn.click();
				Thread.sleep(5000);
				waitUntilElementVisible(driver, this.routesUploadStatus);
				routeUploadedStatus=this.routesUploadStatus.getText();
				break;
			}

		}
		return routeUploadedStatus;

	}

	//Import Routes creation 
	public String importRoutePlanReplace(String cardName, String filePath) throws InterruptedException {
		logger.info("Starting of import route plan");

		for (int i = 0; i < this.routesMenuCard.size(); i++){
			String routeCardName=this.routesMenuCard.get(i).getText();
			if (routeCardName.equalsIgnoreCase(routeCardName)) {
				this.routesMenuCard.get(i).click();
				waitUntilElementVisible(driver, this.routesChooseButton);
				this.routesChooseButton.sendKeys(filePath);
				waitUntilElementVisible(driver, this.replaceRadioBtn);
				this.replaceRadioBtn.click();
				this.importBtn.click();
				Thread.sleep(5000);
				waitUntilElementVisible(driver, this.routesUploadStatus);
				routeUploadedStatus=this.routesUploadStatus.getText();
				break;
			}

		}
		return routeUploadedStatus;

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
