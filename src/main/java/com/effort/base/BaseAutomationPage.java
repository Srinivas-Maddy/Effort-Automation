package com.effort.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
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

	static Random random = new Random();
	static Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

	public BaseAutomationPage(WebDriver driver) {

		logger.info("Starting of BaseAutomationPage method");

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

	public void scrollDown(int scroll, WebElement element) {
		logger.info("Starting of scrollDown method");


		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0, " + scroll + ")");
		js.executeScript("arguments[0].scrollIntoView(true);",element);

		//js.executeScript("arguments[0].scrollIntoView();", element);

		logger.info("Ending of scrollDown method");
	}

	public void scrollIntoView(WebElement element) {
		logger.info("Starting of scrollDown method");


		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0, " + scroll + ")");
		js.executeScript("arguments[0].scrollIntoView(true);",element);

		//js.executeScript("arguments[0].scrollIntoView();", element);

		logger.info("Ending of scrollDown method");
	}

	public void explicitWait(WebElement webElement) {
		logger.info("Staritng of explicitWait method");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(webElement));

		logger.info("Ending of explicitWait method");
	}

	@SuppressWarnings("deprecation")
	public void implicitWait() {
		logger.info("Starting of implicitWait Method");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		logger.info("Ending of implicitWait Method");
	}

	public void waitUntilElementVisible(WebDriver driver, WebElement xpath) {
		logger.info("Starting of waitUntilElementVisible method");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(xpath));

		logger.info("Ending of waitUntilElementVisible method");
	}

	public void waitUntilElementLoacted(By by) {
		logger.info("Starting of waitUntilElementLoacted method");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		logger.info("Ending of waitUntilElementVisible method");

	}

	public void waitUntilConfiramtionAlert(WebDriver driver) {
		logger.info("Starting of waitUntilConfiramtionAlert method");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.alertIsPresent());

		logger.info("Ending of waitUntilConfiramtionAlert method");
	}

	public void clickOnWebElementUsingJavascript(WebElement webelement) {
		logger.info("Starting of clickOnWebElementUsingJavascript method");


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", webelement);

		logger.info("Ending of clickOnWebElementUsingJavascript method");
	}

	public String getUniqueNumber(String value) {
		logger.info("Starting of getUniqueNumber method");

		// Generate random integers in range 0 to 99
		int rand_int1 = random.nextInt(10000);

		logger.info("Ending of getUniqueNumber method");
		return value + rand_int1;
	}

	public void switchToNewWindow(int windowCount) {
		logger.info("Starting of switchToNewWindow method");

		// To Open new window and check Assertions
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(windowCount));

		logger.info("Ending of switchToNewWindow method");
	}

	public void switchWindow() {
		logger.info("Starting of swtich window method");

		String parentWindow = driver.getWindowHandle();
		Set<String> multipleWindows = driver.getWindowHandles();
		Iterator<String> It = multipleWindows.iterator();
		while (It.hasNext()) {
			String newWind = It.next();
			if (!parentWindow.equals(newWind)) {
				driver.switchTo().window(newWind);
			}
		}
		logger.info("Ending of swtich window method");
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

		Actions action = new Actions(driver);
		action.dragAndDropBy(webElement, xCoordinate, 0).perform();

		logger.info("Ending of slider method");
	}

	// Get Current Date and time
	public String getCurrentDateTime() {
		logger.info("Starting of getCurrentDateTime method");

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

		logger.info("Ending of getCurrentDateTime method");
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

	// Creating a method for random string
	public static String RandGeneratedString(int l) {
		logger.info("Starting of RandGeneratedString method");

		// a list of characters to choose from in form of a string
		String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";

		// creating a StringBuffer size of AlphaNumericStr
		StringBuilder s = new StringBuilder(l);
		int i;
		for (i = 0; i < l; i++) {

			// generating a random number using math.random()
			int ch = (int) (AlphaNumericStr.length() * Math.random());

			// adding Random character one by one at the end of s
			s.append(AlphaNumericStr.charAt(ch));
		}
		logger.info("Ending of RandGeneratedString method");
		return s.toString();

	}

	public static String randomEmailGenerator() {
		logger.info("Starting of randomEmailGenerator method");

		// Create a array for all email domains
		String[] domains = { "gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "aol.com", "spoors.in" };
		// Create Random class

		// Get the count of the domains
		int index = random.nextInt(domains.length);

		// Create another string to store the random domain
		String domain = domains[index];
		// length of email address between 5 and 14 characters
		int length = random.nextInt(10) + 5;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = (char) (random.nextInt(26) + 'a');
			sb.append(c);
		}

		sb.append("@").append(domain);

		logger.info("Ending of randomEmailGenerator method");
		return sb.toString();

	}

	public static String randomMobileNumbers() {
		logger.info("Starting of randomMobileNumbers method");

		int countryCode = 91; // India country code
		int operatorCode = random.nextInt(5) + 70; // operator code between 70 and 74
		int number = random.nextInt(900000000) + 100000000; // random 9 digit number

		logger.info("Ending of randomMobileNumbers method");
		return countryCode + operatorCode + "" + number;
	}

	public static String getCurrentDate() {
		logger.info("Starting of getCurrentDate method");

		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(currentDate);

		logger.info("Ending of getCurrentDate method");
		return formattedDate;
	}

	public static String getCurrentDateAsNumber() {
		logger.info("Starting of getCurrentDateAsNumber method");

		// Create a Calendar Object

		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		String todayStr = Integer.toString(todayInt);

		logger.info("Ending of getCurrentDateAsNumber method");
		return todayStr;

	}

	public static String getTomorrowDateAsNumber(int number) {
		logger.info("Starting of getTomorrowDateAsNumber method");

		// Create a Calendar Object
		// Get Current Day as a number
		calendar.add(Calendar.DAY_OF_MONTH, number);
		// Get the date as simple formate
		SimpleDateFormat dateFormat = new SimpleDateFormat("d");
		String tomorrowDate = dateFormat.format(calendar.getTime());

		logger.info("Starting of getTomorrowDateAsNumber method");
		return tomorrowDate;
	}

	public static String getCurrentTimeAsFiveMinInterval() {
		logger.info("Starting of getCurrentTimeAsFiveMinInterval method");

		// Get the current time
		LocalTime time = LocalTime.now();

		// Round the current time to nearest 5 mins interval
		int minute = time.getMinute();
		int reminder = minute % 5;
		int adjustedMinute = minute - reminder + (reminder < 3 ? 0 : 5);

		// Create a new LocalTime with the adjusted minute
		LocalTime adjustedTime = time.withMinute(adjustedMinute);

		// Define the desired time formate(MM:hh)
		DateTimeFormatter formate = DateTimeFormatter.ofPattern("HH:mm");

		// Format the current time using the defined format
		String formattedTime = adjustedTime.format(formate);

		logger.info("Ending of getCurrentTimeAsFiveMinInterval method");
		return formattedTime;
	}

	public static String getCurrentTime() {
		logger.info("Starting of getCurrentTime method");

		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("kk:mm");
		String timeIn24Hours = formatter.format(currentDate);

		logger.info("Ending of getCurrentTime method");
		return timeIn24Hours;

	}

	public void hardWait(int seconds) {
		logger.info("Starting of hardWait method");
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		logger.info("Ending of hardWait method");
	}

	public void clickOnWebElement(WebElement webElement) {
		logger.info("Starting of clickOnWebElement method");

		Actions action = new Actions(driver);
		try {
			webElement.click();
		} catch (Exception e) {
			try {
				action.moveToElement(webElement).click().build().perform();
			}catch(Exception e2) {
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", webElement);
			}
		} 

		logger.info("Ending of clickOnWebElement method");

	}
}
