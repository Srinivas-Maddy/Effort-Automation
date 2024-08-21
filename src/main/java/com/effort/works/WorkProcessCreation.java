package com.effort.works;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.effort.base.BaseAutomationPage;


public class WorkProcessCreation extends BaseAutomationPage{

	private static final Logger logger = Logger.getLogger(WorkProcessCreation.class);

	public static WebDriverWait waitElementVisiblity=null; 

	public String WorkSpecName=null;

	public static String timeStamp;

	@FindBy(xpath="//a[text()='App Builder']")
	private WebElement configurator;

	@FindBy(id="work")
	private WebElement processButton;

	@FindBy(xpath="//li[@title='Activity Process']/span[2]/a")
	private WebElement actionProcess;

	@FindBy(xpath="//input[@value='Create Process ']")
	private WebElement createProcess;

	@FindBy(xpath="//a[contains(text(),'Create On My Own')]")
	private WebElement createOnMyOwnProcess;

	@FindBy(id="workSpecTitle")
	private WebElement workTitle;

	@FindBy(id="workSpecDescription")
	private WebElement processDescription;

	@FindBy(xpath="//input[@id='nxtButton']")
	private WebElement nextButton;

	@FindBy(xpath="//body/div[@id='bodyDiv']/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
	private WebElement addFieldBtn;

	@FindBy(xpath="(//div[@class='select2-container field type fieldType'])[1]")
	private WebElement firstAddedField;


	@FindBy(id="formFieldSpecs20_fieldLabel")
	private WebElement fieldLabel;

	@FindBy(id="formFieldSpecs19_fieldLabel")
	private WebElement fieldlabelValue;

	@FindBy(xpath="//input[@id='nxtButton']")
	private WebElement FlowNext;

	@FindBy(xpath="//button[contains(text(),'Add Activity')]")
	private WebElement addActionBtn;

	@FindBy(xpath="//ul[@id='select2-results-38']//li")
	private List <WebElement> userDefinedFields;

	@FindBy(xpath="//div[@class='select2-result-label']")
	private List<WebElement> labelNames;

	@FindBy(xpath="//div[@class='select2-result-label']")
	private List<WebElement> selectUserDefinedFields;

	@FindBy(xpath="//input[@id='nxtButton']")
	private WebElement formSpecButton;


	@FindBy(xpath="(//input[@class='form-control processSequenceBlur'])[1]")
	private WebElement ActionName;

	@FindBy(xpath="//span[contains(text(),'----Select Form---')]")
	private WebElement selectForms;

	@FindBy(xpath="//ul[@role='listbox']/li[2]")
	private WebElement formSpecs;

	@FindBy(xpath="//input[@id='nxtButton']")
	private WebElement cloneNxtBtn;

	@FindBy(xpath="//input[@value='Skip']")
	private WebElement skipBtn;

	@FindBy(xpath="//input[@id='nxtButton']")
	private WebElement ManageFlowNxtBtn;

	@FindBy(xpath="//input[@id='nxtButton']")
	private WebElement SettingsNxtBtn;

	@FindBy(xpath="//input[@id='nxtButton']")
	private WebElement OtherNxtBtn;


	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement switchOption;

	@FindBy(xpath="//ul[@class='dropdown-menu']//li[4]/a/i")
	private WebElement webApp;	

	@FindBy(xpath="//li[@id='work']")
	private WebElement work;

	@FindBy(xpath="//input[@id='searchText']")
	private WebElement searchBox;

	@FindBy(xpath="//a[contains(text(),'Manage Fields')]")
	private WebElement modifyFieldsCard;

	@FindBy(xpath="(//input[@value='+ Add Field'])[2]")
	private WebElement addFieldsButton;

	@FindBy(xpath="//input[@id='formFieldSpecs53_fieldLabel']")
	private WebElement modifiedFieldLabelInputField;

	@FindBy(xpath="//ul[@class='workspecActionsConfig']/li/span[2]/a")
	private List<WebElement> workProcessCardList;
	
	@FindBy(xpath="//a[contains(text(),'Restrict Access To Employee Groups')]")
	private WebElement crdRestrictEmp;

	@FindBy(xpath="//input[@id='formFieldSpecs54_fieldLabel']")
	private WebElement addNewWorkField;

	@FindBy(xpath="//label[contains(text(),'Saved Successfully')]")
	private WebElement modifyWorkFieldsStatusMsg;
	
	@FindBy(xpath="//input[@name='workActionSpec[6].actionName']")
	private WebElement newActionName_Input;
	
	@FindBy(xpath="//div[@id='s2id_formSpecAction_6']")
	private WebElement actionFormDropDown;
	
	@FindBy(xpath="//ul[@id='select2-results-20']/li[3]")
	private WebElement select_ActionSpec;
	
	@FindBy(xpath="//div[@id='attachButton']/button")
	private WebElement addAttachment_Btn;
	
	@FindBy(xpath="//div[@id='s2id_attachmentFormSpecUniqueIdRow_0']/a/span[1]")
	private WebElement addActachment_DropDown;
	
	@FindBy(xpath="//div[@role='option'][contains(text(),'ApprovalForm')]")
	private WebElement select_Attachment_Form;
	
	@FindBy(xpath="(//input[@value='Save'])[2]")
	private WebElement managerActivities_Save_Btn;

	@FindBy(xpath="//a[contains(text(),'Withdraw')]")
	private WebElement withDrawnBtn;

	@FindBy (xpath="//select[@class='unselected']")
	private WebElement employeeGroups;
	
	@FindBy(xpath="(//span[@class='glyphicon glyphicon-chevron-right'])[2]")
	private WebElement moveEmpGrp_Btn;
	
	@FindBy(xpath="//input[@id='save']")
	private WebElement save_Btn;
	
	@FindBy(id="viewCheckBox")
	private WebElement viewCheckBox;
	
	@FindBy(id="s2id_viewGroupIds")
	private WebElement empGroupDropdown;
	
	@FindBy(xpath="//div[@id='select2-drop']/ul/li[1]")
	private WebElement empGroup;
	
	@FindBy(xpath="//a[contains(text(),'Go back to Work Activity Process Screen')]")
	private WebElement backToWorkCards;
	
	@FindBy(xpath="(//div[contains(@id, 's2id_empWorkField')])[1]")
	private WebElement actionSelection_Dropdown;
	
	@FindBy(xpath="(//div[@id='select2-drop']/ul/li)[1]")
	private WebElement selectEmployee;
	
	@FindBy(id="enableWorkCheckIn")
	private WebElement workCheckIn_Checkbox;
	
	@FindBy(xpath="(//input[@value='Save'])[1]")
	private WebElement settingsSave_btn;
	
	@FindBy(xpath="(//input[@value='Save'])[2]")
	private WebElement saveBtn;

	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;
	
	@FindBy(id="home")
	private WebElement homeModule;
	
	@FindBy(xpath="//a[contains(text(),'Create Process')]")
	private WebElement createProcess_Card;
	
	@FindBy(xpath="//div[@id='workSpecspopup']/div/div[1]/div[1]")
	private WebElement activityProcessOption;
	
	@FindBy(xpath="(//a[contains(text(),'Create On My Own')])[2]")
	private WebElement createMyOwnOption;
	
	@FindBy(xpath="//a[contains(text(),'Withdraw')]")
	private WebElement withDrawCard;
	
	@FindBy(xpath="(//div[@id='configure_workspec_body'])[1]/ul/li/span[2]/a")
	private List<WebElement> activeWorkSpecDetails;

	//Parameterized cunstructor
	public WorkProcessCreation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}


