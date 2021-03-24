package com.sumit.webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWebTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"
				+ "");
		
		//row data & row count
		 
	
		String xp_start = "//body[1]/div[3]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[";
		String xp_end = "]/td[1]";
		
		Thread.sleep(3000);
		
		int rowNum = 0;
		for (int i=2; i<=11; i=i+1) {
			
			String x = driver.findElement(By.xpath(xp_start + i + xp_end)).getText();
			
			rowNum++;
			System.out.println(x);
		}
		
		System.out.println("Row count is :  " + rowNum);
		
		String xpCol_start = "//body[1]/div[3]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[2]/td[";
		String xpCol_end = "]";
		
		Thread.sleep(3000);
		
		int colNum = 0;
		for (int i=1; i<=3; i=i+1) {
			
			String x = driver.findElement(By.xpath(xpCol_start + i + xpCol_end)).getText();
			
			colNum++;
			System.out.println(x);
		}
		
		System.out.println("Col count is :  " + colNum);
		
		//Printing entire WebTable
		
		System.out.println("-----------------------------------");
		
		String xp1_start = "//body[1]/div[3]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[";
		String xp1_mid = "]/td[";
		String xp1_end = "]";
		
		Thread.sleep(3000);
		
	 
		
		for(int rows=2; rows<=rowNum ; rows++) {
			
			
			for(int cols=1; cols<=colNum; cols++) {
				
				String y = driver.findElement(By.xpath(xp1_start + rows + xp1_mid + cols + xp1_end)).getText(); 
				
				System.out.println(y);
				
			}
			
			System.out.println();// Print all the value in the separate line
		}
		
		 

	}

}
