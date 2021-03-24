package com.sumit.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {

	public static void main(String[] args) {
		 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		
		System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame(0);
		
		driver.switchTo().frame("frame-middle");
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]")).getText());
		
		
		
		
		
		

	}

}
