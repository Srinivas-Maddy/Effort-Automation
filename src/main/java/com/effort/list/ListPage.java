package com.effort.list;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.effort.base.BaseAutomationPage;

public class ListPage extends BaseAutomationPage{
	
	private static final Logger logger=Logger.getLogger(ListPage.class.getName());
	
	@FindBy(xpath="//a[contains(text(),'App Builder')]")
	private WebElement appBuilderCard;
	
	@FindBy(id="listMenu")
	private WebElement listMenu;
	
	@FindBy(xpath="//input[@value='Create List']")
    private WebElement createListSpecBtn;
	
	@FindBy(id="entityTitle")
	private WebElement listTitleField;
	
	@FindBy(xpath="//input[contains(@value,'Add Field')]")
	private WebElement addListFieldsBtn;
	
	@FindBy(id="entityFieldIdentifier1")
	private WebElement listIdentiferCheckBox;
	
	@FindBy(id="entityFieldSpecs1_fieldLabel")
	private WebElement fieldLabelNameInput;
	
	@FindBy(xpath="//ul[contains(@id,'select2-results')]/li/div")
	private List<WebElement> listFields;
	
	@FindBy(xpath="//div[contains(@id, 's2id_entityFieldSpecs')]")
	private WebElement datatypeDropdown;
	
	public ListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAppBuilder() {
		logger.info("Starting of clickOnWebBuilder Method");
		
		waitUntilElementVisible(driver, this.appBuilderCard);
		clickOnWebElement(this.appBuilderCard);
		
		logger.info("Ending of clickOnWebBuilder Method");
	}
	
	public void clickOnListMenu() {
		logger.info("Starting of clickOnListMenu Method");
		
		waitUntilElementVisible(driver, this.listMenu);
		clickOnWebElement(this.listMenu);
		
		logger.info("Ending of clickONListMenu Method");
	}
	
	public void clickOnCreateListSpec() {
		logger.info("Starting of clickOnListSpec Method");
		
		waitUntilElementVisible(driver, this.createListSpecBtn);
		clickOnWebElement(this.createListSpecBtn);
		
		logger.info("Ending of clickOnListSpec Method");
	}
	
	public void enterTitleName(String specTitle) {
		logger.info("Starting of enterTitleName Method");
		
		switchWindow();
		waitUntilElementVisible(driver, this.listTitleField);
		this.listTitleField.sendKeys(specTitle+"_"+getCurrentDate());
	
		logger.info("Ending of enterTitleName Method");
	}
	
	public void selectListFields() {
		logger.info("Starting of selectListFields Method");
		
		waitUntilElementVisible(driver, this.addListFieldsBtn);
		clickOnWebElement(this.addListFieldsBtn);	
		waitUntilElementVisible(driver, this.datatypeDropdown);
		clickOnWebElement(this.datatypeDropdown);
		int index=1;
		for (int i = 0; i < listFields.size(); i++) {
			  String fieldDatatype=this.listFields.get(i).getText();	  
			  hardWait(2);
			  clickOnWebElement(listFields.get(i));
			  waitUntilElementVisible(driver, this.listIdentiferCheckBox);
			  clickOnWebElement(this.listIdentiferCheckBox);  
			  driver.findElement(By.id("entityFieldSpecs"+index+"_fieldLabel")).sendKeys(fieldDatatype+"_Auto");
			  waitUntilElementVisible(driver, this.addListFieldsBtn);
			  clickOnWebElement(this.addListFieldsBtn);	
			  index++;
			  hardWait(2);
			  driver.findElement(By.xpath("//table[@id='formFields']/tbody/tr["+index+"]/td[4]")).click();
			  //clickOnWebElement(this.datatypeDropdown);		  
		}
			
			
		
		
			
		logger.info("Ending of selectListFields Method");
	}
	

}
