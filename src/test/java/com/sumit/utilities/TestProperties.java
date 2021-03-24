package com.sumit.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestProperties.class.getName());
	public static WebDriverWait wait;

	// Creating the Methods for findElements and sendKeys
	public static void click(String locatorKey) {
		
		//Create a Time Stamp for logs
		
		 Date d = new Date();
		 System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_")); 

		// Configure the logger file
		PropertyConfigurator.configure("./src/test/resources/log4j.properties");
		
		if (locatorKey.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();

		} else if (locatorKey.endsWith("_CSS")) {

			driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();

		} else if (locatorKey.endsWith("_ID")) {

			driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();
		}

		// Creating logs
		log.info("Typing in an Element :  " + locatorKey);
	}

	public static void type(String locatorKey, String value) {

		try {

			if (locatorKey.endsWith("_XPATH")) {

				driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);

			} else if (locatorKey.endsWith("_CSS")) {

				driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);

			} else if (locatorKey.endsWith("_ID")) {

				driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);
			}

			// Creating logs
			log.info("Clicking on an Element :  " + locatorKey + " Entered the value as : " + value);

		} catch (Throwable t) {

			log.info("Error while typing in an Element :  " + locatorKey);
			log.error(t.getMessage());
			t.printStackTrace();
		}
	}

	public static boolean isElementPresent(String locatorKey) {

		try {

			if (locatorKey.endsWith("_XPATH")) {

				driver.findElement(By.xpath(OR.getProperty(locatorKey)));

			} else if (locatorKey.endsWith("_CSS")) {

				driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));

			} else if (locatorKey.endsWith("_ID")) {

				driver.findElement(By.id(OR.getProperty(locatorKey)));
			}

			log.info("Finding the Element :  " + locatorKey);
			return true;

		} catch (Throwable t) {

		}

		return false;

	}

	public static void tearDown() {

		driver.quit();
	}

	public static void main(String[] args) throws IOException {

		fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
		config.load(fis);
		log.info("config properties loaded !!");

		fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
		OR.load(fis);
		log.info("OR properties loaded !!");

		// Launching the browsers
		if (config.getProperty("browser").equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome Browser launched");

		} else if (config.getProperty("browser").equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox Browser launched");

		} else if (config.getProperty("browser").equals("safari")) {

			driver = new SafariDriver();
			log.info("Safari Browser launched");

		}

		// Hit the URl
		driver.get(config.getProperty("testsiteUrl"));
		// maximize the browser window
		driver.manage().window().maximize();
		// apply implicit wait
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

		// apply explicit wait on Webdriver
		wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("explicit.wait")));

		// Entering email and password
		type("email_XPATH", "abc@hotmail.com");

		// Entering the password
		type("password_XPATH", "abcxyz");

		// Click on Login button
		click("login_XPATH");

		// close the browser
		tearDown();

	}

}
