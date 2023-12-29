package com.effort.leaves;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class LeavesPage extends BaseAutomationPage {
	private static final Logger logger = Logger.getLogger(LeavesPage.class.getName());

	@FindBy(xpath = "(//div[@class='dashboard-cards']/ul/li)[2]")
	private WebElement dashboardwebapp;

	@FindBy(xpath = "//a[text()=' Leaves']")
	private WebElement leaves;

	@FindBy(id = "dots")
	private WebElement threeDots;

	@FindBy(xpath = "//ul[@class='dropdown-menu']/li/a")
	private List<WebElement> dropdownList;

	@FindBy(xpath = "((//ul[@class='list-inline pull-right'])[1]/li)[1]/a/button")
	private WebElement leavesbtn;

	@FindBy(xpath = "//input[@id='fromDate']")
	private WebElement fromdatefield;

	@FindBy(xpath = "(//div[@class='xdsoft_calendar'])[1]/table/tbody/tr/td")
	private List<WebElement> fromdatesdata;

	@FindBy(id = "toDate")
	private WebElement toDateField;

	@FindBy(xpath = "(//div[@class='xdsoft_calendar'])[2]/table/tbody/tr/td")
	private List<WebElement> toDateCalender;

	@FindBy(xpath = "//div[@id='s2id_leaveTp']")
	private WebElement leavetypefield;

	@FindBy(xpath = "(//div[@class='select2-search'])[2]/input")
	private WebElement leavetypeinputfield;

	@FindBy(xpath = "//ul[@class='select2-results']/li/div")
	private List<WebElement> leavetypedropdowndata;

	@FindBy(id = "employeeNote")
	private WebElement leavesremarksarea;

	@FindBy(xpath = "//div[@class='card-v']")
	private WebElement leaveapplyformscroll;

	@FindBy(id = "save")
	private WebElement leavessavebtn;

	@FindBy(xpath = "//table[@id='example']/tbody/tr/td[1]")
	private List<WebElement> leavescheckbox;
	
	@FindBy(id="filters")
	private WebElement filterOption;
	
	@FindBy(id="appliedLeaves")
	private WebElement appliedLeave_Checkbox;
	
	@FindBy(id="search")
	private WebElement search_Button;
	
	@FindBy(xpath="(//input[@id='selectLeave'])[1]")
	private WebElement selectAppliedLeave_Checkbox;
	
	@FindBy(id="managerNote")
	private WebElement remarks_TextArea;
	
	@FindBy(id="assignLeaves")
	private WebElement approved_Btn;
	
	@FindBy(id="rejectLeaves")
	private WebElement rejected_Btn;
	
	@FindBy(id="managerNoteForReject")
	private WebElement rejectionRemark_TextArea;
	
	@FindBy(id="approve")
	private WebElement approve_Btn;
	
	@FindBy(id="reject")
	private WebElement reject_Btn;

	@FindBy(xpath = "//input[@id='approve']")
	private WebElement leavesapprovebtn;

	@FindBy(xpath = "(//div[@class='modal-content'])[5]//fieldset/textarea")
	private WebElement leavapprovalnote;

	@FindBy(xpath = "(//input[@value='Approve'])[2]")
	private WebElement leaveapprovalnotebtn;

	@FindBy(xpath = "//input[@id='reject']")
	private WebElement leavesrejectbtn;

	@FindBy(xpath = "//textarea[@id='managerNoteForReject']")
	private WebElement leaverejectnote;

	@FindBy(xpath = "//input[@id='rejectLeaves']")
	private WebElement leaverejectnotebtn;

	@FindBy(xpath = "//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath = "//td[contains(@class,'xdsoft_current xdsoft_today')]")
	private WebElement dateToday;
	
	@FindBy(xpath="//div[@id='title-content']")
	private WebElement leaveTitle;

	@FindBy(xpath = "//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;

	public LeavesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnWebApp() throws InterruptedException {
		logger.info("Starting of clickOnWebApp Method");
		hardWait(3);
		waitUntilElementVisible(driver, this.dashboardwebapp);
		this.dashboardwebapp.click();
		Thread.sleep(500);
		logger.info("Ending of clickOnDots Method");

	}

	public void clickOnThreeDots() {
		logger.info("Starting of clickOnThreeDots Method");
		waitUntilElementVisible(driver, this.threeDots);
		this.threeDots.click();
		logger.info("Ending of clickOnThreeDots Method");
	}

	public void clickOnLeaves(String leaveSpecName) {
		for (int i = 0; i < this.dropdownList.size(); i++) {
			String threeDotsData = this.dropdownList.get(i).getText();
			if (threeDotsData.equalsIgnoreCase(leaveSpecName)) {
				waitUntilElementVisible(driver, this.dropdownList.get(i));
				this.dropdownList.get(i).click();
				break;
			}
		}
	}

	public void clickOnApplyLeaves() {
		logger.info("Starting of clickOnApplyLeaves Method");
		waitUntilElementVisible(driver, this.leavesbtn);
		this.leavesbtn.click();
		logger.info("Ending of clickOnApplyLeaves Method");
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

	public void pickLeavesFromDate() throws InterruptedException {
		logger.info("Starting of pickLeavesFromDate Method");

		waitUntilElementVisible(driver, this.fromdatefield);
		clickOnWebElement(fromdatefield);
		String presentdatetime = getCurrentDateAsNumber();
		String currentMonth = getCurrentMonthAsString();
		hardWait(5);
		List<WebElement> currentMonthDates = driver.findElements(
				By.xpath("(//div[@class='xdsoft_calendar'])[1]/table/tbody/tr/td[@data-month="+currentMonth+"]"));

		for (int i = 0; i < currentMonthDates.size(); i++) { 
			String fromactualdatetime = currentMonthDates.get(i).getText();
			if(fromactualdatetime.equalsIgnoreCase(presentdatetime)) 
			{
			 waitUntilElementVisible(driver, currentMonthDates.get(i));
			 clickOnWebElement(currentMonthDates.get(i));
			 break; 
			 } 
			
		}
		clickOnWebElement(leaveTitle);
		hardWait(10);
		logger.info("Ending of pickLeavesFromDate Method");
	}

	public void clickOnToDate() throws InterruptedException {
		logger.info("Starting of clickToDate Method");

		scrollDown(0, this.toDateField);
		waitUntilElementVisible(driver, this.toDateField);
		this.toDateField.click();
		String tomorrowDate = getTomorrowDateAsNumber(1);
		Thread.sleep(500);
		for (int i = 1; i < toDateCalender.size(); i++) {
			hardWait(3);
			String fromactualdatetime = this.toDateCalender.get(i).getText();
			if (fromactualdatetime.equalsIgnoreCase(tomorrowDate)) {
				waitUntilElementVisible(driver, this.toDateCalender.get(i));
				this.toDateCalender.get(i).click();
				break;
			}
		}

	}

	public void clickOnTo() {
		logger.info("Starting of clickOnTo Method");

		scrollDown(0, this.toDateField);
		hardWait(10);
		waitUntilElementVisible(driver, this.toDateField);
		clickOnWebElement(this.toDateField);
		String currentMonth = getCurrentMonthAsString();
		String tomorrowDate = getTomorrowDateAsNumber(1);
		hardWait(5);
		List<WebElement> currentMonthDates = driver.findElements(
				By.xpath("(//div[@class='xdsoft_calendar'])[2]/table/tbody/tr/td[@data-month="+currentMonth+"]"));

		for (int i = 0; i < currentMonthDates.size(); i++) {
			String monthsInCalender = currentMonthDates.get(i).getText();
			if (monthsInCalender.equalsIgnoreCase(tomorrowDate)) {
				waitUntilElementVisible(driver, currentMonthDates.get(i));
				clickOnWebElement(currentMonthDates.get(i));
				break;
			}
		}
		clickOnWebElement(leaveTitle);
		hardWait(4);
		
		logger.info("Ending of clickOnTo Method");
	}

	public void pickLeaveType(String leavetype) {
		logger.info("Starting of pickLeaveType Method");
		hardWait(3);

		try {
			this.leavetypefield.click();
			for (int i = 0; i < leavetypedropdowndata.size(); i++) {
				String actualleavetype = this.leavetypedropdowndata.get(i).getText();
				if (actualleavetype.equalsIgnoreCase(leavetype)) {
					waitUntilElementVisible(driver, this.leavetypedropdowndata.get(i));
					this.leavetypedropdowndata.get(i).click();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println();
		}
		waitUntilElementVisible(driver, this.leavetypefield);

		logger.info("Ending of pickLeaveType Method");
	}

	public void enterLeaveRemarks(String leaveRemark) throws InterruptedException {
		logger.info("Starting of enterLeaveRemarks Method");
		waitUntilElementVisible(driver, this.leavesremarksarea);
		this.leavesremarksarea.sendKeys(leaveRemark);
		Thread.sleep(2000);
		String presentdatetime = getCurrentDateAsNumber();
		Thread.sleep(500);
		for (int i = 0; i < fromdatesdata.size(); i++) {
			String fromactualdatetime = this.fromdatesdata.get(i).getText();
			if (fromactualdatetime.equalsIgnoreCase(presentdatetime)) {
				waitUntilElementVisible(driver, this.fromdatesdata.get(i));
				this.fromdatesdata.get(i).click();
				break;
			}
		}

	}

	public void leavesSave() throws InterruptedException {
		logger.info("Starting of leavesSave Method");
		scrollDown(100, this.leaveapplyformscroll);
		waitUntilElementVisible(driver, this.leavessavebtn);
		this.leavessavebtn.click();
	}
	
	public void approvedPendingLeave() {
		logger.info("Starting of approvedPendingLeave method");
		
		waitUntilElementVisible(driver, this.filterOption);
		clickOnWebElement(this.filterOption);
		waitUntilElementVisible(driver, this.appliedLeave_Checkbox);
		clickOnWebElement(this.appliedLeave_Checkbox);
		waitUntilElementVisible(driver, this.search_Button);
		clickOnWebElement(this.search_Button);
		waitUntilElementVisible(driver, this.selectAppliedLeave_Checkbox);
		hardWait(5);
		clickOnWebElement(this.selectAppliedLeave_Checkbox);
		clickOnWebElement(this.approve_Btn);
		waitUntilElementVisible(driver, this.remarks_TextArea);
		this.remarks_TextArea.sendKeys("Approved Leave throgh the Automation script");
		waitUntilElementVisible(driver, this.approved_Btn);
		clickOnWebElement(this.approved_Btn);
		
		logger.info("Ending of approvedPendingLeave method");		
	}
	
	public void rejectPendingLeave() {
		logger.info("Starting of rejectPendingLeave method");
		
		hardWait(5);
		waitUntilElementVisible(driver, this.filterOption);
		clickOnWebElement(this.filterOption);
		waitUntilElementVisible(driver, this.appliedLeave_Checkbox);
		clickOnWebElement(this.appliedLeave_Checkbox);
		waitUntilElementVisible(driver, this.search_Button);
		clickOnWebElement(this.search_Button);
		hardWait(5);
		waitUntilElementVisible(driver, this.selectAppliedLeave_Checkbox);
		clickOnWebElement(this.selectAppliedLeave_Checkbox);
		clickOnWebElement(this.reject_Btn);
		waitUntilElementVisible(driver, this.rejectionRemark_TextArea);
		this.rejectionRemark_TextArea.sendKeys("Rejected Leave throgh the Automation script");
		waitUntilElementVisible(driver, this.rejected_Btn);
		clickOnWebElement(this.rejected_Btn);
		
		logger.info("Ending of rejectPendingLeave method");		
	}

	
	

	public void selectEmployeeToReject() throws InterruptedException {
		logger.info("Starting of selectEmployeeToReject Method");
		Thread.sleep(1000);
		int i = 0;
		while (i < this.leavescheckbox.size()) {
			waitUntilElementVisible(driver, this.leavescheckbox.get(i));
			this.leavescheckbox.get(i).click();
			break;
		}
		i++;
	}

	public void clickOnReject() {
		logger.info("Starting of clickOnReject Method");
		waitUntilElementVisible(driver, this.leavesrejectbtn);
		this.leavesrejectbtn.click();
	}

	public void enterLeaveRejectNote(String rejectnote) throws InterruptedException {
		logger.info("Starting of enterLeaveRejectNote Method");
		waitUntilElementVisible(driver, this.leaverejectnote);
		this.leaverejectnote.sendKeys(rejectnote);
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.leaverejectnotebtn);
		this.leaverejectnotebtn.click();
	}

	public void leavesLogOut() throws InterruptedException {

		logger.info("Starting of leavesLogout Method");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		waitUntilElementVisible(driver, userNameBtn);
		userNameBtn.click();
		if (logoutBtn.get(logoutBtn.size() - 1).getText().equalsIgnoreCase("LogOut")) {
			logoutBtn.get(logoutBtn.size() - 1).click();
		}
		logger.info("Ending of leavesLogout Method");
	}

}
