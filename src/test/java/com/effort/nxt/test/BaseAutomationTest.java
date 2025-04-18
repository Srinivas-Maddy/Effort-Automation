package com.effort.nxt.test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.effort.base.BaseAutomationPage;
import com.effort.base.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseAutomationTest {

	protected static String browserDriverPath = null;
	protected static Map<String, String> chromeDriverMap = new HashMap<String, String>();
	private static final Logger logger = Logger.getLogger(BaseAutomationTest.class);
	protected WebDriver driver = null;
	protected String loginURL = null;
	protected LoginPage loginPage = null;
	
	protected static Properties expectedAssertionsProp = null;
	protected static Properties testDataProp = null;
	protected static Properties empDataProp=null;
	protected static Properties formDataProp=null;
	protected static Properties custmrDataProp=null;
	
	

	private static Map<WEB_DRIVER, WebDriver> webDriverPool = new Hashtable<WEB_DRIVER, WebDriver>();

	public enum WEB_DRIVER {

		LOGIN_DRIVER, FORGOT_PASSWORD_DRIVER, BUY_INVESTMENT_DRIVER;
	}

	@BeforeSuite (alwaysRun = true)
	public void initTestData() {
		if (testDataProp == null) {
			FileReader testDataReader = null;
			FileReader assertionsReader = null;
			FileReader empDataReader=null;
			FileReader custmrDataReader=null;
			FileReader formDataReader=null;

			try {
				
				testDataReader = new FileReader("src/main/resources/testdata.properties");
				//testDataReader = new FileReader("src/main/resources/TestEnvData.properties");
				empDataReader= new FileReader("src/main/resources/EmployeeDetails.properties");
				custmrDataReader = new FileReader("src/main/resources/CustomerDetails.properties") ;
				assertionsReader = new FileReader("src/main/resources/expectedassertion.properties");
				formDataReader = new FileReader("src/main/resources/FormData.properties");
				
				

				testDataProp = new Properties();
				testDataProp.load(testDataReader);

				expectedAssertionsProp = new Properties();
				expectedAssertionsProp.load(assertionsReader);
				
				empDataProp = new Properties();
				empDataProp.load(empDataReader);
				
				custmrDataProp = new Properties();
				custmrDataProp.load(custmrDataReader);
				
				formDataProp = new Properties();
				formDataProp.load(formDataReader);
				
				
				

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {

					testDataReader.close();
					assertionsReader.close();
					empDataProp.clone();
					custmrDataProp.clone();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected synchronized void quitDriver(WEB_DRIVER webDriver) {
		logger.info("Starting of method quitDriver in BaseAutomationTest ");

		WebDriver driver = webDriverPool.get(webDriver);
		try {
			if (driver != null) {
				driver.quit();
				driver = null;
				webDriverPool.remove(webDriver);
				logger.debug(webDriver + " Web driver quit successfully in BaseAutomationTest ");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			driver = null;
		}
		logger.info("Ending of method quitDriver in BaseAutomationTest");
	}

	@AfterSuite(alwaysRun = true)
	protected synchronized void quitAllDrivers() {
		logger.info("Starting of method quitAllDrivers in BaseAutomationTest ");

		WebDriver driver = null;

		synchronized (webDriverPool) {
			if (!webDriverPool.isEmpty()) {
				for (WEB_DRIVER driverKey : webDriverPool.keySet()) {
					logger.debug("Quitting driver key: " + driverKey);
					synchronized (webDriverPool) {
						driver = webDriverPool.get(driverKey);
						try {

							if (driver != null) {
								Thread.sleep(3000);
								driver.quit();
								driver = null;
								webDriverPool.remove(driverKey);
								Thread.sleep(3000);
								logger.debug("Driver quit successfully in BaseAutomationTest ");
							}
						} catch (Exception ex) {
							logger.error(ex.getMessage());
							driver = null;
						}
					}

				}

			}
		}
		logger.info("Ending of method quitAllDrivers in BaseAutomationTest");
	}

	/**
	 * This method is used for get driver
	 * 
	 * @param webDriver
	 * @return
	 */

	protected synchronized WebDriver getWebDriver(String browser, WEB_DRIVER webDriver) {
		logger.info("Starting of method getWebDriver");

		WebDriver driver = webDriverPool.get(webDriver);

		String osPath = System.getProperty("os.name");

		// Use existing driver
		if (driver != null) {
			logger.debug("Using existing web driver " + webDriver);
			return driver;
		}

		if (osPath.contains("Linux")) {
			browserDriverPath = "/usr/bin/chromedriver";
			logger.debug("######### In linux condition Using existing web driver Linux ###### ");
			if (browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				options.addArguments("--no-sandbox");
				driver = new FirefoxDriver(options);
			} else {
				logger.debug("######### In Else Chrome browser condition Using existing web driver Linux ###### ");
				/*
				 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
				 * ChromeOptions(); options.setHeadless(true);
				 * options.addArguments("--no-sandbox"); driver = new ChromeDriver(options);
				 */
				System.setProperty("webdriver.chrome.driver", browserDriverPath);
				ChromeOptions options = new ChromeOptions();
				options.setHeadless(true);
				options.addArguments("--no-sandbox");
				driver = new ChromeDriver(options);

				logger.debug("######### Driver is here  ###### " + driver);

			}
		} else if (osPath.contains("Mac OS X")) {
			browserDriverPath = "/usr/bin/safaridriver";

			if (browserDriverPath.contains("safaridriver")) {
				System.setProperty("webdriver.safari.driver", browserDriverPath);
				driver = new SafariDriver();

				logger.debug("Safari driver path " + browserDriverPath);
			}
		} else {

			if (browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("Chromium")) {
				WebDriverManager.chromiumdriver().setup();
				driver = new EdgeDriver();

			} else if (browser.equalsIgnoreCase("IEDriverServer")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			}
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		logger.info("***************** Driver Successfully Created **************** " + driver.getTitle());

		logger.info("End of method getWebDriver");

		webDriverPool.put(webDriver, driver);
		      
		return driver;
	}

	/**
	 * This method is used for returning chrome browser version.
	 * 
	 * @param driverInfo
	 * @return
	 */

	public String getChromeDriverVersion(String driverInfo) {
		logger.info("Starting of getChromeDriverVersion method ");

		String tVersion = driverInfo.split("is")[2];
		tVersion = tVersion.split("with")[0];
		tVersion = (tVersion.split("\\.")[0]).trim();
		logger.debug("Chrome browser Version : " + tVersion);

		logger.info("Ending of getChromeDriverVersion method ");

		return tVersion;
	}

//	protected void logIn(String siteURL, String userName, String password, WebDriver driver) throws Exception {
//		logger.debug("Login URL " + siteURL);
//
//		driver.get(siteURL);
//
//		this.loginPage.logIn(userName, password);
//	}

	public void goToSite(String siteURL, WebDriver driver) throws Exception {

		driver.get(siteURL);

	}
	

}
