package com.sumit.mousehover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverMovement {

	public static void main(String[] args) throws InterruptedException {
		 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.xpath("//button[@id='mousehover']"));
		WebElement reload = driver.findElement(By.xpath("//a[contains(text(),'Reload')]"));
	 
		
		Actions act  = new Actions(driver);
		act.moveToElement(ele).perform();
		reload.click();

		Thread.sleep(3000);
		 
		 
		 
	}

}
