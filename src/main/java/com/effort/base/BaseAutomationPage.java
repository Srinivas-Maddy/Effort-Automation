package com.effort.base;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseAutomationPage {
	protected WebDriver driver = null;

	private static final Logger logger = Logger.getLogger(BaseAutomationPage.class);
	
	public static String TEST_FILE_PATH = null;
	
	
	public BaseAutomationPage(WebDriver driver) {
		this.driver = driver;
		if (TEST_FILE_PATH == null) {
			TEST_FILE_PATH = getTestFilePath();
			logger.debug("In Constructor " + TEST_FILE_PATH);
		}
		PageFactory.initElements(driver, this);
	}

	public String getTestFilePath() {
		logger.info("Starting of selectDropdown method");
		String path = "src/test/resources";
		File file = new File(path);
		logger.info("Ending of selectDropdown method");
		return file.getAbsolutePath();
	}

	protected void selectDropdown(WebElement element, String value) {
		logger.info("Starting of selectDropdown method");
		Select conditions = new Select(element);
		conditions.selectByValue(value);
		logger.info("Ending of selectDropdown method");
	
	}

	public void scrollDown(int scroll,WebElement element) {
		logger.info("Starting of scrollDown method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0, " + scroll + ")");
		js.executeScript("arguments[0].scrollIntoView();", element);
		logger.info("Ending of scrollDown method");
	}

	public void explicitWait(WebElement webElement) {
		logger.info("Staritng of explicitWait method");

		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(webElement));

		logger.info("Ending of explicitWait method");
	}

	public void implicitWait() {
		logger.info("Starting of implicitWait Method");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		logger.info("Ending of implicitWait Method");
	}

	public void waitUntilElementVisible(WebDriver driver, WebElement xpath) {
		logger.info("Starting of waitUntilElementVisible method");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(xpath));
		logger.info("Ending of waitUntilElementVisible method");
	}

	public void waitUntilElementLoacted(By by) {
		logger.info("Starting of waitUntilElementLoacted method");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		logger.info("Ending of waitUntilElementVisible method");

	}

	public void waitUntilConfiramtionAlert(WebDriver driver)
	{
		logger.info("Starting of waitUntilConfiramtionAlert method");
		WebDriverWait wait= new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.alertIsPresent());
		logger.info("Ending of waitUntilConfiramtionAlert method");

	}

	public void clickOnWebElement(WebElement webelement) {
		logger.info("Starting of clickOnWebElement method");

		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("arguments[0].click();", webelement);

		logger.info("Ending of clickOnWebElement method");
	}

	public String getUniqueNumber(String value) {
		logger.info("Starting of getUniqueNumber method");
		logger.info("Ending of getUniqueNumber method");

		Random rand = new Random();
		// Generate random integers in range 0 to 99
		int rand_int1 = rand.nextInt(10000);

		return value + rand_int1;
	}

	public void switchToNewWindow(int windowCount) {
		logger.info("Starting of switchToNewWindow method");

		// To Open new window and check Assertions
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(windowCount));

		logger.info("Ending of switchToNewWindow method");
	}
	
	public void switchToNewOpenWin() {
		logger.info("Starting of switchToNewOpenWin method");

		
	}

	public void closeWindow() {
		logger.info("Starting of closeWindow method");

		// Recent window will be closed and returns back
		driver.close();
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));

		logger.info("Ending of closeWindow method");
	}



	public void refresh() {
		logger.info("Starting of refresh method");
		driver.navigate().refresh();
		logger.info("Ending of refresh method");
	}

	public void mouseHoverActions(WebElement webElement) {
		logger.info("Starting of mouseHoverActions method");
		Actions action = new Actions(driver);
		action.moveToElement(webElement).build().perform();
		logger.info("Ending of mouseHoverActions method");
	}

	public void mouseHoverAndClick(WebElement webElement) {
		logger.info("Starting of mouseHoverAndClick method");
		Actions action = new Actions(driver);
		action.moveToElement(webElement).click().build().perform();
		logger.info("Ending of mouseHoverAndClick method");
	}

	public void slider(WebElement webElement, int xCoordinate) {
		logger.info("Starting of slider method");
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(webElement, xCoordinate, 0).perform();
		logger.info("Ending of slider method");
	}

	//Get Current Date and time
	public String getCurrentDateTime() {

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return timeStamp;

	}


	//
	public void sleep(int sec) {
		logger.info("Starting of sleep Method");

		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			logger.error("Error occurred while using sleep method ", e);

		}

		logger.info("Ending of sleep Method");
	}


	//Creating a method for random string 
	public static String RandGeneratedString(int l){

		// a list of characters to choose from in form of a string

		String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";

		// creating a StringBuffer size of AlphaNumericStr
		StringBuilder s = new StringBuilder(l);

		int i;

		for ( i=0; i<l; i++) {

			//generating a random number using math.random()

			int ch = (int)(AlphaNumericStr.length() * Math.random());

			//adding Random character one by one at the end of s

			s.append(AlphaNumericStr.charAt(ch));

		}

		return s.toString();

	}


	public static String randomEmailGenerator() {
		//Create a array for all email domains
		String [] domains= {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "aol.com", "spoors.in"};
		//Create Random class
		Random random=new Random();

		//Get the count of the domains
		int index=random.nextInt(domains.length);

		//Create another  string to store the random domain
		String domain=domains[index];
		// length of email address between 5 and 14 characters
		int length =random.nextInt(10)+5;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = (char)(random.nextInt(26) + 'a');
			sb.append(c);
		}

		sb.append("@").append(domain);

		return sb.toString();

	}


	public static String randomMobileNumbers() {
		logger.info("Starting of randomMobileNumbers method");
		Random random = new Random();
		int countryCode = 91; // India country code
		int operatorCode = random.nextInt(5) + 70; // operator code between 70 and 74
		int number = random.nextInt(900000000) + 100000000; // random 9 digit number
		return countryCode+operatorCode+""+number;		
	}


	public static String getCurrentDate() {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(currentDate);
		return formattedDate;
	}

	public static String getCurrentDateAsNumber() {

		//Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		//Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        String todayStr = Integer.toString(todayInt);
		return todayStr;

	}
	
	
	public static String getCurrentTime() {
		
		  Date currentDate = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("kk:mm");
		  String timeIn24Hours = formatter.format(currentDate);

		  return timeIn24Hours;

	}
	
	
	/*
	 * public static String getScreenshot(String testCaseName) throws IOException {
	 * 
	 * TakesScreenshot ts= (TakesScreenshot)driver; File
	 * source=ts.getScreenshotAs(OutputType.FILE); File destination=new
	 * File(System.getProperty("user.dir")+"//ErrorScreenshots//"+testCaseName+
	 * ".png");
	 * 
	 * FileUtils.copyFile(source, destination);
	 * 
	 * return
	 * System.getProperty("user.dir")+"//ErrorScreenshots//"+testCaseName+".png";
	 * 
	 * }
	 */

}