	public void clickOnConfigurator() {
		logger.info("Starting of clickOnConfigurator Method");
		this.configurator.click();
		logger.info("Ending of clickOnConfigurator Method");

	}

	public void clickOnProcess() {
		logger.info("Starting of clickOnProcess Method");
		waitUntilElementVisible(driver, this.processButton);
		this.processButton.click();
		logger.info("Ending of clickOnConfigurator Method");

	}


	public void clickOnActionProcess() {
		logger.info("Starting of clickOnActionProcess Method");
		waitUntilElementVisible(driver, this.actionProcess);
		this.actionProcess.click();
		logger.info("Ending of clickOnActionProcess Method");

	}

	public void clickOnCreateProcess() {
		logger.info("Starting of clickOnCreateProcess Method");
		waitUntilElementVisible(driver, this.createProcess);
		this.createProcess.click();
		logger.info("Ending of clickOnCreateProcess Method");

	}

	public void clickOnCreateMyOwnProcess() {
		logger.info("Starting of clickOnCreateMyOwnProcess Method");
		waitUntilElementVisible(driver, this.createOnMyOwnProcess);
		this.createOnMyOwnProcess.click();
		logger.info("Ending of clickOnCreateMyOwnProcess Method");
	}

	public void workProcessTitle(String specName) {
		logger.info("Starting of work title method");
		waitUntilElementVisible(driver, this.workTitle);
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		WorkSpecName=specName+"_"+timeStamp;
		this.workTitle.sendKeys(WorkSpecName);
		logger.info("Ending of work title menthod");
	}

