package com.effort.employees;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.effort.base.BaseAutomationPage;

public class EmployeeCreation extends BaseAutomationPage{

	private static final Logger logger = Logger.getLogger(EmployeeCreation.class.getName());
	String parentWind=driver.getWindowHandle();

	String employeeFirstName=null;
	private String employeeId=null;
	private String disableLabel="CLICK TO DISABLE";

	@FindBy(xpath="//a[contains(text(),'Web App')]")
	private WebElement webApp;

	@FindBy(xpath="//a[contains(text(),' Employees ')]")
	private WebElement employeeModule;

	@FindBy(xpath="//a[@title='Add Employee']")
	private WebElement addEmpBtn;

	@FindBy(xpath="//input[@id='empFirstName']")
	private WebElement firstName;

	@FindBy(id="empLastName")
	private WebElement empLastName;

	@FindBy(xpath="//input[@name='empNo']")
	private WebElement empId;

	@FindBy(id="manager")
	private WebElement managerCheckBox;

	@FindBy(id="generateQrCode")
	private WebElement qrCode;

	@FindBy(id="empEmail")
	private WebElement empEmail;

	@FindBy(xpath="//input[@name='empPhone']")
	private WebElement empPhone;

	@FindBy(xpath="//div[@class='empAdavDetailsContainer bg-label']")
	private WebElement advanceDetails;

	@FindBy(xpath="//div[@id='empAdavFieldsContainer']/div/div/ul/li/label[1]")
	private List<WebElement> empAdvanceList;

	@FindBy(xpath="//div[@id='s2id_managerEmail']/a")
	private WebElement reportManagerdropdown;

	@FindBy(xpath="//ul[@id='select2-results-3']/li/div")
	private List<WebElement> managerNames;

	@FindBy(xpath="//input[@id='s2id_autogen3_search']")
	private WebElement managerNameInput;

	@FindBy(xpath="//input[@id='employeeImage']")
	private WebElement chooseEmpImage;

	@FindBy(id="designation")
	private WebElement designation;

	@FindBy(xpath="//span[@id='select2-chosen-5']")
	private WebElement roleDropDown;

	@FindBy(xpath="//ul[@id='select2-results-5']/li/div")
	private List<WebElement> empRoles;

	@FindBy(xpath="//div[@id='s2id_empMappedGroups']")
	private WebElement empGrpDropDown;
	
	@FindBy(xpath="//div[@id='select2-drop']/ul/li/div")
	private List<WebElement> empGrps;

	@FindBy(id="s2id_mce")
	private WebElement autoMapDrpdown;
	
	@FindBy(xpath="//ul[@id='select2-results-7']//li/div")
	private List<WebElement> mapDropdown;
	
	@FindBy(id="s2id_territoryIds")
	private WebElement territoryDropdown;
	
	@FindBy(xpath="//div[@id='select2-drop']/ul/li/div")
	private List<WebElement> territoryOptions;

	@FindBy(xpath="//input[@id='save']")
	private WebElement saveBtn;

	@FindBy(xpath="//div[@id='snackbarVal']")
	private WebElement EmpsavedMsg;

	@FindBy(id="filters")
	private WebElement filterBtn;

	@FindBy(id="empNamefilt")
	private WebElement EmployeefirstName;

	@FindBy(id="search")
	private WebElement applyBtn;

	@FindBy(xpath="//table/tbody/tr/td[2]/div/span/i")
	private List<WebElement> editButtons;

	@FindBy(id="empNofilt")
	private WebElement empIdFilterScreen;

	@FindBy(xpath="//button[@id='dropdownMenu1']")
	private WebElement actionMenu;

	@FindBy(xpath="//ul[@aria-labelledby='dropdownMenu1']/li/a")
	private List<WebElement> actionDropDowns;
	
	@FindBy(id="save1")
	private WebElement modifySaveBtn;

	@FindBy(id="disableEmployee")
	private WebElement applyDisableEmp;

