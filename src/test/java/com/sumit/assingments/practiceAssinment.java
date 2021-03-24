package com.sumit.assingments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practiceAssinment {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		//Launching the browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Hit the Url
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		
		//Enter the email 
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@gmail.com");
		
		//Enter the Submit button
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		
		 
	}

}
