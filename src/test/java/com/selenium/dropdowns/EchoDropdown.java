package com.selenium.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EchoDropdown {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		//launching the browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Hit the url
		driver.get("http://www.echoecho.com/htmlforms11.htm");
		
		//Click on dropdown
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@name='dropdownmenu']"));
		
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("Cheese");
		
		System.out.println(dropdown.getFirstSelectedOption().getText());

	}

}
