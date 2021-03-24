package com.sumit.checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxExample {
	
	public static WebDriver driver;
	

	public static void main(String[] args) {
		
		        //Launching the browser
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
				//get the url
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				
				//assertion
				Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
				
				//handle checkbox
				driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
				System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
				
				//Count the no of checkboxees
				System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
				
				Assert.assertTrue(true, "Test is passed");
		

	}

}