	public void workProcessDiscription(String specDisc) {
		logger.info("Starting of workProcessDiscription method");
		waitUntilElementVisible(driver, this.processDescription);
		this.processDescription.sendKeys(specDisc);
		logger.info("Ending of work title menthod");

	}

	public void clickOnNextBtn() {
		logger.info("Starting of clickOnNextBtn Method");
		waitUntilElementVisible(driver, this.nextButton);
		this.nextButton.click();
		logger.info("Ending of clickOnNextBtn Method");
	}

	public void clickOnAddFieldBtn() {
		logger.info("Starting of clickOnAddFieldBtn Method");
		waitUntilElementVisible(driver, this.addFieldBtn);
		this.addFieldBtn.click();
		logger.info("Ending of clickOnAddFieldBtn Method");	
	}

	public void clickOnFirstAddedField() {
		logger.info("Starting of clickOnFirstAddedField Method");
		waitUntilElementVisible(driver, this.firstAddedField);
		mouseHoverAndClick(firstAddedField);
		//this.firstAddedField.click();
		logger.info("Ending of clickOnFirstAddedField Method");	
	}

	public void addUserDefinedFields() throws InterruptedException {
		int count=2;
		int labelCount=19;
		logger.info("Starting of userdefined field fetching method");
		logger.info("Click on the first user defined field");
		//waitElementVisiblity.until(ExpectedConditions.visibilityOf(firstAddedField));
		logger.info("Capturing the all user defined fields");

		//List<WebElement> fields=driver.findElements(By.xpath("//div[@class='select2-result-label']"));
		//int userDefinedFieldsCount=driver.findElements(By.xpath("//ul[@id='select2-results-38']//li")).size();
		int userDefinedFieldsCount=this.userDefinedFields.size();


		for(int i=0;i<userDefinedFieldsCount;i++) 
		{
			logger.info("Loop Started");
			//fields.get(i).click();
			//String lableName=driver.findElements(By.xpath("//div[@class='select2-result-label']")).get(i).getText();
			String lableName=this.labelNames.get(i).getText();

			if(!lableName.equals("Datespan") && !lableName.equals("DateTimespan") && !lableName.equals("Dropdown") && !lableName.equals("Multi Select Dropdown") && !lableName.equalsIgnoreCase("Location diff")&& !lableName.equalsIgnoreCase("Location To Address")) {
				//driver.findElements(By.xpath("//div[@class='select2-result-label']")).get(i).click();	
				this.selectUserDefinedFields.get(i).click();
				driver.findElement(By.xpath("//input[@id='formFieldSpecs"+labelCount+"_fieldLabel']")).sendKeys("Normal_Fields_"+lableName);
				if(i==userDefinedFieldsCount-1){
					break;
				}
				waitUntilElementVisible(driver, this.addFieldBtn);
				this.addFieldBtn.click();
				driver.findElement(By.xpath("(//div[@class='select2-container field type fieldType'])["+count+"]")).click();
				count++;
				labelCount++;
				logger.info("Loop end");
			}		

		}
		this.nextButton.click();
		//driver.findElement(By.xpath("//input[@id='nxtButton']")).click();
		driver.switchTo().alert().accept();

		//waitElementVisiblity.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nxtButton']")));
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.formSpecButton);
		this.formSpecButton.click();
	}

	public void selectActionForms() {

		for(int i=0;i<=5;i++) {
			waitUntilElementVisible(driver, this.addActionBtn);
			scrollIntoView(addActionBtn);
			clickOnWebElement(addActionBtn);
			driver.findElement(By.xpath("//input[@name='workActionSpec["+i+"].actionName']")).sendKeys("Action_"+i);
			//ActionName.sendKeys("Action_"+i);
			selectForms.click();
			formSpecs.click();
		}

		this.FlowNext.click();
		driver.switchTo().alert().accept();


	}

	public void clickNextCloneFieldData() throws InterruptedException {
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.cloneNxtBtn);
		this.cloneNxtBtn.click();		
	}

	public void clickNextManageFlow() throws InterruptedException {
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.ManageFlowNxtBtn);
		this.ManageFlowNxtBtn.click();	
		driver.switchTo().alert().accept();
	}

	public void clickSkipAutoAllocation() {
		waitUntilElementVisible(driver, this.skipBtn);
		skipBtn.click();
	}

	public void clickNextSetting() throws InterruptedException {
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.SettingsNxtBtn);
		this.SettingsNxtBtn.click();	

	}

	public void clickOtherSetting() throws InterruptedException {
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.OtherNxtBtn);
		this.OtherNxtBtn.click();	

	}

	//Validating the Created Work Process

	public String getWorkProcessName() {
		logger.info("Starting of getWorkProcessName");

		String actualSpecName=driver.findElement(By.xpath("//h4[contains(text(),'"+WorkSpecName+"')]")).getText();
		logger.info("Ending of getWorkProcessName");
		return actualSpecName;
	}


	public void ModifyWorkFields() {
		logger.info("Starting of Modify work fields method");

		waitUntilElementVisible(driver, this.modifyFieldsCard);
		this.modifyFieldsCard.click();
		waitUntilElementVisible(driver, this.addFieldsButton);
		scrollDown(1000, this.addFieldsButton);
		this.addFieldsButton.click();
		waitUntilElementVisible(driver, this.modifiedFieldLabelInputField);
		scrollIntoView(this.modifiedFieldLabelInputField);
		hardWait(5);
		this.modifiedFieldLabelInputField.sendKeys("New Field modification");
		waitUntilElementVisible(driver, this.saveBtn);
		scrollDown(1000, this.saveBtn);
		this.saveBtn.click();
		driver.switchTo().alert().accept();

		logger.info("Ending of Modify work fields method");		
	}

	public void withDrawWorkSpec() {
		logger.info("Starting of withDrawWorkSpec method");
        hardWait(5);
		waitUntilElementVisible(driver, this.withDrawnBtn);
		this.withDrawnBtn.click();
		driver.switchTo().alert().accept();

		logger.info("Ending of withDrawWorkSpec method");
	}

	public String modifyManageFieldsCard(String cardName) {
		logger.info("Starting of modifyConfiguration Method");

		String statusMsg = null;
		for (int i = 0; i <this.workProcessCardList.size(); i++) {
			waitUntilElementVisible(driver, this.workProcessCardList.get(i));
			String actualCardName=this.workProcessCardList.get(i).getText();
			if (actualCardName.equalsIgnoreCase(cardName)) {
				clickOnWebElement(this.workProcessCardList.get(i));
				waitUntilElementVisible(driver, this.addFieldsButton);
				scrollDown(1000, this.addFieldsButton);
				clickOnWebElement(this.addFieldsButton);
				waitUntilElementVisible(driver, this.addNewWorkField);
				clickOnWebElement(this.addNewWorkField);
				this.addNewWorkField.sendKeys("New Field modification");
				waitUntilElementVisible(driver, this.saveBtn);
				scrollDown(1000, this.saveBtn);
				clickOnWebElement(saveBtn);
				driver.switchTo().alert().accept();
				waitUntilElementVisible(driver, this.modifyWorkFieldsStatusMsg);
				statusMsg=this.modifyWorkFieldsStatusMsg.getText();
				break;

			}
			logger.info("Ending of modifyConfiguration Method");

		}
		return statusMsg;

	}

	public String modifyManageActivitiesCard(String cardName) {
		logger.info("Starting of modifyManageActivitiesCard method");

		String statusMsg=null;
		for (int i = 0; i <this.workProcessCardList.size(); i++) {
			waitUntilElementVisible(driver, this.workProcessCardList.get(i));
			String actualCardName=this.workProcessCardList.get(i).getText();
			if (actualCardName.equalsIgnoreCase(cardName)) {
				clickOnWebElement(this.workProcessCardList.get(i));
				scrollIntoView(addActionBtn);
				waitUntilElementVisible(driver, this.addActionBtn);
				clickOnWebElement(addActionBtn);
				waitUntilElementVisible(driver, this.newActionName_Input);
                this.newActionName_Input.sendKeys("Modified Action");
                waitUntilElementVisible(driver, this.actionFormDropDown);
                clickOnWebElement(this.actionFormDropDown);
                waitUntilElementVisible(driver, this.select_ActionSpec);
                clickOnWebElement(this.select_ActionSpec);
                waitUntilElementVisible(driver, this.addAttachment_Btn);
                clickOnWebElement(this.addAttachment_Btn);
                waitUntilElementVisible(driver, this.addActachment_DropDown);
                clickOnWebElement(this.addActachment_DropDown);
                waitUntilElementVisible(driver, this.select_Attachment_Form);
                clickOnWebElement(this.select_Attachment_Form);
                scrollIntoView(this.managerActivities_Save_Btn);
                waitUntilElementVisible(driver, this.managerActivities_Save_Btn);
                clickOnWebElement(this.managerActivities_Save_Btn);
                statusMsg=driver.switchTo().alert().getText();
        		driver.switchTo().alert().accept();
				break;

			}

			logger.info("Ending of modifyManageActivitiesCard method");

		}
		return statusMsg;
	}
	
	public void restrictAccessGroups(String cardName, String groupName) {
		logger.info("Starting of restrictAccessGroups");
		
		for (int i = 0; i <this.workProcessCardList.size(); i++) {
			waitUntilElementVisible(driver, this.workProcessCardList.get(i));
			String actualCardName=this.workProcessCardList.get(i).getText();
			if (actualCardName.equalsIgnoreCase(cardName)) {
			
					//clickUsingActionClass(crdRestrictEmp);
					clickUsingActionClass(workProcessCardList.get(i));
					hardWait(2);
					
					waitUntilElementVisible(driver, this.employeeGroups);
					
						selectDropdown(this.employeeGroups, groupName);
				
					
					waitUntilElementVisible(driver, this.moveEmpGrp_Btn);
					this.moveEmpGrp_Btn.click();
					clickOnWebElement(this.save_Btn);
					break;
				
			}
		}
		
		logger.info("Ending of restrictAccessGroups");

		
	}
	
	public void managePermission_Configuration(String cardName) {
		logger.info("Starting of managePermissionCard_Configuration");
		
		for (int i = 0; i <this.workProcessCardList.size(); i++) {
			waitUntilElementVisible(driver, this.workProcessCardList.get(i));
			String actualCardName=this.workProcessCardList.get(i).getText();
			if (actualCardName.equalsIgnoreCase(cardName)) {

					clickUsingActionClass(this.workProcessCardList.get(i));
					hardWait(2);
					waitUntilElementVisible(driver, this.viewCheckBox);
					clickOnWebElement(this.viewCheckBox);
					clickOnWebElement(this.empGroupDropdown);
					waitUntilElementVisible(driver, this.empGroup);
					clickOnWebElement(this.empGroup);
					clickOnWebElement(this.saveBtn);
					waitUntilElementVisible(driver, this.backToWorkCards);
					clickOnWebElement(this.backToWorkCards);	
					break;
				
			}
		}
		
		logger.info("Ending of managePermissionCard_Configuration");		
	}
	
	public void manageActivitySubmissionVisibility_Configuration(String cardName) {
		logger.info("Starting of manageActivitySubmissionVisibility_Configuration");
		
		for (int i = 0; i <this.workProcessCardList.size(); i++) {
			waitUntilElementVisible(driver, this.workProcessCardList.get(i));
			String actualCardName=this.workProcessCardList.get(i).getText();
			if (actualCardName.equalsIgnoreCase(cardName)) {
				clickUsingActionClass(this.workProcessCardList.get(i));
				hardWait(2);
					waitUntilElementVisible(driver, this.actionSelection_Dropdown);
					clickOnWebElement(this.actionSelection_Dropdown);
					hardWait(2);
					waitUntilElementVisible(driver, this.selectEmployee);
					clickOnWebElement(this.selectEmployee);
					hardWait(2);
					waitUntilElementVisible(driver, this.backToWorkCards);
					clickOnWebElement(this.backToWorkCards);	
					break;				
				
			}
		}
		
		logger.info("Ending of managePermissionCard_Configuration");

		
	}
	
	public void settingsConfiguration(String cardName) {
		logger.info("Starting of settingsConfiguration");
		
		for (int i = 0; i <this.workProcessCardList.size(); i++) {
			waitUntilElementVisible(driver, this.workProcessCardList.get(i));
			String actualCardName=this.workProcessCardList.get(i).getText();
			if (actualCardName.equalsIgnoreCase(cardName)) {
				clickUsingActionClass(this.workProcessCardList.get(i));
				hardWait(2);
				waitUntilElementVisible(driver, this.workCheckIn_Checkbox);
				clickOnWebElement(this.workCheckIn_Checkbox);
				waitUntilElementVisible(driver, this.settingsSave_btn);
				clickOnWebElement(this.settingsSave_btn);
					break;		
			}
		}
		
		logger.info("Ending of settingsConfiguration");	
	}
	
	public void clickOnHome() {
		logger.info("Starting of clickOnHome method");
		
		hardWait(3);
		waitUntilElementVisible(driver, this.homeModule);
		clickOnWebElement(this.homeModule);
		
		logger.info("Ending of clickOnHome method");
	}
	
	public void clickOnCreateProcessInHomeScreen() {
		logger.info("Starting of clickOnCreateProcessInHomeScreen Method");
		
		hardWait(10);
		waitUntilElementVisible(driver, this.createProcess_Card);
		clickOnWebElement(this.createProcess_Card);
		waitUntilElementVisible(driver, this.activityProcessOption);
		clickOnWebElement(this.activityProcessOption);
		waitUntilElementVisible(driver, this.createMyOwnOption);
		clickOnWebElement(this.createMyOwnOption);
		
		logger.info("Ending of clickOnCreateProcessInHomeScreen Method");

	}
	
	public void withDrawSpecInHome() {
		logger.info("Starting of withDrawSpecInHome method");
		
		waitUntilElementVisible(driver, this.withDrawCard);
		clickOnWebElement(this.withDrawCard);
		driver.switchTo().alert().accept();
		
		logger.info("Ending of withDrawSpecInHome method");
	}
	
	public void withDrawAllSpecs() {
		logger.info("Starting of withDrawAllSpecs method");
		
		for (int i = 1; i <activeWorkSpecDetails.size() ; i++) {
			waitUntilElementVisible(driver, this.activeWorkSpecDetails.get(1));
			clickOnWebElement(this.activeWorkSpecDetails.get(1));
			waitUntilElementVisible(driver, this.withDrawCard);
			clickOnWebElement(this.withDrawCard);
			driver.switchTo().alert().accept();
			hardWait(15);
			if(i==168){
				break;
			}
		}
		
		logger.info("Ending of withDrawAllSpecs method");

	}
	
	

}
