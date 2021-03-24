package com.sumit.assingments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxAssignment {
	
	//Declare a global variable for Webdriver
	public static WebDriver driver;

	public static void main(String[] args) {
		
		//Launching the browser 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//hit the Url
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Select the checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		
		//Verify if it is successfully checked 
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//Uncheck the checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		
		//verify if it is uncheck it
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//Count the no of checkboxes
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		//quit the browser
		driver.quit();
		
	 
		
		 

	}

}
