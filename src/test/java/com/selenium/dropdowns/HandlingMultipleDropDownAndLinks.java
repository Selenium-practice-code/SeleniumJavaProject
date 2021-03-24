package com.selenium.dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleDropDownAndLinks {

	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.wikipedia.org/");

		Select select = new Select(driver.findElement(By.xpath("//select[@id='searchLanguage']")));

		System.out.println("--------------------Printing all dropdown values----------------");

		// another method
		List<WebElement> options = select.getOptions();// Return the list of all Option tag value

		System.out.println(options.size());

		for (int i = 0; i < options.size(); i++) {

			System.out.println(options.get(i).getAttribute("lang"));

		}

		System.out.println("--------------------Printing all links-----------------");

		// finding the List of the Element using tag name

		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]"));

		// finding the Webelement whith in the block only
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		System.out.println("Total links on the page :---> " + links.size());

		for (int i = 0; i < links.size(); i++) {

			System.out.println(links.get(i).getText());

		}

//		// finding the List of the Element using tag name
//
//		List<WebElement> options = driver.findElements(By.tagName("option"));
//
//		System.out.println(options.size());
//
//		for (int i = 0; i < options.size(); i++) {
//
//			System.out.println(options.get(i).getText());
//
//		}
		
		
//		// finding the List of the Element using tag name
		
//		WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchLanguage']"));
//
//		List<WebElement> options = dropdown.findElements(By.tagName("option"));
//
//		System.out.println(options.size());
//
//		for (int i = 0; i < options.size(); i++) {
//
//			System.out.println(options.get(i).getText());
//
//		}

		driver.quit();

	}

}