	@FindBy(xpath="//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath="//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;



	//Default constructor
	public EmployeeCreation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnWebApp() {
		logger.info("Starting of Click on web App method");
		waitUntilElementVisible(driver, webApp);
		this.webApp.click();
		logger.info("Ending of Click on web App method");
	}

	public void clickOnEmployees() {
		logger.info("Starting of clickOnEmployees method");
		waitUntilElementVisible(driver, employeeModule);
		employeeModule.click();
		logger.info("Ending of clickOnEmployees method");
	}

	public void clickOnAddEmpBtn() {
		logger.info("Starting of clickOnAddEmpBtn method");
		waitUntilElementVisible(driver, addEmpBtn);
		addEmpBtn.click();
		logger.info("Ending of clickOnAddEmpBtn method");
	}

	public void switchNewWindow() {
		logger.info("Starting of switchNewWindow method");

		Set<String> newWindows=driver.getWindowHandles();
		Iterator<String> I1= newWindows.iterator();

		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parentWind.equals(child_window))
			{
				driver.switchTo().window(child_window);
			}
		}
	}

	public void enterFirstName(String enterFirstName) {
		logger.info("Starting of enterFirstName method");
		waitUntilElementVisible(driver, firstName);
		this.employeeFirstName=enterFirstName+"_"+getCurrentDate();
		firstName.sendKeys(this.employeeFirstName);
		logger.info("Ending of enterFirstName method");
	}

	public void enterLastName(String enterLastName) {
		logger.info("Starting of enterLastName method");
		waitUntilElementVisible(driver, empLastName);
		empLastName.sendKeys(enterLastName);
		logger.info("ending of enterLastName method");
	}

	public void EmpId() {
		logger.info("Starting of enterEmpId method");
		employeeId=getUniqueNumber("Auto_EMP");
		waitUntilElementVisible(driver, empId);
		empId.sendKeys(this.employeeId);
		logger.info("ending of enterEmpId method");
	}

	public void managerCheckBox() {
		logger.info("Starting of managerCheckBox method");
		waitUntilElementVisible(driver, managerCheckBox);
		managerCheckBox.click();
		logger.info("ending of managerCheckBox method");
	}

	public void qrCodeCheckBox() {
		logger.info("Starting of qrCodeCheckBox method");
		waitUntilElementVisible(driver, qrCode);
		qrCode.click();
		logger.info("ending of qrCodeCheckBox method");
	}

	public void EmpEmail() {
		logger.info("Starting of enterEmpEmail method");
		String randomEmail=randomEmailGenerator();
		waitUntilElementVisible(driver, empEmail);
		empEmail.sendKeys(randomEmail);
		logger.info("ending of enterEmpEmail method");
	}

	public void EmpPhone() {
		logger.info("Starting of enterEmpPhone method");
		String randomPhone=randomMobileNumbers();
		waitUntilElementVisible(driver, empPhone);
		empPhone.sendKeys(randomPhone);
		logger.info("ending of enterEmpPhone method");
	}

	public void clickOnAdvanceDetails() {
		logger.info("Starting of click on Advance details method");
		waitUntilElementVisible(driver, this.advanceDetails);
		this.advanceDetails.click();
		logger.info("Ending of click on Advance details method");
	}

	public void advanceDetails(String designation,String employeeRole, String employeeGroup, String autoMapCustomer, String empTerritory) throws InterruptedException, IOException {
		logger.info("Starting of Advance details method");

		for(int i=0;i<empAdvanceList.size();i++) {
			String labelName=empAdvanceList.get(i).getText();

			//reporting manager name
			if(labelName.equalsIgnoreCase("Reporting Manager:")){
				scrollDown(400, empAdvanceList.get(i));
				waitUntilElementVisible(driver, this.reportManagerdropdown);
				this.reportManagerdropdown.click();
				Thread.sleep(5000);
				for (int j = 0; j<= managerNames.size(); j++){
					String managerName=managerNames.get(j).getText();
					if(managerName.equalsIgnoreCase("Srinivas Maddy")) {
						this.managerNameInput.sendKeys(this.managerNames.get(j).getText());
						this.managerNames.get(0).click();
						break;
					}			
				}
			}

			//Employee Id Photo image
			else if(labelName.equalsIgnoreCase("Employee Photo:")){
				waitUntilElementVisible(driver, this.chooseEmpImage);
				String pathFile=System.getProperty("user.dir")+"\\MediaFiles\\IDCardPhoto.jpg";
				this.chooseEmpImage.sendKeys(pathFile);

			}

			//Employee Designation
			else if(labelName.equalsIgnoreCase("Designation :")) {
				waitUntilElementVisible(driver, this.designation);
				this.designation.sendKeys(designation);
			}

			//Employee Role
			else if(labelName.equalsIgnoreCase("Role :")) {
				waitUntilElementVisible(driver, this.roleDropDown);
				this.roleDropDown.click();
				int count=0;
				while(count<empRoles.size()) {
					if(empRoles.get(count).getText().equalsIgnoreCase(employeeRole)){
						this.empRoles.get(count).click();
						break;
					}
					count++;
				}					
			}

			//Employee Group
			else if(labelName.equalsIgnoreCase("Employee group :")) {
				waitUntilElementVisible(driver, this.empGrpDropDown);
				this.empGrpDropDown.click();
				
				int grpCount=0;
				while(grpCount<empGrps.size()) {
					
					if(empGrps.get(grpCount).getText().equalsIgnoreCase(employeeGroup)) {
						empGrps.get(grpCount).click();
						break;
					}
					grpCount++;
				}
			}
			
			//Auto Map Customer To Employee
			else if(labelName.equalsIgnoreCase("Auto Map Customer to Employee :")) {
				waitUntilElementVisible(driver, this.autoMapDrpdown);
				this.autoMapDrpdown.click();
				int mapOptions=0;
				while(mapOptions<mapDropdown.size()) {
					if(mapDropdown.get(mapOptions).getText().equalsIgnoreCase(autoMapCustomer)) {
						mapDropdown.get(mapOptions).click();
						break;
					}
					mapOptions++;
				}				
			}
			
			//Territoty dropdown
			else if(labelName.equalsIgnoreCase("Employee territory :")) {
				scrollDown(500, this.territoryDropdown);
				waitUntilElementVisible(driver, this.territoryDropdown);
				this.territoryDropdown.click();
				int terrioryOptionsCount=0;
				while(terrioryOptionsCount<territoryOptions.size()) {
					if(territoryOptions.get(terrioryOptionsCount).getText().equalsIgnoreCase(empTerritory)) {
						territoryOptions.get(terrioryOptionsCount).click();
						break;
					}
					terrioryOptionsCount++;
				}
				
			}
			
		}

	}




	public void clickOnSaveBtn() throws InterruptedException {
		logger.info("Starting of clickOnSaveBtn method");
		scrollDown(500, this.territoryDropdown);
		waitUntilElementVisible(driver, saveBtn);
		Thread.sleep(2000);
		saveBtn.click();
		logger.info("ending of qrCodeCheckBox method");
	}

	public String EmpSavedSuccsusfullyMsg() throws InterruptedException {
		logger.info("Starting of EmpSavedSuccsusfullyMsg Method");
		Thread.sleep(500);
		waitUntilElementVisible(driver, EmpsavedMsg);
		String actualEmpSavedMsg = this.EmpsavedMsg.getText();
		return actualEmpSavedMsg;
	}


	public void clickOnFilter() {
		logger.info("Starting of clickOnFilter method");
		scrollDown(100, this.filterBtn);
		waitUntilElementVisible(driver,this.filterBtn);
		this.filterBtn.click();
		logger.info("Ending of clickOnFilter method");
	}

	public void filterEmployeeName(){
		logger.info("Starting of filterEmployeeName method");
		waitUntilElementVisible(driver, this.EmployeefirstName);
		this.EmployeefirstName.sendKeys(this.employeeFirstName);
		waitUntilElementVisible(driver, this.applyBtn);
		this.applyBtn.click();
		logger.info("Ending of filterEmployeeName method");

	}

	public void clickOnEditButton() throws InterruptedException {
		logger.info("Starting of clickOnEditButton method");
		Thread.sleep(500);
		int i=0;
		if(i<editButtons.size())
			this.editButtons.get(i).click();
		waitUntilElementVisible(driver, this.firstName);
		this.firstName.clear();
		this.firstName.sendKeys("Modified Employee Name");
		this.empLastName.clear();
		this.empLastName.sendKeys("Modified Last name");
		waitUntilElementVisible(driver, this.modifySaveBtn);
		this.modifySaveBtn.click();

	}


	public void disableEmployee() throws InterruptedException {
		logger.info("Starting of diable employee method");
		waitUntilElementVisible(driver, this.empIdFilterScreen);
		this.empIdFilterScreen.sendKeys(this.employeeId);
		waitUntilElementVisible(driver, this.applyBtn);
		this.applyBtn.click();	
		waitUntilElementVisible(driver, this.actionMenu);
		Thread.sleep(5000);
		this.actionMenu.click();
		Thread.sleep(5000);
		for (int i=0; i<actionDropDowns.size(); i++) {
			String ExpectedLabel=this.actionDropDowns.get(i).getText();
			if(this.disableLabel.equalsIgnoreCase(ExpectedLabel)) {
				waitUntilElementVisible(driver, this.actionDropDowns.get(i));
				this.actionDropDowns.get(i).click();
				break;
			}			
		}
		waitUntilElementVisible(driver, this.applyDisableEmp);
		this.applyDisableEmp.click();	
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
