package com.sumit.headlessbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GhostDriver {

	public static void main(String[] args) {
		 
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions option = new ChromeOptions();
		option.setHeadless(true);
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://google.com");
		
		System.out.println(driver.getTitle());

	}

}
