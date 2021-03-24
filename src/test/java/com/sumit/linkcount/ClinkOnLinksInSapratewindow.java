package com.sumit.linkcount;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClinkOnLinksInSapratewindow {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElements(By.tagName("a")).size());

		// collect the links in footer section
		WebElement footerBlock = driver.findElement(By.id("gf-BIG"));

		// Print the footer block
		System.out.println(footerBlock.findElements(By.tagName("a")).size());

		// First block in footer block
		WebElement firstBlock = footerBlock.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		// Print the first block
		List<WebElement> links = firstBlock.findElements(By.tagName("a"));

		System.out.println("Links on the first block--->  " + links.size());

		// Click on each link in the column and if the links are working
		for (int i = 1; i < links.size(); i++) {

			// System.out.println(links.get(i).getText());

			String clickOnLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			links.get(i).sendKeys(clickOnLinks);// 4 windows open

			Thread.sleep(3000);
		}//Opens all the tabs

		// Handling the window
		Set<String> windoids = driver.getWindowHandles();
		Iterator<String> iterator = windoids.iterator();

		// Checking window present or not
		while (iterator.hasNext()) { // first 0th window present

			driver.switchTo().window(iterator.next());
			System.out.println(driver.getTitle());
		}

	}

}
