package com.sumit.mousehover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MousehoverTest {
	
	
WebDriver driver;
	
	public void launchBrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
	}
	
	public void mouseMove() throws InterruptedException {
		
		WebElement ele = driver.findElement(By.xpath("//span[@class='icp-nav-flag icp-nav-flag-in']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(5000);
	}
	
	public void closeBrowser() {
		
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		
		MousehoverTest mt = new MousehoverTest();
		mt.launchBrowser();
		mt.mouseMove();
	    mt.closeBrowser();
		
	}

}
