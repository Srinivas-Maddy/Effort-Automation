package com.effort.filters;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class LeavesFiltersPage extends BaseAutomationPage {
	private static final Logger logger = Logger.getLogger(LeavesFiltersPage.class.getName());

	@FindBy(xpath = "(//div[@class='dashboard-cards']/ul/li)[2]")
	private WebElement dashboardwebapp;

	@FindBy(xpath = "//a[text()=' Leaves']")
	private WebElement leaves;

	@FindBy(id = "filters")
	private WebElement leavesfilterbtn;

	@FindBy(xpath = "(//div[@class='select2-container select2-container-multi form-control'])[1]")
	private WebElement leavesempnamefield;

	@FindBy(xpath = "(//ul[@class='select2-choices'])[1]/li/input")
	private WebElement leavesempnameinputfield;

	@FindBy(id = "appliedLeaves")
	private WebElement leavesappliedcheckbox;

	@FindBy(xpath = "//input[@id='approvedLeaves']")
	private WebElement leavesapprovedcheckbox;

	@FindBy(xpath = "//input[@id='cancelledLeaves']")
	private WebElement leavescancelledcheckbox;

	@FindBy(xpath = "//input[@id='rejectedLeaves']")
	private WebElement leavesrejectedcheckbox;

	@FindBy(xpath = "(//ul[@class='select2-results'])[4]/li/div")
	private List<WebElement> leavesempnamesdata;

	@FindBy(xpath = "(//ul[@class='select2-results'])[3]/li/div/span")
	private List<WebElement> secondTimeLeaveEmpName;

	@FindBy(xpath = "((//table[@id='example']/tbody/tr)[1]/td)[8]/span[text()='Applied']")
	private WebElement leavesappliedresult;

	@FindBy(xpath = "((//table[@id='example']/tbody/tr)/td)[8]/span[text()='Approved']")
	private WebElement leavesapprovedresult;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[8]/span[text()='Cancelled']")
	private WebElement leavescancelledresult;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr)[1]/td[8]/span[text()='Rejected']")
	private WebElement leavesrejectedresult;

	@FindBy(xpath = "//input[@id='appliedOnLeaves']")
	private WebElement appliedcheckbox;

	@FindBy(xpath = "(//div[@class='select2-container select2-container-multi form-control'])[2]")
	private WebElement reportingmangrfield;

	@FindBy(xpath = "//input[@id='s2id_autogen2']")
	private WebElement reportingmangrinputfield;

	@FindBy(xpath="//div[@class='select2-result-label']/span")
	private WebElement reportingmanagerdata;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr)[1]/td[9][text()='Srinivas Maddy']")
	private WebElement reportingmanagerresult;

	@FindBy(xpath="//input[@id='formDateTime']")
	private WebElement appliedbtwninputfield;

	@FindBy(xpath = "(//div[@class='xdsoft_calendar'])[1]/table/tbody/tr/td")
	private List<WebElement> appliedbtwndates;

	//(//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_'])[1]/div[1]/div[2]/table/tbody/tr/td

	@FindBy(xpath = "(((//table[@id='example']/tbody/tr)[3]/td)[11])/font")
	private WebElement leavesdateresult;

	@FindBy(xpath="//input[@id='toDateTime']")
	private WebElement leavesandinputfield;

	@FindBy(xpath = "(//div[@class='xdsoft_calendar'])[2]/table/tbody/tr/td")
	private List<WebElement> leavesanddates;

	@FindBy(xpath = "(//div[@class='select2-container select2-container-multi form-control'])[3]")
	private WebElement leavetypefield;

	@FindBy(xpath="(//ul[@class='select2-results'])[3]/li/div")
	private List<WebElement> leavetypedropdwndata;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr)[1]/td[7][text()='Leave']")
	private WebElement leavetyperesult;

	@FindBy(xpath="//input[@id='formDateTime']")
	private WebElement myleavesdateinputfield;

	@FindBy(xpath = "(//div[@class='xdsoft_calendar'])[1]/table/tbody/tr/td")
	private List<WebElement> myleavesdates;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr[3]/td)[2]/a[text()='Leave']")
	private WebElement myleavesdateresult;

	@FindBy(xpath="//input[@id='toDateTime']")
	private WebElement myleavesandinputfield;

	@FindBy(xpath = "(//div[@class='xdsoft_calendar'])[2]/table/tbody/tr/td")
	private List<WebElement> myleavesanddates;

	@FindBy(xpath = "//button[@value='View My Leaves']")
	private WebElement viewmyleavebtn;

	@FindBy(xpath = "//a[@id='filters']")
	private WebElement myleavefilterbtn;

	@FindBy(xpath = "//input[@id='appliedLeaves']")
	private WebElement myleavesappliedcheckbox;

	@FindBy(xpath = "//input[@id='approvedLeaves']")
	private WebElement myleavesapprovedcheckbox;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[6]/span[text()='Approved']")
	private WebElement myleavesapprovedresult;

	@FindBy(xpath = "//input[@id='cancelledLeaves']")
	private WebElement myleavescancelledcheckbox;

	@FindBy(xpath = "//input[@id='rejectedLeaves']")
	private WebElement myleavesrejectedcheckbox;

	@FindBy(xpath = "//a[@id='search']")
	private WebElement leavesapplybtn;

	@FindBy(xpath = "//a[@id='reset']")
	private WebElement leavesresetbtn;

	@FindBy(xpath = "((//a/span)[4]/span)[2]")
	private WebElement userNameBtn;
	
	@FindBy(xpath = "(//ul[@class='dropdown-menu'])[2]/li/a")
	private List<WebElement> logoutBtn;

	public LeavesFiltersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void clickOnWebApp() throws InterruptedException {
		logger.info("Starting of clickOnWebApp Method");
		waitUntilElementVisible(driver, this.dashboardwebapp);
		this.dashboardwebapp.click();
		Thread.sleep(500);
		logger.info("Ending of clickOnDots Method");
	}

	public void clickOnLeaves() {
		logger.info("Starting of clickOnLeaves Method");
		waitUntilElementVisible(driver, this.leaves);
		this.leaves.click();
		logger.info("Ending of clickOnLeaves Method");
	}

	public void clickOnLeavesFilters() {
		logger.info("Starting of clickOnLeavesFilters Method");
		waitUntilElementVisible(driver, this.leavesfilterbtn);
		this.leavesfilterbtn.click();
		logger.info("Ending of clickOnLeavesFilters Method");
	}

	public void enterAppliedLeavesEmployeeName(String leavesempname) throws InterruptedException {
		logger.info("Starting of enterAppliedLeavesEmployeeName Method");
		waitUntilElementVisible(driver, this.leavesempnameinputfield);
		this.leavesempnameinputfield.click();
		this.leavesempnameinputfield.sendKeys(leavesempname);
		Thread.sleep(1000);
		int i = 0;
		while (i < this.leavesempnamesdata.size()) {
			String leaveemployeesnames = this.leavesempnamesdata.get(i).getText();
			if (leaveemployeesnames.equalsIgnoreCase("Srinivas Maddy")) {
				waitUntilElementVisible(driver, this.leavesempnamesdata.get(i));
				this.leavesempnamesdata.get(i).click();
				break;
			}
			i++;
		}
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.leavesappliedcheckbox);
		this.leavesappliedcheckbox.click();
		waitUntilElementVisible(driver, this.leavesapplybtn);
		this.leavesapplybtn.click();
		logger.info("Ending of enterAppliedLeavesEmployeeName Method");
	}

	public String appliedLeavesValidation() {
		logger.info("Starting of appliedLeavesValidation Method");
		waitUntilElementVisible(driver, this.leavesappliedresult);
		String actualleavesappliedresult = this.leavesappliedresult.getText();
		return actualleavesappliedresult;
	}

	public void enterApprovedLeavesEmployeeName(String leavesempname) throws InterruptedException {
		logger.info("Starting of enterApprovedLeavesEmployeeName Method");

		waitUntilElementVisible(driver, this.leavesresetbtn);
		this.leavesresetbtn.click();

		waitUntilElementVisible(driver, this.leavesempnameinputfield);
		this.leavesempnameinputfield.click();
		this.leavesempnameinputfield.sendKeys(leavesempname);
		Thread.sleep(1000);
		int i = 0;
		while (i < this.secondTimeLeaveEmpName.size()) {
			String leaveemployeesnames = this.secondTimeLeaveEmpName.get(i).getText();
			if (leaveemployeesnames.equalsIgnoreCase("Srinivas Maddy")) {
				waitUntilElementVisible(driver, this.secondTimeLeaveEmpName.get(i));
				this.secondTimeLeaveEmpName.get(i).click();
				break;
			}
			i++;
		}

		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.leavesapprovedcheckbox);
		this.leavesapprovedcheckbox.click();
		waitUntilElementVisible(driver, this.leavesapplybtn);
		this.leavesapplybtn.click();
		logger.info("Ending of enterApprovedLeavesEmployeeName Method");
	}

	public String approvedLeavesValidation() {
		logger.info("Starting of approvedLeavesValidation Method");
		waitUntilElementVisible(driver, this.leavesapprovedresult);
		String actualleavesapprovedresult = this.leavesapprovedresult.getText();
		return actualleavesapprovedresult;
	}

	public void enterCancelledLeavesEmployeeName(String leavesempname) throws InterruptedException {
		logger.info("Starting of enterCancelledLeavesEmployeeName Method");

		waitUntilElementVisible(driver, this.leavesresetbtn);
		this.leavesresetbtn.click();

		waitUntilElementVisible(driver, this.leavesempnameinputfield);
		this.leavesempnameinputfield.click();
		this.leavesempnameinputfield.sendKeys(leavesempname);
		Thread.sleep(1000);
		int i = 0;
		while (i < this.secondTimeLeaveEmpName.size()) {
			String leaveemployeesnames = this.secondTimeLeaveEmpName.get(i).getText();
			if (leaveemployeesnames.equalsIgnoreCase("Srinivas Maddy")) {
				waitUntilElementVisible(driver, this.secondTimeLeaveEmpName.get(i));
				this.secondTimeLeaveEmpName.get(i).click();
				break;
			}
			i++;
		}

		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.leavescancelledcheckbox);
		this.leavescancelledcheckbox.click();
		waitUntilElementVisible(driver, this.leavesapplybtn);
		this.leavesapplybtn.click();
		logger.info("Ending of enterCancelledLeavesEmployeeName Method");
	}

	public String cancelledLeavesValidation() {
		logger.info("Starting of cancelledLeavesValidation Method");
		waitUntilElementVisible(driver, this.leavescancelledresult);
		String actualleavescancelledresult = this.leavescancelledresult.getText();
		return actualleavescancelledresult;
	}

	public void enterRejectedLeavesEmployeeName(String leavesempname) throws InterruptedException {
		logger.info("Starting of enterRejectedLeavesEmployeeName Method");

		waitUntilElementVisible(driver, this.leavesresetbtn);
		this.leavesresetbtn.click();

		waitUntilElementVisible(driver, this.leavesempnameinputfield);
		this.leavesempnameinputfield.click();
		this.leavesempnameinputfield.sendKeys(leavesempname);
		Thread.sleep(1000);
		int i = 0;
		while (i < this.secondTimeLeaveEmpName.size()) {
			String leaveemployeesnames = this.secondTimeLeaveEmpName.get(i).getText();
			if (leaveemployeesnames.equalsIgnoreCase("Srinivas Maddy")) {
				waitUntilElementVisible(driver, this.secondTimeLeaveEmpName.get(i));
				this.secondTimeLeaveEmpName.get(i).click();
				break;
			}
			i++;
		}

		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.leavesrejectedcheckbox);
		this.leavesrejectedcheckbox.click();
		waitUntilElementVisible(driver, this.leavesapplybtn);
		this.leavesapplybtn.click();
		logger.info("Ending of enterRejectedLeavesEmployeeName Method");
	}

	public String rejectedLeavesValidation() {
		logger.info("Starting of rejectedLeavesValidation Method");
		waitUntilElementVisible(driver, this.leavesrejectedresult);
		String actualleavesrejectedresult = this.leavesrejectedresult.getText();
		return actualleavesrejectedresult;

	}

	public void enterReportingManager(String leavesempname) throws InterruptedException {
		logger.info("Starting of enterReportingManager Method");
		waitUntilElementVisible(driver, this.leavesresetbtn);
		this.leavesresetbtn.click();
		waitUntilElementVisible(driver, this.reportingmangrfield);
		this.reportingmangrfield.click();
		this.reportingmangrinputfield.sendKeys(leavesempname);
		waitUntilElementVisible(driver, this.reportingmanagerdata);
		this.reportingmanagerdata.click();
		waitUntilElementVisible(driver, this.leavesapplybtn);
		this.leavesapplybtn.click();
		logger.info("Ending of enterReportingManager Method");
	}

	public String reportingManagerValidation() {
		logger.info("Starting of reportingManagerValidation Method");
		waitUntilElementVisible(driver, this.reportingmanagerresult);
		String actualreportingmangerresult = this.reportingmanagerresult.getText();
		return actualreportingmangerresult;

	}

	public void clickOnLeavesAppliedCheckbox() {
		logger.info("Starting of clickLeavesAppliedCheckbox Method");
		waitUntilElementVisible(driver, this.leavesresetbtn);
		this.leavesresetbtn.click();
		waitUntilElementVisible(driver, this.appliedcheckbox);
		this.appliedcheckbox.click();
		logger.info("Ending of clickLeavesAppliedCheckbox Method");
	}

	public void pickAppliedLeavesDates() throws InterruptedException {
		logger.info("Starting of pickAppliedLeavesDate Method");
		waitUntilElementVisible(driver, this.appliedbtwninputfield);
		this.appliedbtwninputfield.click();
		Thread.sleep(500);

		int count=0;
		while(count<this.appliedbtwndates.size()) {
			waitUntilElementVisible(driver, this.appliedbtwndates.get(count));
			this.appliedbtwndates.get(count).click();
			break;
		}
		count++;
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.leavesandinputfield);
		this.leavesandinputfield.click();

		String presentanddate = getCurrentDateAsNumber();
		Thread.sleep(500);
		for (int i = 0; i <=this.leavesanddates.size() - 1; i++) {
			String actualanddate = leavesanddates.get(i).getText();
			if (actualanddate.equalsIgnoreCase(presentanddate)) {
				waitUntilElementVisible(driver, leavesanddates.get(i));
				leavesanddates.get(i).click();
				break;
			}
		}

		waitUntilElementVisible(driver, this.leavesapplybtn);
		this.leavesapplybtn.click();

		logger.info("Ending of pickAppliedLeavesDate Method");

	}

	public String leavesDateValidation() {
		logger.info("Starting of leavesDateValidation Method");
		waitUntilElementVisible(driver, this.leavesdateresult);
		String actualleavesdatesresult = this.leavesdateresult.getText();
		return actualleavesdatesresult;

	}

	public void selectLeaveType(String leavetype) throws InterruptedException {
		logger.info("Starting of selectLeaveType Method");
		waitUntilElementVisible(driver, this.leavesresetbtn);
		this.leavesresetbtn.click();
		waitUntilElementVisible(driver, this.leavetypefield);
		this.leavetypefield.click();
		Thread.sleep(1000);
		for(int i=0 ; i<this.leavetypedropdwndata.size();i++) {
			String leavetypedata = this.leavetypedropdwndata.get(i).getText();
			if(leavetypedata.equalsIgnoreCase(leavetype)) {
				waitUntilElementVisible(driver, this.leavetypedropdwndata.get(i));
				this.leavetypedropdwndata.get(i).click();
				break;
			}	
		}
		waitUntilElementVisible(driver, this.leavesapplybtn);
		this.leavesapplybtn.click();

	}

	public String leavesTypeValidation() {
		logger.info("Starting of leavesTypeValidation Method");
		waitUntilElementVisible(driver, this.leavetyperesult);
		String actualleavestyperesult = this.leavetyperesult.getText();
		return actualleavestyperesult;

	}

	public void clickOnViewMyLeaves() {
		logger.info("Starting of clickOnViewMyLeaves Method");
		waitUntilElementVisible(driver, this.viewmyleavebtn);
		this.viewmyleavebtn.click();
		logger.info("Ending of clickOnViewMyLeaves Method");
	}

	public void SwitchNewWindow() {
		logger.info("Starting of SwitchNewWindow Method");
		String parentwind = driver.getWindowHandle();
		Set<String> newwindows = driver.getWindowHandles();
		Iterator<String> I1 = newwindows.iterator();
		while (I1.hasNext()) {
			String child_Window = I1.next();
			if (!parentwind.equals(child_Window)) {
				driver.switchTo().window(child_Window);
			}
		}
		logger.info("Ending of SwitchNewWindow Method");
	}

	public void clickOnMyLeavesFilter() {
		logger.info("Starting of clickOnMyLeavesFilter Method");
		waitUntilElementVisible(driver, this.myleavefilterbtn);
		this.myleavefilterbtn.click();
		logger.info("Ending of clickOnMyLeavesFilter Method");
	}

	public void selectAppliedStatus() {
		logger.info("Starting of selectAppliedStatus Method");
		waitUntilElementVisible(driver, this.myleavesappliedcheckbox);
		this.myleavesappliedcheckbox.click();
		waitUntilElementVisible(driver, this.leavesapplybtn);
		this.leavesapplybtn.click();
		logger.info("Ending of selectAppliedStatus Method");
	}

	public void selectApprovedStatus() {
		logger.info("Starting of selectApprovedStatus Method");
		waitUntilElementVisible(driver, this.myleavefilterbtn);
		this.myleavefilterbtn.click();
		waitUntilElementVisible(driver, this.leavesresetbtn);
		this.leavesresetbtn.click();
		waitUntilElementVisible(driver, this.myleavesapprovedcheckbox);
		this.myleavesapprovedcheckbox.click();
		waitUntilElementVisible(driver, this.leavesapplybtn);
		this.leavesapplybtn.click();
		logger.info("Ending of selectApprovedStatus Method");
	} 

	public String myleavesApprovedValidation() {
		logger.info("Starting of myleavesApprovedValidation Method");
		waitUntilElementVisible(driver, this.myleavesapprovedresult);
		String actualmyleavesapprovedresult = this.myleavesapprovedresult.getText();
		return actualmyleavesapprovedresult;

	}

	public void selectCancelledStatus() {
		logger.info("Starting of selectCancelledStatus Method");
		waitUntilElementVisible(driver, this.myleavefilterbtn);
		this.myleavefilterbtn.click();
		waitUntilElementVisible(driver, this.leavesresetbtn);
		this.leavesresetbtn.click();
		waitUntilElementVisible(driver, this.myleavescancelledcheckbox);
		this.myleavescancelledcheckbox.click();
		waitUntilElementVisible(driver, this.leavesapplybtn);
		this.leavesapplybtn.click();
		logger.info("Ending of selectCancelledStatus Method");
	}

	public void selectRejectedStatus() {
		logger.info("Starting of selectRejectedStatus Method");
		waitUntilElementVisible(driver, this.myleavefilterbtn);
		this.myleavefilterbtn.click();
		waitUntilElementVisible(driver, this.leavesresetbtn);
		this.leavesresetbtn.click();
		waitUntilElementVisible(driver, this.myleavesrejectedcheckbox);
		this.myleavesrejectedcheckbox.click();
		waitUntilElementVisible(driver, this.leavesapplybtn);
		this.leavesapplybtn.click();
		logger.info("Ending of selectRejectedStatus Method");
	}

	public void pickMyLeavesFilterDates() throws InterruptedException {
		logger.info("Starting of pickMyLeavesFilterDates Method");

		waitUntilElementVisible(driver, this.myleavefilterbtn);
		this.myleavefilterbtn.click();
		waitUntilElementVisible(driver, this.leavesresetbtn);
		this.leavesresetbtn.click();

		waitUntilElementVisible(driver, this.myleavesdateinputfield);
		this.myleavesdateinputfield.click();

		int count=0;
		Thread.sleep(5000);
		while(count<this.myleavesdates.size()) {
			waitUntilElementVisible(driver, this.myleavesdates.get(count));
			this.myleavesdates.get(count).click();
			break;
		}		

		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.myleavesandinputfield);
		this.myleavesandinputfield.click();

		String presentanddate = getCurrentDateAsNumber();
		Thread.sleep(500);
		for (int i = 0; i <=this.myleavesanddates.size() - 1; i++) {
			String actualanddate = myleavesanddates.get(i).getText();
			if (actualanddate.equalsIgnoreCase(presentanddate)) {
				waitUntilElementVisible(driver, myleavesanddates.get(i));
				myleavesanddates.get(i).click();
				break;
			}
		}

		waitUntilElementVisible(driver, this.leavesapplybtn);
		this.leavesapplybtn.click();

		logger.info("Ending of pickMyLeavesFilterDates Method");
	}

	public String myleavesDatesValidation() {
		logger.info("Starting of myleavesDatesValidation Method");
		waitUntilElementVisible(driver, this.myleavesdateresult);
		String actualmyleavesdatesresult = this.myleavesdateresult.getText();
		return actualmyleavesdatesresult;

	}

	public void filtersLeavesLogout() throws InterruptedException {

		logger.info("Starting of filtersLeavesLogout Method");
		Thread.sleep(1000);
		waitUntilElementVisible(driver, userNameBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.userNameBtn);
		for(int i=0; i<this.logoutBtn.size();i++) {
			String dropdownNames=this.logoutBtn.get(i).getText();
			if (dropdownNames.equalsIgnoreCase("Logout")){
				waitUntilElementVisible(driver,this.logoutBtn.get(i));
				this.logoutBtn.get(i).click();
				break;
			}

		}

		logger.info("Ending of filtersLeavesLogout Method");
	}

}
