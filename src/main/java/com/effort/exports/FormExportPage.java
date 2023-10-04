package com.effort.exports;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import com.effort.base.BaseAutomationPage;

public class FormExportPage extends BaseAutomationPage{
	
	public static final Logger logger=Logger.getLogger(FormExportPage.class);
	
	public String exportSelectedStatusMsg;
	
	@FindBy(xpath="//a[contains(text(),'Web App')]")
	private WebElement webApp;
	
	@FindBy(xpath="//li[@id='forms']")
	private WebElement formsModule;
	
	@FindBy(xpath="//div[@id='formTypeOrderedDiv']/li/span[2]/h5")
	private List<WebElement> formSpecName;
	
	@FindBy(xpath="//div[@class='card-v']/ul/li")
	private List<WebElement> cardView;
	
	@FindBy(xpath="//button[@id='last30']")
	private WebElement last30DaysData;
	
	@FindBy(xpath="//table[contains(@class,'no-footer')]/thead/tr/th[1]/input")
	private WebElement selectAllCheckBox;
	
	@FindBy(xpath="//div[@class='dropdown']/button")
	private WebElement exportDropDown;
	
	@FindBy(xpath="//ul[@class='dropdown-menu btn-block']/li/a")
	private List<WebElement> exportOptions;
	
	@FindBy(xpath="//div[@id='progress']")
	private WebElement exportSelectedStatus;

	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;
	

	public FormExportPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	//Click on the WebApp
	public void clickOnWebApp() {
		logger.info("Starting of clickOn WebApp method");
		waitUntilElementVisible(driver, this.webApp);
		this.webApp.click();
		logger.info("Ending of clicOnWebApp Method");
	}
	
	//Click on the Form Module
	public void clickOnFormsModule() {
		logger.info("Starting of click on form module");
		waitUntilElementVisible(driver, this.formsModule);
		this.formsModule.click();
		logger.info("Ending of Click on form module");
	}
	
	//Click on form spec name
	public void clickOnForm(String formSpecName) {
		logger.info("Starting of click on form");
		for (int i = 0; i < this.formSpecName.size(); i++){
			String formName=this.formSpecName.get(i).getText();
			if (formName.equalsIgnoreCase(formSpecName)){
				waitUntilElementVisible(driver, this.formSpecName.get(i));
				this.formSpecName.get(i).click();
				break;
			}			
		}
		logger.info("Ending of click on form");
	}
	
	
	//Click on the Last 30 days form submission data
	public void clickOnLast30DaysData(String last30daysData){
		logger.info("Starting of clickOnLast30DaysData method");
		for (int i = 0; i < this.cardView.size(); i++) {
			String cardLabelName=this.cardView.get(i).getText();
			if (cardLabelName.contains(last30daysData)) {
				waitUntilElementVisible(driver, this.cardView.get(i));
				this.cardView.get(i).click();
				break;
			}		
		}
		logger.info("Ending of clickOnLast30DaysData method");	
	}
	
	//Select the checkbox
	public void selecAllCheckBox() throws InterruptedException {
		logger.info("Starting of selectAllCheckBox method");
		waitUntilElementVisible(driver, this.last30DaysData);
		this.last30DaysData.click();
		Thread.sleep(5000);
		waitUntilElementVisible(driver, this.selectAllCheckBox);
		this.selectAllCheckBox.click();
		logger.info("Ending of selectAllCheckBox method");
	}
	
	//Click On Exports
	public void clickOnExportDrodDown(){
		logger.info("Starting of click On export dropdown");
		waitUntilElementVisible(driver, this.exportDropDown);
		this.exportDropDown.click();
		logger.info("Ending of click on export dropdown");
	}
	
	//Click on ExportSelectedOption 
	public String clickOnExportSelected(String exportOptions) throws InterruptedException{
		for (int i = 0; i < this.exportOptions.size(); i++) {
			String exportName=this.exportOptions.get(i).getText();
			if (exportName.equalsIgnoreCase(exportOptions)){
				waitUntilElementVisible(driver, this.exportOptions.get(i));
				this.exportOptions.get(i).click();
				this.switchWindow();
				Thread.sleep(8000);
				waitUntilElementVisible(driver, this.exportSelectedStatus);
				exportSelectedStatusMsg=this.exportSelectedStatus.getText();
				break;
			}			
		}
		return exportSelectedStatusMsg;
		
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
