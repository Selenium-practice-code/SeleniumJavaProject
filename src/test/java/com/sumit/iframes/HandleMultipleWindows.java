package com.sumit.iframes;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleWindows {

	public static void main(String[] args) {

		// Launching the Chrome Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Hit the Url
		driver.get("http://the-internet.herokuapp.com/");

		// Clicking on Multiple Window link
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();

		// First window and click on Click Here button
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

		// Handling the mutiple window
		Set<String> windoids = driver.getWindowHandles();
		Iterator<String> iterator = windoids.iterator();

		String f_window = iterator.next();
		String s_window = iterator.next();

		// Switch to Second window and Grab the Text
		driver.switchTo().window(s_window);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());

		// Switch back to First window and Grab the text
		driver.switchTo().window(f_window);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());

	}

}
