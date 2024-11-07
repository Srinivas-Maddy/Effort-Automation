package com.effort.exports;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class WorkExportsPage extends BaseAutomationPage{

	private static final Logger logger = Logger.getLogger(WorkExportsPage.class.getName());
	
	@FindBy(xpath = "//a[contains(text(),'Web App')]")
	private WebElement webApp;
	
	@FindBy(id="work")
	private WebElement workModule;
	
	@FindBy(xpath="//h5[contains(text(),'Automation Action Procoss')]")
	private WebElement workProcessCard;
	
	@FindBy(id="export-v")
	private WebElement exportOptions;
	
	@FindBy(xpath="(//div[@id='export-v']/ul/li/a)[3]")
	private WebElement exportAllOption;
	
	@FindBy(xpath="//button[contains(text(),'Confirm')]")
	private WebElement confirmBtn;
	
	@FindBy(xpath="//ul[@id='worksStatusTypes']/li[1]")
	private WebElement yetToStartBar;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td/input[@id='selectWork']")
	private List<WebElement> checkBoxes;
	
	@FindBy(xpath="(//div[@id='export-v']/ul/li/a)[2]")
	private WebElement exportSelected;
	
	@FindBy(xpath="(//div[@id='export-v']/ul/li/a)[1]")
	private WebElement exportFilterd;
	
	@FindBy(id="progress")
	private WebElement progressStatus;
	
	@FindBy(id="filters")
	private WebElement filterBtn;
	
	@FindBy(xpath="//div[@id='s2id_F1S_F4F']")
	private WebElement empField;
	
	@FindBy(xpath="//input[@id='s2id_autogen14_search']")
	private WebElement employeeNameInput;
	
	@FindBy(xpath="//ul[@id='select2-results-14']/li[1]")
	private WebElement empSearchResult;
	
	@FindBy(id="search")
	private WebElement applyFilterBtn;
	
	@FindBy(id="reset")
	private WebElement resetBtn;
	
	//Constructor
	public WorkExportsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnWebApp() {
		logger.info("Starting of clickOnWebApp Method");
		
		try {
			waitUntilElementVisible(driver, this.webApp);
			clickOnWebElement(this.webApp);
		} catch (Exception e) {
			clickOnWebElementUsingJavascript(this.webApp);
		}
		
		logger.info("Ending of clickOnWebApp Method");
	}
	
	public void clickOnProcessModule() {
		logger.info("Starting of clickOnProcessModule Method");
		
		try {
			switchToNewWindow(0);
			waitUntilElementVisible(driver, this.workModule);
			clickOnWebElement(workModule);
		} catch (Exception e) {
			try {
				clickOnWebElementUsingJavascript(workModule);
			} catch (Exception e2) {
				logger.info("Element Not Fond, Reason : "+e2);
			}
		}	
		logger.info("Ending of clickOnProcessModule Method");
	}
	
	public void clickOnProccessName() {
		logger.info("Starting of clickOnProccessName Method");
		
		try {
			waitUntilElementVisible(driver, this.workProcessCard);
			clickOnWebElement(this.workProcessCard);
		} catch (Exception e) {
			try {
				clickOnWebElementUsingJavascript(workProcessCard);
			} catch (Exception e2) {
				logger.info("Process name card Element is not found : "+e2);
			}
		}
		
		logger.info("Ending of clickOnProccessName Method");
	}
	
	public void clickOnExportOptions() {
		logger.info("Starting of clickOnExportOptions Method");
		
		try {
			waitUntilElementVisible(driver, this.exportOptions);
			scrollIntoView(exportOptions);
			clickOnWebElement(this.exportOptions);
		} catch (Exception e) {
			try {
				clickOnWebElementUsingJavascript(this.exportOptions);
			} catch (Exception e2) {
				logger.info("Export Options element is not Fouund : "+e2);			}
		}
		
		logger.info("Ending of clickOnExportOptions Method");
	}
	
	public void clickOnExportAllOption() {
		logger.info("Starting of clickOnExportAllOption Method");
		
		try {
			waitUntilElementVisible(driver, exportAllOption);
			clickOnWebElement(exportAllOption);
		} catch (Exception e) {
			try {
				clickOnWebElementUsingJavascript(exportAllOption);
			} catch (Exception e2) {
				logger.info("Export All Option is not Found : "+e2);				}
		}
		
		logger.info("Ending of clickOnExportAllOption Method");
	}
	
	public void clickOnConfirm() {
		logger.info("Starting of clickOnConfirm Method");
		
		try {
			waitUntilElementVisible(driver, confirmBtn);
			clickOnWebElement(confirmBtn);
			hardWait(5);
		} catch (Exception e) {
			clickOnWebElementUsingJavascript(confirmBtn);
		}
		
		logger.info("Ending of clickOnConfirm Method");
	}
	
	public void clickOnYetToStartWorks() {
		logger.info("Starting of clickOnYetToStartWorks Method");
		try {
			waitUntilElementVisible(driver, this.yetToStartBar);
			clickOnWebElement(this.yetToStartBar);
			hardWait(10);
		} catch (Exception e) {
			try {
				clickOnWebElementUsingJavascript(this.yetToStartBar);
			} catch (Exception e2) {
				logger.info("Yet to Start Button is not Found : "+e2);				}
			}		
		logger.info("Ending of clickOnYetToStartWorks Method");
	}
	
	public void selectCheckbox() {
		logger.info("Starting of selectCheckbox Method");
		
		hardWait(10);
		scrollIntoView(this.checkBoxes.get(0));

		for (int i = 0; i < checkBoxes.size(); i++) {
			waitUntilElementVisible(driver, this.checkBoxes.get(i));
			clickOnWebElement(this.checkBoxes.get(i));
			if(i>4){
				break;
			}	
		}
		
		logger.info("Ending of selectCheckbox Method");
	}
	
	public void clickOnSelectAll() {
		logger.info("Starting of selectCheckbox Method");
		
		try {
			waitUntilElementVisible(driver, this.exportSelected);
			clickOnWebElement(this.exportSelected);
			switchToNewWindow(2);
		} catch (Exception e) {
			clickOnWebElementUsingJavascript(this.exportSelected);
		}
		
		logger.info("Ending of selectCheckbox Method");
	}
	
	public String getSheetDownloadStatus() {
		logger.info("Starting of getSheetDownloadStatus Method");
		
		String status=null;
		try {
			hardWait(10);
			waitUntilElementVisible(driver, progressStatus);
			status=this.progressStatus.getText();
		} catch (Exception e) {
			try {
				waitUntilElementVisible(driver, this.progressStatus);
				status=this.progressStatus.getText();
			} catch (Exception e2) {
				logger.info("Export Selected Status element is not Found : "+e2);				}
		}
		hardWait(15);
		switchToNewWindow(0);
		
		logger.info("Ending of getSheetDownloadStatus Method");
     return status;
	}
	
	public void clickOnFilter() {
		logger.info("Starting of clickOnFilter Menthod");
		
			waitUntilElementVisible(driver, this.filterBtn);
			scrollIntoView(this.filterBtn);
			clickOnWebElement(this.filterBtn);
			
		logger.info("Ending of clickOnFilter Menthod");
	}
	
	public void selectEmployee(String name){
		logger.info("Starting of selectEmployee Method");
		
		waitUntilElementVisible(driver, this.empField);
		scrollIntoView(this.empField);
		clickOnWebElement(this.empField);
		waitUntilElementVisible(driver, this.employeeNameInput);
		this.employeeNameInput.sendKeys(name);
		try {
			waitUntilElementVisible(driver, this.empSearchResult);
			clickOnWebElement(empSearchResult);
		} catch (Exception e) {
			try {
				clickOnWebElementUsingJavascript(this.empSearchResult);
			} catch (Exception e2) {
				logger.info("Employee Result is not Found, Exception :"+e2);
			}
		}
		
		logger.info("Ending of selectEmployee Method");
	}
	
	public void clickOnApplyFilter() {
		logger.info("Starting of clickOnApplyFilter Method");
		
		waitUntilElementVisible(driver, this.applyFilterBtn);
		scrollIntoView(this.applyFilterBtn);
		clickOnWebElement(this.applyFilterBtn);
		hardWait(10);
		
		logger.info("Ending of clickOnApplyFilter Method");
	}
	
	
	public void clickOnReset() {
		logger.info("Starting of clickOnReset Method");
		
		waitUntilElementVisible(driver, this.resetBtn);
		clickOnWebElement(this.resetBtn);
		
		logger.info("Ending of clickOnReset Method");
	}
	
	public void clickOnExportFiltered() {
		logger.info("Starting of clickOnExportFiltered Method");
		
		try {
			waitUntilElementVisible(driver, this.exportFilterd);
			clickOnWebElement(this.exportFilterd);
			switchToNewWindow(3);
		} catch (Exception e) {
			clickOnWebElementUsingJavascript(this.exportFilterd);
		}
		
		logger.info("Ending of clickOnExportFiltered Method");
	}
	
	public String getExportFilteredtatus() {
		logger.info("Starting of getExportFilteredtatus Method");
		
		String status=null;
		try {
			hardWait(20);
			waitUntilElementVisible(driver, progressStatus);
			status=this.progressStatus.getText();
		} catch (Exception e) {
			try {
				waitUntilElementVisible(driver, this.progressStatus);
				status=this.progressStatus.getText();
			} catch (Exception e2) {
				logger.info("Export Filtered Status element is not Found : "+e2);				}
		}
		
		logger.info("Ending of getSheetDownloadStatus Method");
     return status;
	}
	
}
