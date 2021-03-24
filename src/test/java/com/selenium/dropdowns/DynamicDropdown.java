package com.selenium.dropdowns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropdown {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Launching the browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Open Url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Handle the Dynamic DropDown 
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		// Select the city From DropDown 
		driver.findElement(By.xpath("//a[@value='BLR']")).click();

		// Apply implicit wait for loading element
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Select the Destination city from To DropDown  
		driver.findElement(By.xpath("(//a[@value='BHO'])[2]")).click();

		Thread.sleep(3000);

		// close the browser
		driver.close();

	}

}
