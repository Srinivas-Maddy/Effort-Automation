package com.effort.filters;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class EntityFiltersPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(EntityFiltersPage.class.getName());

	@FindBy(xpath = "(//div[@class='dashboard-cards']/ul/li)[2]")
	private WebElement dashboardwebapp;

	@FindBy(id = "dots")
	private WebElement webappthreedots;

	@FindBy(xpath = "(//ul[@class='dropdown-menu'])[1]/li")
	private List<WebElement> webappthreedotsdata;

	@FindBy(xpath = "//ul[@class='list-inline pull-left']/li/a")
	private WebElement filtersbtn;

	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	private WebElement entityName;

	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]/td[4]")
	private WebElement entityNameResult;

	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	private WebElement fltrentityidfield;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[5]")
	private WebElement fltrentityidresult;

	@FindBy(xpath = "(//input[@class='form-control'])[3]")
	private WebElement fltrentitylocation;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[6]")
	private WebElement fltrlocationresult;

	@FindBy(xpath = "//input[@class='form-control numeric']")
	private WebElement fltrentitynumber;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[10]")
	private WebElement fltrnumberresult;

	@FindBy(xpath = "(//div[text()='Text'])[2]/input")
	private WebElement fltrentitytext;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[11]")
	private WebElement fltrtextresult;

	@FindBy(xpath = "(//input[@class='form-control'])[7]")
	private WebElement fltremailfield;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[16]")
	private WebElement fltremailresult;

	@FindBy(xpath = "(//input[@class='form-control'])[8]")
	private WebElement fltrlocfield;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[18]")
	private WebElement fltrlocresult;

	@FindBy(xpath = "(//input[@class='form-control'])[9]")
	private WebElement fltrphnfield;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[19]")
	private WebElement fltrphnresult;

	@FindBy(xpath = "(//input[@class='form-control'])[10]")
	private WebElement fltrcurrencyfield;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[20]")
	private WebElement fltrcurrencyresult;

	@FindBy(xpath = "(//input[@class='form-control'])[11]")
	private WebElement fltrurlfield;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[21]")
	private WebElement fltrurlresult;

	@FindBy(xpath = "(//input[@class='form-control'])[13]")
	private WebElement fltrcountryfield;

	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[27]")
	private WebElement fltrcountryresult;

	@FindBy(xpath = "(//div[text()='Customer'])[2]/div")
	private WebElement fltrcustomerfield;

	@FindBy(xpath = "(//div[text()='Customer'])[2]/div/ul/li/input")
	private WebElement enterCustomerName;

	@FindBy(xpath = "(//ul[@class='select2-results'])[8]/li/div/span")
	private List<WebElement> fltrcustomerdropdowndata;

	@FindBy(xpath = "((//table[@id='example']/tbody/tr)/td)[4]")
	private WebElement fltrcustmrresult;

	@FindBy(xpath = "(//div[text()='Multi Pick Customer'])[2]/div")
	private WebElement fltrmultipickcustomerfield;

	@FindBy(xpath = "(//div[text()='Multi Pick Customer'])[2]/div/ul/li/input")
	private WebElement fltrmultipickcustomerinputfield;

	@FindBy(xpath = "(//ul[@class='select2-results'])[8]/li/div/span")
	private List<WebElement> fltrmultipickcustomerdropdowndata;

	@FindBy(xpath = "((//table[@id='example']/tbody/tr)/td)[4]")
	private WebElement fltrmultipickcustomerresult;

	@FindBy(xpath = "(//div[text()='Territory'])[2]/div")
	private WebElement fltrterritoryfield;

	@FindBy(xpath = "(//ul[@class='select2-results'])[8]/li/div")
	private List<WebElement> fltrterritorydropdowndata;

	@FindBy(xpath = "((//table[@id='example']/tbody/tr)/td)[5][text()='807090']")
	private WebElement fltrterritoryresult;

	@FindBy(xpath = "(//div[text()='Yes/No'])[2]/select")
	private WebElement fltryesornofield;

	@FindBy(xpath = "(//div[text()='Yes/No'])[2]/select/option")
	private List<WebElement> fltryesornodata;

	@FindBy(xpath = "((//table[@id='example']/tbody/tr)/td)[4]")
	private WebElement fltryesornoresult;

	@FindBy(xpath = "(//div[text()='Customer Type'])[2]/input")
	private WebElement fltrcustomertypefield;
	
	@FindBy(xpath = "(//table[@id='example']/tbody/tr/td)[32]")
	private WebElement fltrcustomertyperesult;
	
	@FindBy(xpath="((//div[@class='col-md-12 pd-0'])[5]/div[2]/div)[1]/div")
	private WebElement fltrfilledbyfield;
	
	@FindBy(xpath="//div[text()='FilledBy']/div/ul/li/input")
	private WebElement fltrfilledbyinputfield;
	
	@FindBy(xpath="(//div[contains(@class,'select2-drop-multi')])[7]/ul/li/div/span")
	private List<WebElement> fltrfilledbydropdowndata;
	
	@FindBy(xpath="((//table[@id='example']/tbody/tr)/td)[4]")
	private WebElement fltrfilledbyresult;
	
	@FindBy(xpath = "((//a/span)[4]/span)[2]")
	private WebElement userNameBtn;
	
	@FindBy(xpath="//ul[@id='orderedUl']/li/a")
    private List<WebElement> navigationBar;	
	
	@FindBy(xpath = "(//ul[@class='dropdown-menu'])[2]/li/a[text()=' Logout']")
	private WebElement logoutBtn;

