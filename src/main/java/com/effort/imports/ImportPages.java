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




	public String importCustomerMapping(String card, String filePath) throws InterruptedException {
		logger.info("Starting  on import Customer employee mapping");

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
			logger.info("Ending  on import Customer employee mapping");

		}
		return empCustomerMappingStatus;


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
