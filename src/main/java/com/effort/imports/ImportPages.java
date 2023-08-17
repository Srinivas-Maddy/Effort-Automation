package com.effort.imports;
import java.util.List;
import org.apache.log4j.Logger;
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

	@FindBy(xpath="//div[contains(text(),'Mapping successfully done')]")
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
				Thread.sleep(5000);
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
				driver.navigate().refresh();
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
