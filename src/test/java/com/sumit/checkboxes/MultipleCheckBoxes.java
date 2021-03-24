package com.sumit.checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		
		driver.findElement(By.xpath("//input[@id='check1']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[@id='easycont']/div[1]/div[2]/div[2]/div[2]/div[3]/label[1]/input[1]")).click();

	}

}
