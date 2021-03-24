package com.sumit.radiobutton;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonExample {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		
	List<WebElement> radio_button = driver.findElements(By.name("optradio"));
	
	System.out.println(radio_button.get(0).getAttribute("value"));
	 
	System.out.println(radio_button.get(0).getAttribute("checked"));
	
	//Check the radio button if it is unchecked
	radio_button.get(0).click();
	 
	System.out.println(radio_button.get(0).getAttribute("checked"));
	
	driver.quit();

	}
	
	

}
