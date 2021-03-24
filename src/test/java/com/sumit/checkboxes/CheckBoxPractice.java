package com.sumit.checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxPractice {

	public static void main(String[] args) {
		 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		
		Assert.assertFalse(driver.findElement(By.id("isAgeSelected")).isSelected());
		
		driver.findElement(By.id("isAgeSelected")).click();
		System.out.println(driver.findElement(By.id("isAgeSelected")).isSelected());
		
		
		Assert.assertTrue(true, "Successfully click on CheckBox");
		
		
		
		
		
		

	}

}
