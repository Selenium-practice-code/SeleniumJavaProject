package com.sumit.linkcount;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkCountOnPge {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElements(By.tagName("a")).size());

		// collect the links in footer section
		WebElement footerBlock = driver.findElement(By.id("gf-BIG"));

		List<WebElement> links = footerBlock.findElements(By.tagName("a"));

		System.out.println("Total links on the page :---> " + links.size());

		for (int i = 0; i < links.size(); i++) {

			System.out.println(links.get(i).getText());
			 

		}

	}

}
