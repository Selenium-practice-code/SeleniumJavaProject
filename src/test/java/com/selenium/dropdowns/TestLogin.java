package com.selenium.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {
	
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		 
		if(browser.equals("chrome")) {
			
			//Launching chrome   browser
			WebDriverManager.chromedriver().setup();
			
			  driver = new  ChromeDriver();			
		
		}else if(browser.equals("firefox")) {
			
			//Launching firefox browser
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
		
		}else if(browser.equals("safari")) {
			
			
			//Launching Safari browser
			driver = new SafariDriver();
		}
		
		
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//get the title of the page
		String title = driver.getTitle();
		
		//print the title of the page
		System.out.println(title);
		
		//get the length of the title
		System.out.println(title.length());
		
		
		//Dropdown with select tag
		
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		
		Select dropdown = new Select(staticDropdown);
		//Select base on index
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//Select base on visibletext
		dropdown.selectByVisibleText("INR");
		
		//Select base on value
		dropdown.selectByValue("AED");
		
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		
		//quit the webdriver
		driver.quit();

	}

} 
