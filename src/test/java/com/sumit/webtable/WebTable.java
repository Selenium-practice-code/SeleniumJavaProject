package com.sumit.webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		//  //body[1]/div[3]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[2]/td[1]
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"
				+ "");
		
		String xp_start = "/html[1]/body[1]/div[3]/div[2]/fieldset[2]/div[1]/table[1]/tbody[1]/tr[";
		String xp_mid = "]/td[";
		String xp_end = "]";
		
		Thread.sleep(3000);
		
	 
		
		 
		
		int rowNum = 9;
		for(int rows=1; rows<=rowNum; rows++) {
			 
			 
			
			int colNum = 4;
			for(int cols=1; cols<=colNum; cols++) {
				
				
				String x = driver.findElement(By.xpath(xp_start + rows + xp_mid + cols + xp_end)).getText(); 
				
				System.out.println(x);
				
			}
			
			System.out.println();// Print all the value in the separate line
		}
		 
	}

}
