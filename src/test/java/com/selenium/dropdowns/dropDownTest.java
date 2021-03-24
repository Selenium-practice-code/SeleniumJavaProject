package com.selenium.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDownTest {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		 
		//Launching the browser 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Open Url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Dropdown with Select tag		
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));	
		
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Thread.sleep(2000);
		
		
		//Select Adult from dropdown
		for(int i=1; i<5; i++) {
			
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		 
		Thread.sleep(3000);
		
		//Selecting Child from dropdown
		for(int i=0; i<3; i++) {
			
			driver.findElement(By.id("hrefIncChd")).click();
		}
		
		Thread.sleep(3000);
		
		//selecting infanct from dropdown  
		for(int i=0; i<3; i++) {
			
			driver.findElement(By.id("hrefIncInf")).click();
		}
		
		//close the dropdown
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		 Thread.sleep(3000);
		 
		//for validation
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
	
		Select dropdown = new Select(staticDropdown);
		
		//dropdown based on index
		dropdown.selectByIndex(3);
		//print on console
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//Dropdown based on visible text
		dropdown.selectByVisibleText("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//Dropdown based by value
		dropdown.selectByValue("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		Thread.sleep(2000);
		
		//quit the driver
		driver.quit();

	}

}