//	@FindBy(xpath = "(//ul[@class='dropdown-menu'])[2]/li/a")
//	private List<WebElement> logoutBtn;

	@FindBy(id = "search")
	private WebElement filterapply;

	@FindBy(xpath = "//a[text()='Reset']")
	private WebElement filtersreset;

	public EntityFiltersPage(WebDriver driver) {
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

	public void clickOnEntityModule() {
		logger.info("Starting of click On entity module");
		for (int i = 0; i <this.navigationBar.size(); i++){
			String navNames=this.navigationBar.get(i).getText();
			if(navNames.equalsIgnoreCase("Automation Entity teju1")) {
				waitUntilElementVisible(driver, this.navigationBar.get(i));
				this.navigationBar.get(i).click();
				break;
			}
			
		}
		logger.info("Ending of click On entity module");
	}
	

	public String enterFiltersEntityName(String filterentityname) {
		logger.info("Starting of enterFiltersEntityName Method");
		scrollDown(100, this.filtersbtn);
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.entityName);
		this.entityName.sendKeys(filterentityname);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.entityNameResult);
		String actualfltrname = this.entityNameResult.getText();
		return actualfltrname;
	}

	public String enterFilterEntityID(String filterentityid) {
		logger.info("Starting of enterFilterEntityID Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		waitUntilElementVisible(driver, this.fltrentityidfield);
		this.fltrentityidfield.sendKeys(filterentityid);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.fltrentityidresult);
		String actualfltrid = this.fltrentityidresult.getText();
		return actualfltrid;
		// logger.info("Ending of enterFilterEntityID Method");
	}

	public String enterFilterEntityLocation(String filterentitylocation) {
		logger.info("Starting of enterFilterEntityLocation Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		waitUntilElementVisible(driver, this.fltrentitylocation);
		this.fltrentitylocation.sendKeys(filterentitylocation);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.fltrlocationresult);
		String actualfltrlocation = this.fltrlocationresult.getText();
		return actualfltrlocation;
	}

	public String enterFilterNumber(String filterentitynumber) throws InterruptedException {
		logger.info("Starting of enterFilterNumber Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		waitUntilElementVisible(driver, this.fltrentitynumber);
		this.fltrentitynumber.sendKeys(filterentitynumber);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.fltrnumberresult);
		String actualfltrnumber = this.fltrnumberresult.getText();
		return actualfltrnumber;
	}

	public String enterFilterText(String filterentitytext) throws InterruptedException {
		logger.info("Starting of enterFilterText Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		scrollDown(100, this.fltrentitytext);
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.fltrentitytext);
		this.fltrentitytext.sendKeys(filterentitytext);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.fltrtextresult);
		String actualfltrtext = this.fltrtextresult.getText();
		return actualfltrtext;
	}

	public String enterFilterEmail(String filterentityemail) throws InterruptedException {
		logger.info("Starting of enterFilterEmail Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		scrollDown(100, this.fltremailfield);
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.fltremailfield);
		this.fltremailfield.sendKeys(filterentityemail);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.fltremailresult);
		String actualfltremail = this.fltremailresult.getText();
		return actualfltremail;
	}

	public String enterFilterLoc(String filterentityloc) throws InterruptedException {
		logger.info("Starting of enterFilterLoc Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.fltrlocfield);
		this.fltrlocfield.sendKeys(filterentityloc);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.fltrlocresult);
		String actualfltrloc = this.fltrlocresult.getText();
		return actualfltrloc;
	}

	public String enterFilterPhone(String filterentityphone) throws InterruptedException {
		logger.info("Starting of enterFilterPhone Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.fltrphnfield);
		this.fltrphnfield.sendKeys(filterentityphone);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.fltrphnresult);
		String actualfltrphone = this.fltrphnresult.getText();
		return actualfltrphone;
	}

	public String enterFilterCurrency(String filterentitycurrency) throws InterruptedException {
		logger.info("Starting of enterFilterCurrency Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.fltrcurrencyfield);
		this.fltrcurrencyfield.sendKeys(filterentitycurrency);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.fltrcurrencyresult);
		String actualfltrcurrency = this.fltrcurrencyresult.getText();
		return actualfltrcurrency;
	}

	public String enterFilterUrl(String filterentityurl) throws InterruptedException {
		logger.info("Starting of enterFilterUrl Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.fltrurlfield);
		this.fltrurlfield.sendKeys(filterentityurl);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.fltrurlresult);
		String actualfltrurl = this.fltrurlresult.getText();
		return actualfltrurl;
	}

	public String enterFilterCountry(String filterentitycountry) throws InterruptedException {
		logger.info("Starting of enterFilterCountry Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.fltrcountryfield);
		this.fltrcountryfield.sendKeys(filterentitycountry);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.fltrcountryresult);
		String actualfltrcountry = this.fltrcountryresult.getText();
		return actualfltrcountry;
	}

	public String pickFilterCustomer(String filterentitycustomer) throws InterruptedException {
		logger.info("Starting of pickFilterCustomer Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.fltrcustomerfield);
		this.fltrcustomerfield.click();
		this.enterCustomerName.sendKeys(filterentitycustomer);
		int count = 0;
		while (count < this.fltrcustomerdropdowndata.size()) {
			String customernameslist = this.fltrcustomerdropdowndata.get(count).getText();
			if (customernameslist.equalsIgnoreCase(filterentitycustomer)) {
				waitUntilElementVisible(driver, this.fltrcustomerdropdowndata.get(count));
				this.fltrcustomerdropdowndata.get(count).click();
				break;
			}
			count++;
		}
		Thread.sleep(2000);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.fltrcustmrresult);
		String actualfltrcustomerresult = this.fltrcustmrresult.getText();
		return actualfltrcustomerresult;
	}

	public String pickFilterMultiPickCustomer(String filterentitymultipickcustomer) throws InterruptedException {
		logger.info("Starting of pickFilterMultiPickCustomer Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.fltrmultipickcustomerfield);
		this.fltrmultipickcustomerfield.click();
		this.fltrmultipickcustomerinputfield.sendKeys(filterentitymultipickcustomer);
		int count = 0;
		while (count < this.fltrmultipickcustomerdropdowndata.size()) {
			String customernameslist = this.fltrmultipickcustomerdropdowndata.get(count).getText();
			if (customernameslist.equalsIgnoreCase(filterentitymultipickcustomer)) {
				waitUntilElementVisible(driver, this.fltrmultipickcustomerdropdowndata.get(count));
				this.fltrmultipickcustomerdropdowndata.get(count).click();
				break;
			}
			count++;
		}
		Thread.sleep(2000);
		waitUntilElementVisible(driver, this.filterapply);
		this.filterapply.click();
		waitUntilElementVisible(driver, this.fltrmultipickcustomerresult);
		String actualfltrmultipickcustomerresult = this.fltrmultipickcustomerresult.getText();
		return actualfltrmultipickcustomerresult;
	}

	public String pickFilterTerritory(String filterterritory) throws InterruptedException {
		logger.info("Starting of pickFilterTerritory Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		this.filtersbtn.click();
		waitUntilElementVisible(driver, this.filtersreset);
		this.filtersreset.click();
		Thread.sleep(1000);
		scrollDown(50, fltrterritoryfield);
		waitUntilElementVisible(driver, this.fltrterritoryfield);
		this.fltrterritoryfield.click();
		int count = 0;
		while (count < this.fltrterritorydropdowndata.size()) {
			String customernameslist = this.fltrterritorydropdowndata.get(count).getText();
			if (customernameslist.equalsIgnoreCase(filterterritory)) {
				waitUntilElementVisible(driver, this.fltrterritorydropdowndata.get(count));
				this.fltrterritorydropdowndata.get(count).click();
				break;
			}
			count++;
		}
		Thread.sleep(2000);
		waitUntilElementVisible(driver, this.filterapply);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.filterapply);
		waitUntilElementVisible(driver, this.fltrterritoryresult);
		String actualfltrterritoryresult = this.fltrterritoryresult.getText();
		return actualfltrterritoryresult;
	}

	public String pickFilterYesOrNo(String filteryesorno) throws InterruptedException {
		logger.info("Starting of pickFilterYesOrNo Method");
		Thread.sleep(3000);
		waitUntilElementVisible(driver, this.filtersbtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.filtersbtn);
		waitUntilElementVisible(driver, this.filtersreset);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.filtersreset);
		Thread.sleep(3000);
		waitUntilElementVisible(driver, this.fltryesornofield);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.fltryesornofield);		
		int count = 0;
		while (count < this.fltryesornodata.size()) {
			String yesornolist = this.fltryesornodata.get(count).getText();
			if (yesornolist.equalsIgnoreCase(filteryesorno)) {
				waitUntilElementVisible(driver, this.fltryesornodata.get(count));
				this.fltryesornodata.get(count).click();
				break;
			}
			count++;
		}
		Thread.sleep(2000);
		waitUntilElementVisible(driver, this.filterapply);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.filterapply);
		waitUntilElementVisible(driver, this.fltryesornoresult);
		String actualfltryesornoresult = this.fltryesornoresult.getText();
		return actualfltryesornoresult;
	}

	public String enterFiltersCustomerType(String filterentitycustomertype) throws InterruptedException {
		logger.info("Starting of enterFiltersCustomerType Method");
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.filtersbtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.filtersbtn);
		waitUntilElementVisible(driver, this.filtersreset);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.filtersreset);
		waitUntilElementVisible(driver, this.fltrcustomertypefield);
		this.fltrcustomertypefield.sendKeys(filterentitycustomertype);
		waitUntilElementVisible(driver, this.filterapply);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.filterapply);
		waitUntilElementVisible(driver, this.fltrcustomertyperesult);
		String actualfltrcustomertype = this.fltrcustomertyperesult.getText();
		return actualfltrcustomertype;
	}
	public String pickFilterFilledBy(String filterentityfilledby) throws InterruptedException {
		logger.info("Starting of pickFilterFilledBy Method");
		waitUntilElementVisible(driver, this.filtersbtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.filtersbtn);
		waitUntilElementVisible(driver, this.filtersreset);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.filtersreset);
		Thread.sleep(1000);
		waitUntilElementVisible(driver, this.fltrfilledbyfield);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.fltrfilledbyfield);
		this.fltrfilledbyinputfield.sendKeys(filterentityfilledby);
		int count = 0;
		while (count < this.fltrfilledbydropdowndata.size()) {
			String customernameslist = this.fltrfilledbydropdowndata.get(count).getText();
			if (customernameslist.equalsIgnoreCase(filterentityfilledby)) {
				waitUntilElementVisible(driver, this.fltrfilledbydropdowndata.get(count));
				this.fltrfilledbydropdowndata.get(count).click();
				break;
			}
			count++;
		}
		Thread.sleep(2000);
		waitUntilElementVisible(driver, this.filterapply);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.filterapply);
		Thread.sleep(5000);
		waitUntilElementVisible(driver, this.fltrfilledbyresult);
		String actualfltrfilledbyresult = this.fltrfilledbyresult.getText();
		return actualfltrfilledbyresult;
	}
	
	public void filtersEntityLogout() throws InterruptedException {
		
		logger.info("Starting of filtersEntityLogout Method");
		 Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",userNameBtn );
		waitUntilElementVisible(driver, userNameBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.userNameBtn);
		waitUntilElementVisible(driver, this.logoutBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", this.logoutBtn);
		logger.info("Ending of filtersEntityLogout Method");
		}
	
	}


