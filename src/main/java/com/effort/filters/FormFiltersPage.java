package com.effort.filters;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class FormFiltersPage extends BaseAutomationPage{

	private static final Logger logger = Logger.getLogger(FormFiltersPage.class.getName());
	
	@FindBy(id="forms")
	private WebElement formModule;
	
	@FindBy(xpath="(//h5[contains(text(),'All Field Form Auto')])[2]")
	private WebElement formSpecName;
	
	@FindBy(id="filters")
	private WebElement filterBtn;
	
	@FindBy(id="reset")
	private WebElement resetFilterBtn;
	
	@FindBy(id="search")
	private WebElement applyFilterBtn;
	
	@FindBy(id="formIdsForFiltering")
	private WebElement formIDInputField;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td[3]/a")
	private WebElement formIdFilteredResult;
	
	@FindBy(id="s2id_F1S_filledBy")
	private WebElement filedByBtn;
	
	@FindBy(id="s2id_autogen5_search")
	private WebElement employeeInputField;
	
	@FindBy(xpath="(//ul[@id='select2-results-5']/li/div)[1]")
	private WebElement employeeNameResult;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr[1]/td[23]/a")
	private WebElement filedByEmpNameResult;
	
	@FindBy(id="s2id_F1S_modifiedBy")
	private WebElement modifiedByBtn;
	
	@FindBy(id="s2id_autogen6_search")
	private WebElement modifiedEmpSearchInput;
	
	@FindBy(xpath="(//ul[@id='select2-results-6']/li/div)[1]")
	private WebElement modifiedEmpNames;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr[1]/td[25]/a")
	private WebElement modifiedByNameResult;
	
	@FindBy(id="F1S_createdTime_1")
	private WebElement filledDate;
	
	@FindBy(xpath="(//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_' ])[3]/div/div[2]/table/tbody/tr/td[@data-date='1']")
	private WebElement firstDateInTheMonth;
	
	@FindBy(xpath="((//div[@class='xdsoft_time_box xdsoft_scroller_box'])[3]/div)[1]/div[contains(@class,'xdsoft_current')]")
	private WebElement currentTimeFromDate;
	
	@FindBy(xpath="(//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_' ])[4]/div/div[2]/table/tbody/tr/td[contains(@class,'xdsoft_current xdsoft_today')]")
	private WebElement currentDate;
	
	@FindBy(xpath="((//div[@class='xdsoft_time_box xdsoft_scroller_box'])[4]/div)[1]/div[contains(@class,'xdsoft_current')]")
	private WebElement currentTimeToDate;
	
	@FindBy(id="F1S_createdTime_2")
	private WebElement andDateField;
	
	@FindBy(id="F1S_F2F")
	private WebElement currencyInput;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr[1]/td[4]")
	private WebElement currencyFilterResult;
	
	@FindBy(id="F1S_F3F_1")
	private WebElement dateField;
	
	@FindBy(xpath="(//div[contains(@class,'xdsoft_calendar')])[7]/table/tbody/tr/td[@data-date='1']")
	private WebElement pickMonthFirstDate;
	
	@FindBy(id="F1S_F3F_2")
	private WebElement formDate;
	
	@FindBy(xpath="(//div[contains(@class,'xdsoft_calendar')])[8]/table/tbody/tr/td[contains(@class,'xdsoft_current xdsoft')]")
	private WebElement pickCurrentDate;
	
	@FindBy(id="F1S_F7F")
	private WebElement numberFieldInput;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr[1]/td[9]")
	private WebElement numberFilterResult;
	
	@FindBy(id="F1S_F8F")
	private WebElement textInput;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr[1]/td[10]")
	private WebElement textFilterResult;
	
	@FindBy(id="F1S_F11F")
	private WebElement emailInput;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr[1]/td[12]/font")
	private WebElement emailFilterResult;
	
	public FormFiltersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public void clickOnForms() {
		
		logger.info("Starting of clickOnForms Method");
		
		waitUntilElementVisible(driver, this.formModule);
		clickOnWebElement(formModule);
		
		logger.info("Ending of clickOnForms Method");
	}
	
	public void clickOnFormSpec() {
		
		logger.info("Starting of clickOnFormSpec Method");
		try {
			waitUntilElementVisible(driver, this.formSpecName);
			clickOnWebElement(this.formSpecName);
		} catch (Exception e) {
			try {
				clickOnWebElementUsingJavascript(formSpecName);
			} catch (Exception e2) {
				logger.info("Form Spec Name is not Found in the list"+e2);
			}
		}

		logger.info("Ending of clickOnFormSpec Method");
	}
	
	public void clickOnFilter() {
		
		logger.info("Starting of clickOnFilter Method");
		
		waitUntilElementVisible(driver, this.filterBtn);
		clickOnWebElement(this.filterBtn);
		
		logger.info("Ending of clickOnFilter Method");
	}
	
	public void clickOnReset() {
		
		logger.info("Starting of clickOnReset Method");
		
		waitUntilElementVisible(driver, this.resetFilterBtn);
		clickOnWebElement(this.resetFilterBtn);
		
		logger.info("Ending of clickOnReset Method");
	}
	
	public void clickOnApply() {
		logger.info("Starting of clickOnApply Method");
		
		waitUntilElementVisible(driver, this.applyFilterBtn);
		clickOnWebElement(this.applyFilterBtn);
		
		logger.info("Ending of clickOnApply Method");
	}
	
	public void filterWithFormId(String formId) {
		
		logger.info("Starting of filterWithFormId Method");
		
		waitUntilElementVisible(driver, formIDInputField);
		scrollIntoView(this.formIDInputField);
		this.formIDInputField.sendKeys(formId);
		
		logger.info("Ending of filterWithFormId Method");
	}
	
	public String getFormIDResult() {
		logger.info("Starting of getFormIDResult Method");
		
		String formID=null;
		try {
			hardWait(5);
			waitUntilElementVisible(driver, this.formIdFilteredResult);
			formID=this.formIdFilteredResult.getText();
		} catch (Exception e) {
			try {
				waitUntilElementVisible(driver, this.formIdFilteredResult);
				formID=this.formIdFilteredResult.getText();
			} catch (Exception e2) {
				logger.info("Filtered form id is not found,"+e2);
			}
		}
		
		logger.info("Ending of getFormIDResult Method");

		return formID;
	}
	
	public void selectFiledByName(String name) {
		logger.info("Starting of selectFiledByName Method");
		
		waitUntilElementVisible(driver, this.filedByBtn);
		clickOnWebElement(this.filedByBtn);
		waitUntilElementVisible(driver, this.employeeInputField);
		this.employeeInputField.sendKeys(name);
		
		try {
			waitUntilElementVisible(driver, this.employeeNameResult);
			clickOnWebElement(employeeNameResult);
		} catch (Exception e) {
			try {
				clickOnWebElementUsingJavascript(employeeNameResult);
			} catch (Exception e2) {
				logger.info("Filled Employee name is not found."+e2);
			}
		}
		
		logger.info("Ending of selectFiledByName Method");
	}
	
	public String getFilledByNameResult() {
		logger.info("Starting of getFilledByNameResult Method");

		String result=null;
		try {
			waitUntilElementVisible(driver, this.filedByEmpNameResult);
			scrollIntoView(this.filedByEmpNameResult);
			result=this.filedByEmpNameResult.getText();
		} catch (Exception e) {
			scrollIntoView(this.filedByEmpNameResult);
			result=this.filedByEmpNameResult.getText();
		}
		
		logger.info("Ending of getFilledByNameResult Method");
		
		return result;
	}
	
	public void selectModifiedByName(String name) {
		logger.info("Starting of selectModifiedByName Method");
		
		waitUntilElementVisible(driver, this.modifiedByBtn);
		clickOnWebElement(this.modifiedByBtn);
		waitUntilElementVisible(driver, this.modifiedEmpSearchInput);
		this.modifiedEmpSearchInput.sendKeys(name);
		
		try {
			waitUntilElementVisible(driver, this.modifiedEmpNames);
			clickOnWebElement(modifiedEmpNames);
		} catch (Exception e) {
			try {
				clickOnWebElementUsingJavascript(modifiedEmpNames);
			} catch (Exception e2) {
				logger.info("Modified Employee name is not found."+e2);
			}
		}
		
		logger.info("Ending of selectModifiedByName Method");
	}
	
	public String getModifiedByNameResult() {
		logger.info("Starting of getModifiedByNameResult Method");

		String result=null;
		try {
			waitUntilElementVisible(driver, this.modifiedByNameResult);
			scrollIntoView(this.modifiedByNameResult);
			result=this.modifiedByNameResult.getText();
		} catch (Exception e) {
			scrollIntoView(this.modifiedByNameResult);
			result=this.modifiedByNameResult.getText();
		}
		
		logger.info("Ending of getFilledByNameResult Method");
		
		return result;
	}
	
	public void clickOnFilledDate() {
		logger.info("Starting of clickOnFilledDate Method");
		
		waitUntilElementVisible(driver, this.filledDate);
		scrollIntoView(filledDate);
		clickOnWebElement(filledDate);
		try {
			hardWait(2);
			waitUntilElementVisible(driver, this.firstDateInTheMonth);
			clickOnWebElement(firstDateInTheMonth);
			clickOnWebElement(this.currentTimeFromDate);
		} catch (Exception e) {
			try {
				hardWait(2);
				clickOnWebElementUsingJavascript(this.firstDateInTheMonth);
			} catch (Exception e2) {
				logger.info("Form submission Date is not found "+e2);
			}
		}

		logger.info("Ending of clickOnFilledDate Method");
	}
	
	public void clickOnEndDate() {
		logger.info("Starting of clickOnAndDate Method");
		
		waitUntilElementVisible(driver, this.andDateField);
		clickOnWebElement(this.andDateField);
		try {
			hardWait(2);
			waitUntilElementVisible(driver, this.currentDate);
			clickOnWebElement(this.currentDate);
			clickOnWebElement(this.currentTimeToDate);
		} catch (Exception e) {
			try {
				hardWait(2);
				clickOnWebElementUsingJavascript(this.currentDate);
			} catch (Exception e2) {
				logger.info("Current Date element is not found"+e2);
			}
		}
		
		logger.info("Ending of clickOnAndDate Method");
	}
	
	public void enterCurrency(String value) {
		logger.info("Starting of enterCurrency Method");
		
		waitUntilElementVisible(driver, this.currencyInput);
		scrollIntoView(this.currencyInput);
		this.currencyInput.sendKeys(value);
		
		logger.info("Ending of enterCurrency Method");
	}
	
	public String getCurrencyFilterResult() {
		
		logger.info("Starting of getCurrencyFilterResult Method");
		
		String result=null;
		hardWait(10);
		waitUntilElementVisible(driver, this.currencyFilterResult);
		result=this.currencyFilterResult.getText();
		
		logger.info("Ending of getCurrencyFilterResult Method");

		return result;
	}
	
	public void clickOnFormDate() {
	
		logger.info("Starting of clickOnFormDate Method");
		
		waitUntilElementVisible(driver, this.dateField);
		clickOnWebElement(this.dateField);
		try {
			waitUntilElementVisible(driver,this.pickMonthFirstDate);
			clickOnWebElement(this.pickMonthFirstDate);
		} catch (Exception e) {
			try {
				waitUntilElementVisible(driver, this.pickMonthFirstDate);
				clickOnWebElementUsingJavascript(this.pickMonthFirstDate);
			} catch (Exception e2) {
				logger.info("Selected Date field web element not found"+e2);
			}
		}
			
		logger.info("Ending of clickOnFormDate Method");
	}
	
	public void clickOnToDate() {
		logger.info("Starting of clickOnToDate method");
		
		waitUntilElementVisible(driver, this.formDate);
		clickOnWebElement(this.formDate);
		hardWait(1);
		try {
			waitUntilElementVisible(driver, this.pickCurrentDate);
			clickOnWebElement(this.pickCurrentDate);
		} catch (Exception e) {
			try {
				waitUntilElementVisible(driver, this.pickCurrentDate);
				clickOnWebElementUsingJavascript(this.pickCurrentDate);
			} catch (Exception e2) {
				logger.info("Unable to Find the To Date"+e2);
			}
		}
		
		logger.info("Ending of clickOnToDate method");
	}
	
	public void enterNumberValue(String numberValue) {
		logger.info("Starting of enterCurrecnyValue Method");
		
		waitUntilElementVisible(driver, this.numberFieldInput);
		this.numberFieldInput.sendKeys(numberValue);
		
		logger.info("Ending of enterCurrecnyValue Method");
	}
	
	public String getNumberResult() {
		logger.info("Starting of getNumberResult Method");
		
		waitUntilElementVisible(driver, this.numberFilterResult);
		String numberResult=this.numberFilterResult.getText();
		
		logger.info("Starting of getNumberResult Method");
		
		return numberResult;
	}
	
	public void enterTextInputValue(String textValue) {
		logger.info("Starting of enterTextInputValue Method");
		
		waitUntilElementVisible(driver, this.textInput);
		this.textInput.sendKeys(textValue);
		
		logger.info("Ending of enterTextInputValue Method");
	}
	
	public String getTextFilterResult() {
		logger.info("Starting of getTextFilterResult Method");
		
		waitUntilElementVisible(driver, this.textFilterResult);
		String textResult=this.textFilterResult.getText();
		
		logger.info("Ending of getTextFilterResult Method");

		return textResult;
	}
	
	public void enterEmailId(String email) {
		logger.info("Starting of enterEmailId Method");
		
		waitUntilElementVisible(driver, this.emailInput);
		this.emailInput.sendKeys(email);
		
		logger.info("Ending of enterEmailId Method");
	}
	
	public String getEmailFilterResult() {
		logger.info("Starting of getEmailFilterResult Method");
		
		waitUntilElementVisible(driver, this.emailFilterResult);
		String emailResult=this.emailFilterResult.getText();
		
		logger.info("Ending of getEmailFilterResult Method");
		
		return emailResult;
	}
	
}
