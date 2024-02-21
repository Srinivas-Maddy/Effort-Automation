package com.effort.entities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class EntitiesSubmission extends BaseAutomationPage {

	public static final Logger logger = Logger.getLogger(EntitiesSubmission.class.getName());
	
	@FindBy(xpath = "//li[@id='logout_id']")
	private WebElement userNameBtn;

	@FindBy(xpath = "//li[@id='logout_id']/ul/li")
	private List<WebElement> logoutBtn;
	
	@FindBy(xpath="(//div[@class='dashboard-cards']/ul/li)[2]")
	private WebElement dashboardwebapp;
	
	@FindBy(id="dots")
	private WebElement webappthreedots;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu'])[1]/li/a")
	private List<WebElement> webappthreedotsdata;
	
	@FindBy(xpath="//ul[@id='orderedUl']/li/a")
    private List<WebElement> navigationBar;	
	
	@FindBy(id="addEntity")
	private WebElement addentity;
	
	@FindBy(xpath="(//input[@class='field form-control inputTypeText'])[1]")
	private WebElement entitynameinputfield;
	
	@FindBy(xpath="(//input[@class='field form-control inputTypeText'])[2]")
	private WebElement entityidinputfield;
	
	@FindBy(xpath="(//input[@class='mapField form-control'])[1]")
	private WebElement locationlat;
	
	@FindBy(xpath="(//input[@class='mapField form-control'])[2]")
	private WebElement locationlog;
	
	@FindBy(xpath="//input[@class='field numeric form-control']")
	private WebElement entitynumber;
	
	@FindBy(xpath="(//input[@class='field form-control inputTypeText'])[4]")
	private WebElement entitytext;
	
	@FindBy(xpath="//input[@class='time form-control']")
	private WebElement entitytime;
	
	@FindBy(xpath="(//div[@class='xdsoft_time_variant'])[2]/div")
	private List<WebElement> entitytimedropdown;
	
	@FindBy(xpath="(//input[@class='field dateTime form-control'])[2]")
	private WebElement entitydatetime;
	
	@FindBy(xpath="(//div[@class='xdsoft_calendar'])[3]/table/tbody/tr/td")
	private List<WebElement> entitydatetimedata;
	
	@FindBy(xpath="(//input[@class='field form-control'])[2]")
	private WebElement entityemail;
	
	@FindBy(xpath="//input[@class='field date form-control']")
	private WebElement entitydatefield;
	
	@FindBy(xpath="(//div[@class='xdsoft_calendar']/table)[4]/tbody/tr/td")
	private List<WebElement> entitydatedata;
	
	
	
	@FindBy(xpath="(//input[@class='mapField form-control'])[5]")
	private WebElement entitylocationlat;
	
	@FindBy(xpath="(//input[@class='mapField form-control'])[6]")
	private WebElement entitylocationlog;
	
	@FindBy(xpath="//input[@class='field form-control inputTypePhone']")
	private WebElement entityphone;
	
	@FindBy(xpath="//input[@class='field currency form-control']")
	private WebElement entitycurrency;
	
	@FindBy(xpath="//input[@class='field form-control inputTypeUrl']")
	private WebElement entityurl;
	
	@FindBy(xpath="//input[@accept='audio/*']")
	private WebElement entityaudio;
	
	@FindBy(xpath="//input[@class='fileMultiMedia']")
	private WebElement entitydocument;
	
	@FindBy(xpath="//input[@accept='image/*']")
	private WebElement entityimage;
	
	@FindBy(xpath="//input[@onclick='ValidateSingleInput(this);']")
	private WebElement entitysignature;
	
	@FindBy(xpath="//input[@accept='video/*']")
	private WebElement entityvideo;
	
	@FindBy(xpath="(//span[@class='select2-chosen'])[1]")
	private WebElement entitycountryfield;
	
	@FindBy(xpath="(//ul[@class='select2-results'])[4]/li/div")
	private List<WebElement> entitycountrydropdowndata;
	
	@FindBy(xpath="//select[@class='field cusPick form-control']")
	private WebElement entitycustomerfield;
	
	@FindBy(xpath="//table[contains(@class,'pq-grid-table')]/tbody/tr[3]/td[2]")
	private WebElement entitycustomersdata;
	
	@FindBy(xpath="(//input[@type='submit'])[3]")
	private WebElement entitycustomerokbtn;
	
	@FindBy(xpath="//select[@class='field pickemployees form-control']")
	private WebElement entityemployeefield;
	
	@FindBy(xpath="//div[@class='pq-cont']/table/tbody/tr[2]/td[2]")
	private WebElement entityemployeesdata;
	
	@FindBy(xpath="//input[@class='btn  btn-success']")
	private WebElement entityemployeeokbtn;
	
	@FindBy(xpath="//a[text()='								Click here to Select Customer']")
	private WebElement entitymultipickcustomerfield;
	
	@FindBy(xpath="//div[@class='pq-cont']/table/tbody/tr[4]/td[2]")
	private WebElement entitymultipickcustomersdata;
	
	@FindBy(xpath="//input[@value='OK']")
	private WebElement entitymultipickcustomerokbtn;
	
	@FindBy(xpath="(//span[@class='select2-chosen'])[2]")
	private WebElement entityterritoryfield;
	
	@FindBy(xpath="(//ul[@role='listbox'])[4]/li")
	private List<WebElement> entityterritorydropdowndata;
	
	@FindBy(xpath="(//span[@class='select2-chosen'])[3]")
	private WebElement yesornoinputfield;
	
	@FindBy(xpath="(//ul[@class='select2-results'])[4]/li")
	private List<WebElement> yesornodropdowndata;
	
	@FindBy(xpath="//select[@class='field pickForms form-control']")
	private WebElement entityformfield;
	
	@FindBy(xpath="//div[@class='pq-cont']/table/tbody/tr[2]/td[2]")
	private WebElement entityformsdata;
	
	@FindBy(xpath="(//input[@type='submit'])[3]")
	private WebElement entityformsokbtn;
	
	@FindBy(xpath="(//span[@class='select2-chosen'])[4]")
	private WebElement entitycustomertypefield;
	
	@FindBy(xpath="(//ul[@class='select2-results'])[4]/li")
	private List<WebElement> entitycustomertypedropdowndata;
	
	@FindBy(xpath="//select[@class='field customEntityPick form-control']")
	private WebElement entitycustomentityfield;
	
	@FindBy(xpath="//div[@class='pq-cont']/table/tbody/tr[4]/td[2]")
	private WebElement entitycustomentitydata;
	
	@FindBy(xpath="(//input[@type='submit'])[2]")
	private WebElement entitycustomentityokbtn;
	
	@FindBy(xpath="//input[@id='save']")
	private WebElement save;
	
	@FindBy(xpath="//div[@id='snackbarVal']")
	private WebElement entitycreationsuccusmsg;
	
	@FindBy(xpath="(//div[@class='container-fluid bg-1'])[2]")
//	(//div[@class='col-md-12'])[3]
	private WebElement page;
	
	@FindBy(xpath="//table[@id='example']/tbody//td[@class=' dt-body-center'][1]/div/a/i")
	private List<WebElement> editbtn;
	
	@FindBy(xpath="//div[@id='snackbarVal']")
	private WebElement modifiedsuccusmsg;
	
	@FindBy(xpath="//table[@id='example']/tbody//td[1]/input[@type='checkbox']")
	private List<WebElement> checkbox ;
	
	@FindBy(id="deleteForms")
	private WebElement deletebtn;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr[@role='row']/td[@class='dt-body-center sorting_1']")
	private List<WebElement> leftcheckboxs;
	
	@FindBy(linkText="Map To Employee")
	private WebElement maptoemployeebtn;
	
	@FindBy(xpath="//span[@class='select2-chosen']")
	private WebElement maptoemployeefield ;
	
	@FindBy(xpath="//input[@class='select2-input']")
	private WebElement maptoemployeeinputfield ;
	
	@FindBy(xpath="(//ul[@class='select2-results'])[3]")
	private List<WebElement> maptoemployeedropdowndata;
	
	@FindBy(xpath="//button[@onclick='performAssignTo();']")
	private WebElement maptoemployeeapply ;
	
	
	public EntitiesSubmission(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnWebApp() throws InterruptedException {
		logger.info("Starting of clickOnWebApp Method");
		this.hardWait(3);
		waitUntilElementVisible(driver, this.dashboardwebapp);
		this.dashboardwebapp.click();	
		Thread.sleep(500);
		logger.info("Ending of clickOnDots Method");	
		
	}
	
	public void clickOnEntityModule() {
		logger.info("Starting of click On entity module");
		for (int i = 0; i <this.navigationBar.size(); i++){
			String navNames=this.navigationBar.get(i).getText();
			if(navNames.equalsIgnoreCase("Automation Entity teju")) {
				waitUntilElementVisible(driver, this.navigationBar.get(i));
				this.navigationBar.get(i).click();
				break;
			}
			
		}
		logger.info("Ending of click On entity module");
	}
	
	public void clickOnAddEntity() {
		logger.info("Starting of clickOnAddEntity Method");
		waitUntilElementVisible(driver, this.addentity);
		this.addentity.click();	
		logger.info("Ending of clickOnAddEntity Method");	
	}
	
	public void switchToNewWindow() {
		logger.info("Starting of switchToNewWindow Method");
		String parentwindow = driver.getWindowHandle();
		Set<String> newwindow = driver.getWindowHandles();
		Iterator<String>I1 = newwindow.iterator();
		while(I1.hasNext()) {
			String childwindow = I1.next();
			if(!parentwindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);				
			}
		}	
		logger.info("Ending of switchToNewWindow Method");
	}
	
	public void enterEntityNameDetails(String Name) {
		logger.info("Starting of enterEntityDetails Method");
		waitUntilElementVisible(driver, this.entitynameinputfield);
		this.entitynameinputfield.sendKeys(Name);	
		logger.info("Ending of enterEntityDetails Method");
	}
	
	public void enterEntityIDDetails() {
		logger.info("Starting of enterEntityDetails Method");
		String RandomentityIds = randomMobileNumbers();
		waitUntilElementVisible(driver, this.entityidinputfield);
		this.entityidinputfield.sendKeys(RandomentityIds);		
		logger.info("Ending of enterEntityDetails Method");
	}
	
	public void enterEntityLat(String Lat) {
		logger.info("Starting of enterEntityLat Method");
		waitUntilElementVisible(driver, this.locationlat);
		this.locationlat.sendKeys(Lat);	
		logger.info("Ending of enterEntityLat Method");
	}
	
	public void enterEntityLog(String Log) {
		logger.info("Starting of enterEntityLog Method");
		waitUntilElementVisible(driver, this.locationlog);
		this.locationlog.sendKeys(Log);	
		scrollDown(50, save);
		logger.info("Ending of enterEntityLog Method");
	}
	
	public void enterEntityNumber(String Number) {
		logger.info("Starting of enterEntityNumber Method");
		waitUntilElementVisible(driver, this.entitynumber);
		this.entitynumber.sendKeys(Number);	
		logger.info("Ending of enterEntityNumber Method");
	}

	public void enterEntityText(String Text) {
		logger.info("Starting of enterEntityText Method");
		waitUntilElementVisible(driver, this.entitytext);
		this.entitytext.sendKeys(Text);	
		logger.info("Ending of enterEntityText Method");
	}
	
	public void pickEntityTime() throws InterruptedException {
		logger.info("Starting of pickEntityTime Method");
		waitUntilElementVisible(driver, this.entitytime);
		scrollDown(100, entitytime);
		this.entitytime.click();
		String currentTime = getCurrentTime();
		String[] timeString = currentTime.split(":");
		Integer hour = Integer.parseInt(timeString[0]);
		hour = hour * 60;
		Integer min = Integer.parseInt(timeString[1]);
		int Index = hour + min;
		int timeItemCount = entitytimedropdown.size();
		if (timeItemCount != 1440) {
			Index = 50;
		}
		Thread.sleep(1000);
		this.entitytimedropdown.get(Index).click();
		
		logger.info("Ending of pickEntityTime Method");
	}
	
	public void clickEntityDateTime() {
		logger.info("Starting of clickEntityDateTime Method");
		waitUntilElementVisible(driver, this.entitydatetime);
		this.entitydatetime.click();
		
		logger.info("Ending of clickEntityDateTime Method");
	}
	public void pickEntityDateTime() throws InterruptedException {
		logger.info("Starting of pickEntityDateTime Method");
		String presentdatetime = getCurrentDateAsNumber();
		Thread.sleep(500);
		for (int i = 0; i <= entitydatetimedata.size() - 1; i++) {
			String actualdatetime = entitydatetimedata.get(i).getText();
			if (actualdatetime.equalsIgnoreCase(presentdatetime)) {
				waitUntilElementVisible(driver, entitydatetimedata.get(i));
				entitydatetimedata.get(i).click();
				break;
			}
		}
		this.entitydatetime.click();
		
		logger.info("Ending of pickEntityDateTime Method");
	}
	public void enterEntityEmail(String entityemail) {
		logger.info("Starting of enterEntityEmail Method");
		waitUntilElementVisible(driver, this.entityemail);
		this.entityemail.sendKeys(entityemail);
		logger.info("Ending of enterEntityEmail Method");
	}
	
	public void ClickEntityDate() {
		logger.info("Starting of ClickEntityDate Method");
		waitUntilElementVisible(driver, this.entitydatefield);
		this.entitydatefield.click();
		logger.info("Ending of ClickEntityDate Method");
	}
	
	public void pickEntityDate() throws InterruptedException {
		logger.info("Starting of pickEntityDate Method");
		String presentdate = getCurrentDateAsNumber();
		Thread.sleep(500);
		for (int i = 0; i <= entitydatedata.size() -1; i++) {
			String actualdate = entitydatedata.get(i).getText();
			if (actualdate.equalsIgnoreCase(presentdate)) {
				waitUntilElementVisible(driver, entitydatedata.get(i));
				entitydatedata.get(i).click();
				break;
			}
		}
		
		logger.info("Ending of pickEntityDate Method");
	}
	
	public void enterEntityLocationLat(String EntityLat) {
		logger.info("Starting of enterEntityLocationLat Method");
		waitUntilElementVisible(driver, this.entitylocationlat);
		this.entitylocationlat.sendKeys(EntityLat);
		logger.info("Ending of enterEntityLocationLat Method");
	}
	
	public void enterEntityLocationLog(String EntityLog) {
		logger.info("Starting of enterEntityLocationLong Method");
		waitUntilElementVisible(driver, this.entitylocationlog);
		this.entitylocationlog.sendKeys(EntityLog);	
		logger.info("Ending of enterEntityLocationLong Method");
	}
	
	public void enterEntityPhone() {
		logger.info("Starting of enterEntityPhone Method");
		String RandomPhone = randomMobileNumbers();
		waitUntilElementVisible(driver, this.entityphone);
		entityphone.sendKeys(RandomPhone);
		logger.info("Ending of enterEntityPhone Method");
	}
	public void enterEntityCurrency(String Currencyvalue) {
		logger.info("Starting of enterEntityCurrency Method");
		waitUntilElementVisible(driver, this.entitycurrency);
		this.entitycurrency.sendKeys(Currencyvalue);	
		
		logger.info("Ending of enterEntityCurrency Method");
	}
	public void enterEntityURL(String entityURL) {
		logger.info("Starting of enterEntityURL Method");
		waitUntilElementVisible(driver, this.entityurl);
		this.entityurl.sendKeys(entityURL);	
		
		logger.info("Ending of enterEntityURL Method");
	}
	public void pickEntityAudio() {
		logger.info("Starting of pickEntityAudio Method");
		waitUntilElementVisible(driver, this.entityaudio);
		String audiopath= System.getProperty("user.dir")+ "/MediaFiles/Audofile.mp3";
		this.entityaudio.sendKeys(audiopath);	
		logger.info("Ending of pickEntityAudio Method");
	}
	
	public void pickEntityDocument() {
		logger.info("Starting of pickDocument Method");
		waitUntilElementVisible(driver, this.entitydocument);
		String documentpath= System.getProperty("user.dir")+ "/MediaFiles/Documentfile.xlsx";
		this.entitydocument.sendKeys(documentpath);		
		logger.info("Ending of pickDocument Method");
	}
	
	public void pickEntityImage() {
		logger.info("Starting of pickEntityImage Method");
		waitUntilElementVisible(driver, this.entityimage);
		String imagepath= System.getProperty("user.dir")+ "/MediaFiles/image.jpg";
		this.entityimage.sendKeys(imagepath);		
		logger.info("Ending of pickEntityImage Method");
	}
	public void pickEntitySignature() {
		logger.info("Starting of pickEntitySignature Method");
		waitUntilElementVisible(driver, this.entitysignature);
		String signaturepath= System.getProperty("user.dir")+ "/MediaFiles/Signature.jpg";
		this.entitysignature.sendKeys(signaturepath);		
		logger.info("Ending of pickEntitySignature Method");
	}
	public void pickEntityVideo() {
		logger.info("Starting of pickEntityVideo Method");
		waitUntilElementVisible(driver, this.entityvideo);
		String videopath= System.getProperty("user.dir")+ "/MediaFiles/Video.mp4";
		this.entityvideo.sendKeys(videopath);		
		logger.info("Ending of pickEntityVideo Method");
	}
	
	public void pickEntityCountry() throws InterruptedException {
		logger.info("Starting of pickEntityCountry Method");
		scrollDown(100, this.entitycountryfield);
		waitUntilElementVisible(driver, this.entitycountryfield);
		this.entitycountryfield.click();
		for (int i = 0; i <this.entitycountrydropdowndata.size(); i++) {
			String countryName = this.entitycountrydropdowndata.get(i).getText();
			if (countryName.equalsIgnoreCase("India")) {
				waitUntilElementVisible(driver, this.entitycountrydropdowndata.get(i));
				this.entitycountrydropdowndata.get(i).click();
				break;
			}
		}
		logger.info("Ending of pickEntityCountry Method");
	}
	
	public void selectEntityCustomer() {
		logger.info("Starting of selectEntityCustomer Method");
		waitUntilElementVisible(driver, this.entitycustomerfield);
		this.entitycustomerfield.click();
		waitUntilElementVisible(driver, this.entitycustomersdata);
		this.entitycustomersdata.click();
		waitUntilElementVisible(driver, this.entitycustomerokbtn);
		this.entitycustomerokbtn.click();
		logger.info("Ending of selectEntityCustomer Method");
	}
	public void SelectEntityEmployee() throws InterruptedException {
		logger.info("Starting of SelectEntityEmployee Method");
		waitUntilElementVisible(driver, this.entityemployeefield);
		this.entityemployeefield.click();
		waitUntilElementVisible(driver, this.entityemployeesdata);
		this.entityemployeesdata.click();
		waitUntilElementVisible(driver, this.entityemployeeokbtn);
		this.entityemployeeokbtn.click();
		logger.info("Ending of SelectEntityEmployee Method");
	}
	public void selectEntityMultiPickCustomer() {
		logger.info("Starting of selectEntityMultiPickCustomer Method");
		waitUntilElementVisible(driver, this.entitymultipickcustomerfield);
		this.entitymultipickcustomerfield.click();
		this.hardWait(3);
		waitUntilElementVisible(driver, this.entitymultipickcustomersdata);
		this.entitymultipickcustomersdata.click();
		waitUntilElementVisible(driver, this.entitymultipickcustomerokbtn);
		this.entitymultipickcustomerokbtn.click();
		logger.info("Ending of selectEntityMultiPickCustomer Method");
	}
	public void clickEntityTerritory() {
		logger.info("Starting of pickEntityTerritory Method");
		waitUntilElementVisible(driver, this.entityterritoryfield);
		this.entityterritoryfield.click();
		logger.info("Ending of pickEntityTerritory Method");
	}
	public void pickEntityTerritory(String Territoryname) {
		logger.info("Starting of pickEntityTerritory Method");
		int territoryOptionCount = 0;
		while (territoryOptionCount < this.entityterritorydropdowndata.size()) {
			if (entityterritorydropdowndata.get(territoryOptionCount).getText().equalsIgnoreCase(Territoryname)) {
				entityterritorydropdowndata.get(territoryOptionCount).click();
				break;
			}
			territoryOptionCount++;
		}
		logger.info("Ending of pickEntityTerritory Method");
	}
	
	public void pickYesorNo(String yesorno) {
		logger.info("Starting of selectYesorNo Method");
		waitUntilElementVisible(driver,this.yesornoinputfield);
		this.yesornoinputfield.click();	
		int yesOrNoOptionCount = 0;
		while (yesOrNoOptionCount < this.yesornodropdowndata.size()) {
			if (yesornodropdowndata.get(yesOrNoOptionCount).getText().equalsIgnoreCase(yesorno)) {
				yesornodropdowndata.get(yesOrNoOptionCount).click();
				break;
			}
			yesOrNoOptionCount++;
		}
		logger.info("Ending of selectYesorNo Method");
	}
	
	
	public void selectForm() throws InterruptedException {
		logger.info("Starting of selectForm Method");
		scrollDown(100, this.entityformfield);
			waitUntilElementVisible(driver, this.entityformfield);
			this.entityformfield.click();
			waitUntilElementVisible(driver, this.entityformsdata);
			this.entityformsdata.click();
			waitUntilElementVisible(driver, this.entityformsokbtn);
			this.entityformsokbtn.click();
		logger.info("Ending of selectForm Method");
	}
	
	public void selectCustomerType(String customertype) {
		logger.info("Starting of selectCustomerType Method");
		scrollDown(100, this.entitycustomentityfield);
			waitUntilElementVisible(driver, this.entitycustomertypefield);
			this.entitycustomertypefield.click();
			int customertypeOptionCount = 0;
			while (customertypeOptionCount < this.entitycustomertypedropdowndata.size()) {
				if (entitycustomertypedropdowndata.get(customertypeOptionCount).getText().equalsIgnoreCase(customertype)) {
					entitycustomertypedropdowndata.get(customertypeOptionCount).click();
					break;
				}
				customertypeOptionCount++;
			}
		logger.info("Ending of selectCustomerType Method");
	}
	
	public void selectCustomEntity() {
		logger.info("Starting of selectCustomEntity Method");
			waitUntilElementVisible(driver, this.entitycustomentityfield);
			this.entitycustomentityfield.click();
			waitUntilElementVisible(driver, this.entitycustomentitydata);
			this.entitycustomentitydata.click();
			waitUntilElementVisible(driver, this.entitycustomentityokbtn);
			this.entitycustomentityokbtn.click();
		logger.info("Ending of selectCustomEntity Method");
	}
	
	
	public void saveEntity() {
		logger.info("Starting of saveEntity Method");
		scrollDown(100, this.save);
		waitUntilElementVisible(driver, this.save);
		this.save.click();	
		logger.info("Ending of saveEntity Method");
	}
	
	public String saveEntityAndValidateCreatedEntity() {
		logger.info("Starting of saveEntityAndValidateCreatedEntity Method");
		scrollDown(100, this.save);
		waitUntilElementVisible(driver, this.save);
		this.save.click();	
		
		waitUntilElementVisible(driver, this.entitycreationsuccusmsg);
		String entitycreationsuccusmsg = this.entitycreationsuccusmsg.getText();
		logger.info("Ending of saveEntityAndValidateCreatedEntity Method");
		
		return entitycreationsuccusmsg;	
	}


	public String saveEntityAndValidateModifiedEntity() {
		logger.info("Starting of saveEntityAndValidateModifiedEntity Method");
		scrollDown(100, this.save);
		waitUntilElementVisible(driver, this.save);
		this.save.click();	
		
		waitUntilElementVisible(driver, modifiedsuccusmsg);
		String EntityModifiedMsg = this.modifiedsuccusmsg.getText();
		
		logger.info("Ending of saveEntityAndValidateModifiedEntity Method");
		
		return EntityModifiedMsg;
	}
	public String validateEntityCreationsuccusMessage() {
		logger.info("Starting of validateEntityCreationsuccusMessage Method");
		waitUntilElementVisible(driver, this.entitycreationsuccusmsg);
		String entitycreationsuccusmsg = this.entitycreationsuccusmsg.getText();
		return entitycreationsuccusmsg;	
		
	}
	public void ClickonEditBtn() throws InterruptedException {
		logger.info("Starting of ClickonEditBtn Method");
		Thread.sleep(500);
		//scrollDown(200, page);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		for (int i = 0; i < editbtn.size(); i++) {
			this.editbtn.get(i).click();
			break;
		}
		logger.info("Ending of ClickonEditBtn Method");
	}
	
	public void modifyEntityName(String ModifiedEntityName) {
		logger.info("Starting of modifyEntityName Method");
		waitUntilElementVisible(driver, this.entitynameinputfield);
		this.entitynameinputfield.clear();
		this.entitynameinputfield.sendKeys(ModifiedEntityName);	
		logger.info("Ending of modifyEntityName Method");
	}
	
	public void modifyEntityID() {
		logger.info("Starting of modifyEntityID Method");
		waitUntilElementVisible(driver, this.entityidinputfield);
		this.entityidinputfield.clear();
		String modifiedentityid= randomMobileNumbers();
		this.entityidinputfield.sendKeys(modifiedentityid);	
		logger.info("Ending of modifyEntityID Method");
	}
	
	public String modifiedSuccusMsg() {
		logger.info("Starting of modifiedSuccusMsg Method");

		waitUntilElementVisible(driver, modifiedsuccusmsg);
		String EntityModifiedMsg = this.modifiedsuccusmsg.getText();
		return EntityModifiedMsg;
	}
	
	public void selectEntitytoDelete() throws InterruptedException {
		logger.info("Starting of selectEntitytoDelete Method");
		Thread.sleep(500);
		scrollIntoView(page);
		int i = 0;
		while (i < this.checkbox.size()) {
		    this.checkbox.get(i).click();
		    break;
		}
		logger.info("Ending of selectEntitytoDelete Method");
	}
	
	public void ClickonDeleteBtn() throws InterruptedException {
		logger.info("Starting of ClickonDelete Method");
		waitUntilElementVisible(driver, this.deletebtn);
		this.deletebtn.click();
		driver.switchTo().alert().accept();
		JavascriptExecutor js= 	(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-250)");
		logger.info("Ending of ClickonDelete Method");
	}
	
	
	public void LogOutEntity() throws InterruptedException {
		logger.info("Starting of LogOut Method");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		waitUntilElementVisible(driver, userNameBtn);
		userNameBtn.click();
		if (logoutBtn.get(logoutBtn.size() - 1).getText().equalsIgnoreCase("LogOut")) {
			logoutBtn.get(logoutBtn.size() - 1).click();
		}
		logger.info("Ending of LogOut Method");
	}

}
