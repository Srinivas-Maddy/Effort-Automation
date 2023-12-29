package com.effort.works;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class CheckListProcessCeationPage extends BaseAutomationPage{

	private static final Logger logger=Logger.getLogger(CheckListProcessCeationPage.class.getName());

	@FindBy(xpath="//a[contains(text(),'App Builder')]")
	private WebElement appBuilder_Card;

	@FindBy(id="work")
	private WebElement workModule;

	@FindBy(xpath="//ul[@id='orderedUl']/li/a")
	private List<WebElement> workProcessModule;

	@FindBy(xpath="//div[@id='configure_workspec_body']/ul/li/span[2]/a")
	private List<WebElement> workProcessCards;

	@FindBy(xpath="(//input[contains(@value, 'Create Process ')])[1]")
	private WebElement createProcess_Btn;

	@FindBy(xpath="//a[contains(text(),'Create On My Own')]")
	private WebElement createMyown_Option;

	@FindBy(id="workSpecTitle")
	private WebElement checkListProcessName_Input;

	@FindBy(id="workSpecDescription")
	private WebElement checkListProcessDescription_Input;

	@FindBy(id="nxtButton")
	private WebElement next_Btn;
	
	@FindBy(xpath="//input[@value='Skip']")
	private WebElement skip_Btn;

	@FindBy(xpath="(//input[contains(@value,'+ Add Field')])[1]")
	private WebElement addField_Btn;

	@FindBy(xpath="(//div[@class='select2-container field type fieldType'])[1]")
	private WebElement firstAddedField;

	@FindBy(xpath="//ul[@id='select2-results-38']//li")
	private List <WebElement> userDefinedFields;

	@FindBy(xpath="//div[@class='select2-result-label']")
	private List<WebElement> labelNames;

	@FindBy(xpath="//div[@class='select2-result-label']")
	private List<WebElement> selectUserDefinedFields;
	
	@FindBy(xpath="//button[contains(text(),'Add Activity')]")
	private WebElement addActivity_Btn;
	
	@FindBy(xpath="//span[contains(text(),'----Select Form---')]")
	private WebElement selectForms;
	
	@FindBy(xpath="//ul[@role='listbox']/li[2]")
	private WebElement formSpecs;
	
	@FindBy(id="successMsg")
	private WebElement successMessage;

	public CheckListProcessCeationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnAppBuilder() {
		logger.info("Starting of clickOnAppBuilder Method");

		waitUntilElementVisible(driver, this.appBuilder_Card);
		clickOnWebElement(this.appBuilder_Card);

		logger.info("Ending of ClickOnAppBuilder Method");
	}


	public void clickOnWorkProcess() {
		logger.info("Starting of clickOnWorkProcess");

		waitUntilElementVisible(driver, this.workModule);
		clickOnWebElement(this.workModule);

		logger.info("Ending of clickOnWorkProcess");
	}

	public void clickOnChecklistProcess() {
		logger.info("Starting of clickOnChecklistProcess");

		for (int i = 0; i < this.workProcessCards.size(); i++) {
			String cardNames=this.workProcessCards.get(i).getText();
			if (cardNames.equalsIgnoreCase("Checklist Process")) {
				waitUntilElementVisible(driver, this.workProcessCards.get(i));
				clickOnWebElement(this.workProcessCards.get(i));
			}
		}
		logger.info("Ending of clickOnChecklistProcess");
	}

	public void clickOnCreateProcess() {
		logger.info("Starting of clickOnCreateProcess Method");

		waitUntilElementVisible(driver, this.createProcess_Btn);
		clickOnWebElement(this.createProcess_Btn);
		waitUntilElementVisible(driver, this.createMyown_Option);
		clickOnWebElement(this.createMyown_Option);

		logger.info("Ending of clickOnCreateProcess Method");
	}

	public String enterProcessTitle(String procssName, String description) {
		logger.info("Starting of enterProcessTitle Method");

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String processName=procssName+"_"+timeStamp;
		waitUntilElementVisible(driver, this.checkListProcessName_Input);
		this.checkListProcessName_Input.sendKeys(processName);
		waitUntilElementVisible(driver, this.checkListProcessDescription_Input);
		this.checkListProcessDescription_Input.sendKeys(description);
		clickOnWebElementUsingJavascript(this.next_Btn);

		logger.info("Ending of enterProcessTitle Method");
		return processName;
	}

	public void addWorkField() {
		logger.info("Starting of addWorkField Method");

		int count=2;
		int labelCount=19;
		waitUntilElementVisible(driver, this.addField_Btn);
		clickOnWebElement(this.addField_Btn);
		scrollIntoView(this.firstAddedField);
		clickOnWebElement(this.firstAddedField);
		int userDefinedFieldsCount=this.userDefinedFields.size();

		for (int i = 0; i < userDefinedFieldsCount; i++) {
			String lableName=this.labelNames.get(i).getText();

			if(!lableName.equals("Datespan") && !lableName.equals("DateTimespan") && !lableName.equals("Dropdown") && !lableName.equals("Multi Select Dropdown") && !lableName.equalsIgnoreCase("Location diff")&& !lableName.equalsIgnoreCase("Location To Address")) {
				//driver.findElements(By.xpath("//div[@class='select2-result-label']")).get(i).click();	
				this.selectUserDefinedFields.get(i).click();
				driver.findElement(By.xpath("//input[@id='formFieldSpecs"+labelCount+"_fieldLabel']")).sendKeys("Normal_Fields_"+lableName);
				if(i==userDefinedFieldsCount-1){
					break;
				}
				waitUntilElementVisible(driver, this.addField_Btn);
				clickOnWebElement(this.addField_Btn);
				driver.findElement(By.xpath("(//div[@class='select2-container field type fieldType'])["+count+"]")).click();
				count++;
				labelCount++;
				logger.info("Loop end");
			}		

		}
		clickOnWebElement(this.next_Btn);
		driver.switchTo().alert().accept();		
		
		logger.info("Ending of addWorkField method");

	}

	public void manageForms() {
		logger.info("Starting of manageForms Method");
		
		hardWait(2);
		waitUntilElementVisible(driver, this.next_Btn);
		clickOnWebElement(this.next_Btn);
		
		logger.info("Starting of manageForms Method");
	}
	
	public void manageActivities() {
		logger.info("Starting of manageActivities Method");
		
		hardWait(3);
		waitUntilElementVisible(driver, this.addActivity_Btn);
		

		for(int i=0;i<=5;i++) {
			waitUntilElementVisible(driver, this.addActivity_Btn);
			scrollIntoView(addActivity_Btn);
			clickOnWebElement(addActivity_Btn);
			driver.findElement(By.xpath("//input[@name='workActionSpec["+i+"].actionName']")).sendKeys("Action_"+i);
			//ActionName.sendKeys("Action_"+i);
			selectForms.click();
			formSpecs.click();
		}
		
		clickOnWebElement(this.next_Btn);
		driver.switchTo().alert().accept();
		
		logger.info("Ending of manageActivities Method");

	}
	
	public void cloneFieldsData() {
		logger.info("Starting of cloneFieldsData");
		
		hardWait(2);
		waitUntilElementVisible(driver, this.next_Btn);
		clickOnWebElement(this.next_Btn);
		
		logger.info("Ending of cloneFieldsData");

	}
	
	public void manageFlow() {
		logger.info("Starting manageFlow method ");
		
		hardWait(2);
		waitUntilElementVisible(driver, this.next_Btn);
		clickOnWebElement(this.next_Btn);
		driver.switchTo().alert().accept();
	
		logger.info("Ending manageFlow method ");

	}
	
	public void defineAutoAllocation() {
		logger.info("Starting defineAutoAllocation method ");
		
		hardWait(2);
		waitUntilElementVisible(driver, this.skip_Btn);
		clickOnWebElement(this.skip_Btn);
		
		logger.info("Ending defineAutoAllocation method ");
	}
	
	public String settings() {
		logger.info("Starting settings method ");
		
		hardWait(2);
		waitUntilElementVisible(driver, this.next_Btn);
		clickOnWebElement(this.next_Btn);
		
		hardWait(5);
		waitUntilElementVisible(driver, this.next_Btn);
		clickOnWebElement(this.next_Btn);
			
		waitUntilElementVisible(driver, this.successMessage);
		String sucessMessage=this.successMessage.getText();
		
		logger.info("Ending settings method ");

		return sucessMessage;
	}
	
	
}


