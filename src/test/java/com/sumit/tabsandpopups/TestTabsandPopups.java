package com.sumit.tabsandpopups;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsandPopups {

	public static WebDriver driver;

	public static void main(String[] args) {
		 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//for unique value
		Set<String> winids = driver.getWindowHandles();
		
		Iterator<String> iterator = winids.iterator();
		String first_window = iterator.next();
		
		driver.findElement(By.xpath("//button[@ng-click='mainctrl.login();']")).click();
		
		winids = driver.getWindowHandles();
		iterator = winids.iterator();
		
		String second_window = iterator.next();
		
		driver.switchTo().window(second_window);
		
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[12]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/a[2]")).click();
		//goes to new tab window
		driver.findElement(By.xpath("")).click();
		
		//Capture the title of the page (new tab open)return boolean value
		System.out.println(driver.getTitle().contains("HDFC bank"));
		
	}

}
